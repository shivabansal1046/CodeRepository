package dwMapMgmt;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class WebPageReader {
	
	public WebPageReader()
	{
		
	}

	public static void main(String[] args) {
        try {
            URL google = new URL("http://trans-analyticsv2/analytics/saw.dll?dashboard&PortalPath=%2Fshared%2FBids%20Metrics%2F_portal%2FBids%20Metrics");
            BufferedReader in = new BufferedReader(new InputStreamReader(google.openStream()));
            String inputLine; 
 
            while ((inputLine = in.readLine()) != null) {
                // Process each line.
                System.out.println(inputLine);
            }
            in.close(); 
 
        } catch (MalformedURLException me) {
            System.out.println(me); 
 
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }//end main
}
