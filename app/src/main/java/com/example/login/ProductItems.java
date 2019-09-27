package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductItems extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private String urlJsonArry = "https://jsonplaceholder.typicode.com/users";
    private List<ProductListItems> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_items);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewProduct);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerViewProduct);

//      MyAdapter myadapter = new MyAdapter(this,listItems);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
//      myrv.setAdapter(myadapter);



        mTextViewResult = (TextView) findViewById(R.id.textViewTitle);
        listItems = new ArrayList<>();

        mQueue = Volley.newRequestQueue(this);
        jsonParse();

    }


//    public void btnPhoneNumber(View view) {
//        Intent intent = new Intent(this,PhonenumberProvide.class);
//        startActivity(intent);
//    }
//
//    public void btnloader(View view) {
//        Intent intent = new Intent(this,Booking_Received_Form.class);
//        startActivity(intent);
//    }
//
//    public void btn_conformed(View view) {
//        Intent intent = new Intent(this,BookingConformed_Msg.class);
//        startActivity(intent);
//    }
//
//    public void btnshows(View view) {
//        Intent intent = new Intent(this,Infromation_Form.class);
//        startActivity(intent);
//    }


    private void jsonParse(){
//        String url = "https://api.myjson.com/bins/kp9wz";

        JsonArrayRequest req = new JsonArrayRequest(urlJsonArry,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();

                                JSONObject person = (JSONObject) response
                                        .get(i);

                                String name = person.getString("name");

                                ProductListItems item = new ProductListItems(
                                        person.getString("name")
                                );

                                listItems.add(item);
                                adapter = new ProductListAdapter(listItems,getApplicationContext());
                                recyclerView.setAdapter(adapter);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(req);
    }

}
