package com.vast.Dao;

import java.util.Set;

import com.vast.Exceptions.InvalidLoginException;
import com.vast.Exceptions.InvalidRegisterException;
import com.vast.vo.Examinor;
import com.vast.vo.Login;
import com.vast.vo.Register;

public interface IExaminerDao {
	
	Login getLoginDetails(String uname, String pwd)throws InvalidLoginException;
	Register getRegisterDetails(String name, String email,String pwd,String confrmpwd)throws InvalidRegisterException;
	
	boolean g1addExaminer(Examinor exam);
	boolean g2addExaminer(Examinor exam);
	boolean g2aaddExaminer(Examinor exam);
	boolean g4addExaminor(Examinor exam);
     
}
