package org.ufox.rubik.optimus;

import com.github.ooknight.rubik.optimus.archer.platform.service.PlatformService;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder().sources(Application.class).run(args);
        //
        PlatformService service = context.getBean(PlatformService.class);
        System.out.println(service.role());
        System.out.println(service.group());
        System.out.println(service.account());
        System.out.println(service.createAccountQuery().id.eq(1).findOne());
    }
}
