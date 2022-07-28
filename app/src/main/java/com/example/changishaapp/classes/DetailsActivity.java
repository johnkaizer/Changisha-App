package com.example.changishaapp.classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.changishaapp.R;

public class DetailsActivity extends AppCompatActivity {

    TextView title,amount,progress,description, account, category;
    ImageView imageview,fav_txt,share_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        progress= findViewById(R.id.progress_txt);
        description= findViewById(R.id.description_txt);
        account = findViewById(R.id.account_txt);
        amount= findViewById(R.id.Amount_txt);
        title= findViewById(R.id.title_txt);
        category= findViewById(R.id.Category_txt);
        imageview= findViewById(R.id.pop_image);


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