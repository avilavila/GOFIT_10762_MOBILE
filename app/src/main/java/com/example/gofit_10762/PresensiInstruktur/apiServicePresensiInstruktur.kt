package com.example.gofit_10762.PresensiInstruktur

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

public interface apiServicePresensiInstruktur {
    @FormUrlEncoded
    @POST("api/presensi_instruktur/getData")
    fun getData(
        @Field("blank") blank:String):
            Call<ResponseCreateJadwalHarian>?

    @FormUrlEncoded
    @POST("api/presensi_instruktur/getJadwalHarian")
    fun getJadwalHarian(
        @Field("blank") blank:String):
            Call<ResponseCreateJadwalHarian>?

    @FormUrlEncoded
    @POST("api/presensi_instruktur")
    fun createData(
        @Field("id_instruktur") id_instruktur:Int,
        @Field("id_jadwal_harian") id_jadwal_harian:String,
        @Field("jam_mulai") jam_mulai:String,
    ):
            Call<ResponseCreatePresensiInstruktur>?

    @FormUrlEncoded
    @POST("api/presensi_instruktur/setSelesai")
    fun updateData(
        @Field("id_instruktur") id_instruktur:Int,
        @Field("id_jadwal_harian") id_jadwal_harian:String,
        @Field("jam_selesai") jam_selesai:String,
    ):
            Call<ResponseCreatePresensiInstruktur>?

    @FormUrlEncoded
    @POST("api/presensi_instruktur/getHistori")
    fun getHistori(
        @Field("id_instruktur") id_instruktur:String,
    ):
            Call<ResponseHistoriInstruktur>?
}