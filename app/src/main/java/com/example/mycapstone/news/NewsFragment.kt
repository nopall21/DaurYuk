package com.example.mycapstone.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycapstone.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsList = listOf(
            News("Keren! Kapal Sandal Karya Petugas UPS Siap Ramaikan HUT Jakarta", "Kamis, 20 Juni 2024", "https://akcdn.detik.net.id/community/media/visual/2024/06/20/kapal-sandal-karya-petugas-ups-siap-ramaikan-hut-jakarta_169.jpeg?w=700&q=90", "https://news.detik.com/foto-news/d-7399536/keren-kapal-sandal-karya-petugas-ups-siap-ramaikan-hut-jakarta"),
            News("Komitmen Lestarikan Lingkungan, PLN Sediakan Mesin Daur Ulang Sampah di Lingkungan Kantor", "Kamis, 27 Juni 2024", "https://asset.kompas.com/crops/4oect3Ve6B8SZPYKl78zshJfJjk=/0x1:1000x668/1200x800/data/photo/2024/06/27/667ce9c3a0eb7.jpeg", "https://money.kompas.com/read/2024/06/27/114421626/komitmen-lestarikan-lingkungan-pln-sediakan-mesin-daur-ulang-sampah-di"),
            News("Palangka Raya Resmikan Pusat Daur Ulang Sampah", "Rabu, 30 Mei 2024", "https://asset.kompas.com/crops/stzeoJvkxo9yl-yg_1IshBfLg6k=/0x0:893x595/750x500/data/photo/2024/05/30/6657e471179f9.png", "https://lestari.kompas.com/read/2024/05/30/120000186/palangka-raya-resmikan-pusat-daur-ulang-sampah-"),
            News("Kurangi Sampah Plastik dan Dukung Ekonomi Sirkular dengan Daur Ulang Kemasan Botol Bekas Pakai", "Jumat, 11 Juli 2024", "https://cdn1-production-images-kly.akamaized.net/RTkbWWurVQIByLNAy2yyghPGB-8=/640x360/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/4888149/original/020798200_1720601944-Foto_3_Coca-Cola_Hadirkan_Booth__Dari_Botol_Jadi_Botol__di_Jakarta_Fair_Kemayoran_2024.JPG", "https://www.liputan6.com/health/read/5639167/kurangi-sampah-plastik-dan-dukung-ekonomi-sirkular-dengan-daur-ulang-kemasan-botol-bekas-pakai"),
            News("Menyulap Limbah jadi Kerajinan Bernilai Ekonomis", "Selasa, 20 Juni 2024", "https://cdn1-production-images-kly.akamaized.net/pzROtKtoJQbtFbMGmhMeeHnaeEU=/640x360/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/4868797/original/024745100_1718857611-IMG_0825.JPG", "https://www.liputan6.com/jatim/read/5623973/menyulap-limbah-jadi-kerajinan-bernilai-ekonomis")

        )

        binding.rvNews.layoutManager = LinearLayoutManager(context)
        binding.rvNews.adapter = NewsAdapter(newsList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
