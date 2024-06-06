package com.imaginnovate.Dto;

public class DivisionsDto {
    
    private int id;

    private String name;

    private int parent;

    public DivisionsDto() {
        
    }

    public DivisionsDto(int id, String name, int parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    
}
