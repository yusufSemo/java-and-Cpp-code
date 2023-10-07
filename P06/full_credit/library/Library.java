package library;
import java.util.ArrayList;
/**
 * Models a Publication.
 * 
 * @author              Yusuf Semo
 * @version             1.0
 * @since               1.0
 * @license.agreement   none
 */

public class Library {
    private String name;
    private ArrayList<Publication> publications = new ArrayList<>();
    
 /**
 *  creates a Library instance
 * @param name      the same of the librar
 * @since           1.0
*/ 
    public Library(String name){
        this.name = name;
    }
/**
 * adds a publication to the Library
 * @param publication    the publication that you want to add
 * @since                1.0  
 */
    public void addPublication(Publication publication){
        publications.add(publication);
    }
/**
 * it checks out a publication to a person
 * @param publicationIndex      the index number of the publication
 * @param patron                who the book is going out to
 * @since   1.0
 */
    public void checkOut(int publicationIndex, String patron){
        publications.get(publicationIndex).checkOut(patron);
    }
/**
 * it checks out a publication to a person
 * @param publicationIndex      the index number of the publication
 * @param patron                who the book is going out to
 * @since   1.0
 */
    public void checkIn(int publicationIndex){
        try{
        publications.get(publicationIndex).checkIn();
    } catch(Exception e) {
        System.err.println("\nUnable to check in publication #" + publicationIndex 
            + ": " + e.getMessage() + "\n");
    }
    }
/**
 * this gives all the publications found in the library
 * @return      returns a string of the publications in the library 
 * @since       1.0
 */
@Override
public String toString(){
    StringBuilder theString = new StringBuilder();
    theString.append(name+System.lineSeparator()+System.lineSeparator());
    int index = 0;
    for(Publication i : publications){
        theString.append(index+") "+i+ System.lineSeparator());
        index++;
    }
    String result = theString.toString();
    return result;
}
}