package pro.nanosystems.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import pro.nanosystems.myapplication.data.DbHelper;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private DbHelper mDbHelper;
    private Cursor mCursor;
    private static final String TABLE_NAME = "student";
    private static final String COL_NAME = "name";
    private static final String COL_SEX = "sex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbHelper = new DbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        mCursor = db.query(TABLE_NAME, null, null,
                null, null, null, null);
        while (mCursor.moveToNext()) {
            System.out.println("ID: "
                    + mCursor.getInt(mCursor.getColumnIndex(BaseColumns._ID))
                    + " Name: " + mCursor.getString(mCursor.getColumnIndex(COL_NAME))
                    + " Sex: "+ mCursor.getInt(mCursor.getColumnIndex(COL_SEX))
            );
            Log.d(TAG, "onCreate: " + " Name: " + mCursor.getString(mCursor.getColumnIndex(COL_NAME)));

        }
    }
}
