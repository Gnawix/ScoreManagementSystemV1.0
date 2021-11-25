package com.sms.dao;

import com.sms.pojo.SC;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SCMapper {

    @Insert("insert into sc values(#{studentID},#{courseID},#{score})")
    int addSC(SC sc);

    @Delete("delete from sc where studentID=#{studentID} and courseID=#{courseID}")
    int deleteSC(@Param("studentID") int studentID, @Param("courseID") int courseID);

    @Update("update sc set score=#{score} where studentID=#{studentID} and courseID=#{courseID}")
    int updateSC(SC sc);
}
