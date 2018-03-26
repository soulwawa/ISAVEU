package org.Isaveu;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ISaveUApplication {

	public static void main(String[] args) {
		SpringApplication.run(ISaveUApplication.class, args);
	}
	/*
	 * SqlSessionFactory 설정 
	 */
	@Bean
	//스프링에 필요한 객체를 생성
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		/*
		 * sqlSessionFactory() : Mybatis의 sqlSqlSessionFactory를 반환
		 * 스프링부트가 실행할 때 DataSource객체를 이 메서드 실행 시 주입해서 결과를 만들고, 
		 * 그 결과를 스프링내 빈으로 사용
		 */
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
}