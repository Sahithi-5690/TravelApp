package com.example.androidproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidproject.Domain.Category;
import com.example.androidproject.R;
import com.example.androidproject.databinding.ViewholderCategoryBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewholder> {
    private List<Category> items; // List to hold category data
    private int currentlyVisiblePosition = -1; // Tracks which item's title is currently visible

    // Constructor to initialize the adapter with category data
    public CategoryAdapter(List<Category> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the view for the ViewHolder using the layout resource
        View viewz = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new Viewholder(viewz);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.Viewholder holder, int position) {
        Category item = items.get(position); // Get the category item at the current position

        // Set the image and title for the ViewHolder
        holder.imageView.setImageResource(item.getImageResourceId()); // Set image from drawable
        holder.titleTextView.setText(item.getTitle());

        // Initially, hide the title and remove the background for the item view
        holder.titleTextView.setVisibility(View.GONE);
        holder.itemView.setBackgroundResource(0); // Remove background

        // If the current item's title is the one that's visible, display it and set the background
        if (currentlyVisiblePosition == position) {
            holder.titleTextView.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundResource(R.drawable.blue_bg); // Set background
        }

        // Handle item click to toggle title visibility and background
        holder.itemView.setOnClickListener(v -> {
            if (holder.titleTextView.getVisibility() == View.GONE) {
                // Hide previously visible title, if any
                if (currentlyVisiblePosition != -1) {
                    notifyItemChanged(currentlyVisiblePosition); // Notify adapter to update view
                }

                // Show current item's title and set the background
                holder.titleTextView.setVisibility(View.VISIBLE);
                holder.itemView.setBackgroundResource(R.drawable.blue_bg);
                currentlyVisiblePosition = position; // Update visible position
            } else {
                // Hide the title and remove the background
                holder.titleTextView.setVisibility(View.GONE);
                holder.itemView.setBackgroundResource(0);
                currentlyVisiblePosition = -1; // Reset visible position
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size(); // Return the total number of items
    }

    // ViewHolder class to hold references to the views in each item layout
    public static class Viewholder extends RecyclerView.ViewHolder {
        ImageView imageView; // Image view for category image
        TextView titleTextView; // Text view for category title

        public Viewholder(View itemView) {
            super(itemView);
            // Initialize the views
            imageView = itemView.findViewById(R.id.pic);
            titleTextView = itemView.findViewById(R.id.title);
        }
    }
}
