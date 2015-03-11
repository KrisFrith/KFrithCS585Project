package CS585Project;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;



public class FindFile {
	
	List<String> textFiles(String directory) {
		  List<String> textFiles = new ArrayList<String>();
		  File dir = new File(directory);
		  for (File file : dir.listFiles()) {
		    if (file.getName().endsWith((".java"))) {
		      textFiles.add(file.getName());

		    }
		  }
		  return textFiles;
		}
	
}
