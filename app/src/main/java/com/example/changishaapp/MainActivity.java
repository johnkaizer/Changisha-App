package com.example.changishaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.changishaapp.Adapter.PopularDonationsAdapter;
import com.example.changishaapp.model.PopularDonation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView popularRecycler;
    PopularDonationsAdapter popularDonationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<PopularDonation> popularDonationList= new ArrayList<>();
        popularDonationList.add(new PopularDonation("XYZ Reserve National Park","KSh 7000","Buy torch",R.drawable.donate,"50%"));
        popularDonationList.add(new PopularDonation("XYZ National Park","KSh 7000","Buy torch",R.drawable.donate,"70%"));
        popularDonationList.add(new PopularDonation("XYZ Reserve National Park Nairobi","KSh 7000","Buy torch",R.drawable.donate,"90%"));
        popularDonationList.add(new PopularDonation("XYZ Reserve National Park National Park","KSh 7000","Buy torch",R.drawable.donate,"80%"));
        setPopularDonationsAdapter(popularDonationList);
    }
    private void setPopularDonationsAdapter(List<PopularDonation>popularDonationList){
        popularRecycler = findViewById(R.id.popular_donations);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        popularRecycler.setLayoutManager(layoutManager);
        popularDonationsAdapter = new PopularDonationsAdapter(this,popularDonationList);
        popularRecycler.setAdapter(popularDonationsAdapter);
    }
}