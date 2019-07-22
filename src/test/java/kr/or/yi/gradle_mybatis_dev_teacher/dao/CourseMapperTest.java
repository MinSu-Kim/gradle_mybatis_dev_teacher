package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.gradle_mybatis_dev_teacher.AbstractTest;
import kr.or.yi.gradle_mybatis_dev_teacher.dto.Course;

public class CourseMapperTest extends AbstractTest {
	private static CourseMapper courseDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		courseDao = new CourseMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		courseDao = null;
	}

	@Test
	public void testSelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String, Object> map = new HashMap<>();
		//조건이 하나도 만족하지 않을 경우
		List<Course> list = courseDao.selectCoursesByCondition(map);
		
		//courseId = 1
		map.put("courseId", 1);
		list = courseDao.selectCoursesByCondition(map);
		
		//courseName = "%java%"
		map.clear();
		map.put("courseName", "%java%");
		list = courseDao.selectCoursesByCondition(map);
		
		//courseName = "%java%" and start_Date >= '2013-04-01'
		GregorianCalendar cal = new GregorianCalendar(2013, 3, 1); 
		map.put("startDate", cal.getTime());
		list = courseDao.selectCoursesByCondition(map);
		Assert.assertNotNull(list);
	}
	
	//selectCoursesByChoose
	@Test
	public void test02selectCoursesByChoose() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String, Object> map = new HashMap<>();
		//조건이 하나도 만족하지 않을 경우 otherwise 오늘날짜이후 시작되는 과정 검색
		List<Course> list = courseDao.selectCoursesByChoose(map);
		
		//courseId = 1
		map.put("searchBy", "Tutor");
		map.put("tutorId", 1);
		list = courseDao.selectCoursesByChoose(map);
		
		//courseName = "%java%"
		map.clear();
		map.put("searchBy", "CourseName");
		map.put("courseName", "%java%");
		list = courseDao.selectCoursesByChoose(map);
		
		Assert.assertNotNull(list);
	}

}









