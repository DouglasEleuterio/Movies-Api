package br.com.douglas.movies.repository;

import br.com.douglas.movies.models.ERole;
import br.com.douglas.movies.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
