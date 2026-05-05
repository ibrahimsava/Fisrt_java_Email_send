package org.example.execice_ticket_emailnotification.Repository;
import org.example.execice_ticket_emailnotification.Enity.UsersImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersImplrRepository extends JpaRepository<UsersImpl, Integer> {
    UsersImpl findByUsername(String email);
}
