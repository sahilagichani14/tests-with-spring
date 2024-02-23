package testswithspring;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestsWithSpringApplicationTests.class, DataStoreSystemsHealthTest.class})
public class TestSuite {
    // define all classes above {} & run so all these will be run as a suite
}
