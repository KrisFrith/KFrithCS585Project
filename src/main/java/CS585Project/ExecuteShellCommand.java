//Clones git repository URLs.  Currently not working.  

package CS585Project;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExecuteShellCommand {
	
/**	public void executeShellCommand(ExecuteShellCommand obj){

			ExecuteShellCommand executeCommand = new ExecuteShellCommand();
		
			String domainName = "https://github.com/KrisFrith/SimpleTestPrograms_CS585.git";
	 
			String command1 = "git init";
			
			String command2 = "git clone " + domainName;
			
 
			String output1 = executeCommand.executeCommand(command1);
			System.out.println(output1);
			
			String output2 = executeCommand.executeCommand(command2);
			System.out.println(output2);
	 
		}
**/
		String executeCommand(String command) {
	 
			StringBuffer output = new StringBuffer();
	 
			Process p;
			try {
				p = Runtime.getRuntime().exec(command);
				p.waitFor();
				BufferedReader reader = 
	                            new BufferedReader(new InputStreamReader(p.getInputStream()));
	 
	                        String line = "";			
				while ((line = reader.readLine())!= null) {
					output.append(line + "\n");
				}
	 
			} catch (Exception e) {
				e.printStackTrace();
			}
	 
			return output.toString();
	 
		}
	 
	
}



