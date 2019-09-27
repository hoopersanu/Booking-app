package com.example.login;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.w3c.dom.Text;


public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.viewHolder> {

    private List<ProductListItems> listItems;

    public ProductListAdapter(List<ProductListItems> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    private Context context;


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item_list,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ProductListItems listItem = listItems.get(position);
        holder.textView1.setText(listItem.getTextview());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        public TextView textView1;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.textViewTitle);
        }
    }
}
