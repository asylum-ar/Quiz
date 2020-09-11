package org.sid.dao;

import org.sid.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    @Query("select u from AppUser u  where  UPPER(u.username)  =  UPPER(:x) " )
	public AppUser findByUsername(@Param("x") String Username);
}
