package com.soar.basicframework.insurance.dao;

import com.soar.basicframework.base.BaseDao;
import com.soar.basicframework.insurance.model.InsuredPersonInformation;
import com.soar.basicframework.insurance.model.PolicyholderInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 投保业务持久层接口
 * @author Soar
 * @date 2018/5/2
 */
@Mapper
public interface InsuranceDao extends BaseDao<PolicyholderInformation> {
    /**
     * 插入被投保人信息
     * @param insuredPersonInformation
     * @return
     */
    int insertInsuredPersonInformation(InsuredPersonInformation insuredPersonInformation);

    /**
     * 获取被投保人信息
     * @param pId 投保人id
     * @return
     */
    List<InsuredPersonInformation> getInsuredPersonInformation(String pId);
}
