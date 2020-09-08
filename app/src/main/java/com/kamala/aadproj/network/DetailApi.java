package com.kamala.aadproj.network;

import com.kamala.aadproj.models.Hours;
import com.kamala.aadproj.models.Skill;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DetailApi {
    @GET("hours")
    Call<List<Hours>>getDetailHours();
    @GET("skilliq")
    Call<List<Skill>>getDetailSkill();


}
