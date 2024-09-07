package entity;/*  gaajiCode
    99
    07/09/2024
    */

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    private String customerID;
    private String name;
    private String address;
    private String email;
    private String contactNo;
    private String licenseNo;
    private String frontImage;
    private String backImage;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
