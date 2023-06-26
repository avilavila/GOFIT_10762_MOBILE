package com.example.gofit_10762.User

import com.google.gson.annotations.SerializedName

class DepositKelasMember (
    @SerializedName("id_deposit_member") val id_deposit_member:String,
    @SerializedName("id_member") val ID_MEMBER:String,
    @SerializedName("id_kelas") val ID_KELAS:String,
    @SerializedName("deposit_paket_kelas") val deposit_paket_kelas:String,
    @SerializedName("tanggal_kadaluarsa_kelas") val tanggal_kadaluarsa_kelas:String,
    @SerializedName("nama_kelas") val nama_kelas:String
)