package com.sms.service;

import com.sms.dao.SCMapper;
import com.sms.pojo.SC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SCService {
    @Autowired
    private SCMapper scMapper;

    int addSC(SC sc) {
        return scMapper.addSC(sc);
    }

    int deleteSC(int studentID, int courseID) {
        return scMapper.deleteSC(studentID, courseID);
    }

    public int updateSC(SC sc) {
        return scMapper.updateSC(sc);
    }
}
