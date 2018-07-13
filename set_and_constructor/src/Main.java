import com.yt.service.ManService;
import com.yt.service.impl.ManImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
       ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
       context.start();
       ManService manService = (ManService) context.getBean("manService");
       manService.eatByConstructor("xixi");

    }
}
