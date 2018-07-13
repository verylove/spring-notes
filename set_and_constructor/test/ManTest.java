import com.yt.service.ManService;
import com.yt.service.WoManService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


@RunWith(BlockJUnit4ClassRunner.class)
public class ManTest extends UnitTestBase {

    @Test
    public void eatConstructor() {
        ManService man  = (ManService)super.getBean("manService");
        if(man!=null){
            man.eatByConstructor("haha");
        }else{
            System.out.println("00000000000");
        }

    }

    @Test
    public void eat() {
        WoManService woManService  = (WoManService)super.getBean("woManService");
        if(woManService!=null){
            woManService.eat("xixi");
        }else{
            System.out.println("00000000000");
        }

    }
}