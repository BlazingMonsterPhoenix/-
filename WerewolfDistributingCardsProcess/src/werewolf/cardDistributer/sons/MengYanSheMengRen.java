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

}
