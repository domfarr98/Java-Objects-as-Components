package components;

public class DeleteQuery {
	
	public Object interfaceMethod(Object args) {
		
		Object query = "DELETE FROM `example` WHERE `example`.`index` = " + args + ";";
		
		return query;
		
	}

}
