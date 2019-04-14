	package com.neusoft.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.neusoft.model.Person;
import com.neusoft.model.User;

public class GsonTest {
   public static void main(String[] args) {
	   User user = new User(1,"zhangsan","123");
	   User friend1 = new User(1,"zhangsan1","123");
	   User friend2 = new User(2,"zhangsan2","123");
	   User friend3 = new User(3,"zhangsan3","123");
	   
	   List<User> users = new ArrayList<User>();
	   users.add(friend1);
	   users.add(friend2);
	   users.add(friend3);
	  
	   
	   user.setFriends(users);
	   
	   //json 转字符串
	  /* Person person =new Person();
	   person.setUsername("zhangsan");
	   person.setPassword("123");
	   person.setAge(12);
	   Gson gson = new Gson();
	   String jsonTest = gson.toJson(person);
	   System.out.println(jsonTest);*/
	   
	   
	   //字符串转json
	   String str = "{\"username\":\"zhangsan\",\"password\":\"123\",\"age\":12}";
	   Person person = new Gson().fromJson(str, Person.class);
	   System.out.println(person);
	   
	   
}
}
