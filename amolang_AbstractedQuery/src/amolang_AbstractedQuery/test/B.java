package amolang_AbstractedQuery.test;

public class B implements A {

	String test;
	
	@Override
	public void test() {
		test = "hello world!!!";
	}

	@Override
	public String getTest() {
		return test;
	}

	
	
}