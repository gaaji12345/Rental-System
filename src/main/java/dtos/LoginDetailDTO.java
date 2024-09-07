package dtos;/*  gaajiCode
    99
    07/09/2024
    */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDetailDTO {
    private String loginID;
    private UserDTO user;
    private String date;
    private String time;
}
