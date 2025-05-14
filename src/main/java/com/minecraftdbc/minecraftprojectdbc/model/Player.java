package com.minecraftdbc.minecraftprojectdbc.model;

public class Player {
    private int id;
    private String name;
    private String level; // Cambiado a String (en tu SQL es VARCHAR)
    private float experience; // Cambiado a float (en tu SQL es FLOAT)
    private String playerType; // EXPLORER, BUILDER, WARRIOR
    private String password;

    // Constructor vacío (necesario para JDBC)
    public Player() {
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}