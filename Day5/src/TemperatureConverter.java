
public class TemperatureConverter {
	
	    /**
	     * Converts a given temperature from Celsius to Fahrenheit.
	     *
	     * @param celsiusTemperature The temperature in Celsius to be converted.
	     * @return The equivalent temperature in Fahrenheit.
	     */
	    public static double convertCelsiusToFahrenheit(double celsiusTemperature) {
	        return (celsiusTemperature * 9 / 5) + 32;
	    }

	    public static void main(String[] args) {
	        double inputCelsiusTemperature = 27.0;
	        System.out.println(inputCelsiusTemperature + "Celsius is equal to " 
	                + convertCelsiusToFahrenheit(inputCelsiusTemperature) + "Farenheit");
	    }
	}


