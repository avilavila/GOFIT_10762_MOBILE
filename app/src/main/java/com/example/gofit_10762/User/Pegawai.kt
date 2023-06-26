package com.example.gofit_10762.User

import com.google.gson.annotations.SerializedName

class Pegawai (
    @SerializedName("id_pegawai") val id_pegawai:String,
    @SerializedName("nama_pegawai") val nama_pegawai:String,
    @SerializedName("jabatan") val jabatan:String,
    @SerializedName("alamat_pegawai") val ALAMAT_PEGAWAI:String,
    @SerializedName("telepon_pegawai") val telepon_pegawai:String,
    @SerializedName("email_pegawai") val email_pegawai:String,
    @SerializedName("username_pegawai") val username_pegawai:String,
    @SerializedName("password_pegawai") val password_pegawai:String
)