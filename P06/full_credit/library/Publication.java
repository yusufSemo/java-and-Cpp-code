package library;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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
    private BufferedReader br;

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

    public Publication(BufferedReader br) throws IOException{
        this.br = br;
        this.title = br.readLine();
        this.author = br.readLine();
        this.copyright = Integer.parseInt(br.readLine());
        String status = br.readLine();
        if (status.equals("checked out")) {
            this.loanedTo = br.readLine();
            this.dueDate = LocalDate.parse(br.readLine());
        } else {
            this.loanedTo = null;
            this.dueDate = null;
        }
    }
    public void save(BufferedWriter bw) throws IOException {
        
        bw.write(title);
        bw.newLine();
        bw.write(author);
        bw.newLine();
        bw.write(Integer.toString(copyright));
        bw.newLine();

        if (loanedTo == null) {
            bw.write("checked in");
            bw.newLine();
        } else {
            bw.write("checked out");
            bw.newLine();
            bw.write(loanedTo);
            bw.newLine();
            bw.write(dueDate.toString()); // Convert LocalDate to String
            bw.newLine();
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

