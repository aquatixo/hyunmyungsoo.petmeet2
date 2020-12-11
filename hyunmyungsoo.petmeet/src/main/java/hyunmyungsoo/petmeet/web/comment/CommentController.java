package hyunmyungsoo.petmeet.web.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hyunmyungsoo.petmeet.service.board.BoardService;
import hyunmyungsoo.petmeet.service.comment.CommentService;

@Controller
public class CommentController {
	@Autowired private BoardService boardService;
	@Autowired private CommentService commentService;
	
	//댓글 추가
	@PostMapping("/board/view/addComment")
	public String addComment(HttpSession session,HttpServletRequest request,
			@RequestParam("commentContent") String commentContent,
			@RequestParam("userId") String userId,
			@RequestParam("boardNum") int boardNum) {

		commentService.addCommentHelper(commentContent, userId, boardNum);
		return "redirect:../../board/view?boardNum="+boardNum; 
	}
	
	
	//댓글 삭제 
	@GetMapping("/board/viewBoard/del")
	public String test(@RequestParam("commentNum") int commentNum,
					   @RequestParam("boardNum") int boardNum,Model model) {
		
		System.out.println(commentNum);
		System.out.println(boardNum);
		
		commentService.deleteCommentHelper(commentNum);
		return "redirect:../../board/view?boardNum="+boardNum; 
	}

}
