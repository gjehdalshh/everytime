package spring.everytime.com.user;

import org.apache.ibatis.annotations.Mapper;

import spring.everytime.com.model.domain.UserDomain;
import spring.everytime.com.model.dto.UserDTO;

@Mapper
public interface UserMapper {
	int insUser(UserDTO dto);
	UserDomain selUser(UserDTO dto);
	int idChange(UserDTO dto);
	UserDomain selUserId(UserDTO dto);
	int pwChange(UserDTO dto);
	UserDomain selUserNm(UserDTO dto);
	int nmChange(UserDTO dto);
	UserDomain userInfoProc(UserDTO dto);
	UserDomain findUser(UserDTO dto);
	UserDomain naverUserLogin(UserDTO dto);
	int naverUserInsert(UserDTO dto);
}
