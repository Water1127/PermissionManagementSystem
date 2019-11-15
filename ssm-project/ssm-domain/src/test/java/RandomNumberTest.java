import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Water
 * @date 2019/11/2 - 8:43
 * @description
 */
public class RandomNumberTest {

    @Test
    public void test(){
        String uuid1 = UUID.randomUUID().toString();
        System.out.println(uuid1);
    }

}
