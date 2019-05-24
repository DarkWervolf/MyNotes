package com.example.user.mynotes;

import android.app.ActionBar;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class NewNoteActivity extends AppCompatActivity {

    private EditText editTitle;
    private EditText editBody;
    private FloatingActionButton doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        getIntent();
        editTitle = findViewById(R.id.newNote_editTitle);
        editBody = findViewById(R.id.newNote_editText);
        doneButton = findViewById(R.id.newNote_doneButton);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title", editTitle.getText().toString());
                intent.putExtra("body", editBody.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
