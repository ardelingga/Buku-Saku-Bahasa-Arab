package ard.dev.ku2ba.Java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import ard.dev.ku2ba.Java.ModelJava.ModelCrud;
import ard.dev.ku2ba.R;

public class RecordListActivity extends AppCompatActivity {
    ListView listView;
    AdapterCrud adapter;
    ArrayList<ModelCrud> dataModel;
    SQLiteHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
//
//        listView = findViewById(R.id.list_item);
//        databaseHelper = new SQLiteHelper(this);
//
//        dataModel = new ArrayList<>();
//        dataModel = databaseHelper.showAllData();
//
//        adapter = new AdapterCrud(this, dataModel);
//        listView.setAdapter(adapter);
    }
}
