package hyunmyungsoo.petmeet.service.sitter;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import hyunmyungsoo.petmeet.domain.Sitter;

public interface SitterService {
	boolean addSitter(Sitter sitter);
	void assignSitter(HttpSession session, String sitterTitle, 
			String sitterContent, String sitterPetType, 
			String sitterPetSize, String sitterLocSi, 
			String sitterLocGu, String sitterLocDong, String daterange,
			String fileName) throws ParseException;
}
