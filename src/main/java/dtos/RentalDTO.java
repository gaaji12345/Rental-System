package dtos;/*  gaajiCode
    99
    08/09/2024
    */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalDTO {
    private String rentID;
    private String customerID;
    private String pickupDate;
    private String pickupTime;
    private String  duration;
    private String status;
    private String declineReason;
    private List<RentCarDetailDTO> rentDetails;
}
