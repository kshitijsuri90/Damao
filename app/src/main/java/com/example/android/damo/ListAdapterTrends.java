package com.example.android.damo;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapterTrends extends ArrayAdapter<Trending> {

    private static final String TAG = "ListAdapterTrends";

    ListAdapterTrends(Activity context, ArrayList<Trending> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listview = convertView;
        Log.d(TAG, "Listview");
        if (listview == null) {
            Log.d(TAG, "list_view");
            listview = LayoutInflater.from(getContext()).inflate(R.layout.list_template_trends, parent, false);

        }
        Trending locations = getItem(position);
        assert convertView != null;
        TextView name_text = listview.findViewById(R.id.location_name);
        assert locations != null;
        name_text.setText(locations.getmName());

        TextView details_textview = listview.findViewById(R.id.details_place);
        details_textview.setText(locations.getmInfo());

        ImageView image = listview.findViewById(R.id.image);
        image.setImageResource(locations.getmImage());

        TextView rating = listview.findViewById(R.id.stars);
        rating.setText(locations.getmRating());

        return listview;
    }
}
