package com.wangmin.dao;

import com.wangmin.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 会员的dao接口
 */
@Repository
public interface IMemberDao {

    //根据id查询会员信息
    @Select("select * from member where id = #{memberId}")
    Member findById(String memberId);
}
