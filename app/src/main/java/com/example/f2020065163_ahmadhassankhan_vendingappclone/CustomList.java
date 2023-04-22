package com.example.f2020065163_ahmadhassankhan_vendingappclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class CustomList extends AppCompatActivity {
    String bookList[] = {"English\t\t$20", "Physics\t\t$30", "Chemistry\t\t$40", "Biology\t\t$50", "ComputerScience\t\t$100"};
    int bookimages[] = {R.drawable.english, R.drawable.physics, R.drawable.chemistry, R.drawable.biology, R.drawable.computer};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.customListView);
        CustomBasedAdapter customBasedAdapter = new CustomBasedAdapter(getApplicationContext(), bookList, bookimages);
        listView.setAdapter(customBasedAdapter);
    }
}