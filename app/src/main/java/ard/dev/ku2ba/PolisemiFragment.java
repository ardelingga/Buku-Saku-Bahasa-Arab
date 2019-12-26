package ard.dev.ku2ba;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import ard.dev.ku2ba.Adapter.AdapterPolisemi;
import ard.dev.ku2ba.Adapter.AdapterSinonim;
import ard.dev.ku2ba.Java.DBHelper;
import ard.dev.ku2ba.Model.ModelPolisemi;
import ard.dev.ku2ba.Model.ModelSinonim;

public class PolisemiFragment extends Fragment {

    private View view;
    private boolean isLoaded;

    public static AutoCompleteTextView et_search;
    ArrayList<String> arrayList;
    DatabaseHelper databaseHelper;
    TextView tv_hasil_search;

    ListView listView;
    ArrayAdapter arrayAdapter;
    List<ModelPolisemi> dataModel = new ArrayList<>();
    AdapterPolisemi adapter;

    public static CardView ly_search;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (isLoaded == false){
            view = inflater.inflate(R.layout.polisemi_fragment, container, false);
            init(view);
            isLoaded = true;
        }

        return view;
    }

    private void init(View view) {
        ly_search = view.findViewById(R.id.ly_search_fragment_sinonim);

        databaseHelper = new DatabaseHelper(getActivity(), 1, "ku2ba.db");
        try {
            databaseHelper.openDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            databaseHelper.createDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }
        listView = view.findViewById(R.id.list_view);
        et_search = view.findViewById(R.id.et_search);
        tv_hasil_search = view.findViewById(R.id.tv_hasil_search);
        arrayList = new ArrayList<>();

        refreshData();

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if (s.length() == 1){
//                    arrayList.addAll(dbHelper.getAllWords(s.toString()));
//                    et_search.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList));
//
//                }

                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        et_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String word = (String) parent.getItemAtPosition(position);
////                tv_hasil_search.setText(dbHelper.getMean(word));
//                adapter.getFilter().filter(word);
//            }
//        });
    }

    private void refreshData(){
        dataModel = databaseHelper.getAllDataTblPolisemi();
        adapter = new AdapterPolisemi(getActivity(), dataModel);

        listView.setAdapter(adapter);
    }
}
