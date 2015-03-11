package CS585Project;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CompareMethods {
	
	public void compareMethods (Method[] sourceMethods, Method[] testMethods){
		Method[] source = sourceMethods;
		Method[] test = testMethods;
		List<String> sourceMethodList = new ArrayList();
		List<String> testMethodList = new ArrayList();
		List<String> methodMatchList = new ArrayList();
		int methodMatchCounter = 0;
		
		//Transfer method names from Method source array to String source array for manipulation		
		System.out.println("\nThe source methods are:");

		for (int i = 0; i < source.length; i++){
			Method s = source[i];
			String name = s.getName(); 
			sourceMethodList.add(name);
			System.out.println(name);
		}
		
		//Transfer method names from Method test array to String test array for manipulation
		System.out.println("\nThe test methods are:");
		
		for (int i = 0; i < test.length; i++){
			Method t = test[i];
			String name = t.getName(); 
			testMethodList.add(name);
			System.out.println(name);
			}
		
		for (int i = 0; i < sourceMethodList.size(); i++ ){
			String currentSourceMethod = sourceMethodList.get(i);
			String lowerCaseSourceMethod = currentSourceMethod.toLowerCase();
			for (int x = 0; x < testMethodList.size(); x++){
				String currentTestMethod = testMethodList.get(x);
				String lowerCaseTestMethod = currentTestMethod.toLowerCase();
				if (lowerCaseTestMethod.contains(lowerCaseSourceMethod)){
					methodMatchCounter ++;
					methodMatchList.add(currentSourceMethod);
				}
			}
		}
		System.out.println("\nThere were " + methodMatchCounter + " methods with verified test methods.  They are:\n");
		
		for (int i= 0; i < methodMatchList.size(); i++){
			System.out.println(methodMatchList.get(i));
			
		}
		System.out.println("\n**************************************************");
	}

}
