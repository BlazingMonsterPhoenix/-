package view.customize;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.message.Message;
import werewolf.distributerFactory.DistributerFactory;

@SuppressWarnings("serial")
public class IdentityList extends JPanel {

	private JLabel[] players = new JLabel[13];
	private JTextField[] identities = new JTextField[14];
	
	public IdentityList()
	{
		this.setLayout(null);
		initList();
		initExtIdentities();
		//freshen("12人丘比特");
		this.setBounds(0, 0, Message.getJFrameWidth(), Message.getJFrameHeight());
        this.setOpaque(false);
	}
	
	/**
	 * 初始化身份列表
	 */
	private void initList()
	{
		for (int i = 0; i < 12; i ++)
		{
			players[i] = new JLabel();
			players[i].setText((i + 1) + "号身份：");
			players[i].setBounds((i / 6) * 160 + 10, (i % 6) * 30 + 180, 70, 20);
			players[i].setForeground(Color.WHITE);
			
			identities[i] = new JTextField();
			identities[i].setText("");
			identities[i].setBounds((i / 6) * 160 + 80, (i % 6) * 30 + 180, 70, 20);
			identities[i].setOpaque(false);
			identities[i].setEditable(false);
			identities[i].setForeground(Color.WHITE);
			
			this.add(identities[i]);
			this.add(players[i]);
		}
	}
	
	/**
	 * 初始化额外身份表
	 */
	private void initExtIdentities()
	{
		players[12] = new JLabel();
		players[12].setText("盗贼选择身份：");
		players[12].setBounds(10, 370, 100, 20);
		players[12].setForeground(Color.WHITE);
		
		identities[12] = new JTextField();
		identities[13] = new JTextField();
		for (int i = 12; i < 14; i ++){
			identities[i].setText("");
			identities[i].setBounds((i - 12) * 100 + 120, 370, 70, 20);
			identities[i].setOpaque(false);
			identities[i].setEditable(false);
			identities[i].setForeground(Color.WHITE);
		}
		
		this.add(players[12]);
		this.add(identities[12]);
		this.add(identities[13]);
	}
	
	
	/**
	 * 发牌并显示身份牌
	 * @param theme 板子名称
	 */
	public void distributeCards(String theme)
	{
		String[] cards = DistributerFactory.distribute(theme);
		for (int i = 0; i < cards.length; i ++) {
			identities[i].setText(cards[i]);
		}
	}
	
	/**
	 * 刷新
	 * @description 根据板子名称刷新板子描述，并隐藏多余的身份标签和文本框
	 * @param theme 板子名称
	 */
	public void freshen(String theme)
	{
		showDescription(theme);
		setVisiable(theme);
	}
	
	/**
	 * 显示板子身份配置信息
	 * @param theme 板子名称
	 */
	private void showDescription(String theme)
	{
		String description = DistributerFactory.getDescription(theme);
		description = "<html><body>板子配置：<br>" + description + "<body></html>"; 
		description = description.replaceAll("\n", "<br>");
		
		JLabel descriptionLabel = new JLabel(description);
		descriptionLabel.setBounds(20, 80, 260, 90);
		descriptionLabel.setForeground(Color.RED);
		this.add(descriptionLabel);
	}
	
	
	/**
	 * 显示身份标签和身份文本框
	 * @description 根据游戏板子需要的身份牌数量<br>
	 * 				将多余的身份标签和文本框隐藏，只显示需要显示的
	 * @param theme 板子名称
	 */
	private void setVisiable(String theme)
	{
		//获取身份牌数量
		int numOfCards = DistributerFactory.getNumOfCards(theme);
		//隐藏所有标签和文本框
		for (int i = numOfCards; i < 13; i ++) {
			players[i].setVisible(false);
			identities[i].setVisible(false);
		}
		identities[13].setVisible(false);
		
		//显示需要显示的标签和文本框
		for (int i = 0; i < numOfCards; i ++)
		{
			identities[i].setVisible(true);
			if (i > 12) {
				continue;
			}
			players[i].setVisible(true);
		}
	}
	
}
