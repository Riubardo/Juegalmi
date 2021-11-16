package com.example.tabbedtienda.retrofit;

import android.util.Log;

import com.example.tabbedtienda.retrofit.Interface.JsonPlaceHolderApi;
import com.example.tabbedtienda.ui.models.Plataforma;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LlamadasBBDD {

	private static ArrayList<Plataforma> listaPlataformas = new ArrayList<Plataforma>();

	public static ArrayList<Plataforma> getPosts(){

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://arkadio.duckdns.org/ws/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

		Call<List<Plataforma>> call = jsonPlaceHolderApi.getPosts();
		call.enqueue(new Callback<List<Plataforma>>() {
			@Override
			public void onResponse(Call<List<Plataforma>> call, Response<List<Plataforma>> response) {

				if(!response.isSuccessful()){
					Log.e("", "No exitoso");
					return;
				}
				Log.e("", "DATOS RECIBIDOS");
				listaPlataformas = new ArrayList<Plataforma>(response.body());
				Log.e("","ON RESPONSE tiene "+listaPlataformas.size());
			}

			@Override
			public void onFailure(Call<List<Plataforma>> call, Throwable t) {
				Log.e("", "Fallo");
			}
		});

		return listaPlataformas;

	}
}
