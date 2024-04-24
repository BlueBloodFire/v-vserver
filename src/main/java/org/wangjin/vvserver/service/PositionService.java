package org.wangjin.vvserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.wangjin.vvserver.mapper.PositionMapper;
import org.wangjin.vvserver.model.Position;

import java.util.Date;
import java.util.List;

@Service
public class PositionService {

    @Autowired
    PositionMapper positionMapper;

    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setcreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePositionById(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionByIds(Integer[] ids) {
        return positionMapper.deletePositionByIds(ids);
    }
}
