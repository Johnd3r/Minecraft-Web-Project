package com.minecraftdbc.minecraftprojectdbc.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column; // Agregado
import lombok.Data;
import com.minecraftdbc.minecraftprojectdbc.model.enums.MaterialStatus;

@Data
@Table("material")
public class Material {
    @Id
    @Column("idMaterial")
    private Long idMaterial;

    @Column("materialName")
    private String materialName;
    
    @Column("availableQuantity")
    private int availableQuantity;

    @Column("rarity")
    private String rarity; 

    @Column("materialStatus")
    private MaterialStatus materialStatus; 

}