package com.example.android.damo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.santalu.diagonalimageview.DiagonalImageView;

import java.util.Locale;

public class DetailsActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    private String input_rating = "", input_comment = "";
    double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String name = bundle.getString("name");
        String rating = bundle.getString("rating");
        String description = bundle.getString("description");
        latitude = bundle.getDouble("latitude");
        longitude = bundle.getDouble("longitude");
        int id = bundle.getInt("image");
        TextView name_text = findViewById(R.id.detail_title);
        name_text.setText(name);
        TextView info_text = findViewById(R.id.description);
        info_text.setText(description);
        TextView rating_view = findViewById(R.id.ratings);
        rating_view.setText(rating);
        DiagonalImageView imageView = findViewById(R.id.display_image);
        imageView.setImageResource(id);

        Button location = findViewById(R.id.location_maps);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailsActivity.this, R.string.toast_maps, Toast.LENGTH_LONG).show();
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        Button reviews = findViewById(R.id.see_reviews);
        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, CommentSectionActivity.class);
                if (!input_comment.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("rating", input_rating);
                    bundle.putString("comment", input_comment);
                    intent.putExtras(bundle);
                }
                startActivity(intent);
            }
        });

        Button add_review = findViewById(R.id.add_review);
        add_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "Example Dialog");
    }

    @Override
    public void applyTexts(String rating_text, String comment_text) {
        input_rating = rating_text;
        input_comment = comment_text;
        Intent intent = new Intent(DetailsActivity.this, CommentSectionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("rating", rating_text);
        bundle.putString("comment", comment_text);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
