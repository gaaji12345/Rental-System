package entity;/*  gaajiCode
    99
    07/09/2024
    */

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class LoginDetail {
    @Id
    private String loginID;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    private User user;
    private String date;

    private String time;
}
