package werewolf.cardDistributer.sons;

import werewolf.cardDistributer.father.CardDistributer;

public class YongXuZhiLun implements CardDistributer {

	@Override
	public String[] initCards() {
		String[] cards = new String[12];
		cards[0] = "ƽ��";
		cards[1] = "ƽ��";
		cards[2] = "ƽ��";
		cards[3] = "ƽ��";
		cards[4] = "ʴ������";
		cards[5] = "����";
		cards[6] = "����";
		cards[7] = "����";
		cards[8] = "Ԥ�Լ�";
		cards[9] = "Ů��";
		cards[10] = "ʱ������";
		cards[11] = "����";
		return cards;
	}

	@Override
	public String getTheme() {
		return "����֮��";
	}

}
