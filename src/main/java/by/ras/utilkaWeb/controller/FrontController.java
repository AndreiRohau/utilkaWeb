package by.ras.utilkaWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		System.out.println("req arrived INDEX");
		return "index";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		System.out.println("test page");
		return "test";
	}

}
