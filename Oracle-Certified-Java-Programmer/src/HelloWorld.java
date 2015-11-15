public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println("Added a new Line");
		for(int i = 0;i < 1000;i++){
			System.out.println("Added a Line number " + i );
			for(int i1 = 0;i1 < 9;i1++){
				System.out.println("Added inner loop Line number " + i1 );
			}
		}
	}

}
