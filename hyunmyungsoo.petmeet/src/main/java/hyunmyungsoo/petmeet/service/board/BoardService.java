package hyunmyungsoo.petmeet.service.board;

import java.util.List;

import hyunmyungsoo.petmeet.domain.Board;

public interface BoardService {
	List<Board> getBoards();
	
	boolean addBoard(Board board);
	
	void addBoardHelper(String boardTitle, String boardContent,
			String fileName, String userId);
	
	void updateBoardHelper(String boardTitle, String boardContent,
			String fileName, String userId);
	
	Board getBoard(int boardNum);
	
	boolean fixBoard(Board board);
	boolean delBoard(int boardNum);
	
	//void assignSitter(HttpSession session, String boardTitle, String boardContent, Date regDate, String boardFile);
}

