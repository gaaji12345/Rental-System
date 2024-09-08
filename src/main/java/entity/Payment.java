package entity;/*  gaajiCode
    99
    08/09/2024
    */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Payment {
    @Id
    private String paymentID;
    private double waiverDeductions;
    private String waiverSlip;
    private double extraMileagePayment;
}
