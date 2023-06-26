package com.example.gofit_10762.Member

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_10762.BookingGym.BookingGym
import com.example.gofit_10762.BookingGym.RClientBookingGym
import com.example.gofit_10762.BookingGym.ResponseCreateBookingGym
import com.example.gofit_10762.databinding.ListDataBookingGymBinding
import com.shashank.sony.fancytoastlib.FancyToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookingGymAdapter (
    private val listBookingGym: ArrayList<BookingGym>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<BookingGymAdapter.BookingGymViewHolder>() {
    inner class BookingGymViewHolder(item: ListDataBookingGymBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(bookingGymData: BookingGym) {
            with(binding) {
                txtNama.text = nama
                txtIdMember.text = "ID Member: " + bookingGymData.id_member
                txtNomorStruk.text = "Nomor Struk: "+ bookingGymData.no_struk_presensi_gym.toString()
                txtTanggalBookingGym.text = "Tanggal Booking Gym: "+ bookingGymData.tanggal_booking_gym
                txtTanggalPembuatanBookingGym.text = "Tanggal Pembuatan Booking Gym: "+ bookingGymData.tanggal_pembuatan_booking_gym
                txtSlotBooking.text = "Slot Booking Gym: "+ bookingGymData.slot_booking
                txtPresensi.text = "Status Presensi/Jam Presensi: "+ bookingGymData.status_presensi_gym + " / " + bookingGymData.jam_presensi_gym
                btnDelete.setOnClickListener {
                    val call: Call<ResponseCreateBookingGym> = RClientBookingGym.apiService.deleteData(bookingGymData.no_struk_presensi_gym)
                    call?.enqueue(object : Callback<ResponseCreateBookingGym?> {
                        override fun onResponse(call: Call<ResponseCreateBookingGym?>, response: Response<ResponseCreateBookingGym?>) {
                            if(response != null){
                                if(response.body()?.stt != true){
                                    FancyToast.makeText(context, response.body()?.message.toString(),
                                        FancyToast.LENGTH_LONG,
                                        FancyToast.INFO,true).show()
                                } else {
                                    FancyToast.makeText(context, response.body()?.message.toString() + " - " + bookingGymData.no_struk_presensi_gym,
                                        FancyToast.LENGTH_LONG,
                                        FancyToast.SUCCESS,true).show()
                                    notifyDataSetChanged()
                                }
                            }
                        }

                        override fun onFailure(call: Call<ResponseCreateBookingGym?>, t: Throwable) {
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
            BookingGymViewHolder {
        return BookingGymViewHolder(
            ListDataBookingGymBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: BookingGymViewHolder, position:
        Int
    ) {
        holder.bind(listBookingGym[position])
    }

    override fun getItemCount() = listBookingGym.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<BookingGym>) {
        listBookingGym.clear()
        listBookingGym.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(bookingGym: BookingGym)
        fun onUpdate(bookingGym: BookingGym)
        fun onDelete(bookingGym: BookingGym)
        fun onMap(bookingGym: BookingGym)
    }
}