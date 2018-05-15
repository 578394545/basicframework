package com.soar.basicframework.insurance.service;

import com.soar.basicframework.base.BaseDao;
import com.soar.basicframework.base.BaseServiceImpl;
import com.soar.basicframework.insurance.dao.SchemeDao;
import com.soar.basicframework.insurance.model.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.LinkedList;
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

    /**
     * 获取方案内容
     *
     * @return
     */
    @Override
    public List<SchemeVo> getScheme() {
        List<SchemeVo> schemeVos = new LinkedList<>();
        List<Scheme> list = schemeDao.getList(new Scheme());
        for(Scheme scheme : list){
            //获取价格信息
            schemeVos = getPrice(scheme,schemeVos);

            List<SchemeDetail> schemeDetails = scheme.getSchemeDetail();
            for(SchemeDetail schemeDetail : schemeDetails){
                String dValue = schemeDetail.getDValue();

                String content = schemeDetail.getSdContent();
//
                JSONArray jsonArray = new JSONArray(content);
                int length = jsonArray.length();
                for(int i = 0; i < length ; i++){
                    JSONObject contentJson = new JSONObject(jsonArray.get(i));
                    Iterator<String> it = contentJson.keySet().iterator();
                    while (it.hasNext()) {
                        SchemeDetailContent schemeDetailContent = new SchemeDetailContent();
                        //年龄
                        String age = it.next();
                        schemeDetailContent.setAge(age);

                    }

                }
            }
        }

        return schemeVos;
    }

    private List<SchemeVo> getPrice(Scheme scheme,List<SchemeVo> schemeVos) {
        SchemeVo schemeVo = new SchemeVo();
        schemeVo.setSId(scheme.getSId());
        schemeVo.setSName(scheme.getSName());

        //投保金额json
        String premium = scheme.getSPremium();
        JSONObject premiumJson = new JSONObject(premium);
        //投保个数限制json
        String limitNumber = scheme.getSRemark();
        JSONObject limitJson = new JSONObject(limitNumber);

        Iterator<String> it = premiumJson.keySet().iterator();
        List<SchemePrice> schemePrices = new LinkedList<>();
        while (it.hasNext()) {
            SchemePrice schemePrice = new SchemePrice();
            //投保年龄
            String age = it.next();
            schemePrice.setAge(age);
            //金额
            schemePrice.setPrice((String) premiumJson.get(age));
            //个数限制
            schemePrice.setLimit((Integer) limitJson.get(age));
            schemePrices.add(schemePrice);
        }
        schemeVo.setSchemePrices(schemePrices);
        schemeVos.add(schemeVo);
        return schemeVos;
    }
}
