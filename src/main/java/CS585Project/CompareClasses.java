package CS585Project;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CompareClasses {
	
	public void compareClasses(List<String> foundClasses, List<String> foundTests){
		List<String> classes = foundClasses;
		List<String> tests = foundTests;
		List<String> matchedClasses = new ArrayList<String>();
		int testMatches = 0;
		
		
		for (int i = 0; i < classes.size(); i++){
			String currentClass = classes.get(i);
			if (currentClass != null){
		
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
		System.out.println(testMatches + " of " + foundClasses.size() + " regular and test classes match." + "The matches are: " + matchedClasses);
	}

}
