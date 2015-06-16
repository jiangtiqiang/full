package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Book;

public interface IBookService {

	public List<Book> getBook();

	public void insertBook(Book book, HttpServletRequest request);

	public void updateBook(Book book, HttpServletRequest request);

	public void deleteBook(Book book, HttpServletRequest request);
}
