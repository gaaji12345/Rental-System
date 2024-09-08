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

public class DriverDTO {
    private String driverID;
    private String drivingLicenceNo;
    private String driverName;
    private String email;
    private String contactNo;
    private MultipartFile frontImage;
    private MultipartFile backImage;
    private UserDTO user;
}
