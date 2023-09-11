import java.time.LocalDate;

public class Publication {
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;

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
    public void checkOut(String patron){
        loanedTo = patron;
        LocalDate Today = LocalDate.now();
        dueDate = Today.plusDays(14);
    }

    @Override
    public String toString(){
        if(loanedTo == null){
        return (title+"-by-()"+author+"),copyrightDate-" + copyright );
        }
        else{
            return (title+"\"-by-("+author+"),copyrightDate-" + copyright + " | loaned to ("+loanedTo+") until-"+dueDate );
        }
    }
}

