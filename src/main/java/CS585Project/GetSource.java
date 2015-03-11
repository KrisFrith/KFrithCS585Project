package CS585Project;

import java.io.FileInputStream;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;


public class GetSource {
	public class MethodPrinter {

	    public void methodPrinter(String fileName) throws Exception {
	        // creates an input stream for the file to be parsed
	        FileInputStream in = new FileInputStream(fileName);

	        CompilationUnit cu;
	        try {
	            // parse the file
	            cu = JavaParser.parse(in);
	        } finally {
	            in.close();
	        }

	        // visit and print the methods names
	        new MethodVisitor().visit(cu, null);
	    }

	    /**
	     * Simple visitor implementation for visiting MethodDeclaration nodes. 
	     */
	    private class MethodVisitor extends VoidVisitorAdapter {

	        @Override
	        public void visit(MethodDeclaration n, Object arg) {
	            // here you can access the attributes of the method.
	            // this method will be called for all methods in this 
	            // CompilationUnit, including inner class methods
	            System.out.println(n.getName());
	        }
	    }
	}

}
