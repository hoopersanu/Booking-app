package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.MyAdapter> {


    private List<HomeFragmentList> listItems;
    private Context context;

    public HomeFragmentAdapter(List<HomeFragmentList> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_home_list,parent,false);
        return new MyAdapter(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        public TextView textView1;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.textViewHome);

        }
    }
}
