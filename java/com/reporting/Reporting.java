package com.reporting;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.baseclass.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author jayavel
 * @date 03-10-2022
 * @see used to maintain the reports with get configuration of the project
 *
 */


public class Reporting extends BaseClass {
	
	/**
	 * 
	 * @param jsonfile
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see generate the jvm report with report builder for json file
	 */
	
	
	public static void generateJvmReport(String jsonfile) throws FileNotFoundException, IOException {
		
		File f = new File(System.getProperty("user.dir")+getPropertyFileValue("jvmpath"));
		
	
		Configuration config = new Configuration(f, "Adactin Hotel");
		
		config.addClassifications("Browser", "microsoftedge");
		config.addClassifications("Browser ver", "105.05");
		config.addClassifications("Os", "WINDOW10");
		config.addClassifications("Testing", "Sanity");
		
		List<String> jsonfilesList = new ArrayList<String>();
		jsonfilesList.add(jsonfile);
		
		
		ReportBuilder bulid = new ReportBuilder(jsonfilesList, config);
		
		bulid.generateReports();
		
		
	}

	
	
	
	
	

}
