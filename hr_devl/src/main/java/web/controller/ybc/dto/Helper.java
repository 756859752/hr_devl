package web.controller.ybc.dto;

import java.util.Date;
import java.util.List;
import java.util.Random;

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
	public int getIndexsub(){
		if(a<6){
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
	 public static int[] randomArray(int min,int max,int n){
	        int len = max-min+1;

	        if(max < min || n > len){
	            return null;
	        }

	        //初始化给定范围的待选数组
	        int[] source = new int[len];
	        for (int i = min; i < min+len; i++){
	            source[i-min] = i;
	        }

	        int[] result = new int[n];
	        Random rd = new Random();
	        int index = 0;
	        for (int i = 0; i < result.length; i++) {
	            //待选数组0到(len-2)随机一个下标
	            index = Math.abs(rd.nextInt() % len--);
	            //将随机到的数放入结果集
	            result[i] = source[index];
	            //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
	            source[index] = source[len];
	        }
	        return result;
	 }
}
