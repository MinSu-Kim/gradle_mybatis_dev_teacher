package kr.or.yi.gradle_mybatis_dev_teacher.dao;

import kr.or.yi.gradle_mybatis_dev_teacher.dto.UserPic;

public interface UserPicMapper {
	int insertUserPic(UserPic userPic);
	UserPic selectUserPic(UserPic userPic);
	
	int deleteUserPic(UserPic userPic);
}
