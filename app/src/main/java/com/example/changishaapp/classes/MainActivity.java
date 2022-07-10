package com.example.changishaapp.classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.changishaapp.Adapter.PopularDonationsAdapter;
import com.example.changishaapp.R;
import com.example.changishaapp.model.PopularDonation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView popularRecycler;
    PopularDonationsAdapter popularDonationsAdapter;
    ImageView notification, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        notification= findViewById(R.id.notification_txt);
        profile = findViewById(R.id.profile_image);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, NotificationsActivty.class);
                startActivity(intent);
            }
        });




        List<PopularDonation> popularDonationList= new ArrayList<>();
        popularDonationList.add(new PopularDonation("GOODWILL ORGANIZATION ","KSh 800,000","build shelter and provide a good place for the aged in the kabete area.",R.drawable.donat,"50%","Social",1234567892));
        popularDonationList.add(new PopularDonation("OPENING MINDS DONATIONS","KSh 100,000","Pay fees for kids who are not able.",R.drawable.doo,"70%","Education",1234567892));
        popularDonationList.add(new PopularDonation("THE NEW CHANGE ORGANIZATIONS","KSh 1,200,000","Buy food for kids in primary school in Nairobi.",R.drawable.fund,"90%","Education",1234567892));
        popularDonationList.add(new PopularDonation("REFUGEES IN NEED ","KSh 400,000","Buy books and other stationary for children inn schools coming from less fortunate families.",R.drawable.donatee,"80%","Social",1234567892));
        popularDonationList.add(new PopularDonation("NEW TIMES DONATIONS","KSh 70,000","Buy foodstuffs and clothes for street families",R.drawable.charit,"80%","Social",1234567892));
        popularDonationList.add(new PopularDonation("Kibera Home for Kids","KSh 200,000","The organization wishes to raise money to buy beddings for the kids in the institution ",R.drawable.event,"80%","Health",1234567892));
        popularDonationList.add(new PopularDonation("KNH Hospital","KSh 1,000,000","Buy new masks for the nurses and oxygen tanks for patients.",R.drawable.blood,"30%","Health",1234567892));

        setPopularDonationsAdapter(popularDonationList);
    }
    private void setPopularDonationsAdapter(List<PopularDonation>popularDonationList){
        popularRecycler = findViewById(R.id.popular_donations);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        popularRecycler.setLayoutManager(layoutManager);
        popularDonationsAdapter = new PopularDonationsAdapter(getApplicationContext(), popularDonationList);
        popularRecycler.setAdapter(popularDonationsAdapter);
    }
}