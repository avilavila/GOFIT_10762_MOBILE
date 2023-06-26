package com.example.gofit_10762.Kelas

import com.google.gson.annotations.SerializedName

class Kelas (
    @SerializedName("id_kelas") val id_kelas: Int?,
    @SerializedName("nama_kelas") val nama_kelas:String,
    @SerializedName("harga_kelas") val harga_kelas:Int,
)