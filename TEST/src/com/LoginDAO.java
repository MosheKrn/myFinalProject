package com;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.dbUtil;
 
public class LoginDAO {
    public static String loginCheck(LoginBean loginBean){
        String query="select * from login where email=? and password=?";
        
        try{
            Connection con=dbUtil.getConnection();
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,loginBean.getEmail());
            ps.setString(2,loginBean.getPassword());
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                return "true";
            }
            else{
                return "false";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return "error";
    }
}