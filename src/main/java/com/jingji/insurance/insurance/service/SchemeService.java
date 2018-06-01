package com.jingji.insurance.insurance.service;

import com.jingji.insurance.insurance.model.SchemeVO;
import com.jingji.insurance.base.BaseService;
import com.jingji.insurance.insurance.model.Scheme;

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
