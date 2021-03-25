/*
 * Trisha Espejo
 * Supermarket project
 * DUE: 11/30/20
 * Professor Ted Brown
 */

public class Customer  {
	private int cust;
	private double arrival;
	private double end;
	
	public Customer (int c,double a, double e)
	{
		cust = c;
		arrival = a;
		end = e;
		
	}
	public int getCust()
	{
		return cust;
	}
	public double getArrival()
	{
		return arrival;
	}
	public double getEnd()
	{
		return end;	
	}
	public void setCust(int c)
	{
		this.cust = c;
	}
	public void setArrival(double a)
	{
		this.arrival = a;
	}
	public void setEnd(double e)
	{
		this.end = e;
	}	
	public String toString ()
	{
		String x = null;
		if (end == 0 ) x = "[Customer "+ cust +  ", a(" + arrival + ")] ";
		else x = "[Customer "+ cust +", " +"e(" + end + ")] ";
		return x;
	}
	
}
