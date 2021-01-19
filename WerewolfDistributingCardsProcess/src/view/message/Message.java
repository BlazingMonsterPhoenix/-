package view.message;

public class Message {

	private static final int JFRAME_WIDTH = 340;
	private static final int JFRAME_HEIGHT = 480;
	private static final String BACK_PATH = "pictures/background1.png";
	
	/**
	 * 获取页面宽度
	 * @return 页面宽度
	 */
	public static int getJFrameWidth()
	{
		return JFRAME_WIDTH;
	}
	
	/**
	 * 获取页面高度
	 * @return 页面高度
	 */
	public static int getJFrameHeight()
	{
		return JFRAME_HEIGHT;
	}
	
	/**
	 * 获取背景图片地址
	 * @return 背景图片地址
	 */
	public static String getBackgroundPath()
	{
		return BACK_PATH;
	}
}
