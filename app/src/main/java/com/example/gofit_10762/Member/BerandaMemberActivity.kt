package com.example.gofit_10762.Member

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.gofit_10762.Instruktur.BerandaInstrukturFragment
import com.example.gofit_10762.Instruktur.IzinInstrukturFragment
import com.example.gofit_10762.R

class BerandaMemberActivity : AppCompatActivity() {
    private var id: Int = 0
    private var idUser: String = ""
    private var nama: String = ""
    private var jabatan: String = ""
    private var username: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_member)
        val intent = intent

        val extras = intent.extras

        idUser = extras!!.getString("idUser").toString()
        nama = extras!!.getString("nama").toString()
        jabatan = extras!!.getString("jabatan").toString()
        username = extras!!.getString("username").toString()

        val firstFragment= BerandaMemberFragment()
        val secondFragment= BookingGymFragment()
        val thirdFragment= BookingKelasFragment()
        val fourthFragment= ProfilMemberFragment()
//        val fifthFragment= FragmentCreator()

        val bottomNavigationViewMember = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(
            R.id.bottomNavigationViewMember
        )

        setCurrentFragment(firstFragment)

        bottomNavigationViewMember.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->setCurrentFragment(firstFragment)
                R.id.bookingGym ->setCurrentFragment(secondFragment)
                R.id.bookingKelas ->setCurrentFragment(thirdFragment)
                R.id.user ->setCurrentFragment(fourthFragment)
                R.id.logout ->{
                    val builder: AlertDialog.Builder = AlertDialog.Builder(this@BerandaMemberActivity)
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
            replace(R.id.flFragmentMember,fragment)
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