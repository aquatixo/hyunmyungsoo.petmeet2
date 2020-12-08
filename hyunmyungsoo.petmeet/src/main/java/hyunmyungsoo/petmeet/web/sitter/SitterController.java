package hyunmyungsoo.petmeet.web.sitter;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hyunmyungsoo.petmeet.service.sitter.SitterService;

@Controller("yjcon")
public class SitterController {
	@Autowired private SitterService sitterService;
	
	@GetMapping("/sitter/sitterMain")
	public String listSitterPage(Model model) {
		model.addAttribute("sitterList", sitterService.getSitters());
		return "sitter/sitterMain";
	}
	
	
	@GetMapping("/sitter/insertSitter")
	public String insertSitterPage() {
		return "sitter/insertSitter";
	}
	
	@PostMapping("/sitter/insertSitter")
	public String insertSitterPage(@RequestParam("sitterTitle") String sitterTitle,
			@RequestParam("sitterContent") String sitterContent, @RequestParam("sitterPetType") String sitterPetType,
					// null�� �����ؾ���									// ���� ĭ�� ��ĭ�̶� �ϴ� �ø� �Է� �ϰ� ����
			@RequestParam("sitterPetSize") String sitterPetSize, @RequestParam("sitterLocSi") String sitterLocSi, @RequestParam("sitterLocGu") String sitterLocGu,
			@RequestParam("sitterLocDong") String sitterLocDong, @RequestParam("daterange") String daterange, HttpSession session) throws ParseException {
		
		sitterService.assignSitter(session, sitterTitle, sitterContent, sitterPetType, sitterPetSize, sitterLocSi, sitterLocGu, sitterLocDong, daterange);
		return "redirect:../common/mypage";
	}
}
