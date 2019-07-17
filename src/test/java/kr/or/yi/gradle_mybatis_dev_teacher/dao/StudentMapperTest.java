package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev_teacher.AbstractTest;
import kr.or.yi.gradle_mybatis_dev_teacher.dto.PhoneNumber;
import kr.or.yi.gradle_mybatis_dev_teacher.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest extends AbstractTest {
	private static StudentMapper stdDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stdDao = new StudentMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		stdDao = null;
	}

	@Test
	public void test01SelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student std = new Student();
		std.setStudId(1);
		
		Student selectStd = stdDao.selectStudentByNo(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	
	@Test
	public void test02selectStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student std = new Student();
		std.setStudId(1);
		
		Student selectStd = stdDao.selectStudentByNoWithResultMap(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}

	@Test
	public void test03SelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
				
		List<Student> list = stdDao.selectStudentByAll();
		log.debug(list.toString());
		Assert.assertNotNull(list);
	}
	
	@Test
    public void test04InsertStudent() {
        Calendar newDate = GregorianCalendar.getInstance();
        newDate.set(1990, 2, 28);
        
        Student student = new Student();
        student.setStudId(3);
        student.setName("홍길동");
        student.setEmail("lee@test.co.kr");
        student.setPhone(new PhoneNumber("010-1234-1234"));
        student.setDob(newDate.getTime());
        int res = stdDao.insertStudent(student);
        Assert.assertEquals(1, res);
        
        test03SelectStudentByAll();
    }

    @Test
    public void test05InsertStudentAutoInc() {
        Calendar newDate = GregorianCalendar.getInstance();
        
        newDate.set(1990, 2, 28);
        Student student = new Student();
        student.setName("홍길동4");
        student.setEmail("lee4@test.co.kr");
        student.setDob(newDate.getTime());
        student.setPhone(new PhoneNumber("010-1234-1234"));      
        int res = stdDao.insertStudentAutoInc(student);
        
        Assert.assertEquals(1, res);
        test03SelectStudentByAll();
    }
    
    @Test
    public void test07UpdateStudent(){
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Student student = new Student();
        student.setStudId(1);
        student.setName("Timothy");
        student.setEmail("test@test.co.kr");
        student.setPhone(new PhoneNumber("987-654-3211"));
        student.setDob(new Date());
        
        int result = stdDao.updateStudent(student);
        Assert.assertSame(1, result);
        test03SelectStudentByAll();
        
        student.setEmail("timothy@gmail.com");
        student.setPhone(new PhoneNumber("123-123-1234"));
        student.setDob(new GregorianCalendar(1988, 04, 25).getTime());
        result = stdDao.updateStudent(student);
        Assert.assertSame(1, result);
        test03SelectStudentByAll();
    }

    @Test
    public void test06DeleteStudent(){
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        int deleteStudent = stdDao.deleteStudent(3);
        Assert.assertSame(1, deleteStudent);
        
        test03SelectStudentByAll();
    }

}
