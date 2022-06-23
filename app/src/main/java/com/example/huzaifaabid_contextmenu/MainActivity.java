package com.example.huzaifaabid_contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    String users[] = { "Abdul Haseeb Khan", "Fahad Afzal",
            "Hamza Mushtaq", "Imad Ahmed",
            "Huzaifa" };

    int[] images = { R.drawable.ic_baseline_person_grey, R.drawable.ic_baseline_person_grey,
            R.drawable.ic_baseline_person_grey, R.drawable.ic_baseline_person_grey,
            R.drawable.ic_baseline_person_grey };

    String numbers [] = { "+923401477374", "+923401477374",
            "+923401477374", "+923401477374",
            "+923401477374" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listView);
        MyListView adapter=new MyListView(this,users,images,numbers);
        lv.setAdapter(adapter);
    }




}