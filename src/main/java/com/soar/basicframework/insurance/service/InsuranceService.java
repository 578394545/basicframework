package com.soar.basicframework.insurance.service;

import com.soar.basicframework.base.BaseService;
import com.soar.basicframework.insurance.model.InsuredPersonInformation;
import com.soar.basicframework.insurance.model.PolicyholderInformation;

import java.util.List;

/**
 * 投保业务服务层接口
 * @author Soar
 * @date 2018/5/2
 */
public interface InsuranceService extends BaseService<PolicyholderInformation> {

    void insertInformation(PolicyholderInformation p,List<InsuredPersonInformation> params);
}
