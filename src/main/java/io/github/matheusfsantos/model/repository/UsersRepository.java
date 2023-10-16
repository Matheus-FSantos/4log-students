package io.github.matheusfsantos.model.repository;

import io.github.matheusfsantos.model.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
}
