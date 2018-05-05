package com.fursa.sectionrecyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fursa.sectionrecyclerview.R;
import com.fursa.sectionrecyclerview.holder.LateViewHolder;
import com.fursa.sectionrecyclerview.holder.NoteViewHolder;
import com.fursa.sectionrecyclerview.holder.TodayViewHolder;
import com.fursa.sectionrecyclerview.model.INote;
import com.fursa.sectionrecyclerview.model.Note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_NOTE = 0;
    private static final int TYPE_LATELY = 1;
    private static final int TYPE_TODAY = 2;

    private Date today = new Date();

    private List<INote> notes;

    public NoteAdapter(List<INote> notes) {
        this.notes = notes;
    }

    public INote getItem(int position) {
        return notes.get(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_NOTE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note, parent, false);
                TextView tvTitle = view.findViewById(R.id.title);
                TextView tvText = view.findViewById(R.id.text);
                TextView tvCreated = view.findViewById(R.id.created);
                return new NoteViewHolder(view, tvTitle, tvText, tvCreated);
            case TYPE_TODAY:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.today, parent, false);
                return new TodayViewHolder(view);
            case TYPE_LATELY:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tomorrow, parent, false);
                return new LateViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        INote item = notes.get(position);
        if (item.isNote()) {
            final NoteViewHolder noteHolder = (NoteViewHolder) holder;
            holder.itemView.setEnabled(true);
            Note note = (Note) item;
            noteHolder.title.setText(note.getTitle());
            noteHolder.text.setText(note.getText());
            noteHolder.created.setText(new SimpleDateFormat("d MMMM yyyy HH:mm", new Locale("ru")).format(note.getCreated()));
        } else if (item.isTomorrow()) {
            final LateViewHolder lateViewHolder = (LateViewHolder) holder;
            lateViewHolder.itemView.setEnabled(true);
        } else if (item.isToday()){
            final TodayViewHolder todayViewHolder = (TodayViewHolder) holder;
            todayViewHolder.itemView.setEnabled(true);
        }

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position).isToday()) {
            return TYPE_TODAY;
        }

        if (getItem(position).isTomorrow()) {
            return TYPE_LATELY;
        } else return TYPE_NOTE;
    }
}

