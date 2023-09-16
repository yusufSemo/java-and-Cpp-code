package mdi;
import library.Library;
import library.Publication;
import library.Video;
import library.Video.InvalidRuntimeException;

public class LibraryManager {
    
    public static void main(String[] args){
        try{
        Library library = new Library("Library Of Bobby Lee");
        Publication book1 = new Publication("1984", "George Orwell", 1949);
        Publication book2 = new Publication("Animal Farm", "George Orwell", 1945);
        Publication book3 = new Publication("The Green Mile", "Stephen King", 1996);
        Video video1 = new Video("The Shawshank Redemption", "Frank Darabont", 1982, 142);
        Video video2 = new Video("The Green Mile", "Frank Darabout", 1999, 189);
        Video video3 = new Video("Goonies", "Richard Donner",1985 , 114);

        library.addPublication(book1);
        library.addPublication(book2);
        library.addPublication(book3);
        library.addPublication(video1);
        library.addPublication(video2);
        library.addPublication(video3);
        System.out.println(library);
        int selection = Integer.parseInt(System.console().readLine("\nWhich book to check out? "));
        String patron = System.console().readLine("Who are you? ");
        library.checkOut(selection, patron);
        System.out.println(library);
        } catch (InvalidRuntimeException e) {
            // Handle the InvalidRuntimeException here
            System.err.println("Invalid runtime exception: " + e.getMessage());
        
        } catch(Exception e) {
        System.err.println("Unable to check out a publication\n" + e);
        }
    }
}

