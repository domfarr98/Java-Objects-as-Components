package composition;

public class Sequencer {
	
	Object[] components;
	int[] sequences;
	
	public Sequencer(Object[] components, int[] sequences) {
		
		if (components.length != sequences.length) {
			throw new ArrayIndexOutOfBoundsException("the list of components and cases do not match");
		}
		
		this.sequences = sequences;
		this.components = components;
		
		for(int i=0;i<sequences.length;i++) {
			for(int j=i+1;j<sequences.length;j++) {
				if(sequences[j] < sequences[i]) {
					
					int temp1 = sequences[i];
					Object temp2 = components[i];
					
					sequences[i] = sequences[j];
					components[i] = components[j];
					
					sequences[j] = temp1;
					components[j] = temp2;
				}
			}
		}
	}
	
	public Object interfaceMethod(Object args) {
		
		Object result = args;
		
		for (int i=0;i<components.length;i++) {
			result = Reflector.reflect(components[i], result);
		}
		
		return result;
		
	}
}
