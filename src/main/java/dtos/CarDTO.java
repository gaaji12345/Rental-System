package dtos;/*  gaajiCode
    99
    07/09/2024
    */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDTO {
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
    MultipartFile frontImage;
    MultipartFile rearImage;
    MultipartFile sideImage;
    MultipartFile interiorImage;
}
