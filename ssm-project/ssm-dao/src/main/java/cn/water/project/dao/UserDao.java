package cn.water.project.dao;

import cn.water.project.domain.Orders;
import cn.water.project.domain.Role;
import cn.water.project.domain.UserInfo;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/5 - 10:18
 * @description
 */
public interface UserDao {

    /** 根据Username，查询用户信息（登录） */
    @Select("SELECT * FROM users WHERE username = #{username}")
    @Results(
        id = "userMap",
        value = {@Result(id = true,property = "id",column = "id"),
                @Result(property = "username",column = "username"),
                @Result(property = "email",column = "email"),
                @Result(property = "password",column = "password"),
                @Result(property = "phoneNum",column = "phoneNum"),
                @Result(property = "status",column = "status"),
                @Result(property = "roles",
                        column = "id",
                        javaType = List.class,
                        many = @Many(select = "cn.water.project.dao.RoleDao.findByUserId"))
    })
    UserInfo findByUsername(String username) throws Exception;

    /** 查询所有用户信息（展示） */
    @Select("SELECT * FROM users")
    List<UserInfo> findAll() throws Exception;

    /** 添加新用户（添加） */
    @Insert("INSERT INTO users(id,email,username,password,phoneNum,status) " +
            "VALUES(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    /** 根据id，查询用户信息（详情） */
    @Select("SELECT * FROM users WHERE id = #{userId}")
    @ResultMap("userMap")
    UserInfo findById(String userId) throws Exception;

    /** 根据id，查询用户可以关联的角色（关联角色） */
    @Select("SELECT * FROM role WHERE id NOT IN (SELECT roleId FROM users_role WHERE userId = #{userId})")
    List<Role> findOtherRoles(String userId) throws Exception;

    /** 添加用户和角色的关联（关联角色） */
    @Insert("INSERT INTO users_role VALUES(#{userId},#{roleId})")
    void addRoleToUser( @Param("userId") String userId, @Param("roleId") String roleId) throws Exception;

    /** 根据id，删除用户（删除） */
    @Delete("DELETE FROM users WHERE id=#{userId}")
    void deleteUserById(String userId) throws Exception;


}
