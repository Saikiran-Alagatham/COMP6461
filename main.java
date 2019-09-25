import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class httpc {

	public static void main(String[] args) throws Exception {
	

		Scanner sc = new Scanner(System.in);
        String arg[] = sc.nextLine().split(" ");
        boolean noMethod=true;
		
		for (String str : arg) {
            if (str.toLowerCase().equals("help")) {
               // help(arg);
                
            }
            
            if(str.toLowerCase().equals("get")) {
            	noMethod=false;
            	get(arg);
            }
            
            if(str.toLowerCase().equals("post")) {
            	noMethod=false;
            	//post(arg);
            }
            
           
            
		}
		
		if(noMethod==true) {
		get(arg);	
		}
	
		

	}
	
	public static void get(String s[]) throws Exception {
			
		String link = null;
		boolean verbose=false;
		for(String str:s) {
			if (str.startsWith("http://")) {
				link=str;
			}
			
			if (str.equals("-v")) {
                verbose = true;
            }

		}

		URL u=new URL(link);
		HttpURLConnection connection = (HttpURLConnection) u.openConnection();
		connection.setRequestMethod("GET");
		InputStream in = connection.getInputStream();
        BufferedReader inp = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String i;
        StringBuffer reply = new StringBuffer();
        while ((i = inp.readLine()) != null) {
        	reply.append(i).append("\n");
        }
        in.close();
        
      
        System.out.println(reply.toString());
		
	}

}
