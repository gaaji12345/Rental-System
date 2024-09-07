package repo;/*  gaajiCode
    99
    07/09/2024
    */

import entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query(value = "SELECT customerID FROM Customer ORDER BY customerID DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT * FROM Customer WHERE user_userName=?", nativeQuery = true)
    Customer customerDetail(String userName);
}
