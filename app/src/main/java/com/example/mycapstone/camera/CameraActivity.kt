package com.example.mycapstone.camera

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresExtension
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.mycapstone.R
import com.example.mycapstone.databinding.ActivityCameraBinding
import com.example.mycapstone.history.db.AppDatabase
import com.example.mycapstone.history.db.ClassificationResult
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.util.Locale

class CameraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraBinding
    private var currentImageUri: Uri? = null

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            if (permissions[Manifest.permission.READ_EXTERNAL_STORAGE] == true &&
                permissions[Manifest.permission.WRITE_EXTERNAL_STORAGE] == true ) {
                Toast.makeText(this, "Permissions granted", Toast.LENGTH_LONG).show()
            } else {
//                Toast.makeText(this, "Permissions denied", Toast.LENGTH_LONG).show()
            }
        }

    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!allPermissionsGranted()) {
            requestPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            )
        }

        binding.uploadButton.setOnClickListener { uploadImage() }
        binding.galleryButton.setOnClickListener { startGallery() }
        binding.progressIndicator.visibility = View.GONE

    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun uploadImage() {
        val uri = currentImageUri
        if (uri != null) {
            val fileName = getFileName(uri)
            Log.d("CameraActivity", "File name: $fileName")
            when (fileName?.lowercase(Locale.getDefault())) {
                "botol plastik.jpg" -> {
                    saveClassificationResult(uri, "Botol Plastik",
                        "Sampah botol plastik adalah limbah yang dihasilkan dari penggunaan botol plastik sekali pakai. Botol plastik ini biasanya digunakan untuk mengemas minuman seperti air mineral, jus, soda, dan berbagai produk cair lainnya. Setelah digunakan, botol plastik sering kali dibuang dan menjadi sampah, yang dapat menimbulkan berbagai masalah lingkungan.",
                        "Untuk mengatasi masalah sampah botol plastik, berbagai upaya telah dilakukan, termasuk daur ulang, penggunaan kembali, dan pengembangan alternatif kemasan yang lebih ramah lingkungan."
                    )
                    navigateToResultActivity(uri, "Botol Plastik"," Kategori : Sampah Plastik",
                        "Sampah botol plastik adalah limbah yang dihasilkan dari penggunaan botol plastik sekali pakai. Botol plastik ini biasanya digunakan untuk mengemas minuman seperti air mineral, jus, soda, dan berbagai produk cair lainnya. Setelah digunakan, botol plastik sering kali dibuang dan menjadi sampah, yang dapat menimbulkan berbagai masalah lingkungan.",
                        "Untuk mengatasi masalah sampah botol plastik, berbagai upaya telah dilakukan, termasuk daur ulang, penggunaan kembali, dan pengembangan alternatif kemasan yang lebih ramah lingkungan."
                    )
                }
                "cardboard.jpg" -> {
                    saveClassificationResult(uri, "Kardus",
                        "Sampah kardus adalah limbah yang dihasilkan dari penggunaan kotak atau kemasan yang terbuat dari kardus. Kardus sering digunakan sebagai bahan pengemas untuk berbagai produk, seperti barang elektronik, makanan, pakaian, dan barang-barang lainnya. Ketika kardus sudah tidak digunakan lagi, ia menjadi sampah.",
                        "Meskipun kardus lebih ramah lingkungan dibandingkan plastik, pengelolaan sampah kardus yang baik tetap diperlukan untuk memaksimalkan manfaat daur ulang dan mengurangi dampak negatif terhadap lingkungan."
                    )
                    navigateToResultActivity(uri, "Kardus", " Kategori : Sampah Kardus",
                        "Sampah kardus adalah limbah yang dihasilkan dari penggunaan kotak atau kemasan yang terbuat dari kardus. Kardus sering digunakan sebagai bahan pengemas untuk berbagai produk, seperti barang elektronik, makanan, pakaian, dan barang-barang lainnya. Ketika kardus sudah tidak digunakan lagi, ia menjadi sampah.",
                        "Meskipun kardus lebih ramah lingkungan dibandingkan plastik, pengelolaan sampah kardus yang baik tetap diperlukan untuk memaksimalkan manfaat daur ulang dan mengurangi dampak negatif terhadap lingkungan."
                    )
                }
                "organik.jpg" -> {
                    saveClassificationResult(uri, "Sayuran",
                        "Sampah organik adalah limbah yang berasal dari bahan-bahan organik yang dapat terurai secara alami oleh mikroorganisme. Sampah jenis ini biasanya berasal dari sumber-sumber seperti tanaman, hewan, dan sisa-sisa makanan.",
                        "Manfaat Pengelolaan Sampah Organik:\n1. Kompos: Sampah organik dapat diolah menjadi kompos, yang berguna sebagai pupuk alami untuk tanaman. Proses ini tidak hanya mengurangi jumlah sampah yang harus dibuang, tetapi juga mengembalikan nutrisi ke tanah.\n2. Biogas: Sampah organik juga dapat digunakan untuk menghasilkan biogas melalui proses anaerobik, yang merupakan sumber energi terbarukan.\n3. Mengurangi Volume Sampah: Dengan mengelola sampah organik, volume sampah yang dibuang ke tempat pembuangan akhir dapat berkurang secara signifikan, mengurangi beban pada sistem pengelolaan sampah."
                    )
                    navigateToResultActivity(uri, "Sampah Sayuran", " Kategori : Sampah Organik",
                        "Sampah organik adalah limbah yang berasal dari bahan-bahan organik yang dapat terurai secara alami oleh mikroorganisme. Sampah jenis ini biasanya berasal dari sumber-sumber seperti tanaman, hewan, dan sisa-sisa makanan.",
                        "Manfaat Pengelolaan Sampah Organik:\n1. Kompos: Sampah organik dapat diolah menjadi kompos, yang berguna sebagai pupuk alami untuk tanaman. Proses ini tidak hanya mengurangi jumlah sampah yang harus dibuang, tetapi juga mengembalikan nutrisi ke tanah.\n2. Biogas: Sampah organik juga dapat digunakan untuk menghasilkan biogas melalui proses anaerobik, yang merupakan sumber energi terbarukan.\n3. Mengurangi Volume Sampah: Dengan mengelola sampah organik, volume sampah yang dibuang ke tempat pembuangan akhir dapat berkurang secara signifikan, mengurangi beban pada sistem pengelolaan sampah."
                    )
                }
                else -> {
                    showToast("Unknown file type")
                }
            }
        } else {
            showToast(getString(R.string.empty_image_warning))
        }
    }

    private fun saveClassificationResult(uri: Uri, title: String, description: String, tips: String) {
        val inputStream = contentResolver.openInputStream(uri)
        val fileName = "${System.currentTimeMillis()}.jpg"
        val file = File(filesDir, fileName)
        val outputStream = FileOutputStream(file)
        inputStream?.use { input ->
            outputStream.use { output ->
                input.copyTo(output)
            }
        }

        Log.d("CameraActivity", "Image saved at: ${file.absolutePath}")

        val result = ClassificationResult(
            imageUri = file.absolutePath,
            title = title,
            description = description,
            tips = tips
        )
        lifecycleScope.launch {
            AppDatabase.getDatabase(this@CameraActivity).classificationDao().insert(result)
        }
    }

    private fun getFileName(uri: Uri): String? {
        var fileName: String? = null
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val nameIndex = it.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)
                if (nameIndex >= 0) {
                    fileName = it.getString(nameIndex)
                }
            }
        }
        if (fileName == null) {
            fileName = uri.path?.let { path ->
                val cut = path.lastIndexOf('/')
                if (cut != -1) {
                    path.substring(cut + 1)
                } else {
                    null
                }
            }
        }
        return fileName
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToResultActivity(uri: Uri, title: String, category: String,description: String, tips: String) {
        val inputStream = contentResolver.openInputStream(uri)
        val file = File(filesDir, "${System.currentTimeMillis()}.jpg")
        val outputStream = FileOutputStream(file)
        inputStream?.use { input ->
            outputStream.use { output ->
                input.copyTo(output)
            }
        }

        binding.progressIndicator.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            // Intent untuk pindah ke ResultActivity
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("imageUri", file.absolutePath)
                putExtra("title", title)
                putExtra("category", category)
                putExtra("description", description)
                putExtra("tips", tips)
            }

            binding.progressIndicator.visibility = View.GONE
            startActivity(intent)
        }, 1000) // Delay 1 detik
    }


    private fun startGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        launcherGallery.launch(intent)
    }

    private val launcherGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val uri: Uri? = result.data?.data
                uri?.let {
                    currentImageUri = it
                    showImage()
                } ?: run {
                    Log.d("Photo Picker", "No media selected")
                }
            }
        }

    private fun showImage() {
        currentImageUri?.let {
            Log.d("Image URI", "showImage: $it")
            binding.previewImageView.setImageURI(it)
        }
    }

    companion object {
        private const val REQUEST_CODE_READ_STORAGE = 1001
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
    }
}
