package se.project.coalingot.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se.project.coalingot.security.entity.Authority;
import se.project.coalingot.security.entity.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName input);
}
