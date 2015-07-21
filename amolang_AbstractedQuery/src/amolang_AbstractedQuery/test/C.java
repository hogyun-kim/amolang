package amolang_AbstractedQuery.test;

public class C {

	public A test;
	
	public C() {
		test = getTest();
	}
	
	public A getTest() {
		return new B();
	}
	
	public String get() {
		return test.getTest();
	}
	
	public void test() {
		test.test();
	}
}
