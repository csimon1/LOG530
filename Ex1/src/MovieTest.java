

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MovieTest {
	Movie m0;
	Movie m1;
	Movie m2;

	@Before
	public void setUp() throws Exception {
		m0 = new RegularMovie("Matrix");
		m1 = new NewReleaseMovie("Titanic");
		m2 = new ChildrensMovie("Jumanji");
	}

	//Commented for refactor check
	/*
	
	@Test(expected = IllegalArgumentException.class) 
	public void testMovie1() {
		assertNull(new RegularMovie(null)); //devrait fail bad title !
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testMovie2() {
		assertNull(new Movie(null, null)); //devrait fail bad title, pricecode !
	}
	*/
	

	@Test
	public void testGetPriceCode0() {
		assertTrue(m0.getPriceCode()== Movie.movieType.REGULAR);
	}
	
	@Test
	public void testGetPriceCode1() {
		assertTrue(m1.getPriceCode()== Movie.movieType.NEW_RELEASE);
	}
	
	@Test
	public void testGetPriceCode2() {
		assertTrue(m2.getPriceCode()== Movie.movieType.CHILDRENS);
	}

	@Test
	public void testSetPricCode0() {
		assertTrue(m2.getPriceCode()== Movie.movieType.CHILDRENS);
		m2.setPricCode( Movie.movieType.NEW_RELEASE );
		assertTrue(m2.getPriceCode()== Movie.movieType.NEW_RELEASE);
	}
	
	//Commented for refactor check
	@Test(expected = IllegalArgumentException.class)
	public void testSetPricCode1() {
		assertTrue(m2.getPriceCode()==Movie.movieType.CHILDRENS);
		m2.setPricCode(null);  //bad enum devrait exception
	}
	


	@Test
	public void testGetTitle1() {
		assertTrue(m0.getTitle().compareTo("Matrix")== 0);
	}
	
	@Test
	public void testGetTitle2() {
		Movie mstring = new ChildrensMovie("MadMax\\0Mouahaha"); //test de string escape
		//System.out.println("mstring title="+mstring.getTitle()+" len="+mstring.getTitle().length());
		assertTrue(mstring.getTitle().length()==16);
	}

}
