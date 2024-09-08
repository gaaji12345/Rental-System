package repo;/*  gaajiCode
    99
    07/09/2024
    */

import entity.Rental;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RentalRepo  extends JpaRepository<Rental,String> {
    @Query(value = "SELECT rentID FROM Rental ORDER BY rentID DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}
