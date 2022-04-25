package com.example.ships;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ShipAdapter extends RecyclerView.Adapter<ShipAdapter.ShipHolder> {
    private Context context;
    private List<ShipModal> shipModalList;

    public ShipAdapter(Context context, List<ShipModal>shipModals){
        this.context=context;
        shipModalList=shipModals;
    }

    @NonNull
    @Override
    public ShipHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ship_item ,parent, false);
        return new ShipHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShipHolder holder, int position) {
        ShipModal ship = shipModalList.get(position);
        holder.ship_name.setText(ship.getShip_name());
        holder.ship_id.setText(ship.getShip_id());
        holder.ship_type.setText(ship.getShip_type());
        holder.home_port.setText(ship.getHome_port());
        Glide.with(context).load(ship.getImage()).into(holder.imageView);
        holder.bottom_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShipDetail.class);

                Bundle bundle = new Bundle();
                bundle.putString("home_port", ship.getHome_port());
                bundle.putString("ship_type", ship.getShip_type());

                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return shipModalList.size();
    }

    public class ShipHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView ship_id, ship_name, ship_type, home_port;
        ConstraintLayout bottom_drawer;

        public ShipHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.image);
            ship_id= itemView.findViewById(R.id.ship_id);
            ship_name=itemView.findViewById(R.id.ship_name);
            ship_type=itemView.findViewById(R.id.ship_type);
            home_port=itemView.findViewById(R.id.home_port);
            bottom_drawer=itemView.findViewById(R.id.bottom_drawer);
        }
    }

}
