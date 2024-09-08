package repo;/*  gaajiCode
    99
    07/09/2024
    */

import entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,String> {
}
