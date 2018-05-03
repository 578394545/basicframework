package com.soar.basicframework.insurance.controller;

import com.soar.basicframework.constant.EmployeeResultStatus;
import com.soar.basicframework.constant.GlobalResultStatus;
import com.soar.basicframework.constant.InsuranceResultStatus;
import com.soar.basicframework.insurance.model.InsuredPersonInformation;
import com.soar.basicframework.insurance.model.PolicyholderInformation;
import com.soar.basicframework.insurance.service.InsuranceService;
import com.soar.basicframework.json.JsonResult;
import com.soar.basicframework.utils.DateUtil;
import com.soar.basicframework.utils.JsonUtil;
import com.soar.basicframework.utils.StringUtil;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 投保业务管理控制器
 * @author Soar
 * @date 2018/5/2
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/insurance")
public class InsuranceController {

    @Resource
    private InsuranceService insuranceService;

    /**
     * 检查员工输入的信息是否正确
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insurance",method = RequestMethod.POST)
    public Object insurance(PolicyholderInformation p,String insuredPersonInformations) {
        //insuredPersonInformations格式
        //[{
        //	"IPRelation": 1,
        //	"iName": "soar",
        //	"iCardType": 1,
        //	"iCard": "412154216484842",
        //	"pId": "aduxc213"
        //},{
        //	"IPRelation": 1,
        //	"iName": "soar",
        //	"iCardType": 1,
        //	"iCard": "412154216484842",
        //	"pId": "aduxc213"
        //}]
        if(StringUtil.isEmptyAny(p.getPName(),p.getPCard(),p.getPEmail(),p.getPPhone()) || null == p.getPCardType()
                || null == p.getPIsAppend() || null == p.getPPrice() || null == p.getPItem()){
            return JsonResult.fail(GlobalResultStatus.PARAM_MISSING);
        }
        if(StringUtil.isEmpty(insuredPersonInformations)){
            //被投保人为空
            return JsonResult.fail(InsuranceResultStatus.INSURED_CANNOT_BE_EMPTY);
        }
        if(!StringUtil.isEmail(p.getPEmail())){
            //邮箱格式不对
            return JsonResult.fail(GlobalResultStatus.BAD_MAILBOX_FORMAT);
        }
        if(!StringUtil.isTelephone(p.getPPhone())){
            //手机号格式不对
            return JsonResult.fail(GlobalResultStatus.BAD_PHONE_FORMAT);
        }
        if(null == p.getPInsuranceDate()){
            //默认当前年份的10月1日
            p.setPInsuranceDate(new Date(Calendar.YEAR,10,1));
        }
        if(null == p.getPIsPay()){
            //默认未付款
            p.setPIsPay(0);
        }

        List<InsuredPersonInformation> params = JsonUtil.json2List(insuredPersonInformations,InsuredPersonInformation.class);

        insuranceService.insert(p);
        return JsonResult.success();
    }
}
