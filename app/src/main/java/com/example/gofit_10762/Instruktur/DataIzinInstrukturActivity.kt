package com.example.gofit_10762.Instruktur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gofit_10762.databinding.ActivityDataIzinInstrukturBinding
import com.example.gofit_10762.R
import com.example.gofit_10762.Instruktur.DataIzinInstrukturFragment

class DataIzinInstrukturActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDataIzinInstrukturBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataIzinInstrukturBinding.inflate(layoutInflater)
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
//        binding.txtCari.setOnKeyListener(View.OnKeyListener { _,
//                                                              keyCode, event ->
//            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action
//                == KeyEvent.ACTION_UP
//            ) {
//                showDataFragment()
//                return@OnKeyListener true
//            }
//            false
//        })
//        binding.btnAdd.setOnClickListener {
//            startActivity(
//                Intent(
//                    this,
//                    FormAddDestinationActivity::class.java
//                )
//            )
//        }
    }

    fun showDataFragment(idUser: String, nama: String) {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = DataIzinInstrukturFragment()
        val mBundle = Bundle()
        mBundle.putString("idUser", idUser)
        mBundle.putString("nama", nama)
        mFragment.arguments = mBundle
        mFragmentTransaction.replace(R.id.fl_data, mFragment).commit()
    }
}