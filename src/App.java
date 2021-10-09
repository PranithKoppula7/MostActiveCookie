import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class App {
    /**
     * Main program controller, takes in cookie data and prints out most active cookies
     * 
     * @param args, of length 3 representing relative path of csv file, -d flag, and UTC formatted date
     * @throws Exception, FileNotFoundException or IOException
     */
    public static void main(String[] args) throws Exception {
        // read in arguments, with 0 = relative path, 1 = -d parameter, 2 = timestamp
        String path = args[0];
        String date = args[2];

        // keep track of the max cookie count, and use that for priting any cookies with this count
        int maxCookieCount = 0;

        // create file object for relative and absolute paths
        File file = new File(path);

        // map of cookies to track their count
        Map<String, Integer> cookieCount = new HashMap<>();

        // single line read from csv file
		String line = "";

		BufferedReader br = new BufferedReader(new FileReader(file));

		try {
			while((line = br.readLine()) != null) {
				String[] cookieAndDate = line.split(",");
                String cookie = cookieAndDate[0];

                // if we are on first line, skip
                if(cookie.compareTo("cookie") == 0) continue;

                // format date for UTC format to compare against given date param
                String cookieDateStamp = cookieAndDate[1];
                cookieDateStamp = cookieDateStamp.substring(0, 10);

                if(date.compareTo(cookieDateStamp) == 0) {
                    if(cookieCount.get(cookie) != null) {
                        // update cookie count if it exists
                        cookieCount.put(cookie, cookieCount.get(cookie)+1);
                    } else {
                        // put new cookie count
                        cookieCount.put(cookie, 0);
                    }
                    maxCookieCount = Math.max(maxCookieCount, cookieCount.get(cookie));
                }
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            br.close();
        }

        // loop through map, and if cookie count == max count, print
        for(String cookieKey: cookieCount.keySet()) {
            int count = cookieCount.get(cookieKey);
            if(count == maxCookieCount) {
                System.out.println(cookieKey);
            }
        }
    }
}