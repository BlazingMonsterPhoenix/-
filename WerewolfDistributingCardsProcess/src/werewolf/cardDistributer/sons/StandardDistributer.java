package werewolf.cardDistributer.sons;

import werewolf.cardDistributer.father.CardDistributer;

/**
 * 12人标准场发牌器
 * @author BlazingPhoenix
 *
 */
public class StandardDistributer implements CardDistributer {

	@Override
	public String[] initCards() {
		String[] cards = new String[12];
		cards[0] = "平民";
		cards[1] = "平民";
		cards[2] = "平民";
		cards[3] = "平民";
		cards[4] = "狼人";
		cards[5] = "狼人";
		cards[6] = "狼人";
		cards[7] = "狼人";
		cards[8] = "预言家";
		cards[9] = "女巫";
		cards[10] = "猎人";
		cards[11] = "白痴";
		return cards;
	}

	@Override
	public int getNumOfCards() {
		return 12;
	}

	@Override
	public String getDescription() {
		StringBuffer description = new StringBuffer("平民数量：平民*4\n");
		description.append("神民组合：预言家、女巫、猎人、白痴\n");
		description.append("狼人阵营：狼人*4");
		return description.toString();
	}

	@Override
	public int getNumOfPlayers() {
		return 12;
	}

	@Override
	public String getThemeName() {
		return "标准场";
	}

}
