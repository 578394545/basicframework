package com.soar.basicframework.insurance.service;

import com.soar.basicframework.base.BaseDao;
import com.soar.basicframework.base.BaseServiceImpl;
import com.soar.basicframework.insurance.dao.InsuranceDao;
import com.soar.basicframework.insurance.model.InsuredPersonInformation;
import com.soar.basicframework.insurance.model.PolicyholderInformation;
import com.soar.basicframework.utils.GUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * 投保业务服务层实现
 * @author Soar
 * @date 2018/5/2
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class InsuranceServiceImpl extends BaseServiceImpl<PolicyholderInformation> implements InsuranceService {

    @Resource
    private InsuranceDao insuranceDao;

    /**
     * 抽象方法，必须实现，返回DAO实例
     *
     * @return DAO实例
     */
    @Override
    public BaseDao<PolicyholderInformation> getDao() {
        return insuranceDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertInformation(PolicyholderInformation p, List<InsuredPersonInformation> params) {
        p.setPId(GUID.getPrimaryKeyId());
        p.setPCreateTime(Calendar.getInstance().getTime());
        insuranceDao.insert(p);

        for (InsuredPersonInformation i : params){
            if(i.getIpRelation() == 1){
                i.setICardType(p.getPCardType());
                i.setICard(p.getPCard());
                i.setIName(p.getPName());
            }

            i.setPId(p.getPId());
            i.setIId(GUID.getPrimaryKeyId());
            i.setICreateTime(Calendar.getInstance().getTime());
            insuranceDao.insertInsuredPersonInformation(i);
        }
    }

    /**
     * 获取被投保人信息
     *
     * @param pId 投保人id
     * @return
     */
    @Override
    public List<InsuredPersonInformation> getInsuredPersonInformation(String pId) {
        return insuranceDao.getInsuredPersonInformation(pId);
    }
}
