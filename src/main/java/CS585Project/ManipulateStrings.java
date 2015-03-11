package CS585Project;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ManipulateStrings {
	
	//This class will remove the .java for all classes and the Test portion of any test classes with proper naming convention
	public List<String> removeExtensions(List<String> classList){
	
	List<String> currentClassList = classList;
	for (int i = 0; i < currentClassList.size(); i++){
		String fileName = currentClassList.get(i);
		String extensionRemovedClass = StringUtils.substringBefore(fileName, ".");
		currentClassList.set(i, extensionRemovedClass);
		System.out.println("class is " + currentClassList.get(i));
	}
	
	return currentClassList;
	}
}
