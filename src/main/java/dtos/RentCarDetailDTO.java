package dtos;/*  gaajiCode
    99
    08/09/2024
    */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentCarDetailDTO {
    private String rentID;
    private String carID;
    private String driverID;
    private PaymentDTO  payment;
}
