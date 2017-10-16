package utils;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ����mybatis�����࣬������dao�л�ȡ�͹ر�
 * @author 46098
 */
public class MyBatisUtils {
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	private static SqlSessionFactory sqlSessionFactory;
	/**
	 * ����mybatis.xml�����ļ�
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
	 * ��ֹ�ⲿ����ʵ����
	 */
	private MyBatisUtils(){}
	/**
	 * ��ȡsqlsession
	 * @return
	 */
	public static SqlSession getSelSession(){
		//�ӵ�ǰ�̻߳�ȡsqlsession
		SqlSession sqlSession =  threadLocal.get();
		//�����ǰ�߳���ô��sqlsession
		if(sqlSession == null){
			//ʹ��factory��ȡsqlsession
			sqlSession = sqlSessionFactory.openSession();
			//���̺߳�sqlsession
			threadLocal.set(sqlSession);
		}
		return sqlSession;
	}
	public static void closeSqlSession(){
		//�ӵ�ǰ�߳��й�ȥsqlsession
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession != null){
			//�رմ�sqlsession
			sqlSession.close();
			//����ǰ�߳���sqlsession�ֿ�����GC�������
			threadLocal.remove();
		}
	}
	
	public static void main(String[] args) {
		Connection connection = MyBatisUtils.getSelSession().getConnection();
		System.out.println(connection);
	}
	
}
