package werewolf.distributerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import werewolf.cardDistributer.father.CardDistributer;
import werewolf.util.classUtil.SubClassesScanner;

/**
 * ����������
 * @author zhouzhengyu
 *
 */
public class DistributerFactory {

	private static Map<String,CardDistributer> distributerMap = new HashMap<String,CardDistributer>();
	
	/**
	 * �ַ�����
	 * @param theme ��������
	 * @return ���Һ���ƶѣ�������δ��ƶ����Ϸ�ȡ�ƣ�
	 */
	public static String[] distribute(String theme)
	{
		registerAllDistributers();
		return distributerMap.get(theme).distribute();
	}
	
	
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
	 * ע�ᷢ����
	 * @param theme ��Ϸ���⣨���ӣ�
	 * @param distributer ������
	 */
	public static void register(String theme, CardDistributer distributer)
	{
		if (theme == null || theme.length() == 0 || distributer == null)
		{
			throw new IllegalArgumentException("�������ƻ�����δ��ʼ����������ע��ʧ��");
		}
		distributerMap.putIfAbsent(theme, distributer);
	}
}
