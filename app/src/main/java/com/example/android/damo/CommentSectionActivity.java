package com.example.android.damo;

import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class CommentSectionActivity extends AppCompatActivity {

    private ArrayList<Comment> comments = new ArrayList<>();
    private String comment_text = "", review = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            comment_text = bundle.getString("comment");
            review = bundle.getString("rating");
        }
        assert review != null;
        if (review.length() != 0) {
            if(review.length()<3){
                comments.add(new Comment(comment_text, review));
            }
            else {
                comments.add(new Comment(comment_text, review.substring(0, 2)));
            }
        }
        comments.add(new Comment(getString(R.string.review1), "4.3"));
        comments.add(new Comment(getString(R.string.review2), "4.0"));
        comments.add(new Comment(getString(R.string.review3), "4.2"));
        comments.add(new Comment(getString(R.string.review4), "4.6"));
        comments.add(new Comment(getString(R.string.review5), "4.6"));
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.setVisibility(View.GONE);
        ListView listView = findViewById(R.id.list_view);
        ListAdapterComment listAdapter = new ListAdapterComment(CommentSectionActivity.this, comments);
        listView.setAdapter(listAdapter);
    }
}
