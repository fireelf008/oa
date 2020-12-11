package com.yhxd.modular.system.dao;

import com.yhxd.modular.system.entity.DictType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictTypeDao extends JpaRepository<DictType, Long> {

}
