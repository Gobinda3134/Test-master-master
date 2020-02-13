package com.example.e_softwarica;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Testing {
    testing arithmetic=null;
    @Before
    public void setUp()
    {
        arithmetic=new testing();
    }
    @Test
    public void testlogin()
    {
        testing arithmetic=new testing();
        String expectedResult="Login successfully";
        String actualResult=arithmetic.login("username", "password");
        assertEquals(expectedResult, actualResult);

    }


}
