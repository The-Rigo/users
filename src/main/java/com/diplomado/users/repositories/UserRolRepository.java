package com.diplomado.users.repositories;

import com.diplomado.users.domain.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolRepository extends JpaRepository<UserRol,Integer> {
}
