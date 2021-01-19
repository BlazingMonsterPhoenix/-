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

	@Override
	public int getNumOfCards() {
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public String getDescription() {
		StringBuffer description = new StringBuffer("平民数量：平民*4\n");
		description.append("神民组合：预言家、女巫、定序王子、守卫\n");
		description.append("狼人阵营：狼人*3、蚀时狼妃");
		return description.toString();
	}

}
