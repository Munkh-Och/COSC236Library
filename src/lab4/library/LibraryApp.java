package lab4.library;

public class LibraryApp {
    public static void main(String[] args) {
    	System.out.println("--- Creating scenario to show the functionalities ---");
        Library library = new Library();
        LibrarianController controller = new LibrarianController(library);
        
        Book dune = new Book("Dune", "Frank Herbert");
        Book nineteenEightyFour = new Book("1984", "George Orwell");
        Book mobyDick = new Book("Moby Dick", "Herman Melville");
        
        // Adding books to the Library
        System.out.println("\nAdding books:");
        library.addBook(dune);
        library.addBook(nineteenEightyFour);
        library.addBook(mobyDick);

        Member alice = new Member("Alice", "1");
        Member bob = new Member("Bob", "2");
        
        // Registering members to the Library
        System.out.println("\nRegistering members:");
        library.registerMember(alice);
        library.registerMember(bob);

        // Borrowing a book
        System.out.println("\nBorrowing a book:");
        controller.borrowBook("Alice", "Dune");
        
        // Borrowing a not available book (Alice already got the book)
        System.out.println("\nBorrowing a not available book:");
        controller.borrowBook("Bob", "Dune");
        
        // Returning a book
        System.out.println("\nReturning a book:");
        controller.returnBook("Alice", "Dune");
        
        // Lookup a book
        System.out.println("\nLooking up the book '1984':");
        Book foundBook = library.findBookByTitle("1984");
        if (foundBook != null) {
            System.out.println("Found book: " + foundBook.getTitle() + " by " + foundBook.getAuthor());
        } else {
            System.out.println("Book not found in the catalog.");
        }

        // Lookup a member
        System.out.println("\nLooking up member 'Alice':");
        Member foundMember = library.findMemberByName("Alice");
        if (foundMember != null) {
            System.out.println("Found member: " + foundMember.getName());
        } else {
            System.out.println("Member not found.");
        }

        // Display all books in the catalog
        System.out.println("\nDisplaying the full library catalog:");
        displayCatalog(library);

        // Remove a book from the catalog
        System.out.println("\nRemoving 'Moby Dick' from the library:");
        library.removeBook(mobyDick);
        displayCatalog(library);

        // Remove a member
        System.out.println("\nRemoving member 'Alice' from the library:");
        library.removeMember(alice);
        System.out.println("\nAttempting to lookup removed member 'Alice':");
        foundMember = library.findMemberByName("Alice");
        if (foundMember == null) {
            System.out.println("Alice is no longer a library member.");
        }
    }

    // Additional method to display the catalog
    public static void displayCatalog(Library library) {
        System.out.println("Library Catalog:");
        for (Book book : library.getCatalog()) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + " (Available: " + book.isAvailable() + ")");
        }
    }
}
