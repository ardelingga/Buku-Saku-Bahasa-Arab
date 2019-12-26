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

import java.util.ArrayList;
import java.util.List;

import ard.dev.ku2ba.Model.ModelAntonim;
import ard.dev.ku2ba.Model.ModelSinonim;
import ard.dev.ku2ba.R;

public class AdapterAntonim extends BaseAdapter implements Filterable {
    private Activity activity;
    private List<ModelAntonim> listModel;
    private List<ModelAntonim> listModelFull;
    private LayoutInflater inflater;

    View view;
    TextView tv_id, tv_kata, tv_arti_kata, tv_kata_antonim, tv_arti_kata_antonim;

    public AdapterAntonim(Activity activity, List<ModelAntonim> listModel) {
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
        view = inflater.inflate(R.layout.adapter_antonim, null);
//        tv_id = view.findViewById(R.id.tv_id);
        tv_kata = view.findViewById(R.id.tv_kata);
        tv_arti_kata = view.findViewById(R.id.tv_arti_kata);
        tv_kata_antonim = view.findViewById(R.id.tv_arti_antonim);
        tv_arti_kata_antonim = view.findViewById(R.id.tv_antonim);

//        tv_id.setText(Integer.toString(listModel.get(position).getId()));
        tv_kata.setText(listModel.get(position).getArti_antonim());
        tv_arti_kata.setText(listModel.get(position).getKata_antonim_arab());
        tv_kata_antonim.setText(listModel.get(position).getKata_arab());
        tv_arti_kata_antonim.setText(listModel.get(position).getArti_kata());

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
            List<ModelAntonim> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(listModelFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ModelAntonim item:listModelFull){
                    if (item.getArti_kata().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }else if (item.getKata_arab().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }else if (item.getKata_antonim_arab().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }else if (item.getArti_antonim().toLowerCase().contains(filterPattern)){
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

    public void update(ArrayList<ModelAntonim> results){
        listModel = new ArrayList<>();
        listModel.addAll(results);
        notifyDataSetChanged();
    }
}
