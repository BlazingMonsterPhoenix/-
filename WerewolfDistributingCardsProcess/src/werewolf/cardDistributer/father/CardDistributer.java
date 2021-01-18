package werewolf.cardDistributer.father;

import werewolf.util.arrayUtil.ArrayUtil;

/**
 * ����������
 * @author BlazingPhoenix
 *
 */
public interface CardDistributer {

	/**
	 * ϴ�Ʋ��ַ���ݿ���
	 * @return ���Һ���ƶ�
	 */
	public default String[] distribute()
	{
		String[] cards = initCards();
		cards = (String[]) ArrayUtil.shuffle(cards);
		return cards;
	}
	
	/**
	 * ��ʼ���ƶ�
	 * @return ��ʼ����ġ��ƶѡ�����������飩
	 */
	String[] initCards();
	
	/**
	 * ��ȡ��������
	 * @description ��ȡ���ӵ����ƣ��ڷ���������ע�ᷢ����ʱ��Ҫʹ��
	 * @return ��ȡ���ӵ�����
	 */
	public String getTheme();
	
}
