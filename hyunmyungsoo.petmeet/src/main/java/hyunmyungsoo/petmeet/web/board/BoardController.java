package hyunmyungsoo.petmeet.web.board;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import hyunmyungsoo.petmeet.domain.Board;
import hyunmyungsoo.petmeet.service.board.BoardService;


@Controller
public class BoardController {
	@Autowired private BoardService boardService;
	
	@GetMapping("/board/listBoard")
	public String listBoard(Model model) {
		model.addAttribute("boardList", boardService.getBoards());
		System.out.println(boardService.getBoards());
		return "board/listBoard";
	}
	

	@GetMapping("/board/addBoard")
	public String addBoard() {
		return "board/addBoard";
	}
	
	@PostMapping("/board/addB") //post는 이 request는 데이터를 추가한다는 의미가 있다.
	public boolean addBoardB(@RequestBody Board board, HttpSession session) { //파라미터 value들이 멤버 변수 value로 DI가 된다. //RequestBody는 json
		String userId = session.getAttribute("userEmail").toString();
		board.setUserId(userId);
		return boardService.addBoard(board);
	}
	
	//view 가져오기
	@GetMapping("/board/viewBoard")
	public String boardView(@RequestParam("boardNum") int boardNum , Model model) throws Exception{
		model.addAttribute("board", boardService.getBoard(boardNum));
		 return "board/viewBoard";
		 
	}
	
}
	