package hyunmyungsoo.petmeet.dao.sitter;

import java.util.List;

import hyunmyungsoo.petmeet.domain.Sitter;

public interface SitterDao {
	List<Sitter> selectSitters();
	boolean insertSitter(Sitter sitter);
}
