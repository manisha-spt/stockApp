package com.stock.stockApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stock.stockApp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
