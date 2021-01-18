package werewolf.util.classUtil;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import werewolf.cardDistributer.father.CardDistributer;

/**
 * 子类扫描器
 * 查找发牌器父类的所有子类
 * @author BlazingPhoenix
 *
 */
public class SubClassesScanner {

	//扫描的路径
	private static final String CLASSES_PATH =  System.getProperty("user.dir") + "\\src\\werewolf\\cardDistributer\\sons";
	private static List<String> fileList = new ArrayList<String>();
	private static List<String> sonsRoster = new ArrayList<String>();
	
	/**
	 * 获取发牌器子类列表
	 * @return
	 */
	public static List<String> getDistributersNameList()
	{
		File baseFile = new File(CLASSES_PATH);
		//读取文件
		if(baseFile.exists())
		{
			getSubFileNameList(baseFile,fileList);
		}
		for(String name:fileList){
			if(isChildClass(name, CardDistributer.class))
			{
				sonsRoster.add(name);
			}
		}
		return sonsRoster;
	}
	
	/**
	 *  递归查找指定目录下的类文件的全路径
	 * @param baseFile 查找文件的入口
	 * @param fileList 保存已经查找到的文件集合
	 */
	private static void getSubFileNameList(File baseFile, List<String> fileList){
		if(baseFile.isDirectory())
		{
			File[] files = baseFile.listFiles();
			for(File tmpFile : files){
				getSubFileNameList(tmpFile,fileList);
			}
		}
		String path = baseFile.getPath();
		if(path.endsWith(".java")){
			String name1 = path.substring(path.indexOf("src")+4, path.length());
			String name2 = name1.replaceAll("\\\\", ".");
			String name3 = name2.substring(0, name2.lastIndexOf(".java"));
			fileList.add(name3);
		}
	}
	

	/**
	 * 判断一个类是否继承某个接口
	 * @param className 
	 * @param parentClazz 
	 * @return
	 */
	public static boolean isChildClass(String className,Class parentClazz){
		if(className == null) 
			return false;
		Class clazz = null;
		try {
			clazz = Class.forName(className);
			if(Modifier.isInterface(clazz.getModifiers())){
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return parentClazz.isAssignableFrom(clazz);
	}
		
}
