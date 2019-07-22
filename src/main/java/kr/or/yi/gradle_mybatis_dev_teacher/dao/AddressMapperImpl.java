package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_dev_teacher.dto.Address;
import kr.or.yi.gradle_mybatis_dev_teacher.jdbc.MyBatisSqlSessionFactory;

public class AddressMapperImpl implements AddressMapper {
	private String namespace="kr.or.yi.gradle_mybatis_dev_teacher.dao.AddressMapper";
	
	@Override
	public List<Address> selectAddressByAll(RowBounds rowBounds) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectAddressByAll", null,  rowBounds);
		}
		
	}

}
