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

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    ArrayList<Note> notes;
    Context context;
    public NoteAdapter(ArrayList<Note> notes, Context context){
        this.notes = notes;
        this.context = context;
    }

    //Create ViewHolder
    @NonNull @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_model, viewGroup, false);
        NoteViewHolder nvh = new NoteViewHolder(v);
        return nvh;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int position) {
        Note note = notes.get(position);
        noteViewHolder.onBind(note);
    }

    public void addItem(int position, Note note){
        this.notes.add(position, note);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

}
