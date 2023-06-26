package com.example.gofit_10762.Instruktur

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_10762.IzinInstruktur.IzinInstruktur
import com.example.gofit_10762.databinding.ListDataIzinInstrukturBinding

class IzinInstrukturAdapter (
    private val listIzinInstruktur: ArrayList<IzinInstruktur>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<IzinInstrukturAdapter.IzinInstrukturViewHolder>()
    {
        inner class IzinInstrukturViewHolder(item: ListDataIzinInstrukturBinding) :
            RecyclerView.ViewHolder(item.root) {
            private val binding = item
            fun bind(izinInstrukturData: IzinInstruktur) {
                with(binding) {
                    txtNama.text = nama
                    txtIdIzin.text =
                        "ID Izin Instruktur: " + izinInstrukturData.id_izin_instruktur.toString()
                    txtIdInstrukturPengganti.text =
                        "Nama Instruktur Pengganti: " + izinInstrukturData.nama_instruktur
                    txtTanggalIzin.text = "Tanggal Izin: " + izinInstrukturData.tanggal_izin
                    txtSesiIzin.text = "Sesi Izin: " + izinInstrukturData.sesi_izin
                    txtTanggalBuat.text = "Tanggal Buat Izin: " + izinInstrukturData.tanggal_buat
                    txtStatusIzin.text = "Status Izin: " + izinInstrukturData.status_izin
                    txtTanggalKonfirmasi.text =
                        "Tanggal Konfirmasi: " + izinInstrukturData.tanggal_konfirmasi
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
                IzinInstrukturViewHolder {
            return IzinInstrukturViewHolder(
                ListDataIzinInstrukturBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }

        override fun onBindViewHolder(
            holder: IzinInstrukturViewHolder, position:
            Int
        ) {
            holder.bind(listIzinInstruktur[position])
        }

        override fun getItemCount() = listIzinInstruktur.size

        @SuppressLint("NotifyDataSetChanged")

        fun setData(list: List<IzinInstruktur>) {
            listIzinInstruktur.clear()
            listIzinInstruktur.addAll(list)
            notifyDataSetChanged()
        }

        interface OnAdapterListener {
            fun onClick(izinInstruktur: IzinInstruktur)
            fun onUpdate(izinInstruktur: IzinInstruktur)
            fun onDelete(izinInstruktur: IzinInstruktur)
            fun onMap(izinInstruktur: IzinInstruktur)
        }
    }