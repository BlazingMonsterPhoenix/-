package werewolf.cardDistributer.sons;

import werewolf.cardDistributer.father.CardDistributer;

/**
 * 12人永续之轮板子发牌器
 * @author BlazingPhoenix
 *
 */
public class YongXuZhiLun implements CardDistributer {

	@Override
	public String[] initCards() {
		String[] cards = new String[12];
		cards[0] = "平民";
		cards[1] = "平民";
		cards[2] = "平民";
		cards[3] = "平民";
		cards[4] = "蚀时狼妃";
		cards[5] = "狼人";
		cards[6] = "狼人";
		cards[7] = "狼人";
		cards[8] = "预言家";
		cards[9] = "女巫";
		cards[10] = "定序王子";
		cards[11] = "守卫";
		return cards;
	}

	@Override
	public String getTheme() {
		return "永续之轮";
	}

}
