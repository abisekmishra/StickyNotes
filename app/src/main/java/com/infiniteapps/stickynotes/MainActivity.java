package com.infiniteapps.stickynotes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView stickyList;
    ImageView nothingHereImage;
    TextView nothingHereText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        ArrayList<String> mDataList  = new ArrayList<>();
        mDataList.add("Abisek Mishra Mishra Abisek Abisek Mishra Mishra Abisek Abisek Mishra");
        mDataList.add("Mishra One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve Thirteen");
        mDataList.add("Lorem Ipsum blah blah blah blahblah blahblah blah blah blah Description etc etc etc");

        stickyList = findViewById(R.id.stickyList);
        nothingHereText = findViewById(R.id.nothingHereText);
        nothingHereImage = findViewById(R.id.nothingHereImage);

        StickyAdapter mAdapter = new StickyAdapter(this,mDataList);
        stickyList.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        stickyList.setLayoutManager(layoutManager);
        stickyList.setHasFixedSize(true);

        if(mDataList.size()<0){
            nothingHereImage.setVisibility(View.VISIBLE);
            nothingHereText.setVisibility(View.VISIBLE);
        }else{
            nothingHereImage.setVisibility(View.INVISIBLE);
            nothingHereText.setVisibility(View.INVISIBLE);
        }

    }

}
