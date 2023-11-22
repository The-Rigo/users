package com.diplomado.users.repositories;

import com.diplomado.users.domain.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRolRepository extends JpaRepository<UserRol, Integer> {
    List<UserRol> findAllByUserId(Long user_id);
    List<UserRol> findAllByRolId(Integer rol_id);
}
