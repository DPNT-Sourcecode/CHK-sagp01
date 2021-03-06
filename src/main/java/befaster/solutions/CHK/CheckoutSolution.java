package befaster.solutions.CHK;

import java.util.Vector;

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
		Integer FCount=0;
		Integer Ffullprice=0;
		Integer GCount=0;
		Integer HCount=0;		
		Integer HDiscount=0;
		Integer HDiscountPlus=0;
		Integer ICount=0;
		Integer JCount=0;
		Integer KCount=0;
		Integer KDiscount=0;
		Integer LCount=0;
		Integer MCount=0;
		Integer NCount=0;		
		Integer NDiscount=0;
		Integer OCount=0;
		Integer PCount=0;
		Integer PDiscount=0;
		Integer QCount=0;
		Integer QDiscount=0;
		Integer QFullPrice=0;
		Integer RCount=0;
		Integer SCount=0;
		Integer TCount=0;
		Integer UCount=0;
		Integer Ufullprice=0;
		Integer VCount=0;
		Integer VDiscount=0;
		Integer VDiscountPlus=0;
		Integer WCount=0;
		Integer XCount=0;
		Integer YCount=0;
		Integer ZCount=0;
		Integer STXYZCount=0;
		Vector  vSTXYZ = new Vector();
		
		
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
			else if (currentChar.equals("F"))
			{
				FCount++;
			}
			else if (currentChar.equals("G"))
			{
				GCount++;
			}
			else if (currentChar.equals("H"))
			{
				HCount++;
				if (HCount==5)
				{
					HDiscount++;
				}

				if (HCount==10)
				{
					HDiscountPlus++;
					HDiscount=HDiscount-1;
					HCount=0;
				}
			}
			else if (currentChar.equals("I"))
			{
				ICount++;
			}
			else if (currentChar.equals("J"))
			{
				JCount++;
			}
			else if (currentChar.equals("K"))
			{
				KCount++;
				if (KCount==2)
				{
					KDiscount++;
					KCount=0;
				}
			}
			else if (currentChar.equals("L"))
			{
				LCount++;
			}
			else if (currentChar.equals("M"))
			{
				MCount++;
			}
			else if (currentChar.equals("N"))
			{
				NCount++;
			}
			else if (currentChar.equals("O"))
			{
				OCount++;
			}
			else if (currentChar.equals("P"))
			{
				PCount++;
				if (PCount==5)
				{
					PDiscount++;
					PCount=0;
				}
			}
			else if (currentChar.equals("Q"))
			{
				QCount++;
				if (QCount==3)
				{
					QDiscount++;
					QCount=0;
				}
			}
			else if (currentChar.equals("R"))
			{
				RCount++;
			}
			else if (currentChar.equals("S"))
			{
				SCount++;
				vSTXYZ.addElement("S");
			}
			else if (currentChar.equals("T"))
			{
				TCount++;
				vSTXYZ.addElement("T");
			}
			else if (currentChar.equals("U"))
			{
				UCount++;
			}
			else if (currentChar.equals("V"))
			{
				VCount++;
				if (VCount==2)
				{
					VDiscount++;
				}

				if (VCount==3)
				{
					VDiscountPlus++;
					VDiscount=VDiscount-1;
					VCount=0;
				}
			}
			else if (currentChar.equals("W"))
			{
				WCount++;
			}
			else if (currentChar.equals("X"))
			{
				XCount++;
				vSTXYZ.addElement("X");
			}
			else if (currentChar.equals("Y"))
			{
				YCount++;
				vSTXYZ.addElement("Y");
			}
			else if (currentChar.equals("Z"))
			{
				ZCount++;
				vSTXYZ.addElement("Z");
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

		if (HDiscount>0)
		{
			HCount=HCount-(5*HDiscount);
		}

		if (VDiscount>0)
		{
			VCount=VCount-(2*VDiscount);
		}

		
		// calculat the totals 
		// logic assumes that all the A or B won't be in sequence but will still qualify fir a discount
		total = (ACount*50) + (ADiscount*130) + (ADiscountPlus*200);  
		total =	total + (CCount*20) + (DCount*15) + (ECount*40) + (GCount*20);
		total = total +(HCount*10) + (HDiscount*45) + (HDiscountPlus*80);
		total = total + (ICount*35) + (JCount*60);
		total = total  +(KCount*70) + (KDiscount*120);
		total = total + (LCount*90);
		// deal with N & M later
		total = total + (OCount*10);
		total = total  +(PCount*50) + (PDiscount*200);
		// deal with R & Q later
		// deal with U later
		total = total  +(VCount*50) + (VDiscount*90) + (VDiscountPlus*130);
		total = total + (WCount*20);
				

		System.out.println("Skus = " + skus);

		// Apply the B discount for buying multiple E's
		BCount=BCount-EBAppliedDiscount;

		// Now work out how many B's we have left and if that number gives us a better B price.
		// get a number of discounted items
		// So if B is divisible by 2 then all but one are at the reduced price.
		// Only do this if the E Discount doesn't make all the B's free
		
		if (BCount>0)
		{
			if (BCount%2==0)
			{
				BDiscount=BCount/2;
				BCount=BCount-(2*BDiscount);
			}
			else
			{
				BDiscount=Math.round(BCount/2);
				BCount=BCount-(2*BDiscount);
			}
		}
		
		// check to see if we are actually allowed the B Discount for multiple B's 
		// Divide BCount by 2 => the E discount will have overriden the BCount after E Discount is applied.
		
		if (BCount>0)
		{
			total= total+ (BCount*30);
		}

		if (BDiscount>0)
		{
			total= total+ (BDiscount*45);
		}

		/// Same sort of logic for F Count if its divisible by 2 with a remainder take one of the total for the price calc
		if (FCount>0)
		{
			if (FCount%3==0)
			{
				//if  FCount is divisible by 3 then reduce the amount by 33.3%
				// so 3 get 1 free 6 get one free etc...
				total =total + (((FCount/3)*2)*10);
			}
			else
			{
				total =total  +     (((FCount/3)*2)     *10);
				Ffullprice = FCount%3;
				total=total+(Ffullprice*10);
			}
		}

		/// Same sort of logic for N Count if its divisible by 2 with a remainder take one of the total for the price calc
		if (NCount>0)
		{
			total =total + (NCount*40);
			if (NCount%3==0)
			{
				//if  NCount is divisible by 3 then reduce the number of M by 1
				// so 3 get 1 free 6 get two free etc...
				// Calculat the M value
				if (MCount>0)
				{
					total = total + ((MCount-(NCount/3))*15); 
				}
			}
			else
			{

				NDiscount = Math.round(NCount/3);
				// Calculat the M value
				if (MCount>0&&NDiscount>=1)
				{
					total = total + ((MCount-(NCount/3))*15); 
				}
				else if (MCount>0&&NDiscount<1)
				{
					total = total + (MCount*15); 
				}

			}
		}
		else 
		{
			total = total + (MCount*15); 
		}
		
		/// Same sort of logic for N Count if its divisible by 2 with a remainder take one of the total for the price calc
		if (RCount>0)
		{
			total =total + (RCount*50);
			if (QDiscount>0)
			{
				QCount=QCount+(QDiscount*3);
			}

			// Work out the R affect
			if (RCount%3==0)
			{
				//if  RCount is divisible by 3 then reduce the number of Q by 1
				// so 3 get 1 free 6 get two free etc...
				// Calculate the Q value if there are any
				if (QCount>0)
				{
					QCount=(QCount-(RCount/3));
					//total = total + (QCount*30);
				}
			}
			else
			{
				// we have a decimal for the number of R/3
				if (QCount>0&&Math.round(RCount/3)>=1)
				{
					QCount=(QCount-(RCount/3));
				}
				//otherwise we don't do anything as there are no R discounts to apply
			}
			
			// need to work out the discount on the remaining Q
			if (QCount%3==0)
			{
				// apply the discount formula
				total = total + ((QCount/3)*80); 
			}
			else
			{
				QFullPrice = QCount%3;
				total=total+(QFullPrice*30);
			}
			
		}
		else
		{
			// if there are no R then just do the standard discount
			total = total  +(QCount*30) + (QDiscount*80);
		}

		/// Same sort of logic for N Count if its divisible by 2 with a remainder take one of the total for the price calc
		if (UCount>0)
		{
			if (UCount%4==0)
			{
				//if  UCount is divisible by 4 then reduce the amount by 25%
				// so 4 get 1 free 8 get two free etc...
				total =total + (((UCount/4)*3)*40);
			}
			else
			{
				total =total  +     (((UCount/4)*3)     *40);
				Ufullprice = UCount%4;
				total=total+(Ufullprice*40);
			}
		}
		
		
		
		/// figure out the stxyz calc
		if (vSTXYZ.size()>2)
		{
			int itemCount=0;
			int elementRemainingCount=vSTXYZ.size();
			// figure out the scenarios
			
			// go through the array we have created 3 at a time and pull the item out
			// eachtime we have 3 add 45  to the total until we are down to less than 3
			for (int itemNumber=0; itemNumber<vSTXYZ.size(); itemNumber++)
			{
				itemCount++;
				elementRemainingCount--;
				itemCount++;
				elementRemainingCount--;
				itemCount++;
				itemNumber=itemCount;
				elementRemainingCount--;
				total = total + 45;
				if (elementRemainingCount<3)
				{	
					break;
				}
			}
			
			
			// now go through the remainder and price them up one by one.
			String element="";
			for (int itemNumber=itemCount; itemNumber<vSTXYZ.size();itemNumber++)
			{
				element=(String) vSTXYZ.elementAt(itemCount);
				if (element.equals("S")||element.equals("T")||element.equals("Y"))
				{
					total=total+20;
				}
				else if (element.equals("X"))
				{
					total=total+17;
				}
				else if (element.equals("Z"))
				{
					total=total+21;
				}

			}
		}
		else
		{
			total = total + (SCount*20) + (TCount*20)+ (XCount*17) + (YCount*20) + (ZCount*21);
		}

//		System.out.println("BCount = " + BCount);
//		System.out.println("BDiscount = " + BDiscount);
//		System.out.println("Discount B For 2E " + EBAppliedDiscount );
//		System.out.println("FCount = " + FCount);
//		System.out.println("FDiscount = " + FDiscount);
		
		
		System.out.println("Total = " + total);

		return total;	
    	
    }

    
}
