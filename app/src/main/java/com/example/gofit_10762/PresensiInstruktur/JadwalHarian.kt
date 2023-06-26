package com.example.gofit_10762.PresensiInstruktur

import com.google.gson.annotations.SerializedName

class JadwalHarian (
    @SerializedName("id_jadwal_harian") val id_jadwal_harian: Int?,
    @SerializedName("tanggal_jadwal_harian") val tanggal_jadwal_harian: String,
    @SerializedName("hari_jadwal_umum") val hari_jadwal_umum:String,
    @SerializedName("waktu_jadwal_umum") val waktu_jadwal_umum:String,
    @SerializedName("id_instruktur") val id_instruktur: Int,
    @SerializedName("nama_kelas") val nama_kelas: String,
    @SerializedName("nama_instruktur") val nama_instruktur: String,
    @SerializedName("keterangan_jadwal_harian") val keterangan_jadwal_harian:String,
)