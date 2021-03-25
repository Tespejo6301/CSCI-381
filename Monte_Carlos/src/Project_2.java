/*
 * Name:Trisha Espejo
 * CSCI 381
 * Monte Carlos Simulation: Random Walks
 * Due: 10/04/2020
 * Professor: Ted Brown
 */
public class Project_2 {
	public static void main(String[] args) {
		int x[] = {10, 100, 1000};
		double y[] = {0.4, 18.0/37.0,0.5};
		for (int i = 0; i < y.length; i++)
		{
			for(int j = 0; j < x.length; j++)
			{
				System.out.println("The starting bet " + x[j] + " with the probability: " + y[i] );
				game(x[j], y[i]);
				System.out.println();
			}
		}
	}

	private static void game(int x, double y) {
		int start_money = x;
		int cur_money = x;
		int win = 0 , lose = 0;
		double random = 0;
		double total_bet = 0;
		int bet = 0;
		for(int i = 0; i < 50; i++)
		{
			cur_money = start_money;
			while(true) {
				 bet++;	
				random = Math.random();	
				if (y < random) {		
					cur_money--;	
				}
				else {
					cur_money++;		
				}
				if ( cur_money == 0) {
					lose++;
					break;
					
				}
				if ( cur_money == start_money + 100) {
					win++;
					break;	
				}
				
			}
			total_bet = bet + total_bet;
			bet = 0;	
		}
		System.out.println("number of win: " + win);
		System.out.println("number of lose: " + lose);
		System.out.println("average bet: " + total_bet/ 50.0);
		
	}


}