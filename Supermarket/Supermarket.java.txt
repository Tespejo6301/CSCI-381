/*
 * Trisha Espejo
 * Supermarket project
 * DUE: 11/30/20
 * Professor Ted Brown
 */



import java.util.*;
	
public class Supermarket {
	private static double clock;
	private static int served_cust;
	private static double server_time;
	private static double inter_arrival;
	private static Customer c;
	public static void main(String[] args) {
		Simulate(10000);
		
	}
	//create a random end of service
	private static double end(double clock) {
		Random r = new Random();
		double e = 0;
		double end = 0;
		double log = 0;
		double mean = 0;
		
		mean = (16.0 + 8.0) / 2.0;
		log	= Math.log((1- r.nextDouble()));
		e = mean * (-1 * log);
		//e = (r.nextDouble() * 8) + 8;
		end = e + clock;
		return end;
	}
	// create a random arrival time
	private static double arrive(double time) {
		Random r = new Random();
		double a = 0;
		double arrive = 0;
		double log = 0;
		double mean = 0;
		
		mean = (1.0 + 6.0)/ 2;
		log	= Math.log((1 - r.nextDouble()));
		a = mean * (-1 * log);
		//a = (r.nextDouble() * 5) + 1;
		arrive = a + time;
		return arrive;
		
	}
	//when the customer done in counter the register and end of service is = 0
	//count the number customer completed when register is equal to zero
	private static int customer_fin(LinkedList<Integer> reg, LinkedList<Customer> end_of_service) {
		 int n = served_cust;
		// System.out.println(n);
		for(int i = 0; i < 6; i++)
		{
			if (end_of_service.get(i) != null) {
			// resets the counter
				if (end_of_service.get(i).getEnd() == clock && reg.get(i) == 1) {
					end_of_service.set(i, null);
					reg.set(i, 0);
					n = n + 1;	
				}
			}
		}
		return n;
	}
	//add up the server time
	private static void service_time(double end_serv) {
		double x = 0;
		x = end_serv - clock;
		server_time = x + server_time;
	}
	//add up the interarrival time
	private static void inter_arrive_time(double next_arrive) {
		double x = 0;
		x = next_arrive - clock;
		inter_arrival = x + inter_arrival;
		
	}
	//prints the first events
	private static void print(LinkedList<Customer> delayed_list, LinkedList<Customer> future_event, LinkedList<Integer> register,
			LinkedList<Customer> end_of_service) {
		int busyRegister = 0;
		int freeRegister = 0;
		for(int i = 0; i < 6; i++)
		{
			if (register.get(i) == 1)
				busyRegister++;
		}
		freeRegister = 6 - busyRegister;
		System.out.println("clock: " + clock );
		System.out.println("length of the line : " + delayed_list.size());
		System.out.println("num of customer finish: "  + served_cust);
		System.out.println("future event: " + future_event);
		System.out.println("num of busy register(s): "  + busyRegister);
		System.out.println("num of available register(s): "  + freeRegister);
		System.out.println("register: " + register);
		System.out.println("delayed_list: " + delayed_list);
		System.out.println("end_of_service: " + end_of_service);
		System.out.println();
		
	}
	//add customer to available register 
	private static void addtoRegister(LinkedList<Integer> register, int regnum, LinkedList<Customer> delay_list,
			LinkedList<Customer> future_event, LinkedList<Customer> end_of_service) {
		double end_serv = 0;
		
		register.set(regnum, 1);
	    c = delay_list.remove();
	  
		end_serv = end(clock);
		end_of_service.set(regnum, c);
		c.setEnd(end_serv);
		future_event.add(c);	
		sort(future_event);
		service_time(end_serv);
		
		
	}
	//sort the linkedlist 
	public static void sort (LinkedList<Customer> x)
	{
		int size = x.size() - 1;
		
		Customer current = null;
		Customer input  = null;
		for (int i = 0; i <= size; i++)
        {
			current = x.get(i);
		    input  = x.get(size);
			if (input.getEnd()!=0)
			{
				
				if (x.get(i).getEnd() != 0 &&input.getEnd() < current.getEnd())
				{
					x.set(i, input);
					x.set(size , current);	
				}
				
				else if (input.getEnd() < current.getArrival())
				{
					x.set(i, input);
					x.set(size , current);	
				}	
			}
			else if (current.getEnd() != 0 && input.getArrival() < current.getEnd())
			{
				x.set(i, input);
				x.set(size , current);	
			}
			else if (input.getArrival() < current.getArrival())
			{
				x.set(i, input);
				x.set(size , current);	
			}
        }	
	}
	//prints the  average interarrival time, and average server time
		private static void printAverage() {
			System.out.println("------------------------------------------------------------");
			System.out.println("                        AVERAGE                                ");
			System.out.println("------------------------------------------------------------");
			System.out.println("average interarrival time: " + inter_arrival/10000);
			System.out.println("average server time: " + server_time/10000);
			System.out.println("------------------------------------------------------------");
			
			System.out.println("By Trisha Espejo");
		}
	private static void Simulate(int x) {
		LinkedList<Customer> delay_list = new LinkedList<Customer>();
		LinkedList<Integer> register = new LinkedList<Integer>();
		// keeps track of end of service for each register
		LinkedList<Customer> end_of_service = new LinkedList<Customer>();
		LinkedList<Customer> future_event = new LinkedList<Customer>();
		c = new Customer ( 0, 0, 0);
		int eventnum=0;
		
		//temporary variable use to keep track of customer
		double next_arrive = 0;
		int  count = 0;
		
		clock = 0;
		served_cust = 0;
		// create 6 register with the value of zero
		// all 6 register has end of service = 0
		for(int i = 0; i < 6; i++) {
			register.add(0);
			end_of_service.add(null);
			
		}
		 // create the first customer and their arrival time 
		 next_arrive = arrive(0);
		 c =  new Customer ( 1, next_arrive, 0);
		 future_event.add(c);
		 count++;
		 System.out.println("Event " + eventnum);
		 inter_arrive_time(next_arrive);
		 print(delay_list, future_event, register, end_of_service);
		 while(true) {
				eventnum++;
				//remove from future event list	
				c = future_event.remove();
				if (c.getEnd() != 0)
					clock = c.getEnd();
				else
					clock = c.getArrival();
				//makes sure to always create new arrival time every 1 to 6 minutes of each arrival
				// and max the total number of customer to 10,000
				if (clock == next_arrive && count <= x) {
					count++;
					delay_list.add(c);
					next_arrive = arrive(clock);
					c = new Customer(count, next_arrive, 0);
					future_event.add(c);
					sort(future_event);
					inter_arrive_time(next_arrive);
					
				}
				served_cust = customer_fin(register, end_of_service);
				// removes the customer from the line then add them to register
				if (delay_list.size() > 0)
				{
					
					if (register.get(0) == 0)
						addtoRegister(register, 0, delay_list, future_event, end_of_service);
					else if(register.get(1) == 0)
						addtoRegister(register, 1, delay_list, future_event, end_of_service);
					else if(register.get(2) == 0)
						addtoRegister(register, 2, delay_list, future_event, end_of_service);
					else if(register.get(3) == 0)
						addtoRegister(register, 3, delay_list, future_event, end_of_service);
					else if(register.get(4) == 0)
						addtoRegister(register, 4, delay_list, future_event, end_of_service);
					else if(register.get(5) == 0)
						addtoRegister(register, 5, delay_list, future_event, end_of_service);
				}
				if(eventnum <= 30)
				{
					System.out.println("------------------------------------------------------------");
					System.out.println("Event " + eventnum);
					print(delay_list, future_event, register, end_of_service);
				}
				if (served_cust == x) break;
		 }
		 printAverage();
		
	}
	
		 

}