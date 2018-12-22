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

import java.util.ArrayList;


public class ListAdapterComment extends ArrayAdapter<Comment> {
    private static final String TAG = "ListComment";

    ListAdapterComment(Activity context, ArrayList<Comment> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listview = convertView;
        Log.d(TAG, "Listview");
        if (listview == null) {
            Log.d(TAG, "list_view");
            listview = LayoutInflater.from(getContext()).inflate(R.layout.review_list_template, parent, false);

        }
        Comment comment = getItem(position);
        TextView rating_text = listview.findViewById(R.id.ratings);
        assert comment != null;
        rating_text.setText(comment.getmRating());
        TextView comment_text = listview.findViewById(R.id.comment);
        comment_text.setText(comment.getmComment());
        return listview;
    }
}
