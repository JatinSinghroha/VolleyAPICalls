package com.jatinsinghroha.volleyapicalls;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewWithGlide extends AppCompatActivity implements RVNameWithImageAdapter.GoToFullAnimalDetails{

    RecyclerView nameWithImageRV;
    RVNameWithImageAdapter adapter;
    List<NameAndImageModel> mNameAndImageModelList;

    String[] namesOfAnimals = {"Lion", "Tiger", "Cat", "Dog"};

    String[] imageURLsOfAnimals = {
            "https://images.theconversation.com/files/243439/original/file-20181101-83635-1xcrr39.jpg",
            "https://www.outlookindia.com/outlooktraveller/resizer.php?src=https://www.outlookindia.com/outlooktraveller/public/uploads/articles/explore/shutterstock_1135230113.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/6/66/An_up-close_picture_of_a_curious_male_domestic_shorthair_tabby_cat.jpg", "https://i.natgeofe.com/n/4f5aaece-3300-41a4-b2a8-ed2708a0a27c/domestic-dog_thumb.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_with_glide);

        nameWithImageRV = findViewById(R.id.rvWithGlide);
        mNameAndImageModelList = new ArrayList<>();

        adapter = new RVNameWithImageAdapter(mNameAndImageModelList, this);

        nameWithImageRV.setAdapter(adapter);

        nameWithImageRV.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        nameWithImageRV.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        loadData();
    }

    private void loadData() {
        for (int i = 0; i < 10000; i++) {
            int random = new Random().nextInt(4);
            mNameAndImageModelList.add(
                    new NameAndImageModel(namesOfAnimals[random], imageURLsOfAnimals[random])
            );
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onAnimalClick(NameAndImageModel animalModel) {
        Toast.makeText(RecyclerViewWithGlide.this, animalModel.getName(), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(RecyclerViewWithGlide.this, FullScreenAnimalDetails.class);

        intent.putExtra("animalNameKey", animalModel.getName());
        intent.putExtra("animalImageURLKey", animalModel.getImageURL());

        startActivity(intent);
    }
}