package cn.water.project.service;

import cn.water.project.dao.UserDao;
import cn.water.project.domain.Role;
import cn.water.project.domain.UserInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Water
 * @date 2019/11/5 - 10:14
 * @description
 */
@Service("userService")
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /** 根据Username，查询用户信息（登录） */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            /* 调用Dao持久层的方法 */
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* 创建SimpleGrantedAuthority对象 */
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        /* 获取 Role对象 */
        List<Role> roles = userInfo.getRoles();
        /* 设置权限，从数据库中获取 */
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        /* 将User对象封装为UserDetails（Spring security会自动帮助我们检查账号密码是否正确） */
        User user = new User(
                userInfo.getUsername(),
                userInfo.getPassword(),
                userInfo.getStatus() == 1 ? true : false,
                true,
                true,
                true,
                authorities);
        return user;
    }

    /** 查询所有用户信息（展示） */
    public List<UserInfo> findAll() throws Exception {
       return userDao.findAll();
    }

    /** 查询所有用户信息（展示），并分页 */
    public List<UserInfo> findAllByPage(int pageNum, int pageSize) throws Exception {
        /* PageHelper：pageNum表示页码值，pageSize表示每页显示数。 */
        PageHelper.startPage(pageNum,pageSize);/* 此行代码必须使用于调用具体MySQL数据库操作语句之前 */
        return userDao.findAll();
    }


    /** 添加新用户（添加） */
    public void save(UserInfo userInfo) throws Exception{
        /* 加密处理 */
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    /** 根据id，查询用户信息（详情） */
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    /** 根据id，查询用户可以关联的角色（关联角色） */
    public List<Role> findOtherRoles(String userId) throws Exception{
        return userDao.findOtherRoles(userId);
    }

    /** 添加用户和角色的关联（关联角色） */
    public void addRoleToUser(String userId,String[] roleIdList) throws Exception{
        for (String roleId : roleIdList) {
            userDao.addRoleToUser(userId,roleId);
        }
    }

    /** 根据id，删除单个用户（删除） */
    public void deleteUserById(String userId) throws Exception{
        System.out.println(userId);
        userDao.deleteUserById(userId);
    }

    /** 根据id，删除多个用户（删除） */
    public void deleteUserListById(String[] userIdList) throws Exception{
        for (String userId : userIdList) {
            userDao.deleteUserById(userId);
        }
    }

}
