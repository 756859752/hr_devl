package web.controller.ybc.dto;

import java.util.Date;

public class Helper {
	int a=0;
	int index=0;
	public int getIndex(){
		if(a<5){
			a++;
		}else{
			index++;
			a=1;
		}
		return index;
	}
	public static String getExamid(){
		Date d =new Date();
		Long a=d.getTime();
		return a.toString();
	}
}
