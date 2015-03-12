//Compares source and test classes - confirming whether or not test classes exist and if they do
//that they conform to naming conventions.

package CS585Project;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CompareClasses {
	
//compares List<String> of source and test code to check naming convention
	
	//compares the test and source list
	public void compareClasses(List<String> foundClasses, List<String> foundTests){
		List<String> classes = foundClasses;
		List<String> tests = foundTests;
		List<String> matchedClasses = new ArrayList<String>();
		int testMatches = 0;
		
		
		for (int i = 0; i < classes.size(); i++){
			String currentClass = classes.get(i);
			if (currentClass != null){
				
				//removes any "Test" if the test class was named using classnameTest convention
				//not a really good way to do this--would need to be reworked to identify the actual "Test" portion of string.
				//currently could potentially remove part of a class name i.e. CheckTime class
				for (int x = 0; x <tests.size(); x++){
					String getTest = tests.get(x);
					String currentTest = StringUtils.substringBefore(getTest, "T");
					
					if (currentTest != null){
						if (currentClass.equals(currentTest))	{
							testMatches ++;
							matchedClasses.add(currentClass);
						}
					}
					else System.out.println("There are no test classes.");
				}
			}
			else System.out.println("There are no regular classes.");
		}
		System.out.println("\nMatch Results \n");
		System.out.println(testMatches + " of " + foundClasses.size() + " regular and test classes match." + "The matches are: " + matchedClasses + "\n");
		if (testMatches == 0){
			System.out.println("Could not identify any test classes with the correct naming convention.");
		}
		System.out.println("**************************************************");
	}

}
