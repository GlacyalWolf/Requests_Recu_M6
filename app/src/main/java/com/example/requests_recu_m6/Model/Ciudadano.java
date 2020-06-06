package com.example.requests_recu_m6.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class Ciudadano {
    String nom,dni,ciudad;

    public Ciudadano(){

    }

    public Ciudadano(JSONObject jsonObject){
        try {

            nom=jsonObject.getString("nom");
            dni=jsonObject.getString("dni");
            ciudad=jsonObject.getString("ciudad");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getNom() {
        return nom;
    }

    public String getDni() {
        return dni;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
