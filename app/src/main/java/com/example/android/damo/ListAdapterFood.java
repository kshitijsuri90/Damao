package com.example.android.damo;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.santalu.diagonalimageview.DiagonalImageView;

import java.util.ArrayList;

public class ListAdapterFood extends ArrayAdapter<FoodCustomClass> {
    private static final String TAG = "ListAdapterFood";

    ListAdapterFood(Activity context, ArrayList<FoodCustomClass> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listview = convertView;
        Log.d(TAG, "Listview");
        if (listview == null) {
            Log.d(TAG, "list_view");
            listview = LayoutInflater.from(getContext()).inflate(R.layout.list_item_template_food, parent, false);

        }
        FoodCustomClass food = getItem(position);
        DiagonalImageView imageView = listview.findViewById(R.id.image);
        assert food != null;
        imageView.setImageResource(food.getmImageid());

        TextView restraunt = listview.findViewById(R.id.restaurant_name);
        restraunt.setText(food.getmRestaurant().toUpperCase());

        TextView details = listview.findViewById(R.id.details);
        details.setText(food.getmDetails());

        TextView rating_text = listview.findViewById(R.id.ratings);
        rating_text.setText(food.getmRating());
        return listview;
    }
}
