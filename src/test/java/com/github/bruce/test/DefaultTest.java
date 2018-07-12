package com.github.bruce.test;

import com.github.bruce.test.config.ApplicationContextTestAutowiredName;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader=AnnotationConfigContextLoader.class,
        classes=ApplicationContextTestAutowiredName.class)
public class DefaultTest {

}
