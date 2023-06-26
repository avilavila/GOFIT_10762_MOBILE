package com.example.gofit_10762.BookingKelas

import retrofit2.Call
import retrofit2.http.*

interface apiServiceBookingKelas {
    @GET("api/booking_presensi_kelas")
    fun getBookingKelas(): Call<ResponseCreateBookingKelas>

    @FormUrlEncoded
    @POST("api/booking_presensi_kelas/getJadwalHarian")
    fun getJadwalHarian(@Field("blank") blank:String?,): Call<ResponseCreateJadwalHarian>

    @FormUrlEncoded
    @POST("api/booking_presensi_kelas/getDataBooking")
    fun getDataBooking(
        @Field("id_member") idMember:String?
    ):Call<ResponseCreateBookingKelas>

    @FormUrlEncoded
    @POST("api/booking_presensi_kelas/getDataBookingInstruktur")
    fun getDataBookingInstruktur(
        @Field("id_instruktur") idInstruktur:String?
    ):Call<ResponseCreateBookingKelas>

    @FormUrlEncoded
    @POST("api/booking_presensi_kelas/getHistori")
    fun getHistori(
        @Field("id_member") id_member:String?
    ):Call<ResponseCreateBookingKelas>

    @FormUrlEncoded
    @POST("api/booking_presensi_kelas")
    fun createData(
        @Field("id_member") idMember:String?,
        @Field("id_jadwal_harian") idJadwalHarian:String?
    ): Call<ResponseCreateJadwalHarian>

    @FormUrlEncoded
    @POST("api/booking_presensi_kelas/presensi")
    fun setHadir(
        @Field("id_member") idMember:String?,
        @Field("id_jadwal_harian") idJadwalHarian:String?,
        @Field("jam_presensi_kelas") jam:String?,
    ):Call<ResponseCreateJadwalHarian>

    @FormUrlEncoded
    @POST("api/booking_presensi_kelas/setTidakHadir")
    fun setTidakHadir(
        @Field("id_member") idMember:String?,
        @Field("id_jadwal_harian") idJadwalHarian:String?,
        @Field("jam_presensi_kelas") jam:String?,
    ):Call<ResponseCreateJadwalHarian>

    @DELETE("api/booking_presensi_kelas/{id}")
    fun deleteData(@Path("id") id: String?
    ): Call<ResponseCreateBookingKelas>
}