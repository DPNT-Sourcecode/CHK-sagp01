package befaster.solutions.CHK;

import javax.security.auth.login.LoginException;

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
		Integer EBAppliedDiscount=0;
		Integer DCount =0;
		Integer total=0;
		Integer EAppDisccounter=0;
		
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
//				if (BCount==2)
//				{
//					BDiscount++;
//					BCount=0;
//				}
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
				EAppDisccounter ++;
				if (EAppDisccounter==2)
				{
					EBAppliedDiscount++;
					// reset the discount counter
					EAppDisccounter=0;
				}
			}
			else
			{
				return -1;
			}
		}

		// fudge for the fact we don't know whether to remove the discount.
		
		if (ADiscount>0)
		{
			ACount=ACount-(3*ADiscount);
		}
		
		// calculat the totals 
		// logic assumes that all the A or B won't be in sequence but will still qualify fir a discount
		total = (ACount*50) + (ADiscount*130) + (ADiscountPlus*200) +  (CCount*20) + (DCount*15) + (ECount*40);

		System.out.println("Skus = " + skus);
		System.out.println("ACount = " + ACount);
		System.out.println("ADisount = " + ADiscount);
		System.out.println("ADiscountPlus = " + ADiscountPlus);

		System.out.println("CCount = " + CCount);
		System.out.println("DCount = " + DCount);
		System.out.println("ECount = " + ECount);
		System.out.println("Discount B For 2E " + EBAppliedDiscount );

		// Apply the B discount for buying multiple E's
		BCount=BCount-EBAppliedDiscount;

		// Now work out how many B's we have left and if that number gives us a better B price.
		// get a number of discounted items
		// So if B is divisible by 2 then all but one are at the reduced price.
		Double BDiscountDouble= new Double(BCount/2);
		
		// BDsicount is currently a value that might be invalid so we need to count the remaining B to see if we are 
		// still entitled to a discount after the A discount
		
		// BDiscount is
		
//		int bCountRequiredForDiscountLevel = BDiscount*2;
//		if (BCount==bCountRequiredForDiscountLevel)
//		{
//			// thats fine we don't need to do anything
//		}
//		else
//		{
//			// need to recalculate the Biscount.
//			Double BDiscountDouble= new Double(BCount/2);
//		}
		
		
		// check to see if we are actually allowed the B Discount for multiple B's 
		// Divide BCount by 2 => the E discount will have overriden the BCount after E Discount is applied.
		
		if (BCount>0)
		{
			total= total+ (BCount*30);
		}

		if (BDiscount>0&&BCount>0)
		{
			total= total+ (BDiscount*45);
		}
		
		System.out.println("BCount = " + BCount);
		System.out.println("BDiscount = " + BDiscount);
		System.out.println("Discount B For 2E " + EBAppliedDiscount );
		System.out.println("Total = " + total);

		return total;	

    	
    }

    
}
