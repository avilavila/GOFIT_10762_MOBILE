package com.example.gofit_10762.User

import com.google.gson.annotations.SerializedName

class Member (
    @SerializedName("id_member") val id_member:String,
    @SerializedName("nama_member") val nama_member:String,
    @SerializedName("alamat_member") val alamat_member:String,
    @SerializedName("tanggal_lahir_member") val tanggal_lahir_member:String,
    @SerializedName("telepon_member") val telepon_member:String,
    @SerializedName("email_member") val email_member:String,
    @SerializedName("username_member") val username_member:String,
    @SerializedName("password_member") val password_member:String,
    @SerializedName("tanggal_kadaluarsa_member") val tanggal_kadaluarsa_member:String,
    @SerializedName("saldo_deposit") val saldo_deposit:String,
        )