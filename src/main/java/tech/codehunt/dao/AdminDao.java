package tech.codehunt.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import tech.codehunt.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "UPDATE admin SET username = :newusername, password = :newpassword WHERE username = :oldusername", nativeQuery = true)
    int updateCredential(
            @Param("newusername") String newusername,
            @Param("newpassword") String newpassword,
            @Param("oldusername") String oldusername
    );
}
