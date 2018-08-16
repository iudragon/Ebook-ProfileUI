package com.projects.sharath.readerprofileui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView imageView;

    private ArrayList<BooksModel> booksModelArrayList;
    private BooksAdapter booksAdapter;

    private int images[] = {R.drawable.book4, R.drawable.book3, R.drawable.book2 , R.drawable.book1};
    private String names[] = {"Midnight Dreams", "Lethal Waves", "All the Night", "Graphic Novel"};
    private int progress[] = {75,70,65,60};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MappingToXML();
        CircleImage();
        SetUpRecyclerView();
    }

    private void MappingToXML() {
        recyclerView = findViewById(R.id.rv1);
        imageView = findViewById(R.id.circleProfile);
    }

    private void CircleImage() {
        //TO MAKE IMAGEVIEW CIRCULAR
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.profile);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);
    }

    private void SetUpRecyclerView() {
        booksModelArrayList = new ArrayList<>();
        for(int i = 0 ; i < images.length ; i++){
            BooksModel booksModel = new BooksModel();
            booksModel.setImage(images[i]);
            booksModel.setName(names[i]);
            booksModel.setProgress(progress[i]);
            //we can get the data from progress and set the text of that particular progress for PROGRESS NUM
            booksModel.setProgressnum(String.valueOf(progress[i]));
            booksModelArrayList.add(booksModel);
        }

        booksAdapter = new BooksAdapter(booksModelArrayList, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(booksAdapter);
    }

}
