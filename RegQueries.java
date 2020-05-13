/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dobler
 */
public class RegQueries {
public String FilmerLogin (String Username,String Pass ) {
        String q = 
       "Select filmer.FilmerName from filmer where filmer.UserName = '"+Username+"' AND filmer.Pass='"+Pass+"';";
       String FilmerName = "" ; 
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
            
             result = st.executeQuery(q); 
            ResultSetMetaData md = result.getMetaData();
            int cn = md.getColumnCount();
           
            
           
           while(result.next()) {     
                if(result.getObject(1)!=null) {
                    FilmerName = ""+result.getObject(1);
             } 
           }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                result.close();
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }
   
    return FilmerName ; 
    }
public String AdminLogin (String Username,String Pass ) {
        String q = 
       "Select adminstrator.Name from adminstrator where adminstrator.UserName = '"+Username+"' AND adminstrator.Pass='"+Pass+"';";
       String AdminName = "" ; 
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
            
             result = st.executeQuery(q); 
            ResultSetMetaData md = result.getMetaData();
            int cn = md.getColumnCount();
           
            
           
           while(result.next()) {     
                if(result.getObject(1)!=null) {
                    AdminName = ""+result.getObject(1);
             } 
           }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                result.close();
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }
   
       
    return AdminName ; 
    }
public double AgeReturn (String Username ) {
        String q = 
       "Select convert(current_date(),char) - convert(Birth_Date,char) AS Age from filmer where UserName='"+Username+"'; ";
      double Age = -1 ; 
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
            
             result = st.executeQuery(q); 
            ResultSetMetaData md = result.getMetaData();
            int cn = md.getColumnCount();
           
            
           
           while(result.next()) {     
                if(result.getObject(1)!=null) {
                     Age = (double) result.getObject(1);
             } 
           }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                result.close();
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }
   
       
    return Age ; 
    }


    //filmer (UserName,FilmerName,Birth_Date,Email,Pass)
public String FilmerReg (String Username,String FilmerName,String Birth_Date,String Email, String Pass ) {
        String q = 
       "Insert Into filmer (UserName,FilmerName,Birth_Date,Email,Pass) values ('"+Username+"','"+FilmerName+"','"+Birth_Date+"','"+Email+"','"+Pass+"');";
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             return "NoError";
        } catch (SQLException ex) {
            return "Error";//if the birth date is not good
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    }

public String AddMovie (String MovieName,double MovieLenght,String Genra, int Age_restriction,String MovieDate ) {
        String q = 
       "Insert Into movie (MovieName,Length,Genre,Age_Restriction,Movie_Date_Of_Release) values ('"+MovieName+"',"+MovieLenght+",'"+Genra+"',"+Age_restriction+",'"+MovieDate+"');";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             return "NoError";
        } catch (SQLException ex) {
            return "Error";//if the birth date is not good
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    } 
public String AddList (String UserName,String ListName ) {
        String q = 
       "Insert Into movie_list (UserName,ListName) values ('"+UserName+"','"+ListName+"')";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             return "NoError";
        } catch (SQLException ex) {
            return "Error";//if the list is exists 
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    } 
public void AddMovieToList (String MovieName,String ListName,String UserName ) {
        String q = 
       "Insert Into contains_movie (MovieName,ListName,UserName) values ('"+MovieName+"','"+ListName+"','"+UserName+"');";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    } 
public void AddTVToList (String TV_Name,String ListName,String UserName ) {
        String q = 
       "Insert Into contains_tv (TV_Name,ListName,UserName) values ('"+TV_Name+"','"+ListName+"','"+UserName+"');";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    } 
public String AddTVS (String MovieName,double MovieLenght,String Genra, int Age_restriction,String MovieDate ) {
        String q = 
       "Insert Into tv_series (TV_Name,Episodes,Genre,Age_Restriction,TV_Date_Of_Release) values ('"+MovieName+"',"+MovieLenght+",'"+Genra+"',"+Age_restriction+",'"+MovieDate+"');";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             return "NoError";
        } catch (SQLException ex) {
            return "Error";//if the birth date is not good
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    } 
public String AddRating (String MovieName,double Rating,String UserName ) {
        String q = 
       "Insert into rates (MovieRating,MovieName,UserName) values ("+Rating+",'"+MovieName+"','"+UserName+"');";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             return "NoError";
        } catch (SQLException ex) {
            return "Error";//if the rating already exists
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    } 
public String AddRating_TV (String TV_Name,double Rating,String UserName ) {
        String q = 
       "Insert into rates_tv (Rating,TV_Name,UserName) values ("+Rating+",'"+TV_Name+"','"+UserName+"');";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             return "NoError";
        } catch (SQLException ex) {
            return "Error";//if the rating already exists
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        } }
public String InviteFriend (String Requested,String Invited ) {
        String q = 
       "Insert into invite_filmers (UserName,Friend,Status) values ('"+Requested+"','"+Invited+"','OnHold');";
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             return "NoError";
        } catch (SQLException ex) {
            return "Error";//if the rating already exists
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    } 
public String AcceptFriend (String Requested,String Invited ) {
        String q = 
       "Update invite_filmers\n" +
"set Status ='Accepted'\n" +
"where UserName='"+Requested+"' AND Friend='"+Invited+"';";
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             return "NoError";
        } catch (SQLException ex) {
            return "Error";//if the rating already exists
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    } 
public String RejectFriend (String Requested,String Invited ) {
        String q = 
       "Update invite_filmers\n" +
"set Status ='Rejected'\n" +
"where UserName='"+Requested+"' AND Friend='"+Invited+"';";
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             return "NoError";
        } catch (SQLException ex) {
            return "Error";//if the rating already exists
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    } 
public void UpdateRating (String MovieName,double Rating,String UserName ) {
        String q = 
       "Update rates \n" +
"set MovieRating="+Rating+"\n" +
"where MovieName='"+MovieName+"' AND UserName='"+UserName+"';";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    } 
public void UpdateRating_TV (String TV_Name,double Rating,String UserName ) {
        String q = 
       "Update rates_tv \n" +
"set Rating="+Rating+"\n" +
"where TV_Name='"+TV_Name+"' AND UserName='"+UserName+"';";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    } 
public void DeleteMovie (String MovieName) {
        String q = 
       "Delete from movie where MovieName = '"+MovieName+"';";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    }
public void DeleteTV (String MovieName) {
        String q = 
       "Delete from tv_series where TV_Name = '"+MovieName+"';";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    }

public void DeleteMovieFromList (String MovieName,String ListName,String UserName ) {
        String q = 
       "Delete from contains_movie\n" +
"where UserName='"+UserName+"' AND MovieName='"+MovieName+"' AND ListName ='"+ListName+"';";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
        } catch (SQLException ex) {
            
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    }
public void DeleteTVFromList (String TV_Name,String ListName,String UserName ) {
        String q = 
       "Delete from contains_tv\n" +
"where UserName='"+UserName+"' AND TV_Name='"+TV_Name+"' AND ListName ='"+ListName+"';";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
        } catch (SQLException ex) {
            
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    }
public void DeleteList (String ListName,String UserName ) {
        String q = 
       "Delete from movie_list\n" +
"where ListName='"+ListName+"' AND UserName='"+UserName+"';";
        
        
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
        } catch (SQLException ex) {
            
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    }
public String UpdateMovie (String MovieName,String lenth,String Age,String genere,String Date) {
        String q = 
       "UPDATE movie SET Age_Restriction="+Age+",Length="+lenth+" ,Genre='"+genere+"' ,Movie_Date_Of_Release='"+Date+"' WHERE (`MovieName` = '"+MovieName+"');";
          ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             return "NoError";
        } catch (SQLException ex) {
            return "Error";//if the birth date is not good
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    }
public String UpdateTVS (String MovieName,String lenth,String Age,String genere,String Date) {
        String q = 
       "UPDATE tv_series SET Age_Restriction="+Age+",Episodes="+lenth+" ,Genre='"+genere+"' ,TV_Date_Of_Release='"+Date+"' WHERE (`TV_Name` = '"+MovieName+"');";
          ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             st.executeUpdate(q);
             return "NoError";
        } catch (SQLException ex) {
            return "Error";//if the birth date is not good
        } finally {
            try {
                
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        }   
    }

public boolean IsThereUserName (String Username ) {
        String q = 
       "select UserName from filmer where UserName='"+Username+"';";
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        String name ="";
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             result=st.executeQuery(q);            
            ResultSetMetaData md = result.getMetaData();
            int cn = md.getColumnCount();
           
            
           
           while(result.next()) {     
                if(result.getObject(1)!=null) {
                   name  = ""+result.getObject(1);
             } 
           }
            
           
             
        } catch (SQLException ex) {
          ex.printStackTrace();
        } finally {
            try {
                result.close();
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }  return !name.equals("");
    }
public boolean IsThereTVInList (String Username,String ListName,String TV_Name ) {
        String q = 
       "Select TV_Name from contains_tv where ListName='"+ListName+"' AND UserName='"+Username+"' AND TV_Name='"+TV_Name+"';";
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        String name ="";
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             result=st.executeQuery(q);            
            ResultSetMetaData md = result.getMetaData();
            int cn = md.getColumnCount();
           
            
           
           while(result.next()) {     
                if(result.getObject(1)!=null) {
                   name  = ""+result.getObject(1);
             } 
           }
            
           
             
        } catch (SQLException ex) {
          ex.printStackTrace();
        } finally {
            try {
                result.close();
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }  return !name.equals("");
    }
public boolean IsThereMovieInList (String Username,String ListName,String MovieName ) {
        String q = 
       "Select MovieName from contains_movie where ListName='"+ListName+"' AND UserName='"+Username+"' AND MovieName='"+MovieName+"';";
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        String name ="";
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             result=st.executeQuery(q);            
            ResultSetMetaData md = result.getMetaData();
            int cn = md.getColumnCount();
           
            
           
           while(result.next()) {     
                if(result.getObject(1)!=null) {
                   name  = ""+result.getObject(1);
             } 
           }
            
           
             
        } catch (SQLException ex) {
          ex.printStackTrace();
        } finally {
            try {
                result.close();
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }  return !name.equals("");
    }
public boolean IsThereMovie (String MovieName ) {
        String q = 
       "select MovieName from movie where MovieName='"+MovieName+"';";
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        String name ="";
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             result=st.executeQuery(q);            
            ResultSetMetaData md = result.getMetaData();
            int cn = md.getColumnCount();
           
            
           
           while(result.next()) {     
                if(result.getObject(1)!=null) {
                   name  = ""+result.getObject(1);
             } 
           }
            
           
             
        } catch (SQLException ex) {
          ex.printStackTrace();
        } finally {
            try {
                result.close();
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }  return !name.equals("");
    }
public boolean IsInvited (String UserName,String Friend ) {
        String q = 
       "Select Friend from invite_filmers where UserName='"+UserName+"' AND Friend='"+Friend+"';";
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        String name ="";
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             result=st.executeQuery(q);            
            ResultSetMetaData md = result.getMetaData();
            int cn = md.getColumnCount();
           
            
           
           while(result.next()) {     
                if(result.getObject(1)!=null) {
                   name  = ""+result.getObject(1);
             } 
           }
            
           
             
        } catch (SQLException ex) {
          ex.printStackTrace();
        } finally {
            try {
                result.close();
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }  return !name.equals("");
    }
public boolean IsThereTV (String MovieName ) {
        String q = 
       "select TV_Name from tv_series where TV_Name='"+MovieName+"';";
        ResultSet result=null ; 
        Connection CON=null;
        Statement st =null;
        String name ="";
        try {
            String URL = "jdbc:mysql://localhost/mms";
             CON = DriverManager.getConnection(URL,"root","asdf");
             st = CON.createStatement();
             result=st.executeQuery(q);            
            ResultSetMetaData md = result.getMetaData();
            int cn = md.getColumnCount();
           
            
           
           while(result.next()) {     
                if(result.getObject(1)!=null) {
                   name  = ""+result.getObject(1);
             } 
           }
            
           
             
        } catch (SQLException ex) {
          ex.printStackTrace();
        } finally {
            try {
                result.close();
                st.close();
                CON.close();
        
            } catch (SQLException ex) {
                Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }  return !name.equals("");
    }
public void FilmerdataReturn(Vector data,Vector column,String UserName){
        
        String Queriy= "select UserName , FilmerName, convert( curdate(),char)-convert( Birth_Date,char ) As Age from filmer where upper(UserName) like upper('%"+UserName+"%') OR upper(FilmerName) like upper('%"+UserName+"%') ;";
        Connection DBConnection=null;
       Statement statment=null;
       ResultSet resultQ=null;
       ResultSetMetaData MD=null;
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DBConnection= DriverManager.getConnection("jdbc:mysql://localhost/mms?" +"user=root&password=asdf");
            statment = DBConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultQ= statment.executeQuery(Queriy);
            ResultSetMetaData columnMeta = resultQ.getMetaData(); 
            c = columnMeta.getColumnCount();
            
            for(int i = 1; i <= c; i++) {
                column.add(columnMeta.getColumnName(i)); 
             } 
            Vector row = new Vector();
            while(resultQ.next()) { 
                row = new Vector(c); 

                for(int i = 1; i <= c; i++){
                    row.add(resultQ.getString(i)); 
                 } 

                    data.add(row); 
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
public void RequestsdataReturn(Vector data,Vector column,String UserName){
        
        String Queriy= "Select UserName , FilmerName, convert(curdate()  , char ) -convert(Birth_Date,char) AS Age from invite_filmers natural join filmer where Status='OnHold' AND Friend='"+UserName+"';";
        Connection DBConnection=null;
       Statement statment=null;
       ResultSet resultQ=null;
       ResultSetMetaData MD=null;
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DBConnection= DriverManager.getConnection("jdbc:mysql://localhost/mms?" +"user=root&password=asdf");
            statment = DBConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultQ= statment.executeQuery(Queriy);
            ResultSetMetaData columnMeta = resultQ.getMetaData(); 
            c = columnMeta.getColumnCount();
            
            for(int i = 1; i <= c; i++) {
                column.add(columnMeta.getColumnName(i)); 
             } 
            Vector row = new Vector();
            while(resultQ.next()) { 
                row = new Vector(c); 

                for(int i = 1; i <= c; i++){
                    row.add(resultQ.getString(i)); 
                 } 

                    data.add(row); 
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
public void FriendsdataReturn(Vector data,Vector column,String UserName){
        
        String Queriy= "Select UserName , Friend from invite_filmers where Status='Accepted' AND (UserName='"+UserName+"' OR Friend='"+UserName+"');";
        Connection DBConnection=null;
       Statement statment=null;
       ResultSet resultQ=null;
       ResultSetMetaData MD=null;
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DBConnection= DriverManager.getConnection("jdbc:mysql://localhost/mms?" +"user=root&password=asdf");
            statment = DBConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultQ= statment.executeQuery(Queriy);
            ResultSetMetaData columnMeta = resultQ.getMetaData(); 
            c = columnMeta.getColumnCount();
            
          
                column.add(columnMeta.getColumnName(1)); 
           
            Vector row = new Vector();
            while(resultQ.next()) { 
                row = new Vector(c-1); 

                for(int i = 1; i <= c-1; i++){
                    if(!UserName.equals(resultQ.getString(i)))
                    row.add(resultQ.getString(i)); 
                 } 

                    data.add(row); 
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


public void moviedataReturn(Vector data,Vector column,String MovieName){
        
        String Queriy= "select * from movie where MovieName like upper('%"+MovieName+"%');";
        Connection DBConnection=null;
       Statement statment=null;
       ResultSet resultQ=null;
       ResultSetMetaData MD=null;
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DBConnection= DriverManager.getConnection("jdbc:mysql://localhost/mms?" +"user=root&password=asdf");
            statment = DBConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultQ= statment.executeQuery(Queriy);
            ResultSetMetaData columnMeta = resultQ.getMetaData(); 
            c = columnMeta.getColumnCount();
            
            for(int i = 1; i <= c; i++) {
                column.add(columnMeta.getColumnName(i)); 
             } 
            Vector row = new Vector();
            while(resultQ.next()) { 
                row = new Vector(c); 

                for(int i = 1; i <= c; i++){
                    row.add(resultQ.getString(i)); 
                 } 

                    data.add(row); 
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
public void tvdataReturn(Vector data,Vector column,String MovieName){
        
        String Queriy= "select * from tv_series where TV_Name like upper('%"+MovieName+"%');";
        Connection DBConnection=null;
       Statement statment=null;
       ResultSet resultQ=null;
       ResultSetMetaData MD=null;
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DBConnection= DriverManager.getConnection("jdbc:mysql://localhost/mms?" +"user=root&password=asdf");
            statment = DBConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultQ= statment.executeQuery(Queriy);
            ResultSetMetaData columnMeta = resultQ.getMetaData(); 
            c = columnMeta.getColumnCount();
            
            for(int i = 1; i <= c; i++) {
                column.add(columnMeta.getColumnName(i)); 
             } 
            Vector row = new Vector();
            while(resultQ.next()) { 
                row = new Vector(c); 

                for(int i = 1; i <= c; i++){
                    row.add(resultQ.getString(i)); 
                 } 

                    data.add(row); 
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
public void moviesforfilmerReturn(Vector data,Vector column,String UserName){
        
        String Queriy= "select MovieName, Length,Genre,Movie_Date_Of_Release,MovieRating from movie natural join rates where UserName = '"+UserName+"' order by MovieRating desc;";
        Connection DBConnection=null;
       Statement statment=null;
       ResultSet resultQ=null;
       ResultSetMetaData MD=null;
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DBConnection= DriverManager.getConnection("jdbc:mysql://localhost/mms?" +"user=root&password=asdf");
            statment = DBConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultQ= statment.executeQuery(Queriy);
            ResultSetMetaData columnMeta = resultQ.getMetaData(); 
            c = columnMeta.getColumnCount();
            
            for(int i = 1; i <= c; i++) {
                column.add(columnMeta.getColumnName(i)); 
             } 
            Vector row = new Vector();
            while(resultQ.next()) { 
                row = new Vector(c); 

                for(int i = 1; i <= c; i++){
                    row.add(resultQ.getString(i)); 
                 } 

                    data.add(row); 
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
public void tvforfilmerReturn(Vector data,Vector column,String UserName){
        
        String Queriy= "select TV_Name, Episodes,Genre,TV_Date_Of_Release,Rating from tv_series natural join rates_tv where UserName = '"+UserName+"' order by Rating desc;";
        Connection DBConnection=null;
       Statement statment=null;
       ResultSet resultQ=null;
       ResultSetMetaData MD=null;
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DBConnection= DriverManager.getConnection("jdbc:mysql://localhost/mms?" +"user=root&password=asdf");
            statment = DBConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultQ= statment.executeQuery(Queriy);
            ResultSetMetaData columnMeta = resultQ.getMetaData(); 
            c = columnMeta.getColumnCount();
            
            for(int i = 1; i <= c; i++) {
                column.add(columnMeta.getColumnName(i)); 
             } 
            Vector row = new Vector();
            while(resultQ.next()) { 
                row = new Vector(c); 

                for(int i = 1; i <= c; i++){
                    row.add(resultQ.getString(i)); 
                 } 

                    data.add(row); 
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
public void ListdataReturn(Vector data,Vector column,String UserName){
        
        String Queriy= "Select ListName from movie_list where UserName = '"+UserName+"';";
        Connection DBConnection=null;
       Statement statment=null;
       ResultSet resultQ=null;
       ResultSetMetaData MD=null;
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DBConnection= DriverManager.getConnection("jdbc:mysql://localhost/mms?" +"user=root&password=asdf");
            statment = DBConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultQ= statment.executeQuery(Queriy);
            ResultSetMetaData columnMeta = resultQ.getMetaData(); 
            c = columnMeta.getColumnCount();
            
            for(int i = 1; i <= c; i++) {
                column.add(columnMeta.getColumnName(i)); 
             } 
            Vector row = new Vector();
            while(resultQ.next()) { 
                row = new Vector(c); 

                for(int i = 1; i <= c; i++){
                    row.add(resultQ.getString(i)); 
                 } 

                    data.add(row); 
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
public void SingleListdataReturn(Vector data,Vector column,String UserName,String ListName){
        
        String Queriy= "select MovieName AS Name from contains_movie where ListName='"+ListName+"' AND Username='"+UserName+"' union \n" +
"select TV_name from contains_tv where ListName='"+ListName+"' AND Username='"+UserName+"';";

        Connection DBConnection=null;
       Statement statment=null;
       ResultSet resultQ=null;
       ResultSetMetaData MD=null;
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DBConnection= DriverManager.getConnection("jdbc:mysql://localhost/mms?" +"user=root&password=asdf");
            statment = DBConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultQ= statment.executeQuery(Queriy);
            ResultSetMetaData columnMeta = resultQ.getMetaData(); 
            c = columnMeta.getColumnCount();
            
            for(int i = 1; i <= c; i++) {
                column.add(columnMeta.getColumnName(i)); 
             } 
            Vector row = new Vector();
            while(resultQ.next()) { 
                row = new Vector(c); 

                for(int i = 1; i <= c; i++){
                    row.add(resultQ.getString(i)); 
                 } 

                    data.add(row); 
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
public void moviedataReturnwithrating(Vector data,Vector column,String MovieName){
        
        String Queriy= "select  m.MovieName, m.Age_Restriction, m.Length ,m.Genre ,m.Movie_Date_Of_Release, avg(w.MovieRating)  \n" +
" as TotalRating from movie as m left join rates as w on m.MovieName=w.MovieName where upper(m.MovieName) like upper('%"+MovieName+"%') group by (MovieName)";
        Connection DBConnection=null;
       Statement statment=null;
       ResultSet resultQ=null;
       ResultSetMetaData MD=null;
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DBConnection= DriverManager.getConnection("jdbc:mysql://localhost/mms?" +"user=root&password=asdf");
            statment = DBConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultQ= statment.executeQuery(Queriy);
            ResultSetMetaData columnMeta = resultQ.getMetaData(); 
            c = columnMeta.getColumnCount();
            
            for(int i = 1; i <= c; i++) {
                column.add(columnMeta.getColumnName(i)); 
             } 
            Vector row = new Vector();
            while(resultQ.next()) { 
                row = new Vector(c); 

                for(int i = 1; i <= c; i++){
                    row.add(resultQ.getString(i)); 
                 } 

                    data.add(row); 
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
public void tvdataReturnwithrating(Vector data,Vector column,String TV_Name){
        
        String Queriy= "select  m.TV_Name, m.Age_Restriction, m.Episodes ,m.Genre ,m.TV_Date_Of_Release, avg(w.Rating)  \n" +
" as TotalRating from tv_series as m left join rates_tv as w on m.TV_Name=w.TV_Name where upper(m.TV_Name) like upper('%"+TV_Name+"%') group by (TV_Name)";
        Connection DBConnection=null;
       Statement statment=null;
       ResultSet resultQ=null;
       ResultSetMetaData MD=null;
        try {
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DBConnection= DriverManager.getConnection("jdbc:mysql://localhost/mms?" +"user=root&password=asdf");
            statment = DBConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultQ= statment.executeQuery(Queriy);
            ResultSetMetaData columnMeta = resultQ.getMetaData(); 
            c = columnMeta.getColumnCount();
            
            for(int i = 1; i <= c; i++) {
                column.add(columnMeta.getColumnName(i)); 
             } 
            Vector row = new Vector();
            while(resultQ.next()) { 
                row = new Vector(c); 

                for(int i = 1; i <= c; i++){
                    row.add(resultQ.getString(i)); 
                 } 

                    data.add(row); 
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }

public static void main (String args[]) {
   // String status = FilmerLogin("Ali","1234");
//    System.out.println(status);
  //  System.out.print(AgeReturn("Ali"));
    }
}
