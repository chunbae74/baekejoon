/*
 * 출처: https://hyoje420.tistory.com/14
 */
class overloadingMethods {
	public void print() {
		System.out.println("오버로딩1");
	}
	
	String print(Integer a) {
		System.out.println("오버로딩2");
		return a.toString();
	}
	
	void print(Integer a) {
		System.out.println("오버로딩3");
	}
	
	String print(Integer a, Integer b) {
		System.out.println("오버로딩4");
		return a.toString() + b.toString();
	}
}

public class _1 {

   public static void main(String[] args) {
      overloadingMethods om = new overloadingMethods();
      
      // 메소드1
      om.print();
      
      // 메소드2
      System.out.println(om.print(3));
      
      // 메소드3
      om.print("Hello World!");
      
      // 메소드4
      System.out.println(om.print(4, 5));
   }
  
   
}