package com.minecraftdbc.minecraftprojectdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import com.minecraftdbc.minecraftprojectdbc.model.enums.BuildingType;
import org.springframework.data.relational.core.mapping.Column; 

import lombok.Data;

@Data
@Table("buildings")

public class Buildings {
    @Id
    @Column("idBuilding")
    private Long idBuilding;

    @Column("buildingName")
    private String buildingName;

    @Column("buildingType") 
    private BuildingType buildingType;

    @Column("buildingStatus")
    private String buildingStatus;

    @Column("coordinates")
    private String coordinates;
    

}
