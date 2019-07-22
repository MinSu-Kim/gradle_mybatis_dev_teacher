package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kr.or.yi.gradle_mybatis_dev_teacher.dto.Address;

public interface AddressMapper {
	List<Address> selectAddressByAll(RowBounds rowBounds);
}
