package CS585Project;

import java.lang.reflect.Method;

public class CountClassMethods {
	public void countClassMethods(String fileName){
        //Class className = null;
       try{
          Class className= Class.forName(fileName);
          Method[] methods= className.getDeclaredMethods();
           System.out.println("Number of methods in "+className+" = "+methods.length);
           for(int i=0;i<methods.length;i++){
               System.out.println(methods[i]);
           }
       }catch(ClassNotFoundException classNotFoundException){
           System.out.println("Class could not be found");
       }

    }
}

