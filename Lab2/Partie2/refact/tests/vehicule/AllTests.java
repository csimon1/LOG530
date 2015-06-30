package vehicule;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EngineTest.class, GearTest.class, TireTest.class,
		TransmissionTest.class, TripTest.class })
public class AllTests {

}
