package com.example.user.mynotes;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    final String LOG_TAG = "myLogs";
    final String FILENAME = "file";
    final String DIR_SD = "MyFiles";
    final String FILENAME_SD = "fileSD";

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
                writeFile();
                Intent intent = new Intent();
                intent.putExtra("101", editTitle.getText().toString());
                setResult(101, intent);
                finish();
            }
        });
    }

    void writeFile() {
        try {
            // отрываем поток для записи
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(editTitle.getText().toString(), MODE_PRIVATE)));
            // пишем данные
            bw.write(editBody.getText().toString());
            // закрываем поток
            bw.close();
            Log.d(LOG_TAG, "Файл записан");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
