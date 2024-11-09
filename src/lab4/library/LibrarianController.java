package lab4.library;

public class LibrarianController {

	// GRASP Principle: Controller
	// Handles user requests like borrowing and returning books.
	// Delegates tasks to the appropriate objects.
	private Library library;
	
	// DONE: implement functionality of Member class
	public LibrarianController(Library library) {
		this.library = library;
	}
	  public void borrowBook(String memberName, String bookTitle) {
	        Member member = library.findMemberByName(memberName);
	        Book book = library.findBookByTitle(bookTitle);
	        
	        //if member and book is existing:
	        if (member != null && book != null) {
	            member.borrowBook(book);
	        } else {
	            System.out.println("Member or book not found.");
	        }
	    }

	    public void returnBook(String memberName, String bookTitle) {
	        Member member = library.findMemberByName(memberName);
	        Book book = library.findBookByTitle(bookTitle);

	        if (member != null && book != null) {
	            member.returnBook(book);
	        } else {
	            System.out.println("Member or book not found.");
	        }
	    }
	}
