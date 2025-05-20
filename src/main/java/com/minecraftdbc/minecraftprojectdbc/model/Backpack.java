package com.minecraftdbc.minecraftprojectdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table ("backpack")
public class Backpack {
    
    @Id
    @Column("idBackpack")
    private Long idBackpack;

    @Column("capacity")
    private int capacity;

    @Column("color")
    private String color;

    @Column("currentWeight")
    private float currentWeight;
    
    @Column("backpackStatus")
    private String backpackStatus;

    // Reference to Player One to One
    @Column("idPlayer")
    private AggregateReference<Player,Long> idPlayer; 
   
}
