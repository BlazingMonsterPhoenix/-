package Test;

import werewolf.distributerFactory.DistributerFactory;

public class Test {

	public static void main(String[] args) {
		String[] cards = DistributerFactory.distribute("ÓÀĞøÖ®ÂÖ");
		for (int i = 0; i < 12; i ++)
		{
			System.out.println((i + 1) + "ºÅ£º" + cards[i]);
		}
	}

}
