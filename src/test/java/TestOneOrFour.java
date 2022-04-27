import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.imbabot.java3.lesson6.JunitTests;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;

@RunWith(Parameterized.class)
public class TestOneOrFour {
    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,1,1,1,1,4,4,4,1,4,1,4,1,4}, true},
                {new int[]{1,1,1,1,1,1,1,1,}, false},
                {new int[]{1,1,1,1,1,1,4,4,4,4,1,4,1}, true},
                {new int[]{4,4,4,4,4,4,4,4,4,4}, false},
                {new int[]{4,1,4,3,1,5,5,7,9,10}, false}
        });
    }

    private int[] arr;
    private boolean bool;
    private JunitTests junitTests;

    public TestOneOrFour(int[]arr, boolean bool){
        this.arr = arr;
        this.bool = bool;
    }

    @Before
    public void init(){
        junitTests = new JunitTests();
    }


    @Test
    public void containsFour(){
        Assert.assertTrue(junitTests.oneOrFour(arr));
    }
}