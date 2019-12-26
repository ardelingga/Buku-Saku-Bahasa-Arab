package ard.dev.ku2ba.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ard.dev.ku2ba.Model.ModelSinonim;
import ard.dev.ku2ba.R;

public class AdapterSinonim extends BaseAdapter implements Filterable {
    private Activity activity;
    private List<ModelSinonim> listModel;
    private List<ModelSinonim> listModelFull;
    private LayoutInflater inflater;

    View view;
    TextView tv_id, tv_nama, tv_email;

    public AdapterSinonim(Activity activity, List<ModelSinonim> listModel) {
        this.activity = activity;
        this.listModel = listModel;
        this.inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listModelFull = new ArrayList<>(listModel);
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

//        tv_id.setText(Integer.toString(listModel.get(position).getId()));
        tv_nama.setText(listModel.get(position).getWord_indo());
        tv_email.setText(listModel.get(position).getSinonim_arab());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(activity, listModel.get(position).getWord_indo(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ModelSinonim> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(listModelFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ModelSinonim item:listModelFull){
                    if (item.getWord_indo().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }else if (item.getSinonim_arab().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listModel.clear();
            listModel.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public void update(ArrayList<ModelSinonim> results){
        listModel = new ArrayList<>();
        listModel.addAll(results);
        notifyDataSetChanged();
    }
}
