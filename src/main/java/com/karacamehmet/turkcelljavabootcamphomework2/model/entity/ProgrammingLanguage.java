package com.karacamehmet.turkcelljavabootcamphomework2.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgrammingLanguage {
    private int id;
    private String name;

    public ProgrammingLanguage(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProgrammingLanguage() {
    }
}