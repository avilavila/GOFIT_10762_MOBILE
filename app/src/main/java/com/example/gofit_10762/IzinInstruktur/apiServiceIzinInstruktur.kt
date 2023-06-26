package com.example.gofit_10762.IzinInstruktur

import retrofit2.Call
import retrofit2.http.*

public interface apiServiceIzinInstruktur {
    @GET("api/izin_instruktur/{cari}")
    fun getIzin(@Path("cari") cari: String?): Call<ResponseCreateIzinInstruktur>

    @FormUrlEncoded
    @POST("api/search/{cari}")
    fun search(
        @Field("cari") cari:String?
    ): Call<ResponseCreateIzinInstruktur>

    @GET("api/instruktur/{id}")
    fun getInstruktur(
        @Path("id") id:String?
    ): Call<ResponseCreateInstruktur>

    @FormUrlEncoded
    @POST("api/izin_instruktur")
    fun createData(
        @Field("id_instruktur") idInstruktur:String?,
        @Field("id_instruktur_pengganti") idInstrukturPengganti: String,
        @Field("keterangan_izin") keteranganIzin:String?,
        @Field("tanggal_izin") tanggalIzin:String?,
        @Field("sesi_izin") sesiIzin:String?
    ):Call<ResponseCreateIzinInstruktur>

    @FormUrlEncoded
    @POST("api/izin_instruktur/getId")
    fun getIdInstruktur(@Field("id_instruktur") idInstruktur:String?,):Call<ResponseCreateIzinInstruktur>
}