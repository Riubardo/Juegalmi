package com.example.tabbedtienda.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabbedtienda.LoginDialogFragment;
import com.example.tabbedtienda.R;
import com.example.tabbedtienda.databinding.FragmentHomeBinding;
import com.example.tabbedtienda.ui.datos.RetroFittLlamadas;
import com.example.tabbedtienda.ui.models.Plataforma;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

	// RecyclerView
	RecyclerView recyclerView;
	RecyclerView.Adapter rvAdapter;
	RecyclerView.LayoutManager rvLayoutManger;
	ArrayList<Plataforma> listaPlataformas;
	ImageButton userButton;
	Context context;
	public FragmentManager fragmentManager;

	private LoginDialogFragment dialog = null;
	private HomeViewModel homeViewModel;
	private FragmentHomeBinding binding;

	public FragmentManager getHomeFM(){
		return fragmentManager;
	}

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home, null);
		// RecyclerView Categoria Setup
		recyclerView = (RecyclerView) view.findViewById(R.id.recyclerHome);
		rvLayoutManger = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(rvLayoutManger);
		Log.d("IMPORTANTE", "pasas");

		listaPlataformas = homeViewModel.devuelveLista();

		rvAdapter = new AdaptadorPlataforma(this, listaPlataformas);
		recyclerView.setAdapter(rvAdapter);

		userButton = (ImageButton) view.findViewById(R.id.userButton);
		userButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog = new LoginDialogFragment();
				dialog.show(fragmentManager, "login");

			}
		});

		return view;

	}


	@Override
	public void onAttach(@NonNull Context context) {
		super.onAttach(context);
		this.context=context;
		fragmentManager = getChildFragmentManager();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

}