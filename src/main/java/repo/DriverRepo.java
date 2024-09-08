package repo;/*  gaajiCode
    99
    07/09/2024
    */

import entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {
}
