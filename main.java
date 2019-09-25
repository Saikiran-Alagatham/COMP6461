import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class httpc {

	public static void main(String[] args) throws Exception {
	
		String s="http://httpbin.org/get?course=networking&assignment=1";
		URL u=new URL(s);
		HttpURLConnection connection = (HttpURLConnection) u.openConnection();
		connection.setRequestMethod("GET");
		InputStream in = connection.getInputStream();
      //  String reply = jsontoString(in);
       // int responseCode = connection.getResponseCode();
      //  System.out.println("\nSending 'GET' request to URL : " + u);
       // System.out.println("Response Code : " + responseCode);
        BufferedReader inp = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String i;
        StringBuffer response = new StringBuffer();
        while ((i = inp.readLine()) != null) {
        	response.append(i);
        }
        in.close();
        
        //print in String
        System.out.println(response.toString());
       
        
       
		
		

	}

}
