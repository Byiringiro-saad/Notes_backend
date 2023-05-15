package com.example.notes.repositories;

import com.example.notes.models.UserModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UserModel, Long> {
    UserModel findUserByEmail(String email);

    Optional<UserModel> findUserByEmailAndPassword(String email, String password);
}
