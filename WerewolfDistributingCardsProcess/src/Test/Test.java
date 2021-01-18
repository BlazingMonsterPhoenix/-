package Test;

import werewolf.distributerFactory.DistributerFactory;

public class Test {

	public static void main(String[] args) {
		String[] cards = DistributerFactory.distribute("12人标准场");
		for (int i = 0; i < 12; i ++)
		{
			System.out.println((i + 1) + "号：" + cards[i]);
		}
	}

}
