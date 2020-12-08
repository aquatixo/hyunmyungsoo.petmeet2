package hyunmyungsoo.petmeet.service.sitter;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import hyunmyungsoo.petmeet.domain.Sitter;

public interface SitterService {
<<<<<<< HEAD
	List<Sitter> getSitters();
	Sitter getSitter(String userId);
=======
>>>>>>> branch 'master' of https://github.com/aquatixo/hyunmyungsoo.petmeet2.git
	boolean addSitter(Sitter sitter);
<<<<<<< HEAD
	void assignSitter(HttpSession session, String sitterTitle, String sitterContent, String sitterPetType,
			String sitterPetSize, String sitterLocSi, String sitterLocGu, String sitterLocDong, String daterange,
			String fileName) throws ParseException;
	boolean fixSitter(HttpSession session, String sitterTitle, String sitterContent, 
			String sitterPetType, String sitterPetSize, String sitterLocSi, String sitterLocGu, 
			String sitterLocDong, String daterange) throws ParseException;
=======
	void assignSitter(HttpSession session, String sitterTitle, 
			String sitterContent, String sitterPetType, 
			String sitterPetSize, String sitterLocSi, 
			String sitterLocGu, String sitterLocDong, String daterange,
			String fileName) throws ParseException;
>>>>>>> branch 'master' of https://github.com/aquatixo/hyunmyungsoo.petmeet2.git
}
