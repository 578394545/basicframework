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

    /**
     * 插入投保信息
     * @param p
     * @param params
     */
    void insertInformation(PolicyholderInformation p,List<InsuredPersonInformation> params);

    /**
     * 获取被投保人信息
     * @param pId 投保人id
     * @return
     */
    List<InsuredPersonInformation> getInsuredPersonInformation(String pId);
}
