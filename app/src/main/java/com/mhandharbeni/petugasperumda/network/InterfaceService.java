package com.mhandharbeni.petugasperumda.network;


import com.mhandharbeni.petugasperumda.room.entity.ResponseData;
import com.mhandharbeni.petugasperumda.room.entity.ResponseList;
import com.mhandharbeni.petugasperumda.room.entity.data.DataPegawai;
import com.mhandharbeni.petugasperumda.room.entity.data.DataToken;
import com.mhandharbeni.petugasperumda.room.entity.data.ListJenisAduan;
import com.mhandharbeni.petugasperumda.room.entity.data.ListKelasAduan;
import com.mhandharbeni.petugasperumda.room.entity.data.ListPegawaiUnit;
import com.mhandharbeni.petugasperumda.room.entity.data.ListPengaduanUnit;
import com.mhandharbeni.petugasperumda.room.entity.data.ListWOPetugas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceService {

    @FormUrlEncoded
    @POST("pelanggan/ctoken")
    Call<ResponseData<DataToken>> cToken(
            @Field("device_id") String device_id
    );

    @FormUrlEncoded
    @POST("pegawai/loginpegawai")
    Call<ResponseData> login(
            @Field("np") String np,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("pegawai/datapegawai")
    Call<ResponseData<DataPegawai>> getDataPegawai(
            @Field("token") String token,
            @Field("np") String np
    );

    @FormUrlEncoded
    @POST("pegawai/listpengaduanunit")
    Call<ResponseList<ListPengaduanUnit>> getListPengaduanUnit(
            @Field("token") String token,
            @Field("kdunit") String kdunit
    );

    @FormUrlEncoded
    @POST("pegawai/listpegawaibyunit")
    Call<ResponseList<ListPegawaiUnit>> getListPegawaiUnit(
            @Field("token") String token,
            @Field("kdunit") String kdunit
    );

    @POST("pegawai/jenisaduan")
    Call<ResponseList<ListJenisAduan>> getJenisAduan();

    @POST("pegawai/kelasaduan")
    Call<ResponseList<ListKelasAduan>> getKelasAduan();

    @FormUrlEncoded
    @POST("pegawai/getlistwopetugas")
    Call<ResponseList<ListWOPetugas>> getListWOPetugas(
            @Field("token") String token,
            @Field("nppetugas") String np
    );
}
