package Bai15;

import java.io.*;
import java.util.ArrayList;

public class DocGhiFile { 
	 public static boolean ghiFile(ArrayList<Khoa> listKhoa, String 
	name) { 
	  try { 
	   FileOutputStream fileOutputStream=new 
	FileOutputStream(name); 
	   ObjectOutputStream objectOutputStream=new 
	ObjectOutputStream(fileOutputStream); 
	   objectOutputStream.writeObject(listKhoa); 
	   objectOutputStream.close(); 
	   fileOutputStream.close(); 
	   return true; 
	  }catch (Exception e) { 
	  } 
	  return false; 
	 } 
	 public static ArrayList<Khoa> docFile(String name){ 
	  ArrayList<Khoa> listKhoa=new ArrayList<>(); 
	  try { 
	   FileInputStream fileInputStream=new 
	FileInputStream(name); 
	   ObjectInputStream inputStream=new 
	ObjectInputStream(fileInputStream); 
	   listKhoa=(ArrayList<Khoa>) inputStream.readObject(); 
	   inputStream.close(); 
	   fileInputStream.close(); 
	  } catch (Exception e) { 
	  } 
	  return listKhoa; 
	 } 
	}
