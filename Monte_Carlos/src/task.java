
public class task {

	public static void main(String[] args) {
		int money;
		money = 100;
		int a = 0;
		for(int i = 0; i < 2000; i++)
			{
			    a = winprob(money, a);
			    //System.out.println(a);
			}
	}

	private static int winprob(int i, int a) {
		double bet = 0;
		int cur_money = i;
		int count = a;
		int win = 0 , lose = 0;
		double x = 0;
		
		
		while(true){
			x = Math.random();
			
			if (.4 < x){
				cur_money = cur_money - 1;
				lose++;
			}
			else{
				cur_money = cur_money + 1;
				win++;
						
			}
			//System.out.println(cur_money);
			
			if (cur_money < 1 ){
				cal_lose(lose);
				//count++;
				break;
				
			}
			if (cur_money == i + 100){
				cal_win(win);
				count++;
				break;
			}
		}
		
		//System.out.println(count);
		return count;
		
		
	}

	private static void cal_win(int win) {
		System.out.println("Winner " + "number of win " + win);
		
	}

	private static void cal_lose(int lose) {
		System.out.println("Lose " + "number of lose " + lose);
		
	}
}
