package dtos.meta;/*  gaajiCode
    99
    07/09/2024
    */

import dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerMetaDTO {
    private String customerID;
    private String name;
    private String address;
    private String email;
    private String contactNo;
    private String licenseNo;
    private String frontImage;
    private String backImage;
    private UserDTO user;
}
