package ApachePackage;

class A {
	A(){
		System.out.println("This is in Parent class");
	}
	void check(){
		System.out.println("This is A Check");
	}
}
class B extends A {
	B(){
		System.out.println("This is in Child Class");
	}
	@Override
	void check(){
		System.out.println("This is B Check");
	}
	void display() {
		check();
		super.check();
	}
	
}
public class ConsChain {

	public static void main(String[] args) {
		B At = new B();
		At.display();

	}

}
