package werewolf.util.arrayUtil;

public class ArrayUtil {

	/**
	 * 随机打乱数组（洗牌）
	 * @description 将数组打乱<br>
	 * 				先从数组中随机抽取一个元素作为新数组第一个元素，再从剩下的中抽取一个作为第二个元素，以此类推<br>
	 * 				以抽排类比：n个人从n张牌的牌堆中抽牌。依次随机抽取，每个人拿到任一一张牌的概率相同
	 * @param array 等待被打乱的数组
	 * @return 打乱后的数组
	 */
	public static Object[] shuffle(Object[] array)
	{
		Object[] newArray = array.clone();
		for (int i = 0; i < newArray.length - 1; i ++)
		{
			int x = (int)(Math.random() * newArray.length - i) + i;
			exchange(newArray, i, x);
		}
		return newArray;
	}
	
	/**
	 * 元素交换
	 * @description 将一个数组的两个元素进行交换
	 * @param array 进行修改的数组
	 * @param index1  其中一个参与交换的元素的下标
	 * @param index2  另一个参与交换的元素的下标
	 */
	public static void exchange(Object[] array, int index1, int index2)
	{
		Object a = array[index1];
		array[index1] = array[index2];
		array[index2] = a;
	}
}
