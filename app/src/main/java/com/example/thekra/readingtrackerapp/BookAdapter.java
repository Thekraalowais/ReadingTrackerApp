package com.example.thekra.readingtrackerapp;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Thekra on 8/24/2017.
 */

public class BookAdapter extends CursorAdapter {
    TextView name;
    TextView pages;
    TextView rate;

    public BookAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @NonNull
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.book, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.book_name);
        TextView page = (TextView) view.findViewById(R.id.book_pages);
        TextView rate = (TextView) view.findViewById(R.id.book_rate);

        String nameString = cursor.getString(cursor.getColumnIndex("name"));
        int pageInt = cursor.getInt(cursor.getColumnIndex("page"));
        int RateInt = cursor.getInt(cursor.getColumnIndex("Rating"));

        name.setText(nameString);
        page.setText(String.valueOf(pageInt));
        rate.setText(String.valueOf(RateInt));

    }
}

