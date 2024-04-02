package myShoopingMarch.MyShopping.repository;

import myShoopingMarch.MyShopping.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<AppUser, UUID> {
}
