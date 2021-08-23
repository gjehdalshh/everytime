package spring.everytime.com.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import spring.everytime.com.model.domain.BoardCmtDomain;
import spring.everytime.com.model.domain.BoardDomain;
import spring.everytime.com.model.domain.BoardTypeDomain;
import spring.everytime.com.model.domain.FavoriteDomain;
import spring.everytime.com.model.dto.BoardCmtDTO;
import spring.everytime.com.model.dto.BoardDTO;
import spring.everytime.com.model.dto.BoardTypeDTO;
import spring.everytime.com.model.dto.FavoriteDTO;

@Mapper
public interface BoardMapper {
	BoardTypeDomain selType(BoardTypeDTO dto);
	int insBoard(BoardDTO dto);
	BoardDomain detail(BoardDTO dto);
	List<BoardCmtDomain> detailCmtList(BoardCmtDTO dto);
	int delBoard(BoardDTO dto);
	int updBoard(BoardDTO dto);
	BoardDomain updBoardSel(BoardDTO dto);
	int insFavorite(BoardDTO dto);
	FavoriteDomain selFavorite(FavoriteDTO vo);
	
	/* --------- 댓글 창 ----------- */
	
	// 댓글 추가
	int insCmtProc(BoardCmtDTO dto);
	// 댓글 삭제
	int delCmtBoard(BoardCmtDTO dto);
	
}