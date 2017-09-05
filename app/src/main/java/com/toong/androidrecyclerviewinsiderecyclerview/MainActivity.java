package com.toong.androidrecyclerviewinsiderecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.toong.androidrecyclerviewinsiderecyclerview.adapter.LinearRecyclerViewAdapter;
import com.toong.androidrecyclerviewinsiderecyclerview.model.Item;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements LinearRecyclerViewAdapter.LinearItemClickListener {

    private RecyclerView mRecyclerView;
    private LinearRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("RecyclerView inside RecyclerView");

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ArrayList<Item> data = new ArrayList<>();
        data.add(new Item("a", "b"));
        data.add(new Item("c", "b"));
        data.add(new Item("d", "b"));
        data.add(new Item("e", "b"));
        data.add(new Item("f", "b"));
        data.add(new Item("g", "b"));
        data.add(new Item("h", "b"));
        data.add(new Item("j", "b"));
        data.add(new Item("k", "b"));
        data.add(new Item("l", "b"));
        data.add(new Item("m", "b"));

        adapter = new LinearRecyclerViewAdapter(this, data.toArray(new Item[data.size()]));

        adapter.setClickListener(this);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int linearPosition, int gridPosition) {
        Toast.makeText(this, linearPosition + ":" + gridPosition + " clicked ", Toast.LENGTH_SHORT)
                .show();
    }
}
