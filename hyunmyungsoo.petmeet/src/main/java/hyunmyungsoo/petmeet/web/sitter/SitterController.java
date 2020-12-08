package hyunmyungsoo.petmeet.web.sitter;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hyunmyungsoo.petmeet.service.sitter.SitterService;

@Controller
public class SitterController {
	@Autowired private SitterService sitterService;
	@Value("img")
	private String attachDir;
	
	@GetMapping("/sitter/insertSitter")
	public String insertSitterPage() {
		return "sitter/insertSitter";
	}
	
	@PostMapping("/sitter/insertSitter")
	public String insertSitterPage(@RequestParam("sitterTitle") String sitterTitle,
			@RequestParam("sitterContent") String sitterContent, @RequestParam("sitterPetType") String sitterPetType,
			@RequestParam("sitterPetSize") String sitterPetSize, @RequestParam("sitterLocSi") String sitterLocSi, @RequestParam("sitterLocGu") String sitterLocGu,
			@RequestParam("sitterLocDong") String sitterLocDong, @RequestParam("daterange") String daterange, 
			HttpSession session, HttpServletRequest request,
			@RequestParam MultipartFile attachFile,
			@RequestParam("userId") String userId) throws ParseException {
		
		String dir = request.getServletContext().getRealPath(attachDir);
		
		String fileName = "sitter" + userId + ".PNG";
		
		save(dir + "/" + fileName, attachFile);
		
		sitterService.assignSitter(session, sitterTitle, sitterContent, sitterPetType, sitterPetSize, sitterLocSi, sitterLocGu, sitterLocDong, daterange, fileName);
		return "redirect:../common/mypage";
	}
	
	private void save(String fileName, MultipartFile attachFile) {
		try {
			attachFile.transferTo(new File(fileName));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
