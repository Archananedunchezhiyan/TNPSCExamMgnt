package com.vast.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.log4j.Logger;

import com.vast.Exceptions.InvalidLoginException;
import com.vast.Exceptions.InvalidRegisterException;
import com.vast.vo.Examinor;
import com.vast.vo.Login;
import com.vast.vo.Register;

public class DbExaminerDao implements IExaminerDao{
	static Logger logger=Logger.getLogger("vast");
	static ResourceBundle rb=ResourceBundle.getBundle("vast");

	private static IExaminerDao dao=new DbExaminerDao();
	public DbExaminerDao() {
		
	}
	
	static {
		try {
			Class.forName(rb.getString("driver"));
			logger.debug("driver loaded successfully...");
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	
public static IExaminerDao getDaoInstance()	{
	return dao;
	
}
	
   
   @Override
	public boolean g1addExaminer(Examinor exam) {
	
	   	Connection conn=null;
		
		try {
			 conn=DriverManager.getConnection(rb.getString("url"),rb.getString("uname"),
					rb.getString("pwd"));
			logger.debug("Connected to mysqlserver suceessfully...");
			
			
			String sql="insert into G1examiner values(?,?,?,?)";
			PreparedStatement st=conn.prepareStatement(sql);
			
			st.setString(1, exam.getEname());
			st.setInt(2, exam.getAge());
			st.setString(3, exam.getDegree());
			st.setString(4, exam.getLoc());
			
			
		
			int res=st.executeUpdate();
			
			if(res>0) {
				return true;
				
			}
			logger.info("employee added to the db");
			
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			
			
		}
		finally {
			closeConnection(conn);
		}
		
		return false;
	
  
	}
  
   
   
   
   
	@Override
	public boolean g2addExaminer(Examinor exam) {
	   	Connection conn=null;
		
			try {
				 conn=DriverManager.getConnection(rb.getString("url"),rb.getString("uname"),
						rb.getString("pwd"));
				logger.debug("Connected to mysqlserver suceessfully...");
				
				
				String sql="insert into G2examiner values(?,?,?,?)";
				PreparedStatement st=conn.prepareStatement(sql);
				
				st.setString(1, exam.getEname());
				st.setInt(2, exam.getAge());
				st.setString(3, exam.getDegree());
				st.setString(4, exam.getLoc());
				
				
			
				int res=st.executeUpdate();
				
				if(res>0) {
					return true;
					
				}
				logger.info("employee added to the db");
				
				
			} catch (SQLException e) {
				logger.error(e.getMessage());
				
				
			}
			finally {
				closeConnection(conn);
			}
			
			return false;
	}
   
   
   
   
   
   
   
	@Override
	public boolean g2aaddExaminer(Examinor exam) {
	 	Connection conn=null;
		
		try {
			 conn=DriverManager.getConnection(rb.getString("url"),rb.getString("uname"),
					rb.getString("pwd"));
			logger.debug("Connected to mysqlserver suceessfully...");
			
			
			String sql="insert into G2Aexaminer values(?,?,?,?)";
			PreparedStatement st=conn.prepareStatement(sql);
			
			st.setString(1, exam.getEname());
			st.setInt(2, exam.getAge());
			st.setString(3, exam.getDegree());
			st.setString(4, exam.getLoc());
			
			
		
			int res=st.executeUpdate();
			
			if(res>0) {
				return true;
				
			}
			logger.info("employee added to the db");
			
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
			
			
		}
		finally {
			closeConnection(conn);
		}
		
		return false;
		
	}
   
   
   
	@Override
	public boolean g4addExaminor(Examinor exam) {
	 	Connection conn=null;
		
			try {
				 conn=DriverManager.getConnection(rb.getString("url"),rb.getString("uname"),
						rb.getString("pwd"));
				logger.debug("Connected to mysqlserver suceessfully...");
				
				
				String sql="insert into G4examiner values(?,?,?,?)";
				PreparedStatement st=conn.prepareStatement(sql);
				
				st.setString(1, exam.getEname());
				st.setInt(2, exam.getAge());
				st.setString(3, exam.getDegree());
				st.setString(4, exam.getLoc());
				
				
			
				int res=st.executeUpdate();
				
				if(res>0) {
					return true;
					
				}
				logger.info("employee added to the db");
				
				
			} catch (SQLException e) {
				logger.error(e.getMessage());
				
				
			}
			finally {
				closeConnection(conn);
			}
			
			return false;
		
	}
   
   
   
   
   

		
   
   
   
   
	@Override
	public Login getLoginDetails(String uname, String pwd)throws InvalidLoginException {
		// TODO Auto-generated method stub
		Connection conn=null;
		Login login=null;
		try {
			 conn=DriverManager.getConnection(rb.getString("url"),rb.getString("uname"),
					rb.getString("pwd"));
			logger.debug("Connected to server suceessfully...");
			
			String sql="select * from login where user_name=? and pwd=?";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pwd);
			ResultSet rs=st.executeQuery();
			
			while (rs.next()) {
				
				login=new Login();
//				login.setUserId(rs.getInt("user_id"));
				login.setUsername(rs.getString("user_name"));
				login.setPwd(rs.getNString("pwd"));
			}
			logger.info("datas retrived from DB..");
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
		
		}
		finally {
			closeConnection(conn);
		}
		
		return login;
	}
	
	
	private void closeConnection(Connection conn) {
		try {
			conn.close();
			logger.debug("connection closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
	}



	@Override
	public Register getRegisterDetails(String name, String email, String pwd, String confrmpwd)throws InvalidRegisterException {
	    Connection conn = null;
	    Register register = null;
	    try {
	       
	        conn = DriverManager.getConnection(rb.getString("url"), rb.getString("uname"), rb.getString("pwd"));
	        logger.debug("Connected to mysql server successfully...");

	      
	        String sql = "INSERT INTO register VALUES (?, ?, ?, ?)";
	        PreparedStatement st = conn.prepareStatement(sql);

	        st.setString(1, name);
	        st.setString(2, email);
	        st.setString(3, pwd);
	        st.setString(4, confrmpwd);

	       
	        int result = st.executeUpdate(); 

	     
	        if (result > 0) {
	            logger.info("User successfully added to the database");

	          
	            register = new Register();
	            register.setName(name);
	            register.setEmail(email);
	            register.setPwd(pwd);
	            register.setConfrmpwd(confrmpwd);
	        } else {
	            logger.warn("User was not added to the database.");
	        }
	    } catch (SQLException e) {
	        logger.error("Error occurred while inserting data", e);
	    } finally {
	        
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                logger.error("Failed to close the connection", e);
	            }
	        }
	    }

	  
	    return register;
	}



	


	





	


	





}
