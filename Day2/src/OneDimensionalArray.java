class OneDimensionalArray {
	public static void main(String[] args) {
		
		//int[] ia;					//just variable declaration
		//System.out.println(ia);

		//int[5] ia;				//CE: in Java it is not allowed
		//System.out.println(ia);
		
		//array var dec |  array object creation
		int[] ia        = new int[5];
		System.out.println(ia); //CN@hc -> [I@2f92e0f4
		System.out.println();

		//reading and prining array values
		System.out.println(ia[0]);  
		System.out.println(ia[1]);
		System.out.println(ia[2]);
		System.out.println(ia[3]);
		System.out.println(ia[4]);
		System.out.println();

		//array initialization
		ia[0] = 3;		
		ia[1] = 4;
		ia[2] = 5;
		ia[3] = 6;
		ia[4] = 7;
	
		//reading and printing array values
		System.out.println(ia[0]);  
		System.out.println(ia[1]);
		System.out.println(ia[2]);
		System.out.println(ia[3]);
		System.out.println(ia[4]);
		System.out.println();

		//printing array length
		System.out.println(ia.length);
		System.out.println();

		//accessing array values randamly
		System.out.println(ia[0]);
		System.out.println(ia[2]);
		System.out.println(ia[4]);
		System.out.println();

	//index [>=0 and <length], else we will get AIOOBE
		//System.out.println(ia[-1]);
		//System.out.println(ia[5]);

	}
}