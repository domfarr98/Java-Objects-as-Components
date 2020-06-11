package main;

import composition.Sequencer;
import composition.Selector;

import components.*;
import components.prompts.*;

public class ComposedComponents {
	
	// create instance of atomic components (objects)
	PromptCustom PromptCustomA = new PromptCustom();
	PromptDelete PromptDeleteA = new PromptDelete();
	PromptInsert PromptInsertA = new PromptInsert();
	PromptReadModify PromptReadModifyA = new PromptReadModify();
	PromptTypeModify PromptTypeModifyA = new PromptTypeModify();
	PromptUpdate PromptUpdateA = new PromptUpdate();
	DeleteQuery DeleteQueryA = new DeleteQuery();
	InsertQuery InsertQueryA = new InsertQuery();
	ReadQuery ReadQueryA = new ReadQuery();
	UpdateQuery UpdateQueryA = new UpdateQuery();
	QuerySubmit QuerySubmitA = new QuerySubmit();
	UserInput UserInputA = new UserInput();
	
	// compose all components
	public void composition() {
		
		// create "insert" sequencer
		Object insert_components[] = {PromptInsertA, UserInputA, InsertQueryA};
		int insert_sequence[] = {1, 2, 3};
		Sequencer InsertC = new Sequencer(insert_components, insert_sequence);
		
		// create "update" sequencer
		Object update_components[] = {PromptUpdateA, UserInputA, UpdateQueryA};
		int update_sequence[] = {1, 2, 3};
		Sequencer UpdateC = new Sequencer(update_components, update_sequence);
		
		// create "delete" sequencer
		Object delete_components[] = {PromptDeleteA, UserInputA, DeleteQueryA};
		int delete_sequence[] = {1, 2, 3};
		Sequencer DeleteC = new Sequencer(delete_components, delete_sequence);
		
		// create "modify type" selector
		Object modify_type_components[] = {InsertC, UpdateC, DeleteC};
		String modify_type_cases[] = {"insert", "update", "delete"};
		Selector ModifyTypeC = new Selector(modify_type_components, modify_type_cases);
		
		// create "modify" sequencer
		Object modify_components[] = {PromptTypeModifyA, UserInputA, ModifyTypeC};
		int modify_sequence[] = {1, 2, 3};
		Sequencer ModifyC = new Sequencer(modify_components, modify_sequence);
		
		// create "custom" sequencer
		Object custom_components[] = {PromptCustomA, UserInputA};
		int custom_sequence[] = {1, 2};
		Sequencer CustomC = new Sequencer(custom_components, custom_sequence);
		
		// create "interface type" selector
		Object interface_type_components[] = {ModifyC, ReadQueryA, CustomC};
		String interface_type_cases[] = {"modify", "read", "custom"};
		Selector InterfaceTypeC = new Selector(interface_type_components, interface_type_cases);
		
		// create "top" sequencer
		Object top_components[] = {PromptReadModifyA, UserInputA, InterfaceTypeC, QuerySubmitA};
		int top_sequence[] = {1, 2, 3, 4};
		Sequencer TopC = new Sequencer(top_components, top_sequence);
		
		
		// implement static selector cases here, e.g.:
	//	InterfaceTypeC.chooseCase("Modify");
		
		
		TopC.interfaceMethod(null);
		
	}
	
	

}
