package hyunmyungsoo.petmeet.service.comment;

import java.util.List;

import org.springframework.stereotype.Service;

import hyunmyungsoo.petmeet.domain.Comment;

public interface CommentService {
	List<Comment> getComments(int boardNum);
	
	boolean addComment(Comment comment);
	/*
	void addBoardHelper(String boardTitle, String boardContent,
			String fileName, String userId);
	
	void updateBoardHelper(int boardNum, String boardTitle, String boardContent,
			String fileName, String userId);
	
	void deleteBoardHelper(int boardNum);
	*/
	Comment getComment(int commentNum);
	
	boolean fixComment(Comment comment);
	boolean delComment(int commentNum);
	

}
