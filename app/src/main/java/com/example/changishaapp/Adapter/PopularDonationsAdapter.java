package com.example.changishaapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.changishaapp.DetailsActivity;
import com.example.changishaapp.R;
import com.example.changishaapp.model.PopularDonation;

import java.util.List;

public class PopularDonationsAdapter extends RecyclerView.Adapter<PopularDonationsAdapter.PopularDonationViewHolder>{
    Context context;
    List<PopularDonation> popularDonationList;
    PopularDonation popularDonation;

    public PopularDonationsAdapter(Context context, List<PopularDonation> popularDonationList) {
        this.context = context;
        this.popularDonationList = popularDonationList;
    }

    @NonNull
    @Override
    public PopularDonationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popula_donation_row_item,parent,false);
        PopularDonationViewHolder holder =new PopularDonationViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PopularDonationViewHolder holder, @SuppressLint("RecyclerView") final int position) {
         popularDonation  = popularDonationList.get(position);
        holder.donationImage.setImageResource(popularDonation.getImageUrl());
        holder.title.setText(popularDonation.getTitle());
        holder.progress.setText(popularDonation.getProgress());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("donationImage",popularDonationList.get(position).getImageUrl());
                intent.putExtra("title",popularDonationList.get(position).getTitle());
                intent.putExtra("progress",popularDonationList.get(position).getProgress());
                intent.putExtra("amount",popularDonationList.get(position).getAmount());
                intent.putExtra("description",popularDonationList.get(position).getDescription());
                intent.putExtra("account",popularDonationList.get(position).getAccount());
                intent.putExtra("category",popularDonationList.get(position).getCategory());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

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
