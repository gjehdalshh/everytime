package spring.everytime.com.main;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.everytime.com.common.Utils;
import spring.everytime.com.model.domain.BoardDomain;
import spring.everytime.com.model.domain.BoardTypeDomain;
import spring.everytime.com.model.domain.BoardTypeSubDomain;
import spring.everytime.com.model.domain.UserDomain;
import spring.everytime.com.model.dto.BoardDTO;
import spring.everytime.com.model.dto.BoardTypeDTO;
import spring.everytime.com.model.dto.BoardTypeSubDTO;

@Service
public class MainService {

	@Autowired
	private MainMapper mapper;
	
	@Autowired
	private HttpSession hs;

	List<UserDomain> selList() {
		return mapper.selList();
	}

	List<BoardTypeDomain> typeList() {
		return mapper.typeList();
	}

	List<BoardDomain> boardList(BoardDomain dto) {
		
		List<BoardDomain> vo = mapper.boardList(dto);
		for(int i = 0; i < vo.size(); i++) {
			vo.get(i).setR_dt(Utils.timeFormat(vo.get(i).getR_dt()));
		}
		
		return vo;
	}

	BoardTypeDomain boardType(BoardTypeDTO dto) {
		return mapper.boardType(dto);
	}

	List<BoardTypeDomain> boardTypeList(BoardTypeDTO dto) {
		return mapper.boardTypeList(dto);
	}

	int boardTypeHit(BoardTypeDTO dto) {
		return mapper.boardTypeHit(dto);
	}

	List<BoardTypeSubDomain> boardTypeSubList(BoardTypeSubDTO dto) {
		return mapper.boardTypeSubList(dto);
	}

	List<BoardDomain> hotList(BoardDTO dto) {
		return mapper.hotList(dto);
	}

	List<BoardDomain> boardSubList(BoardDTO dto) {
		return mapper.boardSubList(dto);
	}
	
	List<BoardDomain> boardTypeCmtList(BoardDTO dto) {
		return mapper.boardTypeCmtList(dto);
	}
	
	List<BoardDomain> selectProc(BoardDTO dto) {
		
		return mapper.selectProc(dto);
	}
	
	// 페이징 처리
	BoardDomain listCount(BoardDTO dto) {
		
		return mapper.listCount(dto);
	}

}

