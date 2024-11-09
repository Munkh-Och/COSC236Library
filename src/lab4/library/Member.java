package lab4.library;

import java.util.ArrayList;
import java.util.List;

public class Member {

	// GRASP Principle: Information Expert and Low Coupling
	// Can borrow and return books.

	private String name;
	// private borrowedbBooks TODO: implement collection of borrowed books
	private List<Book> borrowedBooks;
	// TODO: implement functionality of Member class
	public Member(String name) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}
	
	public void borrowBook(Book book) {
		if(book.isAvailable()) {
			book.setAvailable(false);
			borrowedBooks.add(book);
			System.out.println(name + " borrowed " + book.getTitle());
		} else {
			System.out.println(book.getTitle() + " is not available");
		}
	}
	
	public void returnBook(Book book) {
		if(borrowedBooks.remove(book)) {
			book.setAvailable(true);
			System.out.println(name + " returned " + book.getTitle());
		}
	}
	
	public String getName() {
		return name;
	}

}
