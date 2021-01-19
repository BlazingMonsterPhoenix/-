package Test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import view.surface.Surface;

public class Test {

	public static void main(String[] args) {
		//setAlpha("pictures/background.png","pictures/background1.png", 6);
		new Surface();
	}

	/** 
	* 改变png图片的透明度 
	* @param srcImageFile 源图像地址 
	* @param descImageDir 输出图片的路径和名称 
	* @param alpha 输出图片的透明度1-10 
	*/  
	private static void setAlpha(String srcImageFile, String descImageDir,int alpha) {  
	  
	    try {  
	    //读取图片  
	    FileInputStream stream = new FileInputStream(new File(srcImageFile));// 指定要读取的图片  
	  
	    // 定义一个字节数组输出流，用于转换数组  
	    ByteArrayOutputStream os = new ByteArrayOutputStream();  
	  
	    byte[] data =new byte[1024];// 定义一个1K大小的数组  
	    while (stream.read(data) != -1) {  
	    os.write(data);  
	    }  
	  
	        ImageIcon imageIcon = new ImageIcon(os.toByteArray());  
	        BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(),  
	        BufferedImage.TYPE_4BYTE_ABGR);  
	        Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();  
	        g2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getImageObserver());  
	  
	        //判读透明度是否越界  
	        if (alpha < 0) {  
	        alpha = 0;  
	        } else if (alpha > 10) {  
	        alpha = 10;  
	        }  
	  
	        // 循环每一个像素点，改变像素点的Alpha值  
	        for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage.getHeight(); j1++) {  
	        for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage.getWidth(); j2++) {  
	        int rgb = bufferedImage.getRGB(j2, j1);  
	        rgb = ((alpha * 255 / 10) << 24) | (rgb & 0x00ffffff);  
	        bufferedImage.setRGB(j2, j1, rgb);  
	        }  
	        }  
	        g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());  
	  
	        // 生成图片为PNG  
	  
	        ImageIO.write(bufferedImage, "png", new File(descImageDir));  
	  
	    } catch (Exception e) {  
	    e.printStackTrace();  
	    }  
	  
	}  
}

/*int[][] rate = new int[12][5];
float times = 150000.0f;
DecimalFormat df = new DecimalFormat("######0.00");  
for (int x = 0; x < times; x ++)
{
	String[] cards = DistributerFactory.distribute("丘比特");
	for (int i = 0; i < 12; i ++)
	{
		if (cards[i].equals("平民")){
			rate[i][0] ++;
		}
		else if (cards[i].equals("狼人") || cards[i].equals("黑狼王")){
			rate[i][1] ++;
		}
		else if (cards[i].equals("丘比特")){
			rate[i][2] ++;
		}
		else if (cards[i].equals("盗贼")){
			rate[i][3] ++;
		}
		else{
			rate[i][4] ++;
		}
	}
}
for (int i = 0; i < 12; i ++)
{
	System.out.print((i + 1) + "号是平民的次数：" + rate[i][0] + "，概率为" + df.format((rate[i][0] / times) * 100) + "%         ");
	System.out.print((i + 1) + "号是狼人的次数：" + rate[i][1] + "，概率为" + df.format((rate[i][1] / times) * 100) + "%         ");
	System.out.print((i + 1) + "号是爱神的次数：" + rate[i][2] + "，概率为" + df.format((rate[i][2] / times) * 100) + "%         ");
	System.out.print((i + 1) + "号是盗贼的次数：" + rate[i][3] + "，概率为" + df.format((rate[i][3] / times) * 100) + "%         ");
	System.out.print((i + 1) + "号是神民的次数：" + rate[i][4] + "，概率为" + df.format((rate[i][4] / times) * 100) + "%         ");
	System.out.println();
}*/

/*int[][] rate = new int[12][4];
float times = 150000.0f;
DecimalFormat df = new DecimalFormat("######0.00");  
for (int x = 0; x < times; x ++)
{
	String[] cards = DistributerFactory.distribute("12人标准场");
	for (int i = 0; i < 12; i ++)
	{
		if (cards[i].equals("平民")){
			rate[i][0] ++;
		}
		else if (cards[i].equals("狼人")){
			rate[i][1] ++;
		}
		else{
			rate[i][2] ++;
		}
		if (cards[i].equals("女巫")){
			rate[i][3] ++;
		}
	}
}
for (int i = 0; i < 12; i ++)
{
	System.out.print((i + 1) + "号是平民的次数：" + rate[i][0] + "，概率为" + df.format((rate[i][0] / times) * 100) + "%         ");
	System.out.print((i + 1) + "号是狼人的次数：" + rate[i][1] + "，概率为" + df.format((rate[i][1] / times) * 100) + "%         ");
	System.out.print((i + 1) + "号是神民的次数：" + rate[i][2] + "，概率为" + df.format((rate[i][2] / times) * 100) + "%         ");
	System.out.print((i + 1) + "号是女巫的次数：" + rate[i][3] + "，概率为" + df.format((rate[i][3] / times) * 100) + "%         ");
	System.out.println();
}*/