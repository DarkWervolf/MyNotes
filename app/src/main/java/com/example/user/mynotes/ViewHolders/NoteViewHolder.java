package com.example.user.mynotes.ViewHolders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.mynotes.Models.Note;
import com.example.user.mynotes.R;

import java.util.ArrayList;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    public TextView titleView;
    public TextView textView;


    public NoteViewHolder(View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.note_titleView);
        textView = itemView.findViewById(R.id.note_textView);
    }

    public void onBind(Note note) {
        titleView.setText(note.getTitle());
        textView.setText(note.getText());
    }
}
