package com.example.muradmomani.anothaone;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter implements Filterable {
    private ArrayList<movies> _Movies;
    private Activity context;
    private LayoutInflater inflater;
    private ValueFilter valueFilter;
    private ArrayList<movies> mStringFilterList;

    public CustomAdapter(Activity context, ArrayList<movies> _Movies) {
        super();
        this.context = context;
        this._Movies = _Movies;
        mStringFilterList =  _Movies;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        getFilter();
    }

    @Override
    public int getCount() {
        return _Movies.size();
    }

    @Override
    public Object getItem(int position) {
        return _Movies.get(position).getTitle();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder {
        TextView tname, tdes;
        ImageView timg;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.customlist, null);
            holder.tname = (TextView) convertView.findViewById(R.id.listview_item_title);
            holder.tdes = (TextView) convertView.findViewById(R.id.listview_item_short_description);
            holder.timg=(ImageView)convertView.findViewById(R.id.listview_image);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        holder.tname.setText("" + _Movies.get(position).getTitle());
        holder.tdes.setText("" + "" + _Movies.get(position).getDescription());
        holder.timg.setImageResource(_Movies.get(position).getImages());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        if(valueFilter==null) {

            valueFilter=new ValueFilter();
        }

        return valueFilter;
    }
    private class ValueFilter extends Filter {

        //Invoked in a worker thread to filter the data according to the constraint.
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();
            if(constraint!=null && constraint.length()>0){
                ArrayList<movies> filterList=new ArrayList<movies>();
                for(int i=0;i<mStringFilterList.size();i++){
                    if((mStringFilterList.get(i).getTitle().toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {
                        movies contacts = new movies();
                        contacts.setTitle(mStringFilterList.get(i).getTitle());
                        contacts.setDescription(mStringFilterList.get(i).getDescription());
                        contacts.setImages(mStringFilterList.get(i).getImages());
                        filterList.add(contacts);
                    }
                }
                results.count=filterList.size();
                results.values=filterList;
            }else{
                results.count=mStringFilterList.size();
                results.values=mStringFilterList;
            }
            return results;
        }


        //Invoked in the UI thread to publish the filtering results in the user interface.
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            _Movies=(ArrayList<movies>) results.values;
            notifyDataSetChanged();
        }
    }
}
