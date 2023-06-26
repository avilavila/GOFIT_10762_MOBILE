package com.example.gofit_10762.Instruktur

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_10762.BookingKelas.BookingKelas
import com.example.gofit_10762.BookingKelas.RClientBookingKelas
import com.example.gofit_10762.BookingKelas.ResponseCreateJadwalHarian
import com.example.gofit_10762.databinding.ListDataPresensiKelasBinding
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class BookingPresensiKelasAdapter(
    private val listBookingKelas: ArrayList<BookingKelas>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<BookingPresensiKelasAdapter.BookingPresensiKelasViewHolder>() {
    inner class BookingPresensiKelasViewHolder(item: ListDataPresensiKelasBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(bookingKelasData: BookingKelas) {
            with(binding) {
                txtNama.text = bookingKelasData.nama_kelas
                txtNamaMember.text = bookingKelasData.id_member + " / " + bookingKelasData.nama_member
                txtTanggalJadwalHarian.text = bookingKelasData.hari_jadwal_umum + " / " + bookingKelasData.tanggal_jadwal_harian
                btnHadir.setOnClickListener {
                    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                    builder.setMessage("Apakah anda yakin ingin mempresensi member " + bookingKelasData.nama_member +
                            " untuk kelas " + bookingKelasData.nama_kelas +
                            " pada tanggal " + bookingKelasData.tanggal_jadwal_harian + " menjadi HADIR?")
                        .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                                val calendar: Calendar = Calendar.getInstance()
                                val hour = calendar[Calendar.HOUR_OF_DAY]
                                val minute = calendar[Calendar.MINUTE]
                                val second = calendar[Calendar.SECOND]
                                val currentTime = String.format("%02d:%02d:%02d", hour, minute, second)
                                val call: Call<ResponseCreateJadwalHarian> = RClientBookingKelas.apiService.setHadir(
                                    bookingKelasData.id_member,
                                    bookingKelasData.id_jadwal_harian, currentTime
                                )
                                call?.enqueue(object : Callback<ResponseCreateJadwalHarian?> {
                                    override fun onResponse(call: Call<ResponseCreateJadwalHarian?>, response: Response<ResponseCreateJadwalHarian?>) {
                                        if(response.body()?.stt != true){
                                            FancyToast.makeText(context, response.body()?.message.toString(),
                                                FancyToast.LENGTH_LONG,
                                                FancyToast.INFO,true).show()
                                        } else {
                                            FancyToast.makeText(context, response.body()?.message.toString(),
                                                FancyToast.LENGTH_LONG,
                                                FancyToast.SUCCESS,true).show()
                                        }
                                    }

                                    override fun onFailure(call: Call<ResponseCreateJadwalHarian?>, t: Throwable) {
                                        FancyToast.makeText(context, t.message,
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
                btnTidakhadir.setOnClickListener {
                    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                    builder.setMessage("Apakah anda yakin ingin mempresensi member " + bookingKelasData.nama_member +
                            " untuk kelas " + bookingKelasData.nama_kelas +
                            " pada tanggal " + bookingKelasData.tanggal_jadwal_harian + " menjadi TIDAK HADIR?")
                        .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                                val calendar: Calendar = Calendar.getInstance()
                                val hour = calendar[Calendar.HOUR_OF_DAY]
                                val minute = calendar[Calendar.MINUTE]
                                val second = calendar[Calendar.SECOND]
                                val currentTime = String.format("%02d:%02d:%02d", hour, minute, second)
                                val call: Call<ResponseCreateJadwalHarian> = RClientBookingKelas.apiService.setTidakHadir(
                                    bookingKelasData.id_member,
                                    bookingKelasData.id_jadwal_harian, currentTime
                                )
                                call?.enqueue(object : Callback<ResponseCreateJadwalHarian?> {
                                    override fun onResponse(call: Call<ResponseCreateJadwalHarian?>, response: Response<ResponseCreateJadwalHarian?>) {
                                        if(response.body()?.stt != true){
                                            FancyToast.makeText(context, response.body()?.message.toString(),
                                                FancyToast.LENGTH_LONG,
                                                FancyToast.INFO,true).show()
                                        } else {
                                            FancyToast.makeText(context, response.body()?.message.toString(),
                                                FancyToast.LENGTH_LONG,
                                                FancyToast.SUCCESS,true).show()
                                        }
                                    }

                                    override fun onFailure(call: Call<ResponseCreateJadwalHarian?>, t: Throwable) {
                                        FancyToast.makeText(context, t.message,
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
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            BookingPresensiKelasViewHolder {
        return BookingPresensiKelasViewHolder(
            ListDataPresensiKelasBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: BookingPresensiKelasViewHolder, position:
        Int
    ) {
        holder.bind(listBookingKelas[position])
    }

    override fun getItemCount() = listBookingKelas.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<BookingKelas>) {
        listBookingKelas.clear()
        listBookingKelas.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(bookingKelas: BookingKelas)
        fun onUpdate(bookingKelas: BookingKelas)
        fun onDelete(bookingKelas: BookingKelas)
        fun onMap(bookingKelas: BookingKelas)
    }
}