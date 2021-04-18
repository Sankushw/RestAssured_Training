package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features="Features", glue="Step_definition",tags="@DeletePlace",plugin="json:target/jsonReports/cucumber-report.json")
public class TestRunner {
	
}

//if multiple feature files are present the give the path to that feature file in @CucumberOptions above..eg "src/test/java/Features/featureFile1"  
//hooks can be used to run piece of code beore and after every scenario using: @Before and @After tags in a separate hook class
//to run test from cmd, got to project home location in cmd and write mvn test
//to pass tags from cmd: mvn test -Dcucumber.options="--tags @AddPlace"   here -D means parameter
//to use better external reporting-->use  damianszczepanik /maven-cucumber-reporting-->add its dependency from google in pom file and modify version in it as per website--also remove the <classificationFiles> tag from pom
//and it accepts json file at "target/jsonReports/cucumber-report.json" location as input and outputs to "target/cucumber-html-reports".Open the overview-features.html report
//so add this location in @CucumberOptions with plugin parameter.
//Now run the script with verify goal only-->mvn verify(in cmd)--->reporting is done after tests are run, so we use verify goal after that
  
// to install jenkins: install jenkins java package war--in CMD  go to war location (now kept in C root location)and -->java -jar jenkins.war --httpPort=any portno (eg 9090)
//to create freestyle project for cucumberMaven project-->General-advanced-use custom workspace-give project root directory path--add buildstep-invoke top level maven targets--enter goals
//to run parameterized goals in Jenkins -->General-this proj is parameterized-give name and values. Use the name in double quotes in goal as "$tag" eg:  test verify -Dcucumber.options="--tags @"$tag"


