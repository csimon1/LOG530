

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	Customer c0,c1,c2;
	Rental r0,r1,r2;
	Movie m0,m1,m2;
	
	@Before
	public void setUp() throws Exception {
		c0 = new Customer ("Benoit");
		c1 = new Customer ("Charly");
		c2 = new Customer ("Max");
		
		m0 = new Movie("Matrix", Movie.movieType.REGULAR);
		m1 = new Movie("Titanic", Movie.movieType.NEW_RELEASE);
		m2 = new Movie("Jumanji", Movie.movieType.CHILDRENS);
		
		r0 = new Rental(m0, 0);
		r1 = new Rental(m1, 1);
		r2 = new Rental(m2, 2);
	}

	//Commented for refactor check
	@Test(expected = IllegalArgumentException.class) 
	public void testCustomer() {
		assertNull(new Customer (null)); // no name should fail
	}

	@Test(expected = IllegalArgumentException.class) 
	public void testAddBadRental() {
		c0.addRental(null);
	}
	
	@Test
	public void testAddRentalDuplicate() {
		Customer cbase = new Customer ("Benoit");
		c0.addRental(r0);
		cbase.addRental(r0);
		c0.addRental(r0); //already in there, should discard
		assertEquals(cbase.displayInfos(), c0.displayInfos());
	}
	
	@Test
	public void testAddRental() {
		Customer cbase = new Customer ("Benoit");
		//Customer cbase = c0.clone();
		c0.addRental(r1);
		assertNotEquals(cbase.displayInfos(), c0.displayInfos());
	}
	

	@Test
	public void testGetName() {
		assertTrue(c0.getName().compareTo("Benoit")==0);
		assertTrue(c1.getName().compareTo("Charly")==0);
		assertTrue(c2.getName().compareTo("Max")==0);
	}

	@Test
	public void testStatement0() {
		String stat0 = "Rental Record for Benoit\n"
						+"Amount owed is 0.0\n"
						+"You earned 0frequent renter points";
		String stat1 = c0.displayInfos();
		//System.out.println("co_stat="+stat1);
		assertTrue(stat1.compareTo(stat0)==0);
	}
	
	@Test
	public void testStatement1() {
		String stat0 = "Rental Record for Benoit\n"
						+"	Matrix	2.0\n"
						+"Amount owed is 2.0\n"
						+"You earned 1frequent renter points";
		c0.addRental(r0);
		String stat1 = c0.displayInfos();
		//System.out.println("co_stat="+stat1);
		assertTrue(stat1.compareTo(stat0)==0);
	}
	
	@Test
	public void testStatement2() {
		String stat0 = "Rental Record for Benoit\n"
						+"	Matrix	2.0\n"
						+"	Titanic	3.0\n"
						+"Amount owed is 5.0\n"
						+"You earned 2frequent renter points";
		c0.addRental(r0);
		c0.addRental(r1);
		String stat1 = c0.displayInfos();
		//System.out.println("co_stat="+stat1);
		assertTrue(stat1.compareTo(stat0)==0);
	}

	@Test
	public void testStatement3() {
		String stat0 = "Rental Record for Benoit\n"
						+"	Matrix	2.0\n"
						+"	Titanic	3.0\n"
						+"	Jumanji	1.5\n"
						+"Amount owed is 6.5\n"
						+"You earned 3frequent renter points";
		c0.addRental(r0);
		c0.addRental(r1);
		c0.addRental(r2);
		String stat1 = c0.displayInfos();
		//System.out.println("co_stat="+stat1);
		assertTrue(stat1.compareTo(stat0)==0);		
	}
}
