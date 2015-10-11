public abstract class Calculator {

	
	public static long GetKElementOnLR ( long[] numbers, int k, int l, int r) 
			throws ArrayIndexOutOfBoundsException
	{

		if (numbers.length <= r | l>r | l<0)
		{throw new ArrayIndexOutOfBoundsException
			("Массив integers " + 
					" не включает в себя отрезок поиска [" + l + "," + r + "]");}
		if (numbers.length <= k | k<0)
		{throw new ArrayIndexOutOfBoundsException
			("Массив integers не содержит элементов с индексом k = " + k + ".");}
		
		long x = numbers[k]; // x - search start
		int i = l;
		int j = r;
		
		while (i<=j )
		{
			while (i< numbers.length && numbers[i]< x){i++;}
			while (j>=0 && numbers[j]> x){j--;}

			if (i<j)
			{
				long swap = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = swap;
				i++; 
				j--;

			}
			else if (i==j){i++; j--;}
		}

		if(l<=k && k<=j){return GetKElementOnLR(numbers, k, l, j);}
		else if( i<=k && k<=r){return GetKElementOnLR(numbers, k, i, r);}
	    
		return numbers[k];
	}

}
