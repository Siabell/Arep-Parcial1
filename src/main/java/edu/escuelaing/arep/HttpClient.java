package edu.escuelaing.arep;

import java.io.*;
import java.net.*;

public class HttpClient {
	

	public static void main(String[] args) throws Exception {
		
		HttpClient client = new HttpClient();
		client.sendPost();
		
	}
	
	private static void sendPost() throws IOException {
		
		//URL url = new URL("https://arep-parcial1-siabatto.herokuapp.com/");
		URL url = new URL("http://localhost:5000/calculator");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		String pruebaLista = "5,4,3,2,1";
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(pruebaLista.getBytes());
		os.flush();
		os.close();
		
		
		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	}
	
}
