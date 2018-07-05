package com.github.bruce.test;

import com.github.bruce.test.service.ArbitraryDependency;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ArbitraryDependencyTest extends BaseTest {

    @Autowired
    private ArbitraryDependency autowiredFieldDependency;


    @Test
    public void givenAutowiredAnnotation_WhenOnField_ThenDepValid() {
        assertNotNull(autowiredFieldDependency);
        assertEquals("Arbitrary Dependency", autowiredFieldDependency.toString());
    }

}
