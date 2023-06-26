package com.example.gofit_10762.Member

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_10762.BookingGym.BookingGym
import com.example.gofit_10762.databinding.ListHistoriGymBinding

class HistoriGymAdapter (
    private val listHistoriGym: ArrayList<BookingGym>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<HistoriGymAdapter.HistoriGymViewHolder>() {
    inner class HistoriGymViewHolder(item: ListHistoriGymBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(historiData: BookingGym) {
            with(binding) {
                txtNomorStruk.text = "No. Struk -> " + historiData.no_struk_presensi_gym
                txtTanggalBooking.text = "Tanggal Pembuatan Booking : " + historiData.tanggal_pembuatan_booking_gym
                txtTanggalHadirGym.text = "Tanggal Booking Gym              : " + historiData.tanggal_booking_gym
                txtSesi.text = "Slot Booking Gym                     : " + historiData.slot_booking
                txtStatus.text = "Status Presensi                         : " + historiData.status_presensi_gym
                txtJamPresensi.text = "Jam Presensi                             : " + historiData.jam_presensi_gym
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            HistoriGymViewHolder {
        return HistoriGymViewHolder(
            ListHistoriGymBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: HistoriGymViewHolder, position:
        Int
    ) {
        holder.bind(listHistoriGym[position])
    }

    override fun getItemCount() = listHistoriGym.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<BookingGym>) {
        listHistoriGym.clear()
        listHistoriGym.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(historiGym: BookingGym)
        fun onUpdate(historiGym: BookingGym)
        fun onDelete(historiGym: BookingGym)
        fun onMap(historiGym: BookingGym)
    }
}