package com.example.gofit_10762.Member

import android.R
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.gofit_10762.BookingGym.RClientBookingGym
import com.example.gofit_10762.BookingGym.ResponseCreateBookingGym
import com.example.gofit_10762.databinding.ActivityBookingGymBinding
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_booking_gym.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class BookingGymActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBookingGymBinding
    private var spinner: Spinner? = null
    val idJadwalHarian = ArrayList<String>()
    val namaKelas = ArrayList<String>()
    val tanggalJadwalHarian = ArrayList<String>()
    val hariJadwalUmum = ArrayList<String>()
    val jamJadwalUmum = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingGymBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent

        val extras = intent.extras

        val idUser = extras!!.getString("idUser").toString()
        val nama = extras!!.getString("nama").toString()
        val jabatan = extras!!.getString("jabatan").toString()
        val username = extras!!.getString("username").toString()

        val items = listOf("Pilih slot jadwal gym", "07.00-09.00", "09.00-11.00", "11.00-13.00", "13.00-15.00", "15.00-17.00", "17.00-19.00", "19.00-21.00")
        var selectedItem = ""

        spinner = binding.spinner1
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        spinner!!.adapter = adapter
        spinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedItem = parent.getItemAtPosition(position).toString()
                if (selectedItem != "Pilih slot jadwal gym") {

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                val defaultText = "Pilih slot jadwal gym"
                selectedItem = parent.selectedItem?.toString() ?: defaultText
                if (selectedItem == defaultText) {
                    // Handle the case when nothing is selected
                    FancyToast.makeText(applicationContext, "Pilih jadwal dahulu",
                        FancyToast.LENGTH_LONG,
                        FancyToast.ERROR,true).show()
                }
            }

        }

        binding.tvTglBooking.setOnClickListener {
            val datePicker = DatePickerDialog.OnDateSetListener{
                    view,year,month,dayofMonth-> binding.tvTglBooking.text = dateToString(year,month,dayofMonth)
            }
            dateDialog(this,datePicker).show()
        }


        binding.btnAdd.setOnClickListener{
            val builder: AlertDialog.Builder = AlertDialog.Builder(this@BookingGymActivity)
            builder.setMessage("Apakah anda ingin melakukan booking gym pada tanggal " + binding.tvTglBooking.text +
                    " jam " + selectedItem + "?")
                .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                    override fun onClick(dialogInterface: DialogInterface, i: Int){
                        val tanggal = tv_tglBooking.text.toString()

                        val call: Call<ResponseCreateBookingGym> = RClientBookingGym.apiService.createData(idUser, tanggal, selectedItem)
                        call?.enqueue(object : Callback<ResponseCreateBookingGym?> {
                            override fun onResponse(call: Call<ResponseCreateBookingGym?>, response: Response<ResponseCreateBookingGym?>) {
                                if(response != null){
                                    if(selectedItem == "Silakan memilih jadwal"){
                                        FancyToast.makeText(applicationContext, "Mohon untuk memilih jam booking gym!",
                                            FancyToast.LENGTH_LONG,
                                            FancyToast.ERROR,true).show()
                                    } else {
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
                            }

                            override fun onFailure(call: Call<ResponseCreateBookingGym?>, t: Throwable) {
                                FancyToast.makeText(applicationContext, t.message,
                                    FancyToast.LENGTH_LONG,
                                    FancyToast.ERROR,true).show()
                            }
                        })
                    }
                })
                .setNegativeButton("NO", object : DialogInterface.OnClickListener {
                    override fun onClick(dialogInterface: DialogInterface, i: Int){
                    }
                })
                .show()
        }
    }
    private fun dateToString(year: Int, month: Int, dayofMonth:Int):String{
        return year.toString()+"-"+(month+1)+"-"+dayofMonth.toString()
    }

    private fun dateDialog(context: Context, datePicker: DatePickerDialog.OnDateSetListener): DatePickerDialog {
        val calender = Calendar.getInstance()
        return DatePickerDialog(
            context,datePicker,
            calender[Calendar.YEAR],
            calender[Calendar.MONTH],
            calender[Calendar.DAY_OF_MONTH],
        )
    }
}