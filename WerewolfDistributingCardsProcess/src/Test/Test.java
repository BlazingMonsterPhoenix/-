package Test;

import java.text.DecimalFormat;

import werewolf.distributerFactory.DistributerFactory;

public class Test {

	public static void main(String[] args) {
		
	}

}

/*int[][] rate = new int[12][4];
float times = 150000.0f;
DecimalFormat df = new DecimalFormat("######0.00");  
for (int x = 0; x < times; x ++)
{
	String[] cards = DistributerFactory.distribute("12人标准场");
	for (int i = 0; i < 12; i ++)
	{
		if (cards[i].equals("平民")){
			rate[i][0] ++;
		}
		else if (cards[i].equals("狼人")){
			rate[i][1] ++;
		}
		else{
			rate[i][2] ++;
		}
		if (cards[i].equals("女巫")){
			rate[i][3] ++;
		}
	}
}
for (int i = 0; i < 12; i ++)
{
	System.out.print((i + 1) + "号是平民的次数：" + rate[i][0] + "，概率为" + df.format((rate[i][0] / times) * 100) + "%         ");
	System.out.print((i + 1) + "号是狼人的次数：" + rate[i][1] + "，概率为" + df.format((rate[i][1] / times) * 100) + "%         ");
	System.out.print((i + 1) + "号是神民的次数：" + rate[i][2] + "，概率为" + df.format((rate[i][2] / times) * 100) + "%         ");
	System.out.print((i + 1) + "号是女巫的次数：" + rate[i][3] + "，概率为" + df.format((rate[i][3] / times) * 100) + "%         ");
	System.out.println();
}*/