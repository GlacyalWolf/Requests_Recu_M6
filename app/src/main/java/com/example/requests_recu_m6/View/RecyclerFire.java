package com.example.requests_recu_m6.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.requests_recu_m6.Model.Ciudadano;
import com.example.requests_recu_m6.R;
import com.example.requests_recu_m6.Repository.Repository;
import com.example.requests_recu_m6.ViewModel.RecyclerFireAdapter;
import com.example.requests_recu_m6.ViewModel.RecyclerFireViewModel;

import java.util.ArrayList;

public class RecyclerFire extends Fragment {

    private ArrayList<Ciudadano> listciu= new ArrayList<>();
    private RecyclerView miRecycler;
    private RecyclerFireAdapter miAdapter;


    private RecyclerFireViewModel mViewModel;

    public static RecyclerFire newInstance() {
        return new RecyclerFire();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(RecyclerFireViewModel.class);
        View root= inflater.inflate(R.layout.recycler_fire_fragment, container, false);


        miRecycler=root.findViewById(R.id.RecyclerFire);
        miRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        miAdapter= new RecyclerFireAdapter(listciu);
        miRecycler.setAdapter(miAdapter);




        mViewModel.getLiveList().observe(getViewLifecycleOwner(), new Observer<ArrayList<Ciudadano>>() {
            @Override
            public void onChanged(ArrayList<Ciudadano> ciudadanos) {
                miAdapter.setCiudadano(ciudadanos);
                miAdapter.notifyDataSetChanged();
            }
        });














        return root;
    }





}