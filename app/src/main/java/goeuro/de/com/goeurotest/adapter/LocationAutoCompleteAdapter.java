package goeuro.de.com.goeurotest.adapter;

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
import java.util.Locale;

import goeuro.de.com.goeurotest.R;
import goeuro.de.com.goeurotest.entities.Location;
import goeuro.de.com.goeurotest.webapi.WebServiceFactory;

public class LocationAutoCompleteAdapter extends BaseAdapter implements Filterable {

    private Context mContext;
    private List<Location> resultList = new ArrayList<Location>();

    public LocationAutoCompleteAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Location getItem(int index) {
        return resultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_dropdown, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.txt_header)).setText(getItem(position).getName());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    List<Location> books = findLocations(constraint.toString());

                    // Assign the data to the FilterResults
                    filterResults.values = books;
                    filterResults.count = books.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    resultList = (List<Location>) results.values;
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }};
        return filter;
    }

    private List<Location> findLocations(String s) {
        Locale current = mContext.getResources().getConfiguration().locale;
        return WebServiceFactory.getInstance().getCatagories(current.getLanguage() , s);
    }

}