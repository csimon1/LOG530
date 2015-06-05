

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MovieTest {
	Movie m0;
	Movie m1;
	Movie m2;

	@Before
	public void setUp() throws Exception {
		m0 = new Movie("Matrix", 0);
		m1 = new Movie("Titanic", 1);
		m2 = new Movie("Jumanji", 2);
	}

	//Commented for refactor check
	/*
	@Test
	public void testMovie() {
		assertNull(new Movie("Mad max", -1)); //devrait fail bad pricecode !
	}
	*/

	@Test
	public void testGetPriceCode0() {
		assertTrue(m0.getPriceCode()==0);
	}
	
	@Test
	public void testGetPriceCode1() {
		assertTrue(m1.getPriceCode()==1);
	}
	
	@Test
	public void testGetPriceCode2() {
		assertTrue(m2.getPriceCode()==2);
	}

	@Test
	public void testSetPricCode0() {
		assertTrue(m2.getPriceCode()==2);
		m2.setPricCode(0);
		assertTrue(m2.getPriceCode()==0);
	}
	
	//Commented for refactor check
	/*
	@Test
	public void testSetPricCode1() {
		assertTrue(m2.getPriceCode()==2);
		m2.setPricCode(-1);
		assertFalse(m2.getPriceCode()==-1); //bad enum
	}
	*/


	@Test
	public void testGetTitle1() {
		assertTrue(m0.getTitle().compareTo("Matrix")==0);
	}
	
	@Test
	public void testGetTitle2() {
		Movie mstring = new Movie("MadMax\\0Mouahaha", 2); //test de string escape
		//System.out.println("mstring title="+mstring.getTitle()+" len="+mstring.getTitle().length());
		assertTrue(mstring.getTitle().length()==16);
	}

}
