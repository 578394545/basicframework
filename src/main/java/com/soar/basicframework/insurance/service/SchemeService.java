package com.soar.basicframework.insurance.service;

import com.soar.basicframework.base.BaseService;
import com.soar.basicframework.insurance.model.Scheme;
import com.soar.basicframework.insurance.model.SchemeVO;

import java.util.List;


/**
 * 方案服务层接口
 * @author Soar
 * @date 2018/5/9
 */
public interface SchemeService extends BaseService<Scheme> {

    /**
     * 获取方案内容
     * @return
     */
    List<SchemeVO> getScheme();
}
