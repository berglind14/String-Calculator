package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
	   		return 0;
		}
		else if(text.contains("\n"))
	  	{
	  		text = text.replace("\n", ",");
	  		return sum(splitNumbers(text));
	  	}
	  	else if(text.contains(",")){
	    	return sum(splitNumbers(text));
	  	}
	  	else
	    	return 1;
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split(",");
	}

	private static int sum(String[] numbers){
		int total = 0;
		String negatives = "";
	    for(String number : numbers){
	    	if(toInt(number) < 0)
	    	{
	    		negatives = negatives + number;
	    	}
	    	else
	    	{
	    		if(toInt(number) > 999)
	    		{
	    			number = "0";
	    		}
	    		total += toInt(number);
	    	}
	  	}
	  	if(negatives == "")
	  		return total;
	  	else
	  		throw new IllegalArgumentException("Negatives not allowed: " + negatives);
	}
	private static int toInt(String number){
  		return Integer.parseInt(number);
	}
}