import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
	
	private String address;
	ArrayList<Book> books;
	
	
	// Library constructor
	public Library(String address) {
		this.address = address;
		books = new ArrayList<Book>();
	}
	
	// Library class getters and setters
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	//Method to print common library hours
	public static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	//Method to print library address
	public void printAddress() {
		System.out.println(getAddress());
	}
	
	
	
	//Method to add book to a library
	public void addBook(Book book) {
		books.add(book);
		
	}
	
	
	//Method to print available books
	public void printAvailableBooks() {
		Book libraryBook;
		boolean libraryIsEmpty = true;
		for(int i=0; i < books.size(); i +=1) {
			libraryBook = books.get(i);
			if(!(libraryBook.isBorrowed())) {
				System.out.println(libraryBook.getTitle());
			}
		}
		if(libraryIsEmpty){
			System.out.println("No books in catalog");
		}
	}
	
	
	
	//Method for borrowing book
	public String borrowBook(String bookTitle){		
		Book libraryBook;
		String libraryBookTitle;
		for(int i = 0; i < books.size(); i+=1){
			libraryBook = books.get(i);
			libraryBookTitle = libraryBook.getTitle();
			if(libraryBookTitle.equals(bookTitle)){
				if(!(libraryBook.isBorrowed())){
					libraryBook.rented();
					System.out.println("You successfully borrowed " + libraryBookTitle);
					return null;
				}else{
					System.out.println("Sorry, this book is already borrowed.");
					return null;
				}
			}
		}
		System.out.println("Sorry, this book is not in our catalog.");
		return null;
	}
	
	
	//Method to return books
			public void returnBook(String bookTitle){
				Book libraryBook;
				String libraryBookTitle;
				Boolean found = false;
				for(int i = 0; i < books.size(); i+=1){
					libraryBook = books.get(i);
					libraryBookTitle = libraryBook.getTitle();
					if(libraryBookTitle.equals(bookTitle)){
						if(libraryBook.isBorrowed()){
							libraryBook.returned();
							System.out.println("You successfully returned " + libraryBookTitle);
							found = true;
							break;
						}
					}
				}
				if(!found){
					System.out.println("Your book was not fond in the library catalog.");
				}
			}
	
	
	// Main method
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 