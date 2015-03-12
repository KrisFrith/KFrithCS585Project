//Iterates through object inatantiations of the classes and notes the quantity and names
//of methods for each class.

package CS585Project;

import java.lang.reflect.Method;
import java.io.*;
import java.lang.String;

public class CountClassMethods {
	
	public Method[] countClassMethods(String fileName) throws ClassNotFoundException{
		 Class className= Class.forName(fileName);
         Method[] methods= className.getDeclaredMethods();

          System.out.println("\nA quantity of " + methods.length + " method(s) was found for " + className + ".  The methods are:");
          for(int i=0;i<methods.length;i++){
               System.out.println(methods[i]);

       }
  		System.out.println("**************************************************");
       return methods;
    } 
}

