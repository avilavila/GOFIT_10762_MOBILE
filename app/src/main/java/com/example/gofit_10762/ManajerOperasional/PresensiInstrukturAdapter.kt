package com.example.gofit_10762.ManajerOperasional

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_10762.PresensiInstruktur.JadwalHarian
import com.example.gofit_10762.PresensiInstruktur.RClientPresensiInstruktur
import com.example.gofit_10762.PresensiInstruktur.ResponseCreatePresensiInstruktur
import com.example.gofit_10762.databinding.ListDataPresensiInstrukturBinding
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class PresensiInstrukturAdapter (
    private val listJadwalHarian: ArrayList<JadwalHarian>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<PresensiInstrukturAdapter.PresensiInstrukturViewHolder>() {
    inner class PresensiInstrukturViewHolder(item: ListDataPresensiInstrukturBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(presensiInstrukturData: JadwalHarian) {
            with(binding) {
                txtHariTanggal.text = presensiInstrukturData.hari_jadwal_umum + " , " + presensiInstrukturData.tanggal_jadwal_harian
                txtKelas.text = "Nama Kelas: "+ presensiInstrukturData.nama_kelas + " / Jam Kelas : " + presensiInstrukturData.waktu_jadwal_umum
                txtInstruktur.text = "Nama Instruktur : "+ presensiInstrukturData.nama_instruktur + " / ID Instruktur : " + presensiInstrukturData.id_instruktur

                btnMulai.setOnClickListener{
                    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                    builder.setMessage("Apakah anda ingin memulai kelas " + presensiInstrukturData.nama_kelas +
                            " pada tanggal " + presensiInstrukturData.tanggal_jadwal_harian +
                            " dengan instruktur " + presensiInstrukturData.nama_instruktur + "?")
                        .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                                val calendar: Calendar = Calendar.getInstance()
                                val hour = calendar[Calendar.HOUR_OF_DAY]
                                val minute = calendar[Calendar.MINUTE]
                                val second = calendar[Calendar.SECOND]
                                val currentTime = String.format("%02d:%02d:%02d", hour, minute, second)
                                val call: Call<ResponseCreatePresensiInstruktur>? = RClientPresensiInstruktur.apiService.createData(
                                    presensiInstrukturData.id_instruktur,
                                    presensiInstrukturData.id_jadwal_harian.toString(), currentTime
                                )
                                call?.enqueue(object : Callback<ResponseCreatePresensiInstruktur?> {
                                    override fun onResponse(call: Call<ResponseCreatePresensiInstruktur?>, response: Response<ResponseCreatePresensiInstruktur?>) {
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

                                    override fun onFailure(call: Call<ResponseCreatePresensiInstruktur?>, t: Throwable) {
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

                btnSelesai.setOnClickListener {
                    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                    builder.setMessage("Apakah anda yakin ingin menyelesaikan kelas " + presensiInstrukturData.nama_kelas +
                            " pada tanggal " + presensiInstrukturData.tanggal_jadwal_harian +
                            " dengan instruktur " + presensiInstrukturData.nama_instruktur + "?")
                        .setPositiveButton("YES", object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface, i: Int){
                                val calendar: Calendar = Calendar.getInstance()
                                val hour = calendar[Calendar.HOUR_OF_DAY]
                                val minute = calendar[Calendar.MINUTE]
                                val second = calendar[Calendar.SECOND]
                                val currentTime = String.format("%02d:%02d:%02d", hour, minute, second)
                                val call: Call<ResponseCreatePresensiInstruktur>? = RClientPresensiInstruktur.apiService.updateData(
                                    presensiInstrukturData.id_instruktur,
                                    presensiInstrukturData.id_jadwal_harian.toString(), currentTime
                                )
                                call?.enqueue(object : Callback<ResponseCreatePresensiInstruktur?> {
                                    override fun onResponse(call: Call<ResponseCreatePresensiInstruktur?>, response: Response<ResponseCreatePresensiInstruktur?>) {
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

                                    override fun onFailure(call: Call<ResponseCreatePresensiInstruktur?>, t: Throwable) {
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
            PresensiInstrukturViewHolder {
        return PresensiInstrukturViewHolder(
            ListDataPresensiInstrukturBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: PresensiInstrukturViewHolder, position:
        Int
    ) {
        holder.bind(listJadwalHarian[position])
    }

    override fun getItemCount() = listJadwalHarian.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<JadwalHarian>) {
        listJadwalHarian.clear()
        listJadwalHarian.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(jadwalHarian: JadwalHarian)
        fun onUpdate(jadwalHarian: JadwalHarian)
        fun onDelete(jadwalHarian: JadwalHarian)
        fun onMap(jadwalHarian: JadwalHarian)
    }
}