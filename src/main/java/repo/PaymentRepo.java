package repo;/*  gaajiCode
    99
    07/09/2024
    */

import entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,String> {
}
