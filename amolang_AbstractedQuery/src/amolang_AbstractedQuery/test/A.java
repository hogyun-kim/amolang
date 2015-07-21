package amolang_AbstractedQuery.test;

public abstract class A {
	
	private String str;
	
	public A() {
		str = getStr();
	}
	
	public abstract String getStr();
	
	public void print() {
		System.out.println(str);
	};
}


