import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Publication> publications = new ArrayList<>();
    
    public Library(String name){
        this.name = name;
    }

    public void addPublication(Publication publication){
        publications.add(publication);
    }

    public void checkOut(int publicationIndex, String patron){
        try{
        if(publicationIndex<0 || publications.size()<=publicationIndex){
            throw new IndexOutOfBoundsException("The index is out of bounds");
        }
        else{
        publications.get(publicationIndex).checkOut(patron);
        }
    }
    catch(IndexOutOfBoundsException e){
    System.out.println("Invalid input, choose an option between the bounds");
    }
    }

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