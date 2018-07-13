import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

public class UnitTestBase {

    private ClassPathXmlApplicationContext context;



    public  UnitTestBase (){
       try{
           context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml".split("[,\\s]+"));
           context.start();
       }catch (Exception e){
           System.out.println("============");
           e.printStackTrace();
       }

    }


    public <T extends Object> T  getBean(String name){

        try{
            return   (T)context.getBean(name);
        }catch (BeansException e){
            System.out.println("------------");
            e.printStackTrace();;
            return null;
        }


    }

}
