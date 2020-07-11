package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import java.io.*;
import java.text.*;

import images.*;
import texts.*;


public class main extends JFrame {
	images images = new images();		//���α׷��� �ʿ��� image�� ����ϱ� ���� ������
	texts texts = new texts();			//���α׷��� �ʿ��� text�� ����ϱ� ���� ������
	
	String Stringtxt[] = new String[10]; 	//�ҷ��� text�� �ӽ÷� �����ϱ� ���� �迭
	int Stringindex = 0;					//Stringtxt index�� ����ϱ� ���� ����
	int select = 0;							//���õ�  Table ��ȣ�� �����ϱ� ���� ����
	int lucky;								//����Ļ� �̺�Ʈ ��� �����Ǵ� �������ڸ� �����ϱ� ���� ����
	int lucknum[] = new int[12]; 			//1~12�� Table�� �ֹ� ��� �����Ǵ� �������ڸ� �����ϱ� ���� �迭
	int ran;								//���������� ���� �Է� �� �����Ǵ� ������ ���ϸ� �ߺ��� ���� ���ؼ� ������ ����
	int money[] = new int[12];															//1~12�� Table�� �� �ֹ��ݾ��� �����ϱ� ���� �迭
 	String mon1, mon2, mon3, mon4, mon5, mon6, mon7, mon8, mon9, mon10, mon11, mon12;	//1~12�� Table�� �� �ֹ��ݾ��� ����ϱ� ���� ����
	int num[] = new int[12]; 															//������� table�� �ֹ��� �־��ֱ� ���� �迭

	JLabel stkpic = new JLabel(images.backimg()); 			//steakPanel background image�� ����ϱ� ���� JLabel
	JLabel pstpic = new JLabel(images.backimg()); 			//pastaPanel background image�� ����ϱ� ���� JLabel 
	JLabel pizpic = new JLabel(images.backimg()); 			//pizzaPanel background image�� ����ϱ� ���� JLabel 
	JLabel pilpic = new JLabel(images.backimg()); 			//pilafPanel background image�� ����ϱ� ���� JLabel
	JLabel sidepic = new JLabel(images.backimg()); 			//sidePanel background image�� ����ϱ� ���� JLabel
	JLabel drinkpic = new JLabel(images.backimg()); 		//drinkPanel background image�� ����ϱ� ���� JLabel 
	
	JLabel timelabel1 = new JLabel(); 										//��, ��, ���� ��Ÿ���� ���� JLabel
	JLabel timelabel2 = new JLabel(); 										//��, ��, �ʸ� ���³��� ���� JLabel
	JLabel welcome = new JLabel("���� ������ �湮���ֽ� ��� �е鲲 ����帳�ϴ�. "		//������ ��Ʈ�� ��Ÿ���� ���� JLabel 
			+ "���� ���񽺷� ������ �� �ֵ��� �׻� ����ϰڽ��ϴ�. ");

	//steakPanel, pizzaPanel, pilafPanel, pastaPanel, sidePanel, drinkPanel���� �ʿ��� JLabel, JButton 
	JLabel steaklabel[] = new JLabel[7];
	JLabel steakname[] = new JLabel[7];
	JButton steakorder[] = new JButton[7];
	JLabel pizzalabel[] = new JLabel[9];
	JLabel pizzaname[] = new JLabel[9];
	JButton pizzaorder[] = new JButton[9];
	JLabel pilaflabel[] = new JLabel[4];
	JLabel pilafname[] = new JLabel[4];
	JButton pilaforder[] = new JButton[4];
	JLabel pastalabel[] = new JLabel[10];
	JLabel pastaname[] = new JLabel[10];
	JButton pastaorder[] = new JButton[10];
	JLabel sidelabel[] = new JLabel[6];
	JLabel sidename[] = new JLabel[6];
	JButton sideorder[] = new JButton[6];
	JLabel drinklabel[] = new JLabel[11];
	JLabel drinkname[] = new JLabel[11];
	JButton drinkorder[] = new JButton[11];
	
	String t1info[] = new String[20];		// 1��  Table �ֹ� ������ �����ϱ� ���� �迭
	String t2info[] = new String[20];		// 2��  Table �ֹ� ������ �����ϱ� ���� �迭
	String t3info[] = new String[20];		// 3��  Table �ֹ� ������ �����ϱ� ���� �迭
	String t4info[] = new String[20];		// 4��  Table �ֹ� ������ �����ϱ� ���� �迭
	String t5info[] = new String[20];		// 5��  Table �ֹ� ������ �����ϱ� ���� �迭
	String t6info[] = new String[20];		// 6��  Table �ֹ� ������ �����ϱ� ���� �迭
	String t7info[] = new String[20];		// 7��  Table �ֹ� ������ �����ϱ� ���� �迭
	String t8info[] = new String[20];		// 8��  Table �ֹ� ������ �����ϱ� ���� �迭
	String t9info[] = new String[20];		// 9��  Table �ֹ� ������ �����ϱ� ���� �迭
	String t10info[] = new String[20];		// 10��  Table �ֹ� ������ �����ϱ� ���� �迭
	String t11info[] = new String[20];		// 11��  Table �ֹ� ������ �����ϱ� ���� �迭
	String t12info[] = new String[20];		// 12��  Table �ֹ� ������ �����ϱ� ���� �迭
	
	JLabel t1money[] = new JLabel[20];		// 1��  Table ���� �ݾ��� �����ϱ� ���� JLabel
	JLabel t2money[] = new JLabel[20];		// 2��  Table ���� �ݾ��� �����ϱ� ���� JLabel
	JLabel t3money[] = new JLabel[20];		// 3��  Table ���� �ݾ��� �����ϱ� ���� JLabel
	JLabel t4money[] = new JLabel[20];		// 4��  Table ���� �ݾ��� �����ϱ� ���� JLabel
	JLabel t5money[] = new JLabel[20];		// 5��  Table ���� �ݾ��� �����ϱ� ���� JLabel
	JLabel t6money[] = new JLabel[20];		// 6��  Table ���� �ݾ��� �����ϱ� ���� JLabel
	JLabel t7money[] = new JLabel[20];		// 7��  Table ���� �ݾ��� �����ϱ� ���� JLabel
	JLabel t8money[] = new JLabel[20];		// 8��  Table ���� �ݾ��� �����ϱ� ���� JLabel
	JLabel t9money[] = new JLabel[20];		// 9��  Table ���� �ݾ��� �����ϱ� ���� JLabel
	JLabel t10money[] = new JLabel[20];		// 10��  Table ���� �ݾ��� �����ϱ� ���� JLabel
	JLabel t11money[] = new JLabel[20];		// 11��  Table ���� �ݾ��� �����ϱ� ���� JLabel
	JLabel t12money[] = new JLabel[20];		// 12��  Table ���� �ݾ��� �����ϱ� ���� JLabel
	
	JMenu menuoption = new JMenu("Table ����"); 			//����Ǿ� �ִ� table�� ���� ������ ó���ϱ� ���� JMenu
	JMenuBar optionbar = new JMenuBar(); 				//����Ǿ� �ִ� table�� ���� ������ ó���ϱ� ���� JMenuBar
	JMenuItem tbinfo = new JMenuItem(" Table ����"); 		//����Ǿ� �ִ� table�� ���� ������ ó���ϱ� ���� JMenuItem
	
	JButton tbtn[] = new JButton[18]; 					//table�� ������ �� �ְ� �ϱ� ���� JButton
	JButton Clickbtn1, Clickbtn2, Clickbtn3, Clickbtn4;	//tbtn�� �������� �� �߰������� option�� ������ �� �ְ� �ϱ� ���� JButton
	JLabel tblabel[] = new JLabel[12]; 					//tbtn�� ������ �����ϱ� ���� JLabel
	JLabel tblabel2[] = new JLabel[12]; 				//tbtn�� ������ �����ϱ� ���� JLabel
	
	JLabel label = new JLabel(images.tableimg());		//table image�� ����ϱ� ���� JLabel
	JButton steak = new JButton(images.steakimg());		//steak image�� ����ϱ� ���� JLabel
	JButton pasta = new JButton(images.pastaimg());		//pasta image�� ����ϱ� ���� JLabel
	JButton pilaf = new JButton(images.pilafimg());		//pilaf image�� ����ϱ� ���� JLabel
	JButton pizza = new JButton(images.pizzaimg());		//pizza image�� ����ϱ� ���� JLabel
	JButton side = new JButton(images.sidedishimg());	//sidedish image�� ����ϱ� ���� JLabel
	JButton drink = new JButton(images.beverageimg());	//drink image�� ����ϱ� ���� JLabel
	JButton endbtn = new JButton("�ֹ� �Ϸ�");				//�ֹ��Ϸ� ó���� ���� JLabel

	// Reservation ó�� ������ �ʿ��� String
	String t1name, t1birth, t1main = "", t1side = "", t1person, t1phone, t1num, t1time;
	String t2name, t2birth, t2main = "", t2side = "", t2person, t2phone, t2num, t2time;
	String t3name, t3birth, t3main = "", t3side = "", t3person, t3phone, t3num, t3time;
	String t4name, t4birth, t4main = "", t4side = "", t4person, t4phone, t4num, t4time;
	String t5name, t5birth, t5main = "", t5side = "", t5person, t5phone, t5num, t5time;
	String t6name, t6birth, t6main = "", t6side = "", t6person, t6phone, t6num, t6time;
	String t7name, t7birth, t7main = "", t7side = "", t7person, t7phone, t7num, t7time;
	String t8name, t8birth, t8main = "", t8side = "", t8person, t8phone, t8num, t8time;
	String t9name, t9birth, t9main = "", t9side = "", t9person, t9phone, t9num, t9time;
	String t10name, t10birth, t10main = "", t10side = "", t10person, t10phone, t10num, t10time;
	String t11name, t11birth, t11main = "", t11side = "", t11person, t11phone, t11num, t11time;
	String t12name, t12birth, t12main = "", t12side = "", t12person, t12phone, t12num, t12time;
	String nowDate;

	JMenuBar menubar = new JMenuBar();  														//VIP�� ���õ� ó���� �ϱ� ���� �ʿ��� JMenuBar
	JMenu menu = new JMenu("V I P"); 															//VIP�� ���õ� ó���� �ϱ� ���� �ʿ��� JMenu
	JMenuItem mn1, mn2, mn3, mn4, mn5, mn6; 													//VIP�� ���õ� ó���� �ϱ� ���� �ʿ��� JMenuItem
	JTextField namefield, birthfield, hpfield1, hpfield2, hpfield3;  							//Reservation�� �ʿ��� ������ �Է¹ޱ� ���� JTextField
	JLabel name, phone, mainmenu, sidemenu, birth, time, person, sum, danger, led, ttable; 		//Reservation ������ �Է¹��� ������ �����ϱ� ���� JLabel
	JButton ok, cancel; 																		//Reservation ������ ����, ������� ó���� �ϱ� ���� JButton
	JRadioButton man; 																			//Reservation ������ �ʿ��� ���� ������ �ϱ� ���� JRadioButton
	JCheckBox woman;  																			//Reservation ������ �ʿ��� ���� ������ �ϱ� ���� JCheckBox
	ButtonGroup g;    																			//�ϳ��� ó�� �������� �����ϱ� ���� �ʿ��� ButtonGroup
	JLabel manofwoman, myperson, la = new JLabel("��Ȯ�� ���������� �Է����ֽñ� �ٶ��ϴ�.");				//Reservation �������� �Է¹��� ��� dafault���� �����ϱ� ���� JLabel
	JComboBox combox, timebox, mainbox, sidebox, tablebox;										//Reservation �������� �������� ��� �� �����ؾ��� ��� �̸� ó���ϱ� ���� JComboBox
	//Reservation �������� �������� ��츦 ������ �� �ֵ��� �̸� �����ϱ� ���� ���ڿ�
	String ea[] = { "�ο�����", "   1 ��", "   2 ��", "   3 ��", "   4 ��", "   5 ��", "   6 ��", "   7 ��", "   8 ��" };
	String ea2[] = { "�ð�����", "   9 ��  ", "   10 ��", "   11 ��", "   12 ��", "   13 ��", "   14 ��", "   15 ��", "   16 �� ", "   17 ��", "   18 ��" };
	String menuString[] = { " Main Select ", " �߰����� ������ũ ", " ��� ������ũ ", " ��ġ �ʶ��� ", " ��� �ʶ��� ", " ������ �ʶ��� ", " ���� �ʶ��� ", " �������� ���� ", " �Ұ��� ���� " };
	String sideString[] = { " Side Select ", " ���� �극�� ", " ġŲ�״� ������ ", " ĥ������ ������ ", " ����ġ ������ " };
	String tablenum[] = { " 1��  ", " 2��  ", " 3��  ", " 4��  ", " 5��  ", " 6��  ", " 7��  ", " 8��  ", " 9��  ", " 10��  ", " 11��  ", " 12��  " };
	String info[] = new String[10];				//Reservation �������� ������ main dish�� �ӽ÷� �����ϱ� ���� ���ڿ�
	String info2[] = new String[10];			//Reservation �������� ������ side dish�� �ӽ÷� �����ϱ� ���� ���ڿ�
	int numm = 0, numm2 = 0;					//���� info�� info2�� ������ ä�������� �˱� ���� index�� �����ϴ� ����
	//Reservation�� �ʿ��� ������ �����ϵ��� �ϱ� ���� JLabel
	JLabel t_name = new JLabel("�� ��");			
	JLabel t_birth = new JLabel("�������");
	JLabel t_main = new JLabel("Main Dish");
	JLabel t_side = new JLabel("Side Dish");
	JLabel t_person = new JLabel("�� ��");
	JLabel t_phone = new JLabel("��ȭ��ȣ");
	JLabel t_num = new JLabel("�� ��");
	JLabel t_time = new JLabel("�� ��");
	
	String t1price[] = new String[20];			// 1��  Table ���� �ݾ��� �ӽ÷� �����ϱ� ���� JLabel
	String t2price[] = new String[20];			// 2��  Table ���� �ݾ��� �ӽ÷� �����ϱ� ���� JLabel
	String t3price[] = new String[20];			// 3��  Table ���� �ݾ��� �ӽ÷� �����ϱ� ���� JLabel
	String t4price[] = new String[20];			// 4��  Table ���� �ݾ��� �ӽ÷� �����ϱ� ���� JLabel
	String t5price[] = new String[20];			// 5��  Table ���� �ݾ��� �ӽ÷� �����ϱ� ���� JLabel
	String t6price[] = new String[20];			// 6��  Table ���� �ݾ��� �ӽ÷� �����ϱ� ���� JLabel
	String t7price[] = new String[20];			// 7��  Table ���� �ݾ��� �ӽ÷� �����ϱ� ���� JLabel
	String t8price[] = new String[20];			// 8��  Table ���� �ݾ��� �ӽ÷� �����ϱ� ���� JLabel
	String t9price[] = new String[20];			// 9��  Table ���� �ݾ��� �ӽ÷� �����ϱ� ���� JLabel
	String t10price[] = new String[20];			// 10��  Table ���� �ݾ��� �ӽ÷� �����ϱ� ���� JLabel
	String t11price[] = new String[20];			// 11��  Table ���� �ݾ��� �ӽ÷� �����ϱ� ���� JLabel
	String t12price[] = new String[20];			// 12��  Table ���� �ݾ��� �ӽ÷� �����ϱ� ���� JLabel

	Container contentpane;				//Container�� ����ϱ� ���� ����
	FoodMenu fdmenu; 					//FoodMenu�� ����ϱ� ���� ����
	SubMenu clk; 						//Click0�� ����ϱ� ���� ����
	SteakPanel stp;  					//Steak Panel�� ����ϱ� ���� ����
	PastaPanel psp;	 					//Pasta Panel�� ����ϱ� ���� ����
	PilafPanel plp;  					//Pilaf Panel�� ����ϱ� ���� ����
	PizzaPanel pzp;  					//Pizza Panel�� ����ϱ� ���� ����
	SidePanel sdp;   					//Side Panel�� ����ϱ� ���� ����
	DrinkPanel dkp;  					//Drink Panel�� ����ϱ� ���� ����
	OrderInfo od;    					//OrderInfo�� ����ϱ� ���� ����
	Mysetting set;						//Mysetting�� ����ϱ� ���� ����
	showStat rec;						//showStat�� ����ϱ� ���� ����
 	SignPanel spsp;  					//Sign Panel�� ����ϱ� ���� ����
	Payment pay;   						//Payment�� ����ϱ� ���� ����
	Survey sv;     						//Survey�� ����ϱ� ���� ����
	SurveyWindow sw; 					//SurveryWindow�� ����ϱ� ���� ����
	Reservation reser;					//Reservation�� ����ϱ� ���� ����
	Event event;						//Event�� ����ϱ� ���� ����
	CurrentTime currenttime;			//CurrentTime�� ����ϱ� ���� ����
	MyThread mth;						//MyThread�� ����ϱ� ���� ����

	JButton paybtn1 = new JButton(images.cashcimg());	//���� ��Ȳ���� ���� ������ ó�� �ϱ� ���� JButton
	JButton paybtn2 = new JButton(images.cardimg());	//���� ��Ȳ���� ī�� ������ ó�� �ϱ� ���� JButton
	
	JButton surveyok = new JButton("�ϰڽ��ϴ�");			//�������� ��Ȳ���� �������θ� ó�� �ϱ� ���� JButton
	JButton surveycancel = new JButton("�����ʰڽ��ϴ�");	//�������� ��Ȳ���� ���������θ� ó�� �ϱ� ���� JButton
	JTextField surveytxt[] = new JTextField[5];			//�������翡 ���� �亯�� �޾ƿ��� ���� JTextField
	
	JButton surveyre = new JButton(images.chartimg());	//��� ��������� ������ �׸��� ��ȸ�ϱ� ���� JButton
	JLabel mainsign = new JLabel(images.mainsignimg());	//mainsign�� ǥ���ϱ� ���� JLabel
	JButton setting = new JButton(images.settingimg());	//volume setting�� ó���ϱ� ���� JButton
	JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 500, 250); 	//volume setting �������� ���������� ǥ���ϱ� ���� JSlider

	JLabel foodinfo[] = new JLabel[20];								//�̰����� �޴� ����Ʈ�� ǥ���ϱ� ���� JLabel
	JLabel north = new JLabel("< �� �� �� ��  >", JLabel.CENTER);		//���� �������� ������ �����ؾ��� ������ ���;����� �Ͻ��ϴ� ������ ǥ���ϱ� ���� JLabel
	JLabel south2 = new JLabel("",JLabel.CENTER);					//���� �������� �հ� �ݾ��� ǥ���ϱ� ���� JLabel(����� default��)
	Scanner sc;														//Scanner�� ����ϱ� ���� ����

	public main() { 							//main ������
		super("Kiosk - SEOGA&COOK");			//title ����

		for (int i = 0; i < 12; i++) {			//money, num�� ���� �ʱ�ȭ
			money[i] = 0;
			num[i] = 0;
		}
		menuoption.add(tbinfo); 				//tbinfo�� menuoption�� ����
		optionbar.add(menuoption); 				//menuoption�� optionbar�� ����
		fdmenu = new FoodMenu(); 				//FoodMenu�� ����ϱ� ���� ������ ȣ��
		sw = new SurveyWindow(); 				//SurveyWindow�� ����ϱ� ���� ������ ȣ��
		spsp = new SignPanel(); 				//SignPanel�� ����ϱ� ���� ������ ȣ��
		clk = new SubMenu(); 					//Click0�� ����ϱ� ���� ������ ȣ��
		stp = new SteakPanel(); 				//SteakPanel�� ����ϱ� ���� ������ ȣ��
		psp = new PastaPanel(); 				//PastaPanel�� ����ϱ� ���� ������ ȣ��
		plp = new PilafPanel(); 				//PilafPanel�� ����ϱ� ���� ������ ȣ��
		pzp = new PizzaPanel(); 				//PizzaPanel�� ����ϱ� ���� ������ ȣ��
		sdp = new SidePanel(); 					//SidePanel�� ����ϱ� ���� ������ ȣ��
		dkp = new DrinkPanel(); 				//DrinkPanel�� ����ϱ� ���� ������ ȣ��
		set = new Mysetting(); 					//Mysetting�� ����ϱ� ���� ������ ȣ��
		rec = new showStat(); 					//showStat�� ����ϱ� ���� ������ ȣ��
		reser = new Reservation(); 				//Reservation�� ����ϱ� ���� ������ ȣ��
		event = new Event(); 					//Event�� ����ϱ� ���� ������ ȣ��
		pay = new Payment(); 					//Payment�� ����ϱ� ���� ������ ȣ��
		currenttime = new CurrentTime(); 		//CurrentTime���� ����ϱ� ���� ������ ȣ��
		mth = new MyThread(); 					//MyThread�� ����ϱ� ���� ������ ȣ��
		
		Thread th = new Thread(currenttime); 	//currenttime�� thread class�� ���� ����
		Thread th2 = new Thread(mth);    	 	//mth�� thread class�� ���� ����
		th.start();								//thread ����
		th2.start();							//thread ����

		lucky = (int) (Math.random() * 10);		//����Ļ� �̺�Ʈ ��� �����Ǵ� ��������

		//ContentPane setting
		getContentPane();										//���� �۵����� ContentPane ȣ��
		getContentPane().setBackground(Color.WHITE);			//���� �����ǰ� �ִ� contentpane�� ���� ����
		setLayout(null);										//���� ��� ��ġ������ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		
		for (int i = 0; i < 12; i++) {							
			tblabel[i] = new JLabel((i + 1) + " ��");			//table ��ȣ ǥ��
			tblabel2[i] = new JLabel("", JLabel.CENTER);		//�ֹ�, ������ �� �ð� ǥ��
			tbtn[i] = new JButton("�Լ� ����");					//�ֹ�, ������ ������ �������� ǥ��
			tbtn[i].setLayout(new GridLayout(2, 1));			//GridLayout ����
			tbtn[i].add(tblabel[i]);							//tblabel�� tbtn�� ����
			tbtn[i].add(tblabel2[i]);							//tblabel2�� tbtn�� ����
			label.add(tbtn[i]);									//tbtn�� label�� ����
			tbtn[i].addActionListener(new MyActionListener());	//tbtn�� ActionListener ����
			tbtn[i].setBackground(Color.WHITE);					//tbtn ���� ����
			tbtn[i].addMouseListener(new MyMouseListener());	//tbtn�� MouseListener ����
		}
		
		//tbtn�� boundary ����
		for (int j = 0; j < 4; j++) {								
			tbtn[j].setBounds(37 + (j * 251), 45, 174, 83);
			tbtn[j + 4].setBounds(37 + (j * 251), 220, 174, 83);
			tbtn[j + 8].setBounds(37 + (j * 251), 395, 174, 83);
		}
		
		surveyre.setBounds(1040, 250, 122, 109);				//surveyre�� boundary ����
		setting.setBounds(1040, 400, 124, 112);					//setting�� boundary ����
		label.setBounds(0, 154, 1000, 526);						//label�� boundary ����
		mainsign.setBounds(0, 0, 1200, 154);					//mainsign�� boundary ����
		timelabel1.setBounds(1020, 530, 200, 40);				//timelabel1�� boundary ����
		timelabel2.setBounds(1010, 590, 200, 40);				//timelabel2�� boundary ����
		
		timelabel1.setFont(new Font("Bold", Font.BOLD, 25));	//timelabel1�� ��Ʈ ����
		timelabel2.setFont(new Font("Bold", Font.BOLD, 35));	//timelabel2�� ��Ʈ ����
		welcome.setFont(new Font("Bold", Font.BOLD, 40));		//welcome�� ��Ʈ ����
		
		//�� ContentPane�� ����
		add(timelabel1);
		add(timelabel2);
		add(welcome);
		add(label);
		add(surveyre);
		add(setting);
		add(mainsign);
		
		//setting�� �ҷ����� ���� ActionListener
		setting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				set.setVisible(true);
			}
		});
		
		//surveyre�� �ҷ����� ���� ActionListener
		surveyre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				rec.setVisible(true);
			}
		});
		setResizable(false);			//���������� �Ұ����ϰ� ����
		setSize(1200, 800);				//������ ����
		setLocation(165, 100);			//��ġ ����
		setVisible(true);				//Visible ��� ����
	}

	class Mysetting extends JFrame {						// volume ������ ���� class
		JLabel vol = new JLabel(images.soundimg());			// Mysetting�� ���� �۾��� ���ֱ� ���� JLabel
		JButton ok = new JButton(" Set ");					// JSlider�� ���� set �۾��� ���ֱ� ���� JButton
		JLabel setv = new JLabel("(Vol)");					// vol�� ������ ǥ�����ֱ� ���� JLabel

		Mysetting() {										// Mysetting ������, slider setting
			getContentPane();								//���� �۵����� ContentPane ȣ��
			getContentPane().setLayout(null);				// ������ ��ġ������ ����

			vol.setBounds(0, -30, 450, 400);				//vol boundary ����
			slider.setBounds(15, 190, 400, 60);				//slider boundary ����
			setv.setBounds(390, 245, 50, 30);				//setv boundary ����
			ok.setBounds(180, 260, 70, 40);					//ok boundary ����
			slider.setPaintLabels(true);					// slider label ����
			slider.setPaintTicks(true);						// slider tick ����
			slider.setMajorTickSpacing(50);					// slider majortick setting
			slider.setMinorTickSpacing(10);					// slider minortick setting
			slider.setBackground(Color.WHITE);				// slider ���� ����
			slider.setFont(new Font("", Font.BOLD, 15));	// slider ��Ʈ ����
			slider.setValue(500);							// slider default value ����
			
			//�� ContentPane ����
			vol.add(ok);				
			vol.add(setv);
			vol.add(slider);
			add(vol);
			setSize(450, 330);				//������ ����
			setLocation(800, 300);			//��ġ ����
			setResizable(false);			//���������� �Ұ����ϰ� ����
			setVisible(false);				//Visible ��� ����
		}
	}
	
	class showStat extends JFrame {								//stat�� �����ֱ� ���� class
		showStat() {											//showStat ������, showStat setting
			Scanner sc = null;									//scanner �ʱ�ȭ
			try {
				sc = new Scanner(texts.goodSurvey(), "UTF-8");	//�ѱ��� ���������� ������ϱ� ���� UTF-8 ����Ͽ� scanner ����
			} catch (FileNotFoundException e1) {				//FileNotFoundException ����ó��
				e1.printStackTrace();
			}
			
			//goodSurvey�� ������ ���������� �׸� �����亯 ������ �������� ���� JLabel
			JLabel stats1 = new JLabel(sc.nextLine());		
			JLabel stats2 = new JLabel(sc.nextLine());		
			JLabel stats3 = new JLabel(sc.nextLine());		
			JLabel stats4 = new JLabel(sc.nextLine());
			
			setTitle("best stat");								//title ����
			setBackground(Color.WHITE);							//���� ����
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			setLayout(new FlowLayout());						//FlowLayout ��ġ������ ����
			
			//�� ContentPane�� ����
			add(stats1);
			add(stats2);
			add(stats3);
			add(stats4);
			setLocation(550,300);		//��ġ ����
			setResizable(false);		//���������� �Ұ����ϰ� ����
			setSize(400, 400);			//������ ����
		}
	}
	
	class SignPanel extends JFrame {				// ī�� ������ ������ ��� ����ó���� �ϱ� ���� class
		BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);	//������ �̹����� ó���ϱ� ���� BufferedImage
		Graphics graphics = image.createGraphics(); 					//image�� ����� ���� Graphics ����
		JButton yesbtn = new JButton("����");								//����ó���� ���� JButton
		Point stpoint = null, epoint = null;							//������ �׷��� �� ���� �������� ������ �����ϱ� ���� Point ����
		JPanel signpanel = new JPanel();								//������ �׸��� ���� panel�� ���� JPanel
		JPanel southpanel = new JPanel();								//yesbtn�� ǥ���ϱ� ���� JPanel

		SignPanel() {													//SignPanel ������
			setTitle("Your Sign Plz");									//title ����
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			southpanel.setLayout(new FlowLayout());						//FlowLayout ��ġ������ ����
			southpanel.add(yesbtn);										//southpanel�� yesbtn ����
			
			//�� ContentPane�� ����
			add(southpanel, BorderLayout.SOUTH);
			add(signpanel, BorderLayout.CENTER);
			signpanel.addMouseListener(new MyMouseAdapter());			//signpanel�� MouseAdapter ����
			signpanel.addMouseMotionListener(new MyMouseMotion());		//signpanel�� MouseMotionListener ����
			yesbtn.addActionListener(new ActionListener() { 			//yesbtn�� ActionListener ����
				public void actionPerformed(ActionEvent e) {
					try {
						File file = new File("����" + ran + ".jpeg"); 	//������ ������ file type ����
						ImageIO.write(image, "jpeg", file);				//������ file�� ����
					} catch (Exception e1) {							//Exception ���� ó��
						e1.printStackTrace();
					}
					setVisible(false);									//Visible ��� ����
				}
			});
			setResizable(false);										//���������� �Ұ����ϰ� ����
			setSize(400, 400);											//������ ����
		}
		class MyMouseAdapter extends MouseAdapter {			//������ �׸��� ���� ó�� ���콺�� ������ ��� point�� �������� class
			public void mousePressed(MouseEvent e) {
				stpoint = e.getPoint();
			}
			public void mouseReleased(MouseEvent e) {		//������ �׸��� ���� ���콺�� ������ �ٽ� ���� ��� point�� �������� class
				epoint = e.getPoint();
				repaint();								//�ʱ� ȭ������ �ʱ�ȭ
			}
		}
		class MyMouseMotion extends MouseMotionAdapter {	//������ �׸��� �������� �ش� point�� �������� class
			public void mouseDragged(MouseEvent e) {
				epoint = e.getPoint();
				repaint();								//�ʱ� ȭ������ �ʱ�ȭ
			}
		}
		public void paint(Graphics g) { 										//������ �׸��� �������� ������ point�� ���� graphó���Ͽ� ������ȭ�ϴ� class
			if (stpoint != null && epoint != null) {
				g.drawLine(stpoint.x, stpoint.y, epoint.x, epoint.y);			//���������� ���������� ���� ����
				graphics.drawLine(stpoint.x, stpoint.y, epoint.x, epoint.y);	//���������� ���������� ���� ����
				stpoint = epoint;												//�߰� ���� �߻������ʵ��� �ʱ�ȭ
			}
		}
	}
	
	class SurveyWindow extends JDialog {          								//���� ���� �� �������� �������θ� ó���ϴ� class
		JLabel la2 = new JLabel(images.discountimg());							//������ ���� ���θ� ���������� �����ֱ� ���� JLabel

		SurveyWindow() {														//SurveyWindow ������
			getContentPane();													//���� �۵����� ContentPane ȣ��
			getContentPane().setBackground(Color.WHITE);						//���� �۵����� ContentPane ���� ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));				//FlowLayout ��ġ������ ����
			
			JLabel mysur = new JLabel("  ������ �����Ͻø� �������� 5%���� �ص帳�ϴ�.  ");	//������ ������ �����ֱ� ���� JLabel
			
			//�� ContentPane�� ����
			add(mysur);
			add(la2);
			add(surveyok);
			add(surveycancel);
			
			surveyok.addActionListener(new ActionListener() { 			//surveyok�� ActionListener ����
				public void actionPerformed(ActionEvent e) {
					setModal(false);									//��޸��� ����
					new Survey();										//�������縦 �����ϱ� ���� Survey ������ ȣ��
					setVisible(false);									//Visible ��� ����
				}
			});
			
			surveycancel.addActionListener(new ActionListener() { 		//surveycancel�� ActionListener ����
				public void actionPerformed(ActionEvent e) {
					setModal(false);									//��޸��� ����
					setVisible(false);									//Visible ��� ����
				}
			});
			setResizable(false);										//���������� �Ұ����ϰ� ����
			setSize(370, 300);											//������ ����
		}
	}
	
	class Survey extends JDialog { 												//�������翡 �����ϰ��� �ϴ� ��� �������縦 �����ϴ� class
		Survey() {																//Survey ������
			Scanner sc = null;													//Scanner �ʱ�ȭ
			try {
				sc = new Scanner(texts.survey(), "UTF-8");      				//survey.txt���� survey ������ �ʿ��� ���� scan
			} catch (FileNotFoundException e1) {								//FileNotFoundException ���� ó��
				e1.printStackTrace();
			}
			
			//survey ������ �ʿ��� ������ ǥ���ϱ� ���� JLabel
			JLabel sv1 = new JLabel(sc.nextLine(), JLabel.LEFT);
			JLabel sv2 = new JLabel(sc.nextLine(), JLabel.LEFT);
			JLabel sv3 = new JLabel(sc.nextLine(), JLabel.LEFT);
			JLabel sv4 = new JLabel(sc.nextLine(), JLabel.LEFT);
			JButton submit = new JButton("�����ϱ�");					//���� ó���� �ϱ� ���� JButton
			
			setTitle("���� ��");										//title ����	
			getContentPane();										//���� �۵����� ContentPane ȣ��
			setLayout(new GridLayout(10, 1));						//GridLayout ��ġ������ ����
			setModal(true);											//��� ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			//��Ʈ ����
			sv1.setFont(new Font("���ü", Font.BOLD, 16));
			sv2.setFont(new Font("���ü", Font.BOLD, 16));
			sv3.setFont(new Font("���ü", Font.BOLD, 16));
			sv4.setFont(new Font("���ü", Font.BOLD, 16));
			
			for (int i = 0; i < 5; i++)
				surveytxt[i] = new JTextField(40);					//�������� �׸��� �޾ƿ��� ���� JTextField ����
			
			//�� ContentPane�� ����
			add(sv1);
			add(surveytxt[0]);
			add(sv2);
			add(surveytxt[1]);
			add(sv3);
			add(surveytxt[2]);
			add(sv4);
			add(surveytxt[3]);
			add(submit);
			
			submit.addActionListener(new ActionListener() { 	//submit�� ActionListener ����
				public void actionPerformed(ActionEvent e) {
					setVisible(false);							//Visible ��� ����
					System.out.println("");
					new SurveyWrite();							//Survey���� �Է��� ������ ������ȭ�ϱ� ���� SurveyWrite ������ ȣ��
				}
			});
			setSize(500, 600);									//������ ����
			setResizable(false);								//���������� �Ұ����ϰ� ����
			setVisible(true);									//Visible ��� ����
		}
	}
	
	class SurveyWrite {											//�������� �������� JTextField�� �Էµ� ������ ������ȭ�ϴ� class
		SurveyWrite() {											//SurveyWrite ������
			String fileName = "��������" + ran + ".txt";			//������ ������ȭ�Ͽ� ������ File �̸� ����
			
			try {
				File file = new File(fileName);					//������ ������ȭ�Ͽ� ������ File type ����
				FileWriter fw = new FileWriter(file);			//�����͸� �����ϱ� ���� FileWriter ����
				for (int i = 0; i < 5; i++)
					fw.write(surveytxt[i].getText() + "  ");	//�������� �������� JTextField�� �Էµ� ������ �ش� File�� ����
				fw.flush();										//��¾ȵ� ������ ������ flush ó��
				fw.close();										
			} catch (Exception e) {								//Exception ����ó��
				e.printStackTrace();
			}
		}
	}

	class OrderInfo extends JDialog {																//table������ ��ȸ���� �� �ֹ���Ȳ�� ��ȸ�� �� �ֵ��� �ϴ� class
		JLabel foodinfo[] = new JLabel[20];															//���� �ֹ���Ȳ�� �����ϱ� ���� JLabel
		JLabel north = new JLabel("< �� �� �� ��  >", JLabel.CENTER);									//������ ���� ������ ���� �ֹ���Ȳ���� ǥ���ϱ� ���� JLabel
		JLabel south;																				//������ ���� ������ ���� �ֹ��Ѿ����� ǥ���ϱ� ���� JLabel

		OrderInfo() {																				//OrderInfo ������	
			setTitle("�ֹ� ��Ȳ");																		//title ����													
			getContentPane();																		//���� �۵����� ContentPane ȣ��
			getContentPane().setBackground(Color.WHITE);											//���� �۵����� ContentPane�� ���� ����
			setLayout(null);																		//���� ��� ��ġ������ ����
			setModal(true);																			//��� ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

			north.setBounds(10, 10, 360, 25);														//north boundary ����
			add(north);																				//north ����
			
			if (select == 1) {																		//1�� Table�� ���õǾ��� ��
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t1info[i]);											//t1info�� ǥ���ϱ� ���� foodinfo�� ����
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary ����
					t1money[i] = new JLabel(t1price[i]);											//t1price�� ǥ���ϱ� ���� t1money�� ����
					t1money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t1money boundary ����
					add(t1money[i]);																//t1money ����
					south = new JLabel("< �� �� �� ��  > : " + money[0] + " ���Դϴ�.", JLabel.CENTER);	//south�� ǥ���� ���� �����
				}
			} 
			else if (select == 2) {																	//2�� Table�� ���õǾ��� ��
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t2info[i]);											//t2info�� ǥ���ϱ� ���� foodinfo�� ����
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary ����
					t2money[i] = new JLabel(t2price[i]);											//t2price�� ǥ���ϱ� ���� t2money�� ����
					t2money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t2money boundary ����
					add(t2money[i]);																//t2money ����
					south = new JLabel("< �� �� �� ��  > : " + money[1] + " ���Դϴ�.", JLabel.CENTER);	//south�� ǥ���� ���� �����
				}
			}
			else if (select == 3) {																	//3�� Table�� ���õǾ��� ��
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t3info[i]);											//t3info�� ǥ���ϱ� ���� foodinfo�� ����
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary ����
					t3money[i] = new JLabel(t3price[i]);											//t3price�� ǥ���ϱ� ���� t3money�� ����
					t3money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t3money boundary ����
					add(t3money[i]);																//t3money ����
					south = new JLabel("< �� �� �� ��  > : " + money[2] + " ���Դϴ�.", JLabel.CENTER);	//south�� ǥ���� ���� �����
				}
			}
			else if (select == 4) {																	//4�� Table�� ���õǾ��� ��
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t4info[i]);											//t4info�� ǥ���ϱ� ���� foodinfo�� ����
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary ����
					t4money[i] = new JLabel(t4price[i]);											//t4price�� ǥ���ϱ� ���� t4money�� ����
					t4money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t4money boundary ����
					add(t4money[i]);																//t4money ����
					south = new JLabel("< �� �� �� ��  > : " + money[3] + " ���Դϴ�.", JLabel.CENTER);	//south�� ǥ���� ���� �����
				}
			}
			else if (select == 5) {																	//5�� Table�� ���õǾ��� ��
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t5info[i]);											//t5info�� ǥ���ϱ� ���� foodinfo�� ����
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary ����
					t5money[i] = new JLabel(t5price[i]);											//t5price�� ǥ���ϱ� ���� t5money�� ����
					t5money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t5money boundary ����
					add(t5money[i]);																//t5money ����
					south = new JLabel("< �� �� �� ��  > : " + money[4] + " ���Դϴ�.", JLabel.CENTER);	//south�� ǥ���� ���� �����
				}
			}
			else if (select == 6) {																	//6�� Table�� ���õǾ��� ��
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t6info[i]);											//t6info�� ǥ���ϱ� ���� foodinfo�� ����
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary ����
					t6money[i] = new JLabel(t6price[i]);											//t6price�� ǥ���ϱ� ���� t6money�� ����
					t6money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t6money boundary ����
					add(t6money[i]);																//t6money ����
					south = new JLabel("< �� �� �� ��  > : " + money[5] + " ���Դϴ�.", JLabel.CENTER);	//south�� ǥ���� ���� �����
				}
			}
			else if (select == 7) {																	//7�� Table�� ���õǾ��� ��
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t7info[i]);											//t7info�� ǥ���ϱ� ���� foodinfo�� ����
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary ����
					t7money[i] = new JLabel(t7price[i]);											//t7price�� ǥ���ϱ� ���� t7money�� ����
					t7money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t7money boundary ����
					add(t7money[i]);																//t7money ����
					south = new JLabel("< �� �� �� ��  > : " + money[6] + " ���Դϴ�.", JLabel.CENTER);	//south�� ǥ���� ���� �����
				}
			}
			else if (select == 8) {																	//8�� Table�� ���õǾ��� ��
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t8info[i]);											//t8info�� ǥ���ϱ� ���� foodinfo�� ����
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary ����
					t8money[i] = new JLabel(t8price[i]);											//t8price�� ǥ���ϱ� ���� t8money�� ����
					t8money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t8money boundary ����
					add(t8money[i]);																//t8money ����
					south = new JLabel("< �� �� �� ��  > : " + money[7] + " ���Դϴ�.", JLabel.CENTER);	//south�� ǥ���� ���� �����
				}
			}
			else if (select == 9) {																	//9�� Table�� ���õǾ��� ��
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t9info[i]);											//t9info�� ǥ���ϱ� ���� foodinfo�� ����
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary ����
					t9money[i] = new JLabel(t9price[i]);											//t9price�� ǥ���ϱ� ���� t9money�� ����
					t9money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t9money boundary ����
					add(t9money[i]);																//t9money ����
					south = new JLabel("< �� �� �� ��  > : " + money[8] + " ���Դϴ�.", JLabel.CENTER);	//south�� ǥ���� ���� �����
				}
			}
			else if (select == 10) {																//10�� Table�� ���õǾ��� ��
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t10info[i]);											//t10info�� ǥ���ϱ� ���� foodinfo�� ����
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary ����
					t10money[i] = new JLabel(t10price[i]);											//t10price�� ǥ���ϱ� ���� t10money�� ����
					t10money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t10money boundary ����
					add(t10money[i]);																//t10money ����
					south = new JLabel("< �� �� �� ��  > : " + money[9] + " ���Դϴ�.", JLabel.CENTER);	//south�� ǥ���� ���� �����
				}
			}
			else if (select == 11) {																//11�� Table�� ���õǾ��� ��
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t11info[i]);											//t11info�� ǥ���ϱ� ���� foodinfo�� ����
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary ����
					t11money[i] = new JLabel(t11price[i]);											//t11price�� ǥ���ϱ� ���� t11money�� ����
					t11money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t11money boundary ����
					add(t11money[i]);																//t11money ����
					south = new JLabel("< �� �� �� ��  > : " + money[10] + " ���Դϴ�.", JLabel.CENTER);	//south�� ǥ���� ���� �����
				}
			}
			else if (select == 12) {																//12�� Table�� ���õǾ��� ��
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t12info[i]);											//t12info�� ǥ���ϱ� ���� foodinfo�� ����
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary ����
					t12money[i] = new JLabel(t12price[i]);											//t12price�� ǥ���ϱ� ���� t12money�� ����
					t12money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t12money boundary ����
					add(t12money[i]);																//t12money ����
					south = new JLabel("< �� �� �� ��  > : " + money[11] + " ���Դϴ�.", JLabel.CENTER);	//south�� ǥ���� ���� �����
				}
			}
			
			for (int i = 0; i < 20; i++)			
				add(foodinfo[i]);					//foodinfo ����
			south.setBounds(100, 300, 300, 30);		//south boundary ����
			add(south);								//south ����
			setSize(400, 500);						//������ ����
			setVisible(true);						//Visible ��� ����
		}
	}

	class Payment extends JFrame {															//���� ó���� �ϱ� ���� class
		Payment() {																			//Payment ������
			for (int i = 0; i < 20; i++)
				foodinfo[i] = new JLabel();													//���� �ֹ���Ȳ�� �����ϱ� ���� JLabel
			setTitle("Payment Security 1.0");												//title ����
			getContentPane();																//���� �۵����� ContentPane ȣ��
			getContentPane().setBackground(Color.WHITE);									//���� �۵����� ContentPane ���� ����
			setLayout(null);																//���� ��� ��ġ������ ����													
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			for (int i = 0; i < 20; i++) {
				foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);							//foodinfo boundary ����
				add(foodinfo[i]);															//foodinfo ����
			}
			
			paybtn1.addActionListener(new ActionListener() { 								//paybtn1�� ActionListener ����
				public void actionPerformed(ActionEvent e) {
					setVisible(false);														//Visible ��� ����
					for (int i = 0; i < 20; i++)
						foodinfo[i].setText("");											//foodinfo �ʱ�ȭ
					
					if (select == 1) {														//1�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[0] = 0;															
						System.out.println("1�� ���̺��� " + money[0] + " ���� ���Ǿ����ϴ�.");	
						tbtn[0].setText("�Լ� ����");											
						tbtn[0].setBackground(Color.WHITE);									
						tblabel2[0].setText("");											
						money[0] = 0;														
						for (int i = 0; i < 20; i++) {
							t1money[i].setText("");
							t1info[i] = "";
							t1price[i] = "";
						}
					}else if (select == 2) {												//2�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[1] = 0;
						System.out.println("2�� ���̺��� " + money[1] + " ���� ���Ǿ����ϴ�.");
						tbtn[1].setText("�Լ� ����");
						tbtn[1].setBackground(Color.WHITE);
						tblabel2[1].setText("");
						money[1] = 0;
						for (int i = 0; i < 20; i++) {
							t2money[i].setText("");
							t2info[i] = "";
							t2price[i] = "";
						}
					}else if (select == 3) {												//3�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[2] = 0;
						System.out.println("3�� ���̺��� " + money[2] + " ���� ���Ǿ����ϴ�.");
						tbtn[2].setText("�Լ� ����");
						tbtn[2].setBackground(Color.WHITE);
						tblabel2[2].setText("");
						money[2] = 0;
						for (int i = 0; i < 20; i++) {
							t3money[i].setText("");
							t3info[i] = "";
							t3price[i] = "";
						}
					}else if (select == 4) {												//4�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[3] = 0;
						System.out.println("4�� ���̺��� " + money[3] + " ���� ���Ǿ����ϴ�.");
						tbtn[3].setText("�Լ� ����");
						tbtn[3].setBackground(Color.WHITE);
						tblabel2[3].setText("");
						money[3] = 0;
						for (int i = 0; i < 20; i++) {
							t4money[i].setText("");
							t4info[i] = "";
							t4price[i] = "";
						}
					}else if (select == 5) {												//5�� Table�� ���õǾ��� ��  �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[4] = 0;
						System.out.println("5�� ���̺��� " + money[4] + " ���� ���Ǿ����ϴ�.");
						tbtn[4].setText("�Լ� ����");
						tbtn[4].setBackground(Color.WHITE);
						tblabel2[4].setText("");
						money[4] = 0;
						for (int i = 0; i < 20; i++) {
							t5money[i].setText("");
							t5info[i] = "";
							t5price[i] = "";
						}
					}else if (select == 6) {												//6�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[5] = 0;
						System.out.println("6�� ���̺��� " + money[5] + " ���� ���Ǿ����ϴ�.");
						tbtn[5].setText("�Լ� ����");
						tbtn[5].setBackground(Color.WHITE);
						tblabel2[5].setText("");
						money[5] = 0;
						for (int i = 0; i < 20; i++) {
							t6money[i].setText("");
							t6info[i] = "";
							t6price[i] = "";
						}
					} else if (select == 7) {												//7�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[6] = 7;
						System.out.println("7�� ���̺��� " + money[6] + " ���� ���Ǿ����ϴ�.");
						tbtn[6].setText("�Լ� ����");
						tbtn[6].setBackground(Color.WHITE);
						tblabel2[6].setText("");
						money[6] = 0;
						for (int i = 0; i < 20; i++) {
							t7money[i].setText("");
							t7info[i] = "";
							t7price[i] = "";
						}
					} else if (select == 8) {												//8�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[7] = 0;
						System.out.println("8�� ���̺��� " + money[7] + " ���� ���Ǿ����ϴ�.");
						tbtn[7].setText("�Լ� ����");
						tbtn[7].setBackground(Color.WHITE);
						tblabel2[7].setText("");
						money[7] = 0;
						for (int i = 0; i < 20; i++) {
							t8money[i].setText("");
							t8info[i] = "";
							t8price[i] = "";
						}
					} else if (select == 9) {												//9�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[8] = 0;
						System.out.println("9�� ���̺��� " + money[8] + " ���� ���Ǿ����ϴ�.");
						tbtn[8].setText("�Լ� ����");
						tbtn[8].setBackground(Color.WHITE);
						tblabel2[8].setText("");
						money[8] = 0;
						for (int i = 0; i < 20; i++) {
							t9money[i].setText("");
							t9info[i] = "";
							t9price[i] = "";
						}
					} else if (select == 10) {												//10�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[9] = 10;
						System.out.println("10�� ���̺��� " + money[9] + " ���� ���Ǿ����ϴ�.");
						tbtn[9].setText("�Լ� ����");
						tbtn[9].setBackground(Color.WHITE);
						tblabel2[9].setText("");
						money[9] = 0;
						for (int i = 0; i < 20; i++) {
							t10money[i].setText("");
							t10info[i] = "";
							t10price[i] = "";
						}
					} else if (select == 11) {												//11�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[10] = 0;
						System.out.println("11�� ���̺��� " + money[10] + " ���� ���Ǿ����ϴ�.");
						tbtn[10].setText("�Լ� ����");
						tbtn[10].setBackground(Color.WHITE);
						tblabel2[10].setText("");
						money[10] = 0;
						for (int i = 0; i < 20; i++) {
							t11money[i].setText("");
							t11info[i] = "";
							t11price[i] = "";
						}
					} else if (select == 12) {												//12�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[11] = 0;
						System.out.println("12�� ���̺��� " + money[11] + " ���� ���Ǿ����ϴ�.");
						tbtn[11].setText("�Լ� ����");
						tbtn[11].setBackground(Color.WHITE);
						tblabel2[11].setText("");
						money[11] = 0;
						for (int i = 0; i < 20; i++) {
							t12money[i].setText("");
							t12info[i] = "";
							t12price[i] = "";
						}
					}
					sw.setVisible(true);
				}
			});
			
			paybtn2.addActionListener(new ActionListener() { 								//paybtn2�� ActionListener ����
				public void actionPerformed(ActionEvent e) {
					setVisible(false);														//Visible ��� ����
					spsp.setVisible(true);													//spsp�� Visible ������� ����
					for (int i = 0; i < 20; i++)
						foodinfo[i].setText("");											//foodinfo �ʱ�ȭ
					if (select == 1) {														//1�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[0] = 0;
						System.out.println("1�� ���̺��� " + money[0] + " ���� ���Ǿ����ϴ�.");
						tbtn[0].setText("�Լ� ����");
						tbtn[0].setBackground(Color.WHITE);
						tblabel2[0].setText("");
						money[0] = 0;
						for (int i = 0; i < 20; i++) {
							t1money[i].setText("");
							t1info[i] = "";
							t1price[i] = "";
						}
					} else if (select == 2) {												//2�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[1] = 0;
						System.out.println("2�� ���̺��� " + money[1] + " ���� ���Ǿ����ϴ�.");
						tbtn[1].setText("�Լ� ����");
						tbtn[1].setBackground(Color.WHITE);
						tblabel2[1].setText("");
						money[1] = 0;
						for (int i = 0; i < 20; i++) {
							t2money[i].setText("");
							t2info[i] = "";
							t2price[i] = "";
						}
					} else if (select == 3) {												//3�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[2] = 0;
						System.out.println("3�� ���̺��� " + money[2] + " ���� ���Ǿ����ϴ�.");
						tbtn[2].setText("�Լ� ����");
						tbtn[2].setBackground(Color.WHITE);
						tblabel2[2].setText("");
						money[2] = 0;
						for (int i = 0; i < 20; i++) {
							t3money[i].setText("");
							t3info[i] = "";
							t3price[i] = "";
						}
					} else if (select == 4) {												//4�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[3] = 0;
						System.out.println("4�� ���̺��� " + money[3] + " ���� ���Ǿ����ϴ�.");
						tbtn[3].setText("�Լ� ����");
						tbtn[3].setBackground(Color.WHITE);
						tblabel2[3].setText("");
						money[3] = 0;
						for (int i = 0; i < 20; i++) {
							t4money[i].setText("");
							t4info[i] = "";
							t4price[i] = "";
						}
					} else if (select == 5) {												//5�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[4] = 0;
						System.out.println("5�� ���̺��� " + money[4] + " ���� ���Ǿ����ϴ�.");
						tbtn[4].setText("�Լ� ����");
						tbtn[4].setBackground(Color.WHITE);
						tblabel2[4].setText("");
						money[4] = 0;
						for (int i = 0; i < 20; i++) {
							t5money[i].setText("");
							t5info[i] = "";
							t5price[i] = "";
						}
					} else if (select == 6) {												//6�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[5] = 0;
						System.out.println("6�� ���̺��� " + money[5] + " ���� ���Ǿ����ϴ�.");
						tbtn[5].setText("�Լ� ����");
						tbtn[5].setBackground(Color.WHITE);
						tblabel2[5].setText("");
						money[5] = 0;
						for (int i = 0; i < 20; i++) {
							t6money[i].setText("");
							t6info[i] = "";
							t6price[i] = "";
						}
					} else if (select == 7) {												//7�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[6] = 7;
						System.out.println("7�� ���̺��� " + money[6] + " ���� ���Ǿ����ϴ�.");
						tbtn[6].setText("�Լ� ����");
						tbtn[6].setBackground(Color.WHITE);
						tblabel2[6].setText("");
						money[6] = 0;
						for (int i = 0; i < 20; i++) {
							t7money[i].setText("");
							t7info[i] = "";
							t7price[i] = "";
						}
					} else if (select == 8) {												//8�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[7] = 0;
						System.out.println("8�� ���̺��� " + money[7] + " ���� ���Ǿ����ϴ�.");
						tbtn[7].setText("�Լ� ����");
						tbtn[7].setBackground(Color.WHITE);
						tblabel2[7].setText("");
						money[7] = 0;
						for (int i = 0; i < 20; i++) {
							t8money[i].setText("");
							t8info[i] = "";
							t8price[i] = "";
						}
					} else if (select == 9) {												//9�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[8] = 0;
						System.out.println("9�� ���̺��� " + money[8] + " ���� ���Ǿ����ϴ�.");
						tbtn[8].setText("�Լ� ����");
						tbtn[8].setBackground(Color.WHITE);
						tblabel2[8].setText("");
						money[8] = 0;
						for (int i = 0; i < 20; i++) {
							t9money[i].setText("");
							t9info[i] = "";
							t9price[i] = "";
						}
					} else if (select == 10) {												//10�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[9] = 10;
						System.out.println("10�� ���̺��� " + money[9] + " ���� ���Ǿ����ϴ�.");
						tbtn[9].setText("�Լ� ����");
						tbtn[9].setBackground(Color.WHITE);
						tblabel2[9].setText("");
						money[9] = 0;
						for (int i = 0; i < 20; i++) {
							t10money[i].setText("");
							t10info[i] = "";
							t10price[i] = "";
						}
					} else if (select == 11) {												//11�� Table�� ���õǾ��� ��  �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[10] = 0;
						System.out.println("11�� ���̺��� " + money[10] + " ���� ���Ǿ����ϴ�.");
						tbtn[10].setText("�Լ� ����");
						tbtn[10].setBackground(Color.WHITE);
						tblabel2[10].setText("");
						money[10] = 0;
						for (int i = 0; i < 20; i++) {
							t11money[i].setText("");
							t11info[i] = "";
							t11price[i] = "";
						}
					} else if (select == 12) {												//12�� Table�� ���õǾ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[11] = 0;
						System.out.println("12�� ���̺��� " + money[11] + " ���� ���Ǿ����ϴ�.");
						tbtn[11].setText("�Լ� ����");
						tbtn[11].setBackground(Color.WHITE);
						tblabel2[11].setText("");
						money[11] = 0;
						for (int i = 0; i < 20; i++) {
							t12money[i].setText("");
							t12info[i] = "";
							t12price[i] = "";
						}
					}
				}
			});
			
			south2.setBounds(30, 435, 400, 30);						//south2 boundary ����
			north.setBounds(10, 10, 360, 25);						//north boundary ����
			paybtn1.setBounds(60, 480, 117, 104);					//paybtn1 boundary ����
			paybtn2.setBounds(190, 480, 117, 104);					//paybtn2 boundary ����
			south2.setFont(new Font("GOOD", Font.BOLD, 16));		//south2 Font ����

			//�� ContentPane�� ����
			add(north);
			add(south2);
			add(paybtn1);
			add(paybtn2);
			paybtn1.setVisible(true);							//paybtn1�� Visible ������� ����
			paybtn2.setVisible(true);							//paybtn2�� Visible ������� ����
			setResizable(false);								//���������� �Ұ����ϰ� ����
			setSize(400, 650);									//������ ����
			setVisible(false);									//Visible ��� ����
		}
	}
	
	class SteakPanel extends JDialog {									//menu�� steak menu�� ���õ� ó���� �ϱ� ���� class
		SteakPanel() {													//SteakPanel ������
			steakimg steakimg = new steakimg();							//steak menu image�� ����ϱ� ���� steakimg ������ ȣ��
			Scanner sc = null;											//scanner �ʱ�ȭ
			try {
				sc = new Scanner(texts.steak(), "UTF-8");      			//steak.txt���� steak panel�� �ʿ��� ���� scan
			} catch (FileNotFoundException e1) {						//FileNotFoundException ���� ó��
				e1.printStackTrace();
			}
			
			setTitle("Menu - Steak");									//title ����
			getContentPane();											//���� �۵����� ContentPane ȣ��
			setLayout(null);											//���� ��� ��ġ������ ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);												//��� ����
			
			//steak menu�� ���������� ǥ���ϱ� ���� JLabel
			steaklabel[0] = new JLabel(steakimg.steak1img());			
			steaklabel[1] = new JLabel(steakimg.steak2img());
			steaklabel[2] = new JLabel(steakimg.steak3img());
			steaklabel[3] = new JLabel(steakimg.steak4img());
			steaklabel[4] = new JLabel(steakimg.steak5img());
			steaklabel[5] = new JLabel(steakimg.steak6img());
			steaklabel[6] = new JLabel(steakimg.steak7img());
			
			//steak menu�� ǥ���ϱ� ���� JLabel
			steakname[0] = new JLabel(sc.nextLine(), JLabel.CENTER);
			steakname[1] = new JLabel(sc.nextLine(), JLabel.CENTER);
			steakname[2] = new JLabel(sc.nextLine(), JLabel.CENTER);
			steakname[3] = new JLabel(sc.nextLine(), JLabel.CENTER);
			steakname[4] = new JLabel(sc.nextLine(), JLabel.CENTER);
			steakname[5] = new JLabel(sc.nextLine(), JLabel.CENTER);
			steakname[6] = new JLabel(sc.nextLine(), JLabel.CENTER);
			
			for (int i = 0; i < 7; i++) {
				steakorder[i] = new JButton(images.orderimg());			//�ֹ� ��û�� ó���ϱ� ���� JButton
				steakname[i].setForeground(Color.BLACK);				//steakname�� �� ����
				steakorder[i].addActionListener(new SteakAction());		//steakorder�� ActionListener ����
				//�� ContentPane�� ����
				stkpic.add(steaklabel[i]);
				stkpic.add(steakname[i]);
				stkpic.add(steakorder[i]);

			}
			
			//steaklabel boundary ����
			steaklabel[0].setBounds(10, 50, 196, 126);
			steaklabel[1].setBounds(260, 50, 196, 126);
			steaklabel[2].setBounds(510, 50, 196, 126);
			steaklabel[3].setBounds(10, 260, 196, 126);
			steaklabel[4].setBounds(260, 260, 196, 126);
			steaklabel[5].setBounds(510, 260, 196, 126);
			steaklabel[6].setBounds(10, 470, 196, 126);

			//steakname boundary ����
			steakname[0].setBounds(10, 190, 196, 20);
			steakname[1].setBounds(260, 190, 196, 20);
			steakname[2].setBounds(510, 190, 196, 20);
			steakname[3].setBounds(10, 400, 196, 20);
			steakname[4].setBounds(260, 400, 196, 20);
			steakname[5].setBounds(510, 400, 196, 20);
			steakname[6].setBounds(10, 610, 196, 20);

			//steakorder boundary ����
			steakorder[0].setBounds(50, 212, 116, 35);
			steakorder[1].setBounds(300, 212, 116, 35);
			steakorder[2].setBounds(550, 212, 116, 35);
			steakorder[3].setBounds(50, 422, 116, 35);
			steakorder[4].setBounds(300, 422, 116, 35);
			steakorder[5].setBounds(550, 422, 116, 35);
			steakorder[6].setBounds(50, 632, 116, 35);
			stkpic.setBounds(0, 0, 750, 690);
			
			add(stkpic);				//stkpic ����
			setSize(750, 730);			//������ ����
			setLocation(165, 100);		//��ġ ����
			setResizable(false);		//���������� �Ұ����ϰ� ����
			setVisible(false);			//Visible ��� ����
		}

		class SteakAction implements ActionListener { 													//�ֹ���û�� ó�� �ϱ� ���� class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == steakorder[0]) {													//�߰����� ������ũ�� ���õǾ��� ��
					if (select == 1) {																	//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;																//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�߰����� ������ũ";												//������ �޴� �߰�
						t1price[num[0]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 2) {															//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�															//�Ѿ׿� ������ �� �߰�   															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "�߰����� ������ũ";												//������ �޴� �߰�
						t2price[num[1]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 3) {															//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�߰����� ������ũ";												//������ �޴� �߰�
						t3price[num[2]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 4) {															//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�߰����� ������ũ";												//������ �޴� �߰�
						t4price[num[3]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 5) {															//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�߰����� ������ũ";												//������ �޴� �߰�
						t1price[num[4]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 6) {															//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�߰����� ������ũ";												//������ �޴� �߰�
						t6price[num[5]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 7) {															//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�߰����� ������ũ";												//������ �޴� �߰�
						t7price[num[6]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 8) {															//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�߰����� ������ũ";												//������ �޴� �߰�
						t8price[num[7]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 9) {															//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�߰����� ������ũ";												//������ �޴� �߰�
						t9price[num[8]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 10) {															//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�߰����� ������ũ";												//������ �޴� �߰�
						t10price[num[9]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "�߰����� ������ũ";												//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�߰����� ������ũ";												//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == steakorder[1]) {											//��� ������ũ�� ���õǾ��� ��
					if (select == 1) {																	//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;																//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "��� ������ũ";													//������ �޴� �߰�
						t1price[num[0]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																		//�� �ֹ����� ����
					} else if (select == 2) {															//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "��� ������ũ";													//������ �޴� �߰�
						t2price[num[1]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 3) {															//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "��� ������ũ";													//������ �޴� �߰�
						t3price[num[2]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 4) {															//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "��� ������ũ";													//������ �޴� �߰�
						t4price[num[3]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[0]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 5) {															//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "��� ������ũ";													//������ �޴� �߰�
						t5price[num[4]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 6) {															//6�� Table�� ���õǾ��ٸ�			
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "��� ������ũ";													//������ �޴� �߰�
						t6price[num[5]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 7) {															//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "��� ������ũ";													//������ �޴� �߰�
						t7price[num[6]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[0]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 8) {															//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t1info[num[7]] = "��� ������ũ";													//������ �޴� �߰�
						t8price[num[7]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 9) {															//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "��� ������ũ";													//������ �޴� �߰�
						t9price[num[8]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 10) {															//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "��� ������ũ";													//������ �޴� �߰�
						t10price[num[9]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "��� ������ũ";													//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "��� ������ũ";													//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == steakorder[2]) {											//�����̽� ������ũ�� ���õǾ��� ��
					if (select == 1) {																	//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;																//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�����̽� ������ũ";												//������ �޴� �߰�
						t1price[num[0]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																		//�� �ֹ����� ����
					} else if (select == 2) {															//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "�����̽� ������ũ";												//������ �޴� �߰�
						t2price[num[1]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 3) {															//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�����̽� ������ũ";												//������ �޴� �߰�
						t3price[num[2]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 4) {															//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�����̽� ������ũ";												//������ �޴� �߰�
						t4price[num[3]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 5) {															//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�����̽� ������ũ";												//������ �޴� �߰�
						t5price[num[4]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 6) {															//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�����̽� ������ũ";												//������ �޴� �߰�
						t6price[num[5]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 7) {															//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�����̽� ������ũ";												//������ �޴� �߰�
						t7price[num[6]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 8) {															//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�����̽� ������ũ";												//������ �޴� �߰�
						t8price[num[7]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 9) {															//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�����̽� ������ũ";												//������ �޴� �߰�
						t9price[num[8]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 10) {															//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�����̽� ������ũ";												//������ �޴� �߰�
						t10price[num[9]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "�����̽� ������ũ";												//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�����̽� ������ũ";												//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == steakorder[3]) {											//�ߴٸ��� ������ũ�� ���õǾ��� ��
					if (select == 1) {																	//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;																//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�ߴٸ��� ������ũ";												//������ �޴� �߰�
						t1price[num[0]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																		//�� �ֹ����� ����
					} else if (select == 2) {															//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "�ߴٸ��� ������ũ";												//������ �޴� �߰�
						t2price[num[1]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 3) {															//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�ߴٸ��� ������ũ";												//������ �޴� �߰�
						t3price[num[2]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 4) {															//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�ߴٸ��� ������ũ";												//������ �޴� �߰�
						t4price[num[3]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 5) {															//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�ߴٸ��� ������ũ";												//������ �޴� �߰�
						t5price[num[4]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 6) {															//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�ߴٸ��� ������ũ";												//������ �޴� �߰�
						t6price[num[5]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 7) {															//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�ߴٸ��� ������ũ";												//������ �޴� �߰�
						t7price[num[6]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 8) {															//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�ߴٸ��� ������ũ";												//������ �޴� �߰�
						t8price[num[7]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[8]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 9) {															//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�ߴٸ��� ������ũ";												//������ �޴� �߰�
						t9price[num[8]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 10) {															//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�ߴٸ��� ������ũ";												//������ �޴� �߰�
						t10price[num[9]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t11info[num[0]] = "�ߴٸ��� ������ũ";												//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�ߴٸ��� ������ũ";												//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == steakorder[4]) {											//���� ������ũ�� ���õǾ��� ��
					if (select == 1) {																	//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;																//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "���� ������ũ";													//������ �޴� �߰�
						t1price[num[0]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																		//�� �ֹ����� ����
					} else if (select == 2) {															//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "���� ������ũ";													//������ �޴� �߰�
						t2price[num[1]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 3) {															//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "���� ������ũ";													//������ �޴� �߰�
						t3price[num[2]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 4) {															//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�	
						t4info[num[3]] = "���� ������ũ";													//������ �޴� �߰�
						t4price[num[3]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 5) {															//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "���� ������ũ";													//������ �޴� �߰�
						t5price[num[4]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 6) {															//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�	
						t6info[num[5]] = "���� ������ũ";													//������ �޴� �߰�
						t6price[num[5]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 7) {															//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "���� ������ũ";													//������ �޴� �߰�
						t7price[num[6]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 8) {															//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "���� ������ũ";													//������ �޴� �߰�
						t8price[num[7]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 9) {															//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "���� ������ũ";													//������ �޴� �߰�
						t9price[num[8]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 10) {															//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "���� ������ũ";													//������ �޴� �߰�
						t10price[num[9]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "���� ������ũ";												//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t1info[num[11]] = "���� ������ũ";													//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == steakorder[5]) {											//���� ������ũ�� ���õǾ��� ��
					if (select == 1) {																	//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;																//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "���� ������ũ";													//������ �޴� �߰�
						t1price[num[0]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																		//�� �ֹ����� ����
					} else if (select == 2) {															//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "���� ������ũ";													//������ �޴� �߰�
						t2price[num[1]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 3) {															//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "���� ������ũ";													//������ �޴� �߰�
						t3price[num[2]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 4) {															//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "���� ������ũ";													//������ �޴� �߰�
						t4price[num[3]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 5) {															//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "���� ������ũ";													//������ �޴� �߰�
						t5price[num[4]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 6) {															//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "���� ������ũ";													//������ �޴� �߰�
						t6price[num[5]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 7) {															//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "���� ������ũ";													//������ �޴� �߰�
						t7price[num[6]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 8) {															//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "���� ������ũ";													//������ �޴� �߰�
						t8price[num[7]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 9) {															//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "���� ������ũ";													//������ �޴� �߰�
						t9price[num[8]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 10) {															//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "���� ������ũ";													//������ �޴� �߰�
						t10price[num[9]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "���� ������ũ";													//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "���� ������ũ";													//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == steakorder[6]) {											//������ ������ũ�� ���õǾ��� ��
					if (select == 1) {																	//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;																//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "������ ������ũ";													//������ �޴� �߰�
						t1price[num[0]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																		//�� �ֹ����� ����
					} else if (select == 2) {															//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "������ ������ũ";													//������ �޴� �߰�
						t2price[num[1]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 3) {															//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "������ ������ũ";													//������ �޴� �߰�
						t3price[num[2]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 4) {															//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "������ ������ũ";													//������ �޴� �߰�
						t4price[num[3]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 5) {															//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "������ ������ũ";													//������ �޴� �߰�
						t5price[num[4]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 6) {															//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "������ ������ũ";													//������ �޴� �߰�
						t6price[num[5]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 7) {															//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "������ ������ũ";													//������ �޴� �߰�
						t7price[num[6]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 8) {															//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "������ ������ũ";													//������ �޴� �߰�
						t8price[num[7]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 9) {															//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "������ ������ũ";													//������ �޴� �߰�
						t9price[num[8]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 10) {															//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "������ ������ũ";													//������ �޴� �߰�
						t10price[num[9]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "������ ������ũ";												//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;															//�Ѿ׿� ������ �� �߰�																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "������ ������ũ";												//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����																		//�� �ֹ����� ����
					}
				}
			}
		}
	}

	class PastaPanel extends JDialog {									//menu�� pasta menu�� ���õ� ó���� �ϱ� ���� class
		PastaPanel() {													//PastaPanel ������
			pastaimg pastaimg = new pastaimg();							//Pasta image�� ����ϱ� ���� pastaimg ������ ȣ��
			Scanner sc = null;											//scanner �ʱ�ȭ
			try {
				sc = new Scanner(texts.pasta(), "UTF-8");      			//pasta.txt���� pasta panel�� �ʿ��� ���� scan
			} catch (FileNotFoundException e1) {						//FileNotFoundException ���� ó��
				e1.printStackTrace();
			}
			
			setTitle("Menu - Pasta");									//title ����
			getContentPane();											//���� �۵����� ContentPane ȣ��
			setLayout(null);											//���� ��� ��ġ������ ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);												//��� ����
			
			//pasta menu�� ���������� ǥ���ϱ� ���� JLabel
			pastalabel[0] = new JLabel(pastaimg.pasta1img());
			pastalabel[1] = new JLabel(pastaimg.pasta2img());
			pastalabel[2] = new JLabel(pastaimg.pasta3img());
			pastalabel[3] = new JLabel(pastaimg.pasta4img());
			pastalabel[4] = new JLabel(pastaimg.pasta5img());
			pastalabel[5] = new JLabel(pastaimg.pasta6img());
			pastalabel[6] = new JLabel(pastaimg.pasta7img());
			pastalabel[7] = new JLabel(pastaimg.pasta8img());
			pastalabel[8] = new JLabel(pastaimg.pasta9img());
			pastalabel[9] = new JLabel(pastaimg.pasta10img());
			
			//pasta menu�� ǥ���ϱ� ���� JLabel
			pastaname[0] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pastaname[1] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pastaname[2] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pastaname[3] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pastaname[4] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pastaname[5] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pastaname[6] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pastaname[7] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pastaname[8] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pastaname[9] = new JLabel(sc.nextLine(), JLabel.CENTER);

			for (int i = 0; i < 10; i++) {
				pastaorder[i] = new JButton(images.orderimg());			//�ֹ� ��û�� ó���ϱ� ���� JButton
				pastaname[i].setForeground(Color.BLACK);				//pastaname�� �� ����
				//�� ContentPane�� ����
				pstpic.add(pastalabel[i]);								
				pstpic.add(pastaname[i]);
				pstpic.add(pastaorder[i]);
				pastaorder[i].addActionListener(new PastaAction());		//pastaorder�� ActionListener ����
			}
			
			//pastalabel boundary ����
			pastalabel[0].setBounds(10, 50, 168, 108);
			pastalabel[1].setBounds(195, 50, 168, 108);
			pastalabel[2].setBounds(375, 50, 168, 108);
			pastalabel[3].setBounds(555, 50, 168, 108);
			pastalabel[4].setBounds(10, 250, 168, 108);
			pastalabel[5].setBounds(195, 250, 168, 108);
			pastalabel[6].setBounds(375, 250, 168, 108);
			pastalabel[7].setBounds(555, 250, 168, 108);
			pastalabel[8].setBounds(10, 460, 168, 108);
			pastalabel[9].setBounds(195, 460, 168, 108);

			//pastaname boundary ����
			pastaname[0].setBounds(10, 160, 175, 20);
			pastaname[1].setBounds(195, 160, 175, 20);
			pastaname[2].setBounds(375, 160, 175, 20);
			pastaname[3].setBounds(555, 160, 175, 20);
			pastaname[4].setBounds(10, 360, 175, 20);
			pastaname[5].setBounds(195, 360, 175, 20);
			pastaname[6].setBounds(375, 360, 175, 20);
			pastaname[7].setBounds(555, 360, 175, 20);
			pastaname[8].setBounds(10, 570, 175, 20);
			pastaname[9].setBounds(195, 570, 175, 20);

			//pastaorder boundary ����
			pastaorder[0].setBounds(40, 190, 116, 30);
			pastaorder[1].setBounds(220, 190, 116, 30);
			pastaorder[2].setBounds(400, 190, 116, 30);
			pastaorder[3].setBounds(585, 190, 116, 30);
			pastaorder[4].setBounds(40, 390, 116, 30);
			pastaorder[5].setBounds(220, 390, 116, 30);
			pastaorder[6].setBounds(400, 390, 116, 30);
			pastaorder[7].setBounds(585, 390, 116, 30);
			pastaorder[8].setBounds(40, 600, 116, 30);
			pastaorder[9].setBounds(220, 600, 116, 30);

			pstpic.setBounds(0, 0, 750, 690);				//pstpic boundary ����
			add(pstpic);									//pstpic ����
			setLocation(165, 100);							//��ġ ����
			setSize(750, 690);								//������ ����
			setResizable(false);							//���������� �Ұ����ϰ� ����
			setVisible(false);								//Visible ��� ����
		}

		class PastaAction implements ActionListener {												//�ֹ���û�� ó�� �ϱ� ���� class
			public void actionPerformed(ActionEvent e) { 	
				if (e.getSource() == pastaorder[0]) {												//�ӽ��� ġŲ �Ľ�Ÿ�� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�ӽ��� ġŲ �Ľ�Ÿ";											//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�	
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "�ӽ��� ġŲ �Ľ�Ÿ";											//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�ӽ��� ġŲ �Ľ�Ÿ";											//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�	
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�ӽ��� ġŲ �Ľ�Ÿ";											//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�	
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�ӽ��� ġŲ �Ľ�Ÿ";											//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�		
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�ӽ��� ġŲ �Ľ�Ÿ";											//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�	
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�ӽ��� ġŲ �Ľ�Ÿ";											//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�		
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�ӽ��� ġŲ �Ľ�Ÿ";											//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�		
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�ӽ��� ġŲ �Ľ�Ÿ";											//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�		
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�ӽ��� ġŲ �Ľ�Ÿ";											//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {														//11�� Table�� ���õǾ��ٸ�		
						money[10] += 19800;															//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "�ӽ��� ġŲ �Ľ�Ÿ";											//������ �޴� �߰�
						t11price[num[10]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																	//�� �ֹ����� ����
					} else if (select == 12) {														//12�� Table�� ���õǾ��ٸ�		
						money[11] += 19800;															//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�ӽ��� ġŲ �Ľ�Ÿ";											//������ �޴� �߰�
						t12price[num[11]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																	//�� �ֹ����� ����
					}
				} else if (e.getSource() == pastaorder[1]) { 										//�ӽ��� ��Ǫ�� �Ľ�Ÿ�� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�	
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�ӽ��� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�	
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�								
						t2info[num[1]] = "�ӽ��� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�ӽ��� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�ӽ��� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�	
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�ӽ��� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�	
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�ӽ��� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�	
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�ӽ��� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�	
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�ӽ��� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�	
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�ӽ��� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�	
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�ӽ��� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																		//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�	
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "�ӽ��� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�	
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�ӽ��� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pastaorder[2]) {										//��Ʈ �丶�� �Ľ�Ÿ�� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "��Ʈ �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�		
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�		
						t2info[num[1]] = "��Ʈ �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�	
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "��Ʈ �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�		
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "��Ʈ �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�		
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "��Ʈ �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�	
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "��Ʈ �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�		
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "��Ʈ �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�		
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "��Ʈ �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�		
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "��Ʈ �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�		
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "��Ʈ �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�	
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "��Ʈ �丶�� �Ľ�Ÿ";												//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�	
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "��Ʈ �丶�� �Ľ�Ÿ";												//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pastaorder[3]) {										//������� �Ľ�Ÿ�� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "������� �Ľ�Ÿ";											//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�	
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�							
						t2info[num[1]] = "������� �Ľ�Ÿ";											//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�	
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "������� �Ľ�Ÿ";											//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "������� �Ľ�Ÿ";											//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�	
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "������� �Ľ�Ÿ";											//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "������� �Ľ�Ÿ";											//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�	
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "������� �Ľ�Ÿ";											//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�	
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "������� �Ľ�Ÿ";											//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�	
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "������� �Ľ�Ÿ";											//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�	
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "������� �Ľ�Ÿ";											//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�	
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "������� �Ľ�Ÿ";												//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�	
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "������� �Ľ�Ÿ";												//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pastaorder[4]) {										//������ ũ�� �Ľ�Ÿ�� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "������ ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�		
						t2info[num[1]] = "������ ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "������ ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "������ ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "������ ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "������ ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "������ ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "������ ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "������ ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "������ ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "������ ũ�� �Ľ�Ÿ";												//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "������ ũ�� �Ľ�Ÿ";												//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pastaorder[5]) {										//������ �Ľ�Ÿ�� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "������ �Ľ�Ÿ";												//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�														
						t2info[num[1]] = "������ �Ľ�Ÿ";												//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "������ �Ľ�Ÿ";												//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "������ �Ľ�Ÿ";												//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "������ �Ľ�Ÿ";												//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "������ �Ľ�Ÿ";												//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "������ �Ľ�Ÿ";												//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "������ �Ľ�Ÿ";												//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "������ �Ľ�Ÿ";												//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "������ �Ľ�Ÿ";												//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "������ �Ľ�Ÿ";													//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "������ �Ľ�Ÿ";													//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}	
				} else if (e.getSource() == pastaorder[6]) {										//�����̽� ��Ǫ�� �Ľ�Ÿ�� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�����̽� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�															
						t2info[num[1]] = "�����̽� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�����̽� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�����̽� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�����̽� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�����̽� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�����̽� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�����̽� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�����̽� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�����̽� ��Ǫ�� �Ľ�Ÿ";										//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "�����̽� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�����̽� ��Ǫ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pastaorder[7]) {										//��Ǫ�� �丶�� �Ľ�Ÿ�� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "��Ǫ�� �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�															
						t2info[num[1]] = "��Ǫ�� �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "��Ǫ�� �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "��Ǫ�� �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "��Ǫ�� �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "��Ǫ�� �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "��Ǫ�� �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "��Ǫ�� �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "��Ǫ�� �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "��Ǫ�� �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "��Ǫ�� �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "��Ǫ�� �丶�� �Ľ�Ÿ";											//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pastaorder[8]) {										//��Ǫ�� �ø��� �Ľ�Ÿ�� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "��Ǫ�� �ø��� �Ľ�Ÿ";											//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�														
						t2info[num[1]] = "��Ǫ�� �ø��� �Ľ�Ÿ";											//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "��Ǫ�� �ø��� �Ľ�Ÿ";											//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "��Ǫ�� �ø��� �Ľ�Ÿ";											//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "��Ǫ�� �ø��� �Ľ�Ÿ";											//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "��Ǫ�� �ø��� �Ľ�Ÿ";											//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "��Ǫ�� �ø��� �Ľ�Ÿ";											//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "��Ǫ�� �ø��� �Ľ�Ÿ";											//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "��Ǫ�� �ø��� �Ľ�Ÿ";											//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "��Ǫ�� �ø��� �Ľ�Ÿ";											//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "��Ǫ�� �ø��� �Ľ�Ÿ";											//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "��Ǫ�� �ø��� �Ľ�Ÿ";											//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pastaorder[9]) {										//��Ǫ�� ũ�� �Ľ�Ÿ�� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "��Ǫ�� ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�														
						t2info[num[1]] = "��Ǫ�� ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "��Ǫ�� ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "��Ǫ�� ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "��Ǫ�� ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "��Ǫ�� ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "��Ǫ�� ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "��Ǫ�� ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "��Ǫ�� ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "��Ǫ�� ũ�� �Ľ�Ÿ";											//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "��Ǫ�� ũ�� �Ľ�Ÿ";												//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "��Ǫ�� ũ�� �Ľ�Ÿ";												//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} 
			}
		}
	}

	class PilafPanel extends JDialog {									//menu�� pilaf menu�� ���õ� ó���� �ϱ� ���� class
		PilafPanel() {													//PilafPanel ������ ȣ��
			pilafimg pilafimg = new pilafimg();							//pilaf image�� ����ϱ� ���� pilafimg ������ ȣ��
			Scanner sc = null;											//scanner �ʱ�ȭ
			try {
				sc = new Scanner(texts.pilaf(), "UTF-8");      			//pilaf.txt���� steak panel�� �ʿ��� ���� scan
			} catch (FileNotFoundException e1) {						//FileNotFoundException ���� ó��
				e1.printStackTrace();
			}
			setTitle("Menu - Pilaf");									//title ����
			getContentPane();											//���� �۵����� ContentPane ȣ��
			setLayout(null);											//���� ��� ��ġ������ ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);												//��� ����
			
			//pilaf menu�� ���������� ǥ���ϱ� ���� JLabel
			pilaflabel[0] = new JLabel(pilafimg.pilaf1img());
			pilaflabel[1] = new JLabel(pilafimg.pilaf2img());
			pilaflabel[2] = new JLabel(pilafimg.pilaf3img());
			pilaflabel[3] = new JLabel(pilafimg.pilaf4img());
			
			//pilaf menu�� ǥ���ϱ� ���� JLabel
			pilafname[0] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pilafname[1] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pilafname[2] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pilafname[3] = new JLabel(sc.nextLine(), JLabel.CENTER);
			
			
			for (int i = 0; i < 4; i++) {
				pilaforder[i] = new JButton(images.orderimg());			//�ֹ� ��û�� ó���ϱ� ���� JButton
				pilafname[i].setForeground(Color.BLACK);				//pilafname�� �� ����
				//�� ContentPane�� ����
				pilpic.add(pilaflabel[i]);
				pilpic.add(pilafname[i]);
				pilpic.add(pilaforder[i]);
				pilaforder[i].addActionListener(new PilafAction());		//pilaforder�� ActionListener ����
			}
			
			//pilaflabel boundary ����
			pilaflabel[0].setBounds(10, 50, 168, 108);
			pilaflabel[1].setBounds(195, 50, 168, 108);
			pilaflabel[2].setBounds(375, 50, 168, 108);
			pilaflabel[3].setBounds(555, 50, 168, 108);

			//pilafname boundary ����
			pilafname[0].setBounds(10, 160, 175, 20);
			pilafname[1].setBounds(195, 160, 175, 20);
			pilafname[2].setBounds(375, 160, 175, 20);
			pilafname[3].setBounds(555, 160, 175, 20);

			//pilaforder boundary ����
			pilaforder[0].setBounds(40, 190, 116, 30);
			pilaforder[1].setBounds(220, 190, 116, 30);
			pilaforder[2].setBounds(400, 190, 116, 30);
			pilaforder[3].setBounds(580, 190, 116, 30);
			pilpic.setBounds(0, 0, 750, 690);
			
			add(pilpic);				//pilpic ����
			setLocation(165, 100);		//��ġ ����
			setResizable(false);		//���������� �Ұ����ϰ� ����
			setSize(750, 690);			//������ ����
			setVisible(false);			//Visible ��� ����
		}

		class PilafAction implements ActionListener { 												//�ֹ���û�� ó�� �ϱ� ���� class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == pilaforder[0]) {												//��ġ �ʶ����� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "��ġ �ʶ���";													//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�														
						t2info[num[1]] = "��ġ �ʶ���";													//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "��ġ �ʶ���";													//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "��ġ �ʶ���";													//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "��ġ �ʶ���";													//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "��ġ �ʶ���";													//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "��ġ �ʶ���";													//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "��ġ �ʶ���";													//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "��ġ �ʶ���";													//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "��ġ �ʶ���";												//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "��ġ �ʶ���";													//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "��ġ �ʶ���";													//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pilaforder[1]) {										//��� �ʶ����� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "��� �ʶ���";													//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "��� �ʶ���";													//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "��� �ʶ���";													//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "��� �ʶ���";													//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "��� �ʶ���";													//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "��� �ʶ���";													//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "��� �ʶ���";													//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "��� �ʶ���";													//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "��� �ʶ���";													//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "��� �ʶ���";												//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "��� �ʶ���";													//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "��� �ʶ���";													//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pilaforder[2]) {										//������ �ʶ����� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "������ �ʶ���";												//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�									
						t2info[num[1]] = "������ �ʶ���";												//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "������ �ʶ���";												//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "������ �ʶ���";												//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "������ �ʶ���";												//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "������ �ʶ���";												//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "������ �ʶ���";												//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "������ �ʶ���";												//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "������ �ʶ���";												//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "������ �ʶ���";												//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "������ �ʶ���";													//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "������ �ʶ���";													//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pilaforder[3]) {										//���� �ʶ����� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "���� �ʶ���";													//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�															
						t2info[num[1]] = "���� �ʶ���";													//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "���� �ʶ���";													//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "���� �ʶ���";													//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "���� �ʶ���";													//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "���� �ʶ���";													//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "���� �ʶ���";													//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "���� �ʶ���";													//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "���� �ʶ���";													//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "���� �ʶ���";												//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "���� �ʶ���";													//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "���� �ʶ���";													//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				}
			}
		}
	}

	class PizzaPanel extends JDialog {								//menu�� pizza menu�� ���õ� ó���� �ϱ� ���� class
		PizzaPanel() {												//PizzaPanel ������
			pizzaimg pizzaimg = new pizzaimg();						//pizza image�� ����ϱ� ���� pizzaimg ������ ȣ��
			Scanner sc = null;										//scanner �ʱ�ȭ
			try {
				sc = new Scanner(texts.pizza(), "UTF-8");      		//pizza.txt���� pizza panel�� �ʿ��� ���� scan
			} catch (FileNotFoundException e1) {					//FileNotFoundException ���� ó��
				e1.printStackTrace();
			}
			
			setTitle("Menu - Pizza");								//title ����
			getContentPane();										//���� �۵����� ContentPane ȣ��
			setLayout(null);										//���� ��� ��ġ������ ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);											//��� ����
			
			//pizza menu�� ���������� ǥ���ϱ� ���� JLabel
			pizzalabel[0] = new JLabel(pizzaimg.pizza1img());
			pizzalabel[1] = new JLabel(pizzaimg.pizza2img());
			pizzalabel[2] = new JLabel(pizzaimg.pizza3img());
			pizzalabel[3] = new JLabel(pizzaimg.pizza4img());
			pizzalabel[4] = new JLabel(pizzaimg.pizza5img());
			pizzalabel[5] = new JLabel(pizzaimg.pizza6img());
			pizzalabel[6] = new JLabel(pizzaimg.pizza7img());
			pizzalabel[7] = new JLabel(pizzaimg.pizza8img());
			pizzalabel[8] = new JLabel(pizzaimg.pizza9img());

			//pizza menu�� ǥ���ϱ� ���� JLabel
			pizzaname[0] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pizzaname[1] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pizzaname[2] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pizzaname[3] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pizzaname[4] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pizzaname[5] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pizzaname[6] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pizzaname[7] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pizzaname[8] = new JLabel(sc.nextLine(), JLabel.CENTER);

			for (int i = 0; i < 9; i++) {
				pizzaorder[i] = new JButton(images.orderimg());			//�ֹ� ��û�� ó���ϱ� ���� JButton
				pizzaname[i].setForeground(Color.BLACK);				//pizzaname�� �� ����
				pizzaorder[i].addActionListener(new PizzaAction());		//pizzaorder�� ActionListener ����
				//�� ContentPane�� ����
				pizpic.add(pizzalabel[i]);
				pizpic.add(pizzaname[i]);
				pizpic.add(pizzaorder[i]);
			}

			//pizzalabel boundary ����
			pizzalabel[0].setBounds(10, 50, 196, 126);
			pizzalabel[1].setBounds(260, 50, 196, 126);
			pizzalabel[2].setBounds(510, 50, 196, 126);
			pizzalabel[3].setBounds(10, 260, 196, 126);
			pizzalabel[4].setBounds(260, 260, 196, 126);
			pizzalabel[5].setBounds(510, 260, 196, 126);
			pizzalabel[6].setBounds(10, 470, 196, 126);
			pizzalabel[7].setBounds(260, 470, 196, 126);
			pizzalabel[8].setBounds(510, 470, 196, 126);

			//pizzaname boundary ����
			pizzaname[0].setBounds(10, 190, 196, 20);
			pizzaname[1].setBounds(260, 190, 196, 20);
			pizzaname[2].setBounds(510, 190, 196, 20);
			pizzaname[3].setBounds(10, 400, 196, 20);
			pizzaname[4].setBounds(260, 400, 196, 20);
			pizzaname[5].setBounds(510, 400, 196, 20);
			pizzaname[6].setBounds(10, 610, 196, 20);
			pizzaname[7].setBounds(260, 610, 196, 20);
			pizzaname[8].setBounds(510, 610, 196, 20);

			//pizzaorder boundary ����
			pizzaorder[0].setBounds(50, 212, 116, 35);
			pizzaorder[1].setBounds(300, 212, 116, 35);
			pizzaorder[2].setBounds(550, 212, 116, 35);
			pizzaorder[3].setBounds(50, 422, 116, 35);
			pizzaorder[4].setBounds(300, 422, 116, 35);
			pizzaorder[5].setBounds(550, 422, 116, 35);
			pizzaorder[6].setBounds(50, 632, 116, 35);
			pizzaorder[7].setBounds(300, 632, 116, 35);
			pizzaorder[8].setBounds(550, 632, 116, 35);
			pizpic.setBounds(0, 0, 750, 690);			//pizpic boundary ����
			
			add(pizpic);				//pizpic ����
			setSize(750, 750);			//������ ����
			setLocation(165, 100);		//��ġ ����
			setResizable(false);		//���������� �Ұ����ϰ� ����
			setVisible(false);			//Visible ��� ����
		}

		class PizzaAction implements ActionListener { 												//�ֹ���û�� ó�� �ϱ� ���� class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == pizzaorder[0]) {												//�������� ���ڸ� �������� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 9800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�������� ����";												//������ �޴� �߰�
						t1price[num[0]] = " 9.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 9800;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "�������� ����";												//������ �޴� �߰�
						t2price[num[1]] = " 9.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 9800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�������� ����";												//������ �޴� �߰�
						t3price[num[2]] = " 9.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 9800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�������� ����";												//������ �޴� �߰�
						t4price[num[3]] = " 9.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 9800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�������� ����";												//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 9800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�������� ����";												//������ �޴� �߰�
						t6price[num[5]] = " 9.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 9800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�������� ����";												//������ �޴� �߰�
						t7price[num[6]] = " 9.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 9800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�������� ����";												//������ �޴� �߰�
						t8price[num[7]] = " 9.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 9800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�������� ����";												//������ �޴� �߰�
						t9price[num[8]] = " 9.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 9800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�������� ����";												//������ �޴� �߰�
						t10price[num[9]] = " 9.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 9800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "�������� ����";												//������ �޴� �߰�
						t11price[num[10]] = " 9.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 9800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�������� ����";												//������ �޴� �߰�
						t12price[num[11]] = " 9.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pizzaorder[1]) {										//���ް��� ���ڸ� �������� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "���ް��� ����";												//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�														
						t2info[num[1]] = "���ް��� ����";												//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "���ް��� ����";												//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "���ް��� ����";												//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "���ް��� ����";												//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "���ް��� ����";												//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "���ް��� ����";												//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "���ް��� ����";												//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "���ް��� ����";												//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "���ް��� ����";												//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "���ް��� ����";													//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "���ް��� ����";													//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pizzaorder[2]) {										//�����Ʈ ���ڰ� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 14800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�����Ʈ ����";												//������ �޴� �߰�
						t1price[num[0]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 14800;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "�����Ʈ ����";												//������ �޴� �߰�
						t2price[num[1]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 14800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�����Ʈ ����";												//������ �޴� �߰�
						t3price[num[2]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 14800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�����Ʈ ����";												//������ �޴� �߰�
						t4price[num[3]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 14800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�����Ʈ ����";												//������ �޴� �߰�
						t5price[num[4]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 14800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�����Ʈ ����";												//������ �޴� �߰�
						t6price[num[5]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 14800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�����Ʈ ����";												//������ �޴� �߰�
						t7price[num[6]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 14800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�����Ʈ ����";												//������ �޴� �߰�
						t8price[num[7]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 14800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�����Ʈ ����";												//������ �޴� �߰�
						t9price[num[8]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 14800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�����Ʈ ����";												//������ �޴� �߰�
						t10price[num[9]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 14800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "�����Ʈ ����";													//������ �޴� �߰�
						t11price[num[10]] = " 14.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 14800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�����Ʈ ����";													//������ �޴� �߰�
						t12price[num[11]] = " 14.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pizzaorder[3]) {										//������������ ���ڰ� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 14800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "������������ ����";											//������ �޴� �߰�
						t1price[num[0]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 14800;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "������������ ����";											//������ �޴� �߰�
						t2price[num[1]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 14800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "������������ ����";											//������ �޴� �߰�
						t3price[num[2]] = " 14.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 14800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "������������ ����";											//������ �޴� �߰�
						t4price[num[3]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 14800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "������������ ����";											//������ �޴� �߰�
						t5price[num[4]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 14800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "������������ ����";											//������ �޴� �߰�
						t6price[num[5]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 14800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "������������ ����";											//������ �޴� �߰�
						t7price[num[6]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 14800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "������������ ����";											//������ �޴� �߰�
						t8price[num[7]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 14800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "������������ ����";											//������ �޴� �߰�
						t9price[num[8]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 14800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "������������ ����";											//������ �޴� �߰�
						t10price[num[9]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 14800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "������������ ����";												//������ �޴� �߰�
						t11price[num[10]] = " 14.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 14800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "������������ ����";												//������ �޴� �߰�
						t12price[num[11]] = " 14.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pizzaorder[4]) {										//�Ұ��� ���ڰ� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�Ұ��� ����";												//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�	
						t2info[num[1]] = "�Ұ��� ����";												//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�Ұ��� ����";												//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�Ұ��� ����";												//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�Ұ��� ����";												//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�Ұ��� ����";												//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�Ұ��� ����";												//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�Ұ��� ����";												//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�Ұ��� ����";												//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�Ұ��� ����";												//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "�Ұ��� ����";													//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�Ұ��� ����";													//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pizzaorder[5]) {										//������ũ������ ���ڰ� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 14800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "������ũ������ ����";											//������ �޴� �߰�
						t1price[num[0]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 14800;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "������ũ������ ����";											//������ �޴� �߰�
						t2price[num[1]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 14800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "������ũ������ ����";											//������ �޴� �߰�
						t3price[num[2]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 14800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "������ũ������ ����";											//������ �޴� �߰�
						t4price[num[3]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 14800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "������ũ������ ����";											//������ �޴� �߰�
						t5price[num[4]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 14800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "������ũ������ ����";											//������ �޴� �߰�
						t6price[num[5]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 14800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "������ũ������ ����";											//������ �޴� �߰�
						t7price[num[6]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 14800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "������ũ������ ����";											//������ �޴� �߰�
						t8price[num[7]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 14800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "������ũ������ ����";											//������ �޴� �߰�
						t9price[num[8]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 14800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "������ũ������ ����";											//������ �޴� �߰�
						t10price[num[9]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 14800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "������ũ������ ����";												//������ �޴� �߰�
						t11price[num[10]] = " 14.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 14800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "������ũ������ ����";												//������ �޴� �߰�
						t12price[num[11]] = " 14.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pizzaorder[6]) {										//���ڶ� ���ڰ� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 13800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "���ڶ� ����";													//������ �޴� �߰�
						t1price[num[0]] = " 13.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 13800;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "���ڶ� ����";													//������ �޴� �߰�
						t2price[num[1]] = " 13.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 13800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "���ڶ� ����";													//������ �޴� �߰�
						t3price[num[2]] = " 13.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 13800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "���ڶ� ����";													//������ �޴� �߰�
						t4price[num[3]] = " 13.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 13800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "���ڶ� ����";													//������ �޴� �߰�
						t5price[num[4]] = " 13.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 13800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "���ڶ� ����";													//������ �޴� �߰�
						t6price[num[5]] = " 13.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 13800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "���ڶ� ����";													//������ �޴� �߰�
						t7price[num[6]] = " 13.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 13800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "���ڶ� ����";													//������ �޴� �߰�
						t8price[num[7]] = " 13.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 13800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "���ڶ� ����";													//������ �޴� �߰�
						t9price[num[8]] = " 13.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 13800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "���ڶ� ����";												//������ �޴� �߰�
						t10price[num[9]] = " 13.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 13800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "���ڶ� ����";													//������ �޴� �߰�
						t11price[num[10]] = " 13.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 13800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "���ڶ� ����";													//������ �޴� �߰�
						t12price[num[11]] = " 13.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pizzaorder[7]) {										//���ýó��� ���ڰ� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 14800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "���ýó��� ����";												//������ �޴� �߰�
						t1price[num[0]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 14800;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "���ýó��� ����";												//������ �޴� �߰�
						t2price[num[1]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 14800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "���ýó��� ����";												//������ �޴� �߰�
						t3price[num[2]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 14800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "���ýó��� ����";												//������ �޴� �߰�
						t4price[num[3]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 14800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "���ýó��� ����";												//������ �޴� �߰�
						t5price[num[4]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 14800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "���ýó��� ����";												//������ �޴� �߰�
						t6price[num[5]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 14800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "���ýó��� ����";												//������ �޴� �߰�
						t7price[num[6]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 14800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "���ýó��� ����";												//������ �޴� �߰�
						t8price[num[7]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 14800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "���ýó��� ����";												//������ �޴� �߰�
						t9price[num[8]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 14800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "���ýó��� ����";												//������ �޴� �߰�
						t10price[num[9]] = " 14.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 14800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "���ýó��� ����";												//������ �޴� �߰�
						t11price[num[10]] = " 14.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 14800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "���ýó��� ����";												//������ �޴� �߰�
						t12price[num[11]] = " 14.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == pizzaorder[8]) {										//�丶���Ʈ ���ڰ� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 19800;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�丶���Ʈ ����";												//������ �޴� �߰�
						t1price[num[0]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 19800;															//�Ѿ׿� ������ �� �߰�															
						t2info[num[1]] = "�丶���Ʈ ����";												//������ �޴� �߰�
						t2price[num[1]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 19800;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�丶���Ʈ ����";												//������ �޴� �߰�
						t3price[num[2]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 19800;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�丶���Ʈ ����";												//������ �޴� �߰�
						t4price[num[3]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 19800;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�丶���Ʈ ����";												//������ �޴� �߰�
						t5price[num[4]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 19800;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�丶���Ʈ ����";												//������ �޴� �߰�
						t6price[num[5]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 19800;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�丶���Ʈ ����";												//������ �޴� �߰�
						t7price[num[6]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 19800;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�丶���Ʈ ����";												//������ �޴� �߰�
						t8price[num[7]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 19800;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�丶���Ʈ ����";												//������ �޴� �߰�
						t9price[num[8]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 19800;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�丶���Ʈ ����";												//������ �޴� �߰�
						t10price[num[9]] = " 19.800";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 19800;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "�丶���Ʈ ����";												//������ �޴� �߰�
						t11price[num[10]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 19800;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�丶���Ʈ ����";												//������ �޴� �߰�
						t12price[num[11]] = " 19.800";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				}
			}
		}
	}

	class SidePanel extends JDialog {									//menu�� sidedish menu�� ���õ� ó���� �ϱ� ���� class
		SidePanel() {													//SidePanel ������ 
			sidedishimg sidedishimg = new sidedishimg();				//sidedish image�� ����ϱ� ���� sidedishimg ������ ȣ��
			Scanner sc = null;											//scanner �ʱ�ȭ
			try {
				sc = new Scanner(texts.sidedish(), "UTF-8");      		//sidedish.txt���� steak panel�� �ʿ��� ���� scan
			} catch (FileNotFoundException e1) {						//FileNotFoundException ���� ó��
				e1.printStackTrace();
			}
			
			setTitle("Menu - Sidedish");								//title ����
			getContentPane();											//���� �۵����� ContentPane ȣ��
			setLayout(null);											//���� ��� ��ġ������ ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);												//��� ����
			
			//sidedish menu�� ���������� ǥ���ϱ� ���� JLabel
			sidelabel[0] = new JLabel(sidedishimg.sidedish1img());
			sidelabel[1] = new JLabel(sidedishimg.sidedish2img());
			sidelabel[2] = new JLabel(sidedishimg.sidedish3img());
			sidelabel[3] = new JLabel(sidedishimg.sidedish4img());
			sidelabel[4] = new JLabel(sidedishimg.sidedish5img());
			sidelabel[5] = new JLabel(sidedishimg.sidedish6img());

			//sidedish menu�� ǥ���ϱ� ���� JLabel
			sidename[0] = new JLabel(sc.nextLine(), JLabel.CENTER);
			sidename[1] = new JLabel(sc.nextLine(), JLabel.CENTER);
			sidename[2] = new JLabel(sc.nextLine(), JLabel.CENTER);
			sidename[3] = new JLabel(sc.nextLine(), JLabel.CENTER);
			sidename[4] = new JLabel(sc.nextLine(), JLabel.CENTER);
			sidename[5] = new JLabel(sc.nextLine(), JLabel.CENTER);

			for (int i = 0; i < 6; i++) {
				sideorder[i] = new JButton(images.orderimg());			//�ֹ� ��û�� ó���ϱ� ���� JButton
				sidename[i].setForeground(Color.BLACK);					//sidename�� �� ����
				sideorder[i].addActionListener(new SideAction());		//sideorder�� ActionListener ����
				//�� ContentPane�� ����
				sidepic.add(sidelabel[i]);
				sidepic.add(sidename[i]);
				sidepic.add(sideorder[i]);
			}

			//sidelabel boundary ����
			sidelabel[0].setBounds(10, 50, 196, 126);
			sidelabel[1].setBounds(260, 50, 196, 126);
			sidelabel[2].setBounds(510, 50, 196, 126);
			sidelabel[3].setBounds(10, 260, 196, 126);
			sidelabel[4].setBounds(260, 260, 196, 126);
			sidelabel[5].setBounds(510, 260, 196, 126);

			//sidename boundary ����
			sidename[0].setBounds(10, 190, 196, 20);
			sidename[1].setBounds(260, 190, 196, 20);
			sidename[2].setBounds(510, 190, 196, 20);
			sidename[3].setBounds(10, 400, 196, 20);
			sidename[4].setBounds(260, 400, 196, 20);
			sidename[5].setBounds(510, 400, 196, 20);

			//sideorder boundary ����
			sideorder[0].setBounds(50, 212, 116, 35);
			sideorder[1].setBounds(300, 212, 116, 35);
			sideorder[2].setBounds(550, 212, 116, 35);
			sideorder[3].setBounds(50, 422, 116, 35);
			sideorder[4].setBounds(300, 422, 116, 35);
			sideorder[5].setBounds(550, 422, 116, 35);
			sidepic.setBounds(0, 0, 750, 690);			//sidepic boundary ����
			
			add(sidepic);			//sidepic ����
			setSize(750, 690);		//������ ����	
			setResizable(false);	//���������� �Ұ����ϰ� ����
			setLocation(165, 100);	//��ġ ����
			setVisible(false);		//Visible ��� ����
		}

		class SideAction implements ActionListener { 												//�ֹ���û�� ó�� �ϱ� ���� class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == sideorder[0]) {												//���� �극�尡 ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 1000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "���� �극��";													//������ �޴� �߰�
						t1price[num[0]] = " 1.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 1000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "���� �극��";													//������ �޴� �߰�
						t2price[num[1]] = " 1.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 1000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "���� �극��";													//������ �޴� �߰�
						t3price[num[2]] = " 1.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 1000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "���� �극��";													//������ �޴� �߰�
						t4price[num[3]] = " 1.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 1000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "���� �극��";													//������ �޴� �߰�
						t5price[num[4]] = " 1.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 1000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "���� �극��";													//������ �޴� �߰�
						t6price[num[5]] = " 1.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 1000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "���� �극��";													//������ �޴� �߰�
						t7price[num[6]] = " 1.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 1000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "���� �극��";													//������ �޴� �߰�
						t8price[num[7]] = " 1.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 1000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "���� �극��";													//������ �޴� �߰�
						t9price[num[8]] = " 1.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 1000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "���� �극��";												//������ �޴� �߰�
						t10price[num[9]] = " 1.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 1000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "���� �극��";													//������ �޴� �߰�
						t11price[num[10]] = " 1.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 1000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "���� �극��";													//������ �޴� �߰�
						t12price[num[11]] = " 1.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == sideorder[1]) {											//����Ÿ�׸� �����尡 ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 12000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "����Ÿ�׸� ������";											//������ �޴� �߰�
						t1price[num[0]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 12000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "����Ÿ�׸� ������";											//������ �޴� �߰�
						t2price[num[1]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 12000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "����Ÿ�׸� ������";											//������ �޴� �߰�
						t3price[num[2]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 12000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "����Ÿ�׸� ������";											//������ �޴� �߰�
						t4price[num[3]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 12000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "����Ÿ�׸� ������";											//������ �޴� �߰�
						t5price[num[4]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 12000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "����Ÿ�׸� ������";											//������ �޴� �߰�
						t6price[num[5]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 12000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "����Ÿ�׸� ������";											//������ �޴� �߰�
						t7price[num[6]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 12000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "����Ÿ�׸� ������";											//������ �޴� �߰�
						t8price[num[7]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 12000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "����Ÿ�׸� ������";											//������ �޴� �߰�
						t9price[num[8]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 12000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "����Ÿ�׸� ������";											//������ �޴� �߰�
						t10price[num[9]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 12000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "����Ÿ�׸� ������";												//������ �޴� �߰�
						t11price[num[10]] = " 12.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 12000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "����Ÿ�׸� ������";												//������ �޴� �߰�
						t12price[num[11]] = " 12.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == sideorder[2]) {											//���� �����尡 ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 12000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "���� ������";													//������ �޴� �߰�
						t1price[num[0]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 12000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "���� ������";													//������ �޴� �߰�
						t2price[num[1]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 12000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "���� ������";													//������ �޴� �߰�
						t3price[num[2]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 12000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "���� ������";													//������ �޴� �߰�
						t4price[num[3]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 12000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "���� ������";													//������ �޴� �߰�
						t5price[num[4]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 12000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "���� ������";													//������ �޴� �߰�
						t6price[num[5]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 12000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "���� ������";													//������ �޴� �߰�
						t7price[num[6]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 12000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "���� ������";													//������ �޴� �߰�
						t8price[num[7]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 12000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "���� ������";													//������ �޴� �߰�
						t9price[num[8]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 12000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "���� ������";												//������ �޴� �߰�
						t10price[num[9]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 12000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "���� ������";													//������ �޴� �߰�
						t11price[num[10]] = " 12.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 12000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "���� ������";													//������ �޴� �߰�
						t12price[num[11]] = " 12.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == sideorder[3]) {											//ġŲ�ٴ� �����尡 ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 12000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "ġŲ�ٴ� ������";												//������ �޴� �߰�
						t1price[num[0]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 12000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "ġŲ�ٴ� ������";												//������ �޴� �߰�
						t2price[num[1]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 12000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "ġŲ�ٴ� ������";												//������ �޴� �߰�
						t3price[num[2]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 12000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "ġŲ�ٴ� ������";												//������ �޴� �߰�
						t4price[num[3]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 12000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "ġŲ�ٴ� ������";												//������ �޴� �߰�
						t5price[num[4]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 12000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "ġŲ�ٴ� ������";												//������ �޴� �߰�
						t6price[num[5]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 12000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "ġŲ�ٴ� ������";												//������ �޴� �߰�
						t7price[num[6]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 12000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "ġŲ�ٴ� ������";												//������ �޴� �߰�
						t8price[num[7]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 12000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "ġŲ�ٴ� ������";												//������ �޴� �߰�
						t9price[num[8]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 12000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "ġŲ�ٴ� ������";												//������ �޴� �߰�
						t10price[num[9]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 12000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "ġŲ�ٴ� ������";												//������ �޴� �߰�
						t11price[num[10]] = " 12.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 12000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "ġŲ�ٴ� ������";												//������ �޴� �߰�
						t12price[num[11]] = " 12.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == sideorder[4]) {											//ĥ������ �����̰� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 12000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "ĥ������ ������";												//������ �޴� �߰�
						t1price[num[0]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 12000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "ĥ������ ������";												//������ �޴� �߰�
						t2price[num[1]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 12000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "ĥ������ ������";												//������ �޴� �߰�
						t3price[num[2]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 12000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "ĥ������ ������";												//������ �޴� �߰�
						t4price[num[3]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 12000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "ĥ������ ������";												//������ �޴� �߰�
						t5price[num[4]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 12000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "ĥ������ ������";												//������ �޴� �߰�
						t6price[num[5]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 12000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "ĥ������ ������";												//������ �޴� �߰�
						t7price[num[6]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 12000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "ĥ������ ������";												//������ �޴� �߰�
						t8price[num[7]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 12000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "ĥ������ ������";												//������ �޴� �߰�
						t9price[num[8]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 12000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "ĥ������ ������";												//������ �޴� �߰�
						t10price[num[9]] = " 12.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 12000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "ĥ������ ������";												//������ �޴� �߰�
						t11price[num[10]] = " 12.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 12000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "ĥ������ ������";												//������ �޴� �߰�
						t12price[num[11]] = " 12.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == sideorder[5]) {											//����ġ �����̰� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 4000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "����ġ ������";												//������ �޴� �߰�
						t1price[num[0]] = " 4.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 4000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "����ġ ������";												//������ �޴� �߰�
						t2price[num[1]] = " 4.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 4000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "����ġ ������";												//������ �޴� �߰�
						t3price[num[2]] = " 4.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 4000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "����ġ ������";												//������ �޴� �߰�
						t4price[num[3]] = " 4.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 4000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "����ġ ������";												//������ �޴� �߰�
						t5price[num[4]] = " 4.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 4000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "����ġ ������";												//������ �޴� �߰�
						t6price[num[5]] = " 4.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 4000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "����ġ ������";												//������ �޴� �߰�
						t7price[num[6]] = " 4.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 4000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "����ġ ������";												//������ �޴� �߰�
						t8price[num[7]] = " 4.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 4000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "����ġ ������";												//������ �޴� �߰�
						t9price[num[8]] = " 4.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 4000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "����ġ ������";												//������ �޴� �߰�
						t10price[num[9]] = " 4.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 4000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "����ġ ������";													//������ �޴� �߰�
						t11price[num[10]] = " 4.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 4000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "����ġ ������";													//������ �޴� �߰�
						t12price[num[11]] = " 4.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				}
			}
		}
	}

	class DrinkPanel extends JDialog {									//menu�� beverage menu�� ���õ� ó���� �ϱ� ���� class
		DrinkPanel() {													//DrinkPanel ������ ȣ��
			beverageimg beverageimg = new beverageimg();				//beverage image�� ����ϱ� ���� beverageimg ������ ȣ��
			Scanner sc = null;											//scanner �ʱ�ȭ
			try {
				sc = new Scanner(texts.beverage(), "UTF-8");      		//beverage.txt���� drink panel�� �ʿ��� ���� scan
			} catch (FileNotFoundException e1) {						//FileNotFoundException ���� ó��
				e1.printStackTrace();
			}
			
			setTitle("Menu - Beverage");								//title ����
			getContentPane();											//���� �۵����� ContentPane ȣ��
			setLayout(null);											//���� ��� ��ġ������ ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);												//��� ����
			
			//beverage menu�� ���������� ǥ���ϱ� ���� JLabel
			drinklabel[0] = new JLabel(beverageimg.beverage1img());
			drinklabel[1] = new JLabel(beverageimg.beverage2img());
			drinklabel[2] = new JLabel(beverageimg.beverage3img());
			drinklabel[3] = new JLabel(beverageimg.beverage4img());
			drinklabel[4] = new JLabel(beverageimg.beverage5img());
			drinklabel[5] = new JLabel(beverageimg.beverage6img());
			drinklabel[6] = new JLabel(beverageimg.beverage7img());
			drinklabel[7] = new JLabel(beverageimg.beverage8img());
			drinklabel[8] = new JLabel(beverageimg.beverage9img());
			drinklabel[9] = new JLabel(beverageimg.beverage10img());
			drinklabel[10] = new JLabel(beverageimg.beverage11img());
			
			//beverage menu�� ǥ���ϱ� ���� JLabel
			drinkname[0] = new JLabel(sc.nextLine(), JLabel.CENTER);
			drinkname[1] = new JLabel(sc.nextLine(), JLabel.CENTER);
			drinkname[2] = new JLabel(sc.nextLine(), JLabel.CENTER);
			drinkname[3] = new JLabel(sc.nextLine(), JLabel.CENTER);
			drinkname[4] = new JLabel(sc.nextLine(), JLabel.CENTER);
			drinkname[5] = new JLabel(sc.nextLine(), JLabel.CENTER);
			drinkname[6] = new JLabel(sc.nextLine(), JLabel.CENTER);
			drinkname[7] = new JLabel(sc.nextLine(), JLabel.CENTER);
			drinkname[8] = new JLabel(sc.nextLine(), JLabel.CENTER);
			drinkname[9] = new JLabel(sc.nextLine(), JLabel.CENTER);
			drinkname[10] = new JLabel(sc.nextLine(), JLabel.CENTER);

			for (int i = 0; i < 11; i++) {
				drinkorder[i] = new JButton(images.orderimg());			//�ֹ� ��û�� ó���ϱ� ���� JButton
				drinkname[i].setForeground(Color.BLACK);				//drinkname�� �� ����
				drinkorder[i].addActionListener(new DrinkAction());		//drinkorder�� ActionListener ����
				//�� ContentPane�� ����
				drinkpic.add(drinklabel[i]);	
				drinkpic.add(drinkname[i]);
				drinkpic.add(drinkorder[i]);
			}

			//drinklabel boundary ����
			drinklabel[0].setBounds(10, 50, 168, 108);
			drinklabel[1].setBounds(195, 50, 168, 108);
			drinklabel[2].setBounds(375, 50, 168, 108);
			drinklabel[3].setBounds(555, 50, 168, 108);
			drinklabel[4].setBounds(10, 250, 168, 108);
			drinklabel[5].setBounds(195, 250, 168, 108);
			drinklabel[6].setBounds(375, 250, 168, 108);
			drinklabel[7].setBounds(555, 250, 168, 108);
			drinklabel[8].setBounds(10, 460, 168, 108);
			drinklabel[9].setBounds(195, 460, 168, 108);
			drinklabel[10].setBounds(375, 460, 168, 108);

			//drinkname boundary ����
			drinkname[0].setBounds(10, 160, 175, 20);
			drinkname[1].setBounds(195, 160, 175, 20);
			drinkname[2].setBounds(375, 160, 175, 20);
			drinkname[3].setBounds(555, 160, 175, 20);
			drinkname[4].setBounds(10, 360, 175, 20);
			drinkname[5].setBounds(195, 360, 175, 20);
			drinkname[6].setBounds(375, 360, 175, 20);
			drinkname[7].setBounds(555, 360, 175, 20);
			drinkname[8].setBounds(10, 570, 175, 20);
			drinkname[9].setBounds(195, 570, 175, 20);
			drinkname[10].setBounds(375, 570, 175, 20);

			//drinkorder boundary ����
			drinkorder[0].setBounds(40, 190, 116, 30);
			drinkorder[1].setBounds(220, 190, 116, 30);
			drinkorder[2].setBounds(400, 190, 116, 30);
			drinkorder[3].setBounds(585, 190, 116, 30);
			drinkorder[4].setBounds(40, 390, 116, 30);
			drinkorder[5].setBounds(220, 390, 116, 30);
			drinkorder[6].setBounds(400, 390, 116, 30);
			drinkorder[7].setBounds(585, 390, 116, 30);
			drinkorder[8].setBounds(40, 600, 116, 30);
			drinkorder[9].setBounds(220, 600, 116, 30);
			drinkorder[10].setBounds(400, 600, 116, 30);
			drinkpic.setBounds(0, 0, 750, 690);				//drinkpic boundary ����
			
			add(drinkpic);				//drinkpic ����
			setLocation(165, 100);		//��ġ ����	
			setResizable(false);		//���������� �Ұ����ϰ� ����
			setSize(750, 690);			//������ ����
			setVisible(false);			//Visible ��� ����
		}

		class DrinkAction implements ActionListener { 												//�ֹ���û�� ó�� �ϱ� ���� class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == drinkorder[0]) {												//���� ���̵带 �������� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 7000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "���� ���̵�";													//������ �޴� �߰�
						t1price[num[0]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 7000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "���� ���̵�";													//������ �޴� �߰�
						t2price[num[1]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 7000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "���� ���̵�";													//������ �޴� �߰�
						t3price[num[2]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 7000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "���� ���̵�";													//������ �޴� �߰�
						t4price[num[3]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 7000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "���� ���̵�";													//������ �޴� �߰�
						t5price[num[4]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 7000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "���� ���̵�";													//������ �޴� �߰�
						t6price[num[5]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 7000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "���� ���̵�";													//������ �޴� �߰�
						t7price[num[6]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 7000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "���� ���̵�";													//������ �޴� �߰�
						t8price[num[7]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 7000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "���� ���̵�";													//������ �޴� �߰�
						t9price[num[8]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 7000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "���� ���̵�";												//������ �޴� �߰�
						t10price[num[9]] = " 7.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 7000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "���� ���̵�";													//������ �޴� �߰�
						t11price[num[10]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 7000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "���� ���̵�";													//������ �޴� �߰�
						t12price[num[11]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == drinkorder[1]) {										//����� ���̵尡 ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 7000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "����� ���̵�";												//������ �޴� �߰�
						t1price[num[0]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 7000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "����� ���̵�";												//������ �޴� �߰�
						t2price[num[1]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 7000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "����� ���̵�";												//������ �޴� �߰�
						t3price[num[2]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 7000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "����� ���̵�";												//������ �޴� �߰�
						t4price[num[3]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 7000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "����� ���̵�";												//������ �޴� �߰�
						t5price[num[4]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 7000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "����� ���̵�";												//������ �޴� �߰�
						t6price[num[5]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 7000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "����� ���̵�";												//������ �޴� �߰�
						t7price[num[6]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 7000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "����� ���̵�";												//������ �޴� �߰�
						t8price[num[7]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 7000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "����� ���̵�";												//������ �޴� �߰�
						t9price[num[8]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 7000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "����� ���̵�";												//������ �޴� �߰�
						t10price[num[9]] = " 7.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 7000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "����� ���̵�";												//������ �޴� �߰�
						t11price[num[10]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 7000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "����� ���̵�";												//������ �޴� �߰�
						t12price[num[11]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}	
				} else if (e.getSource() == drinkorder[2]) {										//���� ���̵尡 ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 7000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "���� ���̵�";													//������ �޴� �߰�
						t1price[num[0]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 7000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "���� ���̵�";													//������ �޴� �߰�
						t2price[num[1]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 7000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "���� ���̵�";													//������ �޴� �߰�
						t3price[num[2]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 7000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "���� ���̵�";													//������ �޴� �߰�
						t4price[num[3]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 7000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "���� ���̵�";													//������ �޴� �߰�
						t5price[num[4]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 7000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "���� ���̵�";													//������ �޴� �߰�
						t6price[num[5]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 7000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "���� ���̵�";													//������ �޴� �߰�
						t7price[num[6]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 7000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "���� ���̵�";													//������ �޴� �߰�
						t8price[num[7]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 7000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "���� ���̵�";													//������ �޴� �߰�
						t9price[num[8]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 7000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "���� ���̵�";												//������ �޴� �߰�
						t10price[num[9]] = " 7.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 7000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "���� ���̵�";													//������ �޴� �߰�
						t11price[num[10]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 7000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "���� ���̵�";													//������ �޴� �߰�
						t12price[num[11]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == drinkorder[3]) {										//���� ���̵尡 ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 7000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "���� ���̵�";													//������ �޴� �߰�
						t1price[num[0]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 7000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "���� ���̵�";													//������ �޴� �߰�
						t2price[num[1]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 7000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "���� ���̵�";													//������ �޴� �߰�
						t3price[num[2]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 7000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "���� ���̵�";													//������ �޴� �߰�
						t4price[num[3]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 7000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "���� ���̵�";													//������ �޴� �߰�
						t5price[num[4]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 7000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "���� ���̵�";													//������ �޴� �߰�
						t6price[num[5]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 7000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "���� ���̵�";													//������ �޴� �߰�
						t7price[num[6]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 7000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "���� ���̵�";													//������ �޴� �߰�
						t8price[num[7]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 7000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "���� ���̵�";													//������ �޴� �߰�
						t9price[num[8]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 7000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "���� ���̵�";												//������ �޴� �߰�
						t10price[num[9]] = " 7.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 7000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "���� ���̵�";													//������ �޴� �߰�
						t11price[num[10]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 7000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "���� ���̵�";													//������ �޴� �߰�
						t12price[num[11]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == drinkorder[4]) {										//�Ѷ�� ���̵尡 ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 7000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�Ѷ�� ���̵�";												//������ �޴� �߰�
						t1price[num[0]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 7000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "�Ѷ�� ���̵�";												//������ �޴� �߰�
						t2price[num[1]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 7000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�Ѷ�� ���̵�";												//������ �޴� �߰�
						t3price[num[2]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 7000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�Ѷ�� ���̵�";												//������ �޴� �߰�
						t4price[num[3]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 7000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�Ѷ�� ���̵�";												//������ �޴� �߰�
						t5price[num[4]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 7000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�Ѷ�� ���̵�";												//������ �޴� �߰�
						t6price[num[5]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 7000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�Ѷ�� ���̵�";												//������ �޴� �߰�
						t7price[num[6]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 7000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�Ѷ�� ���̵�";												//������ �޴� �߰�
						t8price[num[7]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 7000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�Ѷ�� ���̵�";												//������ �޴� �߰�
						t9price[num[8]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 7000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�Ѷ�� ���̵�";												//������ �޴� �߰�
						t10price[num[9]] = " 7.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 7000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "�Ѷ�� ���̵�";													//������ �޴� �߰�
						t11price[num[10]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 7000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�Ѷ�� ���̵�";													//������ �޴� �߰�
						t12price[num[11]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == drinkorder[5]) {										//�ڸ� ���̵尡 ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 7000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�ڸ� ���̵�";													//������ �޴� �߰�
						t1price[num[0]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 7000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "�ڸ� ���̵�";													//������ �޴� �߰�
						t2price[num[1]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 7000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�ڸ� ���̵�";													//������ �޴� �߰�
						t3price[num[2]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 7000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�ڸ� ���̵�";													//������ �޴� �߰�
						t4price[num[3]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 7000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�ڸ� ���̵�";													//������ �޴� �߰�
						t5price[num[4]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 7000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�ڸ� ���̵�";													//������ �޴� �߰�
						t6price[num[5]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 7000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�ڸ� ���̵�";													//������ �޴� �߰�
						t7price[num[6]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 7000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�ڸ� ���̵�";													//������ �޴� �߰�
						t8price[num[7]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 7000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�ڸ� ���̵�";													//������ �޴� �߰�
						t9price[num[8]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 7000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�ڸ� ���̵�";												//������ �޴� �߰�
						t10price[num[9]] = " 7.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 7000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "�ڸ� ���̵�";													//������ �޴� �߰�
						t11price[num[10]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 7000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�ڸ� ���̵�";													//������ �޴� �߰�
						t12price[num[11]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == drinkorder[6]) {										//û���� ���̵尡 ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 7000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "û���� ���̵�";												//������ �޴� �߰�
						t1price[num[0]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 7000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "û���� ���̵�";												//������ �޴� �߰�
						t2price[num[1]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 7000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "û���� ���̵�";												//������ �޴� �߰�
						t3price[num[2]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 7000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "û���� ���̵�";												//������ �޴� �߰�
						t4price[num[3]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 7000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "û���� ���̵�";												//������ �޴� �߰�
						t5price[num[4]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 7000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "û���� ���̵�";												//������ �޴� �߰�
						t6price[num[5]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 7000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "û���� ���̵�";												//������ �޴� �߰�
						t7price[num[6]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 7000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "û���� ���̵�";												//������ �޴� �߰�
						t8price[num[7]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 7000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "û���� ���̵�";												//������ �޴� �߰�
						t9price[num[8]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 7000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "û���� ���̵�";												//������ �޴� �߰�
						t10price[num[9]] = " 7.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 7000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "û���� ���̵�";													//������ �޴� �߰�
						t11price[num[10]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 7000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "û���� ���̵�";													//������ �޴� �߰�
						t12price[num[11]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == drinkorder[7]) {										//ü�� ���̵尡 ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 7000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "ü�� ���̵�";													//������ �޴� �߰�
						t1price[num[0]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 7000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "ü�� ���̵�";													//������ �޴� �߰�
						t2price[num[1]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 7000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "ü�� ���̵�";													//������ �޴� �߰�
						t3price[num[2]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 7000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "ü�� ���̵�";													//������ �޴� �߰�
						t4price[num[3]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 7000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "ü�� ���̵�";													//������ �޴� �߰�
						t5price[num[4]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 7000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "ü�� ���̵�";													//������ �޴� �߰�
						t6price[num[5]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 7000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "ü�� ���̵�";													//������ �޴� �߰�
						t7price[num[6]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 7000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "ü�� ���̵�";													//������ �޴� �߰�
						t8price[num[7]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 7000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "ü�� ���̵�";													//������ �޴� �߰�
						t9price[num[8]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 7000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "ü�� ���̵�";												//������ �޴� �߰�
						t10price[num[9]] = " 7.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 7000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "ü�� ���̵�";													//������ �޴� �߰�
						t11price[num[10]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 7000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "ü�� ���̵�";													//������ �޴� �߰�
						t12price[num[11]] = " 7.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == drinkorder[8]) {										//�ݶ� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 2000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "�ݶ�";														//������ �޴� �߰�
						t1price[num[0]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 2000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "�ݶ�";														//������ �޴� �߰�
						t2price[num[1]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 2000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "�ݶ�";														//������ �޴� �߰�
						t3price[num[2]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 2000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "�ݶ�";														//������ �޴� �߰�
						t4price[num[3]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 2000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "�ݶ�";														//������ �޴� �߰�
						t5price[num[4]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 2000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "�ݶ�";														//������ �޴� �߰�
						t6price[num[5]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 2000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "�ݶ�";														//������ �޴� �߰�
						t7price[num[6]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 2000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "�ݶ�";														//������ �޴� �߰�
						t8price[num[7]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 2000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "�ݶ�";														//������ �޴� �߰�
						t9price[num[8]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 2000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "�ݶ�";														//������ �޴� �߰�
						t10price[num[9]] = " 2.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 2000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "�ݶ�";														//������ �޴� �߰�
						t11price[num[10]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 2000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "�ݶ�";														//������ �޴� �߰�
						t12price[num[11]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == drinkorder[9]) {										//���̴ٰ� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 2000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "���̴�";													//������ �޴� �߰�
						t1price[num[0]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 2000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "���̴�";													//������ �޴� �߰�
						t2price[num[1]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 2000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "���̴�";													//������ �޴� �߰�
						t3price[num[2]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 2000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "���̴�";													//������ �޴� �߰�
						t4price[num[3]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 2000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "���̴�";													//������ �޴� �߰�
						t5price[num[4]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 2000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "���̴�";													//������ �޴� �߰�
						t6price[num[5]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 2000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "���̴�";													//������ �޴� �߰�
						t7price[num[6]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 2000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "���̴�";													//������ �޴� �߰�
						t8price[num[7]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 2000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "���̴�";													//������ �޴� �߰�
						t9price[num[8]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 2000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "���̴�";													//������ �޴� �߰�
						t10price[num[9]] = " 2.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 2000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "���̴�";														//������ �޴� �߰�
						t11price[num[10]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 2000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "���̴�";														//������ �޴� �߰�
						t12price[num[11]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				} else if (e.getSource() == drinkorder[10]) {										//ȯŸ�� ���õǾ��� ��
					if (select == 1) {																//1�� Table�� ���õǾ��ٸ�
						money[0] += 2000;															//�Ѿ׿� ������ �� �߰�
						t1info[num[0]] = "ȯŸ";														//������ �޴� �߰�
						t1price[num[0]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t1info[num[0]] + " �հ�ݾ� : " + money[0]);
						num[0]++;																	//�� �ֹ����� ����
					} else if (select == 2) {														//2�� Table�� ���õǾ��ٸ�
						money[1] += 2000;															//�Ѿ׿� ������ �� �߰�
						t2info[num[1]] = "ȯŸ";														//������ �޴� �߰�
						t2price[num[1]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t2info[num[1]] + " �հ�ݾ� : " + money[1]);
						num[1]++;																	//�� �ֹ����� ����
					} else if (select == 3) {														//3�� Table�� ���õǾ��ٸ�
						money[2] += 2000;															//�Ѿ׿� ������ �� �߰�
						t3info[num[2]] = "ȯŸ";														//������ �޴� �߰�
						t3price[num[2]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t3info[num[2]] + " �հ�ݾ� : " + money[2]);
						num[2]++;																	//�� �ֹ����� ����
					} else if (select == 4) {														//4�� Table�� ���õǾ��ٸ�
						money[3] += 2000;															//�Ѿ׿� ������ �� �߰�
						t4info[num[3]] = "ȯŸ";														//������ �޴� �߰�
						t4price[num[3]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t4info[num[3]] + " �հ�ݾ� : " + money[3]);
						num[3]++;																	//�� �ֹ����� ����
					} else if (select == 5) {														//5�� Table�� ���õǾ��ٸ�
						money[4] += 2000;															//�Ѿ׿� ������ �� �߰�
						t5info[num[4]] = "ȯŸ";														//������ �޴� �߰�
						t5price[num[4]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t5info[num[4]] + " �հ�ݾ� : " + money[4]);
						num[4]++;																	//�� �ֹ����� ����
					} else if (select == 6) {														//6�� Table�� ���õǾ��ٸ�
						money[5] += 2000;															//�Ѿ׿� ������ �� �߰�
						t6info[num[5]] = "ȯŸ";														//������ �޴� �߰�
						t6price[num[5]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t6info[num[5]] + " �հ�ݾ� : " + money[5]);
						num[5]++;																	//�� �ֹ����� ����
					} else if (select == 7) {														//7�� Table�� ���õǾ��ٸ�
						money[6] += 2000;															//�Ѿ׿� ������ �� �߰�
						t7info[num[6]] = "ȯŸ";														//������ �޴� �߰�
						t7price[num[6]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t7info[num[6]] + " �հ�ݾ� : " + money[6]);
						num[6]++;																	//�� �ֹ����� ����
					} else if (select == 8) {														//8�� Table�� ���õǾ��ٸ�
						money[7] += 2000;															//�Ѿ׿� ������ �� �߰�
						t8info[num[7]] = "ȯŸ";														//������ �޴� �߰�
						t8price[num[7]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t8info[num[7]] + " �հ�ݾ� : " + money[7]);
						num[7]++;																	//�� �ֹ����� ����
					} else if (select == 9) {														//9�� Table�� ���õǾ��ٸ�
						money[8] += 2000;															//�Ѿ׿� ������ �� �߰�
						t9info[num[8]] = "ȯŸ";														//������ �޴� �߰�
						t9price[num[8]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t9info[num[8]] + " �հ�ݾ� : " + money[8]);
						num[8]++;																	//�� �ֹ����� ����
					} else if (select == 10) {														//10�� Table�� ���õǾ��ٸ�
						money[9] += 2000;															//�Ѿ׿� ������ �� �߰�
						t10info[num[9]] = "ȯŸ";														//������ �޴� �߰�
						t10price[num[9]] = " 2.000";												//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t10info[num[9]] + " �հ�ݾ� : " + money[9]);
						num[9]++;																	//�� �ֹ����� ����
					} else if (select == 11) {															//11�� Table�� ���õǾ��ٸ�
						money[10] += 2000;																//�Ѿ׿� ������ �� �߰�
						t11info[num[10]] = "ȯŸ";														//������ �޴� �߰�
						t11price[num[10]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t11info[num[10]] + " �հ�ݾ� : " + money[10]);
						num[10]++;																		//�� �ֹ����� ����
					} else if (select == 12) {															//12�� Table�� ���õǾ��ٸ�
						money[11] += 2000;																//�Ѿ׿� ������ �� �߰�
						t12info[num[11]] = "ȯŸ";														//������ �޴� �߰�
						t12price[num[11]] = " 2.000";													//������ �� �߰�
						System.out.println("�ֹ� ���� : " + t12info[num[11]] + " �հ�ݾ� : " + money[11]);
						num[11]++;																		//�� �ֹ����� ����
					}
				}
			}
		}						
	}

	class FoodMenu extends JDialog {										//�ֹ��� �� Restaurant�� Menu�� ��ȸ�ϰ� �̿� ���� �۾��� �ϴ� class
		JPanel menupanel = new JPanel();									//menu�� �ð������� ��Ÿ���� ���� ����ϴ� JPanel
		JLabel menupimg = new JLabel(images.menuimg());						//������ ���� ������ menu��� ���� �ð������� ��Ÿ���� ���� ����ϴ� JLabel

		FoodMenu() {														//FoodMenu ������
			//�� button�� ���ο��� ��� ����
			steak.setContentAreaFilled(false);	
			pasta.setContentAreaFilled(false);
			pilaf.setContentAreaFilled(false);
			pizza.setContentAreaFilled(false);
			side.setContentAreaFilled(false);
			drink.setContentAreaFilled(false);
			endbtn.setContentAreaFilled(false);
			
			//�� button�� ActionListener ����
			steak.addActionListener(new FoodAction());
			pasta.addActionListener(new FoodAction());
			pilaf.addActionListener(new FoodAction());
			pizza.addActionListener(new FoodAction());
			side.addActionListener(new FoodAction());
			drink.addActionListener(new FoodAction());
			endbtn.addActionListener(new FoodAction());
			
			getContentPane();												//���� �۵����� ContentPane ȣ��									
			setLayout(null);												//���� ��� ��ġ������ ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			menupanel.setSize(160, 600);									//menupanel ������ ����							
			menupanel.setBackground(Color.WHITE);							//menupanel ���� ����
			menupanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));	//menupanel�� FlowLayout ��ġ�����ڷ� ����
			//menupanel�� �� ContentPane�� ����
			menupanel.add(menupimg);
			menupanel.add(steak);
			menupanel.add(pasta);
			menupanel.add(pilaf);
			menupanel.add(pizza);
			menupanel.add(side);
			menupanel.add(drink);
			menupanel.add(endbtn);
			add(menupanel);					//menupanel ����
			
			endbtn.addActionListener(new ActionListener() {							//endbtn�� ActionListener ����
				public void actionPerformed(ActionEvent e) { 
					if (select == 1) {												//1�� Table�� ���õǾ��ٸ�
						if (money[0] > 0) {
							lucknum[0] = (int) (Math.random() * 10);				//�������ڸ� �����ϰ� �ش� table�� lucknum�� ����
							tbtn[0].setBackground(Color.GREEN);						//tbtn�� ���� ����
							tbtn[0].setForeground(Color.BLACK);						//tbtn�� �� ����
							mon1 = "�ݾ�: " + Integer.toString(money[0]) + " ��";		//Table�� �� �ֹ��ݾ��� ����ϱ� ���� ���ڿ� ����
							tbtn[0].setText(mon1);									//tbtn�� mon1�� ���
							tblabel2[0].setText("�ð�: " + nowDate);					//tblable2�� ó���� �ð��� ���
						}
					} else if (select == 2) {										//2�� Table�� ���õǾ��ٸ�
						if (money[1] > 0) {
							lucknum[1] = (int) (Math.random() * 10);				//�������ڸ� �����ϰ� �ش� table�� lucknum�� ����
							tbtn[1].setBackground(Color.GREEN);						//tbtn�� ���� ����
							tbtn[1].setForeground(Color.BLACK);						//tbtn�� �� ����
							mon2 = "�ݾ�: " + Integer.toString(money[1]) + " ��";		//Table�� �� �ֹ��ݾ��� ����ϱ� ���� ���ڿ� ����
							tbtn[1].setText(mon2);									//tbtn�� mon2�� ���
							tblabel2[1].setText("�ð�: " + nowDate);					//tblable2�� ó���� �ð��� ���
						}
					} else if (select == 3) {										//3�� Table�� ���õǾ��ٸ�	
						if (money[2] > 0) {
							lucknum[2] = (int) (Math.random() * 10);				//�������ڸ� �����ϰ� �ش� table�� lucknum�� ����
							tbtn[2].setBackground(Color.GREEN);						//tbtn�� ���� ����
							tbtn[2].setForeground(Color.BLACK);						//tbtn�� �� ����
							mon3 = "�ݾ�: " + Integer.toString(money[2]) + " ��";		//Table�� �� �ֹ��ݾ��� ����ϱ� ���� ���ڿ� ����
							tbtn[2].setText(mon3);									//tbtn�� mon3�� ���
							tblabel2[2].setText("�ð�: " + nowDate);					//tblable2�� ó���� �ð��� ���
						}
					} else if (select == 4) {										//4�� Table�� ���õǾ��ٸ�	
						if (money[3] > 0) {
							lucknum[3] = (int) (Math.random() * 10);				//�������ڸ� �����ϰ� �ش� table�� lucknum�� ����
							tbtn[3].setBackground(Color.GREEN);						//tbtn�� ���� ����
							tbtn[3].setForeground(Color.BLACK);						//tbtn�� �� ����
							mon4 = "�ݾ�: " + Integer.toString(money[3]) + " ��";		//Table�� �� �ֹ��ݾ��� ����ϱ� ���� ���ڿ� ����
							tbtn[3].setText(mon4);									//tbtn�� mon4�� ���
							tblabel2[3].setText("�ð�: " + nowDate);					//tblable2�� ó���� �ð��� ���
						}
					} else if (select == 5) {										//5�� Table�� ���õǾ��ٸ�	
						if (money[4] > 0) {
							lucknum[4] = (int) (Math.random() * 10);				//�������ڸ� �����ϰ� �ش� table�� lucknum�� ����
							tbtn[4].setBackground(Color.GREEN);						//tbtn�� ���� ����
							tbtn[4].setForeground(Color.BLACK);						//tbtn�� �� ����
							mon5 = "�ݾ�: " + Integer.toString(money[4]) + " ��";		//Table�� �� �ֹ��ݾ��� ����ϱ� ���� ���ڿ� ����
							tbtn[4].setText(mon5);									//tbtn�� mon5�� ���
							tblabel2[4].setText("�ð�: " + nowDate);					//tblable2�� ó���� �ð��� ���
						}
					} else if (select == 6) {										//6�� Table�� ���õǾ��ٸ�	
						if (money[5] > 0) {
							lucknum[5] = (int) (Math.random() * 10);				//�������ڸ� �����ϰ� �ش� table�� lucknum�� ����
							tbtn[5].setBackground(Color.GREEN);						//tbtn�� ���� ����
							tbtn[5].setForeground(Color.BLACK);						//tbtn�� �� ����
							mon6 = "�ݾ�: " + Integer.toString(money[5]) + " ��";		//Table�� �� �ֹ��ݾ��� ����ϱ� ���� ���ڿ� ����
							tbtn[5].setText(mon6);									//tbtn�� mon6�� ���
							tblabel2[5].setText("�ð�: " + nowDate);					//tblable2�� ó���� �ð��� ���
						}
					} else if (select == 7) {										//7�� Table�� ���õǾ��ٸ�
						if (money[6] > 0) {
							lucknum[6] = (int) (Math.random() * 10);				//�������ڸ� �����ϰ� �ش� table�� lucknum�� ����
							tbtn[6].setBackground(Color.GREEN);						//tbtn�� ���� ����
							tbtn[6].setForeground(Color.BLACK);						//tbtn�� �� ����
							mon7 = "�ݾ�: " + Integer.toString(money[6]) + " ��";		//Table�� �� �ֹ��ݾ��� ����ϱ� ���� ���ڿ� ����
							tbtn[6].setText(mon7);									//tbtn�� mon7�� ���
							tblabel2[6].setText("�ð�: " + nowDate);					//tblable2�� ó���� �ð��� ���
						}
					} else if (select == 8) {										//8�� Table�� ���õǾ��ٸ�
						if (money[7] > 0) {
							lucknum[7] = (int) (Math.random() * 10);				//�������ڸ� �����ϰ� �ش� table�� lucknum�� ����
							tbtn[7].setBackground(Color.GREEN);						//tbtn�� ���� ����
							tbtn[7].setForeground(Color.BLACK);						//tbtn�� �� ����
							mon8 = "�ݾ�: " + Integer.toString(money[7]) + " ��";		//Table�� �� �ֹ��ݾ��� ����ϱ� ���� ���ڿ� ����
							tbtn[7].setText(mon8);									//tbtn�� mon8�� ���
							tblabel2[7].setText("�ð�: " + nowDate);					//tblable2�� ó���� �ð��� ���
						}
					} else if (select == 9) {										//9�� Table�� ���õǾ��ٸ�
						if (money[8] > 0) {
							lucknum[8] = (int) (Math.random() * 10);				//�������ڸ� �����ϰ� �ش� table�� lucknum�� ����
							tbtn[8].setBackground(Color.GREEN);						//tbtn�� ���� ����
							tbtn[8].setForeground(Color.BLACK);						//tbtn�� �� ����
							mon9 = "�ݾ�: " + Integer.toString(money[8]) + " ��";		//Table�� �� �ֹ��ݾ��� ����ϱ� ���� ���ڿ� ����
							tbtn[8].setText(mon9);									//tbtn�� mon9�� ���
							tblabel2[8].setText("�ð�: " + nowDate);					//tblable2�� ó���� �ð��� ���
						}
					} else if (select == 10) {										//10�� Table�� ���õǾ��ٸ�	
						if (money[9] > 0) {
							lucknum[9] = (int) (Math.random() * 10);				//�������ڸ� �����ϰ� �ش� table�� lucknum�� ����
							tbtn[9].setBackground(Color.GREEN);						//tbtn�� ���� ����
							tbtn[9].setForeground(Color.BLACK);						//tbtn�� �� ����
							mon10 = "�ݾ�: " + Integer.toString(money[9]) + " ��";	//Table�� �� �ֹ��ݾ��� ����ϱ� ���� ���ڿ� ����
							tbtn[9].setText(mon10);									//tbtn�� mon10�� ���
							tblabel2[9].setText("�ð�: " + nowDate);					//tblable2�� ó���� �ð��� ���
						}
					} else if (select == 11) {										//11�� Table�� ���õǾ��ٸ�	
						if (money[10] > 0) {
							lucknum[10] = (int) (Math.random() * 10);				//�������ڸ� �����ϰ� �ش� table�� lucknum�� ����
							tbtn[10].setBackground(Color.GREEN);					//tbtn�� ���� ����
							tbtn[10].setForeground(Color.BLACK);					//tbtn�� �� ����
							mon11 = "�ݾ�: " + Integer.toString(money[10]) + " ��";	//Table�� �� �ֹ��ݾ��� ����ϱ� ���� ���ڿ� ����
							tbtn[10].setText(mon11);								//tbtn�� mon11�� ���
							tblabel2[10].setText("�ð�: " + nowDate);					//tblable2�� ó���� �ð��� ���
						}
					} else if (select == 12) {										//12�� Table�� ���õǾ��ٸ�	
						if (money[11] > 0) {
							lucknum[11] = (int) (Math.random() * 10);				//�������ڸ� �����ϰ� �ش� table�� lucknum�� ����
							tbtn[11].setBackground(Color.GREEN);					//tbtn�� ���� ����
							tbtn[11].setForeground(Color.BLACK);					//tbtn�� �� ����
							mon12 = "�ݾ�: " + Integer.toString(money[11]) + " ��";	//Table�� �� �ֹ��ݾ��� ����ϱ� ���� ���ڿ� ����
							tbtn[11].setText(mon12);								//tbtn�� mon12�� ���
							tblabel2[11].setText("�ð�: " + nowDate);					//tblable2�� ó���� �ð��� ���
						}
					}
					setVisible(false);			//Visible ��� ����
				}
			});
			setSize(160, 450);					//������ ����
			setLocation(0, 100);				//��ġ ����
			setResizable(false);				//���������� �Ұ����ϰ� ����
		}

		class FoodAction implements ActionListener { 		//menu���� ������ panel�� �ҷ����� ���� class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == steak)					
					stp.setVisible(true);					//steak panel�� Visible ��� ����
				else if (e.getSource() == pasta)			
					psp.setVisible(true);					//pasta panel�� Visible ��� ����
				else if (e.getSource() == pilaf)			
					plp.setVisible(true);					//pilaf panel�� Visible ��� ����
				else if (e.getSource() == pizza)			
					pzp.setVisible(true);					//pizza panel�� Visible ��� ����
				else if (e.getSource() == side)				
					sdp.setVisible(true);					//side panel�� Visible ��� ����
				else if (e.getSource() == drink)			
					dkp.setVisible(true);					//drink panel�� Visible ��� ����
			}
		}
	}

	class SubMenu extends JDialog {										//�ֹ�, ���, ����, ��ҿ� ���õ� �۾��� ó���ϴ� class 
		SubMenu() {														//SubMenu ������													
			getContentPane();											//���� �۵����� ContentPane ȣ��
			setTitle("�ֹ� / ���  / ���� / ���");							//title ����
			setLayout(new GridLayout(1, 4));							//GridLayout ��ġ������ ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);												//��� ����
			
			Clickbtn1 = new JButton("�ֹ�", images.orderingimg()); 		//�ֹ� ��û�� ó���ϱ� ���� JButton
			Clickbtn2 = new JButton("���", images.cashimg());	 		//��� ��û�� ó���ϱ� ���� JButton
			Clickbtn3 = new JButton("����", images.reservationimg());	 	//���� ��û�� ó���ϱ� ���� JButton
			Clickbtn4 = new JButton("���", images.cancelimg());	 		//��� ��û�� ó���ϱ� ���� JButton
			
			//�� ContentPane�� ����
			add(Clickbtn1);
			add(Clickbtn2);
			add(Clickbtn3);
			add(Clickbtn4);
			
			Clickbtn2.setEnabled(false);						//�־��� ������ �����ɶ��� Clickbtn2�� enable�� �� �ֵ��� ����
			
			//�� Clickbtn�� ������ ����
			Clickbtn1.setSize(134, 108);						
			Clickbtn2.setSize(134, 108);						
			Clickbtn3.setSize(134, 108);						
			Clickbtn4.setSize(134, 108);				
			
			//�� Clickbtn�� ActionListener ����
			Clickbtn1.addActionListener(new ClickAction());		
			Clickbtn2.addActionListener(new ClickAction());
			Clickbtn3.addActionListener(new ClickAction());
			Clickbtn4.addActionListener(new ClickAction());
			
			setJMenuBar(optionbar);							//optionbar�� Menubar�� ����
			tbinfo.addActionListener(new ClickAction());	//tbinfo�� ActionListener ����
			
			setSize(385, 165);			//������ ����
			setLocation(500, 300);		//��ġ ����
			setResizable(false);		//���������� �Ұ����ϰ� ����
			setVisible(false);			//Visible ��� ����
		}

		class Table1 extends JFrame {				//1�� Table�� �ֹ� ���� �����ϰ� ����ϴ� class
			JLabel name = new JLabel(t1name);		//����� �Է��ߴ� �̸��� �����ϱ� ���� JLabel
			JLabel birth = new JLabel(t1birth);		//����� �Է��ߴ� ��������� �����ϱ� ���� JLabel
			JLabel main = new JLabel(t1main);		//����� �Է��ߴ� ���� �޴��� �����ϱ� ���� JLabel
			JLabel side = new JLabel(t1side);		//����� �Է��ߴ� ���̵� �޴��� �����ϱ� ���� JLabel
			JLabel person = new JLabel(t1person);	//����� �Է��ߴ� �湮�ο� ���� �����ϱ� ���� JLabel
			JLabel phone = new JLabel(t1phone);		//����� �Է��ߴ� ��ȭ��ȣ�� �����ϱ� ���� JLabel
			JLabel num = new JLabel(t1num);			//����� �Է��ߴ� ���̺� ��ȣ�� �����ϱ� ���� JLabel
			JLabel time = new JLabel(t1time);		//����� �Է��ߴ� �湮�ð��� �����ϱ� ���� JLabel
			
			public Table1() {										//Table1 ������
				setTitle("Table 1");								//title ����
				getContentPane();									//���� �۵����� ContentPane ȣ��
				setLayout(null);									//���� ��� ��ġ������ ����
				setModal(true);										//��� ����
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//�� JLabel�� boundary ����
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//�� JLabel�� boundary ����
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//�� ContentPane�� ����
				add(t_name);
				add(t_birth);
				add(t_main);
				add(t_side);
				add(t_person);
				add(t_phone);
				add(t_num);
				add(t_time);
				add(name);
				add(birth);
				add(main);
				add(side);
				add(person);
				add(phone);
				add(num);
				add(time);
				setSize(450, 400);		//������ ����
				setResizable(false);	//���������� �Ұ����ϰ� ����
				setVisible(true);		//Visible ��� ����
			}
		}

		class Table2 extends JFrame {				//2�� Table�� �ֹ� ���� �����ϰ� ����ϴ� class
			JLabel name = new JLabel(t2name);		//����� �Է��ߴ� �̸��� �����ϱ� ���� JLabel
			JLabel birth = new JLabel(t2birth);		//����� �Է��ߴ� ��������� �����ϱ� ���� JLabel
			JLabel main = new JLabel(t2main);		//����� �Է��ߴ� ���� �޴��� �����ϱ� ���� JLabel
			JLabel side = new JLabel(t2side);		//����� �Է��ߴ� ���̵� �޴��� �����ϱ� ���� JLabel
			JLabel person = new JLabel(t2person);	//����� �Է��ߴ� �湮�ο� ���� �����ϱ� ���� JLabel
			JLabel phone = new JLabel(t2phone);		//����� �Է��ߴ� ��ȭ��ȣ�� �����ϱ� ���� JLabel
			JLabel num = new JLabel(t2num);			//����� �Է��ߴ� ���̺� ��ȣ�� �����ϱ� ���� JLabel
			JLabel time = new JLabel(t2time);		//����� �Է��ߴ� �湮�ð��� �����ϱ� ���� JLabel

			public Table2() {										//Table2 ������
				setTitle("Table 2");								//title ����
				getContentPane();									//���� �۵����� ContentPane ȣ��
				setLayout(null);									//���� ��� ��ġ������ ����
				setModal(true);										//��� ����
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//�� JLabel�� boundary ����
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//�� JLabel�� boundary ����
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//�� ContentPane�� ����
				add(t_name);
				add(t_birth);
				add(t_main);
				add(t_side);
				add(t_person);
				add(t_phone);
				add(t_num);
				add(t_time);
				add(name);
				add(birth);
				add(main);
				add(side);
				add(person);
				add(phone);
				add(num);
				add(time);
				setSize(600, 400);			//������ ����
				setResizable(false);		//���������� �Ұ����ϰ� ����
				setVisible(true);			//Visible ��� ����
			}
		}

		class Table3 extends JFrame {				//3�� Table�� �ֹ� ���� �����ϰ� ����ϴ� class
			JLabel name = new JLabel(t3name);		//����� �Է��ߴ� �̸��� �����ϱ� ���� JLabel
			JLabel birth = new JLabel(t3birth);		//����� �Է��ߴ� ��������� �����ϱ� ���� JLabel
			JLabel main = new JLabel(t3main);		//����� �Է��ߴ� ���� �޴��� �����ϱ� ���� JLabel
			JLabel side = new JLabel(t3side);		//����� �Է��ߴ� ���̵� �޴��� �����ϱ� ���� JLabel
			JLabel person = new JLabel(t3person);	//����� �Է��ߴ� �湮�ο� ���� �����ϱ� ���� JLabel
			JLabel phone = new JLabel(t3phone);		//����� �Է��ߴ� ��ȭ��ȣ�� �����ϱ� ���� JLabel
			JLabel num = new JLabel(t3num);			//����� �Է��ߴ� ���̺� ��ȣ�� �����ϱ� ���� JLabel
			JLabel time = new JLabel(t3time);		//����� �Է��ߴ� �湮�ð��� �����ϱ� ���� JLabel

			public Table3() {										//Table3 ������
				setTitle("Table 3");								//title ����
				getContentPane();									//���� �۵����� ContentPane ȣ��
				setLayout(null);									//���� ��� ��ġ������ ����
				setModal(true);										//��� ����
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//�� JLabel�� boundary ����
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//�� JLabel�� boundary ����
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//�� ContentPane�� ����
				add(t_name);
				add(t_birth);
				add(t_main);
				add(t_side);
				add(t_person);
				add(t_phone);
				add(t_num);
				add(t_time);
				add(name);
				add(birth);
				add(main);
				add(side);
				add(person);
				add(phone);
				add(num);
				add(time);
				setSize(600, 400);			//������ ����
				setResizable(false);		//���������� �Ұ����ϰ� ����
				setVisible(true);			//Visible ��� ����
			}
		}

		class Table4 extends JFrame {				//4�� Table�� �ֹ� ���� �����ϰ� ����ϴ� class
			JLabel name = new JLabel(t4name);		//����� �Է��ߴ� �̸��� �����ϱ� ���� JLabel
			JLabel birth = new JLabel(t4birth);		//����� �Է��ߴ� ��������� �����ϱ� ���� JLabel
			JLabel main = new JLabel(t4main);		//����� �Է��ߴ� ���� �޴��� �����ϱ� ���� JLabel
			JLabel side = new JLabel(t4side);		//����� �Է��ߴ� ���̵� �޴��� �����ϱ� ���� JLabel
			JLabel person = new JLabel(t4person);	//����� �Է��ߴ� �湮�ο� ���� �����ϱ� ���� JLabel
			JLabel phone = new JLabel(t4phone);		//����� �Է��ߴ� ��ȭ��ȣ�� �����ϱ� ���� JLabel
			JLabel num = new JLabel(t4num);			//����� �Է��ߴ� ���̺� ��ȣ�� �����ϱ� ���� JLabel
			JLabel time = new JLabel(t4time);		//����� �Է��ߴ� �湮�ð��� �����ϱ� ���� JLabel

			public Table4() {										//Table4 ������
				setTitle("Table 4");								//title ����
				getContentPane();									//���� �۵����� ContentPane ȣ��
				setLayout(null);									//���� ��� ��ġ������ ����
				setModal(true);										//��� ����
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//�� JLabel�� boundary ����
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//�� JLabel�� boundary ����
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//�� ContentPane�� ����
				add(t_name);
				add(t_birth);
				add(t_main);
				add(t_side);
				add(t_person);
				add(t_phone);
				add(t_num);
				add(t_time);
				add(name);
				add(birth);
				add(main);
				add(side);
				add(person);
				add(phone);
				add(num);
				add(time);
				setSize(600, 400);			//������ ����
				setResizable(false);		//���������� �Ұ����ϰ� ����
				setVisible(true);			//Visible ��� ����
			}
		}

		class Table5 extends JFrame {				//5�� Table�� �ֹ� ���� �����ϰ� ����ϴ� class
			JLabel name = new JLabel(t5name);		//����� �Է��ߴ� �̸��� �����ϱ� ���� JLabel
			JLabel birth = new JLabel(t5birth);		//����� �Է��ߴ� ��������� �����ϱ� ���� JLabel
			JLabel main = new JLabel(t5main);		//����� �Է��ߴ� ���� �޴��� �����ϱ� ���� JLabel
			JLabel side = new JLabel(t5side);		//����� �Է��ߴ� ���̵� �޴��� �����ϱ� ���� JLabel
			JLabel person = new JLabel(t5person);	//����� �Է��ߴ� �湮�ο� ���� �����ϱ� ���� JLabel
			JLabel phone = new JLabel(t5phone);		//����� �Է��ߴ� ��ȭ��ȣ�� �����ϱ� ���� JLabel
			JLabel num = new JLabel(t5num);			//����� �Է��ߴ� ���̺� ��ȣ�� �����ϱ� ���� JLabel
			JLabel time = new JLabel(t5time);		//����� �Է��ߴ� �湮�ð��� �����ϱ� ���� JLabel

			public Table5() {										//Table5 ������
				setTitle("Table 5");								//title ����
				getContentPane();									//���� �۵����� ContentPane ȣ��
				setLayout(null);									//���� ��� ��ġ������ ����
				setModal(true);										//��� ����
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//�� JLabel�� boundary ����
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//�� JLabel�� boundary ����
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//�� ContentPane�� ����
				add(t_name);
				add(t_birth);
				add(t_main);
				add(t_side);
				add(t_person);
				add(t_phone);
				add(t_num);
				add(t_time);
				add(name);
				add(birth);
				add(main);
				add(side);
				add(person);
				add(phone);
				add(num);
				add(time);
				setSize(600, 400);			//������ ����
				setResizable(false);		//���������� �Ұ����ϰ� ����
				setVisible(true);			//Visible ��� ����
			}
		}

		class Table6 extends JFrame {				//6�� Table�� �ֹ� ���� �����ϰ� ����ϴ� class
			JLabel name = new JLabel(t6name);		//����� �Է��ߴ� �̸��� �����ϱ� ���� JLabel
			JLabel birth = new JLabel(t6birth);		//����� �Է��ߴ� ��������� �����ϱ� ���� JLabel
			JLabel main = new JLabel(t6main);		//����� �Է��ߴ� ���� �޴��� �����ϱ� ���� JLabel
			JLabel side = new JLabel(t6side);		//����� �Է��ߴ� ���̵� �޴��� �����ϱ� ���� JLabel
			JLabel person = new JLabel(t6person);	//����� �Է��ߴ� �湮�ο� ���� �����ϱ� ���� JLabel
			JLabel phone = new JLabel(t6phone);		//����� �Է��ߴ� ��ȭ��ȣ�� �����ϱ� ���� JLabel
			JLabel num = new JLabel(t6num);			//����� �Է��ߴ� ���̺� ��ȣ�� �����ϱ� ���� JLabel
			JLabel time = new JLabel(t6time);		//����� �Է��ߴ� �湮�ð��� �����ϱ� ���� JLabel

			public Table6() {										//Table6 ������
				setTitle("Table 6");								//title ����
				getContentPane();									//���� �۵����� ContentPane ȣ��
				setLayout(null);									//���� ��� ��ġ������ ����
				setModal(true);										//��� ����
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//�� JLabel�� boundary ����
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//�� JLabel�� boundary ����
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//�� ContentPane�� ����
				add(t_name);
				add(t_birth);
				add(t_main);
				add(t_side);
				add(t_person);
				add(t_phone);
				add(t_num);
				add(t_time);
				add(name);
				add(birth);
				add(main);
				add(side);
				add(person);
				add(phone);
				add(num);
				add(time);
				setSize(600, 400);			//������ ����
				setResizable(false);		//���������� �Ұ����ϰ� ����
				setVisible(true);			//Visible ��� ����
			}
		}

		class Table7 extends JFrame {				//7�� Table�� �ֹ� ���� �����ϰ� ����ϴ� class
			JLabel name = new JLabel(t7name);		//����� �Է��ߴ� �̸��� �����ϱ� ���� JLabel
			JLabel birth = new JLabel(t7birth);		//����� �Է��ߴ� ��������� �����ϱ� ���� JLabel
			JLabel main = new JLabel(t7main);		//����� �Է��ߴ� ���� �޴��� �����ϱ� ���� JLabel
			JLabel side = new JLabel(t7side);		//����� �Է��ߴ� ���̵� �޴��� �����ϱ� ���� JLabel
			JLabel person = new JLabel(t7person);	//����� �Է��ߴ� �湮�ο� ���� �����ϱ� ���� JLabel
			JLabel phone = new JLabel(t7phone);		//����� �Է��ߴ� ��ȭ��ȣ�� �����ϱ� ���� JLabel
			JLabel num = new JLabel(t7num);			//����� �Է��ߴ� ���̺� ��ȣ�� �����ϱ� ���� JLabel
			JLabel time = new JLabel(t7time);		//����� �Է��ߴ� �湮�ð��� �����ϱ� ���� JLabel

			public Table7() {										//Table7 ������
				setTitle("Table 7");								//title ����
				getContentPane();									//���� �۵����� ContentPane ȣ��
				setLayout(null);									//���� ��� ��ġ������ ����
				setModal(true);										//��� ����
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//�� JLabel�� boundary ����
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//�� JLabel�� boundary ����
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//�� ContentPane�� ����
				add(t_name);
				add(t_birth);
				add(t_main);
				add(t_side);
				add(t_person);
				add(t_phone);
				add(t_num);
				add(t_time);
				add(name);
				add(birth);
				add(main);
				add(side);
				add(person);
				add(phone);
				add(num);
				add(time);
				setSize(600, 400);		//������ ����
				setResizable(false);	//���������� �Ұ����ϰ� ����
				setVisible(true);		//Visible ��� ����
			}
		}

		class Table8 extends JFrame {				//8�� Table�� �ֹ� ���� �����ϰ� ����ϴ� class
			JLabel name = new JLabel(t8name);		//����� �Է��ߴ� �̸��� �����ϱ� ���� JLabel
			JLabel birth = new JLabel(t8birth);		//����� �Է��ߴ� ��������� �����ϱ� ���� JLabel
			JLabel main = new JLabel(t8main);		//����� �Է��ߴ� ���� �޴��� �����ϱ� ���� JLabel
			JLabel side = new JLabel(t8side);		//����� �Է��ߴ� ���̵� �޴��� �����ϱ� ���� JLabel
			JLabel person = new JLabel(t8person);	//����� �Է��ߴ� �湮�ο� ���� �����ϱ� ���� JLabel
			JLabel phone = new JLabel(t8phone);		//����� �Է��ߴ� ��ȭ��ȣ�� �����ϱ� ���� JLabel
			JLabel num = new JLabel(t8num);			//����� �Է��ߴ� ���̺� ��ȣ�� �����ϱ� ���� JLabel
			JLabel time = new JLabel(t8time);		//����� �Է��ߴ� �湮�ð��� �����ϱ� ���� JLabel

			public Table8() {										//Table8 ������
				setTitle("Table 8");								//title ����
				getContentPane();									//���� �۵����� ContentPane ȣ��
				setLayout(null);									//���� ��� ��ġ������ ����
				setModal(true);										//��� ����
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//�� JLabel�� boundary ����
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//�� JLabel�� boundary ����
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//�� ContentPane�� ����
				add(t_name);
				add(t_birth);
				add(t_main);
				add(t_side);
				add(t_person);
				add(t_phone);
				add(t_num);
				add(t_time);
				add(name);
				add(birth);
				add(main);
				add(side);
				add(person);
				add(phone);
				add(num);
				add(time);
				setSize(600, 400);		//������ ����
				setResizable(false);	//���������� �Ұ����ϰ� ����
				setVisible(true);		//Visible ��� ����
			}
		}

		class Table9 extends JFrame {				//9�� Table�� �ֹ� ���� �����ϰ� ����ϴ� class
			JLabel name = new JLabel(t9name);		//����� �Է��ߴ� �̸��� �����ϱ� ���� JLabel
			JLabel birth = new JLabel(t9birth);		//����� �Է��ߴ� ��������� �����ϱ� ���� JLabel
			JLabel main = new JLabel(t9main);		//����� �Է��ߴ� ���� �޴��� �����ϱ� ���� JLabel
			JLabel side = new JLabel(t9side);		//����� �Է��ߴ� ���̵� �޴��� �����ϱ� ���� JLabel
			JLabel person = new JLabel(t9person);	//����� �Է��ߴ� �湮�ο� ���� �����ϱ� ���� JLabel
			JLabel phone = new JLabel(t9phone);		//����� �Է��ߴ� ��ȭ��ȣ�� �����ϱ� ���� JLabel
			JLabel num = new JLabel(t9num);			//����� �Է��ߴ� ���̺� ��ȣ�� �����ϱ� ���� JLabel
			JLabel time = new JLabel(t9time);		//����� �Է��ߴ� �湮�ð��� �����ϱ� ���� JLabel

			public Table9() {										//Table9 ������
				setTitle("Table 9");								//title ����
				getContentPane();									//���� �۵����� ContentPane ȣ��
				setLayout(null);									//���� ��� ��ġ������ ����
				setModal(true);										//��� ����
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//�� JLabel�� boundary ����
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//�� JLabel�� boundary ����
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//�� ContentPane�� ����
				add(t_name);
				add(t_birth);
				add(t_main);
				add(t_side);
				add(t_person);
				add(t_phone);
				add(t_num);
				add(t_time);
				add(name);
				add(birth);
				add(main);
				add(side);
				add(person);
				add(phone);
				add(num);
				add(time);
				setSize(600, 400);		//������ ����
				setResizable(false);	//���������� �Ұ����ϰ� ����
				setVisible(true);		//Visible ��� ����
			}
		}

		class Table10 extends JFrame {				//10�� Table�� �ֹ� ���� �����ϰ� ����ϴ� class
			JLabel name = new JLabel(t10name);		//����� �Է��ߴ� �̸��� �����ϱ� ���� JLabel
			JLabel birth = new JLabel(t10birth);	//����� �Է��ߴ� ��������� �����ϱ� ���� JLabel
			JLabel main = new JLabel(t10main);		//����� �Է��ߴ� ���� �޴��� �����ϱ� ���� JLabel
			JLabel side = new JLabel(t10side);		//����� �Է��ߴ� ���̵� �޴��� �����ϱ� ���� JLabel
			JLabel person = new JLabel(t10person);	//����� �Է��ߴ� �湮�ο� ���� �����ϱ� ���� JLabel
			JLabel phone = new JLabel(t10phone);	//����� �Է��ߴ� ��ȭ��ȣ�� �����ϱ� ���� JLabel
			JLabel num = new JLabel(t10num);		//����� �Է��ߴ� ���̺� ��ȣ�� �����ϱ� ���� JLabel
			JLabel time = new JLabel(t10time);		//����� �Է��ߴ� �湮�ð��� �����ϱ� ���� JLabel

			public Table10() {										//Table10 ������
				setTitle("Table 10");								//title ����
				getContentPane();									//���� �۵����� ContentPane ȣ��							
				setLayout(null);									//���� ��� ��ġ������ ����
				setModal(true);										//��� ����
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//�� JLabel�� boundary ����
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//�� JLabel�� boundary ����
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//�� ContentPane�� ����
				add(t_name);
				add(t_birth);
				add(t_main);
				add(t_side);
				add(t_person);
				add(t_phone);
				add(t_num);
				add(t_time);
				add(name);
				add(birth);
				add(main);
				add(side);
				add(person);
				add(phone);
				add(num);
				add(time);
				setSize(600, 400);		//������ ����
				setResizable(false);	//���������� �Ұ����ϰ� ����
				setVisible(true);		//Visible ��� ����
			}
		}

		class Table11 extends JFrame {				//11�� Table�� �ֹ� ���� �����ϰ� ����ϴ� class
			JLabel name = new JLabel(t11name);		//����� �Է��ߴ� �̸��� �����ϱ� ���� JLabel
			JLabel birth = new JLabel(t11birth);	//����� �Է��ߴ� ��������� �����ϱ� ���� JLabel
			JLabel main = new JLabel(t11main);		//����� �Է��ߴ� ���� �޴��� �����ϱ� ���� JLabel
			JLabel side = new JLabel(t11side);		//����� �Է��ߴ� ���̵� �޴��� �����ϱ� ���� JLabel
			JLabel person = new JLabel(t11person);	//����� �Է��ߴ� �湮�ο� ���� �����ϱ� ���� JLabel
			JLabel phone = new JLabel(t11phone);	//����� �Է��ߴ� ��ȭ��ȣ�� �����ϱ� ���� JLabel
			JLabel num = new JLabel(t11num);		//����� �Է��ߴ� ���̺� ��ȣ�� �����ϱ� ���� JLabel
			JLabel time = new JLabel(t11time);		//����� �Է��ߴ� �湮�ð��� �����ϱ� ���� JLabel

			public Table11() {										//Table11 ������
				setTitle("Table 11");								//title ����
				getContentPane();									//���� �۵����� ContentPane ȣ��
				setLayout(null);									//���� ��� ��ġ������ ����
				setModal(true);										//��� ����
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//�� JLabel�� boundary ����
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//�� JLabel�� boundary ����
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//�� ContentPane�� ����
				add(t_name);
				add(t_birth);
				add(t_main);
				add(t_side);
				add(t_person);
				add(t_phone);
				add(t_num);
				add(t_time);
				add(name);
				add(birth);
				add(main);
				add(side);
				add(person);
				add(phone);
				add(num);
				add(time);
				setSize(600, 400);		//������ ����
				setResizable(false);	//���������� �Ұ����ϰ� ����
				setVisible(true);		//Visible ��� ����
			}
		}

		class Table12 extends JFrame {				//12�� Table�� �ֹ� ���� �����ϰ� ����ϴ� class
			JLabel name = new JLabel(t12name);		//����� �Է��ߴ� �̸��� �����ϱ� ���� JLabel
			JLabel birth = new JLabel(t12birth);	//����� �Է��ߴ� ��������� �����ϱ� ���� JLabel
			JLabel main = new JLabel(t12main);		//����� �Է��ߴ� ���� �޴��� �����ϱ� ���� JLabel
			JLabel side = new JLabel(t12side);		//����� �Է��ߴ� ���̵� �޴��� �����ϱ� ���� JLabel
			JLabel person = new JLabel(t12person);	//����� �Է��ߴ� �湮�ο� ���� �����ϱ� ���� JLabel
			JLabel phone = new JLabel(t12phone);	//����� �Է��ߴ� ��ȭ��ȣ�� �����ϱ� ���� JLabel
			JLabel num = new JLabel(t12num);		//����� �Է��ߴ� ���̺� ��ȣ�� �����ϱ� ���� JLabel
			JLabel time = new JLabel(t12time);		//����� �Է��ߴ� �湮�ð��� �����ϱ� ���� JLabel

			public Table12() {										//Table12 ������
				setTitle("Table 12");								//title ����
				getContentPane();									//���� �۵����� ContentPane ȣ��
				setLayout(null);									//���� ��� ��ġ������ ����
				setModal(true);										//��� ����
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//�� JLabel�� boundary ����
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//�� JLabel�� boundary ����
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//�� ContentPane�� ����
				add(t_name);
				add(t_birth);
				add(t_main);
				add(t_side);
				add(t_person);
				add(t_phone);
				add(t_num);
				add(t_time);
				add(name);
				add(birth);
				add(main);
				add(side);
				add(person);
				add(phone);
				add(num);
				add(time);
				setSize(600, 400);		//������ ����
				setResizable(false);	//���������� �Ұ����ϰ� ����
				setVisible(true);		//Visible ��� ����
			}
		}

		class ClickAction implements ActionListener { 									//submenu�� �ֹ�, ���, ����, ���, table ���� ��ȸ�� ���� �۾��� �����ϴ� class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Clickbtn1) {										//�߻��� event�� �ֹ��� ���� ó���� ��
					setModal(false);													//��޸��� ����
					setVisible(false);													//Visible ��� ����
					fdmenu.setVisible(true);											//fdmenu�� Visible ������� ����
				} 
				else if (e.getSource() == Clickbtn2) {									//�߻��� event�� ��꿡 ���� ó���� ��
					setModal(false);													//��޸��� ����
					setVisible(false);													//Visible ��� ����
					if (select == 1 & lucknum[0] == lucky) {			//1�� Table�� ���õǾ��µ� ����Ļ翡 ��÷�Ǿ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[0] = 0;																	
						System.out.println("1�� ���̺��� ���� �Ļ縦 �Ͽ����ϴ�.");
						tbtn[0].setText("�Լ� ����"); 								
						tbtn[0].setBackground(Color.WHITE); 
						tblabel2[0].setText(""); 
						money[0] = 0; 
						for (int i = 0; i < 20; i++) {
							t1money[i] = new JLabel("");
							t1info[i] = "";
							t1price[i] = "";
						}
						event.setVisible(true);								//event�� Visible ������� ����
					} else if (select == 2 & lucknum[1] == lucky) {			//2�� Table�� ���õǾ��µ� ����Ļ翡 ��÷�Ǿ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[1] = 0;	
						System.out.println("2�� ���̺��� ���� �Ļ縦 �Ͽ����ϴ�.");
						tbtn[1].setText("�Լ� ����");
						tbtn[1].setBackground(Color.WHITE);
						tblabel2[1].setText("");
						money[1] = 0;
						for (int i = 0; i < 20; i++) {
							t2money[i] = new JLabel("");
							t2info[i] = "";
							t2price[i] = "";
						}
						event.setVisible(true);								//event�� Visible ������� ����
					} else if (select == 3 & lucknum[2] == lucky) {			//3�� Table�� ���õǾ��µ� ����Ļ翡 ��÷�Ǿ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[2] = 0;							
						System.out.println("3�� ���̺��� ���� �Ļ縦 �Ͽ����ϴ�.");
						tbtn[2].setText("�Լ� ����");
						tbtn[2].setBackground(Color.WHITE);
						tblabel2[2].setText("");
						money[2] = 0;
						for (int i = 0; i < 20; i++) {
							t3money[i] = new JLabel("");
							t3info[i] = "";
							t3price[i] = "";
						}
						event.setVisible(true);								//event�� Visible ������� ����
					} else if (select == 4 & lucknum[3] == lucky) {			//4�� Table�� ���õǾ��µ� ����Ļ翡 ��÷�Ǿ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[3] = 0;							
						System.out.println("4�� ���̺��� ���� �Ļ縦 �Ͽ����ϴ�.");
						tbtn[3].setText("�Լ� ����");
						tbtn[3].setBackground(Color.WHITE);
						tblabel2[3].setText("");
						money[3] = 0;
						for (int i = 0; i < 20; i++) {
							t4money[i] = new JLabel("");
							t4info[i] = "";
							t4price[i] = "";
						}
						event.setVisible(true);								//event�� Visible ������� ����
					} else if (select == 5 & lucknum[4] == lucky) {			//5�� Table�� ���õǾ��µ� ����Ļ翡 ��÷�Ǿ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[4] = 0;							
						System.out.println("5�� ���̺��� ���� �Ļ縦 �Ͽ����ϴ�.");
						tbtn[4].setText("�Լ� ����");
						tbtn[4].setBackground(Color.WHITE);
						tblabel2[4].setText("");
						money[4] = 0;
						for (int i = 0; i < 20; i++) {
							t5money[i] = new JLabel("");
							t5info[i] = "";
							t5price[i] = "";
						}
						event.setVisible(true);								//event�� Visible ������� ����
					} else if (select == 6 & lucknum[5] == lucky) {			//6�� Table�� ���õǾ��µ� ����Ļ翡 ��÷�Ǿ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[5] = 0;							
						System.out.println("6�� ���̺��� ���� �Ļ縦 �Ͽ����ϴ�.");
						tbtn[5].setText("�Լ� ����");
						tbtn[5].setBackground(Color.WHITE);
						tblabel2[5].setText("");
						money[5] = 0;
						for (int i = 0; i < 20; i++) {
							t6money[i] = new JLabel("");
							t6info[i] = "";
							t6price[i] = "";
						}
						event.setVisible(true);								//event�� Visible ������� ����
					} else if (select == 7 & lucknum[6] == lucky) {			//7�� Table�� ���õǾ��µ� ����Ļ翡 ��÷�Ǿ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[6] = 0;							
						System.out.println("7�� ���̺��� ���� �Ļ縦 �Ͽ����ϴ�.");
						tbtn[6].setText("�Լ� ����");
						tbtn[6].setBackground(Color.WHITE);
						tblabel2[6].setText("");
						money[6] = 0;
						for (int i = 0; i < 20; i++) {
							t7money[i] = new JLabel();
							t7info[i] = "";
							t7price[i] = "";
						}
						event.setVisible(true);								//event�� Visible ������� ����
					} else if (select == 8 & lucknum[7] == lucky) {			//8�� Table�� ���õǾ��µ� ����Ļ翡 ��÷�Ǿ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[7] = 0;							
						System.out.println("8�� ���̺��� ���� �Ļ縦 �Ͽ����ϴ�.");
						tbtn[7].setText("�Լ� ����");
						tbtn[7].setBackground(Color.WHITE);
						tblabel2[7].setText("");
						money[7] = 0;
						for (int i = 0; i < 20; i++) {
							t8money[i] = new JLabel("");
							t8info[i] = "";
							t8price[i] = "";
						}
						event.setVisible(true);								//event�� Visible ������� ����
					} else if (select == 9 & lucknum[8] == lucky) {			//9�� Table�� ���õǾ��µ� ����Ļ翡 ��÷�Ǿ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[8] = 0;							
						System.out.println("9�� ���̺��� ���� �Ļ縦 �Ͽ����ϴ�.");
						tbtn[8].setText("�Լ� ����");
						tbtn[8].setBackground(Color.WHITE);
						tblabel2[8].setText("");
						money[8] = 0;
						for (int i = 0; i < 20; i++) {
							t9money[i] = new JLabel("");
							t9info[i] = "";
							t9price[i] = "";
						}
						event.setVisible(true);								//event�� Visible ������� ����
					} else if (select == 10 & lucknum[9] == lucky) {		//10�� Table�� ���õǾ��µ� ����Ļ翡 ��÷�Ǿ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[9] = 0;							
						System.out.println("10�� ���̺��� ���� �Ļ縦 �Ͽ����ϴ�.");
						tbtn[9].setText("�Լ� ����");
						tbtn[9].setBackground(Color.WHITE);
						tblabel2[9].setText("");
						money[9] = 0;
						for (int i = 0; i < 20; i++) {
							t10money[i] = new JLabel("");
							t10info[i] = "";
							t10price[i] = "";
						}
						event.setVisible(true);								//event�� Visible ������� ����
					} else if (select == 11 & lucknum[10] == lucky) {		//11�� Table�� ���õǾ��µ� ����Ļ翡 ��÷�Ǿ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[10] = 0;							
						System.out.println("11�� ���̺��� ���� �Ļ縦 �Ͽ����ϴ�.");
						tbtn[10].setText("�Լ� ����");
						tbtn[10].setBackground(Color.WHITE);
						tblabel2[10].setText("");
						money[10] = 0;
						for (int i = 0; i < 20; i++) {
							t11money[i] = new JLabel("");
							t11info[i] = "";
							t11price[i] = "";
						}
						event.setVisible(true);								//event�� Visible ������� ����
					} else if (select == 12 & lucknum[11] == lucky) {		//12�� Table�� ���õǾ��µ� ����Ļ翡 ��÷�Ǿ��� �� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[11] = 0;							
						System.out.println("12�� ���̺��� ���� �Ļ縦 �Ͽ����ϴ�.");
						tbtn[11].setText("�Լ� ����");
						tbtn[11].setBackground(Color.WHITE);
						tblabel2[11].setText("");
						money[11] = 0;
						for (int i = 0; i < 20; i++) {
							t12money[i] = new JLabel("");
							t12info[i] = "";
							t12price[i] = "";
						}
						event.setVisible(true);								//event�� Visible ������� ����
					} else if (select == 1) {											//1�� Table�� ���õǾ��ٸ�	
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t1info[i]);								//�ֹ��� ���� �̸��� ����ϱ� ���� ����
							t1money[i] = new JLabel(t1price[i]); 						//�ֹ��� ���� ���� ����ϱ� ���� ����
							t1money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t1money boundary ����
							pay.add(t1money[i]);										//pay�� t1money ����
							south2.setText("< �� �� �� ��  > : " + money[0] + " ���Դϴ�."); 	//south2�� ǥ���� ���� �����
						}
						pay.setVisible(true);  											//Pay�� Visible ������� ����
					} else if (select == 2) {											//2�� Table�� ���õǾ��ٸ�	
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t2info[i]);								//�ֹ��� ���� �̸��� ����ϱ� ���� ����
							t2money[i] = new JLabel(t2price[i]); 						//�ֹ��� ���� ���� ����ϱ� ���� ����
							t2money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t2money boundary ����
							pay.add(t2money[i]);										//pay�� t2money ����
							south2.setText("< �� �� �� ��  > : " + money[1] + " ���Դϴ�."); 	//south2�� ǥ���� ���� �����
						}
						pay.setVisible(true);  											//Pay�� Visible ������� ����
					} else if (select == 3) {											//3�� Table�� ���õǾ��ٸ�		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t3info[i]);								//�ֹ��� ���� �̸��� ����ϱ� ���� ����
							t3money[i] = new JLabel(t3price[i]); 						//�ֹ��� ���� ���� ����ϱ� ���� ����
							t3money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t3money boundary ����
							pay.add(t3money[i]);										//pay�� t3money ����
							south2.setText("< �� �� �� ��  > : " + money[2] + " ���Դϴ�."); 	//south2�� ǥ���� ���� �����
						}
						pay.setVisible(true);  											//Pay�� Visible ������� ����
					} else if (select == 4) {											//4�� Table�� ���õǾ��ٸ�		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t4info[i]);								//�ֹ��� ���� �̸��� ����ϱ� ���� ����
							t4money[i] = new JLabel(t4price[i]); 						//�ֹ��� ���� ���� ����ϱ� ���� ����
							t4money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t4money boundary ����
							pay.add(t4money[i]);										//pay�� t4money ����
							south2.setText("< �� �� �� ��  > : " + money[3] + " ���Դϴ�."); 	//south2�� ǥ���� ���� �����
						}
						pay.setVisible(true);  											//Pay�� Visible ������� ����
					} else if (select == 5) {											//5�� Table�� ���õǾ��ٸ�	
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t5info[i]);								//�ֹ��� ���� �̸��� ����ϱ� ���� ����
							t5money[i] = new JLabel(t5price[i]); 						//�ֹ��� ���� ���� ����ϱ� ���� ����
							t5money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t5money boundary ����
							pay.add(t5money[i]);										//pay�� t5money ����
							south2.setText("< �� �� �� ��  > : " + money[4] + " ���Դϴ�."); 	//south2�� ǥ���� ���� �����
						}
						pay.setVisible(true);  											//Pay�� Visible ������� ����
					} else if (select == 6) {											//6�� Table�� ���õǾ��ٸ�		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t6info[i]);								//�ֹ��� ���� �̸��� ����ϱ� ���� ����
							t6money[i] = new JLabel(t6price[i]); 						//�ֹ��� ���� ���� ����ϱ� ���� ����
							t6money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t6money boundary ����
							pay.add(t6money[i]);										//pay�� t6money ����
							south2.setText("< �� �� �� ��  > : " + money[5] + " ���Դϴ�."); 	//south2�� ǥ���� ���� �����
						}
						pay.setVisible(true);  											//Pay�� Visible ������� ����
					} else if (select == 7) {											//7�� Table�� ���õǾ��ٸ�		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t7info[i]);								//�ֹ��� ���� �̸��� ����ϱ� ���� ����
							t7money[i] = new JLabel(t7price[i]); 						//�ֹ��� ���� ���� ����ϱ� ���� ����
							t7money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t7money boundary ����
							pay.add(t7money[i]);										//pay�� t7money ����
							south2.setText("< �� �� �� ��  > : " + money[6] + " ���Դϴ�."); 	//south2�� ǥ���� ���� �����
						}
						pay.setVisible(true);  											//Pay�� Visible ������� ����
					} else if (select == 8) {											//8�� Table�� ���õǾ��ٸ�	
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t8info[i]);								//�ֹ��� ���� �̸��� ����ϱ� ���� ����
							t8money[i] = new JLabel(t8price[i]); 						//�ֹ��� ���� ���� ����ϱ� ���� ����
							t8money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t8money boundary ����
							pay.add(t8money[i]);										//pay�� t8money ����
							south2.setText("< �� �� �� ��  > : " + money[7] + " ���Դϴ�."); 	//south2�� ǥ���� ���� �����
						}
						pay.setVisible(true);  											//Pay�� Visible ������� ����
					} else if (select == 9) {											//9�� Table�� ���õǾ��ٸ�		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t9info[i]);								//�ֹ��� ���� �̸��� ����ϱ� ���� ����
							t9money[i] = new JLabel(t9price[i]); 						//�ֹ��� ���� ���� ����ϱ� ���� ����
							t9money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t9money boundary ����
							pay.add(t9money[i]);										//pay�� t9money ����
							south2.setText("< �� �� �� ��  > : " + money[8] + " ���Դϴ�."); 	//south2�� ǥ���� ���� �����
						}
						pay.setVisible(true);  											//Pay�� Visible ������� ����
					} else if (select == 10) {											//10�� Table�� ���õǾ��ٸ�		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t10info[i]);							//�ֹ��� ���� �̸��� ����ϱ� ���� ����
							t10money[i] = new JLabel(t10price[i]); 						//�ֹ��� ���� ���� ����ϱ� ���� ����
							t10money[i].setBounds(195, 40 + (i * 30), 100, 25); 		//t10money boundary ����
							pay.add(t10money[i]);										//pay�� t10money ����
							south2.setText("< �� �� �� ��  > : " + money[9] + " ���Դϴ�."); 	//south2�� ǥ���� ���� �����
						}
						pay.setVisible(true);  											//Pay�� Visible ������� ����
					} else if (select == 11) {											//11�� Table�� ���õǾ��ٸ�	
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t11info[i]);							//�ֹ��� ���� �̸��� ����ϱ� ���� ����
							t11money[i] = new JLabel(t11price[i]); 						//�ֹ��� ���� ���� ����ϱ� ���� ����
							t11money[i].setBounds(195, 40 + (i * 30), 100, 25); 		//t11money boundary ����
							pay.add(t11money[i]);										//pay�� t11money ����
							south2.setText("< �� �� �� ��  > : " + money[10] + " ���Դϴ�."); 	//south2�� ǥ���� ���� �����
						}
						pay.setVisible(true);  											//Pay�� Visible ������� ����
					} else if (select == 12) {											//12�� Table�� ���õǾ��ٸ�		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t12info[i]);							//�ֹ��� ���� �̸��� ����ϱ� ���� ����
							t12money[i] = new JLabel(t12price[i]); 						//�ֹ��� ���� ���� ����ϱ� ���� ����
							t12money[i].setBounds(195, 40 + (i * 30), 100, 25); 		//t12money boundary ����
							pay.add(t12money[i]);										//pay�� t12money ����
							south2.setText("< �� �� �� ��  > : " + money[11] + " ���Դϴ�."); 	//south2�� ǥ���� ���� �����
						}
						pay.setVisible(true);  											//Pay�� Visible ������� ����
					} 
				} else if (e.getSource() == Clickbtn3) { 								//�߻��� event�� ���࿡ ���� ó���� ��	
					setModal(false);													//��޸��� ����
					setVisible(false);													//Visible ��� ����
					int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ� ?", 	//���࿩�θ� ��Ȯ���ϱ� ���� confirmDialog
							"Confirm", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) { 		//confirmDialog���� Yes�� �������� ��
						setVisible(false);							//Visible ��� ����
						//Reservation�� �ʿ��� ������ �Է¹��� �� �ʿ��� JTextField �ʱ�ȭ
						namefield.setText("");						
						birthfield.setText("");
						man.setSelected(false);
						hpfield1.setText("");
						hpfield2.setText("");
						hpfield3.setText("");
						reser.setVisible(true);
					}					
				} else if (e.getSource() == Clickbtn4) {		//�߻��� event�� ��ҿ� ���� ó���� ��
					setVisible(false);							//Visible ��� ����
					
					for (int i = 0; i < 20; i++)
						foodinfo[i].setText("");				//foodinfo �ʱ�ȭ
					
					if (select == 1) {							//1�� Table�� ���õǾ��ٸ� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[0] = 0;
						tbtn[0].setText("�Լ� ����");
						tbtn[0].setBackground(Color.WHITE);
						tblabel2[0].setText("");
						money[0] = 0;
						for (int i = 0; i < 20; i++) {
							t1money[i].setText("");
							t1info[i] = "";
							t1price[i] = "";
						}
					}else if (select == 2) {					//2�� Table�� ���õǾ��ٸ� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[1] = 0;
						tbtn[1].setText("�Լ� ����");
						tbtn[1].setBackground(Color.WHITE);
						tblabel2[1].setText("");
						money[1] = 0;
						for (int i = 0; i < 20; i++) {
							t2money[i].setText("");
							t2info[i] = "";
							t2price[i] = "";
						}
					}else if (select == 3) {					//3�� Table�� ���õǾ��ٸ� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[2] = 0;
						tbtn[2].setText("�Լ� ����");
						tbtn[2].setBackground(Color.WHITE);
						tblabel2[2].setText("");
						money[2] = 0;
						for (int i = 0; i < 20; i++) {
							t3money[i].setText("");
							t3info[i] = "";
							t3price[i] = "";
						}
					}else if (select == 4) {					//4�� Table�� ���õǾ��ٸ� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[3] = 0;
						tbtn[3].setText("�Լ� ����");
						tbtn[3].setBackground(Color.WHITE);
						tblabel2[3].setText("");
						money[3] = 0;
						for (int i = 0; i < 20; i++) {
							t4money[i].setText("");
							t4info[i] = "";
							t4price[i] = "";
						}
					}else if (select == 5) {					//5�� Table�� ���õǾ��ٸ� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[4] = 0;
						tbtn[4].setText("�Լ� ����");
						tbtn[4].setBackground(Color.WHITE);
						tblabel2[4].setText("");
						money[4] = 0;
						for (int i = 0; i < 20; i++) {
							t5money[i].setText("");
							t5info[i] = "";
							t5price[i] = "";
						}
					}else if (select == 6) {					//6�� Table�� ���õǾ��ٸ� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[5] = 0;
						tbtn[5].setText("�Լ� ����");
						tbtn[5].setBackground(Color.WHITE);
						tblabel2[5].setText("");
						money[5] = 0;
						for (int i = 0; i < 20; i++) {
							t6money[i].setText("");
							t6info[i] = "";
							t6price[i] = "";
						}
					} else if (select == 7) {					//7�� Table�� ���õǾ��ٸ� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[6] = 7;
						tbtn[6].setText("�Լ� ����");
						tbtn[6].setBackground(Color.WHITE);
						tblabel2[6].setText("");
						money[6] = 0;
						for (int i = 0; i < 20; i++) {
							t7money[i].setText("");
							t7info[i] = "";
							t7price[i] = "";
						}
					} else if (select == 8) {					//8�� Table�� ���õǾ��ٸ� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[7] = 0;
						tbtn[7].setText("�Լ� ����");
						tbtn[7].setBackground(Color.WHITE);
						tblabel2[7].setText("");
						money[7] = 0;
						for (int i = 0; i < 20; i++) {
							t8money[i].setText("");
							t8info[i] = "";
							t8price[i] = "";
						}
					} else if (select == 9) {					//9�� Table�� ���õǾ��ٸ� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[8] = 0;
						tbtn[8].setText("�Լ� ����");
						tbtn[8].setBackground(Color.WHITE);
						tblabel2[8].setText("");
						money[8] = 0;
						for (int i = 0; i < 20; i++) {
							t9money[i].setText("");
							t9info[i] = "";
							t9price[i] = "";
						}
					} else if (select == 10) {					//10�� Table�� ���õǾ��ٸ� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[9] = 10;
						tbtn[9].setText("�Լ� ����");
						tbtn[9].setBackground(Color.WHITE);
						tblabel2[9].setText("");
						money[9] = 0;
						for (int i = 0; i < 20; i++) {
							t10money[i].setText("");
							t10info[i] = "";
							t10price[i] = "";
						}
					} else if (select == 11) {					//11�� Table�� ���õǾ��ٸ� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[10] = 0;
						tbtn[10].setText("�Լ� ����");
						tbtn[10].setBackground(Color.WHITE);
						tblabel2[10].setText("");
						money[10] = 0;
						for (int i = 0; i < 20; i++) {
							t11money[i].setText("");
							t11info[i] = "";
							t11price[i] = "";
						}
					} else if (select == 12) {					//12�� Table�� ���õǾ��ٸ� �����ϴ� �����͸� �⺻ ������ �ʱ�ȭ
						num[11] = 0;
						tbtn[11].setText("�Լ� ����");
						tbtn[11].setBackground(Color.WHITE);
						tblabel2[11].setText("");
						money[11] = 0;
						for (int i = 0; i < 20; i++) {
							t12money[i].setText("");
							t12info[i] = "";
							t12price[i] = "";
						}
					}
				}
				if (e.getSource() == tbinfo) {								//�߻��� event�� table ���� ��ȸ�� ���� ó���� ��
					if (select == 1) {										//1�� Table�� ���õǾ��ٸ�
						if (tbtn[0].getBackground() == Color.YELLOW)		//����Ǿ� �ִ� ��쿡��
							new Table1();									//���������� �����ֱ� ���� Table1 ������ ȣ��
						else if (tbtn[0].getBackground() == Color.GREEN)	//�ֹ��Ǿ� �ִ� ��쿡��
							new OrderInfo();								//�ֹ������� �����ֱ� ���� OrderInfo ������ ȣ��
					} else if (select == 2) {								//2�� Table�� ���õǾ��ٸ�
						if (tbtn[1].getBackground() == Color.YELLOW)		//����Ǿ� �ִ� ��쿡��
							new Table2();									//���������� �����ֱ� ���� Table2 ������ ȣ��
						else if (tbtn[1].getBackground() == Color.GREEN)	//�ֹ��Ǿ� �ִ� ��쿡��
							new OrderInfo();								//�ֹ������� �����ֱ� ���� OrderInfo ������ ȣ��
					} else if (select == 3) {								//3�� Table�� ���õǾ��ٸ�
						if (tbtn[2].getBackground() == Color.YELLOW)		//����Ǿ� �ִ� ��쿡��
							new Table3();									//���������� �����ֱ� ���� Table3 ������ ȣ��
						else if (tbtn[2].getBackground() == Color.GREEN)	//�ֹ��Ǿ� �ִ� ��쿡��
							new OrderInfo();								//�ֹ������� �����ֱ� ���� OrderInfo ������ ȣ��
					} else if (select == 4) {								//4�� Table�� ���õǾ��ٸ�
						if (tbtn[3].getBackground() == Color.YELLOW)		//����Ǿ� �ִ� ��쿡��
							new Table4();									//���������� �����ֱ� ���� Table4 ������ ȣ��
						else if (tbtn[3].getBackground() == Color.GREEN)	//�ֹ��Ǿ� �ִ� ��쿡��
							new OrderInfo();								//�ֹ������� �����ֱ� ���� OrderInfo ������ ȣ��
					} else if (select == 5) {								//5�� Table�� ���õǾ��ٸ�
						if (tbtn[4].getBackground() == Color.YELLOW)		//����Ǿ� �ִ� ��쿡��
							new Table5();									//���������� �����ֱ� ���� Table5 ������ ȣ��
						else if (tbtn[4].getBackground() == Color.GREEN)	//�ֹ��Ǿ� �ִ� ��쿡��
							new OrderInfo();								//�ֹ������� �����ֱ� ���� OrderInfo ������ ȣ��
					} else if (select == 6) {								//6�� Table�� ���õǾ��ٸ�
						if (tbtn[5].getBackground() == Color.YELLOW)		//����Ǿ� �ִ� ��쿡��
							new Table6();									//���������� �����ֱ� ���� Table6 ������ ȣ��
						else if (tbtn[5].getBackground() == Color.GREEN)	//�ֹ��Ǿ� �ִ� ��쿡��
							new OrderInfo();								//�ֹ������� �����ֱ� ���� OrderInfo ������ ȣ��
					} else if (select == 7) {								//7�� Table�� ���õǾ��ٸ�
						if (tbtn[6].getBackground() == Color.YELLOW)		//����Ǿ� �ִ� ��쿡��
							new Table7();									//���������� �����ֱ� ���� Table7 ������ ȣ��
						else if (tbtn[6].getBackground() == Color.GREEN)	//�ֹ��Ǿ� �ִ� ��쿡��
							new OrderInfo();								//�ֹ������� �����ֱ� ���� OrderInfo ������ ȣ��
					} else if (select == 8) {								//8�� Table�� ���õǾ��ٸ�
						if (tbtn[7].getBackground() == Color.YELLOW)		//����Ǿ� �ִ� ��쿡��
							new Table8();									//���������� �����ֱ� ���� Table8 ������ ȣ��
						else if (tbtn[7].getBackground() == Color.GREEN)	//�ֹ��Ǿ� �ִ� ��쿡��
							new OrderInfo();								//�ֹ������� �����ֱ� ���� OrderInfo ������ ȣ��
					} else if (select == 9) {								//9�� Table�� ���õǾ��ٸ�
						if (tbtn[8].getBackground() == Color.YELLOW)		//����Ǿ� �ִ� ��쿡��
							new Table9();									//���������� �����ֱ� ���� Table9 ������ ȣ��
						else if (tbtn[8].getBackground() == Color.GREEN)	//�ֹ��Ǿ� �ִ� ��쿡��
							new OrderInfo();								//�ֹ������� �����ֱ� ���� OrderInfo ������ ȣ��
					} else if (select == 10) {								//10�� Table�� ���õǾ��ٸ�
						if (tbtn[9].getBackground() == Color.YELLOW)		//����Ǿ� �ִ� ��쿡��
							new Table10();									//���������� �����ֱ� ���� Table10 ������ ȣ��
						else if (tbtn[9].getBackground() == Color.GREEN)	//�ֹ��Ǿ� �ִ� ��쿡��
							new OrderInfo();								//�ֹ������� �����ֱ� ���� OrderInfo ������ ȣ��
					} else if (select == 11) {								//11�� Table�� ���õǾ��ٸ�
						if (tbtn[10].getBackground() == Color.YELLOW)		//����Ǿ� �ִ� ��쿡��
							new Table11();									//���������� �����ֱ� ���� Table11 ������ ȣ��
						else if (tbtn[10].getBackground() == Color.GREEN)	//�ֹ��Ǿ� �ִ� ��쿡��
							new OrderInfo();								//�ֹ������� �����ֱ� ���� OrderInfo ������ ȣ��
					} else if (select == 12) {								//12�� Table�� ���õǾ��ٸ�
						if (tbtn[11].getBackground() == Color.YELLOW)		//����Ǿ� �ִ� ��쿡��
							new Table12();									//���������� �����ֱ� ���� Table12 ������ ȣ��
						else if (tbtn[11].getBackground() == Color.GREEN)	//�ֹ��Ǿ� �ִ� ��쿡��
							new OrderInfo();								//�ֹ������� �����ֱ� ���� OrderInfo ������ ȣ��
					}
				}
			}
		}
	}

	class CurrentTime implements Runnable {												//����ð��� ����ϰų� �ֹ��� ��� �ð��� ǥ���� �� �ش� �ð��� �����ϴ� class
		int n = 0;																		//:�� �����Ÿ��� �������ֱ� ���� ����
		public void run() {																//Runnable �������̽��� run �޼ҵ� �������̵�
			while (true) {
				Date dt = new Date();													//���� ��¥�� �ð��� ����� ��ü�� �����ϱ� ���� Date ������ ȣ��
				//���� �ٸ� �ʿ��� ���·� ���� ����
				SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				SimpleDateFormat nowtime2 = new SimpleDateFormat("yyyy - MM - dd");
				SimpleDateFormat nowtime3;
				if (n % 2 == 1)															//if���� �����ɶ��� :�� ��Ÿ���� ����
					nowtime3 = new SimpleDateFormat("a hh:mm");
				else
					nowtime3 = new SimpleDateFormat("a hh mm");
				SimpleDateFormat nowtime4 = new SimpleDateFormat("MMddhhmmss");
				
				//���� �ʿ��� ������ ������ ���¸� ����
				ran = Integer.parseInt(nowtime4.format(dt));
				nowDate = nowtime.format(dt);
				timelabel1.setText(nowtime2.format(dt));
				timelabel2.setText(nowtime3.format(dt));
				n++;
				try {
					Thread.sleep(500);													//thread�� 0.5�ʵ��� sleep ó��
				} catch (InterruptedException e) {										//InterruptedException ���� ó��
					return;
				}
			}
		}
	}
	
	class MyThread implements Runnable {							//main �ϴܿ� ���� �ٲ�鼭 �̵��ϴ� ������ ����ϴ� class
		int m = 1200;												//������ x��ǥ�� �������ֱ� ���� ����
		int a = 30, b = 30, c = 30, d = 0;							//������ ���� ������ ���Ͽ� ���� �ٲ�� �ϱ� ���� ����
		public void run() {											//Runnable �������̽��� run �޼ҵ� �������̵�
			while (true) {
				welcome.setBounds(m, 700, 50000, 40);				//welcome boundary ����
				m--;
				//d�� ���� ���� rgb���� a,b,c�� �����Ͽ� ������ ���Ͽ� ���� ���� ���ϵ��� ����
				if (a == b & a == c)
					d++;
				if (d % 6 == 0)
					welcome.setForeground(new Color(a, b, c));
				else if (d % 6 == 1)
					welcome.setForeground(new Color(b, a, c));
				else if (d % 6 == 2)
					welcome.setForeground(new Color(a, c, b));
				else if (d % 6 == 3)
					welcome.setForeground(new Color(c, a, b));
				else if (d % 6 == 4)
					welcome.setForeground(new Color(c, b, a));
				else if (d % 6 == 5)
					welcome.setForeground(new Color(b, c, a));

				if (b == 30 & c == 30 & a < 240) {
					a++;
				} else if (a == 240 & b < 240 & c < 240) {
					b++;
				} else if (a == 240 & b == 240 & c < 240) {
					c++;
				} else if (a > 30 & a <= 240 & b == 240 & c == 240) {
					a--;
				} else if (a == 30 & b > 30 & c == 240) {
					b--;
				} else if (a == 30 & b == 30 & c > 30) {
					c--;
				}
				
				if (m < -2600) 
					m = 1200;
				
				try {
					Thread.sleep(5);					//thread�� 0.005�ʵ��� sleep ó��
				} catch (InterruptedException e) {		//InterruptedException ���� ó��
					return;
				}
			}
		}
	}
	
	class Event extends JDialog {									//����Ļ翡 ��÷�Ǿ��� ��츦 ó���ϴ� class
		Event() {													//Event ������
			setTitle("Event ��÷!");									//title ����
			getContentPane();										//���� �۵����� ContentPane ȣ��
			setModal(true);											//��� ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setSize(700, 500);										//������ ����
			setVisible(false);										//Visible ��� ����
		}
		public void paint(Graphics g) { 								
			Image img = images.eventimg().getImage();				//event ��÷����� ǥ���ϱ� ���� image�� ����ϱ� ���� eventimg ������ ȣ�� 
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);	//img�� graphicsó���� ���� image�� ǥ��
		}
	}
	
	class Reservation extends JDialog { 							//Reservation�� ���õ� ó���� �ϴ� class
		Reservation() {												//Reservation ������
			setTitle("���� ���� �ý���");								//title ����
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//VIP�� ���õ� ó���� �ϱ� ���� JMenuItem
			mn1 = new JMenuItem("VIP 1");  											
			mn2 = new JMenuItem("VIP 2"); 				
			mn3 = new JMenuItem("VIP 3"); 				
			mn4 = new JMenuItem("VIP 4"); 				
			mn5 = new JMenuItem("�ʱ�ȭ "); 				
			mn6 = new JMenuItem("Close"); 				

			//menu�� �� menu item�� ����
			menu.add(mn1); 				
			menu.add(mn2); 				
			menu.add(mn3); 				
			menu.add(mn4); 				
			menu.add(mn5); 				
			menu.add(mn6); 			
			menubar.add(menu);			//menubar�� menu ���� 				
			setJMenuBar(menubar); 		//menubar�� JMenubar�� ����
			
			//�� menu item�� ActionListener�� ����
			mn1.addActionListener(new MyActionListener()); 				
			mn2.addActionListener(new MyActionListener()); 				
			mn3.addActionListener(new MyActionListener()); 				
			mn4.addActionListener(new MyActionListener()); 				
			mn5.addActionListener(new MyActionListener()); 				
			mn6.addActionListener(new MyActionListener()); 				
			menu.addActionListener(new MyActionListener()); 			

			contentpane = getContentPane();						//���� �۵����� ContentPane ȣ��
			contentpane.setLayout(new BorderLayout());			//BorderLayout ��ġ������ ����
			
			//BorderLayout ������ area�� panel ����
			add(new SouthPanel(), BorderLayout.SOUTH);
			add(new NorthPanel(), BorderLayout.NORTH);
			add(new CenterPanel(), BorderLayout.CENTER);

			setSize(420, 600);			//������ ����
			setLocation(1365, 100);		//��ġ ����
			setResizable(false);		//���������� �Ұ����ϰ� ����
			setVisible(false);			//Visible ��� ����
			la.setFocusable(true);		//��Ŀ���� ������ �� �ֵ��� ����
			la.requestFocus();			//��Ŀ�� ��û
		}

		class SouthPanel extends JPanel {								//Reservation ������ �ʿ��� ����, ������Ҹ� ó���ϴ� class
			SouthPanel() {												//SouthPanel ������
				getContentPane();										//���� �۵����� ContentPane ȣ��
				setBackground(Color.LIGHT_GRAY);						//���� ����

				ok = new JButton("����", images.yesimg());				//yes image�� Ȱ���Ͽ� ������ �ð������� ǥ���ϴ� JButton
				ok.addActionListener(new MyActionListener());			//ok�� ActionListener ����
				add(ok);												//ok ����
				cancel = new JButton("�������", images.noimg());			//no image�� Ȱ���Ͽ� ������Ҹ� �ð������� ǥ���ϴ� JButton
				cancel.addActionListener(new MyActionListener()); 		//cancel�� ActionListener ����
				add(cancel);											//cancel ����
			}
		}

		class NorthPanel extends JPanel {								//Reservation ������ ��µǴ� ������ ���� event�� ó���ϴ� class
			NorthPanel() {												//NorthPanel ������
				getContentPane();										//���� �۵����� ContentPane ȣ��
				add(la);												//la ����
				la.addMouseMotionListener(new MyMouseAdapter());		//la�� MouseMotionListener ����
			}
		}

		class CenterPanel extends JPanel {								//Reservation ������ �ʿ��� ������ �Է¹޴� class
			public CenterPanel() {										//CenterPanel ������
				getContentPane();										//���� �۵����� ContentPane ȣ��
				setLayout(null);										//���� ��� ��ġ������ ����
				setBackground(Color.WHITE);								//���� ����	

				//reservation ������ �ʿ��� ������ �Է¹ޱ� ���� JLabel
				manofwoman = new JLabel();
				myperson = new JLabel();
				name = new JLabel("�� ��");
				birth = new JLabel("�������");
				mainmenu = new JLabel("MAIN DISH");
				sidemenu = new JLabel("SIDE DISH");
				person = new JLabel("�� ��");
				phone = new JLabel("�޴���");
				time = new JLabel("�湮�ð�");
				sum = new JLabel("�ο���");
				led = new JLabel("������ �������ּ���.");
				ttable = new JLabel("Table");
				man = new JRadioButton("����"); 						
				woman = new JCheckBox("����"); 

				//reservation ������ �ʿ��� ������ �Է¹ޱ� ���� JLabel�� ��Ʈ ����
				name.setFont(new Font("���ü", Font.BOLD, 15));
				birth.setFont(new Font("���ü", Font.BOLD, 15));
				phone.setFont(new Font("���ü", Font.BOLD, 15));
				mainmenu.setFont(new Font("���ü", Font.BOLD, 15));
				sidemenu.setFont(new Font("���ü", Font.BOLD, 15));
				person.setFont(new Font("���ü", Font.BOLD, 15));
				time.setFont(new Font("���ü", Font.BOLD, 15));
				sum.setFont(new Font("���ü", Font.BOLD, 15));
				led.setFont(new Font("���ü", Font.BOLD, 15));
				ttable.setFont(new Font("���ü", Font.BOLD, 15)); 
				man.setFont(new Font("", Font.BOLD, 12));
				woman.setFont(new Font("", Font.BOLD, 12));
				
				g = new ButtonGroup();								//�ϳ��� ó�� �������� �����ϱ� ���� �ʿ��� ButtonGroup
				g.add(man);											//ButtonGroup�� man �߰�
				g.add(woman);										//ButtonGroup�� woman �߰�
				
				man.addItemListener(new MyItemListener());			//man�� ItemListener ����
				woman.addItemListener(new MyItemListener());		//woman�� ItemListener ����

				//reservation ������ �ʿ��� ������ �Է¹ޱ� ���� JTextField, JLabel, JComboBox
				namefield = new JTextField("");       
				birthfield = new JTextField("");  
				hpfield1 = new JTextField("");    
				hpfield2 = new JTextField("");	 
				hpfield3 = new JTextField("");	 
				JLabel hipon = new JLabel("-");
				JLabel hipon2 = new JLabel("-");
				combox = new JComboBox(ea);
				timebox = new JComboBox(ea2);
				mainbox = new JComboBox(menuString);
				sidebox = new JComboBox(sideString);
				tablebox = new JComboBox(tablenum);
	
				//������ JTextField, JLabel, JComboBox�� ActionListener ����
				namefield.addActionListener(new MyActionListener());
				birthfield.addActionListener(new MyActionListener());
				hpfield3.addActionListener(new MyActionListener());
				combox.addActionListener(new MyActionListener()); 
				mainbox.addActionListener(new MyActionListener()); 
				sidebox.addActionListener(new MyActionListener()); 

				man.setBackground(Color.WHITE);							//man�� ���� ����
				woman.setBackground(Color.WHITE);						//woman�� ���� ����
				
				//������ JTextField, JLabel, JComboBox Boundary ����
				name.setBounds(20, 25, 100, 20);
				birth.setBounds(20, 65, 100, 20);
				mainmenu.setBounds(20, 105, 100, 20);
				sidemenu.setBounds(20, 145, 100, 20);
				person.setBounds(20, 185, 100, 20);
				phone.setBounds(20, 305, 100, 20); 
				sum.setBounds(20, 345, 100, 20);
				time.setBounds(20, 385, 100, 20);
				ttable.setBounds(20, 425, 100, 20);
				namefield.setBounds(120, 20, 100, 30);
				birthfield.setBounds(120, 60, 100, 30);
				mainbox.setBounds(120, 100, 200, 30);
				sidebox.setBounds(120, 140, 200, 30);
				man.setBounds(120, 180, 100, 30);
				woman.setBounds(120, 210, 100, 30);
				led.setBounds(120, 240, 150, 30);
				manofwoman.setBounds(270, 180, 100, 100);
				hpfield1.setBounds(120, 300, 50, 30);
				hipon.setBounds(179, 300, 10, 30);
				hpfield2.setBounds(190, 300, 50, 30);
				hipon2.setBounds(249, 300, 10, 30);
				hpfield3.setBounds(260, 300, 50, 30);
				combox.setBounds(120, 340, 100, 30);
				myperson.setBounds(180, 340, 100, 30);
				timebox.setBounds(120, 380, 100, 30);
				tablebox.setBounds(120, 420, 100, 30);

				//�� ContentPane�� ����
				add(name);
				add(birth);
				add(phone);
				add(mainmenu);
				add(sidemenu);
				add(time);
				add(person);
				add(sum);
				add(namefield);
				add(birthfield);
				add(mainbox);
				add(sidebox);
				add(hpfield1);
				add(hpfield2);
				add(hpfield3);
				add(combox);
				add(timebox);
				add(hipon);
				add(hipon2);
				add(manofwoman);
				add(tablebox);
				add(led);
				add(man);
				add(woman);
				add(myperson);
				add(ttable);
				
				namefield.setFocusable(true);		//��Ŀ���� ������ �� �ֵ��� ����	
				namefield.requestFocus();			//��Ŀ�� ��û
				birthfield.setFocusable(true);		//��Ŀ���� ������ �� �ֵ��� ����	
				birthfield.requestFocus();			//��Ŀ�� ��û
				hpfield3.setFocusable(true);		//��Ŀ���� ������ �� �ֵ��� ����	
				hpfield3.requestFocus();			//��Ŀ�� ��û
			}
		}

		class MyActionListener implements ActionListener { 			//Reservation �������� �ʿ��� event�� ó���ϴ� class
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == namefield){	 					//�߻��� event�� namefield���� �� ��
					System.out.println(namefield.getText()); 		//namefield�� �Էµ� ���� ���
					namefield.setVisible(false);					//namefield Visible ��� ����
				}
				if(e.getSource() == birthfield){					//�߻��� event�� birthfield���� �� ��
					System.out.println(birthfield.getText());		//birthfield�� �Էµ� ���� ���
					birthfield.setVisible(false);					//birthfield Visible ��� ����
				}
				if(e.getSource() == hpfield3){														//�߻��� event�� hpfield3���� �� ��
					System.out.println(hpfield1.getText()+hpfield2.getText()+hpfield3.getText());	//hpfield�� �Էµ� ���� ���
					hpfield1.setVisible(false); 													//hpfield1 Visible ��� ����
					hpfield2.setVisible(false); 													//hpfield2 Visible ��� ����
					hpfield2.setVisible(false); 													//hpfield3 Visible ��� ����
				}

				if (e.getSource() == mn1) { 						//�߻��� event�� mn1���� �� ��
					Stringindex = 0;								//Stringindex �ʱ�ȭ
					Scanner sc = null;								//scanner �ʱ�ȭ
					try {
						sc = new Scanner(texts.vip1()); 			//VIP 1�� ������ scan
					} catch (FileNotFoundException e1) {			//FileNotFoundException ���� ó��
						e1.printStackTrace();
					}
					
					while (sc.hasNext()) {							//������ ���� �����Ҷ����� �ݺ�
						Stringtxt[Stringindex] = sc.nextLine();		//Stringindex�� ������Ű�鼭 ������� Stringtxt�� ����
						Stringindex++;
					}
					led.setOpaque(true);							//led�� ������ ����
					woman.setSelected(true);						//���ڷ� ����
					namefield.setText(Stringtxt[0]);				//���Ͽ��� �ҷ��� ���ڿ��� namefield�� �����ŵ�ϴ�
					birthfield.setText(Stringtxt[1]);				//���Ͽ��� �ҷ��� ���ڿ��� birthfield�� �����ŵ�ϴ�
					hpfield1.setText(Stringtxt[2]);					//���Ͽ��� �ҷ��� ���ڿ��� hpfield1�� �����ŵ�ϴ�
					hpfield2.setText(Stringtxt[3]);					//���Ͽ��� �ҷ��� ���ڿ��� hpfield2�� �����ŵ�ϴ�
					hpfield3.setText(Stringtxt[4]);					//���Ͽ��� �ҷ��� ���ڿ��� hpfield3�� �����ŵ�ϴ�
					man.setSelected(true);
				} else if (e.getSource() == mn2) { 					//�߻��� event�� mn2���� �� ��
					Stringindex = 0;								//Stringindex �ʱ�ȭ
					try {
						sc = new Scanner(texts.vip2()); 			//VIP 2�� ������ scan
					} catch (FileNotFoundException e1) {			//FileNotFoundException ���� ó��
						e1.printStackTrace();
					}
					while (sc.hasNext()) {							//������ ���� �����Ҷ����� �ݺ�
						Stringtxt[Stringindex] = sc.nextLine();		//Stringindex�� ������Ű�鼭 ������� Stringtxt�� ����
						Stringindex++;
					}
					led.setOpaque(true);							//led�� ������ ����
					man.setSelected(true);							//���ڷ� ����
					namefield.setText(Stringtxt[0]);				//���Ͽ��� �ҷ��� ���ڿ��� namefield�� �����ŵ�ϴ�
					birthfield.setText(Stringtxt[1]);				//���Ͽ��� �ҷ��� ���ڿ��� birthfield�� �����ŵ�ϴ�
					hpfield1.setText(Stringtxt[2]);					//���Ͽ��� �ҷ��� ���ڿ��� hpfield1�� �����ŵ�ϴ�
					hpfield2.setText(Stringtxt[3]);					//���Ͽ��� �ҷ��� ���ڿ��� hpfield2�� �����ŵ�ϴ�
					hpfield3.setText(Stringtxt[4]);					//���Ͽ��� �ҷ��� ���ڿ��� hpfield3�� �����ŵ�ϴ�
				} else if (e.getSource() == mn3) { 					//�߻��� event�� mn3���� �� ��
					Stringindex = 0;								//Stringindex �ʱ�ȭ
					try {
						sc = new Scanner(texts.vip3()); 			//VIP 3�� ������ scan
					} catch (FileNotFoundException e1) {			//FileNotFoundException ���� ó��
						e1.printStackTrace();
					}
					while (sc.hasNext()) {							//������ ���� �����Ҷ����� �ݺ�
						Stringtxt[Stringindex] = sc.nextLine();		//Stringindex�� ������Ű�鼭 ������� Stringtxt�� ����
						Stringindex++;
					}
					led.setOpaque(true);							//led�� ������ ����
					woman.setSelected(true);						//���ڷ� ����
					namefield.setText(Stringtxt[0]);				//���Ͽ��� �ҷ��� ���ڿ��� namefield�� �����ŵ�ϴ�
					birthfield.setText(Stringtxt[1]);				//���Ͽ��� �ҷ��� ���ڿ��� birthfield�� �����ŵ�ϴ�
					hpfield1.setText(Stringtxt[2]);					//���Ͽ��� �ҷ��� ���ڿ��� hpfield1�� �����ŵ�ϴ�
					hpfield2.setText(Stringtxt[3]);					//���Ͽ��� �ҷ��� ���ڿ��� hpfield2�� �����ŵ�ϴ�
					hpfield3.setText(Stringtxt[4]);					//���Ͽ��� �ҷ��� ���ڿ��� hpfield3�� �����ŵ�ϴ�
				} else if (e.getSource() == mn4) { 					//�߻��� event�� mn4���� �� ��
					Stringindex = 0;								//Stringindex �ʱ�ȭ
					try {
						sc = new Scanner(texts.vip4()); 			//VIP 4�� ������ scan
					} catch (FileNotFoundException e1) {			//FileNotFoundException ���� ó��
						e1.printStackTrace();
					}
					while (sc.hasNext()) {							//������ ���� �����Ҷ����� �ݺ�
						Stringtxt[Stringindex] = sc.nextLine();		//Stringindex�� ������Ű�鼭 ������� Stringtxt�� ����
						Stringindex++;
					}
					led.setOpaque(true);							//led�� ������ ����
					man.setSelected(true);							//���ڷ� ����
					namefield.setText(Stringtxt[0]);				//���Ͽ��� �ҷ��� ���ڿ��� namefield�� �����ŵ�ϴ�
					birthfield.setText(Stringtxt[1]);				//���Ͽ��� �ҷ��� ���ڿ��� birthfield�� �����ŵ�ϴ�
					hpfield1.setText(Stringtxt[2]);					//���Ͽ��� �ҷ��� ���ڿ��� hpfield1�� �����ŵ�ϴ�
					hpfield2.setText(Stringtxt[3]);					//���Ͽ��� �ҷ��� ���ڿ��� hpfield2�� �����ŵ�ϴ�
					hpfield3.setText(Stringtxt[4]);					//���Ͽ��� �ҷ��� ���ڿ��� hpfield3�� �����ŵ�ϴ�
				} else if (e.getSource() == mn5) { 		//�߻��� event�� mn5���� �� �� ������ ����Ǿ� �ִ� ������ �ʱ�ȭ
					namefield.setText("");				
					birthfield.setText("");				
					man.setSelected(false);				
					hpfield1.setText("");			
					hpfield2.setText("");			
					hpfield3.setText("");			
				} else if (e.getSource() == mn6 || e.getSource() == cancel) { 	//�߻��� event�� mn6���� �̰ų� cancel���� �� �� ������ ����Ǿ� �ִ� ������ �ʱ�ȭ
					reser.setVisible(false);
					namefield.setText("");
					birthfield.setText("");
					man.setSelected(false);
					hpfield1.setText("");
					hpfield2.setText("");
					hpfield3.setText("");
				}
				if (e.getSource() == mainbox) { 										//�߻��� event�� mainbox���� �� ��							
					int result = JOptionPane.showConfirmDialog(null, "���ðڽ��ϱ� ?", 	//������ ��Ȯ���ϱ� ���� confirmDialog 
							"", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {								//confirmDialog���� Yes�� �������� ��
						String b = (String) mainbox.getSelectedItem();  				//�� �޴��� String ������ ����
						if (!mainbox.getSelectedItem().equals("Main Select")) { 		//�� �޴��� default���� �ƴ϶�� �ֹ� ó��
							info[numm] = b; 
							numm++;   	
							System.out.println(b);
						}
					}
				} 
				if (e.getSource() == sidebox) {											//�߻��� event�� sidebox���� �� ��
					int result = JOptionPane.showConfirmDialog(null, "���ðڽ��ϱ� ?", 	//������ ��Ȯ���ϱ� ���� confirmDialog
							"", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {								//confirmDialog���� Yes�� �������� ��
						String b = (String) sidebox.getSelectedItem();  				//�� �޴��� String ������ ����
						if (!sidebox.getSelectedItem().equals("Side Select")) { 		//�� �޴��� default���� �ƴ϶�� �ֹ� ó��
							info2[numm2] = b;	
							numm2++;  
							System.out.println(b);
						}
					}
				}
				if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 1��  ")) { 	//�߻��� event�� ok���� �̰� tablebox�� ���� 1���� ��
					if (tbtn[0].getBackground() == Color.YELLOW) {							//�ߺ����� �������� ����
						JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.",				//�ߺ����� ������ �õ����� �˷��ֱ� ���� MessageDialog
								"", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[0].setForeground(Color.GREEN);														//tbtn �� ����
						tbtn[0].setBackground(Color.YELLOW);													//tbtn ���� ����
						tbtn[0].setText("<����> " + namefield.getText());											//tbtn�� ������� ���
						//���� ��� �Է��ߴ� ������ �ش� table�� ����
						t1name = namefield.getText();															
						t1birth = birthfield.getText();															
						for (int i = 0; i < numm; i++)
							t1main += info[i];																	
						for (int i = 0; i < numm2; i++)
							t1side += info2[i];	
						if (man.isSelected() == true)	
							t1person = man.getText();	
						else if (woman.isSelected() == true)	
							t1person = woman.getText();	
						t1phone = hpfield1.getText() + "-" + hpfield2.getText() + "-" + hpfield3.getText();	
						t1num = (String) combox.getSelectedItem(); 	
						t1time = (String) timebox.getSelectedItem();	
						setVisible(false);																		//Visible ��� ����
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 2��  ")) { 	//�߻��� event�� ok���� �̰� tablebox�� ���� 2���� ��
					if (tbtn[1].getBackground() == Color.YELLOW) {								//�ߺ����� �������� ����
						JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.", 				//�ߺ����� ������ �õ����� �˷��ֱ� ���� MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[1].setForeground(Color.GREEN);														//tbtn �� ����
						tbtn[1].setBackground(Color.YELLOW);													//tbtn ���� ����
						tbtn[1].setText("<����> " + namefield.getText());											//tbtn�� ������� ���
						//���� ��� �Է��ߴ� ������ �ش� table�� ����
						t2name = namefield.getText();
						t2birth = birthfield.getText();
						for (int i = 0; i < numm; i++)
							t2main += info[i];
						for (int i = 0; i < numm2; i++)
							t2side += info2[i];	
						if (man.isSelected() == true)
							t2person = man.getText();
						else if (woman.isSelected() == true)
							t2person = woman.getText();
						t2phone = hpfield1.getText() + "-" + hpfield2.getText() + "-" + hpfield3.getText();
						t2num = (String) combox.getSelectedItem();
						t2time = (String) timebox.getSelectedItem();
						setVisible(false);																		//Visible ��� ����
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 3��  ")) { 	//�߻��� event�� ok���� �̰� tablebox�� ���� 3���� ��
					if (tbtn[2].getBackground() == Color.YELLOW) {								//�ߺ����� �������� ����
						JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.", 				//�ߺ����� ������ �õ����� �˷��ֱ� ���� MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[2].setForeground(Color.GREEN);														//tbtn �� ����
						tbtn[2].setBackground(Color.YELLOW);													//tbtn ���� ����
						tbtn[2].setText("<����> " + namefield.getText());											//tbtn�� ������� ���
						//���� ��� �Է��ߴ� ������ �ش� table�� ����
						t3name = namefield.getText();
						t3birth = birthfield.getText();
						for (int i = 0; i < numm; i++)
							t3main += info[i];
						for (int i = 0; i < numm2; i++)
							t3side += info2[i];	
						if (man.isSelected() == true)
							t3person = man.getText();
						else if (woman.isSelected() == true)
							t3person = woman.getText();
						t3phone = hpfield1.getText() + "-" + hpfield2.getText() + "-" + hpfield3.getText();
						t3num = (String) combox.getSelectedItem();
						t3time = (String) timebox.getSelectedItem();
						setVisible(false);																		//Visible ��� ����
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 4��  ")) { 	//�߻��� event�� ok���� �̰� tablebox�� ���� 4���� ��
					if (tbtn[3].getBackground() == Color.YELLOW) {								//�ߺ����� �������� ����
						JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.", 				//�ߺ����� ������ �õ����� �˷��ֱ� ���� MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[3].setForeground(Color.GREEN);														//tbtn �� ����
						tbtn[3].setBackground(Color.YELLOW);													//tbtn ���� ����
						tbtn[3].setText("<����> " + namefield.getText());											//tbtn�� ������� ���
						//���� ��� �Է��ߴ� ������ �ش� table�� ����
						t4name = namefield.getText();
						t4birth = birthfield.getText();
						for (int i = 0; i < numm; i++)
							t4main += info[i];
						for (int i = 0; i < numm2; i++)
							t4side += info2[i];	
						if (man.isSelected() == true)
							t4person = man.getText();
						else if (woman.isSelected() == true)
							t4person = woman.getText();
						t4phone = hpfield1.getText() + "-" + hpfield2.getText() + "-" + hpfield3.getText();
						t4num = (String) combox.getSelectedItem();
						t4time = (String) timebox.getSelectedItem();
						setVisible(false);																		//Visible ��� ����
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 5��  ")) { 	//�߻��� event�� ok���� �̰� tablebox�� ���� 5���� ��
					if (tbtn[0].getBackground() == Color.YELLOW) {								//�ߺ����� �������� ����
						JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.", 				//�ߺ����� ������ �õ����� �˷��ֱ� ���� MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[4].setForeground(Color.GREEN);														//tbtn �� ����
						tbtn[4].setBackground(Color.YELLOW);													//tbtn ���� ����
						tbtn[4].setText("<����> " + namefield.getText());											//tbtn�� ������� ���
						//���� ��� �Է��ߴ� ������ �ش� table�� ����
						t5name = namefield.getText();
						t5birth = birthfield.getText();
						for (int i = 0; i < numm; i++)
							t5main += info[i];
						for (int i = 0; i < numm2; i++)
							t5side += info2[i];	
						if (man.isSelected() == true)
							t5person = man.getText();
						else if (woman.isSelected() == true)
							t5person = woman.getText();
						t5phone = hpfield1.getText() + "-" + hpfield2.getText() + "-" + hpfield3.getText();
						t5num = (String) combox.getSelectedItem();
						t5time = (String) timebox.getSelectedItem();
						setVisible(false);																		//Visible ��� ����
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 6��  ")) { 	//�߻��� event�� ok���� �̰� tablebox�� ���� 6���� ��
					if (tbtn[0].getBackground() == Color.YELLOW) {								//�ߺ����� �������� ����
						JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.", 				//�ߺ����� ������ �õ����� �˷��ֱ� ���� MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[5].setForeground(Color.GREEN);														//tbtn �� ����
						tbtn[5].setBackground(Color.YELLOW);													//tbtn ���� ����
						tbtn[5].setText("<����> " + namefield.getText());											//tbtn�� ������� ���
						//���� ��� �Է��ߴ� ������ �ش� table�� ����
						t6name = namefield.getText();
						t6birth = birthfield.getText();
						for (int i = 0; i < numm; i++)
							t6main += info[i];
						for (int i = 0; i < numm2; i++)
							t6side += info2[i];	
						if (man.isSelected() == true)
							t6person = man.getText();
						else if (woman.isSelected() == true)
							t6person = woman.getText();
						t6phone = hpfield1.getText() + "-" + hpfield2.getText() + "-" + hpfield3.getText();
						t6num = (String) combox.getSelectedItem();
						t6time = (String) timebox.getSelectedItem();
						setVisible(false);																		//Visible ��� ����
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 7��  ")) { 	//�߻��� event�� ok���� �̰� tablebox�� ���� 7���� ��
					if (tbtn[0].getBackground() == Color.YELLOW) {								//�ߺ����� �������� ����
						JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.",					//�ߺ����� ������ �õ����� �˷��ֱ� ���� MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[6].setForeground(Color.GREEN);														//tbtn �� ����
						tbtn[6].setBackground(Color.YELLOW);													//tbtn ���� ����
						tbtn[6].setText("<����> " + namefield.getText());											//tbtn�� ������� ���
						//���� ��� �Է��ߴ� ������ �ش� table�� ����
						t7name = namefield.getText();
						t7birth = birthfield.getText();
						for (int i = 0; i < numm; i++)
							t7main += info[i];
						for (int i = 0; i < numm2; i++)
							t7side += info2[i];	
						if (man.isSelected() == true)
							t7person = man.getText();
						else if (woman.isSelected() == true)
							t7person = woman.getText();
						t7phone = hpfield1.getText() + "-" + hpfield2.getText() + "-" + hpfield3.getText();
						t7num = (String) combox.getSelectedItem();
						t7time = (String) timebox.getSelectedItem();
						setVisible(false);																		//Visible ��� ����
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 8��  ")) { 	//�߻��� event�� ok���� �̰� tablebox�� ���� 8���� ��
					if (tbtn[0].getBackground() == Color.YELLOW) {								//�ߺ����� �������� ����
						JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.", 				//�ߺ����� ������ �õ����� �˷��ֱ� ���� MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[7].setForeground(Color.GREEN);														//tbtn �� ����
						tbtn[7].setBackground(Color.YELLOW);													//tbtn ���� ����
						tbtn[7].setText("<����> " + namefield.getText());											//tbtn�� ������� ���
						//���� ��� �Է��ߴ� ������ �ش� table�� ����
						t8name = namefield.getText();
						t8birth = birthfield.getText();
						for (int i = 0; i < numm; i++)
							t8main += info[i];
						for (int i = 0; i < numm2; i++)
							t8side += info2[i];	
						if (man.isSelected() == true)
							t8person = man.getText();
						else if (woman.isSelected() == true)
							t8person = woman.getText();
						t8phone = hpfield1.getText() + "-" + hpfield2.getText() + "-" + hpfield3.getText();
						t8num = (String) combox.getSelectedItem();
						t8time = (String) timebox.getSelectedItem();
						setVisible(false);																		//Visible ��� ����
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 9��  ")) { 	//�߻��� event�� ok���� �̰� tablebox�� ���� 9���� ��
					if (tbtn[0].getBackground() == Color.YELLOW) {								//�ߺ����� �������� ����
						JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.",					//�ߺ����� ������ �õ����� �˷��ֱ� ���� MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[8].setForeground(Color.GREEN);														//tbtn �� ����
						tbtn[8].setBackground(Color.YELLOW);													//tbtn ���� ����
						tbtn[8].setText("<����> " + namefield.getText());											//tbtn�� ������� ���
						//���� ��� �Է��ߴ� ������ �ش� table�� ����
						t9name = namefield.getText();
						t9birth = birthfield.getText();
						for (int i = 0; i < numm; i++)
							t9main += info[i];
						for (int i = 0; i < numm2; i++)
							t9side += info2[i];	
						if (man.isSelected() == true)
							t9person = man.getText();
						else if (woman.isSelected() == true)
							t9person = woman.getText();
						t9phone = hpfield1.getText() + "-" + hpfield2.getText() + "-" + hpfield3.getText();
						t9num = (String) combox.getSelectedItem();
						t9time = (String) timebox.getSelectedItem();
						setVisible(false);																		//Visible ��� ����
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 10��  ")) {		//�߻��� event�� ok���� �̰� tablebox�� ���� 10���� ��
					if (tbtn[0].getBackground() == Color.YELLOW) {									//�ߺ����� �������� ����
						JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.", 					//�ߺ����� ������ �õ����� �˷��ֱ� ���� MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[9].setForeground(Color.GREEN);														//tbtn �� ����
						tbtn[9].setBackground(Color.YELLOW);													//tbtn ���� ����
						tbtn[9].setText("<����> " + namefield.getText());											//tbtn�� ������� ���
						//���� ��� �Է��ߴ� ������ �ش� table�� ����
						t10name = namefield.getText();
						t10birth = birthfield.getText();
						for (int i = 0; i < numm; i++)
							t10main += info[i];
						for (int i = 0; i < numm2; i++)
							t10side += info2[i];	
						if (man.isSelected() == true)
							t10person = man.getText();
						else if (woman.isSelected() == true)
							t10person = woman.getText();
						t10phone = hpfield1.getText() + "-" + hpfield2.getText() + "-" + hpfield3.getText();
						t10num = (String) combox.getSelectedItem();
						t10time = (String) timebox.getSelectedItem();
						setVisible(false);																		//Visible ��� ����
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 11��  ")) { 	//�߻��� event�� ok���� �̰� tablebox�� ���� 11���� ��
					if (tbtn[0].getBackground() == Color.YELLOW) {									//�ߺ����� �������� ����
						JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.", 					//�ߺ����� ������ �õ����� �˷��ֱ� ���� MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[10].setForeground(Color.GREEN);													//tbtn �� ����
						tbtn[10].setBackground(Color.YELLOW);													//tbtn ���� ����
						tbtn[10].setText("<����> " + namefield.getText());										//tbtn�� ������� ���
						//���� ��� �Է��ߴ� ������ �ش� table�� ����
						t11name = namefield.getText();
						t11birth = birthfield.getText();
						for (int i = 0; i < numm; i++)
							t11main += info[i];
						for (int i = 0; i < numm2; i++)
							t11side += info2[i];	
						if (man.isSelected() == true)
							t11person = man.getText();
						else if (woman.isSelected() == true)
							t11person = woman.getText();
						t11phone = hpfield1.getText() + "-" + hpfield2.getText() + "-" + hpfield3.getText();
						t11num = (String) combox.getSelectedItem();
						t11time = (String) timebox.getSelectedItem();
						setVisible(false);																		//Visible ��� ����
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 12��  ")) { 	//�߻��� event�� ok���� �̰� tablebox�� ���� 12���� ��
					if (tbtn[0].getBackground() == Color.YELLOW) {									//�ߺ����� �������� ����
						JOptionPane.showMessageDialog(null, "�̹� ����� �ڸ��Դϴ�.",						//�ߺ����� ������ �õ����� �˷��ֱ� ���� MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[11].setForeground(Color.GREEN);													//tbtn �� ����
						tbtn[11].setBackground(Color.YELLOW);													//tbtn ���� ����
						tbtn[11].setText("<����> " + namefield.getText());										//tbtn�� ������� ���
						//���� ��� �Է��ߴ� ������ �ش� table�� ����
						t12name = namefield.getText();
						t12birth = birthfield.getText();
						for (int i = 0; i < numm; i++)
							t12main += info[i];
						for (int i = 0; i < numm2; i++)
							t12side += info2[i];	
						if (man.isSelected() == true)
							t12person = man.getText();
						else if (woman.isSelected() == true)
							t12person = woman.getText();
						t12phone = hpfield1.getText() + "-" + hpfield2.getText() + "-" + hpfield3.getText();
						t12num = (String) combox.getSelectedItem();
						t12time = (String) timebox.getSelectedItem();
						setVisible(false);																		//Visible ��� ����
					}
				}
			}
		}

		class MyMouseAdapter extends MouseAdapter {				//reservation�� northpanel�� ���� mouse event�� ó���ϴ� class
			public void mouseDragged(MouseEvent e) {
				la.setText("��Ȯ�� ���������� �Է��� �ּ���.");			//mouse dragged event�� �߻��ϸ� ������ ���� ���					
			}
			public void mouseMoved(MouseEvent e) {
				la.setText(" ���������� Ÿ����� ������ �ʽ��ϴ�.");		//mouse moved event�� �߻��ϸ� ������ ���� ���
			}
		}
		class MyItemListener implements ItemListener { 			//reservation�� groupbutton�� ���� item event�� ó���ϴ� class
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem() == man)		
					led.setText("�����Դϴ�.");					//man�� ���õǸ� led�� ������ ���� ���
				else if (e.getItem() == woman)   
					led.setText("�����Դϴ�"); 					//woman�� ���õǸ� led�� ������ ���� ���
				if (man.isSelected())
					manofwoman.setIcon(images.manimg());		//man�� ���õǸ� man image�� ����մϴ�
				else if (woman.isSelected())
					manofwoman.setIcon(images.womanimg()); 		//woman�� ���õǸ� woman image�� ����մϴ�
			}
		}
	}

	class MyMouseListener extends MouseAdapter {												//table�� ���� mouse event�� ó���ϴ� class
		public void mouseEntered(MouseEvent e) {
			for (int i = 0; i < 12; i++)														
				if (e.getSource() == tbtn[i] && tbtn[i].getBackground() == Color.WHITE) 
					tbtn[i].setBackground(Color.LIGHT_GRAY); 									//table button���� ���콺�� �ö󰡸� table�� ������ ȸ������ ����
		}
		public void mouseExited(MouseEvent e) {
			for (int i = 0; i < 12; i++)           
				if (e.getSource() == tbtn[i] && tbtn[i].getBackground() == Color.LIGHT_GRAY)
					tbtn[i].setBackground(Color.WHITE);											//table button������ ���콺�� �������� table�� ������ ������� ����
		}
	}
	class MyActionListener implements ActionListener {															//table�� ���� action event�� ó���ϴ� class
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tbtn[0]) {																		//1�� table�� ���õǾ��� ��
				if (tbtn[0].getBackground() == Color.LIGHT_GRAY || tbtn[0].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//�ֹ��� ���°� �ƴ϶�� ��� ��ư ��Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				} else if (tbtn[0].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//�ֹ��� ���¶�� ��� ��ư Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				}
				select = 1;																						//table ��ȣ ����
			} else if (e.getSource() == tbtn[1]) {																//2�� table�� ���õǾ�����
				if (tbtn[1].getBackground() == Color.LIGHT_GRAY || tbtn[1].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//�ֹ��� ���°� �ƴ϶�� ��� ��ư ��Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				} else if (tbtn[1].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//�ֹ��� ���¶�� ��� ��ư Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				}
				select = 2;																						//table ��ȣ ����
			} else if (e.getSource() == tbtn[2]) {																//3�� table�� ���õǾ�����
				if (tbtn[2].getBackground() == Color.LIGHT_GRAY || tbtn[2].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//�ֹ��� ���°� �ƴ϶�� ��� ��ư ��Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				} else if (tbtn[2].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//�ֹ��� ���¶�� ��� ��ư Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				}
				select = 3;																						//table ��ȣ ����
			} else if (e.getSource() == tbtn[3]) {																//4�� table�� ���õǾ�����
				if (tbtn[3].getBackground() == Color.LIGHT_GRAY || tbtn[3].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//�ֹ��� ���°� �ƴ϶�� ��� ��ư ��Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				} else if (tbtn[3].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//�ֹ��� ���¶�� ��� ��ư Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				}
				select = 4;																						//table ��ȣ ����
			} else if (e.getSource() == tbtn[4]) {																//5�� table�� ���õǾ�����
				if (tbtn[4].getBackground() == Color.LIGHT_GRAY || tbtn[4].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//�ֹ��� ���°� �ƴ϶�� ��� ��ư ��Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				} else if (tbtn[4].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//�ֹ��� ���¶�� ��� ��ư Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				}
				select = 5;																						//table ��ȣ ����
			} else if (e.getSource() == tbtn[5]) {																//6�� table�� ���õǾ�����
				if (tbtn[5].getBackground() == Color.LIGHT_GRAY || tbtn[5].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//�ֹ��� ���°� �ƴ϶�� ��� ��ư ��Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				} else if (tbtn[5].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//�ֹ��� ���¶�� ��� ��ư Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				}
				select = 6;																						//table ��ȣ ����
			} else if (e.getSource() == tbtn[6]) {																//7�� table�� ���õǾ�����
				if (tbtn[6].getBackground() == Color.LIGHT_GRAY || tbtn[6].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//�ֹ��� ���°� �ƴ϶�� ��� ��ư ��Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				} else if (tbtn[6].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//�ֹ��� ���¶�� ��� ��ư Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				}
				select = 7;																						//table ��ȣ ����
			} else if (e.getSource() == tbtn[7]) {																//8�� table�� ���õǾ����� 
				if (tbtn[7].getBackground() == Color.LIGHT_GRAY || tbtn[7].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//�ֹ��� ���°� �ƴ϶�� ��� ��ư ��Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				} else if (tbtn[7].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//�ֹ��� ���¶�� ��� ��ư Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				}
				select = 8;																						//table ��ȣ ����
			} else if (e.getSource() == tbtn[8]) {																//9�� table�� ���õǾ�����
				if (tbtn[8].getBackground() == Color.LIGHT_GRAY || tbtn[8].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//�ֹ��� ���°� �ƴ϶�� ��� ��ư ��Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				} else if (tbtn[8].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//�ֹ��� ���¶�� ��� ��ư Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				}
				select = 9;																						//table ��ȣ ����
			} else if (e.getSource() == tbtn[9]) {																//10�� table�� ���õǾ�����
				if (tbtn[9].getBackground() == Color.LIGHT_GRAY || tbtn[9].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//�ֹ��� ���°� �ƴ϶�� ��� ��ư ��Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				} else if (tbtn[9].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//�ֹ��� ���¶�� ��� ��ư Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				}
				select = 10;																					//table ��ȣ ����
			} else if (e.getSource() == tbtn[10]) {																//11�� table�� ���õǾ�����
				if (tbtn[10].getBackground() == Color.LIGHT_GRAY || tbtn[10].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//�ֹ��� ���°� �ƴ϶�� ��� ��ư ��Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				} else if (tbtn[10].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//�ֹ��� ���¶�� ��� ��ư Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				}
				select = 11;																					//table ��ȣ ����
			} else if (e.getSource() == tbtn[11]) {																//12�� table�� ���õǾ�����
				if (tbtn[11].getBackground() == Color.LIGHT_GRAY || tbtn[11].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//�ֹ��� ���°� �ƴ϶�� ��� ��ư ��Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				} else if (tbtn[11].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//�ֹ��� ���¶�� ��� ��ư Ȱ��ȭ
					clk.setVisible(true);  																		//clk�� Visible ������� ����
				}
				select = 12;																					//table ��ȣ ����
			}
		}
	}
	
	public static void main(String[] args) {
		new login.login();			//��ó�� �α��� �۾��� �����ϱ� ���� login ������ ȣ��
	}
}