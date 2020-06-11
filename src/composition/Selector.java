package composition;

public class Selector {
	
	Object[] components;
	String[] cases;
	String givenCase;

	public Selector(Object[] components, String[] cases) {
		
		if (components.length != cases.length) {
			throw new ArrayIndexOutOfBoundsException("the list of components, cases or further running does not match");
		}
		
		this.components = components;
		this.cases = cases;
		
	}
	
	public Object interfaceMethod(Object args) {
		
		int selectedCase = 0;
		
		if (givenCase == null) {
			for (int i=0;i<components.length;i++) {
				if (args.equals(cases[i])) {
					selectedCase = i;
					break;
				}
			}
		}
		
		else {
			for (int i=0;i<components.length;i++) {
				if (cases[i] == givenCase) {
					selectedCase = i;
					break;
				}
			}
		}
		
		return Reflector.reflect(components[selectedCase], args);
		
	}
	
	public void chooseCase(String givenCase) {
		
		this.givenCase = givenCase;
		
	}
	
}
