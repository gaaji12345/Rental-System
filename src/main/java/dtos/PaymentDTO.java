package dtos;/*  gaajiCode
    99
    08/09/2024
    */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
    private String paymentID;
    private double waiverDeductions;
    private MultipartFile waiverSlip;
    private double extraMileagePayment;
}
