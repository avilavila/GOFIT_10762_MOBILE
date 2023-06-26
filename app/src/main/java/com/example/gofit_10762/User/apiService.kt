package com.example.gofit_10762.User

import retrofit2.Call
import retrofit2.http.*

public interface apiService {
    @GET("api/users")
    open fun getUser(): Call<ResponseUser?>?

    @GET("api/member/{id}")
    open fun getMember(@Path("id") id:String?): Call<ResponseCreateMember?>?

    @GET("api/pegawai/{id}")
    open fun getMO(@Path("id") id:String?): Call<ResponseCreateMO?>?

    @FormUrlEncoded
    @POST("api/login")
    fun login(
        @Field("email") email:String,
        @Field("password") password:String):
            Call<ResponseCreate>?

    @FormUrlEncoded
    @POST("api/deposit_kelas_member/getData")
    fun getDepositKelasMember(
        @Field("id_member") id_member:String):
            Call<ResponseCreateDepositKelasMember>?
}