package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Book;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utils.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	@RequestMapping("api/book/get")
	@ResponseBody
	public List<Book> getBook() {
		SessionFactory session = HibernateUtil.getSessionFactory();
		String hql = "from Book as book where book.id>1";
		Query query = session.openSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		return list;
	}

	@RequestMapping("api/book/post")
	@ResponseBody
	public void insertBook(@RequestBody Book book, HttpServletRequest request) {
		SessionFactory session = HibernateUtil.getSessionFactory();
		Session ss = session.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(book);
		tx.commit();
	}

	@RequestMapping("api/book/put")
	@ResponseBody
	public void updateBook(@RequestBody Book book, HttpServletRequest request) {
		SessionFactory session = HibernateUtil.getSessionFactory();
		Session ss = session.openSession();
		Transaction tx = ss.beginTransaction();
		ss.update(book);
		tx.commit();
	}

	@RequestMapping("api/book/delete")
	@ResponseBody
	public void deleteBook(@RequestBody Book book, HttpServletRequest request) {
		SessionFactory session = HibernateUtil.getSessionFactory();
		Session ss = session.openSession();
		Transaction tx = ss.beginTransaction();
		ss.delete(book);
		tx.commit();
	}
}
