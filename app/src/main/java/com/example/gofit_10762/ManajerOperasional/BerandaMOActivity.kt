package com.example.gofit_10762.ManajerOperasional

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.gofit_10762.Member.BerandaMemberFragment
import com.example.gofit_10762.Member.BookingGymFragment
import com.example.gofit_10762.PresensiInstruktur.PresensiInstruktur
import com.example.gofit_10762.R

class BerandaMOActivity : AppCompatActivity() {
    private var id: Int = 0
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_moactivity)
        val intent = intent

        val extras = intent.extras

        idUser = extras!!.getString("idUser").toString()
        nama = extras!!.getString("nama").toString()
        jabatan = extras!!.getString("jabatan").toString()
        username = extras!!.getString("username").toString()

        val firstFragment= BerandaMOFragment()
        val secondFragment= DataPresensiInstrukturFragment()
        val thirdFragment= ProfilMOFragment()
//        val fourth= FragmentCreator()
//        val fifthFragment= FragmentCreator()

        val bottomNavigationViewMO = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(
            R.id.bottomNavigationViewMO
        )

        setCurrentFragment(firstFragment)

        bottomNavigationViewMO.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->setCurrentFragment(firstFragment)
                R.id.presensi ->setCurrentFragment(secondFragment)
//                R.id.bookingKelas ->setCurrentFragment(thirdFragment)
                R.id.user ->setCurrentFragment(thirdFragment)
                R.id.logout ->{
                    val builder: AlertDialog.Builder = AlertDialog.Builder(this@BerandaMOActivity)
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
            replace(R.id.flFragmentMO,fragment)
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