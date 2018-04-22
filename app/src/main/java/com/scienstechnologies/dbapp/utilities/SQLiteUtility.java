package com.scienstechnologies.dbapp.utilities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Lokesh on 4/22/2018.
 */

public class SQLiteUtility {


    public static long insertRows(String name, String mobile, String mail, String password,
                                  SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("mobile", mobile);
        contentValues.put("mail", mail);
        contentValues.put("password", password);
        return sqLiteDatabase.insert("TestDB", null, contentValues);
    }

    public static String getMemberInformation(String name, SQLiteDatabase sqLiteDatabase) {
        Cursor cursor = sqLiteDatabase.rawQuery("select * from TestDB", null);
        String memberInfo = null;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String nameInRecord = cursor.getString(0);
                    if (nameInRecord.equalsIgnoreCase(name)) {
                        String memberName = cursor.getString(0);  // 0 means talbe coloumn  of name
                        String memberMobile = cursor.getString(1);       // 1 means table coloumn of mobile
                        String memeberMail = cursor.getString(2);          // 2 means table coloumn of mail
                        memberInfo = "Member name " + memberName + " \n" + "Member mobile" + memberMobile
                                + "\n" + "Member mail " + memeberMail;
                        break;
                    }
                } while (cursor.moveToNext());
            }
        }
        return memberInfo;
    }

}
