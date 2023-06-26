package com.example.gofit_10762.Member

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_10762.BookingKelas.BookingKelas
import com.example.gofit_10762.databinding.ListHistoriKelasBinding

class HistoriKelasAdapter (
    private val listHistoriKelas: ArrayList<BookingKelas>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<HistoriKelasAdapter.HistoriKelasViewHolder>() {
    inner class HistoriKelasViewHolder(item: ListHistoriKelasBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(historiData: BookingKelas) {
            with(binding) {
                txtNomorStruk.text = "No. Struk -> " + historiData.no_struk_presensi_kelas
                txtNamaKelas.text = "Kelas " + historiData.nama_kelas
                txtTanggalBooking.text = "Tanggal Booking Kelas : " + historiData.tanggal_pembuatan_booking_kelas
                txtHariTanggal.text = "Hari, Tanggal Kelas       : " + historiData.hari_jadwal_umum + ", " + historiData.tanggal_jadwal_harian
                txtJenisBooking.text = "Jenis Booking                : " + historiData.jenis_booking_kelas
                txtStatus.text = "Status Presensi             : " + historiData.status_presensi_kelas
                txtJamPresensi.text = "Jam Presensi                 : " + historiData.jam_presensi_kelas
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            HistoriKelasViewHolder {
        return HistoriKelasViewHolder(
            ListHistoriKelasBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: HistoriKelasViewHolder, position:
        Int
    ) {
        holder.bind(listHistoriKelas[position])
    }

    override fun getItemCount() = listHistoriKelas.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<BookingKelas>) {
        listHistoriKelas.clear()
        listHistoriKelas.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(historyKelas: BookingKelas)
        fun onUpdate(historyKelas: BookingKelas)
        fun onDelete(historyKelas: BookingKelas)
        fun onMap(historyKelas: BookingKelas)
    }
}