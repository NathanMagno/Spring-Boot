package br.com.fiap.universidade_fiap.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DiscenteController {

	@GetMapping("/index")
	public ModelAndView popularIndex()
	{
		return new ModelAndView("/home/index");
	}
	
}
