import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManager {
    
    public static void main(String[] args){
        Library library = new Library("Library Of Bobby Lee");

        Publication book1 = new Publication("1984", "George Orwell", 1949);
        Publication book2 = new Publication("Animal Farm", "George Orwell", 1945);
        Publication book3 = new Publication("The Green Mile", "Stephen King", 1996);

    
        library.addPublication(book1);
        library.addPublication(book2);
        library.addPublication(book3);

        System.out.println(library);
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Which book to check out? ");
        int bookIndex = 0;
        try{
            bookIndex = scanner.nextInt();
            scanner.nextLine();
        } catch(InputMismatchException e){
            System.out.println("Invalid input. put a number that is available");
        }
        System.out.printf("Who are you? ");
        String name = scanner.nextLine();
        library.checkOut(bookIndex,name);
        scanner.close();
        System.out.println(library);

        
    }
}
