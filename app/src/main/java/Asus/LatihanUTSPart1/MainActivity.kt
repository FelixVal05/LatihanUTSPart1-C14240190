package Asus.LatihanUTSPart1

import Asus.LatihanUTSPart1.DetailActivity.Companion.dataKegiatan
import Kegiatan
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val seminar = Kegiatan(
            "seminar",
            "Seminar Teknologi 2026",
            "Membangun Aplikasi Android Modern",
            "20 Oktober 2026",
            "09.00 - 12.00 WIB",
            "Auditorium Kampus XYZ",
            "Seminar ini menghadirkan pembicara dari industri teknologi untuk membahas perkembangan terbaru dalam pengembangan aplikasi Android, mulai dari arsitektur modern, UI/UX, hingga best practice dalam pembuatan aplikasi yang berkualitas."
        )

        val workshop = Kegiatan(
            "workshop",
            "Workshop UI/UX Design",
            "Dari Ide Menjadi Desain yang Menarik",
            "25 Oktober 2026",
            "13.00 - 16.00 WIB",
            "Lab Komputer Lt. 3",
            "Workshop UI/UX Design membahas dasar perancangan antarmuka aplikasi yang mudah digunakan. Peserta akan belajar membuat konsep desain, memilih warna, menyusun layout, dan memahami pengalaman pengguna."
        )

        val event = Kegiatan(
            "event",
            "Campus Fair 2026",
            "Temukan Peluang untuk Masa Depanmu",
            "28 November 2026",
            "08.00 - 17.00 WIB",
            "Lapangan Kampus XYZ",
            "Campus Day 2026 merupakan kegiatan kampus yang berisi berbagai aktivitas mahasiswa, informasi organisasi, pameran komunitas, serta kesempatan untuk mengenal kegiatan dan lingkungan kampus."
        )

        val _btnSeminar = findViewById<LinearLayout>(R.id.seminar)
        val _btnWorkshop = findViewById<LinearLayout>(R.id.workshop)
        val _btnEvent = findViewById<LinearLayout>(R.id.event)

        _btnSeminar.setOnClickListener {
            bukaDetail(seminar)
        }

        _btnWorkshop.setOnClickListener {
            bukaDetail(workshop)
        }

        _btnEvent.setOnClickListener {
            bukaDetail(event)
        }
    }

    private fun bukaDetail(kegiatan : Kegiatan){
        val intentWithData = Intent(this@MainActivity, DetailActivity::class.java).apply {
            putExtra(dataKegiatan, kegiatan)
        }
        startActivity(intentWithData)
    }
}
