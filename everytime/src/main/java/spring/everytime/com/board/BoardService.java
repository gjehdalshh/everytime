package spring.everytime.com.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.everytime.com.common.Utils;
import spring.everytime.com.model.domain.BoardCmtDomain;
import spring.everytime.com.model.domain.BoardDomain;
import spring.everytime.com.model.domain.BoardTypeDomain;
import spring.everytime.com.model.domain.FavoriteDomain;
import spring.everytime.com.model.dto.BoardCmtDTO;
import spring.everytime.com.model.dto.BoardDTO;
import spring.everytime.com.model.dto.BoardTypeDTO;
import spring.everytime.com.model.dto.FavoriteDTO;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;

	public BoardTypeDomain selType(BoardTypeDTO dto) {
		return mapper.selType(dto);
	}

	public int insBoard(BoardDTO dto) {

		int result = mapper.insBoard(dto);
		if (result != 1) {
			return 2;
		}
		return 1;
	}

	public BoardDomain detail(BoardDTO dto) {

		BoardDomain vo = mapper.detail(dto);
		
		vo.setR_dt(Utils.timeFormat(vo.getR_dt()));

		return vo;
	}
	
	public List<BoardCmtDomain> detailCmtList(BoardCmtDTO dto) {
		
		return mapper.detailCmtList(dto);
	}

	public int delBoard(BoardDTO dto) {

		int result = mapper.delBoard(dto);
		if (result != 1) {
			return 2;
		}

		return 1;
	}

	public BoardDomain updBoardSel(BoardDTO dto) {
		return mapper.updBoardSel(dto);
	}

	public int updBoard(BoardDTO dto) {
		
		int result = mapper.updBoard(dto);

		if (result != 1) {
			return 2;
		}
		return 1;
	}
	
	
	/* ----------- 좋아요 ------------------- */
	int insFavorite(BoardDTO dto) {
		FavoriteDTO vo = new FavoriteDTO();
		vo.setI_user(dto.getI_user());
		vo.setI_board(dto.getI_board());
		System.out.println(vo.getI_board());
		System.out.println(vo.getI_user());
		FavoriteDomain vo2 = mapper.selFavorite(vo);
		
		if(vo2 == null) {
			return mapper.insFavorite(dto);
		}
		
		System.out.println(vo2.getI_board());
		System.out.println(vo2.getI_user());
		
		
		System.out.println(dto.getI_board());
		System.out.println(dto.getI_user());
		
		return 2;
	}
	
	
	/* --------------- 댓글 창 ------------------- */
	
	// 댓글 작성
	public int insCmtProc(BoardCmtDTO dto) {
		
		// 로그인을 하지 않은 경우
		if(dto.getI_user() == 0) {
			return 2;
		}
		
		return mapper.insCmtProc(dto);
	}
	
	
	
	
	
	
	
	
	
	
	
}
