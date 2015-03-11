package CS585Project;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
//import CS585Project.GetSource.MethodPrinter;
import CS585Project.FindFile;
import CS585Project.CountClassMethods;
import CS585Project.ManipulateStrings;
import CS585Project.CompareClasses;
import CS585Project.ExecuteShellCommand;


public class App {

	public static void main(String[] args) {
		
		ExecuteShellCommand executeCommand = new ExecuteShellCommand();
		
		String domainName = "https://github.com/KrisFrith/SimpleTestPrograms_CS585.git";
 		String command001 = "cd ..";
		String command01 = "cd AppData";
 		String command02 = "cd Local";
 		String command03 = "cd GitHub";
		String command1 = "git init";
		String command2 = "git clone " + domainName;
		
		
		String output001 = executeCommand.executeCommand(command001);
		System.out.println(output001);
		
		String output0011 = executeCommand.executeCommand(command001);
		System.out.println(output0011);
		
		String output01 = executeCommand.executeCommand(command01);
		System.out.println(output01);
		
		String output02= executeCommand.executeCommand(command02);
		System.out.println(output02);
		
		String output03 = executeCommand.executeCommand(command03);
		System.out.println(output03);
		
		String output1 = executeCommand.executeCommand(command1);
		System.out.println(output1);
		
		String output2 = executeCommand.executeCommand(command2);
		System.out.println(output2);
		FindFile findSourceFile = new FindFile();
		List<String> foundSource = new ArrayList<String>();
		foundSource = findSourceFile.textFiles("C:\\Users\\Kristin\\git\\SimpleTestPrograms_CS585\\main\\java\\CS585ClassProject");
		System.out.println("The classes found are: " + foundSource);
		
	
		FindFile findTestFile = new FindFile();
		List<String> foundTest = new ArrayList<String>();
		foundTest = findTestFile.textFiles("C:\\Users\\Kristin\\git\\SimpleTestPrograms_CS585\\test\\java");
		System.out.println("The test classes found are: " + foundTest + "\n");	
		
		ManipulateStrings removeExtension = new ManipulateStrings();
		List<String> sourceClasses = removeExtension.removeExtensions(foundSource);
		List<String> testClasses = removeExtension.removeExtensions(foundTest);
		
		for (int i = 0; i < foundSource.size(); i++){
			CountClassMethods countClassMethods = new CountClassMethods();
			countClassMethods.countClassMethods(sourceClasses.get(i));
		}
		
		for (int x = 0; x < foundTest.size(); x++){
			CountClassMethods countClassMethods = new CountClassMethods();
			countClassMethods.countClassMethods(testClasses.get(x));
			}
		
		CompareClasses compareClasses = new CompareClasses();
		compareClasses.compareClasses(sourceClasses, foundTest);
/**
		GetSource getSource = new GetSource();
		MethodPrinter methodPrinter = getSource.new MethodPrinter();
		
		for (int i = 0; i < foundSource.size(); i++){
		     try {
			     methodPrinter.methodPrinter(foundSource.get(i));
		     } catch (Exception e) {
			     System.out.println("Error in methodPrinter");
			     e.printStackTrace();
			     }
		} **/

	}
}
