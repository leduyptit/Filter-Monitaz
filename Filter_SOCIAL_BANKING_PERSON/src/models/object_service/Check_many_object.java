package object_service;

import java.util.List;

import json_cv.object;

public class Check_many_object {
	public static int check_many_object(List<object> list,int own){
		int check=0;
		if(list.size()>0){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getid_object() == own || list.get(i).getcid_object() == own){
				check=1;
			}
		}
		}
		else{
			check=1;
		}
		return check;
	}
}
