package com.scienstechnologies.dbapp.others;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lokesh on 4/22/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    private String createTable = "create table TestDB(name Text, mobile Text, mail Text, password Text)";

    public DBHelper(Context context) {
        super(context, "MyDataBase", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     *  Getting SQLiteDatabase object
     * @return SQLiteDatabase (Object) with this writable access(We able to insert new records(rows) in table)
     */
    public SQLiteDatabase getSQLiteObjectWithWritable() {
        return getWritableDatabase();
    }

    /**
     * Getting SqliteObject with readable permission.
     * @return SQLiteDatabase with Read access. (Through this we can read all records in table).
     */
    public SQLiteDatabase getSqliteObjectWithReadable(){
        return getReadableDatabase();
    }

}
