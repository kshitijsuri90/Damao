package com.example.android.damo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText rating;
    private EditText comment;
    private ExampleDialogListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);
        builder.setView(view).setTitle("Review")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String rating_value = rating.getText().toString();
                String comment_text = comment.getText().toString();
                if (comment_text.length() != 0 && rating_value.length() != 0 && Double.parseDouble(rating_value) <= 5) {
                    listener.applyTexts(rating_value, comment_text);
                } else {
                    Toast.makeText(getContext(), R.string.toast_review, Toast.LENGTH_LONG).show();
                }
            }
        });

        rating = view.findViewById(R.id.raing_input);
        comment = view.findViewById(R.id.comment_input);

        return builder.create();
    }

    public interface ExampleDialogListener {
        void applyTexts(String rating_text, String comment_text);
    }
}
