package com.example.tabbedtienda.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeViewModel extends ViewModel implements Callback<List<Plataforma>> {

	private ArrayList<Plataforma> listaPlataformas;
	private MutableLiveData<String> mText;

	public HomeViewModel() {
		mText = new MutableLiveData<>();
		mText.setValue("This is home fragment");
	}
	public ArrayList<Plataforma> devuelveLista(){
		Gson gson = new GsonBuilder()
				.setLenient()
				.create();
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://arkadio.duckdns.org/ws/")
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();
		RetroFittLlamadas retroFittLlamadas = retrofit.create(RetroFittLlamadas.class);
		Call<List<Plataforma>> call = retroFittLlamadas.getPlataformas();
		call.enqueue(this);
		return listaPlataformas;
	}
	public LiveData<String> getText() {
		return mText;
	}

	@Override
	public void onResponse(Call<List<Plataforma>> call, Response<List<Plataforma>> response) {
		if(response.isSuccessful()) {
			List<Plataforma> plataformaList = response.body();
		} else {
			System.out.println(response.errorBody());
		}
	}
	@Override
	public void onFailure(Call<List<Plataforma>> call, Throwable t) {
		t.printStackTrace();
	}
}