package com.example.ships;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    ShipAdapter shipAdapter;
    List<ShipModal> shipModalList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        shipAdapter =new ShipAdapter(shipModalList);
        recyclerView.setAdapter(shipAdapter);


    }
    private void fetchShips(){
        progressBar.setVisibility(View.VISIBLE);
        RequestManager.requestManager().getShips().enqueue(new Callback<List<ShipModal>>() {
            @Override
            public void onResponse(Call<List<ShipModal>> call, Response<List<ShipModal>> response) {
                if (response.isSuccessful()&& response.body() !=null){
                    shipModalList.addAll(response.body());
                    shipAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<List<ShipModal>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    public boolean  onCreateOptionMenu(Menu filter){
        getMenuInflater().inflate(R.menu.filter, filter);
        MenuItem item = filter.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(filter);
    }
}