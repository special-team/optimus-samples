package test;

import com.github.ooknight.rubik.core.kernel.DBContext;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Module;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:develop.properties")
public class Demo {

    @Resource
    private ApplicationContext context;
    @Resource
    private JavaMailSender sender;
    //
    @Value("${spring.mail.from}")
    private String from;
    @Resource
    private TemplateEngine templateEngine;

    @Test
    public void test() {
        //FunctionAgent agent = context.getBean(FunctionAgent.class);
        //List r =
        //
        //List r = context.getBean(DBContext.class)
        //    .createQuery(Module.class).fetch("function","name")
        //    .where().eq("function.isMenu", 1).findList();
        //
        //List r = context.getBean(DBContext.class)
        //    .createNamedQuery(Module.class, "get-module-list-with-function").setDisableLazyLoading(true).findList();
        //
        List r = context.getBean(DBContext.class).createQuery(Module.class)
            //.fetch("function").where().eq("t1.is_menu_", 1)
            .filterMany("function").eq("isMenu", 1)
            .findList();
        //List r = Ebean.createQuery(Module.class, "select (+query,function) where function.isMenu=1").findList();
        //List r = Ebean.createQuery(Module.class, "fetch function join function where function.isMenu=1").findList();
        //
        System.out.println(r);
    }

    @Test
    public void test2() throws Exception {
        MimeMessage mailMessage = sender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
        Context context = new Context();
        List<String> messages = Lists.newArrayList();
        messages.add("1");
        messages.add("2");
        messages.add("3");
        context.setVariable("messages", messages);
        mimeMessageHelper.setFrom(from);
        //message.setFrom("");
        mimeMessageHelper.setTo("ooknight@163.com");
        mimeMessageHelper.setSubject("主题：测试邮件1");
        mimeMessageHelper.setText(templateEngine.process("portal/email/order", context), true);
        sender.send(mimeMessageHelper.getMimeMessage());
    }

    @Test
    public void test3() throws Exception {
        MimeMessage mailMessage = sender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo("ooknight@163.com");
        mimeMessageHelper.setSubject("主题：测试简单邮件1");
        mimeMessageHelper.setText("test");
        sender.send(mimeMessageHelper.getMimeMessage());
    }
}
