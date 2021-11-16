package com.example.tabbedtienda.ui.datos;

import com.example.tabbedtienda.ui.models.Plataforma;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetroFittLlamadas {
    @GET("plataformas/stock")
    Call<List<Plataforma>> getPlataformas();
}
