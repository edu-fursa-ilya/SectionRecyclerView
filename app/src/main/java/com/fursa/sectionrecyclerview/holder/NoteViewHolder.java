package com.fursa.sectionrecyclerview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView text;
    public TextView created;

    public NoteViewHolder(View itemView, TextView title, TextView text, TextView created) {
        super(itemView);
        this.title = title;
        this.text = text;
        this.created = created;
    }
}
