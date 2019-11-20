package com.catalog.models;

public enum Category {
    Mechanical(1), Diagnostic(2), Detail(3);

    private int index;
    Category(int index){
        this.index = index;
    }
    public int getIndex(){
        return index;
    }
}
