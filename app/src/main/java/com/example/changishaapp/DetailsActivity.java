package com.example.changishaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView title;
    TextView amount;
    TextView progress;
    TextView description;
    TextView account;
    TextView category;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        title.findViewById(R.id.title_txt);
        amount.findViewById(R.id.Amount_txt);
        progress.findViewById(R.id.progress_txt);
        description.findViewById(R.id.description_txt);
        account.findViewById(R.id.account_txt);
        category.findViewById(R.id.Category_txt);
        imageview.findViewById(R.id.pop_image);


        title.setText(getIntent().getExtras().getString("title"));
        amount.setText(getIntent().getExtras().getString("amount"));
        progress.setText(getIntent().getExtras().getString("progress"));
        description.setText(getIntent().getExtras().getString("description"));
        account.setText(getIntent().getExtras().getString("account"));
        category.setText(getIntent().getExtras().getString("category"));
        Integer ImageUrl = getIntent().getIntExtra("donationImage",0);
        imageview.setImageResource(ImageUrl);


    }
}