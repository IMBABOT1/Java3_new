import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FourTest {
    @Parameterized.Parameters
    public static Collection<Object[]> params(){
        return Arrays.asList(new Object[][]{
                {new int[]{1,5,4,3,5,4,4,8,9,4,0,3,2}, new int[]{3,2}},
                {new int[]{8,2,4,36,585,4,32}, new int[]{32}},
                {new int[]{8,2,36,585,4,32}, new RuntimeException()},
                {new int[]{92,6,4,3,3,4,1,2,3,5,5,69,32}, new int[]{1,2,3,5,5,69,32}}
        });
    }
}
