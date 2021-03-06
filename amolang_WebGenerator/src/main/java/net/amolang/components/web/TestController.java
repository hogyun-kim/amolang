package net.amolang.components.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/hello")
	public String hello(Model model) {
		
		
		Map<String, Object> m = model.asMap();
		
		@SuppressWarnings("unchecked")
		List<String> dbinfo = (List<String>) m.get("dbconnectinfo");
		
		model.addAttribute("dbinfo", dbinfo);
		
		return "hello";
	}
	
	@RequestMapping("/test")
	public String test(Model model) {
		
		Map<String, Object> dbinfo = model.asMap();
		
		model.addAttribute("test", dbinfo);
		
		return "test";
	}
}
