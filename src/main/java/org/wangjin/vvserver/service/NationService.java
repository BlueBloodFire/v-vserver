package org.wangjin.vvserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wangjin.vvserver.mapper.NationMapper;
import org.wangjin.vvserver.model.Nation;

import java.util.List;

@Service
public class NationService {

    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
