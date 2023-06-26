package com.example.gofit_10762.Member

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.gofit_10762.BookingKelas.JadwalHarian
import com.example.gofit_10762.BookingKelas.RClientBookingKelas
import com.example.gofit_10762.BookingKelas.ResponseCreateJadwalHarian
import com.example.gofit_10762.databinding.ActivityBookingKelasBinding
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookingKelasActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBookingKelasBinding
    private var spinner: Spinner? = null
    val idJadwalHarian = ArrayList<String>()
    val namaKelas = ArrayList<String>()
    val tanggalJadwalHarian = ArrayList<String>()
    val hariJadwalUmum = ArrayList<String>()
    val jamJadwalUmum = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingKelasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent

        val extras = intent.extras

        val idUser = extras!!.getString("idUser").toString()
        val nama = extras!!.getString("nama").toString()
        val jabatan = extras!!.getString("jabatan").toString()
        val username = extras!!.getString("username").toString()

        setData()

        spinner = binding.spinner1
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            R.layout.simple_spinner_item, idJadwalHarian
        )
        setSpinner(adapter)

        binding.btnAdd.setOnClickListener{
            val input = binding.txtInput.text.toString()

            if(input.length == 0){
                binding.txtInput.setError("Tidak boleh kosong!")
            } else {
                val call: Call<com.example.gofit_10762.BookingKelas.ResponseCreateJadwalHarian>? = RClientBookingKelas.apiService.createData(idUser, input)
                call?.enqueue(object : Callback<com.example.gofit_10762.BookingKelas.ResponseCreateJadwalHarian?> {
                    override fun onResponse(call: Call<ResponseCreateJadwalHarian?>, response: Response<ResponseCreateJadwalHarian?>) {
                        if(response != null){
                            if(response.body()?.stt != true){
                                FancyToast.makeText(applicationContext, response.body()?.message.toString(),
                                    FancyToast.LENGTH_LONG,
                                    FancyToast.INFO,true).show()
                            } else {
                                FancyToast.makeText(applicationContext, response.body()?.message.toString(),
                                    FancyToast.LENGTH_LONG,
                                    FancyToast.SUCCESS,true).show()
                                finish()
                            }
                        }
                    }

                    override fun onFailure(call: Call<com.example.gofit_10762.BookingKelas.ResponseCreateJadwalHarian?>, t: Throwable) {
                        FancyToast.makeText(applicationContext, t.message,
                            FancyToast.LENGTH_LONG,
                            FancyToast.ERROR,true).show()
                    }
                })
            }
        }
    }

    fun setData(){
        val call: Call<com.example.gofit_10762.BookingKelas.ResponseCreateJadwalHarian> = RClientBookingKelas.apiService.getJadwalHarian("blank")
        call?.enqueue(object : Callback<com.example.gofit_10762.BookingKelas.ResponseCreateJadwalHarian> {
            override fun onResponse(call: Call<com.example.gofit_10762.BookingKelas.ResponseCreateJadwalHarian>, response: Response<com.example.gofit_10762.BookingKelas.ResponseCreateJadwalHarian>) {
                if (response.isSuccessful){
                    val jadwalHarian: List<JadwalHarian>? = response.body()?.data
                    for (i in 0 until jadwalHarian!!.size) {
                        val item = jadwalHarian.get(i)
                        idJadwalHarian.add(item.id_jadwal_harian.toString() + " - " + item.hari_jadwal_umum + " - " + item.tanggal_jadwal_harian + " - " + item.nama_kelas + " - " + item.waktu_jadwal_umum)
                        namaKelas.add(item.nama_kelas)
                        tanggalJadwalHarian.add(item.tanggal_jadwal_harian)
                        hariJadwalUmum.add(item.hari_jadwal_umum)
                        jamJadwalUmum.add(item.waktu_jadwal_umum)
                    }
                }
            }

            override fun onFailure(call: Call<com.example.gofit_10762.BookingKelas.ResponseCreateJadwalHarian>, t: Throwable) {
            }
        })
    }

    fun saveData(idUser: String, nama:String, jabatan: String, username: String, input: String){
        with(binding){


        }
    }

    fun setSpinner(adapter: ArrayAdapter<String>){
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        spinner!!.adapter = adapter
        spinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                binding.btnAdd.setOnClickListener{
                    FancyToast.makeText(applicationContext, "Pilih jadwal!",
                        FancyToast.LENGTH_LONG,
                        FancyToast.SUCCESS,true).show()
                }
            }
        }
    }
}