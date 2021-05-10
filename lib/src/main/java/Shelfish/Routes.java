package Shelfish;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Routes {
	@GetMapping("/")
	public String Index() {
		return "index";
	}
	@GetMapping("/about")
	public String About() {
		return "about";
	}
	@GetMapping("/howtouse")
	public String HowToUse() {
		return "howtouse";
	}
	
	
	
}
