package com.example.tabbedtienda.ui.home;

import static com.example.tabbedtienda.retrofit.LlamadasBBDD.getPosts;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.example.tabbedtienda.ui.models.Plataforma;

import java.util.ArrayList;

public class AsyncTaskClass extends AsyncTask<String, Integer, ArrayList<Plataforma>> {

	Context context;

	//-----> CONSTRUCTOR
	public AsyncTaskClass(Context context){
		this.context = context;
	}

	//-----> DO IN BACKGROUND
	@Override
	protected ArrayList<Plataforma> doInBackground(String... strings){
		ArrayList<Plataforma> listaPlataformas = getPosts();
		return listaPlataformas;
	}

}
