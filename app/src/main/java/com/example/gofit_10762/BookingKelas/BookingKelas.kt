package com.example.gofit_10762.BookingKelas

import com.google.gson.annotations.SerializedName

class BookingKelas (
    @SerializedName("no_struk_presensi_kelas") val no_struk_presensi_kelas: String?,
    @SerializedName("id_member") val id_member:String,
    @SerializedName("id_jadwal_harian") val id_jadwal_harian:String,
    @SerializedName("jenis_booking_kelas") val jenis_booking_kelas :String,
    @SerializedName("jam_presensi_kelas") val jam_presensi_kelas : String,
    @SerializedName("status_presensi_kelas") val status_presensi_kelas : String,
    @SerializedName("tanggal_pembuatan_booking_kelas") val tanggal_pembuatan_booking_kelas :String,
    @SerializedName("hari_jadwal_umum") val hari_jadwal_umum : String,
    @SerializedName("tanggal_jadwal_harian") val tanggal_jadwal_harian : String,
    @SerializedName("nama_kelas") val nama_kelas : String,
    @SerializedName("nama_member") val nama_member : String,
    )