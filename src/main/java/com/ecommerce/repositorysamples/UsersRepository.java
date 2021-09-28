package com.ecommerce.repositorysamples;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ecommerce.modelsamples.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
	
	
	public Users getUsersByUsername(@Param("username") String username);
	
	List<Users> findByUsername(@Param("username") String username);
    }
