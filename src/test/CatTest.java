import com.lpc.other.aspect.two.Cat;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liupengcheng1 on 2017/1/5.
 */
public class CatTest extends BaseTest {

    @Autowired
    private Cat cat;

    @Test
    public void testRun(){
        cat.run();
    }

}
