package ard.dev.ku2ba.Java;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

import ard.dev.ku2ba.R;

public class Test3Fragment extends Fragment {

    View view;
    AutoCompleteTextView et_search;
    ArrayList<String> arrayList;
    DBHelper dbHelper;
    TextView tv_hasil_search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_test3, container, false);

        dbHelper = new DBHelper(getActivity(), 1, "ku2ba.db");
        try {
            dbHelper.openDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            dbHelper.createDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }

        et_search = view.findViewById(R.id.et_search);
        tv_hasil_search = view.findViewById(R.id.tv_hasil_search);
        arrayList = new ArrayList<>();
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1){
                arrayList.addAll(dbHelper.getAllWords(s.toString()));
                et_search.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String word = (String) parent.getItemAtPosition(position);
                tv_hasil_search.setText(dbHelper.getMean(word));
            }
        });

        return view;
    }
}
