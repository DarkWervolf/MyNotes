package com.example.user.mynotes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.user.mynotes.Adapters.NoteAdapter;
import com.example.user.mynotes.Models.Note;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private NoteAdapter adapter;
    final ArrayList<Note> notes = new ArrayList<>();
    private Snackbar mSnackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new NoteAdapter(notes, this);
        recyclerView.setAdapter(adapter);
        ConstraintLayout mainLayout = findViewById(R.id.main_layout);

        FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.main_button_addNote);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        if(notes.isEmpty()){
            mSnackbar = Snackbar.make(mainLayout, "Welcome! Let's add a first note!",
                    Snackbar.LENGTH_LONG)
                    .setAction("Go!", snackbarOnClickListener);
            mSnackbar.show();
        }
    }

    View.OnClickListener snackbarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
            startActivityForResult(intent, 1);
        }
    };

    Note createNote(String title, String text){
        Date currentDate = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String timeText = timeFormat.format(currentDate);

        Note newNote = new Note(title, text, timeText);
        return newNote;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        else {
            String title = data.getStringExtra("title");
            String text = data.getStringExtra("body");
            notes.add(createNote(title, text));
            adapter.notifyItemChanged(notes.size());
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Note was successfully added!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
