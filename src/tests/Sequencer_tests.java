package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import composition.Sequencer;

class Sequencer_tests {

	@Test
	void singleComposureSequencing() {
		
		// create objects
		Obj1 one =  new Obj1();
		Obj3 three =  new Obj3();
		
		// organise into array and assign sequence
		Object components[] = {one, three};
		int sequences[] = {1, 2};
		
		// compose new object using obj1 and obj3 using a sequencer
		Sequencer composure =  new Sequencer(components, sequences);
		
		// use the reflector to invoke the sequence
		Object result = composure.interfaceMethod(null);
		
		// run the test
		assertEquals(result, "this is objects 1 & 3");
	}

}
