package com.demo.springboot;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.demo.api.util.StringRegExp;

public class StringMatcherTest {
    private StringRegExp regExp;

    @Before
    public void setup(){
    	regExp = new StringRegExp();
    }
    //API will only accept English Capital Letter. If not, reject and throw error message, or otherwise
    @Test
    public void testIsAlpha() {
    	assertFalse(regExp.isAlpha(null));
        assertFalse(regExp.isAlpha(" "));
        assertTrue(regExp.isAlpha("   T "));
        assertFalse(regExp.isAlpha("The World"));
        assertFalse(regExp.isAlpha(" the world"));
        assertTrue(regExp.isAlpha("THE WORLD"));
        assertTrue(regExp.isAlpha(" THE WORLD"));
        assertFalse(regExp.isAlpha("THE1 WORLD1"));
        assertFalse(regExp.isAlpha("The1 World 1"));
        assertTrue(regExp.isAlpha("A HEN  HAS  MANY   CHICKS"));
        assertFalse(regExp.isAlpha("THE WORLD."));
        assertFalse(regExp.isAlpha("THE WORLD #"));
    }
    
    
    @Test
    public void testConvertAlpha() {
    	assertEquals(null,regExp.convertAlpha(null));
        assertEquals(" ",regExp.convertAlpha(" "));
        assertEquals("t3",regExp.convertAlpha("   T "));
        assertEquals("dlrow1eht",regExp.convertAlpha("The World"));
        assertEquals("dlrow1eht1",regExp.convertAlpha(" the world"));
        assertEquals("dlrow1eht",regExp.convertAlpha("THE WORLD"));
        assertEquals("dlrow1eht1",regExp.convertAlpha(" THE WORLD"));
        assertEquals("1dlrow11eht",regExp.convertAlpha("THE1 WORLD1"));
        assertEquals("11dlrow11eht",regExp.convertAlpha("The1 World 1"));
        assertEquals("skcihc3ynam2sah2neh1a",regExp.convertAlpha("A HEN  HAS  MANY   CHICKS"));
        assertEquals(".dlrow1eht",regExp.convertAlpha("THE WORLD."));
        assertEquals("#1dlrow1eht",regExp.convertAlpha("THE WORLD #"));
    }

}
