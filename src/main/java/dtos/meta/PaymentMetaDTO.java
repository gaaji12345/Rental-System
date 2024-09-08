package dtos.meta;/*  gaajiCode
    99
    08/09/2024
    */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentMetaDTO {
    private String paymentID;
    private double waiverDeductions;
    private String  waiverSlip;
    private double extraMileagePayment;
}
