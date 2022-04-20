package com.example.image_gallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.grid_view);
// Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));
/**
 * On Click event for Single Gridview Item
 * */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
// Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(),
                        FullImageActivity.class);
// passing array index
                Toast.makeText(getApplicationContext(), "ID is: "+ position,
                        Toast.LENGTH_SHORT).show();
                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }
}