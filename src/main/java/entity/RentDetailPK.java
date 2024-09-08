package entity;/*  gaajiCode
    99
    08/09/2024
    */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentDetailPK  implements Serializable {
    private String rentId;
    private String carId;
}
