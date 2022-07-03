package com.example.changishaapp.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.changishaapp.R;
import com.example.changishaapp.model.PopularDonation;

import java.util.List;

public class PopularDonationsAdapter extends RecyclerView.Adapter<PopularDonationsAdapter.PopularDonationViewHolder>{
    Context context;
    List<PopularDonation> popularDonationList;

    public PopularDonationsAdapter(Context context, List<PopularDonation> popularDonationList) {
        this.context = context;
        this.popularDonationList = popularDonationList;
    }

    @NonNull
    @Override
    public PopularDonationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popula_donation_row_item,parent,false);
        return new PopularDonationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularDonationViewHolder holder, int position) {
        holder.donationImage.setImageResource(popularDonationList.get(position).getImageUrl());
        holder.title.setText(popularDonationList.get(position).getTitle());
        holder.progress.setText(popularDonationList.get(position).getProgress());

    }

    @Override
    public int getItemCount() {
        return popularDonationList.size();
    }

    public static final class PopularDonationViewHolder extends RecyclerView.ViewHolder{
        ImageView donationImage;
        TextView title, progress;

        public PopularDonationViewHolder(@NonNull View itemView) {
            super(itemView);
            donationImage = itemView.findViewById(R.id.popular_image);
            title = itemView.findViewById(R.id.donation_title);
            progress = itemView.findViewById(R.id.progress);
        }
    }
}
