
public class tester {

	public static void main(String[] args) {
		double count = 0;
		int big = 1000;
		int best =1000;
		int yes = 0, no = 0;
		double num = 0;
		num = .5;
		int z = 0;
		int r=0, a=0;
		//System.out.println(num);
		
 		//for (int i = 0; i < 30; i++)
		//{
 			while( 0 != best && best != big + 100)
 			{
 			//System.out.println(best);
			count = Math.random();
			System.out.println(z + ": " +best);
			if (count > num) 
				{
				best--;
				r++;
				}
			else {
				best++; 
				a++;
			}
			
			//if (best == big + 100) yes++;
			//if(best == 0) no++;
			
			z++;
 			}
		//}	
		System.out.println("true " + yes);
		System.out.println("false " + no);
		System.out.println("yes " + a);
		System.out.println("no " + r);
		System.out.println("coco " + z);
	}


}
