package com.prog34.entries;

public class Blanket implements Cover {
    String coverName;

    public Blanket(String coverName) {
        this.coverName = coverName;
    }

    @Override
    public String getCoverName() {
        return this.coverName;
    }
}
