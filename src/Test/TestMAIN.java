package Test;

import tileengine.Tile;


public class TestMAIN {

	public static void main(String[] args){	
		System.out.println("start");
		test();
		System.out.println("end");
	}
	public static void test()
	{
		System.out.println("New tile keycode");
		Tile tuile = new Tile("1/0.5/0.5");
		System.out.println("New tile brute");
		Tile tuile2 = new Tile(1,0,0);
	}
}
