package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class ProductionSheet {
        private String machineNumber;
        private String partName;
        private String material;
        private String partWeight;
        private String actualProduction;
        private String machineStatus;

        public ProductionSheet(String machineNumber, String partName, String material, String partWeight, String actualProduction, String machineStatus) {
                this.machineNumber = machineNumber;
                this.partName = partName;
                this.material = material;
                this.partWeight = partWeight;
                this.actualProduction = actualProduction;
                this.machineStatus = machineStatus;
        }

}
