package spring.everytime.com.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.everytime.com.model.dto.BoardDTO;
import spring.everytime.com.model.dto.BoardTypeDTO;
import spring.everytime.com.model.dto.BoardTypeSubDTO;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	// 메인 페이지
	@GetMapping("main/home")
	public void selList(Model model, BoardDTO dto) {
				
		//유저 정보
		//model.addAttribute("user_list", service.selList());
		// 핫 게시판
		model.addAttribute("hotList", service.hotList(dto));
		
		//게시판 종류
		model.addAttribute("type_list", service.typeList());
	}
	
	// 게시판 목록
	@GetMapping("/main/boardType")
	public void boardType(Model model, BoardTypeDTO dto, BoardTypeSubDTO dto2) {
		//일반적인 게시판
		model.addAttribute("board_type", service.boardTypeList(dto));
		//sub 게시판
		model.addAttribute("board_type_sub", service.boardTypeSubList(dto2));
	}
	
	// 게시판 하나
	@GetMapping("/main/board")
	public void board(Model model, BoardDTO dto, BoardTypeDTO typeDto) {
		service.boardTypeHit(typeDto);

		//주 내용
		model.addAttribute("board_list", service.boardList(dto));
		
		//게시판 제목
		model.addAttribute("board_type", service.boardType(typeDto));
	}
	
	// 서브 게시판 하나
	@GetMapping("/main/subBoard")
	public void subBoard(Model model, BoardDTO dto) {
		
		// t_board_type_sub
		model.addAttribute("subBoard_list", service.boardSubList(dto));
		
	}

	
}

