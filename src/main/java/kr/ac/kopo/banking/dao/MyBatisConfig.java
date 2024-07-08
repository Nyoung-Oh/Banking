package kr.ac.kopo.banking.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {

	private SqlSession session;
	
	public MyBatisConfig() {
		
		try {
			String resource = "db/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SqlSession getInstance() {
		return session;
	}
	public static void main(String args[]) {
		MyBatisConfig config=new MyBatisConfig();
		SqlSession session=config.getInstance();
		System.out.println("session="+session);
	}
}
