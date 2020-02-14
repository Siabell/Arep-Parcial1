package edu.escuelaing.arep;
import static spark.Spark.*;
import com.google.gson.Gson;

import edu.escuelaing.arep.calculator.Calculator;

public class SparkWebApp {
	
	
	public static void main(String[] args) {
		port(getPort());
		final Gson gson = new Gson();
		
		
		staticFiles.location("/webApp");
		
		 
		post("/calculator", (request, response) -> {
			System.out.println(request.body());   
			response.type("application/json");
            final String calculatorResult = Calculator.calculateMerge(request.body());
            System.out.println(calculatorResult); 
            response.status(200);
            return gson.toJson(calculatorResult);
		});
		
		get("/calculator/:data", (request, response) -> {
			
			response.type("application/json");
            final String calculatorResult = Calculator.calculateMerge(request.params(":data"));
            System.out.println(calculatorResult);
            response.status(200);
            return gson.toJson(calculatorResult);
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
