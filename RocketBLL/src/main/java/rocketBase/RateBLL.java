package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) 
	{
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		ArrayList<RateDomainModel> RateList = RateDAL.getAllRates();
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		double Rates = 0;
		RateDomainModel rate_domain_model1 = new RateDomainModel();
		//TODO - RocketBLL RateBLL.getRate
		//			obviously this should be changed to return the determined rate
		for (RateDomainModel RD : RateList){
			
			if (GivenCreditScore >= RD.getiMinCreditScore()) {
				
				Rates = RD.getdInterestRate();
			}
			
			if (Rates == 0){
				
				throw new RateException(rate_domain_model1);
				
			}
		}
		return Rates;
		
		
		
		
	}
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	//		Parameters:
	//		r - rate
	//		n - num of periods
	//		y - pmt per period
	//		p - future value
	//		t - type (true=pmt at end of period, false=pmt at begining of period)
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		if (r != 0){
			(p*(1+r)^n + y(1+rt)((1+r)^n-1)/r + f) == 0;
		}
		if (r == 0){
			(n*y + p + f) == 0;  
			
		}
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
