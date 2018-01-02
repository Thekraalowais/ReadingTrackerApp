package com.example.thekra.readingtrackerapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.thekra.readingtrackerapp.Contract.ReadingEntry;


public class BookAdapter extends CursorAdapter {
    TextView name;
    TextView pages;
    TextView rate;

    public BookAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.book, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        name = (TextView) view.findViewById(R.id.book_name);
        pages = (TextView) view.findViewById(R.id.book_pages);
        rate = (TextView) view.findViewById(R.id.book_rate);

        String nameString = cursor.getString(cursor.getColumnIndex(ReadingEntry.COLUMN_NAME));
            int pageInt = cursor.getInt(cursor.getColumnIndex(ReadingEntry.COLUMN_PAGE));
            int RateInt = cursor.getInt(cursor.getColumnIndex(ReadingEntry.COLUMN_RATING));


            name.setText(nameString);
            pages.setText(String.valueOf(pageInt));
            rate.setText(String.valueOf(RateInt));

    }
}

