package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) 
    {
    	
    	String currentChar="";
    	Integer ACount =0;
    	Integer ADiscount=0;
    	Integer ADiscountPlus=0;
    	Integer BDiscount=0;
    	Integer BCount =0;
    	Integer CCount =0;
    	Integer ECount =0;
    	Integer DCount =0;
    	Integer total=0;
    	
    	for (int charNo=0; charNo<skus.length();charNo++)
    	{
    		currentChar=skus.substring(charNo, charNo+1);
    		if (currentChar.equals("A"))
    		{
    			ACount++;
    			if (ACount==3)
    			{
    				ADiscount++;
    			}
    			
    			if (ACount==5)
    			{
    				ADiscountPlus++;
    				ADiscount=ADiscount-1;
    				ACount=0;
    			}
    		}
    		else if (currentChar.equals("B"))
    		{
    			BCount++;
    			if (BCount==2)
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
    		else if (currentChar.equals("E"))
    		{
    			ECount++;
    			if (ECount==2)
    			{
    				BCount=BCount-1;
    			}
    	    }
    		else
    		{
    			return -1;
    		}
    	}
    	
    	// calculat the totals 
    	// logic assumes that all the A or B won't be in sequence but will still qualify fir a discount
    	total = (ACount*50) + (ADiscount*130) + (ADiscountPlus*200) +  (BCount*30)  + (CCount*20) + (DCount*15) + (ECount*40);
    	if (BCount>0)
    	{
    		total= total + (BDiscount*45);
    	}
    	
    	return total;
    	
    	
    }
}
