package com.example.android.stakehomelesson07_lenal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    ArrayList<President> presidents;
    PresidentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        setTitle("Recycler View");
        initialData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PresidentAdapter(presidents, this);
        recyclerView.setAdapter(adapter);

    }

    private void initialData() {

        presidents = new ArrayList<>();
        presidents.add(new President("Bill Clinton", "1993-2001", R.drawable.clinton));
        presidents.add(new President("George W. Bush", "2001-2009", R.drawable.bush));
        presidents.add(new President("Barack Obama", "2009-2017", R.drawable.obama));


    }


    public void addRandomPerson(View view) {
        presidents.add(getRandomPerson());
        adapter.notifyDataSetChanged();
    }

    private President getRandomPerson() {
        int num = (int) (Math.random() * 3);
        if (num == 0)
            return new President("Bill Clinton", "1993-2001", R.drawable.clinton);
        else if (num == 1)
            return new President("George W. Bush", "2001-2009", R.drawable.bush);
        else
            return new President("Barack Obama", "2009-2017", R.drawable.obama);
    }
}


