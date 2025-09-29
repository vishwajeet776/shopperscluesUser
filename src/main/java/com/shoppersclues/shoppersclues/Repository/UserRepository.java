package com.shoppersclues.shoppersclues.Repository;

import com.shoppersclues.shoppersclues.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
