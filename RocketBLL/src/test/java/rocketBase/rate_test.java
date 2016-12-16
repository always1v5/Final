package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void testRate() throws RateException{
		
		
		assertTrue(RateBLL.getRate(600) == 5);
		assertTrue(RateBLL.getRate(900) == 3.5);
		assertTrue(RateBLL.getRate(700) == 4);
		assertTrue(RateBLL.getRate(680) == 4.5);
		assertTrue(RateBLL.getRate(800) == 3.5);
		
	}
	
	
	@Test
	public void test() {
		assert(1==1);
	}
	@Test
	public void PaymentTest(){
		assertEquals();
		assertEquals();
	}
}
