package com.example.gofit_10762.PresensiInstruktur

import com.google.gson.annotations.SerializedName

class HistoriInstruktur (
    @SerializedName("id_presensi_instruktur") val id_presensi_instruktur: String?,
    @SerializedName("id_instruktur") val id_instruktur:String,
    @SerializedName("id_jadwal_harian") val id_jadwal_harian :String,
    @SerializedName("jam_mulai") val jam_mulai :String,
    @SerializedName("jam_selesai") val jam_selesai :String,
    @SerializedName("keterlambatan") val keterlambatan :String,
    @SerializedName("durasi_kelas") val durasi_kelas :String,
    @SerializedName("status") val status :String,
    @SerializedName("nama_kelas") val nama_kelas :String,
    @SerializedName("hari_jadwal_umum") val hari_jadwal_umum :String,
    @SerializedName("tanggal_Jadwal_harian") val tanggal_Jadwal_harian :String,
)