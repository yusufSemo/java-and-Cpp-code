package library;
import java.time.LocalDate;
/**
 * Models a Publication.
 * 
 * @author              Yusuf Semo
 * @version             1.0
 * @since               1.0
 * @license.agreement   none
 */
public class Publication {
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;

 /**
     * Creates a Publication instance.
     *
     * @param title                this is the title of the publication such as title of a book
     * @param author               this is the author of the publication
     * @param copyright            this is the copywrite year of the publication
     * @since                      1.0
     */
    public Publication(String title, String author, int copyright){
        this.title = title;
        this.author = author;
        if((LocalDate.now().getYear())>=copyright && copyright>=1900){
        this.copyright = copyright;
        }
        else{
            throw new IllegalArgumentException("CopyRight year is not between 1900 and this year");
        }
    }
    /**
     *  this checks out a publication to a person, gives a due date for the publication
     * @param patron        this is who the book is going to be lended to 
     * @since               1.0
     */

    public void checkOut(String patron){
        loanedTo = patron;
        LocalDate Today = LocalDate.now();
        dueDate = Today.plusDays(14);
    }
    /**
     *  this checks in a publication , so the publication can be used by others.
     * @since               1.0
     */
    public void checkIn(){
        loanedTo = null;
        dueDate = null;
    }
    /**
     * returns a String that contains the title of the publication, author,and copywrite and also
     * if the book is lent out it says the person its lent to and dutdate.
     * @return      String the information on publication and if it is lent out
     * @since       1.0
     */
    @Override
    public String toString(){
        if(loanedTo == null){
        return ("Book: "+title+"-by-("+author+"),copyrightDate-" + copyright );
        }
        else{
            return ("Book: "+title+"\"-by-("+author+"),copyrightDate-" + copyright + System.lineSeparator()+ " | loaned to ("+loanedTo+") until-"+dueDate );
        }
    }
}

