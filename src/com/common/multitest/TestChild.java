package com.design;

class TestParent {

	static String toStingTest(TestChild tc) {
		String str = tc.field;
		return str.toUpperCase();
	}

}

class TestChild extends TestParent {
	String field = "testing...";
	public static void main(String[] args) {
		//String field1 = "test";
		//TestChild tc = new TestChild();
		String stingTest = toStingTest(new TestChild());
		System.out.println("HKHR : " + stingTest );
	}
}
