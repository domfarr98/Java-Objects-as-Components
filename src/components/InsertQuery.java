package components;

public class InsertQuery {
	
	public Object interfaceMethod(Object args) {
		
		Object query = "INSERT INTO `example` (`string_list`) VALUES ('" + args + "');";
		
		return query;
		
	}

}
