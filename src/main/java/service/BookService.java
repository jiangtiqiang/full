package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Book;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import utils.HibernateUtil;

@Service
public class BookService implements IBookService {
	public List<Book> getBook() {
		SessionFactory session = HibernateUtil.getSessionFactory();
		String hql = "from Book as book where book.id>1";
		Query query = session.openSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Book> list = query.list();
		return list;
	}

	public void insertBook(Book book, HttpServletRequest request) {
		SessionFactory session = HibernateUtil.getSessionFactory();
		Session ss = session.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(book);
		tx.commit();
	}

	public void updateBook(Book book, HttpServletRequest request) {
		SessionFactory session = HibernateUtil.getSessionFactory();
		Session ss = session.openSession();
		Transaction tx = ss.beginTransaction();
		ss.update(book);
		tx.commit();
	}

	public void deleteBook(Book book, HttpServletRequest request) {
		SessionFactory session = HibernateUtil.getSessionFactory();
		Session ss = session.openSession();
		Transaction tx = ss.beginTransaction();
		ss.delete(book);
		tx.commit();
	}
}
