package com.example.gofit_10762

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.romainpiel.shimmer.Shimmer
import com.romainpiel.shimmer.ShimmerTextView

class BerandaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        val dashboard = layoutInflater.inflate(R.layout.activity_beranda, null)
        val btnGuest: Button = findViewById(R.id.btnGuest)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val tv: TextView = findViewById(R.id.textView)


        btnGuest.setOnClickListener {
            val moveGuest = Intent(this, BerandaUmumActivity::class.java)
            startActivity(moveGuest)
        }

        btnLogin.setOnClickListener {
            val moveLogin = Intent(this, MainActivity::class.java)
            startActivity(moveLogin)
        }
    }
}