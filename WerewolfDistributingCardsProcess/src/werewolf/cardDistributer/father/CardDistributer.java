package werewolf.cardDistributer.father;

import werewolf.util.arrayUtil.ArrayUtil;

/**
 * 发牌器父类
 * @author BlazingPhoenix
 *
 */
public interface CardDistributer {

	/**
	 * 洗牌并分发身份牌
	 * @return 打乱后的身份牌牌堆（玩家依次从牌堆顶拿取身份牌）
	 */
	public default String[] distribute()
	{
		String[] cards = initCards();
		cards = shuffleCards(cards);
		return cards;
	}
	
	default String[] shuffleCards(String[] cards)
	{
		//洗牌10次
		for (int i = 0; i < 10; i ++){
			cards = (String[]) ArrayUtil.shuffle(cards);
		}
		return cards;
	}
	
	/**
	 * 初始化牌堆
	 * @description 不同板子人数、身份牌类型不同，每个板子对应一个发牌器子类<br>
	 * 				发牌器子类根据自身对应的板子实现此方法
	 * @return 初始化后的牌堆
	 */
	String[] initCards();
	
	/**
	 * 获取游戏主题（板子）名称
	 * @description 获取板子名称，在发牌器工厂中注册发牌器时需要用到此方法<br>
	 * 				在发牌器工厂中，板子名称与发牌器一一对应<br>
	 * 				发牌时根据板子名称获取对应的发牌器进行发牌
	 * @return 板子名称
	 */
	public String getTheme();
	
	/**
	 * 获取身份牌数量
	 * @return 身份牌数量
	 */
	public int getNumOfCards();
	
	/**
	 * 获取板子身份描述
	 * @return 身份牌描述
	 */
	public String getDescription();
}
