package test;

import driver.Driver;
import org.junit.jupiter.api.Test;

public class demo {
    @Test
    public void startTest(){
        Driver driver=new Driver();
        try {
            driver.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
