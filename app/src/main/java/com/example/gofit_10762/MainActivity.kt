package com.example.gofit_10762

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.gofit_10762.Instruktur.BerandaInstrukturActivity
import com.example.gofit_10762.ManajerOperasional.BerandaMOActivity
import com.example.gofit_10762.Member.BerandaMemberActivity
import com.example.gofit_10762.User.RClientUser.apiService
import com.example.gofit_10762.User.ResponseCreate
import com.example.gofit_10762.User.User
import com.example.gofit_10762.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.romainpiel.shimmer.Shimmer
import com.romainpiel.shimmer.ShimmerTextView
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var tv: ShimmerTextView? = null
    var shimmer: Shimmer? = null
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var mainLayout: ConstraintLayout
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        inputEmail = findViewById(R.id.inputLayoutEmail)
        inputPassword = findViewById(R.id.inputLayoutPassword)
        mainLayout = findViewById(R.id.mainLayout)
        val extras = Bundle()
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnLogin: Button = findViewById(R.id.btnLogin)
//        val btnForgot: Button = findViewById(R.id.btnForgot)


        btnClear.setOnClickListener {
            inputEmail.getEditText()?.setText("")
            inputPassword.getEditText()?.setText("")

            Snackbar.make(mainLayout, "Text Cleared Success", Snackbar.LENGTH_LONG).show()
        }

//        btnForgot.setOnClickListener {
//            //masih kosong dulu
//        }

        btnLogin.setOnClickListener(View.OnClickListener {
            val email: String = inputEmail.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()

            if(email.length == 0 && password.length == 0){
                inputEmail.setError("Tidak boleh kosong!")
                inputPassword.setError("Tidak boleh kosong!")
            } else if (email.length == 0){
                inputEmail.setError("Tidak boleh kosong!")
            } else if (password.length == 0){
                inputPassword.setError("Tidak boleh kosong!")
            }
            val call: Call<ResponseCreate>? = apiService.login(email,password)
            call?.enqueue(object : Callback<ResponseCreate?> {
                override fun onResponse(call: Call<ResponseCreate?>, response: Response<ResponseCreate?>) {
                    if(response.body()?.stt == true){
                        val user: User? = response.body()?.user
                        // Do something with the user object
                        extras.putInt("id", user?.getId()!!)
                        extras.putString("idUser", user?.getIdUser()!!)
                        extras.putString("nama", user?.getNama())
                        extras.putString("jabatan", user?.getJabatan())
                        extras.putString("username", user?.getUsername())

                        if(user?.getJabatan() == "Member"){
                            val intent = Intent(this@MainActivity, BerandaMemberActivity::class.java)
                            intent.putExtras(extras)
                            FancyToast.makeText(applicationContext, "Login sebagai Member " + user?.getNama().toString(),
                                FancyToast.LENGTH_LONG,
                                FancyToast.SUCCESS,true).show()
                            startActivity(intent)
                            finish()
                        } else if(user?.getJabatan() == "Instruktur"){
                            val intent = Intent(this@MainActivity, BerandaInstrukturActivity::class.java)
                            intent.putExtras(extras)
                            FancyToast.makeText(applicationContext, "Login sebagai Instruktur " + user?.getNama().toString(),
                                FancyToast.LENGTH_LONG,
                                FancyToast.SUCCESS,true).show()
                            startActivity(intent)
                            finish()
                        } else if(user?.getJabatan() == "Manajer Operasional"){
                            val intent = Intent(this@MainActivity, BerandaMOActivity::class.java)
                            intent.putExtras(extras)
                            FancyToast.makeText(applicationContext, "Login sebagai MO " + user?.getNama().toString(),
                                FancyToast.LENGTH_LONG,
                                FancyToast.SUCCESS,true).show()
                            startActivity(intent)
                            finish()
                        }
                    } else {
                        FancyToast.makeText(applicationContext, "email atau password salah!",
                            FancyToast.LENGTH_LONG,
                            FancyToast.ERROR,true).show()
                    }
                }

                override fun onFailure(call: Call<ResponseCreate?>, t: Throwable) {
                    // Handle the error
                    FancyToast.makeText(applicationContext,t.message,
                        FancyToast.LENGTH_LONG,
                        FancyToast.ERROR,true).show()
//                    FancyToast.makeText(applicationContext, "email atau password salah!",
//                        FancyToast.LENGTH_LONG,
//                        FancyToast.ERROR,true).show()
                }
            })
        })
    }
}