package com.minecraftdbc.minecraftprojectdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.minecraftdbc.minecraftprojectdbc.model.enums.BackpackStatus;

import lombok.Data;

@Data
@Table ("backpack")
public class Backpack {
    
    @Id
    @Column("idBackpack")
    private Long idBackpack;

    @Column("capacity")
    private Integer capacity = 20;

    @Column("color")
    private String color = "#000000";

    @Column("currentWeight")
    private Float currentWeight = 0f;
    
    @Column("backpackStatus")
    private BackpackStatus backpackStatus;

    // Reference to Player One to One
    @Column("idPlayer")
    private AggregateReference<Player,Long> idPlayer; 
   
}
