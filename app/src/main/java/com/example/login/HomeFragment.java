package com.example.login;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{
//    private TextView mTextViewResult;
    private RequestQueue mQueue;

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;

    private RecyclerView.Adapter adapter;
    private String urlJsonArry = "https://jsonplaceholder.typicode.com/users";
    private List<HomeFragmentList> listItems;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View v = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewHome);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView myrv = (RecyclerView) v.findViewById(R.id.recyclerViewHome);

//      MyAdapter myadapter = new MyAdapter(this,listItems);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),2));


        listItems = new ArrayList<>();

        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        jsonParse();


        return v;
    }
    private void jsonParse(){
//        String url = "https://api.myjson.com/bins/kp9wz";

        JsonArrayRequest req = new JsonArrayRequest(urlJsonArry,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                Toast.makeText(getActivity().getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();

                                JSONObject person = (JSONObject) response
                                        .get(i);

                                String name = person.getString("name");

                                HomeFragmentList item = new HomeFragmentList(
                                        person.getString("name")
                                );

                                listItems.add(item);
                                adapter = new HomeFragmentAdapter(listItems,getActivity().getApplicationContext());
                                recyclerView.setAdapter(adapter);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity().getApplicationContext(),
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
