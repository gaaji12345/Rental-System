package repo;/*  gaajiCode
    99
    07/09/2024
    */

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    User findByUserName(String userName);
}
