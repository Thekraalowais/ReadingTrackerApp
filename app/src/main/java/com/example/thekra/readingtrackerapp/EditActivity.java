package com.example.thekra.readingtrackerapp;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.thekra.readingtrackerapp.Contract.ReadingEntry;

public class EditActivity extends AppCompatActivity {
    private EditText bookName;
    private EditText page;
    private Spinner rate;
    private int Rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        bookName = (EditText) findViewById(R.id.book_name_field);
        page = (EditText) findViewById(R.id.page_field);
        rate = (Spinner) findViewById(R.id.rate_feild);
        setUpSpinner();
    }

    private void setUpSpinner() {
        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.array_rate_options, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        rate.setAdapter(spinnerAdapter);
        rate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String currentRate = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(currentRate)) {
                    if (currentRate.equals(getString(R.string.no_rate))) {
                        Rating = ReadingEntry.RATING_NO;
                    } else if (currentRate.equals(getString(R.string.rate1))) {
                        Rating = ReadingEntry.RATING_ONE;
                    } else if (currentRate.equals(getString(R.string.rate2))) {
                        Rating = ReadingEntry.RATING_TOW;
                    } else if (currentRate.equals(getString(R.string.rate3))) {
                        Rating = ReadingEntry.RATING_THREE;
                    } else if (currentRate.equals(getString(R.string.rate4))) {
                        Rating = ReadingEntry.RATING_FOUR;
                    } else if (currentRate.equals(getString(R.string.rate5))) {
                        Rating = ReadingEntry.RATING_FIVE;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Rating = ReadingEntry.RATING_NO;
            }


        });
    }

    public void insert() {
        try {
            String name = bookName.getText().toString().trim();
            String pageString = page.getText().toString().trim();
            int pagesInt = Integer.parseInt(pageString);

            DbHelper dbHelper = new DbHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(ReadingEntry.COLUMN_NAME, name);
            values.put(ReadingEntry.COLUMN_PAGE, pagesInt);
            values.put(ReadingEntry.COLUMN_RATING, Rating);

            long newRow = db.insert(ReadingEntry.TABLE_NAME, null, values);

            if (newRow == -1) {
                Toast.makeText(EditActivity.this, "Fail add book", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(EditActivity.this, "Successfully add book", Toast.LENGTH_SHORT).show();
                finish();
            }
        } catch (NumberFormatException e) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("Unsaved data!").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog = dialog.create();
            alertDialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                insert();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
