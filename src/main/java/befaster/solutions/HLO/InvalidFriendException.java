package befaster.solutions.HLO;

public class InvalidFriendException extends Exception 
{
	   public InvalidFriendException()
	    {
	        super();
	    }
	    public InvalidFriendException(String message)
	    {
	        super(message);
	    }
	    public InvalidFriendException(Throwable cause)
	    {
	        super(cause);
	    }
	    public InvalidFriendException(String message, Throwable cause)
	    {
	        super(message, cause);
	    }
}
