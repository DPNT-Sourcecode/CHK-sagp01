package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) 
    {
    	
    	String currentChar="";
    	Integer ACount =0;
    	Integer ADiscount=0;
    	Integer BDiscount=0;
    	Integer BCount =0;
    	Integer CCount =0;
    	Integer DCount =0;
    	Integer total=0;
    	// this one doesn't make a lot of senses !!
    	// we can return the value for A , B C etc.... but with a single parameter we can't specify the quantity.
    	// unless we do something like pass in a JSON object.
    	// to read that though we need a specification for the object.
    	// this solution will just return the price but not taking into account the quality discount.
    	for (int charNo=0; charNo<skus.length();charNo++)
    	{
    		currentChar=skus.substring(charNo, charNo+1);
    		if (currentChar.equals("A"))
    		{
    			ACount++;
    			if (ACount>3)
    			{
    				ADiscount++;
    				ACount=0;
    			}
    		}
    		else if (currentChar.equals("B"))
    		{
    			BCount++;
    			if (BCount>2)
    			{
    				BDiscount++;
    				BCount=0;
    			}
    	   	}
    		else if (currentChar.equals("C"))
    		{
    			CCount++;
    	 	}
    		else if (currentChar.equals("D"))
    		{
    			DCount++;
    	    }
    		else
    		{
    			return -1;
    		}
    	}
    	
    	// calculat the totals 
    	// logic assumes that all the A or B won't be in sequence but will still qualify fir a discount
    	total = (ACount*50) + (ADiscount*130) + (BCount*30) + (BDiscount*45) + (CCount*20) + (DCount*15);
    	
    	return total;
    	
    	
    }
}
