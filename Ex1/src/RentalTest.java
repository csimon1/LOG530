

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RentalTest {
	Rental r0,r1,r2;
	Movie m0,m1,m2;
	
	@Before
	public void setUp() throws Exception {
		m0 = new RegularMovie("Matrix");
		m1 = new NewReleaseMovie("Titanic");
		m2 = new ChildrensMovie("Jumanji");

		r0 = new Rental(m0, 0);
		r1 = new Rental(m1, 1);
		r2 = new Rental(m2, 2);
	}

	/*
	@Test(expected = IllegalArgumentException.class) 
	public void testRental0() {
		assertNull(new Rental(null, 0)); //devrait fail bad movie
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testRental1() {
		assertNull(new Rental(null, -1)); //devrait fail bad movie and daynum
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testRental2() {
		assertNull(new Rental(m0, -1)); //devrait fail bad   daynum
	}
	*/
	
	@Test
	public void testRentalOk() {
		assertNotNull(r0);
	}

	@Test
	public void testGetDaysRented() {
		assertTrue(r0.getDaysRented()==0);
		assertTrue(r1.getDaysRented()==1);
		assertTrue(r2.getDaysRented()==2);
	}

	@Test
	public void testGetMovie() {
		assertTrue(r0.getMovie() == m0);
		assertTrue(r1.getMovie() == m1);
		assertTrue(r2.getMovie() == m2);
	}

}
