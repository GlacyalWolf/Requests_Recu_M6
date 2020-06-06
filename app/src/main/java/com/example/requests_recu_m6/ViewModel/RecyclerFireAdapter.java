package com.example.requests_recu_m6.ViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.requests_recu_m6.Model.Ciudadano;
import com.example.requests_recu_m6.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerFireAdapter extends RecyclerView.Adapter<RecyclerFireAdapter.ViewHolder> {
    ArrayList<Ciudadano> listc= new ArrayList<>();

    public RecyclerFireAdapter(ArrayList<Ciudadano> listc) {
        this.listc = listc;
    }

    public void setCiudadano(ArrayList<Ciudadano> lc){
        this.listc=lc;
    }

    @NonNull
    @Override
    public RecyclerFireAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_fire_holder,
                parent,false);

        return new RecyclerFireAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerFireAdapter.ViewHolder holder, int position) {
        String nombre=listc.get(position).getNom();
        String dni=listc.get(position).getDni();
        String ciudad=listc.get(position).getCiudad();

        holder.dni.setText(dni);
        holder.ciudad.setText(ciudad);
        holder.nombre.setText(nombre);
    }

    @Override
    public int getItemCount() {
        return listc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre,dni,ciudad;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.fTextNom);
            dni=itemView.findViewById(R.id.fTextDni);
            ciudad=itemView.findViewById(R.id.fTextCiudad);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Bundle
                }
            });
        }
    }
}
