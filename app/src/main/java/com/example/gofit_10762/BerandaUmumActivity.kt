package com.example.gofit_10762

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.gofit_10762.BerandaUmumFragment
import kotlinx.android.synthetic.main.activity_beranda_umum.*

class BerandaUmumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_umum)

        val firstFragment= BerandaUmumFragment()
        val secondFragment= DataPricelistFragment()
        val thirdFragment= DataJadwalHarianFragment()


        bottomNavigationViewUmum.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->setCurrentFragment(firstFragment)
                R.id.pricelist ->setCurrentFragment(secondFragment)
                R.id.jadwalharian ->setCurrentFragment(thirdFragment)
//                R.id.user ->setCurrentFragment(firstFragment)
                R.id.logout ->{
                    val builder: AlertDialog.Builder = AlertDialog.Builder(this@BerandaUmumActivity)
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
            replace(R.id.flFragmentUmum,fragment)
            commit()
        }

}