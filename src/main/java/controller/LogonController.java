package controller;

import java.util.List;

import model.Book;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.BookService;

@Controller
public class LogonController {

	private Logger loger = Logger.getLogger(LogonController.class);

	@Autowired
	private BookService bookService;

	@RequestMapping("/home/logon")
	public ModelAndView logon() {
		ModelAndView mv = new ModelAndView();
		List<Book> list = bookService.getBook();
		mv.addObject("bookList", list);
		mv.setViewName("logon");
		loger.info("log4j is working correctly");
		loger.error("谁去投点，马上出来了");
		return mv;

	}
}
