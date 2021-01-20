package view.customize;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.message.Message;

@SuppressWarnings("serial")
public class DistributingButton extends JPanel {

	private JLabel distributingButton = new JLabel();
	
	public DistributingButton()
	{
		this.setLayout(null);
		this.setBounds(0, 0, Message.getJFrameWidth(), Message.getJFrameHeight());
        this.setOpaque(false);
        initButton();
	}
	
	/**
	 * 初始化发牌按钮
	 */
	private void initButton()
	{
		distributingButton.setText("开始发牌");
		distributingButton.setFont(new java.awt.Font("Dialog", 1, 30));
		distributingButton.setBounds(100, 400, 140, 35);
		distributingButton.setForeground(Color.WHITE);
		this.add(distributingButton);
	}
	
	/**
	 * 发牌按钮添加点击事件
	 * @param l 鼠标监听器
	 */
	public void addClickListener(MouseListener l)
	{
		MouseListener listener = new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent arg0) {
				l.mouseClicked(arg0);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				distributingButton.setBackground(Color.RED);
				System.out.println("1");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				distributingButton.setBackground(Color.WHITE);
				System.out.println("2");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("3");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.out.println("4");
			}
		};
		distributingButton.addMouseListener(listener);
	}
	
}
