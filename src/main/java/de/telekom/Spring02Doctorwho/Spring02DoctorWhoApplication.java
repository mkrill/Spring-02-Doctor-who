package de.telekom.Spring02Doctorwho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class Spring02DoctorWhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring02DoctorWhoApplication.class, args);
	}

	@RequestMapping("/doctor/{incarnationNumber}")
	@ResponseBody
	public String hello(@PathVariable("incarnationNumber") int incNumber) {

		// For doctors 9 to 13 inclusive, return the details about the incarnation of
		// the corresponding Doctor (here is a list). These details should be returned
		// in JSON format, and include the doctor's number and name like this:
		// {"number": 13, "name": "Jodie Whittaker"}. For the other doctors (1 to 8)
		// return a 303 status. If the number is not valid, return a 404 status and
		// display this informative message: `Impossible to retrieve the incarnation
		// <incarnation number>" .

		String returnString="";
		if (incNumber >= 1 && incNumber <= 8) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "No information available about these doctors!");
		} else if (incNumber < 1 || incNumber > 13) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Impossible to retrieve the incarnation <incarnation number>");
		} else {
			switch (incNumber) {
			case 9:
				returnString = "{\"number\":" + incNumber + "\"name\": \"Christopher Eccleston\"}";
				break;
			case 10:
				returnString = "{\"number\":" + incNumber + "\"name\": \"David Tennant\"}";
				break;
			case 11:
				returnString = "{\"number\":" + incNumber + "\"name\": \"Matt Smith\"}";
				break;
			case 12:
				returnString = "{\"number\":" + incNumber + "\"name\": \"Peter Capaldi\"}";
				break;
			case 13:
				returnString = "{\"number\":" + incNumber + "\"name\": \"Jodie Whittaker\"}";
				break;
			}
		}
		return returnString;
	}
}
