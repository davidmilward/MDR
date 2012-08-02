package uk.org.datalink.MDR.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
 
import uk.org.datalink.MDR.domain.Country;

public class CountryDDValidator implements Validator {
    
	
	public boolean supports(Class clazz) {
	   //just validate the Customer instances
	   return Country.class.isAssignableFrom(clazz);
	}
 
	
	public void validate(Object target, Errors errors) {
 
		Country country = (Country)target;
 
	   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "abbr2", "required.abbr2");
 
	   if("NONE".equals(country.getAbbr2())){
		errors.rejectValue("country", "required.country");
	   }
	}
	
	
}
