import com.cn.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class Test {
    public static void main(String[] args) throws IOException {
        //mybatis配置文件
        String resource="mybatis-config.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Person person=new Person();
        person.setId(1);
        person.setName("xxx");
        person.setAge(20);
        sqlSession.insert("com.cn.dao.PersonMapper.insert",person);
        sqlSession.commit();
        System.out.println(person.getId());
    }
}
