package com.mysamples.basiclogin;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "Student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "USERNAME";
    public static final String COL_3 = "PASSWORD";
    public static final String COL_4 = "FIRST_NAME";
    public static final String COL_5 = "LAST_NAME";
    public static final String COL_6 = "GRADE";
    SQLiteDatabase sqliteDatabase;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " USERNAME TEXT, PASSWORD TEXT, FIRST_NAME TEXT, LAST_NAME TEXT, GRADE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public void insertData(Students students) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, students.getUsername());
        contentValues.put(COL_3, students.getPassword());
        contentValues.put(COL_4, students.getFirstname());
        contentValues.put(COL_5, students.getLastname());
        contentValues.put(COL_6, students.getGrades());
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }



    public Cursor viewAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;

    }

    public String searchPassword(String username) {
        sqliteDatabase = this.getReadableDatabase();
        String login = "SELECT USERNAME, PASSWORD FROM " + TABLE_NAME;
        Cursor c = sqliteDatabase.rawQuery(login, null);
        String uname, pword;
        pword = "not found";
        if (c.moveToFirst()) {
            do {
                uname = c.getString(0);


                if (uname.equals(username)) {
                    pword = c.getString(1);
                    break;

                }
            } while (c.moveToNext());
        }
        return pword;
    }

    public void updateData(Students students) {
        sqliteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, students.getUsername());
        contentValues.put(COL_3, students.getPassword());
        contentValues.put(COL_4, students.getFirstname());
        contentValues.put(COL_5, students.getLastname());
        contentValues.put(COL_6, students.getGrades());
        sqliteDatabase.update(TABLE_NAME, contentValues, "USERNAME = ? AND PASSWORD = ?",
                new String[]{students.getUsername()});
        sqliteDatabase.close();

    }
    public void deleteData(Students students){
        sqliteDatabase = this.getReadableDatabase();
        sqliteDatabase.delete(TABLE_NAME, "USERNAME = ?",new String[]{students.getUsername()});
    }


}