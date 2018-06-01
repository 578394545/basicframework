package com.jingji.insurance.insurance.controller;

import com.jingji.insurance.constant.EmployeeResultStatus;
import com.jingji.insurance.constant.GlobalResultStatus;
import com.jingji.insurance.constant.InsuranceResultStatus;
import com.jingji.insurance.dict.model.Dict;
import com.jingji.insurance.dict.service.DictService;
import com.jingji.insurance.employee.model.Employee;
import com.jingji.insurance.insurance.model.InsuredPersonInformation;
import com.jingji.insurance.insurance.model.PolicyholderInformation;
import com.jingji.insurance.insurance.model.SchemeVO;
import com.jingji.insurance.insurance.service.InsuranceService;
import com.jingji.insurance.insurance.service.SchemeService;
import com.jingji.insurance.json.JsonResult;
import com.jingji.insurance.push.service.SmsService;
import com.jingji.insurance.utils.DateUtil;
import com.jingji.insurance.utils.JsonUtil;
import com.jingji.insurance.utils.StringUtil;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Resource
    private SchemeService schemeService;

    @Resource
    private DictService dictService;

    @Resource
    private SmsService smsService;

    /**
     * 检查员工输入的信息是否正确
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insurance",method = RequestMethod.POST)
    public Object insurance(PolicyholderInformation p,String insuredPersonInformations,HttpServletRequest request,String pInsuranceString) {
        //insuredPersonInformations格式
        //[{"ipRelation": 1,"iname": "soar","icardType": 1,"icard": "412154216484842","pid": "aduxc213","ibirth":"1991-02-26"},{"ipRelation": 1,"iname": "soar","icardType": 1,"icard": "412154216484842","pid": "aduxc213","ibirth":"1991-02-26"}]

        Employee employee = (Employee) request.getSession().getAttribute(EmployeeResultStatus.CURRENT_EMPLOYEE);
        if(null == employee){
            return JsonResult.fail(GlobalResultStatus.USER_LOGIN_SESSION_TIME_OUT);
        }
        if(StringUtil.isEmptyAny(p.getPName(),p.getPCard(),p.getPEmail(),p.getPPhone()) || null == p.getPCardType()
                || null == p.getPIsAppend() || null == p.getPPrice() || null == p.getPItem()){
            return JsonResult.fail(GlobalResultStatus.PARAM_MISSING);
        }
        if(StringUtil.isEmpty(insuredPersonInformations)){
            //被投保人为空
            return JsonResult.fail(InsuranceResultStatus.INSURED_CANNOT_BE_EMPTY);
        }
        if(p.getPCardType() == 1){
            //如果是用的身份证，校验身份证格式
            if(!StringUtil.validateIDCard(p.getPCard())){
                return JsonResult.fail(InsuranceResultStatus.IDCARD_ERROR);
            }
        }
        List<InsuredPersonInformation> params = JsonUtil.json2List(insuredPersonInformations,InsuredPersonInformation.class);
        for(InsuredPersonInformation i : params){
            if(StringUtil.isEmptyAny(i.getICard(),i.getIName())
                    || null == i.getICardType() || null == i.getIpRelation() || null == i.getIBirth()){
                return JsonResult.fail(GlobalResultStatus.PARAM_MISSING);
            }
            if(i.getICardType() == 1){
                //如果是用的身份证，校验身份证格式
                if(!StringUtil.validateIDCard(i.getICard())){
                    return JsonResult.fail(InsuranceResultStatus.INSURED_IDCARD_ERROR);
                }
            }
        }
        if(!StringUtil.isEmail(p.getPEmail())){
            //邮箱格式不对
            return JsonResult.fail(GlobalResultStatus.BAD_MAILBOX_FORMAT);
        }
        if(!StringUtil.isTelephone(p.getPPhone())){
            //手机号格式不对
            return JsonResult.fail(GlobalResultStatus.BAD_PHONE_FORMAT);
        }
        if(null == pInsuranceString){
            //默认字典项
            Dict dict = dictService.get(EmployeeResultStatus.INSURANCE_DATE);
            String pInsurance = dict.getDValue();
            p.setPInsuranceDate(DateUtil.parse(pInsurance,DateUtil.FMT_DATE));
        }else{
            p.setPInsuranceDate(DateUtil.parse(pInsuranceString,DateUtil.FMT_DATE));
        }
        if(null == p.getPIsPay()){
            //默认未付款
            p.setPIsPay(0);
        }
        p.setENumber(employee.getNumber());
        insuranceService.insertInformation(p,params);
        return JsonResult.success();
    }


    /**
     * 获取支付信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getPayment")
    public Object getPayment(HttpServletRequest request, BigDecimal price){
        Employee employee = (Employee) request.getSession().getAttribute(EmployeeResultStatus.CURRENT_EMPLOYEE);
        if(null == employee){
            return JsonResult.fail(GlobalResultStatus.USER_LOGIN_SESSION_TIME_OUT);
        }
        //调用甲方提供的支付接口
        System.out.print(employee.getName());

        return JsonResult.success();
    }

    /**
     * 支付
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pay")
    public Object pay(HttpServletRequest request){
        Employee employee = (Employee) request.getSession().getAttribute(EmployeeResultStatus.CURRENT_EMPLOYEE);
        if(null == employee){
            return JsonResult.fail(GlobalResultStatus.USER_LOGIN_SESSION_TIME_OUT);
        }
        //调用甲方提供的支付接口，完成支付操作
        boolean result = true;

        if(result){
            Map<String, Object> resultMap = new HashMap<>(16);
            //获取投保人信息
            PolicyholderInformation param = new PolicyholderInformation();
            param.setENumber(employee.getNumber());
            List<PolicyholderInformation> policyholderInformations = insuranceService.getList(param);
            PolicyholderInformation policyholderInformation = policyholderInformations.get(0);
            Map<String, Object> pMap = new HashMap<>(16);
            pMap.put("pitem",policyholderInformation.getPItem());
            pMap.put("pisAppend",policyholderInformation.getPIsAppend());
            pMap.put("pinsuranceString",policyholderInformation.getPInsuranceDate());
            resultMap.put("policyholderInformation",pMap);

            //修改投保人支付状态
            insuranceService.update(policyholderInformation);

            //根据投保人主键id获取被投保人信息
            List<InsuredPersonInformation> insuredPersonInformations =
                    insuranceService.getInsuredPersonInformation(policyholderInformation.getPId());
            List<Map<String, Object>> iList = new LinkedList<>();
            Map<String, Object> iMap = new HashMap<>(16);
            for(InsuredPersonInformation i : insuredPersonInformations){
                iMap.put("iname",i.getIName());
                iList.add(iMap);
            }
            resultMap.put("insuredPersonInformations",iList);

            //调用甲方提供的短信接口，发送短信，
            // 模板：尊敬的客户，恭喜您已投保完成，我们将尽快处理您的投保信息，保单号将于10月1日后发送到您的邮箱，请注意查收。【人保财险】
            String phone = policyholderInformation.getPPhone();
            String msg = "尊敬的客户，恭喜您已投保完成，我们将尽快处理您的投保信息，保单号将于10月1日后发送到您的邮箱，请注意查收。【人保财险】";
            smsService.sendSms(phone,msg);
            return JsonResult.success(resultMap);
        }

        return JsonResult.fail(GlobalResultStatus.ERROR);
    }
    /**
     * 获取方案信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getScheme")
    public Object getScheme(HttpServletRequest request){
        Employee employee = (Employee) request.getSession().getAttribute(EmployeeResultStatus.CURRENT_EMPLOYEE);
        if(null == employee){
            return JsonResult.fail(GlobalResultStatus.USER_LOGIN_SESSION_TIME_OUT);
        }

        List<SchemeVO> list = schemeService.getScheme();
        Dict dict = dictService.get(EmployeeResultStatus.INSURANCE_DATE);
        String pInsuranceString = dict.getDValue();

        Map<String, Object> result = new HashMap<>(16);
        result.put("scheme",list);
        result.put("pInsuranceString",pInsuranceString);
        result.put("timeLimit",1);

        return JsonResult.success(result);
    }
}
