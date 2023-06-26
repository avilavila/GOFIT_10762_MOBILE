package com.example.gofit_10762.Member

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gofit_10762.User.DepositKelasMember
import com.example.gofit_10762.databinding.ListDataPaketBinding

class DepositKelasMemberAdapter (
    private val listPaket: ArrayList<DepositKelasMember>,
    private val context: Context,
    private val nama: String
) :
    RecyclerView.Adapter<DepositKelasMemberAdapter.DepositKelasMemberViewHolder>() {
    inner class DepositKelasMemberViewHolder(item: ListDataPaketBinding) :
        RecyclerView.ViewHolder(item.root) {
        private val binding = item
        fun bind(paketData: DepositKelasMember) {
            with(binding) {
                txtNama.text = "Kelas -> " + paketData.nama_kelas
                txtKadaluarsa.text = "Tanggal Kadaluarsa     : " + paketData.tanggal_kadaluarsa_kelas
                txtDeposit.text = "Jumlah Deposit Paket : " + paketData.deposit_paket_kelas
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            DepositKelasMemberViewHolder {
        return DepositKelasMemberViewHolder(
            ListDataPaketBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: DepositKelasMemberViewHolder, position:
        Int
    ) {
        holder.bind(listPaket[position])
    }

    override fun getItemCount() = listPaket.size

    @SuppressLint("NotifyDataSetChanged")

    fun setData(list: List<DepositKelasMember>) {
        listPaket.clear()
        listPaket.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(paket: DepositKelasMember)
        fun onUpdate(paket: DepositKelasMember)
        fun onDelete(paket: DepositKelasMember)
        fun onMap(paket: DepositKelasMember)
    }
}