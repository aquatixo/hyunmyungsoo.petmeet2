package hyunmyungsoo.petmeet.dao.sitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hyunmyungsoo.petmeet.dao.map.sitter.SitterMap;
import hyunmyungsoo.petmeet.domain.Sitter;

@Repository
public class SitterDaoImpl implements SitterDao {
	@Autowired private SitterMap sitterMap;
	@Override
	public Sitter selectSitter(String userId) {
		return sitterMap.selectSitter(userId);
	}
	
	@Override
	public boolean insertSitter(Sitter sitter) {
		return sitterMap.insertSitter(sitter);
	}
	
	@Override
	public boolean updateSitter(Sitter sitter) {
		return sitterMap.updateSitter(sitter);
	}
}