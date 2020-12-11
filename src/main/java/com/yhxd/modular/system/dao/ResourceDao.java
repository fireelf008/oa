package com.yhxd.modular.system.dao;

import com.yhxd.modular.system.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceDao extends JpaRepository<Resource, Long> {

}
