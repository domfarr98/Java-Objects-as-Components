package components;

public class UpdateQuery {
	
	public Object interfaceMethod(Object args) {
		
		String temp = (String) args;
		
		String[] temp1 = temp.split(" ");
		
		Object query = "UPDATE `example` SET `string_list` = '" + temp1[1] + "' WHERE `example`.`index` = " + temp1[0];
		
		return query;
		
	}

}
