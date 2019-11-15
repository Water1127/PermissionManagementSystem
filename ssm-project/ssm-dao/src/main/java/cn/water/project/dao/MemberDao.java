package cn.water.project.dao;

import cn.water.project.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author Water
 * @date 2019/11/3 - 16:24
 * @description
 */
public interface MemberDao {

    /** 根据Id，查询会员信息 */
    @Select("SELECT * FROM member WHERE id = #{memberId}")
    Member findById(String memberId) throws Exception;

}
