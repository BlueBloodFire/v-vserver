package org.wangjin.vvserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangjin.vvserver.mapper.JObLevelMapper;
import org.wangjin.vvserver.model.JObLevel;

import java.util.Date;
import java.util.List;

@Service
public class JobLevelService {

    @Autowired
    JObLevelMapper jobLevelMapper;

    public List<JObLevel> getAllJobLevels() {
        return jobLevelMapper.getAllJobLevels();
    }

    public Integer addJobLevel(JObLevel jobLevel) {
        jobLevel.setcreateDate(new Date());
        jobLevel.setEnabled(true);
        return jobLevelMapper.insertSelective(jobLevel);
    }

    public Integer updateJobLevelById(JObLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteJobLevelById(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJobLevelsByIds(Integer[] ids) {
        return jobLevelMapper.deleteJobLevelByIds(ids);
    }
}
