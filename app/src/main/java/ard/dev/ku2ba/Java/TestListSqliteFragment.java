package ard.dev.ku2ba.Java;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import ard.dev.ku2ba.R;

public class TestListSqliteFragment extends Fragment {

    View view;
    ListView listView;
    ArrayAdapter<String> adapter;
    EditText et_search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.list_view);
        et_search = view.findViewById(R.id.et_search);
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, getListOfWords());

        listView.setAdapter(adapter);
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), getListOfWords()[position], Toast.LENGTH_SHORT).show();
            }
        });



    }

    String[] getListOfWords(){
        String[] source_word = new String[]{
            "arde",
            "ahmad",
            "amar",
            "bobon",
            "budi",
            "bani",
            "cici",
            "cucu",
            "cinta",
            "doni",
            "dani",
            "darmawan"
        };
        return source_word;
    }

    private void filterValue(String value){
        int size_adapter = adapter.getCount();

        for (int i = 0; i < size_adapter; i++){
            if (adapter.getItem(i).startsWith(value)){
                listView.setSelection(i);
                break;
            }
        }
    }
}
