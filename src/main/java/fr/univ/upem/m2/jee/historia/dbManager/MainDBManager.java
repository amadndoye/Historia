package fr.univ.upem.m2.jee.historia.dbManager;

import fr.univ.upem.m2.jee.historia.entity.Login;
import java.util.Collections;

public class MainDBManager {

	
	public static void main(String arg[]) {
		
		DBManager manager = new DBManager();
                Login admin = new Login();
                admin.setMail("admin@mail");
                admin.setUserName("admin");
                admin.setPassword("admin");
                admin.setPreviousSearch(Collections.EMPTY_LIST);
                manager.save(admin);
		for(Login user : manager.findAll(Login.class)){
			System.out.println("---------------User : " +user.getUserName());
		}
                
                
	}
}
