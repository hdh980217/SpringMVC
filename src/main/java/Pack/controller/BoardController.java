package Pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Pack.dto.BoardDTO;
import Pack.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardDTO> list = service.boardList();
		model.addAttribute("list", list);
		return "board/boardListView";
	}
	
	@GetMapping("newBoard")
	public String newBoardGet() {
		return "board/newBoardView";
	}
	
	@PostMapping("newBoard")
	public String newBoardPost(BoardDTO dto) {
		service.newBoard(dto);
		return "redirect:boardList";
	}
	
	@GetMapping("boardDetail/{boardNo}")
	public String boardDetail(Model model, @PathVariable int boardNo) {
		model.addAttribute("board", service.boardDetail(boardNo));
		return "board/boardDetailView";
	}
	
	@GetMapping("updateBoard/{boardNo}")
	public String updateBoardGet(Model model, @PathVariable int boardNo) {
		model.addAttribute("board", service.boardDetail(boardNo));
		return "board/boardUpdateView";
	}
	
	@PostMapping("updateBoard")
	public String updateBoardPost(BoardDTO dto) {
		service.boardUpdate(dto);
		return "redirect:boardList";
	}
	
	@GetMapping("deleteBoard/{boardNo}")
	public String deleteBoard(@PathVariable int boardNo) {
		service.boardDelete(boardNo);
		return "board/boardDeleteView";
	}
}
