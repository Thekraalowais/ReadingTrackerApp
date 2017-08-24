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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DbHelper(this);
        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
        ListView listView = (ListView) findViewById(R.id.list);
        BookAdapter adapter = new BookAdapter(this, cursor);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayData();
    }

    private void displayData() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.query(ReadingEntry.TABLE_NAME, null, null, null, null, null, null);
//        cursor = db.rawQuery("SELECT  * FROM Reading", null);
//        TextView displayText = (TextView) findViewById(R.id.display_text);
//        try {
////            displayText.setText("The reading table contain:" + cursor.getCount() + "\n");
////            displayText.append(ReadingEntry.COLUMN_ID + " - " +
////                    ReadingEntry.COLUMN_NAME + " - " + ReadingEntry.COLUMN_PAGE + " - " + ReadingEntry.COLUMN_RATING + "\n");
//            int idIndex = cursor.getColumnIndex(ReadingEntry.COLUMN_ID);
//            int nameIndex = cursor.getColumnIndex(ReadingEntry.COLUMN_NAME);
//            int pageIndex = cursor.getColumnIndex(ReadingEntry.COLUMN_PAGE);
//            int ratingIndex = cursor.getColumnIndex(ReadingEntry.COLUMN_RATING);
//            while (cursor.moveToNext()) {
//                int id = cursor.getInt(idIndex);
//                String name = cursor.getString(nameIndex);
//                int page = cursor.getInt(pageIndex);
//                int rate = cursor.getInt(ratingIndex);
////                displayText.append("\n" + id + " - " + name + " - " + page + " - " + rate);
//            }
//
//        } finally {
        cursor.close();
//        }
    }

}
