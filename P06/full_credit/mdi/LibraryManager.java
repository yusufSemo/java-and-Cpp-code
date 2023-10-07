package mdi;
import java.io.Console;
import java.util.Scanner;

import library.Library;
import library.Publication;
import library.Video;

public class LibraryManager {
    private Library library;
    private static Console console = System.console();
    private static final String name = "Library of Bobby Lee";
    
    public LibraryManager(Library library) {
        this.library = library;
    }
    // 1)List the publications in your library 
    public void listPublications(){
        System.out.println("== Library Calalogue =="+System.lineSeparator());
        System.out.println(library); //prints Library name and contents
    }
    public void addPublication(){
        String pub = console.readLine("Enter the name for the publication: ");   if(pub.isEmpty()) return;
        String name = console.readLine("Enter the author's name: ");   if(name.isEmpty()) return;
        int Copyright = Integer.parseInt(console.readLine("Enter the Copyright year: "));
        library.addPublication(new Publication(pub, name, Copyright));
    }
    
    public void addVideo(){
        String vid = console.readLine("Enter the name for the Video: ");   if(vid.isEmpty()) return;
        String name = console.readLine("Enter the author's name: ");   if(name.isEmpty()) return;
        int Copyright = Integer.parseInt(console.readLine("Enter the Copyright year: "));
        int runtime = Integer.parseInt(console.readLine("Enter the Run Time: "));
        library.addPublication(new Video(vid, name, Copyright, runtime));
    }
    public void checkOutPublication(){
        System.out.println(library);
        int selection = Integer.parseInt(System.console().readLine("\nWhich Publication to check out? "));
        String patron = System.console().readLine("Who are you? ");
        library.checkOut(selection, patron);
    }
    public void checkInPublication(){
        System.out.println(library);
        int index = Integer.parseInt(System.console().readLine("\nWhich Publication to check in? "));
        library.checkIn(index);
    }
            
    public static void main(String[] args){
        Library library = new Library(name);
        LibraryManager libMan = new LibraryManager(library);
        library.addPublication( new Publication("1984", "George Orwell", 1949));
        library.addPublication( new Publication("Animal Farm", "George Orwell", 1945));
        library.addPublication( new Publication("The Green Mile", "Stephen King", 1996));
        library.addPublication( new Video("The Shawshank Redemption", "Frank Darabont", 1982, 142));
        library.addPublication(new Video("The Green Mile", "Frank Darabout", 1999, 189));
        library.addPublication( new Video("Goonies", "Richard Donner",1985 , 114));

        Scanner input1 = new Scanner(System.in);
        int in = 100;
        while(in != 0){
            try {
            System.out.printf("\n== Menu ==\n\n");
            System.out.println(name+ System.lineSeparator());
            System.out.printf("0) Exit\n1) List\n2) Add Publication\n3) Add Video\n4) Check out\n5) Check in\n");
            System.out.print(System.lineSeparator() + "Seletion: ");
            in = input1.nextInt();
            input1.nextLine();
            if(in == 1){
                libMan.listPublications();
            }if (in == 2) {
                libMan.addPublication();
            }if (in == 3) {
                libMan.addVideo();
            }if(in == 4){
                libMan.checkOutPublication();
            }if(in == 5){
                libMan.checkInPublication();
            }} catch (Exception e) {
                System.err.println("Error - " + e.getMessage());
            }
        }
        input1.close(); 
    }
}
