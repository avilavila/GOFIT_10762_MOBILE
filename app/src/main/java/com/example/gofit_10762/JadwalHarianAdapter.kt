package com.example.gofit_10762

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_10762.JadwalHarian.JadwalHarian
import com.example.gofit_10762.Kelas.Kelas
import com.example.gofit_10762.databinding.ListDataJadwalHarianBinding
import com.example.gofit_10762.databinding.ListDataKelasBinding

class JadwalHarianAdapter (
    private val listJadwalHarian: ArrayList<JadwalHarian>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<JadwalHarianAdapter.JadwalHarianViewHolder>()
{
    inner class JadwalHarianViewHolder(item: ListDataJadwalHarianBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(JadwalHarianData: JadwalHarian) {
            with(binding) {
                txtTanggal.text = "" + JadwalHarianData.tanggal_jadwal_harian.toString()
                txtIdJadwalHarian.text =
                    "ID ( " + JadwalHarianData.id_jadwal_harian.toString() + " )"
                txtIdJadwalUmum.text =
                    "Hari, Tanggal : " + JadwalHarianData.hari_jadwal_umum + ", " + JadwalHarianData.tanggal_jadwal_harian
                txtIdInstruktur.text =
                    "Instruktur      : " + JadwalHarianData.nama_instruktur.toString()
                txtKeterangan.text =
                    "Keterangan    : " + JadwalHarianData.keterangan_jadwal_harian.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            JadwalHarianViewHolder {
        return JadwalHarianViewHolder(
            ListDataJadwalHarianBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: JadwalHarianViewHolder, position:
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