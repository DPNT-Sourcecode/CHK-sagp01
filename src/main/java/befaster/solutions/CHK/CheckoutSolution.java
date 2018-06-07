package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) 
    {
    	
    	// this one doesn't make a lot of senses !!
    	// we can return the value for A , B C etc.... but with a single parameter we can't specify the quantity.
    	// unless we do something like pass in a JSON object.
    	// to read that though we need a specification for the object.
    	// this solution will just return the price but not taking into account the quality discount.
    	
    	if (skus.equals("A"))
    	{
    		return 50;
    	}
    	else if (skus.equals("B"))
    	{
    		return 30;
    	}
    	else if (skus.equals("A"))
    	{
    		return 20;
    	}
    	else if (skus.equals("A"))
    	{
    		return 15;
    	}
    	else
    	{
    		return -1;
    	}
    	
    }
}
