package Asus.LatihanUTSPart1

import Kegiatan
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val kegiatan = intent.getParcelableExtra<Kegiatan>(dataKegiatan, Kegiatan::class.java)

        findViewById<ImageView>(R.id.gambar).setImageResource(resources.getIdentifier(kegiatan?.gambar, "drawable", packageName))
        findViewById<TextView>(R.id.title).text = kegiatan?.title
        findViewById<TextView>(R.id.subtitle).text = kegiatan?.subtitle
        findViewById<TextView>(R.id.tanggal).text = "📅 ${kegiatan?.tanggal}"
        findViewById<TextView>(R.id.jam).text = "⏱️ ${kegiatan?.jam}"
        findViewById<TextView>(R.id.lokasi).text = "📍 ${kegiatan?.lokasi}"
        findViewById<TextView>(R.id.deskripsi).text = kegiatan?.deskripsi

        findViewById<TextView>(R.id.back).setOnClickListener {
            finish()
        }
    }

    companion object{
        val dataKegiatan = "dataKegiatan"
    }
}