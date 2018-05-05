package com.fursa.sectionrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fursa.sectionrecyclerview.adapter.NoteAdapter;
import com.fursa.sectionrecyclerview.model.INote;
import com.fursa.sectionrecyclerview.model.Note;
import com.fursa.sectionrecyclerview.model.TodaySeparator;
import com.fursa.sectionrecyclerview.model.TomorrowSeparator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvNotes;
    private NoteAdapter mNoteAdapter;

    Calendar calendar = Calendar.getInstance();

    Date mDate = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNotes = (RecyclerView) findViewById(R.id.recycler);
        mNoteAdapter = new NoteAdapter(fillList());
        rvNotes.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        rvNotes.setAdapter(mNoteAdapter);

    }

    private List<INote> fillList() {
        List<INote> items = new ArrayList<>();
        Date today = new Date();
        items.add(new TodaySeparator());
        items.add(new Note("Test 0", "Test 0", new Date()));
        items.add(new Note("Test 1", "Test 1", new Date()));
        items.add(new TomorrowSeparator());
        items.add(new Note("Test 2", "Test 2", new Date(today.getTime() + (1000 * 60 * 60 * 24))));
        return items;
    }


}
