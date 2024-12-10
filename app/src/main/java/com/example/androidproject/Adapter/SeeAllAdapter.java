package com.example.androidproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.Domain.ItemDomain;
import com.example.androidproject.R;

import java.util.List;

public class SeeAllAdapter extends RecyclerView.Adapter<SeeAllAdapter.ViewHolder> {
    private final List<ItemDomain> items;

    public SeeAllAdapter(List<ItemDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_seeall, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the current item from the list
        ItemDomain currentItem = items.get(position);

        // Bind data to views
        holder.itemTitle.setText(currentItem.getTitle());
        holder.itemSubtitle.setText(currentItem.getAddress()); // Use the location as the subtitle
        holder.itemPrice.setText("$" + currentItem.getPrice());
        holder.itemRating.setText(currentItem.getScore() + " ★");

        // Set the image resource
        holder.itemImage.setImageResource(currentItem.getPic());

        // Optional: Handle description if needed
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemTitle, itemSubtitle, itemPrice, itemRating;
        ImageView itemImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemSubtitle = itemView.findViewById(R.id.itemSubtitle);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            itemRating = itemView.findViewById(R.id.itemRating);
            itemImage = itemView.findViewById(R.id.itemImage);
        }
    }
}
