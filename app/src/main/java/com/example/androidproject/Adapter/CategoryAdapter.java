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
    private List<Category> items;
    private int currentlyVisiblePosition = -1;

    public CategoryAdapter(List<Category> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewz = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new Viewholder(viewz);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.Viewholder holder, int position) {
        Category item = items.get(position);
        holder.imageView.setImageResource(item.getImageResourceId()); // Set image from drawable
        holder.titleTextView.setText(item.getTitle());

        // Initially, set the title to be hidden and remove the background from the whole item view
        holder.titleTextView.setVisibility(View.GONE);
        holder.itemView.setBackgroundResource(0); // Remove background from the whole item view

        // If the title at the current position is the visible one, show it and set the background for the whole item view
        if (currentlyVisiblePosition == position) {
            holder.titleTextView.setVisibility(View.VISIBLE);
            holder.itemView.setBackgroundResource(R.drawable.blue_bg); // Set background for the whole item view
        }

        holder.itemView.setOnClickListener(v -> {
            // Check if this item is currently visible
            if (holder.titleTextView.getVisibility() == View.GONE) {
                // If the clicked item's title is hidden, show it and set the background for the whole item view
                if (currentlyVisiblePosition != -1) {
                    // Hide the previous title (if any)
                    notifyItemChanged(currentlyVisiblePosition);
                }

                // Show the clicked item's title and apply the background to the whole item view
                holder.titleTextView.setVisibility(View.VISIBLE);
                holder.itemView.setBackgroundResource(R.drawable.blue_bg); // Set background for the whole item view
                currentlyVisiblePosition = position; // Update the currently visible position
            } else {
                // If the clicked item's title is visible, hide it and remove the background from the whole item view
                holder.titleTextView.setVisibility(View.GONE);
                holder.itemView.setBackgroundResource(0); // Remove background from the whole item view
                currentlyVisiblePosition = -1; // No item is visible now
            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;

        public Viewholder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.pic);
            titleTextView = itemView.findViewById(R.id.title);
        }
    }
}

