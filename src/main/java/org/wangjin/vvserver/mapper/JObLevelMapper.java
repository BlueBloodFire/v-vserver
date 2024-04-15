package org.wangjin.vvserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.wangjin.vvserver.model.JObLevel;

import java.util.List;

public interface JObLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JObLevel record);

    int insertSelective(JObLevel record);

    JObLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JObLevel record);

    int updateByPrimaryKey(JObLevel record);

    List<JObLevel> getAllJobLevels();

    Integer deleteJobLevelByIds(@Param("ids") Integer[] ids);
}
