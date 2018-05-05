package com.fursa.sectionrecyclerview.model;

public class TodaySeparator implements INote {
    @Override
    public boolean isNote() {
        return false;
    }

    @Override
    public boolean isToday() {
        return true;
    }

    @Override
    public boolean isTomorrow() {
        return false;
    }
}
