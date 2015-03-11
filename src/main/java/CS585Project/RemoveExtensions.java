package CS585Project;

import org.apache.commons.io.FilenameUtils;

public class RemoveExtensions {
	
	void removeFileExtensions(String fileName){
	
	FilenameUtils.removeExtension(fileName);
	}
}
