package hyunmyungsoo.petmeet.web.admin.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hyunmyungsoo.petmeet.domain.Paging;
import hyunmyungsoo.petmeet.service.board.BoardService;
import hyunmyungsoo.petmeet.service.user.UserService;

@Controller
public class AdminBoardController {
	@Autowired private BoardService boardService;
	@Autowired private UserService userService;
	@Value("img")
	private String attachDir;
	
	//listBoard
	@GetMapping("/admin/board/listBoard")
	public String boardList(Paging page Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		
		int total = boardService.countBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		page = new Paging(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", page);
		
		model.addAttribute("userList", userService.getUsers());
		model.addAttribute("boardList", boardService.getBoards(page));
		
		return "admin/board/listBoard";
	}
	
	//view 가져오기
	@GetMapping("/admin/board/view")
	public String boardView(@RequestParam("boardNum") int boardNum , Model model, HttpSession session) throws Exception{
		model.addAttribute("board", boardService.getBoard(boardNum));
		model.addAttribute("idForDel", session.getAttribute("userEmail"));
		model.addAttribute("userList", userService.getUsers());
		
		System.out.println(session.getAttribute("userEmail"));
		
		System.out.println(boardService.getBoard(boardNum));
		 return "admin/board/viewBoard";
	}
	
	//게시글 삭제
	@PostMapping("/admin/board/view/del")
	public String delBoard(HttpSession session,HttpServletRequest request,
			@RequestParam("boardNum") int boardNum) {
		
		System.out.println(boardNum);
		System.out.println("삭제");

		boardService.deleteBoardHelper(boardNum);
		return "redirect:../../board/listBoard";
	}
	
	
	
	
}
