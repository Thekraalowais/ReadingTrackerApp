package com.example.thekra.readingtrackerapp;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.thekra.readingtrackerapp.Contract.ReadingEntry;

/**
 * Created by Thekra on 8/24/2017.
 */

public class BookAdapter extends CursorAdapter {
    TextView name;
    TextView pages;
    TextView rate;
    TextView id;

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
        id = (TextView) view.findViewById(R.id.book_name);
        name = (TextView) view.findViewById(R.id.book_name);
        pages = (TextView) view.findViewById(R.id.book_pages);
        rate = (TextView) view.findViewById(R.id.book_rate);
        if(cursor.moveToFirst())
        do {

            int idInt = cursor.getColumnIndex(ReadingEntry._ID);
            String nameString = cursor.getString(cursor.getColumnIndex(ReadingEntry.COLUMN_NAME));
            int pageInt = cursor.getInt(cursor.getColumnIndex(ReadingEntry.COLUMN_PAGE));
            int RateInt = cursor.getInt(cursor.getColumnIndex(ReadingEntry.COLUMN_RATING));
            Log.v("SSSSSSSSSSSSSs", "id " + idInt);
            Log.v("SSSSSSSSSSSSSs", "name " + nameString);
            Log.v("SSSSSSSSSSSSSs", "page " + pageInt);
            Log.v("SSSSSSSSSSSSSs", "rate " + RateInt);


            name.setText(nameString);
            pages.setText(String.valueOf(pageInt));
            rate.setText(String.valueOf(RateInt));
        }while(cursor.moveToNext());
//        id.append(" " + idInt);
//        name.append(" " + nameString);
//        pages.append(" " + pageInt);
//        rate.append(" " + RateInt);
    }
}

