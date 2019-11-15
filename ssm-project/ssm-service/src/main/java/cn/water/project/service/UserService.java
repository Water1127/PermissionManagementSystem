package cn.water.project.service;

import cn.water.project.domain.Role;
import cn.water.project.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/5 - 10:14
 * @description
 */
public interface UserService extends UserDetailsService {

    /** 查询所有用户信息（展示） */
    List<UserInfo> findAll() throws Exception;

    /** 查询所有用户信息（展示），并分页 */
    List<UserInfo> findAllByPage (int pageNum, int pageSize) throws Exception;

    /** 添加用户 */
    void save(UserInfo userInfo) throws Exception;

    /** 根据id，查询用户信息（详情） */
    UserInfo findById(String id) throws Exception;

    /** 根据id，查询用户可以关联的角色（关联角色） */
    List<Role> findOtherRoles(String userId) throws Exception;

    /** 添加用户和角色的关联（关联角色） */
    void addRoleToUser(String userId,String[] roleIdList) throws Exception;

    /** 根据id，删除单个用户（删除） */
    void deleteUserById(String userId) throws Exception;

    /** 根据id，删除多个用户（删除） */
    void deleteUserListById(String[] userIdList) throws Exception;

}
