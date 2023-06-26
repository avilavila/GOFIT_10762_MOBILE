package com.example.gofit_10762.Instruktur

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.gofit_10762.User.User
import com.example.gofit_10762.databinding.FragmentBerandaInstrukturBinding
import com.example.gofit_10762.Instruktur.BerandaInstrukturFragment
import com.example.gofit_10762.Instruktur.IzinInstrukturFragment
import com.example.gofit_10762.R

class BerandaInstrukturActivity : AppCompatActivity() {
    private var id: Int = 0
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_instruktur)
        val intent = intent

        val extras = intent.extras

        id = extras!!.getInt("id")
        idUser = extras!!.getString("idUser").toString()
        nama = extras!!.getString("nama").toString()
        jabatan = extras!!.getString("jabatan").toString()
        username = extras!!.getString("username").toString()

        val firstFragment= BerandaInstrukturFragment()
        val secondFragment= IzinInstrukturFragment()
        val thirdFragment= DataPresensiKelasFragment()
        val fourthFragment= ProfilInstrukturFragment()
//        val fourth= FragmentCreator()
//        val fifthFragment= FragmentCreator()

        val bottomNavigationView = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(
            R.id.bottomNavigationView
        )

        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->setCurrentFragment(firstFragment)
                R.id.izinInstruktur ->setCurrentFragment(secondFragment)
                R.id.presensiMember ->setCurrentFragment(thirdFragment)
                R.id.user ->setCurrentFragment(fourthFragment)
                R.id.logout ->{
                    val builder: AlertDialog.Builder = AlertDialog.Builder(this@BerandaInstrukturActivity)
                    builder.setMessage("Are you sure want to exit?")
                        .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                                finishAndRemoveTask()
                            }
                        })
                        .show()
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
    public fun getIdUser(): String {
        return idUser
    }

    public fun getNama(): String {
        return nama
    }

    public fun getJabatan(): String {
        return jabatan
    }

    public fun getUsername(): String {
        return username
    }
}