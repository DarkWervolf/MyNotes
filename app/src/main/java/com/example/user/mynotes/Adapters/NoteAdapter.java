package com.example.user.mynotes.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.user.mynotes.Models.Note;
import com.example.user.mynotes.R;
import com.example.user.mynotes.ViewHolders.NoteViewHolder;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter {

    List<Note> notes;
    public NoteAdapter(List<Note> notes){
        this.notes = notes;
    }

    //Create ViewHolder
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_model, viewGroup, false);
        NoteViewHolder nvh = new NoteViewHolder(v);
        return nvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    }

    public void onBindViewH(NoteViewHolder noteViewHolder, Note note) {
        noteViewHolder.onBind(note);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return notes.size();
    }

}
