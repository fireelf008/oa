package com.yhxd.modular.system.dao;

import com.yhxd.modular.system.entity.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictDao extends JpaRepository<Dict, Long> {

}
