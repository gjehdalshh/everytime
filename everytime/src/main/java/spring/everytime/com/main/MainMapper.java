package spring.everytime.com.main;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import spring.everytime.com.model.domain.BoardDomain;
import spring.everytime.com.model.domain.BoardTypeDomain;
import spring.everytime.com.model.domain.BoardTypeSubDomain;
import spring.everytime.com.model.domain.UserDomain;
import spring.everytime.com.model.dto.BoardDTO;
import spring.everytime.com.model.dto.BoardTypeDTO;
import spring.everytime.com.model.dto.BoardTypeSubDTO;

@Mapper
public interface MainMapper {
	List<UserDomain> selList();
	List<BoardTypeDomain> typeList();
	List<BoardDomain> boardList(BoardDTO dto);
	BoardTypeDomain boardType(BoardTypeDTO dto);
	List<BoardTypeDomain> boardTypeList(BoardTypeDTO dto);
	int boardTypeHit(BoardTypeDTO dto);
	List<BoardTypeSubDomain> boardTypeSubList(BoardTypeSubDTO dto);
	List<BoardDomain> hotList(BoardDTO dto);
	List<BoardDomain> boardSubList(BoardDTO dto);
	List<BoardDomain> boardTypeCmtList(BoardDTO dto);
}
