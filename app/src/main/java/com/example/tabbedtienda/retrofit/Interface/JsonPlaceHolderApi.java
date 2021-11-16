package com.example.tabbedtienda.retrofit.Interface;

import com.example.tabbedtienda.ui.models.Plataforma;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

	@GET("plataformas/stock")
	Call<List<Plataforma>> getPosts();
}
