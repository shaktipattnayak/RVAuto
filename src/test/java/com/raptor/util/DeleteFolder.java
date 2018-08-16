package com.raptor.util;

import java.io.File;
import java.io.IOException;

public class DeleteFolder {
	public static void deleteDir(File dir)
		    throws IOException
		  {
		    if (!dir.isDirectory()) {
		      throw new IOException("Not a directory " + dir);
		    }
		    
		    File[] files = dir.listFiles();
		    for (int i = 0; i < files.length; i++) {
		      File file = files[i];
		      
		      if (file.isDirectory()) {
		        deleteDir(file);
		      }
		      else {
		        boolean deleted = file.delete();
		        if (!deleted) {
		          throw new IOException("Unable to delete file" + file);
		        }
		      } 
		    }
		   dir.delete();
		   new File("C:\\Raptor\\Reports").mkdirs();
		   // System.out.println("File deleted success");
		  }

	
	 //public static void main(String[] args) throws IOException {

	        /*String files; 
	        File file = new File("D:\\TEST_FOLDER");
	        File[] listOfFiles = file.listFiles(); 
	        for (int i = 0; i < listOfFiles.length; i++) 
	        {
	            if (listOfFiles[i].isFile()) 
	            {
	                files = listOfFiles[i].getName();
	                System.out.println(files);
	                if(!files.equalsIgnoreCase("Scan.pdf"))
	                {boolean issuccess=new File(listOfFiles[i].toString()).delete();
	                    System.err.println("Deletion Success "+issuccess);
	                }}}*/
		
	   // }
}
