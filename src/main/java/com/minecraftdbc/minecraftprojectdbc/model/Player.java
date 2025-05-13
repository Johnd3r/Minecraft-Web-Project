package com.minecraftdbc.minecraftprojectdbc.model;

public class Player {
    private int id;
    private String name;
    private int level;
    private int experience;
    private String password;

    // Constructor
    public Player(int id, String name, int level, int experience, String password) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.password = password;
    }

    public Player() {} // ConstrACuctor vacío (importante para cuando cargamos datos)

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }  
}
