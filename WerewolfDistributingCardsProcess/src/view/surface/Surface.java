package view.surface;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.customize.ChooseBox;
import view.customize.DistributingButton;
import view.customize.IdentityList;
import view.message.Message;

@SuppressWarnings("serial")
public class Surface extends JFrame {

	public Surface()
	{
		init();
		initBackground(Message.getBackgroundPath());
		initChooseBox();
		initIdentityList();
		initButton();
		this.setVisible(true);
	}
	
	/**
	 * 初始化
	 * @description 设置位置、大小等基础信息
	 */
	private void init()
	{
		//获取屏幕宽高
		double width = Toolkit.getDefaultToolkit().getScreenSize().width;
		double height = Toolkit.getDefaultToolkit().getScreenSize().height;
		//标题
		this.setTitle("狼人杀发牌助手");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//关闭设置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//位置（居中）
		this.setLocation((int) (width - Message.getJFrameWidth()) / 2, (int) (height - Message.getJFrameHeight()) / 2);
		//长宽
		this.setSize(Message.getJFrameWidth(), Message.getJFrameHeight());
		//禁止缩放
		this.setResizable(false);
	}
	
	/**
	 * 初始化背景图片
	 * @param address 背景图片地址
	 */
	private void initBackground(String address)
	{
		ImageIcon background = new ImageIcon(address); 
		//缩放图片大小
		int width = Message.getJFrameWidth();
        int height = Message.getJFrameHeight();
        //第三个值是图片转化的方式
        Image img = background.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        background = new ImageIcon(img);
        
		JLabel backgroundLabel = new JLabel(background);    
        backgroundLabel.setBounds(0, 0, Message.getJFrameWidth(), Message.getJFrameHeight()); 
        JPanel backgroundPanel = (JPanel) this.getContentPane();  
        backgroundPanel.setOpaque(false);
        this.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));  
	}
	
	/**
	 * 初始化身份列表
	 */
	private void initIdentityList()
	{
		IdentityList list = new IdentityList();
		list.setBounds(0, 0, Message.getJFrameWidth(), Message.getJFrameHeight());
		this.add(list);
	}
	
	/**
	 * 初始化板子选择器
	 */
	private void initChooseBox()
	{
		ChooseBox box = new ChooseBox();
		box.setBounds(0, 0, Message.getJFrameWidth(), Message.getJFrameHeight());
		this.add(box);
	}
	
	/**
	 * 初始化发牌按钮
	 */
	private void initButton()
	{
		DistributingButton button = new DistributingButton();
		button.setBounds(0, 0, Message.getJFrameWidth(), Message.getJFrameHeight());
		button.addClickListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("点击");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				System.out.println("1");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});
		this.add(button);
	}
	
	
}
