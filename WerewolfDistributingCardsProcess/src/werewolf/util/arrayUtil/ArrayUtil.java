package werewolf.util.arrayUtil;

public class ArrayUtil {

	/**
	 * ����������飨ϴ�ƣ�
	 * @description ���������<br>
	 * 				�ȴ������������ȡһ��Ԫ����Ϊ�������һ��Ԫ�أ��ٴ�ʣ�µ��г�ȡһ����Ϊ�ڶ���Ԫ�أ��Դ�����<br>
	 * 				�Գ�����ȣ�n���˴�n���Ƶ��ƶ��г��ơ����������ȡ��ÿ�����õ���һһ���Ƶĸ�����ͬ
	 * @param array �ȴ������ҵ�����
	 * @return ���Һ������
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
	 * Ԫ�ؽ���
	 * @description ��һ�����������Ԫ�ؽ��н���
	 * @param array �����޸ĵ�����
	 * @param index1  ����һ�����뽻����Ԫ�ص��±�
	 * @param index2  ��һ�����뽻����Ԫ�ص��±�
	 */
	public static void exchange(Object[] array, int index1, int index2)
	{
		Object a = array[index1];
		array[index1] = array[index2];
		array[index2] = a;
	}
}
