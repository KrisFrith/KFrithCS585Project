package CS585Project;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import java.lang.StringBuilder;

public class ManipulateStrings {
	
	//This class will remove the .java for all classes and the Test portion of any test classes with proper naming convention
	public List<String> removeExtensions(List<String> classListJava){
	
	List<String> currentClassList = classListJava;
	
	for (int i = 0; i < currentClassList.size(); i++){
		String fileName = currentClassList.get(i);
		String extensionRemovedClass = StringUtils.substringBefore(fileName, ".");
		currentClassList.set(i, extensionRemovedClass);
		//System.out.println("Class without .java is " + currentClassList.get(i));
		}
	
	return currentClassList;
	}
	
	public List<String> addProjectName(List<String> classListNotFormal){
		
	List<String> currentClassList = classListNotFormal;
		
	for (int i = 0; i < currentClassList.size(); i++){
		String fileName = "CS585ClassProjectTestCode." + currentClassList.get(i);
		currentClassList.set(i, fileName);
		//System.out.println("class formal name is " + currentClassList.get(i));
		}
	
	return currentClassList;
	} 
}
