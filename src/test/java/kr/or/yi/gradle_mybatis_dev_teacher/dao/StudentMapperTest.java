package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev_teacher.AbstractTest;
import kr.or.yi.gradle_mybatis_dev_teacher.dto.Gender;
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

    @Test
	public void test07selectStudentMapByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
				
		List<Map<String,Object>> list = stdDao.selectStudentMapByAll();
		Assert.assertNotNull(list);
		
		for(Map<String,Object> e : list) {
			for(Entry<String, Object> ee: e.entrySet()) {
				log.debug(String.format("key(%s) -> value(%s)", ee.getKey(), ee.getValue()));
			}
		}
	}
    
    @Test
    public void test08selectStudentByNoResultMapExtends(){
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Student std = new Student();
        std.setStudId(1);
        
        Student searchStudent = stdDao.selectStudentByNoResultMapExtends(std);
        Assert.assertNotNull(searchStudent);
        
        log.debug(searchStudent.toString());
    }
    
    @Test
    public void test09InsertStudentEnum() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

        Calendar newDate = GregorianCalendar.getInstance();
        newDate.set(1990, 2, 28);
        
        Student student = new Student();
        student.setStudId(3);
        student.setName("홍길동남");
        student.setEmail("lee@test.co.kr");
        student.setPhone(new PhoneNumber("010-1234-1234"));
        student.setDob(newDate.getTime());
        student.setGender(Gender.FEMALE);
        
        int res = stdDao.insertStudentEnum(student);
        Assert.assertEquals(1, res);
        
        Student selStd = stdDao.selectStudentByNo(student);
        log.debug(selStd.toString());
        
        student.setStudId(10);
        student.setName("홍길동여");
        student.setGender(Gender.MALE);
        stdDao.insertStudentEnum(student);
        
        selStd = stdDao.selectStudentByNo(student);
        log.debug(selStd.toString());
        
        stdDao.deleteStudent(3);
        stdDao.deleteStudent(10);
    }
    
    @Test
    public void test10selectStudentByMap() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        
        Map<String,String> map = new HashMap<String, String>();
        map.put("name", "Timothy");
        map.put("email", "timothy@gmail.com");
        
        Student std = stdDao.selectStudentByMap(map);
        log.debug(std.toString());
        
        map.remove("email");
        std = stdDao.selectStudentByMap(map);
        log.debug(std.toString());
        
        map.clear();
        map.put("email", "timothy@gmail.com");
        std = stdDao.selectStudentByMap(map);
        log.debug(std.toString());
        
        Assert.assertNotNull(std);
    }
    
    
    @Test
    public void test12selectStudentForMap() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        
        Map<Integer, String> result = stdDao.selectStudentForMap();
        Assert.assertNotNull(result);
        
        for(Entry<Integer, String> e : result.entrySet()) {
        	log.debug(String.format("%d -> %s", e.getKey(), e.getValue()));
        }
    }
        
    @Test
    public void test13UpdateStudentForSet(){
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        
        Student student = new Student();
        student.setStudId(1);
        student.setName("Timothy");
        int result = stdDao.updateStudentForSet(student);
        Assert.assertSame(1, result);
        
        
        student.setEmail("test@test.co.kr");
        student.setPhone(new PhoneNumber("987-654-3211"));
        result = stdDao.updateStudentForSet(student);
        Assert.assertSame(1, result);
        
        student.setDob(new Date());
        result = stdDao.updateStudentForSet(student);
        Assert.assertSame(1, result);
        
     
        student.setEmail("timothy@gmail.com");
        student.setPhone(new PhoneNumber("123-123-1234"));
        student.setDob(new GregorianCalendar(1988, 04, 25).getTime());
        result = stdDao.updateStudentForSet(student);
        Assert.assertSame(1, result);
        
    }
}








