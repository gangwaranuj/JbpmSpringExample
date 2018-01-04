package com.thinksys.bpm.utility;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Test {

	public static int returnRandom(int low,int high){ 
		Random rand = new Random();
		int Low = low;
		int High = high;
		int Result = rand.nextInt(High-Low) + Low;
		return Result;
		}

	public static void saveFile(ArrayList <String> list){ 
	
	Path file = Paths.get("insertScriptFile.txt");
	try {
		Files.write(file, list, Charset.forName("UTF-8"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		
		ArrayList<Integer>geoCode=new ArrayList<Integer>();
		//geoCode.add(50);
		geoCode.add(12035);
		//geoCode.add(18317);
		

		ArrayList<Integer>cityCode=new ArrayList<Integer>();
		cityCode.add(8);
		cityCode.add(12037);
		cityCode.add(9);
	//	geoCode.add(18317);
		
		ArrayList<Integer>extCode=new ArrayList<Integer>();
		extCode.add(21466);
		extCode.add(21467);
		extCode.add(21468);
		extCode.add(21469);
		extCode.add(21470);
		extCode.add(21471);

		ArrayList <String> list = new ArrayList<String>();
		
		String mainQuery="INSERT INTO public.icmp_upn_detail(upn_id, created_by, creation_date, device, extension_upn_id,"
				+ "installation_date, modification_date, modificed_by, os_language,"
				+ "os_name, upn_status, fk_browser_id, fk_city_id, fk_ext_version_id,fk_geo_id, fk_isp_id, fk_product_id, extension_version) VALUES ("; 
				
	for(int i=1520;i<=15000;i++)
		{
			Random ran= new Random();
			String subQuery="";
			int upn_id=i;
			String created_by="'system'";
			String creation_date="'now()'";
			String device="'Desktop'";
			String  extension_upn_id=""+Test.returnRandom(777777779, 999999999);
			String installation_date="'2017-05-"+Test.returnRandom(1, 15)+"'";
			String modification_date="'now()'";
			String modificed_by="'anonymousUser'";
			String os_language="'en-US'";
			String os_name="'Win32'";
			int upn_status=1;
			int fk_browser_id=Test.returnRandom(1,4);
			int fk_city_id=cityCode.get(Test.returnRandom(0,2));
			int fk_ext_version_id=extCode.get(Test.returnRandom(0, 6));
			int fk_geo_id=geoCode.get(Test.returnRandom(0,3));
			int fk_isp_id=Test.returnRandom(1,4);
			int fk_product_id=Test.returnRandom(1,4);
			String extension_version="''";
			subQuery=subQuery+upn_id+","+created_by+","+creation_date+","+device+","+extension_upn_id+","+installation_date+","+modification_date+","+modificed_by+","+os_language+",";
			subQuery=subQuery+os_name+","+upn_status+","+fk_browser_id+","+fk_city_id+","+fk_ext_version_id+","+fk_geo_id+","+fk_isp_id+","+fk_product_id+","+extension_version+");";
/*			System.out.println(mainQuery+subQuery);*/
			list.add(mainQuery+subQuery);
		}
		Test.saveFile(list);
	}

}
