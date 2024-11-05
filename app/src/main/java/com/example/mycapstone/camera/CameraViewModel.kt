//package com.example.mycapstone.camera
//
//import android.net.Uri
//import android.os.Build
//import android.view.View
//import androidx.annotation.RequiresExtension
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.lifecycleScope
//import com.example.mycapstone.R
//import com.example.mycapstone.data.remote.retrofit.ApiConfig
//import kotlinx.coroutines.launch
//import okhttp3.MediaType.Companion.toMediaType
//import okhttp3.MultipartBody
//import okhttp3.RequestBody.Companion.asRequestBody
//import java.io.File
//
//class CameraViewModel : ViewModel() {
//    private var currentImageUri: Uri? = null
//
//    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
//    private fun uploadImage() {
//        currentImageUri?.let { uri ->
//            val imageFile = File(uri.path ?: "")
//            val reducedFile = imageFile.reduceFileImage()
//            showLoading(true)
//
//            val requestImageFile = reducedFile.asRequestBody("image/jpeg".toMediaType())
//            val multipartBody = MultipartBody.Part.createFormData(
//                "photo",
//                reducedFile.name,
//                requestImageFile
//            )
//            val request = CameraRequest
//            val token =
//            val response = ApiConfig.apiService.uploadImage(token, multipartBody)
//
//            lifecycleScope.launch {
//                try {
//                    if (response.isSuccessful) {
//                        val detectResponse = response.body()
//                        detectResponse?.let {
//                            with(it) {
//                                binding.resultTextView.text = if (statusCode == 200) {
//                                    String.format("Ini adalah jenis sampah : %s", detected_trash)
//                                } else {
//                                    showToast("Error: ${status}")
//                                    "Sampah tidak terdeteksi"
//                                }
//                            }
//                        }
//                    } else {
//                        showToast("Upload failed with code: ${response.code()}")
//                    }
//                } catch (e: Exception) {
//                    showToast("Error occurred: ${e.message}")
//                } finally {
//                    showLoading(false)
//                }
//            }
//        } ?: showToast(getString(R.string.empty_image_warning))
//    }
//
//    private fun showLoading(isLoading: Boolean) {
//        binding.progressIndicator.visibility = if (isLoading) View.VISIBLE else View.GONE
//    }
//}