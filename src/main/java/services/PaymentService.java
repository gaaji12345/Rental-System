package services;/*  gaajiCode
    99
    08/09/2024
    */

import dtos.PaymentDTO;
import dtos.meta.PaymentMetaDTO;

import java.util.ArrayList;

public interface PaymentService {
    void addPayment(PaymentDTO paymentDTO);

    ArrayList<PaymentMetaDTO> getAllPayments();

    void updatePayment(String paymentID,String total);
}
