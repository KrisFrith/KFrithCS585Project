//Checks methods in the test classes to determine if there are test classes for constructors
//in the source classes.  

package CS585Project;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CheckConstructorTestMethods {
	
	public void checkConstructorTestMethods(Method[] testMethods) {
		
		Method[] method = testMethods;
		List<String> testStrings = new ArrayList();
		List<String> constructorMethods = new ArrayList();
		
		System.out.println("\nThe following classes are constructor test classes:");
		for (int i = 0; i < method.length; i++){
			Method m = method[i];
			String name = m.getName(); 
			testStrings.add(name);
		}
		
		for (int i = 0; i < method.length; i++){
			Method isConstructor = method[i];
			String name = isConstructor.getName(); 
			String lowercaseName = name.toLowerCase();
			if (lowercaseName.contains("constructor")){
				constructorMethods.add(name);
				System.out.println (name);
			}
			
		}
	}
}
