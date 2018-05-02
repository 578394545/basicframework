package com.soar.basicframework.insurance.service;

import com.soar.basicframework.base.BaseDao;
import com.soar.basicframework.base.BaseServiceImpl;
import com.soar.basicframework.insurance.dao.InsuranceDao;
import com.soar.basicframework.insurance.model.PolicyholderInformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 投保业务服务层实现
 * @author Soar
 * @date 2018/5/2
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class InsuranceServiceImpl extends BaseServiceImpl<PolicyholderInformation> implements InsuranceService {

    @Resource
    private InsuranceDao EmployeeDao;

    /**
     * 抽象方法，必须实现，返回DAO实例
     *
     * @return DAO实例
     */
    @Override
    public BaseDao<PolicyholderInformation> getDao() {
        return EmployeeDao;
    }
}
