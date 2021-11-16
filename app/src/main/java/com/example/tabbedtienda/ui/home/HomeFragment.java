package com.example.tabbedtienda.ui.home;

import android.content.Context;
import android.os.Bundle;
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
import com.example.tabbedtienda.ui.models.Plataforma;

import java.util.ArrayList;

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
		/*
		homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
		binding = FragmentHomeBinding.inflate(inflater, container, false);
		View root = binding.getRoot();
		final TextView textView = binding.tvHome;
		homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
			@Override
			public void onChanged(@Nullable String s) {
				textView.setText(s);
			}
		});
		return root;
		*/
		View view = inflater.inflate(R.layout.fragment_home, null);

		// RecyclerView Categoria Setup
		recyclerView = (RecyclerView) view.findViewById(R.id.recyclerHome);
		rvLayoutManger = new LinearLayoutManager(getActivity());
		recyclerView.setLayoutManager(rvLayoutManger);

		//listaPlataformas = new ArrayList<>();
		listaPlataformas = devuelveLista();
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

		//loadPlataformas(); <- vacio, mas adelante cargar datos acá

		return view;

	}

	private ArrayList<Plataforma> devuelveLista(){
		//String supuestoResponse = VolleyGET.crearRequest("plataformas/stock").toString();

		//ArrayList<Plataforma> listaPlataformas = getPosts();
		//Log.e("", "DevuelveLista tiene en lista:" + listaPlataformas.size());
		return listaPlataformas;
	}

	private void loadPlataformas(){

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