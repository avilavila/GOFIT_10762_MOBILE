package com.example.gofit_10762.Member

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_10762.BookingKelas.BookingKelas
import com.example.gofit_10762.BookingKelas.RClientBookingKelas
import com.example.gofit_10762.BookingKelas.ResponseCreateBookingKelas
import com.example.gofit_10762.databinding.ListDataBookingKelasBinding
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookingKelasAdapter (
    private val listBookingKelas: ArrayList<BookingKelas>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<BookingKelasAdapter.BookingKelasViewHolder>() {
    inner class BookingKelasViewHolder(item: ListDataBookingKelasBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(bookingKelasData: BookingKelas) {
            with(binding) {
                txtNama.text = nama
                txtNomorStruk.text = "Nomor Struk: "+ bookingKelasData.no_struk_presensi_kelas.toString()
                txtIdJadwalHarian.text = "Tanggal Booking Kelas: "+ bookingKelasData.tanggal_jadwal_harian
                txtNamaKelas.text = "Nama Kelas: " + bookingKelasData.nama_kelas
                txtHariJadwalHarian.text = "Hari Jadwal Harian: " + bookingKelasData.hari_jadwal_umum

                btnDelete.setOnClickListener {
                    val call: Call<ResponseCreateBookingKelas> = RClientBookingKelas.apiService.deleteData(bookingKelasData.no_struk_presensi_kelas)
                    call?.enqueue(object : Callback<ResponseCreateBookingKelas?> {
                        override fun onResponse(call: Call<ResponseCreateBookingKelas?>, response: Response<ResponseCreateBookingKelas?>) {
                            if(response != null){
                                if(response.body()?.stt != true){
                                    FancyToast.makeText(context, response.body()?.message.toString(),
                                        FancyToast.LENGTH_LONG,
                                        FancyToast.INFO,true).show()
                                } else {
                                    FancyToast.makeText(context, response.body()?.message.toString() + " - " + bookingKelasData.no_struk_presensi_kelas,
                                        FancyToast.LENGTH_LONG,
                                        FancyToast.SUCCESS,true).show()
                                    notifyDataSetChanged()
                                }
                            }
                        }

                        override fun onFailure(call: Call<ResponseCreateBookingKelas?>, t: Throwable) {
                            FancyToast.makeText(context, t.message,
                                FancyToast.LENGTH_LONG,
                                FancyToast.ERROR,true).show()
                        }
                    })
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            BookingKelasViewHolder {
        return BookingKelasViewHolder(
            ListDataBookingKelasBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: BookingKelasViewHolder, position:
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