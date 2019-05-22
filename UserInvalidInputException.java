/**
 * Created by Ferris on 4/19/2017.
 * This class is a user defined Exception class that inherits the capabilities of
 * the IllegalArgumentException class.
 */
public class UserInvalidInputException extends IllegalArgumentException {
    /**
     * Constructor
     *
     * Description:
     * When the argument is empty the constructor will return the message "File was empty"
     */
    public UserInvalidInputException()
    {

        super("File was empty!");
    }

    /**
     * Constructor
     * @param message
     * Description:
     * returns the string argument 'message' when constructor is called
     */
    public UserInvalidInputException(String message)
    {
        super(message);
    }

}
