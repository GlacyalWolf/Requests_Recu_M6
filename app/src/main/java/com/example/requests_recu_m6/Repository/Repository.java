package com.example.requests_recu_m6.Repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.requests_recu_m6.Model.Ciudadano;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Repository {

    private MutableLiveData<ArrayList<Ciudadano>> listaciud;
    private Context context;
    private static Repository repository;
    private ArrayList<Ciudadano> list= new ArrayList<>();



    private  Repository(Context context){
        this.context = context;
        listaciud= new MutableLiveData<>();

    }

    public static Repository get(Context context){
        if(repository == null){
            repository = new Repository(context);
        }
        return repository;
    }


    public static Repository getRepository(){return repository;}



    public void getCiud() {
        myThread hilo = new myThread();
        hilo.execute("https://projecterecum8.firebaseio.com/examen/value.json");
    }

    public LiveData<ArrayList<Ciudadano>> getLiveList(){
        return listaciud;
    }


    public class myThread extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection;
            URL url;
            String result;
            result ="";

            try{

                url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();

                int data = inputStream.read();

                while(data != -1){
                    result += (char) data;
                    data = inputStream.read();
                }

            }catch (Exception e){

                e.printStackTrace();

            }

            Log.i("RESULT", result);



            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ArrayList<Ciudadano> listcontact= new ArrayList<>();
            // tratamiento del json
            try {
                JSONArray jsonArray = new JSONArray(s);
                for(int i=0; i<jsonArray.length();i++){
                    JSONObject jsonObject;
                    jsonObject = jsonArray.getJSONObject(i);
                    // passar a arraylist de Contactos

                    Ciudadano ciudadano = new Ciudadano(jsonObject);
                    listcontact.add(ciudadano);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            listaciud.postValue(listcontact);


        }
    }




}
