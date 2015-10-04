import java.util.Scanner;

public class MedianCalculator {

	public static void main(String[] args) {
		String[] firstNarray, secondNarray;
		int N =0;
		
		Scanner in = new Scanner(System.in);		
		do
		{
			System.out.println("������� ������ ������ N ����������� �����, ����������� ����� �������� (����� �������):");
	        String firstN = in.nextLine();
	        System.out.println("������� ������ ������ N ����������� �����, ����������� ����� �������� (����� �������):");
	        String secondN = in.nextLine();
	        
			firstNarray = firstN.split("\\D+");
			secondNarray = secondN.split("\\D+");
			N = firstNarray.length;
			if (N != secondNarray.length)
			{System.out.println("��������� ������� ����� �� ���������� ������. ������� ������� ������.");}
		}while (firstNarray.length != secondNarray.length);	
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
		{System.out.println(ex.toString());}
		
		
	}

}
