package com.example.gofit_10762.IzinInstruktur

import com.google.gson.annotations.SerializedName

class Instruktur (
    @SerializedName("id_instruktur") val id_instruktur:String,
    @SerializedName("nama_instruktur") val nama_instruktur:String,
    @SerializedName("alamat_instruktur") val alamat_instruktur:String,
    @SerializedName("tanggal_lahir_instruktur") val tanggal_lahir_instruktur:String,
    @SerializedName("telepon_instruktur") val telepon_instruktur:String,
    @SerializedName("email_instruktur") val email_instruktur:String,
    @SerializedName("username_instruktur") val username_instruktur:String,
    @SerializedName("password_instruktur") val password_instruktur:String,
    @SerializedName("keterlambatan") val keterlambatan:String,
)