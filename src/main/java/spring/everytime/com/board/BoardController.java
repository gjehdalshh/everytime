package spring.everytime.com.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.everytime.com.model.dto.BoardCmtDTO;
import spring.everytime.com.model.dto.BoardDTO;
import spring.everytime.com.model.dto.BoardTypeDTO;
import spring.everytime.com.model.dto.FavoriteDTO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// 글 페이지
	@GetMapping("/board/detail")
	public void Detail(Model model, BoardDTO dto, BoardCmtDTO Cmtdto) {
		//detail 페이지
		model.addAttribute("detail", service.detail(dto));
		
		//detail 페이지 댓글
		model.addAttribute("detailCmtList", service.detailCmtList(Cmtdto));
	}
	
	// 글 쓰기
	@GetMapping("/board/insBoard")
	public void InsBoard(Model model, BoardTypeDTO dto) {
		
		model.addAttribute("selType", service.selType(dto));
	}
	
	// 글 쓰기 ajax 처리
	@ResponseBody
	@PostMapping("/insBoardProc")
	public Map<String, Object> insBoard(@RequestBody BoardDTO dto) {
		
		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", service.insBoard(dto));
		
		return val;
	}
	
	// 글 삭제 ajax 처리
	@ResponseBody
	@PostMapping("/board/delBoard")
	public Map<String, Object> delBoard(@RequestBody BoardDTO dto) {
		
		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", service.delBoard(dto));
		
		return val;
	}
	
	//글 수정
	@GetMapping("/board/updBoard")
	public void updBoard(Model model, BoardDTO dto) {
		model.addAttribute("updBoard", service.updBoardSel(dto));	
	}
	
	//글 수정 ajax 처리
	@ResponseBody
	@PostMapping("/updBoardProc")
	public Map<String, Object> updBoardProc(@RequestBody BoardDTO dto) {
		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", service.updBoard(dto));
		
		return val;
	}
	
	
	/* ------------ 댓글 창 ------------------- */
	
	// 댓글 작성
	@ResponseBody
	@PostMapping("/insCmtProc")
	public Map<String, Object> insCmtProc(@RequestBody BoardCmtDTO dto) {
		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", service.insCmtProc(dto));
		
		return val;
	}
	
	// 댓글 삭제
	@ResponseBody
	@PostMapping("/delCmtBoard")
	public Map<String, Object> delCmtBoard(@RequestBody BoardCmtDTO dto) {
		Map<String, Object> val = new HashMap<String, Object>();
		val.put("result", service.delCmtBoard(dto));
		
		return val;
	}
	
	// 좋아요
		@ResponseBody
		@PostMapping("/main/insFavorite")
		public Map<String, Object>insFavorite(@RequestBody BoardDTO dto) {
			
			Map<String, Object> val = new HashMap<String, Object>();
			
			val.put("result", service.insFavorite(dto));
			return val;
		}
}


