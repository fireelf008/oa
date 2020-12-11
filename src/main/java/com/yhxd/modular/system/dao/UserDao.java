package com.yhxd.modular.system.dao;

import com.yhxd.modular.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsernameAndEnable(String username, Integer enable);
}
