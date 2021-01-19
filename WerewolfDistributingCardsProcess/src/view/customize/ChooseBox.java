package view.customize;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.message.Message;
import werewolf.distributerFactory.DistributerFactory;

@SuppressWarnings("serial")
public class ChooseBox extends JPanel {

	JComboBox<String> playerNumBox;
	JComboBox<String> themeChooseBox;
	
	public ChooseBox()
	{
		this.setLayout(null);
		initTitle();
		initNumChooseBox();
		initThemeChooseBox();
		//System.out.println(getTheme());
		this.setBounds(0, 0, Message.getJFrameWidth(), Message.getJFrameHeight());
        this.setOpaque(false);
	}
	
	private void initTitle()
	{
		JLabel title = new JLabel();
		title.setText("狼人杀发牌助手");
		title.setFont(new java.awt.Font("Dialog", 1, 30));
		title.setBounds(50, 10, 240, 35);
		title.setForeground(Color.RED);
		this.add(title);
	}
	
	/**
	 * 初始化人数选择框
	 */
	private void initNumChooseBox()
	{
		JLabel tips = new JLabel();
		tips.setText("选择人数：");
		tips.setBounds(10, 60, 80, 20);
		tips.setForeground(Color.WHITE);
		
		playerNumBox = new JComboBox<String>();
		Map<String,Integer> numList = DistributerFactory.getNumOfPlayersList();
		for (String num : numList.keySet())
		{
			playerNumBox.addItem(num);
		}
		playerNumBox.setBounds(90, 60, 55, 20);
		playerNumBox.setOpaque(false);
		
		this.add(tips);
		this.add(playerNumBox);
	}
	
	/**
	 * 
	 */
	private void initThemeChooseBox()
	{
		JLabel tips = new JLabel();
		tips.setText("选择板子：");
		tips.setBounds(150, 60, 80, 20);
		tips.setForeground(Color.BLACK);
		
		themeChooseBox = new JComboBox<String>();
		List<String> themeList = DistributerFactory.getThemeNamesOfNPlayers("12人");
		for (String theme : themeList)
		{
			themeChooseBox.addItem(theme);
		}
		themeChooseBox.setBounds(220, 60, 85, 20);
		themeChooseBox.setOpaque(false);
		
		this.add(tips);
		this.add(themeChooseBox);
	}
	
	public String getTheme()
	{
		return playerNumBox.getSelectedItem().toString() + themeChooseBox.getSelectedItem().toString();
	}
}
