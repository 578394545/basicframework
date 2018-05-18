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
    public List<SchemeVO> getScheme() {
        List<SchemeVO> schemeVos = new LinkedList<>();

        List<Scheme> list = schemeDao.getList(new Scheme());
        for(Scheme scheme : list){

            SchemeVO schemeVo = new SchemeVO();
            schemeVo.setSId(scheme.getSId());
            schemeVo.setSName(scheme.getSName());

            //投保金额json
            String premium = scheme.getSPremium();
            JSONObject premiumJson = new JSONObject(premium);
            //投保个数限制json
            String limitNumber = scheme.getSRemark();
            JSONObject limitJson = new JSONObject(limitNumber);

            Iterator<String> it = premiumJson.keySet().iterator();
            List<SchemePriceVO> schemePrices = new LinkedList<>();
            while (it.hasNext()) {
                SchemePriceVO schemePrice = new SchemePriceVO();
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

            List<SchemeDetail> schemeDetails = scheme.getSchemeDetail();
            List<SchemeDetailVO> schemeDetailVOS = new LinkedList<>();
            for(SchemeDetail schemeDetail : schemeDetails){
                SchemeDetailVO schemeDetailVO = new SchemeDetailVO();
                schemeDetailVO.setDValue(schemeDetail.getDValue());

                String content = schemeDetail.getSdContent();
                String remark = schemeDetail.getSdRemark();
//
                JSONArray contentJsonArray = new JSONArray(content);
                JSONArray remarkJsonArray = new JSONArray(remark);
                int length = contentJsonArray.length();
                List<SchemeDetailContent> schemeDetailContents = new LinkedList<>();
                for(int i = 0; i < length ; i++){
                    JSONObject contentJson = new JSONObject(contentJsonArray.get(i).toString());
                    JSONObject remarkJson = new JSONObject(remarkJsonArray.get(i).toString());
                    Iterator<String> it2 = contentJson.keySet().iterator();
                    while (it2.hasNext()) {
                        SchemeDetailContent schemeDetailContent = new SchemeDetailContent();
                        //年龄
                        String age = it2.next();
                        schemeDetailContent.setAge(age);
                        schemeDetailContent.setPremium((String) contentJson.get(age));
                        schemeDetailContent.setRemark((String) remarkJson.get(age));

                        schemeDetailContents.add(schemeDetailContent);
                    }
                    schemeDetailVO.setContentList(schemeDetailContents);
                }
                schemeDetailVOS.add(schemeDetailVO);
                schemeVo.setSchemeDetailVOs(schemeDetailVOS);
            }
            schemeVos.add(schemeVo);
        }
        return schemeVos;
    }

}
