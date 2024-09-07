package dtos;/*  gaajiCode
    99
    07/09/2024
    */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CustomDTO {
    private String value;

    public CustomDTO(String lastIndex) {
        this.value=lastIndex;
    }

}
