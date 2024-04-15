package org.wangjin.vvserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wangjin.vvserver.model.JObLevel;
import org.wangjin.vvserver.model.RespBean;
import org.wangjin.vvserver.service.JobLevelService;

import java.util.List;

@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    // 获取工作等级所有信息
    @GetMapping("/")
    public List<JObLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    // 添加工作等级
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JObLevel jObLevel) {
        if (jobLevelService.addJobLevel(jObLevel) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    // 更新工作等级
    @PutMapping("/")
    public RespBean updateJobLevelById(@RequestBody JObLevel jObLevel) {
        if (jobLevelService.updateJobLevelById(jObLevel) == 1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    // 依据用户id删除相应工作等级
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevelById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    // 删除工作等级集群
    @DeleteMapping("/")
    public RespBean deleteJobLevelByIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelsByIds(ids) == ids.length) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
