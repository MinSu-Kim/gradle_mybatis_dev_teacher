package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev_teacher.AbstractTest;
import kr.or.yi.gradle_mybatis_dev_teacher.dto.UserPic;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicMapperTest extends AbstractTest {
	private static UserPicMapper picDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		picDao = new UserPicMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		picDao = null;
	}

	@Test
	public void testInsertUserPic() throws IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPic userPic = new UserPic();
		userPic.setId(1);
		userPic.setName("이유영");
		String bio = "대한민국의 배우. 1989년 서울특별시에서 태어났다.\r\n" + 
				"\r\n" + 
				"고등학교를 졸업한 이후 바로 대학교에 진학하지 않고 미용실에서 미용사 보조 일을 하다가, 22살이 되던 해인 2010년에 한국예술종합학교 연극원 연기과에 진학하였다. 때문에 같은 10학번인 배우 김고은, 박소담 등과는 동기이다.[2]\r\n" + 
				"\r\n" + 
				"재학 중이던 2014년 5월에 조근현 감독의 저예산 예술 영화인 《봄》에 출연하였다. 그녀는 1960년대를 시대적 배경으로 한 이 영화에서 정숙(김서형 분)에게 돈을 받고 정숙의 남편이자 불치병에 걸려 실의에 빠진 조각가 준구(박용우 분)의 누드모델이 되는 가난한 시골 여자 '민경'을 연기했다. 이 작품으로 밀라노 국제 영화제에서 여우주연상을 받으며 주목을 받았다. 밀라노 국제 영화제 뿐만이 아니라 이 영화로 국내에서도 2015년 올해의 영화상, 부일영화상, 대종상 영화제에서 신인여우상을 수상하는 쾌거를 이루었다.\r\n" + 
				"\r\n" + 
				"2015년에는 《간신》에서 요염한 기생 '설중매'를 연기하면서 강렬한 연기를 펼쳤고, 제36회 청룡영화상에서 신인여우상을 수상하였다.\r\n" + 
				"\r\n" + 
				"《봄》과 《간신》 두 작품 모두 음모 노출이 포함된 전라로 나오는 장면이 꽤 길어 파격적이었는데 두 작품에서의 이미지는 서로 확연히 다르다. 《봄》에서는 순수하고 수줍은 시골 아낙네의 느낌을 잘 살려 화가 앞에서 누드모델로 벗는다면, 《간신》에서는 임지연과의 동성 애정씬 등 여러 벗는 장면에서 설중매라는 캐릭터의 팜므파탈한 색기담당으로서의 매력을 확실히 뽐낸다. 영화 평론가들 사이에서도 그냥 벗기 위해 벗는 것이 아닌, 작품의 주제와 배우의 역할을 제대로 살리기 위해 과감히 벗었다는 호평이 많았다. 슬림한 몸매도 매력적이었다.\r\n" + 
				"\r\n" + 
				"2016년 12월 13일에 배우 김주혁과의 열애설이 나왔고, 이를 인정했다. 홍상수 감독의 당신자신과 당신의 것을 함께 촬영하며 관계가 발전했다고 한다.(관련 기사)\r\n" + 
				"\r\n" + 
				"2017년에는 OCN 드라마 터널에 신재이 역으로 첫 드라마 출연을 했다. 첫 드라마였지만 비중이 꽤 있는 역할이다. 드라마의 내용도 좋았고 시청률도 역대 OCN 드라마 최고 시청률을 경신하면서 성공적으로 마무리했다.\r\n" + 
				"\r\n" + 
				"2017년 10월 30일, 자신의 연인인 김주혁이 강남구 삼성동 아이파크 앞에서 불의의 교통사고로 유명을 달리했다. 당시 부산에서 SBS 런닝맨을 촬영 중이었는데, 녹화 현장에서 비보를 듣고 촬영이 중단되었다고 한다.(관련 기사) 촬영 중단 후 서울로 급히 올라온 후 김주혁의 사망 소식을 믿지 못 하고 재차 확인하면서 슬픔과 충격에서 헤어 나오지 못 하며 차태현 등과 함께 김주혁의 빈소를 지킨 것으로 전해졌다.고 김주혁의 발인식\r\n" + 
				"\r\n" + 
				"2018년부터 열일 행보를 시작했다. 물론 영화는 촬영을 해야 하기 때문에 개봉시기와 좀 차이가 있긴 하지만 그동안 해왔던 패턴에 비해 올 한해는 배우 본인에게 있어 어마어마한 일을 한 것은 분명하다.\r\n" + 
				"\r\n" + 
				"먼저 4월 영화 나를 기억해가 개봉했으며 5월 MBC 4부작 단편드라마 미치겠다, 너땜에!에 주연 한은성 역으로 출연했다. 또한 영화 허스토리에도 우정출연했으며 이전에 연이 있는 홍상수 감독의 영화 풀잎들에도 조연으로 출연했다. 이후 하반기 SBS 수목드라마 친애하는 판사님께에서 송소은 역으로 분해 윤시윤과 좋은 연기력을 선보였다. 터널을 제외하고 쭉 영화판에만 있었음에도 드라마에서도 좋은 연기력을 선보이고 있다는 점은 여러모로 칭찬할 만한 점인 듯. 그리고 마동석, 김영광 주연인 추석 영화 원더풀 고스트에도 주연으로 등장한다. 또한 친판사 촬영과 동시에 2019년 개봉을 앞둔 영화 디바를 배우 신민아와 함께 촬영 중인 것으로 보이는데 촬영 도중 갈비뼈 부상을 당했다. 심한 것은 아니라지만 워낙 많은 작품에 촬영하다보니 팬들의 걱정이 크다.## 이후에 영화 촬영은 잘 끝낸 듯 하다. 해가 넘어가 2019년에도 열일 행보는 여전한데, 영화 악질경찰에서 특별출연을 시작으로, KBS 수목 드라마 국민 여러분!에도 주연 배역 김미영으로 출연했다.";
		userPic.setBio(bio);
		userPic.setPic(getPicFile());
		int result = picDao.insertUserPic(userPic);
		Assert.assertEquals(1, result);
		
	}

	private byte[] getPicFile() throws IOException {
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir") + "\\images\\이유영.jpg");
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
			pic = new byte[bis.available()];
			bis.read(pic);
			return pic;
		}
	}

	@Test
	public void testSelectUserPic() throws FileNotFoundException, IOException{
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPic userPic = new UserPic();
		userPic.setId(1);
		
		UserPic searchPic = picDao.selectUserPic(userPic);
		Assert.assertNotNull(searchPic);
		
		if (searchPic.getPic() != null) {
			File file = getPicFile(searchPic);
			log.debug("file Path = " + file.getAbsolutePath());
		}
	}

	private File getPicFile(UserPic userPic) throws FileNotFoundException, IOException {
		File pics = new File(System.getProperty("user.dir") + "\\pics\\");
		if (!pics.exists()) {
			pics.mkdir();
		}
		
		File pic = new File(pics, userPic.getName() + ".jpg");
		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(pic))){
			bos.write(userPic.getPic());
		}
		
		return pic;
	}

	
	@Test
	public void test03deleteUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPic userPic = new UserPic();
		userPic.setId(1);
		
		int res = picDao.deleteUserPic(userPic);
		Assert.assertEquals(1, res);
		
		deletePicsFolders();
	}

	private void deletePicsFolders() {
		File pics = new File(System.getProperty("user.dir") + "\\pics");
		
		if (pics.exists()) {
			for(File file : pics.listFiles()) {
				file.delete();
			}
		}
		
		pics.delete();
	}
}