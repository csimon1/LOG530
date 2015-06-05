

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
		
		m0 = new Movie("Matrix", 0);
		m1 = new Movie("Titanic", 1);
		m2 = new Movie("Jumangi", 2); //madmax
		r0 = new Rental(m0, 0);
		r1 = new Rental(m1, 1);
		r2 = new Rental(m2, 2);
	}

	@Test
	public void testCustomer() {
		assertNull(new Customer (null)); // no name should fail
	}

	@Test
	public void testAddRental() {
		fail("Not yet implemented");

		Customer cbase = new Customer ("Benoit");
		//Customer cbase = c0.clone();
		c0.addRental(r0);
		assertNotEquals(cbase, c0);
	}

	@Test
	public void testGetName() {
		assertTrue(c0.getName().compareTo("Benoit")==0);
		assertTrue(c1.getName().compareTo("Charly")==0);
		assertTrue(c2.getName().compareTo("Max")==0);
	}

	@Test
	public void testStatement() {
		fail("Not yet implemented");
	}

}
