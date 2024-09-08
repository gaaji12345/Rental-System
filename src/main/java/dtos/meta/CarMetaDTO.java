package dtos.meta;/*  gaajiCode
    99
    07/09/2024
    */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarMetaDTO {
    String carID;
    String regNo;
    String brand;
    String type;
    String passenger;
    String color;
    String transmissionType;
    String fuelType;
    String extraMileagePrice;
    String currentMileage;
    String wavierPayment;
    String availability;
    String freeMileageDaily;
    String freeMileageDailyPrice;
    String freeMileageMonthly;
    String freeMileageMonthlyPrice;
    String frontImage;
    String  rearImage;
    String  sideImage;
    String  interiorImage;
}
