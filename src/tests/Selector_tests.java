package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import composition.Reflector;
import composition.Selector;

class Selector_tests extends Reflector {

	@Test
	void singleComposureSelection() {
		
		// create objects
		Obj1 one = new Obj1();
		Obj2 two = new Obj2();
		
		// organise into array and assign cases
		Object components[] = 	{one, 		two};
		String cases[] = 		{"hello", 	"3"};
		
		// compose new object using obj1 and obj2 using a selector
		Selector composure = new Selector(components, cases);
		
		// choose a specific case for this composure
		composure.chooseCase("hello");
		
		// use the reflector to invoke the selected case object
		Object result = composure.interfaceMethod(null);
		
		// compare
		assertEquals(result, "this is object 1");
	}
	
	@Test
	void multiComposureSelection() {
		
		// selection composure 1
		Obj1 one = new Obj1();
		Obj2 two = new Obj2();
		
		Object components1[] = 	{one, 		two};
		String cases1[] = 		{"hello", 	"3"};
		
		Selector composureOne = new Selector(components1, cases1);
		
		composureOne.chooseCase("hello");
		
		
		// selection composure 2
		Obj1 three =  new Obj1();
		Obj2 four = new Obj2();
		
		Object components2[] = 	{three, 	four};
		String cases2[] = 		{"goodbye", "&"};
		
		Selector composureTwo = new Selector(components2, cases2);
		
		composureTwo.chooseCase("&");
		
		
		// combined selection composure (3)
		Object combinedComponents[] = 	{composureOne, composureTwo};
		String cases3[] = 				{"firstComposure", 						"secondComposure"};
		
		Selector combinedComposure = new Selector(combinedComponents, cases3);
		
		combinedComposure.chooseCase("secondComposure");
		
		
		// run test
		Object selection3 = combinedComposure.interfaceMethod(null);
		
		assertEquals(selection3, "this is object 2");
	}

}
