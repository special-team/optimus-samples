package test.org.ufox.rubik.optimus.kernel.business.customer.service;

import org.ufox.rubik.optimus.archer.business.customer.service.BusinessService;
import org.ufox.rubik.optimus.kernel.business.customer.config.ComplexConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:develop.properties")
@SpringBootTest(classes = ComplexConfiguration.class)
@EnableAutoConfiguration
public class BusinessServiceTest {

    @Resource
    private BusinessService businessService;

    @Test
    public void demo() {
        System.out.println(businessService);
    }
}
