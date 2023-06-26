package com.example.gofit_10762.BookingGym

import com.google.gson.annotations.SerializedName

class BookingGym (
    @SerializedName("no_struk_presensi_gym") val no_struk_presensi_gym: String?,
    @SerializedName("id_member") val id_member:String,
    @SerializedName("tanggal_booking_gym") val tanggal_booking_gym :String,
    @SerializedName("tanggal_pembuatan_booking_gym") val tanggal_pembuatan_booking_gym :String,
    @SerializedName("slot_booking") val slot_booking : String,
    @SerializedName("status_presensi_gym") val status_presensi_gym : String,
    @SerializedName("jam_presensi_gym") val jam_presensi_gym : String
)