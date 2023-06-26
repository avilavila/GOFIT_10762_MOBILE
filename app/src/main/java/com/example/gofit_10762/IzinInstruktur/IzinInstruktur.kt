package com.example.gofit_10762.IzinInstruktur

import com.google.gson.annotations.SerializedName

class IzinInstruktur (
    @SerializedName("id_izin_instruktur") val id_izin_instruktur: Int?,
    @SerializedName("id_instruktur") val id_instruktur:String,
    @SerializedName("id_instruktur_pengganti") val id_instruktur_pengganti :String,
    @SerializedName("keterangan_izin") val keterangan_izin :String,
    @SerializedName("tanggal_izin") val tanggal_izin : String,
    @SerializedName("sesi_izin") val sesi_izin : String,
    @SerializedName("tanggal_buat") val tanggal_buat : String,
    @SerializedName("status_izin") val status_izin : String,
    @SerializedName("tanggal_konfirmasi") val tanggal_konfirmasi : String,
    @SerializedName("nama_instruktur") val nama_instruktur:String
)