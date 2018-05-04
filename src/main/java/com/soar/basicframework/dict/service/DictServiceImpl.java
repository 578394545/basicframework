package com.soar.basicframework.dict.service;

import com.soar.basicframework.base.BaseDao;
import com.soar.basicframework.base.BaseServiceImpl;
import com.soar.basicframework.dict.dao.DictDao;
import com.soar.basicframework.dict.model.Dict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 数据字典服务层实现
 * @author Soar
 * @date 2018/5/4
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService {

    @Resource
    private DictDao dictDao;

    /**
     * 抽象方法，必须实现，返回DAO实例
     *
     * @return DAO实例
     */
    @Override
    public BaseDao<Dict> getDao() {
        return dictDao;
    }
}
