package utils;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 创建mybatis工具类，方便在dao中获取和关闭
 * @author 46098
 */
public class MyBatisUtils {
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	private static SqlSessionFactory sqlSessionFactory;
	/**
	 * 加载mybatis.xml配置文件
	 */
	static{
		try {
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * 禁止外部方法实例化
	 */
	private MyBatisUtils(){}
	/**
	 * 获取sqlsession
	 * @return
	 */
	public static SqlSession getSelSession(){
		//从当前线程获取sqlsession
		SqlSession sqlSession =  threadLocal.get();
		//如果当前线程中么有sqlsession
		if(sqlSession == null){
			//使用factory获取sqlsession
			sqlSession = sqlSessionFactory.openSession();
			//绑定线程和sqlsession
			threadLocal.set(sqlSession);
		}
		return sqlSession;
	}
	public static void closeSqlSession(){
		//从当前线程中过去sqlsession
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession != null){
			//关闭此sqlsession
			sqlSession.close();
			//将当前线程与sqlsession分开，让GC尽早回收
			threadLocal.remove();
		}
	}
	
	public static void main(String[] args) {
		Connection connection = MyBatisUtils.getSelSession().getConnection();
		System.out.println(connection);
	}
	
}
