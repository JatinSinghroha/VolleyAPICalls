package com.jatinsinghroha.volleyapicalls;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

public class FullScreenAnimalDetails extends AppCompatActivity {

    ImageView fullSizeAnimalIV;
    TextView animalNameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_animal_details);

        fullSizeAnimalIV = findViewById(R.id.animalImageFullIV);
        animalNameTV = findViewById(R.id.animalFullNameTV);

        String imageUrl = getIntent().getStringExtra("animalImageURLKey");
        String name = getIntent().getStringExtra("animalNameKey");

        Glide.with(fullSizeAnimalIV)
                .load(imageUrl)
                .circleCrop()
                .placeholder(R.drawable.ic_baseline_download_24)
                .into(fullSizeAnimalIV);

        animalNameTV.setText(name);
    }
}