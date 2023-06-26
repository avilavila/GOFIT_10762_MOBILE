package com.example.gofit_10762.Member

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gofit_10762.R
import com.example.gofit_10762.databinding.ActivityHistoriGymBinding

class HistoriGymActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHistoriGymBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoriGymBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val idUser = intent.getStringExtra("idUser")
        val nama = intent.getStringExtra("nama")
        val jabatan = intent.getStringExtra("jabatan")
        val username = intent.getStringExtra("username")

        if (idUser != null) {
            if (nama != null) {
                showDataFragment(idUser, nama)
            }
        }
    }

    fun showDataFragment(idUser: String, nama: String) {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction =
            mFragmentManager.beginTransaction()
        val mFragment = DataHistoriGymFragment()
        val mBundle = Bundle()
        mBundle.putString("idUser", idUser)
        mBundle.putString("nama", nama)
        mFragment.arguments = mBundle
        mFragmentTransaction.replace(R.id.fl_data, mFragment).commit()
    }
}