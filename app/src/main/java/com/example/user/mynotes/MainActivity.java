package com.example.user.mynotes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NoteAdapter adapter;
    final ArrayList<Note> notes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new NoteAdapter(notes, this);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.button_addNote);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = null;
                Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    Note createNote(String title, String text){
        Note newNote = new Note(title, text);
        return newNote;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        String title = data.getStringExtra("title");
        String text = data.getStringExtra("body");
        notes.add(createNote(title, text));
        adapter.notifyItemChanged(notes.size());
        Toast toast = Toast.makeText(getApplicationContext(),
                "Note was successfully added!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
