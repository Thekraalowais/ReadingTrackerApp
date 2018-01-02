package com.example.thekra.readingtrackerapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import com.example.thekra.readingtrackerapp.Contract.ReadingEntry;



public class MainActivity extends AppCompatActivity {
    private DbHelper dbHelper;
    private Cursor cursor;
    private ListView listView;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
        listView = (ListView) findViewById(R.id.list);
        dbHelper = new DbHelper(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        displayData();
    }

    private Cursor displayData() {
        db = dbHelper.getReadableDatabase();
        cursor = db.query(ReadingEntry.TABLE_NAME, null, null, null, null, null, null);
        BookAdapter adapter = new BookAdapter(this, cursor);
        listView.setAdapter(adapter);
        return cursor;
       }

}
