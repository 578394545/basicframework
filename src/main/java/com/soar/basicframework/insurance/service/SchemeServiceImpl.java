package com.soar.basicframework.insurance.service;

import com.soar.basicframework.base.BaseDao;
import com.soar.basicframework.base.BaseServiceImpl;
import com.soar.basicframework.insurance.dao.InsuranceDao;
import com.soar.basicframework.insurance.dao.SchemeDao;
import com.soar.basicframework.insurance.model.InsuredPersonInformation;
import com.soar.basicframework.insurance.model.PolicyholderInformation;
import com.soar.basicframework.insurance.model.Scheme;
import com.soar.basicframework.utils.GUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * 方案服务层实现
 * @author Soar
 * @date 2018/5/8
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SchemeServiceImpl extends BaseServiceImpl<Scheme> implements SchemeService {

    @Resource
    private SchemeDao schemeDao;

    /**
     * 抽象方法，必须实现，返回DAO实例
     *
     * @return DAO实例
     */
    @Override
    public BaseDao<Scheme> getDao() {
        return schemeDao;
    }

}
