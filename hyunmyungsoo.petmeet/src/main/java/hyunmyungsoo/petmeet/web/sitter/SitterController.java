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
import hyunmyungsoo.petmeet.service.user.UserService;

@Controller
public class SitterController {
	@Autowired private SitterService sitterService;
<<<<<<< HEAD
	@Autowired private UserService userService;
	@Value("img")
	private String attachDir;
	
	@GetMapping("/sitter/sitterMain")
	public String listSitterPage(Model model) {
		model.addAttribute("sitterList", sitterService.getSitters());
		model.addAttribute("userList", userService.getUsers());
		return "sitter/sitterMain";
	}
=======
	@Value("img")
	private String attachDir;
>>>>>>> branch 'master' of https://github.com/aquatixo/hyunmyungsoo.petmeet2.git
	
	@GetMapping("/sitter/insertSitter")
	public String insertSitterPage() {
		return "sitter/insertSitter";
	}
	
	@PostMapping("/sitter/insertSitter")
	public String insertSitterPage(@RequestParam("sitterTitle") String sitterTitle,
			@RequestParam("sitterContent") String sitterContent, @RequestParam("sitterPetType") String sitterPetType,
<<<<<<< HEAD
					
=======
>>>>>>> branch 'master' of https://github.com/aquatixo/hyunmyungsoo.petmeet2.git
			@RequestParam("sitterPetSize") String sitterPetSize, @RequestParam("sitterLocSi") String sitterLocSi, @RequestParam("sitterLocGu") String sitterLocGu,
			@RequestParam("sitterLocDong") String sitterLocDong, @RequestParam("daterange") String daterange, 
			HttpSession session, HttpServletRequest request,
			@RequestParam MultipartFile attachFile,
			@RequestParam("userId") String userId) throws ParseException {
		
		String dir = request.getServletContext().getRealPath(attachDir);
		
		String fileName = "sitter" + userId + ".PNG";
		
		save(dir + "/" + fileName, attachFile);
		
		sitterService.assignSitter(session, sitterTitle, sitterContent, sitterPetType, sitterPetSize, sitterLocSi, sitterLocGu, sitterLocDong, daterange, fileName);
<<<<<<< HEAD
		return "redirect:../common/mypage";
	}
	
	private void save(String fileName, MultipartFile attachFile) {
		try {
			attachFile.transferTo(new File(fileName));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/sitter/upDelSitter")
	public String updDelSitterPage(Model model, HttpSession session) {
		String userId = session.getAttribute("userEmail").toString();
		model.addAttribute("sitter", sitterService.getSitter(userId));
		return "sitter/upDelSitter";
	}
	
	@PostMapping("/sitter/upDelSitter")
	public String fixUser(String sitterFileName, @RequestParam("sitterTitle") String sitterTitle,
			@RequestParam("sitterContent") String sitterContent, @RequestParam("sitterPetType") String sitterPetType, @RequestParam("sitterPetSize") String sitterPetSize,
			@RequestParam("sitterLocSi") String sitterLocSi, @RequestParam("sitterLocGu") String sitterLocGu, @RequestParam("sitterLocDong") String sitterLocDong, @RequestParam("daterange") String daterange, HttpSession session) throws ParseException {
		
		sitterService.fixSitter(session, sitterTitle, sitterContent, sitterPetType, sitterPetSize, sitterLocSi, sitterLocGu, sitterLocDong, daterange);
=======
>>>>>>> branch 'master' of https://github.com/aquatixo/hyunmyungsoo.petmeet2.git
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

