package hyunmyungsoo.petmeet.dao.map.sitter;

import java.util.List;

import org.springframework.stereotype.Repository;

import hyunmyungsoo.petmeet.domain.Sitter;

@Repository
public interface SitterMap {
	List<Sitter> selectSitters();
	boolean insertSitter(Sitter sitter);
}
