package com.ws13.workshop13_ssf;

import java.io.File;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop13SsfApplication {

		public static void main(String[] args) {
			SpringApplication app = new SpringApplication(Workshop13SsfApplication.class);//instantiate a spring application
			//add in code to accept command line arguments
			ApplicationArguments appArgs = new DefaultApplicationArguments(args);//returns the argument as a list of arg type and arg value
			String pathDir ="";
			if (appArgs.containsOption("dataDir")){
				//java myapp.jar --dataDir /opt/tmp/data
				//java -jar target\workshop13-ssf-0.0.1-SNAPSHOT.jar --dataDir=/opt/tmp/data
				pathDir =appArgs.getOptionValues("dataDir").get(0);
				if (pathDir.equals("")){
					System.err.println("Error! Please key in a valid argument. Exiting...");
					System.exit(1);
				}
				pathDir = "."+pathDir;
			}
			else{
				//error to catch if there is no argument or no --dataDir. end program
				System.err.println("Error! Please key in a valid argument. Exiting...");
				System.exit(1);
			}
			//application opens this dir, if it does not exist, create it
			File workingFolder = new File(pathDir);
			if (!workingFolder.exists()){
				workingFolder.mkdirs(); //mkdirs creates more than 1 level, mkdir only one.
				System.out.println("Working directory does not exist, creating it now..");
			}
			System.out.println("\n\n\nThis is the path directory you stated: "+pathDir+"\n\n\n\n");
			
			//javadocs - java.nio.files.Paths and java.nio.files.Files
			app.run(args); //execute the spring application

		
	}

}