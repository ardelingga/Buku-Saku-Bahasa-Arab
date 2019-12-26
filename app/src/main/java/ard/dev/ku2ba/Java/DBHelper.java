package ard.dev.ku2ba.Java;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.emrekose.copyexternaldb.CopyDatabase;

import java.util.ArrayList;
import java.util.List;

import ard.dev.ku2ba.Java.ModelJava.ModelCrud;
import ard.dev.ku2ba.Model.ModelSinonim;

public class DBHelper extends CopyDatabase {

    String TABLE_NAME = "tbl_sinonim_indo_arab";
    String COLUMN_NAME = "word_indo";
    Context mContext;

    public DBHelper(Context context, int version, String databaseName) {
        super(context, version, databaseName);
    }

    public ArrayList<String> getAllWords(String query_word){
        ArrayList<String> arrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(
                TABLE_NAME,
                new String[] {COLUMN_NAME}, COLUMN_NAME+ " LIKE ?",
                new String[] {query_word + "%"},
                null, null, null
        );

        int index = cursor.getColumnIndex(COLUMN_NAME);

        while (cursor.moveToNext()){
            arrayList.add(cursor.getString(index));
        }

        return arrayList;
    }

    public String getMean(String word){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String mean = null;

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_NAME+"= '"+word+"'", null);
        while (cursor.moveToNext()){
            mean = cursor.getString(cursor.getColumnIndex("sinonim_arab"));
        }
        return mean;
    }

    public List<ModelSinonim> getAllData(){
        List<ModelSinonim> listSinonim = new ArrayList<>();

        String select_query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()){
            do {
                ModelSinonim sinonim = new ModelSinonim();
                sinonim.setId(cursor.getInt(0));
                sinonim.setWord_indo(cursor.getString(1));
                sinonim.setSinonim_arab(cursor.getString(2));

                listSinonim.add(sinonim);
            }
            while (cursor.moveToNext());
        }
        return listSinonim;
    }
}
