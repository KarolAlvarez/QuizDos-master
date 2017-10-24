package com.jonmid.quizdos.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.quizdos.Models.UserModelAlvarezKarol;
import com.jonmid.quizdos.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/10/17.
 */

public class UserAdapterAlvarezKarol extends RecyclerView.Adapter<UserAdapterAlvarezKarol.ViewHolder> {


    List<UserModelAlvarezKarol> userModelAlvarezKarolList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public UserAdapterAlvarezKarol(List<UserModelAlvarezKarol> UserList, Context context) {
        this.userModelAlvarezKarolList = UserList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_user, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        //Picasso.with(context).load(userModelAlvarezKarolList.get(position).getArrayPhotos()).into((holder.foto));

        // Encargado de trabajar con el item.xml y sus componentes
        holder.name.setText(userModelAlvarezKarolList.get(position).getName());
        holder.userName.setText(userModelAlvarezKarolList.get(position).getUsername());
        holder.email.setText(userModelAlvarezKarolList.get(position).getEmail());
        holder.phone.setText(userModelAlvarezKarolList.get(position).getPhone());
        holder.nameCompany.setText(userModelAlvarezKarolList.get(position).getNameCompany());
        holder.address.setText(userModelAlvarezKarolList.get(position).getAddress());



    }

    @Override
    public int getItemCount() {
        return userModelAlvarezKarolList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView name,userName,email,phone,nameCompany,address;

        ImageView foto;

        public ViewHolder(View item) {
            super(item);

            foto=(ImageView)item.findViewById(R.id.fotoUser);
            name= (TextView)item.findViewById(R.id.id_tv_userinput_name);
            userName=(TextView)item.findViewById(R.id.id_tv_userinput_username);
            email= (TextView)item.findViewById(R.id.id_tv_userinput_email);
            phone= (TextView)item.findViewById(R.id.id_tv_userinput_email);
            nameCompany= (TextView)item.findViewById(R.id.id_tv_userinput_namecompany);
            address =(TextView)item.findViewById(R.id.id_tv_userinput_address);
        }


    }


}
