package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.gradle_mybatis_dev_teacher.AbstractTest;
import kr.or.yi.gradle_mybatis_dev_teacher.dto.Address;

public class AddressMapperTest extends AbstractTest {
	private static AddressMapper addressDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		addressDao = new AddressMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		addressDao = null;
	}

	@Test
	   public void test01selectAddressByAll() {
	      RowBounds rowBounds = new RowBounds(0, 2);
	      List<Address> lists = addressDao.selectAddressByAll(rowBounds);
	      Assert.assertNotNull(lists);

	   }

	   @Test
	   public void test02selectAddressByAll() {
	      RowBounds rowBounds = new RowBounds(2, 2);
	      List<Address> lists = addressDao.selectAddressByAll(rowBounds);
	      Assert.assertNotNull(lists);
	   }


}
