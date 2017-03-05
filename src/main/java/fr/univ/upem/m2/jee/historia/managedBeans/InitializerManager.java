/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.upem.m2.jee.historia.managedBeans;

import fr.univ.upem.m2.jee.historia.dbManager.DBManager;
import fr.univ.upem.m2.jee.historia.entity.Login;
import fr.univ.upem.m2.jee.historia.entity.Monument;
import fr.univ.upem.m2.jee.historia.entity.Museum;
import fr.univ.upem.m2.jee.historia.parser.CSVParser;
import fr.univ.upem.m2.jee.historia.parser.JSONParser;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Lamine
 */
@ManagedBean(eager=true, name = "initializer")
@ApplicationScoped
public class InitializerManager {

    /**
     * Creates a new instance of InitializerManager
     */
    public InitializerManager() {
    }
    
    @PostConstruct
    public void init() {
       System.out.println("InitializerManager.java : PostConstruct: InitializerManager is initializing");
        DBManager manager = new DBManager();
        addAdmin(manager);
        initMuseums(manager);
        initMonuments(manager);
        System.out.println("InitializerManager.java : PostConstruct: InitializerManager end");

                 
        
    }  
    
    private void addAdmin(DBManager manager){
        boolean adminPresent = false;
        for (Login x : manager.findAll(Login.class)){
            if(x.getUserName().equals("admin")){
                adminPresent = true; 
                break;
            }
        }
        if(!adminPresent){
            Login admin = new Login();
            admin.setMail("admin@mail");
            admin.setUserName("admin");
            admin.setPassword("admin");
            admin.setPreviousSearch(Collections.EMPTY_LIST);
            manager.save(admin);
        }
        
    }
    
    private void initMuseums(DBManager manager){
        List<Museum> museums = manager.findAll(Museum.class);
        if(museums == null || museums.isEmpty()){
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String realPath = ctx.getRealPath("/");   
            System.out.println("realPath = " + realPath);
            HashSet<Museum> parse = CSVParser.parse(realPath+"/resources/locality/nuitMuse.csv", Museum.class);
            System.out.println("CSV file is here  :" + Paths.get("./").toFile().getAbsolutePath());

            HashMap<String,Museum> retained = new HashMap<>();
            for (Museum x : parse){
                x.setAdresse(x.getStreet()+","+x.getCodePostal() +" "+x.getCity() +" " +x.getCountry());
             
                  retained.putIfAbsent(x.getName(), x);
            }
           

            System.out.println("number of parsed value original = " + parse.size() + "filtered = " + retained.size());
            for(Museum x : retained.values()){
                manager.save(x);
            }
            System.out.println("InitializerManager.java : end of loading Museum: InitializerManager end");

        }
    }

    private void initMonuments(DBManager manager) {
        List<Monument> monuments = manager.findAll(Monument.class);
        if(monuments == null || monuments.isEmpty()){ 
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String realPath = ctx.getRealPath("/");   
            System.out.println("realPath = " + realPath);
             Monument [] monumentstmp = new Monument [1];
            System.out.println("txt file is here  :" + Paths.get("./").toFile().getAbsolutePath());
             monumentstmp = JSONParser.parse(realPath+"/resources/locality/Monument_historique franc.txt", monumentstmp.getClass());
             System.out.println("number of parsed value monuments = " +monumentstmp.length);
             for(Monument x : monumentstmp){
                    System.out.println("monuments name = " + x.getName() );
                    manager.save(x);
             }

            System.out.println("InitializerManager.java : end of loading Monument: InitializerManager end");

        }
    }
   
}
