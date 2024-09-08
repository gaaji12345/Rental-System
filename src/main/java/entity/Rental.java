package entity;/*  gaajiCode
    99
    08/09/2024
    */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Rental {
    @Id
    private String rentID;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerID",referencedColumnName = "customerID",nullable = false)
    private Customer customerID;
    private String pickupDate;
    private String pickupTime;
    private String  duration;
    private String status;
    private String declineReason;

    @OneToMany(mappedBy = "rent", cascade = CascadeType.ALL)
    private List<RentCarDetail> rentDetails;
}
