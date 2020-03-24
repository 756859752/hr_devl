package util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Myxxkutil {
		
    public  static  String  GrenericId(List list ,String  fieldName) {
     List<String> listval =new ArrayList<String>();
     String  numval ="";
     int num;
     if(list==null||list.isEmpty()) {
       return "01"; 	 
      }
      
     //获取属性值
     for (Object obj : list) {      
      Class  c=obj.getClass();
        try {
        String   mathodname=  characterHandle(fieldName) ;
        Method   method =c.getMethod(mathodname);
        String   val=(String)method.invoke(obj);
         if("0"==val.substring(0, 1)) {
        	val=val.substring(1);   
          };
         listval.add(val);       
		   } catch (Exception e) {
				// TODO Auto-generated catch block
            e.printStackTrace();
		  } 
	  }        
        
        while(true) {
        	  num = randomNumber();
              numval  = String.valueOf(num); 	
               Boolean flag= listval.contains(numval);
              if(!flag) {
               break; 
              }
            }
        
          if(num>0&&num<=9){
    	   numval ="0"+num;      
             } 
       
        return String.valueOf(numval);  	
     } 
    
    public static String characterHandle(String fieldName) {
		return "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
    	
    }
    
     public static int  randomNumber() {
    	 
         Random random = new Random();
    	 return random.nextInt(99)+1;
     } 
          
}
