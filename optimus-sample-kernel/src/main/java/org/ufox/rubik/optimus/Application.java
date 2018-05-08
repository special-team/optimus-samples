package org.ufox.rubik.optimus;

import com.github.ooknight.rubik.core.kernel.DBContext;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * see @EnableCaching(order = 1)
 * see @EnableTransactionManagement(order = 2)
 * see @EnableAspectJAutoProxy(proxyTargetClass = true)
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder().sources(Application.class).run(args);
        System.out.println(context.getBean(DBContext.class));
        System.out.println(context.getBean(CacheManager.class));
        System.out.println(context.getBean(PlatformTransactionManager.class));
    }
}
