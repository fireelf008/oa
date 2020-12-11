package com.yhxd.modular.system.dao;

import com.yhxd.modular.system.entity.RoleResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleResourceDao extends JpaRepository<RoleResource, Long> {

}
