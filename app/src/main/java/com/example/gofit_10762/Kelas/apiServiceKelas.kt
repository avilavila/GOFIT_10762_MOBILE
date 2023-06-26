package com.example.gofit_10762.Kelas

import com.example.gofit_10762.BookingGym.ResponseCreateBookingGym
import retrofit2.Call
import retrofit2.http.*

interface apiServiceKelas {
    @GET("api/kelas")
    fun getKelas(): Call<ResponseCreateKelas>

    @FormUrlEncoded
    @POST("api/kelas")
    fun createData(
        @Field("id_kelas") idMember:String?,
    ): Call<ResponseCreateKelas>

    @DELETE("api/kelas/{id}")
    fun deleteData(@Path("id") id: String?
    ): Call<ResponseCreateKelas>
}