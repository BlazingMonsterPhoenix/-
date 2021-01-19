package werewolf.cardDistributer.sons;

import werewolf.cardDistributer.father.CardDistributer;
import werewolf.util.arrayUtil.ArrayUtil;

public class QiuBiTe implements CardDistributer {

	@Override
	public String[] initCards() {
		String[] cards = new String[14];
		cards[0] = "黑狼王";
		cards[1] = "狼人";
		cards[2] = "狼人";
		cards[3] = "平民";
		cards[4] = "平民";
		cards[5] = "平民";
		cards[6] = "平民";
		cards[7] = "平民";
		cards[8] = "预言家";
		cards[9] = "女巫";
		cards[10] = "猎人";
		cards[11] = "白痴";
		cards[12] = "丘比特";
		cards[13] = "盗贼";
		return cards;
	}
	
	/**
	 * 覆写洗牌方法
	 * @description 最后两张牌不能同时为狼人，也不能出现盗贼+狼牌的情况<br>
	 * 				即：场上必须存在三狼
	 */
	@Override
	public String[] shuffleCards(String[] cards)
	{
		//将最后一张牌与一张非狼人牌交换（保证最后两张牌不会是双狼）
		int x = (int)(Math.random() * 11) + 3;
		ArrayUtil.exchange(cards, x, 13);
		//洗牌10次
		for (int i = 0; i < 10; i ++){
			cards = (String[]) ArrayUtil.shuffle(cards,0,13);
		}
		//如果最后两张是盗贼+狼人组合，再次洗牌
		for (;(cards[12] + cards[13]).contains("狼") && (cards[12] + cards[13]).contains("盗贼");){
			cards = (String[]) ArrayUtil.shuffle(cards,0,13);
		}
		return cards;
	}

	@Override
	public int getNumOfCards() {
		return 14;
	}

	@Override
	public String getDescription() {
		StringBuffer description = new StringBuffer("平民数量：平民*5\n");
		description.append("神民组合：预言家、女巫、猎人、白痴\n");
		description.append("狼人阵营：狼人*2、黑狼王\n");
		description.append("第三方和可变阵营：丘比特、盗贼");
		return description.toString();
	}

	@Override
	public int getNumOfPlayers() {
		return 12;
	}

	@Override
	public String getThemeName() {
		return "丘比特";
	}

}
