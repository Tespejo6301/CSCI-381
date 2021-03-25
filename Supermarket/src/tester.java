
import java.util.LinkedList;
import java.util.Random;

public class tester {


	public static void main(String[] args) {
		
		
		Random r = new Random();
		
		double mean = 0;
		double random = 0;
		double log = 0;
		double neg_log = 0;
		double arrive = 0;
		
		mean = (1.0 + 6.0)/ 2;
		//random = (r.nextDouble() * 5) + 1 ;
		//log	= Math.log((1-r.nextDouble()));
		//random = mean*(-1 * log);
		//arrive = mean * neg_log;
		//System.out.println(arrive);
		//random = -6 * Math.log(1-r.nextDouble());
		for (int i = 0; i < 10; i++)
		{
		log	= Math.log((1-r.nextDouble()));
		random = mean*(-1 * log);
		System.out.println(random);		
				//log * -1;
		}
		

    
      //  double mean = (1.0 + 6.0)/ 2;
       // double log_value = Math.log((1-rand.nextDouble()));
        //double negative_log_value = negative(log_value);

       // double arrival = mean * negative_log_value;
        
        //System.out.println(arrival);
		
	}
	public static double negative(double num){
        double ans = num;
        ans *= -1;
        return ans;
    }

}