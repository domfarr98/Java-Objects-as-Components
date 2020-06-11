package components;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
	
	public Object interfaceMethod(Object args) throws IOException {
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		Object in = console.readLine();
		
		return in;
		
	}

}
