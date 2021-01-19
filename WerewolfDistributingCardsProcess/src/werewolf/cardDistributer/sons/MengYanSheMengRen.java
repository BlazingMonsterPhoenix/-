package werewolf.cardDistributer.sons;

import werewolf.cardDistributer.father.CardDistributer;

/**
 * 12人噩梦之影发牌器
 * @author BlazingPhoenix
 *
 */
public class MengYanSheMengRen implements CardDistributer {

	@Override
	public String[] initCards() {
		String[] cards = new String[12];
		cards[0] = "平民";
		cards[1] = "平民";
		cards[2] = "平民";
		cards[3] = "平民";
		cards[4] = "噩梦之影";
		cards[5] = "狼人";
		cards[6] = "狼人";
		cards[7] = "狼人";
		cards[8] = "预言家";
		cards[9] = "女巫";
		cards[10] = "猎人";
		cards[11] = "摄梦人";
		return cards;
	}

	@Override
	public String getTheme() {
		return "噩梦之影";
	}

	@Override
	public int getNumOfCards() {
		return 12;
	}

	@Override
	public String getDescription() {
		StringBuffer description = new StringBuffer("平民数量：平民*4\n");
		description.append("神民组合：预言家、女巫、猎人、摄梦人\n");
		description.append("狼人阵营：狼人*3、噩梦之影");
		return description.toString();
	}

}
