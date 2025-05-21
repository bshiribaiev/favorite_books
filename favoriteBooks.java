// Bekbol Shiribaiev
public class favoriteBooks {

	// Main test driver
    public static void main(String[] args) {
		
		// Initializing authors
		Author author1 = new Author("Cal Newport", 1982, "Grand Central Publishing");
		Author author2 = new Author("Hal Elrod", 1979, "Miracle Morning Publishing");
		
		// Initializing my favorite books
		Book book1 = new Book("Deep Work", 2016, author1, "Read");
		Book book2 = new Book("Miracle Morning", 2012, author2, "Read");
		
		// Book to test immutability
		Book bookTest = new Book("Test Book", 2025, author1, "Unread");
		
		System.out.println(author1.getName() + "'s original publisher: " + author1.getPub());
		
		// Changing publisher to further verify immutability
		author1.setPub("Bekbol Publishing");
		
		// Size of the array
		int size = 7;
		Book[] books = new Book[size];
		
        // Adding book to the array
		books[0] = book1;
		books[1] = book2;
		
		// Verifying the bookTest's immutability after changing author's publisher
		System.out.println(author1.getName() + "'s updated publisher: " + author1.getPub() + "\n");
		System.out.println("Test book's original publisher: " + bookTest.author.getPub());
		
        // Printing out the book data
		System.out.println("\nNumber of Books in the library:" + Book.getCount() + "\n");
		
		for(int i = 0; i < Book.getCount() - 1 ; i++) {
			System.out.println(
            "My favorite book " + (i + 1) + ": " 
			+ books[i].getTitle() + ", " + "Author: " 
			+ books[i].getAuthor() + ", " + "Status: " 
			+ books[i].getStatus()
            );
			}
	}
	
	// Author class
	final static class Author {
		private final String name;
		private final int birthY;
		
		// Has to be mutable
		private String curPub; 
		
		// Constructor
		public Author(String name, int birthY, String curPub) {
			this.name = name;
			this.birthY = birthY;
			this.curPub = curPub;
		}
		
		// Getters
		public String getName() {
			return name;
		}
		
		public int getYear() {
			return birthY;
		}
		
		public String getPub() {
			return curPub;
		}
		
		// Setter
		public void setPub(String newPub) {
			this.curPub = newPub;
		}
	}
	
	// Book class
	final static class Book {
		private final Author author;
		private final String title;
		private final int pubYear;
		private final boolean isRead;
		
		// Variable to keep track of book instances
		public static int count = 0;
		
		public Book(String title, int pubY, Author author, String read) {
			this.title = title;
			this.pubYear = pubY;
			this.isRead = read.equalsIgnoreCase("read");
			count++;
			
			// Defensive copy of author to prevent mutability
			this.author = new Author(author.getName(), author.getYear(), author.getPub());
		}
		
		// Getters
		public String getTitle() {
			return title;
		}
		
		public int getYear() {
			return pubYear;
		}
		
		public String getStatus() {
			return isRead ? "Read" : "Unread";
		}
		
		public static int getCount() {
			return count;
		}
		
		public String getAuthor() {
			return author.name;
		}
	}
}
