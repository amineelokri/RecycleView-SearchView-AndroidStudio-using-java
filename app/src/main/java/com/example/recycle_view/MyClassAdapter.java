package com.example.recycle_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyClassAdapter extends RecyclerView.Adapter<MyClassAdapter.MyViewHolder> {
    Context c;

    List<School> schools=new ArrayList<>();
    String names[],desc[];
    int images[];
    public MyClassAdapter(Context c, List<School>schools ) {
        this.c=c;
        this.schools=schools;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(c);
        View v=inflater.inflate(R.layout.template,parent,false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtdesc.setText(schools.get(position).getDesc());
        holder.txtnom.setText(schools.get(position).getName());
        holder.logo.setImageResource(schools.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtnom,txtdesc;
        ImageView logo;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            txtnom=itemView.findViewById(R.id.txtname);
            txtdesc=itemView.findViewById(R.id.txtdesc);
            logo=itemView.findViewById(R.id.logo);
        }


    }
    public void setFiltredList(List<School> names){

        this.schools=names;
        notifyDataSetChanged();
    }
}
