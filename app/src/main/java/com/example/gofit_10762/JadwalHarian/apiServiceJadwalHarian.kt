package com.example.gofit_10762.JadwalHarian

import com.example.gofit_10762.Kelas.ResponseCreateKelas
import retrofit2.Call
import retrofit2.http.GET

interface apiServiceJadwalHarian {
    @GET("api/jadwal_harian")
    fun getJadwalHarian(): Call<ResponseCreateJadwalHarian>
}