package com.example.ships;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShipDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ship_detail);

        TextView home_port= findViewById(R.id.home_port);
        TextView ship_type= findViewById(R.id.ship_type);

        Bundle bundle = getIntent().getExtras();

        String mhome_port= bundle.getString("home_port");
        String mship_type= bundle.getString("ship_type");

        home_port.setText(mhome_port);
        ship_type.setText(mship_type);



    }

}
