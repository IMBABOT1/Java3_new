import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.imbabot.java3.lesson6.JunitTests;

public class ExceptionTest {
    private JunitTests junitTests;

    @Before
    public void init(){
        junitTests = new JunitTests();
    }


    @Test
    public void exceptionTest(){
        try {
            junitTests.method(new int[]{8, 2, 36, 585, 5, 32});
        }catch (RuntimeException e){
            Assert.assertTrue(true);
        }
    }
}
