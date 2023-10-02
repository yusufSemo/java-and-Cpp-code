package mdi;
import java.util.Scanner;

import library.Library;
import library.Publication;
import library.Video;
import library.Video.InvalidRuntimeException;

public class LibraryManager {
    
    public static void main(String[] args){
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

        Scanner input1 = new Scanner(System.in);
        int in = 100;
        while(in != 0){
        System.out.printf("== Menu ==\n\n");
        System.out.printf("0) Exit\n1) List\n2) Add Publication\n3) Add Video\n4) Check out\n5) Check in\n");
        System.out.print(System.lineSeparator() + "Seletion: ");
        in = input1.nextInt();
        input1.nextLine();
        if(in == 1){
            System.out.println("== Library Calalogue =="+System.lineSeparator());
            System.out.println(library); //prints Library name and contents
        }
        if (in == 2) {
            try{
            System.out.print("Enter the name for the publication: ");
            String pub = input1.nextLine();
            System.out.print("Enter the author's name: ");
            String name = input1.nextLine();
            System.out.print("Enter the Copyright year: ");
            int Copyright = input1.nextInt();
            input1.nextLine(); // Consume the newline character
            library.addPublication(new Publication(pub, name, Copyright));
            } catch(Exception e) {
         System.err.println("invalid input, Unable to create out a publication\n" + e);
            } 
        }
        
        if (in == 3) {
            try{
            System.out.print("Enter the name for the Video: ");
            String pub = input1.nextLine();
            System.out.print("Enter the author's name: ");
            String name = input1.nextLine();
            System.out.print("Enter the Copyright year: ");
            int Copyright = input1.nextInt();
            input1.nextLine(); // Consume the newline character
            System.out.print("Enter the Run Time: ");
            int runTime = input1.nextInt();
            input1.nextLine(); // Consume the newline character
            library.addPublication(new Video(pub, name, Copyright, runTime));
             } catch (InvalidRuntimeException e) {
            // Handle the InvalidRuntimeException here
             System.err.println("Invalid runtime exception: " + e.getMessage());
             } catch(Exception e) {
         System.err.println("invalid input, Unable to create out a Video\n" + e);
         }
        }
        if(in == 4){
            System.out.println(library);
            int selection = Integer.parseInt(System.console().readLine("\nWhich Publication to check out? "));
            String patron = System.console().readLine("Who are you? ");
            library.checkOut(selection, patron);
        }
        if(in == 5){
            try{
            System.out.println(library);
            System.out.print("Enter The publicaiton you want to check in: ");
            int index = input1.nextInt();
            library.checkIn(index);
            }catch(Exception e){
                System.err.println("invalid input,unable to check in");  
        }
    }
    }
    input1.close(); 
}
}

