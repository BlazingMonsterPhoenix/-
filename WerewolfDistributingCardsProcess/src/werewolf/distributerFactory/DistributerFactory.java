package werewolf.distributerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import werewolf.cardDistributer.father.CardDistributer;
import werewolf.util.classUtil.SubClassesScanner;

/**
 * 发牌器工厂
 * @author BlazingPhoenix
 *
 */
public class DistributerFactory {

	private static Map<String,CardDistributer> distributerMap = new HashMap<String,CardDistributer>();
	
	/**
	 * 获取板子人数列表
	 * @description 获取所有的板子可能出现的人数有哪些，以及n人场对应的板子的数量
	 * @return 
	 */
	public static Map<String,Integer> getNumOfPlayersList()
	{
		Map<String,Integer> map = new HashMap<String,Integer>();
		registerAllDistributers();
		for (CardDistributer distributer : distributerMap.values())
		{
			String num = distributer.getNumOfPlayers() + "人";
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}
			else {
				map.put(num, 0);
			}
		}
		return map;
	}
	
	/**
	 * 获取所有n人场的板子主题名称 
	 * @param numOfPlayer n
	 * @return 板子主题名称列表
	 */
	public static List<String> getThemeNamesOfNPlayers(String numOfPlayer)
	{
		List<String> themeList = new ArrayList<String>();
		registerAllDistributers();
		for (CardDistributer distributer : distributerMap.values())
		{
			if (numOfPlayer.equals(distributer.getNumOfPlayers() + "人"))
			{
				themeList.add(distributer.getThemeName());
			}
		}
		return themeList;
	}
	
	/**
	 * 根据板子名称获取对应的发牌器进行发牌
	 * @param theme 板子名称
	 * @return 打乱后的身份牌牌堆
	 */
	public static String[] distribute(String theme)
	{
		registerAllDistributers();
		return distributerMap.get(theme).distribute();
	}
	
	/**
	 * 获取板子的身份牌数量
	 * @param theme 板子名称
	 * @return 身份牌数量
	 */
	public static int getNumOfCards(String theme)
	{
		registerAllDistributers();
		return distributerMap.get(theme).getNumOfCards();
	}
	
	/**
	 * 获取板子的身份牌（配置）描述
	 * @param theme 板子名称
	 * @return 配置描述（即，有哪些身份牌）
	 */
	public static String getDescription(String theme)
	{
		registerAllDistributers();
		return distributerMap.get(theme).getDescription();
	}
	
	/**
	 * 将所有的发牌器注册进发牌器工厂
	 */
	private static void registerAllDistributers()
	{
		List<String> distributers = SubClassesScanner.getDistributersNameList();
		for (String name : distributers)
		{
			try {
				Class<?> distributerClass = Class.forName(name);
				CardDistributer distributer = (CardDistributer) distributerClass.newInstance();
				register(distributer.getTheme(), distributer);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 注册发牌器
	 * @param theme 板子名称
	 * @param distributer 板子名称对应的发牌器
	 */
	public static void register(String theme, CardDistributer distributer)
	{
		if (theme == null || theme.length() == 0 || distributer == null)
		{
			throw new IllegalArgumentException("板子名称或发牌器未初始化，所以发牌器注册失败");
		}
		distributerMap.putIfAbsent(theme, distributer);
	}
}
