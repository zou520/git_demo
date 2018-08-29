package uril;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 连接和关闭方法
 * @author Administrator
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory factory;
	static{//在静态代码块下，factory只会被创建一次
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SqlSession createSqlSession(){
		return factory.openSession(false);//true为自动提交事务
	}
	public static void closeSqlSession(SqlSession sqlSession){
		if(null!=sqlSession){
			sqlSession.close();
		}
	}
}
