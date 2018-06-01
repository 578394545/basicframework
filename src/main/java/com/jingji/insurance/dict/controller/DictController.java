package com.jingji.insurance.dict.controller;

import com.jingji.insurance.constant.DictConstants;
import com.jingji.insurance.constant.GlobalResultStatus;
import com.jingji.insurance.dict.model.Dict;
import com.jingji.insurance.dict.model.DictVO;
import com.jingji.insurance.dict.service.DictService;
import com.jingji.insurance.employee.model.Employee;
import com.jingji.insurance.insurance.model.TrafficVO;
import com.jingji.insurance.json.JsonResult;
import com.jingji.insurance.utils.SessionUtil;
import com.jingji.insurance.constant.EmployeeResultStatus;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * 字典信息读取控制器
 * @author Soar
 * @date 2018/5/2
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/dict")
public class DictController {

    @Resource
    private DictService dictService;

    /**
     * 获取证件类型
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCardType")
    public Object getCardType(HttpServletRequest request) {
       if(!SessionUtil.checkSession(request)){
           return JsonResult.fail(GlobalResultStatus.USER_LOGIN_SESSION_TIME_OUT);
       }

        List<DictVO> result = setValues(new Dict(DictConstants.CARD_TYPE_TYPE));

        return null == result ? JsonResult.fail(GlobalResultStatus.NO_DATA) : JsonResult.success(result);
    }

    /**
     * 获取投保人与被投保人关系列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getRelationship")
    public Object getRelationship(HttpServletRequest request) {
        if(!SessionUtil.checkSession(request)){
            return JsonResult.fail(GlobalResultStatus.USER_LOGIN_SESSION_TIME_OUT);
        }

        List<DictVO> result = setValues(new Dict(DictConstants.RELATIONSHIP));

        return null == result ? JsonResult.fail(GlobalResultStatus.NO_DATA) : JsonResult.success(result);
    }

    /**
     * po2vo
     * @param param
     * @return
     */
    private List<DictVO> setValues(Dict param){
        List<Dict> dicts = dictService.getList(param);
        if(null != dicts && dicts.size() > 0){
            List<DictVO> result = new LinkedList<>();
            for (Dict dict : dicts){
                DictVO dictVO = new DictVO();
                dictVO.setNo(dict.getDNo());
                dictVO.setValue(dict.getDValue());
                result.add(dictVO);
            }
            return result;
        }
        return null;
    }

    /**
     * 获取交通保险信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getTraffic")
    public Object getTraffic(HttpServletRequest request){
        Employee employee = (Employee) request.getSession().getAttribute(EmployeeResultStatus.CURRENT_EMPLOYEE);
        if(null == employee){
            return JsonResult.fail(GlobalResultStatus.USER_LOGIN_SESSION_TIME_OUT);
        }

        List<Dict> list = dictService.getList(new Dict(DictConstants.TRAFFIC));
        TrafficVO result = new TrafficVO();
        for (Dict dict : list){
            switch (dict.getDNo()){
                case 1 :
                    result.setItem(dict.getDValue());
                    continue;
                case 2 :
                    result.setQuota(dict.getDValue());
                    continue;
                case 3 :
                    result.setPremium(dict.getDValue());
                    continue;
                case 4 :
                    result.setRemark(dict.getDRemark());
                    continue;
            }
        }
        return JsonResult.success(result);
    }
}
