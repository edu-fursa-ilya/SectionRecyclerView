package com.fursa.sectionrecyclerview.model;

import java.util.Date;

public class Note implements INote {
    private String title;
    private String text;
    private Date created;

    public Note(String title, String text, Date created) {
        this.title = title;
        this.text = text;
        this.created = created;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", created=" + created +
                '}';
    }

    @Override
    public boolean isNote() {
        return true;
    }

    @Override
    public boolean isToday() {
        return false;
    }

    @Override
    public boolean isTomorrow() {
        return false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
