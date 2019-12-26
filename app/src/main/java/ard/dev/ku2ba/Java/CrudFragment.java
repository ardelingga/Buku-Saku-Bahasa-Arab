package ard.dev.ku2ba.Java;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ard.dev.ku2ba.Java.ModelJava.ModelCrud;
import ard.dev.ku2ba.R;
public class CrudFragment extends Fragment {

    View view;
    ListView listView;

    EditText et_id, et_name, et_email;
    Button btn_add, btn_edit, btn_delete;
    List<ModelCrud> dataModel = new ArrayList<>();

    SQLiteHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_crud, container, false);

        db = new SQLiteHelper(getActivity());

        et_id = view.findViewById(R.id.et_id);
        et_name = view.findViewById(R.id.et_nama);
        et_email = view.findViewById(R.id.et_email);
        btn_add = view.findViewById(R.id.btn_add);
        btn_edit = view.findViewById(R.id.btn_edit);
        btn_delete = view.findViewById(R.id.btn_delete);
        listView = view.findViewById(R.id.list_view);

        //Refresh data
        refreshData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), dataModel.get(position).getEmail(), Toast.LENGTH_SHORT).show();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelCrud person = new ModelCrud(Integer.parseInt(et_id.getText().toString()), et_name.getText().toString(), et_email.getText().toString());
                db.addPerson(person);
                refreshData();
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelCrud person = new ModelCrud(Integer.parseInt(et_id.getText().toString()), et_name.getText().toString(), et_email.getText().toString());
                db.updatePerson(person);
                refreshData();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelCrud person = new ModelCrud(Integer.parseInt(et_id.getText().toString()), et_name.getText().toString(), et_email.getText().toString());
                db.deletePerson(person);
                refreshData();
            }
        });


        return view;
    }

    private void refreshData(){
        dataModel = db.getAllData();
        AdapterCrud adapter = new AdapterCrud(getActivity(), dataModel, et_id, et_name, et_email);
        listView.setAdapter(adapter);
    }
}
