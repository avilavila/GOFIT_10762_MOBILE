package com.example.gofit_10762.BookingGym

import com.example.gofit_10762.IzinInstruktur.ResponseCreateIzinInstruktur
import retrofit2.Call
import retrofit2.http.*

interface apiServiceBookingGym {
    @GET("api/booking_presensi_gym")
    fun getBookingGym(): Call<ResponseCreateBookingGym>

    @FormUrlEncoded
    @POST("api/booking_presensi_gym/getData")
    fun getBookingUser(@Field("id") id:String?,):Call<ResponseCreateBookingGym>

    @FormUrlEncoded
    @POST("api/booking_presensi_gym")
    fun createData(
        @Field("id_member") id_member:String?,
        @Field("tanggal_booking_gym") tanggal_booking_gym:String?,
        @Field("slot_booking") slot_booking:String?,
    ):Call<ResponseCreateBookingGym>

    @FormUrlEncoded
    @POST("api/booking_presensi_gym/getHistori")
    fun getHistori(
        @Field("id_member") id_member:String?
    ):Call<ResponseCreateBookingGym>

    @DELETE("api/booking_presensi_gym/{id}")
    fun deleteData(@Path("id") id: String?
    ): Call<ResponseCreateBookingGym>
}