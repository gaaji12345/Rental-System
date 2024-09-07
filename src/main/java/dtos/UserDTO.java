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
public class UserDTO {
    private String userName;
    private String password;
    private String role;
}
