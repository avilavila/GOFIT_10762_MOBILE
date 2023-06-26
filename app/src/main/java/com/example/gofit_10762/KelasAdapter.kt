package com.example.gofit_10762

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_10762.Kelas.Kelas
import com.example.gofit_10762.databinding.ListDataKelasBinding

class KelasAdapter (
    private val listPricelist: ArrayList<Kelas>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<KelasAdapter.KelasViewHolder>()
{
    inner class KelasViewHolder(item: ListDataKelasBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(KelasData: Kelas) {
            with(binding) {
                txtNama.text = KelasData.nama_kelas
                txtIdKelas.text =
                    "ID Kelas ( " + KelasData.id_kelas.toString() + " )"
                txtHargaKelas.text =
                    "Harga Kelas: Rp " + KelasData.harga_kelas
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            KelasViewHolder {
        return KelasViewHolder(
            ListDataKelasBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: KelasViewHolder, position:
        Int
    ) {
        holder.bind(listPricelist[position])
    }

    override fun getItemCount() = listPricelist.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<Kelas>) {
        listPricelist.clear()
        listPricelist.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(kelas: Kelas)
        fun onUpdate(kelas: Kelas)
        fun onDelete(kelas: Kelas)
        fun onMap(kelas: Kelas)
    }
}