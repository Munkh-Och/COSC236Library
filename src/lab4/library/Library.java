package lab4.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	//  GRASP Principles: Creator, Controller
	//	Manage the catalog of books and members.
	//	Track which books are borrowed and available
	
	
	// Attributes:
	// private catalog (list of Book) 
	// private members (list of Members)
	private List<Book> catalog;
	private List<Member> members;

	// DONE: implement functionality of Member class
	public Library() {
		catalog = new ArrayList<>();
		members = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		catalog.add(book);
		System.out.println(book.getTitle() + " added to the library catalog");
	}
	
	public void registerMember(Member member) {
		members.add(member);
		System.out.println(member.getName() + " registered as a library member.");
	}
	
	public Book findBookByTitle(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
	
	public Member findMemberByName(String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }
}
