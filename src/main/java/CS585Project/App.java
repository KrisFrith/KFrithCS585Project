package CS585Project;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
//import java.util.Arrays;

//import org.apache.commons.io.FilenameUtils;

import org.apache.commons.lang3.ArrayUtils;
import CS585Project.FindFile;
import CS585Project.CountClassMethods;
import CS585Project.ManipulateStrings;
import CS585Project.CompareClasses;
//import CS585Project.ExecuteShellCommand;
import CS585Project.CompareMethods;
import CS585Project.CheckConstructorTestMethods;



public class App {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//**ExecuteShellCommand is not consistently working so currently moved to a future version 2.0
		
		//ExecuteShellCommand executeCommand = new ExecuteShellCommand();
		
		//String domainName = "https://github.com/KrisFrith/SimpleTestPrograms_CS585.git";
		//String command1 = "C:\\Users\\Kristin\\AppData\\Local\\GitHub\\PortableGit_c2ba306e536fdf878271f7fe636a147ff37326ad\\cmd";
		//String command2 = "git clone " + domainName;
		
		//String output1 = executeCommand.executeCommand(command1);
		//System.out.println(output1);
		
		//String output2 = executeCommand.executeCommand(command2);
		//System.out.println(output2);
		
		//Find the classes and create a list for the source classes
		FindFile findSourceFile = new FindFile();
		List<String> foundSource = new ArrayList<String>();
		foundSource = findSourceFile.textFiles("C:\\Users\\Kristin\\git\\SimpleTestPrograms_CS585\\main\\java\\CS585ClassProject");
		System.out.println("The classes found are: " + foundSource);
	
		//Find the classes and create a list for the test classes
		FindFile findTestFile = new FindFile();
		List<String> foundTest = new ArrayList<String>();
		foundTest = findTestFile.textFiles("C:\\Users\\Kristin\\git\\SimpleTestPrograms_CS585\\test\\java");
		System.out.println("The test classes found are: " + foundTest + "\n");	
		
		System.out.println("**************************************************");
		
		ManipulateStrings manipulateStrings = new ManipulateStrings();
		
		//remove the .java from the classes for the methodCounter
		List<String> sourceClasses = manipulateStrings.removeExtensions(foundSource);
		List<String> testClasses = manipulateStrings.removeExtensions(foundTest);
		
		//Compare the class names to determine if test methods have correct naming convention
		CompareClasses compareClasses = new CompareClasses();
		compareClasses.compareClasses(sourceClasses, testClasses);
		
		//add the package text to the class for the methodCounter
		List<String> formalNameSourceClasses = manipulateStrings.addProjectName(sourceClasses);
		List<String> formalNameTestClasses = manipulateStrings.addProjectName(testClasses);
		
		Method[] sourceMethods = null;;
		Method[] testMethods = null;
		
		//Get the methods for each class in both source and test classes
		for (int i = 0; i < foundSource.size(); i++){
			Method[] currentSourceMethods;
			CountClassMethods countClassMethods = new CountClassMethods();
			currentSourceMethods = countClassMethods.countClassMethods(formalNameSourceClasses.get(i));
			sourceMethods = ArrayUtils.addAll(sourceMethods, currentSourceMethods);
		}
		
		for (int x = 0; x < foundTest.size(); x++){
			Method[] currentTestMethods;
			CountClassMethods countClassMethods = new CountClassMethods();
			currentTestMethods = countClassMethods.countClassMethods(formalNameTestClasses.get(x));
			testMethods = ArrayUtils.addAll(testMethods, currentTestMethods);
		}

		//compare the methods to determine if there are test classes conventionally named to match source classes.
		CompareMethods compareMethods = new CompareMethods();
		compareMethods.compareMethods(sourceMethods, testMethods);
		
		//Do a check for constructor tests
		CheckConstructorTestMethods checkConstructorTestMethods = new CheckConstructorTestMethods();
		checkConstructorTestMethods.checkConstructorTestMethods(testMethods);
		
	}
}
