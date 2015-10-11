import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedianCalculator {

	public static void main(String[] args) {
		String[] firstNarray = null, secondNarray=null;
		int N =0, N1 = 0;
		
		Scanner in = new Scanner(System.in);		
		do
		{
			System.out.println("������� ������ ������ N ����������� �����, ����������� ����� �������� (����� �������):");
	        String firstN = in.nextLine();
	        System.out.println("������� ������ ������ N ����������� �����, ����������� ����� �������� (����� �������):");
	        String secondN = in.nextLine();
	        
	        //������� ��������� � �������� ���������� �������
	        Pattern p = Pattern.compile("^\\D*((\\d+\\D+)*\\d+)\\D*$");  
	        Matcher firstm = p.matcher(firstN);
	        Matcher secondm = p.matcher(secondN);
	        
	        if (firstm.matches()){firstN = firstm.group(1);}
	        
	        if (secondm.matches()){secondN = secondm.group(1);}
	        
			firstNarray = firstN.split("\\D+");
			secondNarray = secondN.split("\\D+");
			N = firstNarray.length;
			N1 = secondNarray.length;
			
			if (N <=1 || N1<=1)
			{System.out.println("������� ������ �������� �� ��� ������� ���� �����. ������� ������� ������.");}
			if (N != N1)
			{System.out.println("��������� ������� ����� �� ���������� ������. ������� ������� ������.");}
 
	    }while (N<=1 || N != N1);	
		in.close();
		
		
		long[] numbers = new long[2*N];
		for (int i = 0; i<= N-1; i++)
		{numbers[i] = Long.parseLong(firstNarray[i]);}
		for (int i = 0; i<= N-1; i++)
		{numbers[N+i] = Long.parseLong(secondNarray[i]);}
		
		try{
			double firstend = Calculator.GetKElementOnLR(numbers, N-1, 0, 2*N-1);
			double secondstart = Calculator.GetKElementOnLR(numbers, N,  0, 2*N-1);
			double median = (firstend + secondstart)/2;
			System.out.println("������� ����� = " + median);
		}
		catch (Exception ex)
		{System.out.println(ex.getMessage());}
		
		
	}

}
