package werewolf.cardDistributer.father;

import werewolf.util.arrayUtil.ArrayUtil;

/**
 * 发牌器父类
 * @author BlazingPhoenix
 *
 */
public interface CardDistributer {

	/**
	 * 洗牌并分发身份卡牌
	 * @return 打乱后的牌堆
	 */
	public default String[] distribute()
	{
		String[] cards = initCards();
		cards = (String[]) ArrayUtil.shuffle(cards);
		return cards;
	}
	
	/**
	 * 初始化牌堆
	 * @return 初始化后的“牌堆”（身份牌数组）
	 */
	String[] initCards();
	
	/**
	 * 获取板子名称
	 * @description 获取板子的名称，在发牌器工厂注册发牌器时需要使用
	 * @return 获取板子的名称
	 */
	public String getTheme();
	
}
