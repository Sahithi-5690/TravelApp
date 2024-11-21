package com.example.androidproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidproject.Activity.DetailActivity;
import com.example.androidproject.Domain.ItemDomain;
import com.example.androidproject.R;
import com.example.androidproject.databinding.ViewholderRecommendedBinding;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.Viewholder> {
    ArrayList<ItemDomain> items;
    Context context;

    public RecommendedAdapter(ArrayList<ItemDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewholderRecommendedBinding binding = ViewholderRecommendedBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        // Get the current ItemDomain object
        ItemDomain item = items.get(position);
        // Set text and other data
        holder.titleTxt.setText(item.getTitle());
        holder.priceTxt.setText("$" + item.getPrice());
        holder.addressTxt.setText(item.getAddress());
        holder.scoreTxt.setText(String.valueOf(item.getScore()));
        // Load the image from the URL using Glide
        Glide.with(context)
                .load(item.getPic())
                .into(holder.pic);
        holder.itemView.setOnClickListener(v -> {
             //Intent to navigate to DetailActivity (if needed)
             Intent intent = new Intent(context, DetailActivity.class);
             intent.putExtra("object", item);  // Pass the item object (ensure ItemDomain implements Parcelable or Serializable)
             context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class Viewholder extends RecyclerView.ViewHolder {
        // Declare references to the views in the layout
        TextView titleTxt, priceTxt, addressTxt, scoreTxt;
        ImageView pic;
        // Constructor that accepts the binding object to access views
        public Viewholder(ViewholderRecommendedBinding binding) {
            super(binding.getRoot());
            // Initialize the views with the binding object
            titleTxt = binding.titleTxt;
            priceTxt = binding.priceTxt;
            addressTxt = binding.addressTxt;
            scoreTxt = binding.scoreTxt;
            pic = binding.pic; // ImageView for the image
        }
    }
}