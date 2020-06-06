package com.example.requests_recu_m6.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.requests_recu_m6.Model.Ciudadano;
import com.example.requests_recu_m6.Repository.Repository;

import java.util.ArrayList;

public class RecyclerFireViewModel extends ViewModel {
    Repository repo;
    public ArrayList<Ciudadano> listac= new ArrayList<>();
    MutableLiveData<ArrayList<Ciudadano>> livelistac;


    public RecyclerFireViewModel(){
        repo=Repository.getRepository();
        listac = new ArrayList<>();
        livelistac= new MutableLiveData<ArrayList<Ciudadano>>();


    }

    public void getClientes() {
        repo.getCiud();
        repo.getLiveList().observeForever(new Observer<ArrayList<Ciudadano>>() {
            @Override
            public void onChanged(ArrayList<Ciudadano> ciudadanos) {
                listac = ciudadanos;
                livelistac.postValue(listac);

            }
        });
    }

    public LiveData<ArrayList<Ciudadano>> getLiveList(){
        return livelistac;
    }


}