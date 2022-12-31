/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyClass;

/**
 *
 * @author meone
 */
public class SchoolHELP {
    
    public boolean Login(String Username, String Password){
        if (Username.equals("admin") && Password.equals("root")){
            return true;
        }else{
            return false;
        }
    }
    
}
