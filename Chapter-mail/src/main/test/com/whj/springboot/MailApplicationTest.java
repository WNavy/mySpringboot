package com.whj.springboot;

import com.whj.MailApplication;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by wuhaijun on 2017/9/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MailApplication.class)
public class MailApplicationTest {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送普通邮件
     */
    @Test
    public void sendSimpleMail(){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("826818399@qq.com");
        message.setTo("826818399@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);

    }

    /**
     * 发送带有附件的邮件
     */
    @Test
    public void sendAttachmentsMail() throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("826818399@qq.com");
        helper.setTo("826818399@qq.com");
        helper.setSubject("主题：有附件的邮件");
        helper.setText("注意查看附件");

        FileSystemResource file = new FileSystemResource(new File(this.getClass().getResource("/image/1.jpg").getPath()));
        helper.addAttachment("附件",file);

        mailSender.send(mimeMessage);

    }

    /**
     * 发送嵌入静态资源的邮件
     */
    @Test
    public void sendInlineMail() throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("826818399@qq.com");
        helper.setTo("826818399@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("嵌入静态资源", true);
        FileSystemResource file = new FileSystemResource(new File(this.getClass().getResource("/image/1.jpg").getPath()));
        helper.addInline("美女", file);

        mailSender.send(mimeMessage);

    }

}
