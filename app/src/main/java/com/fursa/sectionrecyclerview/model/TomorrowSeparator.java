package com.fursa.sectionrecyclerview.model;

public class TomorrowSeparator implements INote {
    @Override
    public boolean isNote() {
        return false;
    }

    @Override
    public boolean isToday() {
        return false;
    }

    @Override
    public boolean isTomorrow() {
        return true;
    }
}
