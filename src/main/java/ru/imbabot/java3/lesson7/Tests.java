package ru.imbabot.java3.lesson7;

public class Tests {

    @BeforeSuite(priority = 1)
    public void BeforeSuite(){
        System.out.println("BeforeSuite");
    }
    @Test(priority = 2)
    public void test1(){
        System.out.println("test1");
    }
    @Test(priority = 3)
    public void test2(){
        System.out.println("test2");
    }
    @Test(priority = 4)
    public void test3(){
        System.out.println("test3");
    }
    @Test(priority = 5)
    public void test4(){
        System.out.println("test4");
    }
    @Test(priority = 6)
    public void test5(){
        System.out.println("test5");
    }
    @Test(priority = 7)
    public void test6(){
        System.out.println("test6");
    }
    @Test(priority = 8)
    public void test7(){
        System.out.println("test7");
    }
    @Test(priority = 9)
    public void test8(){
        System.out.println("test8");
    }
    @AfterSuite(priority = 10)
    public void afterSuite(){
        System.out.println("AfterSuite");
    }
}
