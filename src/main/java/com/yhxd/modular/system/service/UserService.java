package com.yhxd.modular.system.service;

import com.yhxd.modular.system.dao.ResourceDao;
import com.yhxd.modular.system.dao.UserDao;
import com.yhxd.modular.system.entity.Resource;
import com.yhxd.modular.system.entity.Role;
import com.yhxd.modular.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ResourceDao resourceDao;

    public List<User> findAll() {
        return this.userDao.findAll();
    }

    public List<Resource> loadResource(User user) {

        List<Resource> resourceList = null;

        //判断是否是超管，超管查询所有权限
        if (1 == user.getAdmin()) {
            resourceList = this.resourceDao.findAll();
        } else {
            List<Role> roleList = user.getRoleList();
            resourceList = new ArrayList<>();
            for (Role role : roleList) {
                resourceList.addAll(role.getResourceList());
            }
        }

        //去重并过滤按钮权限，然后按sort字段排序
        resourceList = resourceList.stream().distinct().filter(res -> 0 == res.getType()).sorted(Comparator.comparing(res -> res.getSort())).collect(Collectors.toList());

        //排除顶层菜单，按父id分组
        Map<Long, List<Resource>> groupResourceMap = resourceList.stream().filter(res -> null != res.getPid() && 0 != res.getPid()).collect(Collectors.groupingBy(res -> res.getPid()));

        for (Map.Entry<Long, List<Resource>> entry : groupResourceMap.entrySet()) {
            for (Resource resource : resourceList) {
                if (entry.getKey().equals(resource.getId())) {
                    resource.setChildResourceList(entry.getValue());
                    continue;
                }
            }
        }

        //获取顶层菜单
        List<Resource> rootResourceList = resourceList.stream().filter(res -> null == res.getPid() || 0 == res.getPid()).collect(Collectors.toList());
        return rootResourceList;
    }
}
