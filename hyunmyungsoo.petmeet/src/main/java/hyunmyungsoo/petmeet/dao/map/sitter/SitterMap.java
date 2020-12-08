package hyunmyungsoo.petmeet.dao.map.sitter;

import org.springframework.stereotype.Repository;

import hyunmyungsoo.petmeet.domain.Sitter;

@Repository
public interface SitterMap {
	boolean insertSitter(Sitter sitter);
}
