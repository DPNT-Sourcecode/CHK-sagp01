package befaster.solutions.HLO;

import befaster.runner.SolutionNotImplementedException;

public class HelloSolution {
	
//	In order to complete the round you need to implement the following method:
//	     hello(String) -> String
//
//	Where:
//	 - param[0] = a String. Ignore for now.
//	 - @return = a String containing a message
	
    public String hello(String friendName)
    {
    	if (friendName==null||friendName.equals(""))
    	{
    		// throw new InvalidFriendException("Null or empty friend -- oh dear");
    		// don't try to be clever with the exception
    		return "Empty or null friend name supplied : please check the data and rerun ";
    		
    	}
    	else
    	{
    		return "Hello, " + friendName + "!";
    		//return "Hello, World!";

    	}
    }
}
