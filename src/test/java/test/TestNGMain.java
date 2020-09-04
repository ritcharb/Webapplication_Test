
package test;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;
//testxml file invokes and executed using testNG.run()

public class TestNGMain {
	public static void main(String[] args) {
	    TestListenerAdapter tla = new TestListenerAdapter();
	    TestNG testng = new TestNG();
	    List<String> suites = Lists.newArrayList();
	    suites.add("C:\\Users\\Ar_Richya\\eclipse-workspaceNew\\E2EProject\\testng.xml");//path to xml..
	    testng.setTestSuites(suites);
	    testng.run();
	}

}
