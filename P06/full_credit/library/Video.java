package library;
import java.time.Duration;
/**
 * Models a Publication.
 * 
 * @author              Yusuf Semo
 * @version             1.0
 * @since               1.0
 * @license.agreement   none
 */
public class Video extends Publication {
    Duration runtime;
/**
 * creates an instance of Video
 * 
 * @param title         title of the Vidoe
 * @param author        Who directed the vidoe
 * @param copyright     year the video is copywrited
 * @param runtime       how many minutes long is the video
 * @since               1.0
 */
    public Video(String title, String author, int copyright, int runtime){
        super(title,author,copyright);
        if(runtime<= 0){
            throw new InvalidRuntimeException(title, runtime);
        }else{
        this.runtime = Duration.ofMinutes(runtime);
        }
    }
    /**
     * returns a String that gives information on the video
     * @return      a mondified toString of Publication plus additon information that relates to video
     *              such as runTime 
     * @since       1.0
     */
    @Override
    public String toString(){
        String string = super.toString().replace("Book:","");
        return "Movie: "+string + " | Runtime: " + runtime.toMinutes() + " minutes";
    }
    
    /**
     * modles an invaled run time exception
     * @author              Yusuf Semo
     * @version             1.0
     * @since               1.0
     * @license.agreement   none
     */
    public class InvalidRuntimeException extends ArithmeticException {
        /**
         * consructs a new InvalidRuntimeExeption with a custom message
         * @since       1.0
         */
        public InvalidRuntimeException() {
            super();
        }
        /**
         * consructs a new InvalidRuntimeExeption with a custom message
         * @param s     the detailed message
         * @since       1.0
         */
        public InvalidRuntimeException(String s) {
            super(s);
        }
        /**
         * gives an exeption if the runTime of a video is invaled such as 0 or negative number
         * @param title     title of the video
         * @param runtime   duration of video
         * @since           1.0
         */
        public InvalidRuntimeException(String title, int runtime) {
            super(title + " has invalid runtime " + runtime);
        }
    }
    
}
