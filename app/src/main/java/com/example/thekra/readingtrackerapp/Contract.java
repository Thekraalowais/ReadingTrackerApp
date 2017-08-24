package com.example.thekra.readingtrackerapp;

import android.provider.BaseColumns;


public class Contract {
    public Contract() {}

    public final static class ReadingEntry implements BaseColumns {
        public final static String TABLE_NAME="Reading";
        public final static String COLUMN_ID=BaseColumns._ID;
        public final static String COLUMN_NAME="name";
        public final static String COLUMN_PAGE="page";
        public final static String COLUMN_RATING="Rating";

        public final static int RATING_FIVE=5;
        public final static int RATING_FOUR=4;
        public final static int RATING_THREE=3;
        public final static int RATING_TOW=2;
        public final static int RATING_ONE=1;
        public final static int RATING_NO=0;
    }
}
