package ard.dev.ku2ba;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.emrekose.copyexternaldb.CopyDatabase;

import java.util.ArrayList;
import java.util.List;

import ard.dev.ku2ba.Model.ModelAntonim;
import ard.dev.ku2ba.Model.ModelPolisemi;
import ard.dev.ku2ba.Model.ModelSinonim;

public class DatabaseHelper extends CopyDatabase {

    String TABEL_SINONIM = "tbl_sinonim_indo_arab";
    String TABEL_ANTONIM = "tbl_antonim";
    String TABEL_POLISEMI = "tbl_polisemi";
    String COLUMN_NAME = "word_indo";
    Context mContext;

    public DatabaseHelper(Context context, int version, String databaseName) {
        super(context, version, databaseName);
    }

    public ArrayList<String> getAllWords(String query_word){
        ArrayList<String> arrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(
                TABEL_SINONIM,
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

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABEL_SINONIM+" WHERE "+COLUMN_NAME+"= '"+word+"'", null);
        while (cursor.moveToNext()){
            mean = cursor.getString(cursor.getColumnIndex("sinonim_arab"));
        }
        return mean;
    }

    public List<ModelSinonim> getAllDataTblSinonim(){
        List<ModelSinonim> listSinonim = new ArrayList<>();

        String select_query = "SELECT * FROM "+TABEL_SINONIM;
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

    public List<ModelAntonim> getAllDataTblAntonim(){
        List<ModelAntonim> listAntonim = new ArrayList<>();

        String select_query = "SELECT * FROM "+TABEL_ANTONIM;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()){
            do {
                ModelAntonim antonim = new ModelAntonim();
                antonim.setId(cursor.getInt(0));
                antonim.setKata_arab(cursor.getString(1));
                antonim.setArti_kata(cursor.getString(2));
                antonim.setKata_antonim_arab(cursor.getString(3));
                antonim.setArti_antonim(cursor.getString(4));

                listAntonim.add(antonim);
            }
            while (cursor.moveToNext());
        }
        return listAntonim;
    }

    public List<ModelPolisemi> getAllDataTblPolisemi(){
        List<ModelPolisemi> listAntonim = new ArrayList<>();

        String select_query = "SELECT * FROM "+TABEL_POLISEMI;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()){
            do {
                ModelPolisemi antonim = new ModelPolisemi();
                antonim.setId(cursor.getInt(0));
                antonim.setKata(cursor.getString(1));
                antonim.setMakna1(cursor.getString(2));
                antonim.setArti_makna1(cursor.getString(3));
                antonim.setMakna2(cursor.getString(4));
                antonim.setArti_makna2(cursor.getString(5));

                listAntonim.add(antonim);
            }
            while (cursor.moveToNext());
        }
        return listAntonim;
    }
}
