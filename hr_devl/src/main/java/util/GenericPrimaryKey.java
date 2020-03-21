package util;

import java.util.UUID;


public class GenericPrimaryKey {
	public static String getPrimaryKey(){
		return UUID.randomUUID().toString();
	}
}
