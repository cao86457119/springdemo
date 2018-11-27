package cn.com.kiva.springdemo.LogAop;

@log
public class logTest {
    public void runTest(){
        System.out.println("run runtest");
    }
    public static void main(String... args){
        logTest lt = new logTest();
        lt.runTest();
    }
}
