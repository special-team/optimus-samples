package test.org.ufox.rubik.optimus.kernel.business.customer.service;

import com.github.ooknight.rubik.optimus.archer.platform.service.PlatformService;
import com.github.ooknight.rubik.optimus.kernel.KernelConfiguration;
import org.ufox.rubik.optimus.archer.business.customer.service.BusinessService;
import org.ufox.rubik.optimus.kernel.business.config.ComplexConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {KernelConfiguration.class, ComplexConfiguration.class})
@TestPropertySource("classpath:develop.properties")
public class BusinessServiceTest {

    @Resource
    private BusinessService businessService;
    @Resource
    private PlatformService platformService;

    @Test
    public void demo() {
        System.out.println(businessService);
        System.out.println(platformService);
    }
}
