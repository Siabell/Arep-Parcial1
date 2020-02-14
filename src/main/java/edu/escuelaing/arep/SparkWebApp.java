package edu.escuelaing.arep;
import static spark.Spark.*;
import com.google.gson.Gson;

public class SparkWebApp {
	
	
	public static void main(String[] args) {
		staticFiles.location("/WebApp");
		port(getPort());
		get("/hello", (req, res) -> "Hello Heroku");
		 
		get("/calculator/:data", (request, response) -> {
			final Gson gson = new Gson();
			//response.redirect("/index.html");
			response.type("application/json");
            //final String calculatorResult = CalculatorApp.calculator(request.params(":data"));
            //System.out.println(calculatorResult);
            response.status(200);
            Double hola= 27.0;
            String result ="{\"lista\":"+hola+"}";
            //String result ="{\"lista\":"+hola+"}";
            return gson.toJson(result);
		});
		
	}
		

	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
			}
			return 4567; 
			 //returns default port if heroku-port isn't set (i.e. on localhost)
	}

}
