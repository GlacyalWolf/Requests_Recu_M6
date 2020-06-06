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


    public RecyclerFireViewModel(){
        repo=Repository.getRepository();


    }

    public void getClientes() {
        repo.getCiud();
    }
}