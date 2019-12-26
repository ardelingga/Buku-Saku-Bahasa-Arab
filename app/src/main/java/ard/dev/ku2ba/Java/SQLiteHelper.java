package ard.dev.ku2ba.Java;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ard.dev.ku2ba.Java.ModelJava.ModelCrud;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "biodata.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "person";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nama";
    private static final String KEY_EMAIL = "email";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("
               +KEY_ID+" INTEGER PRIMARY KEY,"
               +KEY_NAME+" TEXT,"
               +KEY_EMAIL+" TEXT);";

       db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public void addPerson(ModelCrud person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, person.getName());
        values.put(KEY_EMAIL, person.getEmail());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public int updatePerson(ModelCrud person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, person.getName());
        values.put(KEY_EMAIL, person.getEmail());

        return db.update(TABLE_NAME, values, KEY_ID+" =?", new String[]{String.valueOf(person.getId())});
    }

    public void deletePerson(ModelCrud person){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID+" =?", new String[]{String.valueOf(person.getId())});
    }

    public ModelCrud getModel(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID, KEY_NAME, KEY_EMAIL}, KEY_ID+" =?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }
        return new ModelCrud(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
    }

    public List<ModelCrud> getAllData(){
        List<ModelCrud> listPerson = new ArrayList<>();

        String select_query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()){
            do {
                ModelCrud person = new ModelCrud();
                person.setId(cursor.getInt(0));
                person.setName(cursor.getString(1));
                person.setEmail(cursor.getString(2));

                listPerson.add(person);
            }
            while (cursor.moveToNext());
        }
        return listPerson;
    }

}
