package com.example.gofit_10762.Instruktur

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_10762.PresensiInstruktur.HistoriInstruktur
import com.example.gofit_10762.databinding.ListHistoriInstrukturBinding

class HistoriInstrukturAdapter (
    private val listHistori: ArrayList<HistoriInstruktur>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<HistoriInstrukturAdapter.HistoriInstrukturViewHolder>() {
    inner class HistoriInstrukturViewHolder(item: ListHistoriInstrukturBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(historiData: HistoriInstruktur) {
            with(binding) {
                txtNama.text = "Kelas " + historiData.nama_kelas
                txtHariTanggal.text = "Hari, Tanggal         : "+historiData.hari_jadwal_umum +", "+historiData.tanggal_Jadwal_harian
                txtJamMulai.text = "Jam Mulai Kelas   : "+historiData.jam_mulai
                txtJamSelesai.text = "Jam Selesai Kelas : "+historiData.jam_selesai
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            HistoriInstrukturViewHolder {
        return HistoriInstrukturViewHolder(
            ListHistoriInstrukturBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: HistoriInstrukturViewHolder, position:
        Int
    ) {
        holder.bind(listHistori[position])
    }

    override fun getItemCount() = listHistori.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<HistoriInstruktur>) {
        listHistori.clear()
        listHistori.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(historiInstruktur: HistoriInstruktur)
        fun onUpdate(historiInstruktur: HistoriInstruktur)
        fun onDelete(historiInstruktur: HistoriInstruktur)
        fun onMap(historiInstruktur: HistoriInstruktur)
    }
}