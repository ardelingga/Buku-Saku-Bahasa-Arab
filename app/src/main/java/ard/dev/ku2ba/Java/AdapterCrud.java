package ard.dev.ku2ba.Java;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import ard.dev.ku2ba.Java.ModelJava.ModelCrud;
import ard.dev.ku2ba.R;

public class AdapterCrud extends BaseAdapter {
    private Activity activity;
    private List<ModelCrud> listModel;
    private LayoutInflater inflater;
    EditText et_id, et_nama, et_email;

    View view;
    TextView tv_id, tv_nama, tv_email;

    public AdapterCrud(Activity activity, List<ModelCrud> listModel, EditText et_id, EditText et_nama, EditText et_email) {
        this.activity = activity;
        this.listModel = listModel;
        this.inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.et_id = et_id;
        this.et_nama = et_nama;
        this.et_email = et_email;
    }

    @Override
    public int getCount() {
        return listModel.size();
    }

    @Override
    public Object getItem(int position) {
        return listModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listModel.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        view = inflater.inflate(R.layout.adapter_sinonim, null);
//        tv_id = view.findViewById(R.id.tv_id);
        tv_nama = view.findViewById(R.id.tv_nama);
        tv_email = view.findViewById(R.id.tv_email);

        tv_id.setText(Integer.toString(listModel.get(position).getId()));
        tv_nama.setText(listModel.get(position).getName());
        tv_email.setText(listModel.get(position).getEmail());

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                et_id.setText(Integer.toString(listModel.get(position).getId()));
//                et_nama.setText(listModel.get(position).getName());
//                et_email.setText(listModel.get(position).getEmail());
//            }
//        });
        return view;
    }
}
