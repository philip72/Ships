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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.ErrorListener;


public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<ShipModal> shipList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();
        shipList= new ArrayList<>();
        fetchShip();

    }

    private void fetchShip() {
        String url= "https://api.spacexdata.com/v3/ships";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(1);
                        String ship_name= jsonObject.getString("ship_name");
                        String ship_id= jsonObject.getString("ship_id");
                        String ship_type=jsonObject.getString("ship_type");
                        String home_port=jsonObject.getString("home_port");
                        String image =jsonObject.getString("image");

                        ShipModal ship = new ShipModal(ship_id,ship_name,ship_type,home_port,image);
                        shipList.add(ship);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    ShipAdapter adapter= new ShipAdapter(MainActivity.this, shipList);
                    recyclerView.setAdapter(adapter);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonArrayRequest);
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