package hyunmyungsoo.petmeet.service.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hyunmyungsoo.petmeet.dao.comment.CommentDao;
import hyunmyungsoo.petmeet.domain.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired private CommentDao commDao;
	

	@Override
	public List<Comment> getComments(int boardNum) {
		return commDao.selectComments(boardNum);
	}

	@Override
	public boolean addComment(Comment comment) {
		return commDao.insertComment(comment) > 0;
	}

	@Override
	public Comment getComment(int commentNum) {
		return commDao.selectComment(commentNum);
	}

	@Override
	public boolean fixComment(Comment comment) {
		return commDao.updateComment(comment) > 0;
	}

	@Override
	public boolean delComment(int commentNum) {
		return commDao.deleteComment(commentNum) > 0;
	}
	
	/*
	@Override
	public void addBoardHelper(String boardTitle, String boardContent, String fileName, String userId) {
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setUserId(userId);
		board.setBoardFile(fileName);
		addBoard(board);
	}

	
	@Override
	public void updateBoardHelper(int boardNum, String boardTitle, String boardContent,  String fileName, String userId) {
		Board board = new Board();
		board.setBoardNum(boardNum);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setUserId(userId);
		board.setBoardFile(fileName);
		
		fixBoard(board);
		
	}
	
	@Override
	public void deleteBoardHelper(int boardNum) {
		delBoard(boardNum);
	}*/


}
