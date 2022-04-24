package com.example.ships;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShipAdapter extends RecyclerView.Adapter<ShipAdapter.ViewHolder> {
    private List<ShipModal>shipList;

    public ShipAdapter(List<ShipModal> shipList) {
        this.shipList = shipList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ship_item, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      //  holder.ship_image.setImageAlpha(shipList.get(position).getImage());
        holder.ship_id.setText(shipList.get(position).getShip_id());
        holder.ship_name.setText(shipList.get(position).getShip_name());

    }

    @Override
    public int getItemCount() {
        return shipList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView ship_id;
        TextView ship_name;
        ImageView ship_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ship_image=itemView.findViewById(R.id.ship_image);
            ship_name= itemView.findViewById(R.id.ship_name);
            ship_id=itemView.findViewById(R.id.ship_id);
        }
    }
}
