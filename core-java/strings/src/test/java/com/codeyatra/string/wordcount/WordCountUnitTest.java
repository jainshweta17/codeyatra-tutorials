package com.codeyatra.string.wordcount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordCountUnitTest {

	@Test
    public void testCountUsingSplit() {
        String stringTocheck = " I  like    my Mother's Cookies, Cake and Icecream but not chocolates! ";
        int count = WordCount.countUsingSplit(stringTocheck);
        System.out.println("Test: [" + stringTocheck + "] count is [" + count + "]");
		assertEquals(11, count);
    }

    @Test
    public void testCountUsingStringTokenizer() {
        String stringTocheck = " I  like    my Mother's Cookies, Cake and Icecream but not chocolates! ";
        int count = WordCount.countUsingStringTokenizer(stringTocheck);
		System.out.println("Test: [" + stringTocheck + "] count is [" + count + "]");
        assertEquals(12, count);
    }

    @Test
    public void testCountUsingApacheStringUtils() {
        String stringTocheck = " I  like    my Mother's Cookies, Cake and Icecream but not chocolates! ";
        int count = WordCount.countUsingApacheStringUtils(stringTocheck);
		System.out.println("Test: [" + stringTocheck + "] count is [" + count + "]");
        assertEquals(12, count);
    }

    @Test
    public void testCountUsingApacheStringUtils1() {
        String stringTocheck = " the[[[end  ";
        int count = WordCount.countUsingApacheStringUtils(stringTocheck);
		System.out.println("Test: [" + stringTocheck + "] count is [" + count + "]");
        assertEquals(2, count);
    }

    /*
     * Please include the spring-core dependency and then uncomment below code, 
     * to test the StringUtils of spring framework.
     */
	/*
    @Test
    public void testCountUsingSpringStringUtils() {
        String stringTocheck = " I  like    my Mother's Cookies, Cake and Icecream but not chocolates! ";
        int count = WordCount.countUsingSpringStringUtils(stringTocheck);
		System.out.println("Test: [" + stringTocheck + "] count is [" + count + "]");
        assertEquals(12, count);
    }
	*/
}
