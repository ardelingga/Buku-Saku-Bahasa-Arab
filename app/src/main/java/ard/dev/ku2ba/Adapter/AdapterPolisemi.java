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
import ard.dev.ku2ba.Model.ModelPolisemi;
import ard.dev.ku2ba.R;

public class AdapterPolisemi extends BaseAdapter implements Filterable {
    private Activity activity;
    private List<ModelPolisemi> listModel;
    private List<ModelPolisemi> listModelFull;
    private LayoutInflater inflater;

    View view;
    TextView tv_id, tv_kata, tv_makna1, tv_arti_makna1, tv_makna2, tv_arti_makna2;

    public AdapterPolisemi(Activity activity, List<ModelPolisemi> listModel) {
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
        view = inflater.inflate(R.layout.adapter_polisemi, null);
//        tv_id = view.findViewById(R.id.tv_id);
        tv_kata = view.findViewById(R.id.tv_kata);
        tv_makna1 = view.findViewById(R.id.tv_makna1);
        tv_arti_makna1 = view.findViewById(R.id.tv_arti_makna1);
        tv_makna2 = view.findViewById(R.id.tv_makna2);
        tv_arti_makna2 = view.findViewById(R.id.tv_arti_makna2);

//        tv_id.setText(Integer.toString(listModel.get(position).getId()));
        tv_kata.setText(listModel.get(position).getKata());
        tv_makna1.setText(listModel.get(position).getMakna1());
        tv_arti_makna1.setText(listModel.get(position).getArti_makna1());
        tv_makna2.setText(listModel.get(position).getMakna2());
        tv_arti_makna2.setText(listModel.get(position).getArti_makna2());

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
            List<ModelPolisemi> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(listModelFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ModelPolisemi item:listModelFull){
                    if (item.getKata().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }else if (item.getMakna1().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }else if (item.getArti_makna1().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }else if (item.getMakna2().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }else if (item.getArti_makna2().toLowerCase().contains(filterPattern)){
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

    public void update(ArrayList<ModelPolisemi> results){
        listModel = new ArrayList<>();
        listModel.addAll(results);
        notifyDataSetChanged();
    }
}
