package pro.nanosystems.myapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Sayyid Shaban on 30/01/2018.
 * E-mail: sayyid.ls@gmail.com
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE = "student.db";
    private static final int VERSION = 2;
    private static final String TABLE_NAME = "student";
    private static final String COL_NAME = "name";
    private static final String COL_SEX = "sex";
    private static final int MALE = 0;
    private static final int FEMALE = 1;

    public DbHelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +
         " ( " + BaseColumns._ID + " integer  primary Key AUTOINCREMENT  , " +COL_NAME
                +" TEXT,  "+COL_SEX+ " INTEGER );"
            );
        // Dump data
        ContentValues values = new ContentValues();
        values.put(COL_NAME, "Ahmed");
        values.put(COL_SEX, MALE);
        db.insert(TABLE_NAME, null, values);
        /**
         * insert into student(name, sex) values ('Ahmed', 0);
         */
        values.put(COL_NAME, "Asmaa");
        values.put(COL_SEX, FEMALE);
        db.insert(TABLE_NAME, null, values);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
               db.execSQL("drop table if exists " + TABLE_NAME);
               onCreate(db);
    }

}
