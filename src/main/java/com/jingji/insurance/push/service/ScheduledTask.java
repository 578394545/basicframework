package com.jingji.insurance.push.service;

import com.jingji.insurance.insurance.model.BeanForExcel;
import com.jingji.insurance.insurance.model.InsuredPersonInformation;
import com.jingji.insurance.insurance.model.PolicyholderInformation;
import com.jingji.insurance.insurance.service.InsuranceService;
import com.jingji.insurance.push.util.EmailConfig;
import com.jingji.insurance.utils.DateUtil;
import com.jingji.insurance.utils.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * 定时任务
 * @author Soar
 * @date 2018/5/30
 */
@Component
public class ScheduledTask {

    static
    {
        System.setProperty("mail.mime.charset", "UTF-8");
    }

    private static Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    @Resource
    private EmailConfig emailConfig;
    @Resource
    private InsuranceService insuranceService;


    @Scheduled(cron = "0 0 19 * * ?")
    public void sendEmail() throws IOException {
        log.info("now time:" + DateUtil.getUtcDate());

        List<String> recipients = new ArrayList<>();
        recipients.add(emailConfig.getSendTo());
        String subject = "今日投保信息";
        String content ;
        //获取投保人与被投保人信息，并生成excel文件
        PolicyholderInformation param = new PolicyholderInformation();
        param.setPCreateTime(Calendar.getInstance().getTime());
        List<PolicyholderInformation> list = insuranceService.getList(param);
        if(null != list && list.size() > 0){
            //获取投保信息，并封装成导出excel使用的bean
            List<BeanForExcel> beanForExcels = getInsurance(list);
            //生成excel
            ExcelUtil<BeanForExcel> export = new ExcelUtil<>(BeanForExcel.class);
            FileOutputStream fout = new FileOutputStream("Insurance.xls");
            export.exportExcel(beanForExcels, "投保信息", 100,fout);

            //发送邮件
            content = "今日投保信息见附件excel文件";
            Map<String, String> emailHost = emailConfig.getEmailUrlMap();
            if(null != emailHost ){
                log.info("发送邮件给："+ recipients.get(0));
                List<File>  files = new ArrayList<>();
                File file = new File("Insurance.xls");
                files.add(file);
                boolean flag = sendEmails(recipients, subject, content,emailHost,files);
                if(flag){
                    //删除文件
                    file.delete();
                }
            }
            fout.close();
        }else{
            content = "今日无人投保";
            Map<String, String> emailHost = emailConfig.getEmailUrlMap();
            if(null != emailHost ){
                log.info("发送邮件给："+ recipients.get(0));
                sendEmails(recipients, subject, content,emailHost,null);
            }
        }

    }

    private boolean sendEmails(List<String> recipients, String subject, String content, Map<String, String> emailHost,List<File> fileList) {
        boolean flag = true;
        String host = emailHost.get("host");
        String port = emailHost.get("port");
        final String user = emailHost.get("user");
        final String password = emailHost.get("password");
        String auth = emailHost.get("auth");

        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", auth);
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.port", port);

        Authenticator authenticator = null;
        if (auth.equals("true"))
        {
            authenticator = new Authenticator()
            {
                @Override
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(user, password);
                }
            };
        }

        Session session = Session.getInstance(props, authenticator);

        try
        {
            Message msg = new MimeMessage(session);
            msg.setSentDate(new Date());
            msg.setFrom(new InternetAddress(user));
            msg.setSubject(subject);

            int receiverCount = recipients.size();
            if (receiverCount > 0) {
                InternetAddress[] address = new InternetAddress[receiverCount];
                for (int i = 0; i < receiverCount; i++) {
                    address[i] = new InternetAddress((String) recipients.get(i));
                }
                msg.addRecipients(Message.RecipientType.TO, address);
            }

            Multipart multipart = new MimeMultipart();

            if (fileList != null && fileList.size() != 0){
                for (int i = 0; i < fileList.size(); i++){
                    File f = (File) fileList.get(i);
                    FileDataSource fds = new FileDataSource(f);
                    BodyPart fileBodyPart = new MimeBodyPart();
                    fileBodyPart.setDataHandler(new DataHandler(fds));
                    //如果附件有中文通过转换没有问题了
                    fileBodyPart.setFileName(MimeUtility.encodeText(f.getName(),"utf-8",null));
                    multipart.addBodyPart(fileBodyPart);
                }
            }

            if (content != null){
                BodyPart htmlPart = new MimeBodyPart();
                htmlPart.setContent(content, "text/html;charset=utf-8");
                multipart.addBodyPart(htmlPart);
            }

            msg.setContent(multipart);
            Transport.send(msg);
        }
        catch (Exception e)
        {
            log.info("发送邮件异常：", e);
            flag = false;
        }
        log.info("发送邮件成功");
        return flag;
    }

    /**
     * 获取投保信息，并封装成导出excel使用的bean
     * @param list
     * @return
     */
    private List<BeanForExcel> getInsurance(List<PolicyholderInformation> list){
        //当天有人投保，则继续
        List<BeanForExcel> beanForExcels = new LinkedList<>();
        for(PolicyholderInformation p : list){
            BeanForExcel beanForExcel = new BeanForExcel();
            beanForExcel.setPItem(p.getSName());
            beanForExcel.setPName(p.getPName());
            beanForExcel.setPCardType(p.getdValue());
            beanForExcel.setPCard(p.getPCard());
            beanForExcel.setPPhone(p.getPPhone());
            beanForExcel.setPEmail(p.getPEmail());

            //获取被保险人信息
            List<InsuredPersonInformation> insuredPersonInformations =
                    insuranceService.getInsuredPersonInformation(p.getPId());
            for(InsuredPersonInformation i : insuredPersonInformations){
                beanForExcel.setIName(i.getIName());
                beanForExcel.setICardType(i.getdValue());
                beanForExcel.setICard(i.getICard());
                beanForExcel.setIBirth(DateUtil.format(i.getIBirth(),DateUtil.FMT_DATE));
                beanForExcel.setBeneficiary("法定");
                BigDecimal price = p.getPPrice().divide(BigDecimal.valueOf(insuredPersonInformations.size()));
                beanForExcel.setPrice(String.valueOf(price));
                beanForExcels.add(beanForExcel);
            }
        }
        return beanForExcels;
    }
}
