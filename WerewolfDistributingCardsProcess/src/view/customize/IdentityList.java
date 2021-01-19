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
		showDescription("丘比特");
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
			players[i].setBounds((i / 6) * 160 + 10, (i % 6) * 30 + 170, 70, 20);
			players[i].setForeground(Color.WHITE);
			
			identities[i] = new JTextField();
			identities[i].setText("");
			identities[i].setBounds((i / 6) * 160 + 80, (i % 6) * 30 + 170, 70, 20);
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
		players[12].setBounds(10, 360, 100, 20);
		players[12].setForeground(Color.WHITE);
		
		identities[12] = new JTextField();
		identities[13] = new JTextField();
		for (int i = 12; i < 14; i ++){
			identities[i].setText("");
			identities[i].setBounds((i - 12) * 100 + 120, 360, 70, 20);
			identities[i].setOpaque(false);
			identities[i].setEditable(false);
			identities[i].setForeground(Color.WHITE);
		}
		
		this.add(players[12]);
		this.add(identities[12]);
		this.add(identities[13]);
	}
	
	/**
	 * 显示板子身份配置信息
	 * @param theme 板子名称
	 */
	public void showDescription(String theme)
	{
		String description = DistributerFactory.getDescription(theme);
		description = "<html><body>" + description + "<body></html>"; 
		description = description.replaceAll("\n", "<br>");
		
		JLabel descriptionLabel = new JLabel(description);
		descriptionLabel.setBounds(20, 80, 260, 90);
		descriptionLabel.setForeground(Color.RED);
		this.add(descriptionLabel);
	}
}
