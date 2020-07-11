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
	images images = new images();		//프로그램에 필요한 image를 사용하기 위한 생성자
	texts texts = new texts();			//프로그램에 필요한 text를 사용하기 위한 생성자
	
	String Stringtxt[] = new String[10]; 	//불러온 text를 임시로 저장하기 위한 배열
	int Stringindex = 0;					//Stringtxt index를 사용하기 위한 변수
	int select = 0;							//선택된  Table 번호를 구별하기 위한 변수
	int lucky;								//무료식사 이벤트 당시 생성되는 랜덤숫자를 저장하기 위한 변수
	int lucknum[] = new int[12]; 			//1~12번 Table의 주문 당시 생성되는 랜덤숫자를 저장하기 위한 배열
	int ran;								//설문참여나 싸인 입력 시 생성되는 파일의 파일명 중복을 막기 위해서 생성한 변수
	int money[] = new int[12];															//1~12번 Table의 총 주문금액을 저장하기 위한 배열
 	String mon1, mon2, mon3, mon4, mon5, mon6, mon7, mon8, mon9, mon10, mon11, mon12;	//1~12번 Table의 총 주문금액을 출력하기 위한 변수
	int num[] = new int[12]; 															//순서대로 table에 주문을 넣어주기 위한 배열

	JLabel stkpic = new JLabel(images.backimg()); 			//steakPanel background image를 사용하기 위한 JLabel
	JLabel pstpic = new JLabel(images.backimg()); 			//pastaPanel background image를 사용하기 위한 JLabel 
	JLabel pizpic = new JLabel(images.backimg()); 			//pizzaPanel background image를 사용하기 위한 JLabel 
	JLabel pilpic = new JLabel(images.backimg()); 			//pilafPanel background image를 사용하기 위한 JLabel
	JLabel sidepic = new JLabel(images.backimg()); 			//sidePanel background image를 사용하기 위한 JLabel
	JLabel drinkpic = new JLabel(images.backimg()); 		//drinkPanel background image를 사용하기 위한 JLabel 
	
	JLabel timelabel1 = new JLabel(); 										//년, 월, 일을 나타내기 위한 JLabel
	JLabel timelabel2 = new JLabel(); 										//시, 분, 초를 나태내기 위한 JLabel
	JLabel welcome = new JLabel("저희 매장을 방문해주신 모든 분들께 감사드립니다. "		//지정된 멘트를 나타내기 위한 JLabel 
			+ "좋은 서비스로 보답할 수 있도록 항상 노력하겠습니다. ");

	//steakPanel, pizzaPanel, pilafPanel, pastaPanel, sidePanel, drinkPanel에서 필요한 JLabel, JButton 
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
	
	String t1info[] = new String[20];		// 1번  Table 주문 정보를 저장하기 위한 배열
	String t2info[] = new String[20];		// 2번  Table 주문 정보를 저장하기 위한 배열
	String t3info[] = new String[20];		// 3번  Table 주문 정보를 저장하기 위한 배열
	String t4info[] = new String[20];		// 4번  Table 주문 정보를 저장하기 위한 배열
	String t5info[] = new String[20];		// 5번  Table 주문 정보를 저장하기 위한 배열
	String t6info[] = new String[20];		// 6번  Table 주문 정보를 저장하기 위한 배열
	String t7info[] = new String[20];		// 7번  Table 주문 정보를 저장하기 위한 배열
	String t8info[] = new String[20];		// 8번  Table 주문 정보를 저장하기 위한 배열
	String t9info[] = new String[20];		// 9번  Table 주문 정보를 저장하기 위한 배열
	String t10info[] = new String[20];		// 10번  Table 주문 정보를 저장하기 위한 배열
	String t11info[] = new String[20];		// 11번  Table 주문 정보를 저장하기 위한 배열
	String t12info[] = new String[20];		// 12번  Table 주문 정보를 저장하기 위한 배열
	
	JLabel t1money[] = new JLabel[20];		// 1번  Table 음식 금액을 저장하기 위한 JLabel
	JLabel t2money[] = new JLabel[20];		// 2번  Table 음식 금액을 저장하기 위한 JLabel
	JLabel t3money[] = new JLabel[20];		// 3번  Table 음식 금액을 저장하기 위한 JLabel
	JLabel t4money[] = new JLabel[20];		// 4번  Table 음식 금액을 저장하기 위한 JLabel
	JLabel t5money[] = new JLabel[20];		// 5번  Table 음식 금액을 저장하기 위한 JLabel
	JLabel t6money[] = new JLabel[20];		// 6번  Table 음식 금액을 저장하기 위한 JLabel
	JLabel t7money[] = new JLabel[20];		// 7번  Table 음식 금액을 저장하기 위한 JLabel
	JLabel t8money[] = new JLabel[20];		// 8번  Table 음식 금액을 저장하기 위한 JLabel
	JLabel t9money[] = new JLabel[20];		// 9번  Table 음식 금액을 저장하기 위한 JLabel
	JLabel t10money[] = new JLabel[20];		// 10번  Table 음식 금액을 저장하기 위한 JLabel
	JLabel t11money[] = new JLabel[20];		// 11번  Table 음식 금액을 저장하기 위한 JLabel
	JLabel t12money[] = new JLabel[20];		// 12번  Table 음식 금액을 저장하기 위한 JLabel
	
	JMenu menuoption = new JMenu("Table 정보"); 			//저장되어 있는 table에 대한 정보를 처리하기 위한 JMenu
	JMenuBar optionbar = new JMenuBar(); 				//저장되어 있는 table에 대한 정보를 처리하기 위한 JMenuBar
	JMenuItem tbinfo = new JMenuItem(" Table 정보"); 		//저장되어 있는 table에 대한 정보를 처리하기 위한 JMenuItem
	
	JButton tbtn[] = new JButton[18]; 					//table을 선택할 수 있게 하기 위한 JButton
	JButton Clickbtn1, Clickbtn2, Clickbtn3, Clickbtn4;	//tbtn을 선택했을 시 추가적으로 option을 선택할 수 있게 하기 위한 JButton
	JLabel tblabel[] = new JLabel[12]; 					//tbtn에 정보를 기입하기 위한 JLabel
	JLabel tblabel2[] = new JLabel[12]; 				//tbtn에 정보를 기입하기 위한 JLabel
	
	JLabel label = new JLabel(images.tableimg());		//table image를 사용하기 위한 JLabel
	JButton steak = new JButton(images.steakimg());		//steak image를 사용하기 위한 JLabel
	JButton pasta = new JButton(images.pastaimg());		//pasta image를 사용하기 위한 JLabel
	JButton pilaf = new JButton(images.pilafimg());		//pilaf image를 사용하기 위한 JLabel
	JButton pizza = new JButton(images.pizzaimg());		//pizza image를 사용하기 위한 JLabel
	JButton side = new JButton(images.sidedishimg());	//sidedish image를 사용하기 위한 JLabel
	JButton drink = new JButton(images.beverageimg());	//drink image를 사용하기 위한 JLabel
	JButton endbtn = new JButton("주문 완료");				//주문완료 처리를 위한 JLabel

	// Reservation 처리 과정에 필요한 String
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

	JMenuBar menubar = new JMenuBar();  														//VIP에 관련된 처리를 하기 위해 필요한 JMenuBar
	JMenu menu = new JMenu("V I P"); 															//VIP에 관련된 처리를 하기 위해 필요한 JMenu
	JMenuItem mn1, mn2, mn3, mn4, mn5, mn6; 													//VIP에 관련된 처리를 하기 위해 필요한 JMenuItem
	JTextField namefield, birthfield, hpfield1, hpfield2, hpfield3;  							//Reservation에 필요한 정보를 입력받기 위한 JTextField
	JLabel name, phone, mainmenu, sidemenu, birth, time, person, sum, danger, led, ttable; 		//Reservation 과정에 입력받은 정보를 저장하기 위한 JLabel
	JButton ok, cancel; 																		//Reservation 과정에 예약, 예약취소 처리를 하기 위한 JButton
	JRadioButton man; 																			//Reservation 과정에 필요한 성별 선택을 하기 위한 JRadioButton
	JCheckBox woman;  																			//Reservation 과정에 필요한 성별 선택을 하기 위한 JCheckBox
	ButtonGroup g;    																			//하나의 처리 과정으로 지정하기 위해 필요한 ButtonGroup
	JLabel manofwoman, myperson, la = new JLabel("정확한 개인정보를 입력해주시기 바랍니다.");				//Reservation 과정에서 입력받을 경우 dafault값을 설정하기 위한 JLabel
	JComboBox combox, timebox, mainbox, sidebox, tablebox;										//Reservation 과정에서 여러가지 경우 중 선택해야할 경우 이를 처리하기 위한 JComboBox
	//Reservation 과정에서 여러가지 경우를 선택할 수 있도록 이를 나열하기 위한 문자열
	String ea[] = { "인원선택", "   1 명", "   2 명", "   3 명", "   4 명", "   5 명", "   6 명", "   7 명", "   8 명" };
	String ea2[] = { "시간선택", "   9 시  ", "   10 시", "   11 시", "   12 시", "   13 시", "   14 시", "   15 시", "   16 시 ", "   17 시", "   18 시" };
	String menuString[] = { " Main Select ", " 닭가슴살 스테이크 ", " 목살 스테이크 ", " 김치 필라프 ", " 목살 필라프 ", " 베이컨 필라프 ", " 새우 필라프 ", " 고르곤졸라 피자 ", " 불고구마 피자 " };
	String sideString[] = { " Side Select ", " 갈릭 브레드 ", " 치킨테더 샐러드 ", " 칠리피즈 프라이 ", " 프렌치 프라이 " };
	String tablenum[] = { " 1번  ", " 2번  ", " 3번  ", " 4번  ", " 5번  ", " 6번  ", " 7번  ", " 8번  ", " 9번  ", " 10번  ", " 11번  ", " 12번  " };
	String info[] = new String[10];				//Reservation 과정에서 선택한 main dish를 임시로 저장하기 위한 문자열
	String info2[] = new String[10];			//Reservation 과정에서 선택한 side dish를 임시로 저장하기 위한 문자열
	int numm = 0, numm2 = 0;					//각각 info와 info2가 어디까지 채워졌는지 알기 위해 index를 저장하는 변수
	//Reservation에 필요한 정보를 기입하도록 하기 위한 JLabel
	JLabel t_name = new JLabel("이 름");			
	JLabel t_birth = new JLabel("생년월일");
	JLabel t_main = new JLabel("Main Dish");
	JLabel t_side = new JLabel("Side Dish");
	JLabel t_person = new JLabel("성 별");
	JLabel t_phone = new JLabel("전화번호");
	JLabel t_num = new JLabel("인 원");
	JLabel t_time = new JLabel("시 간");
	
	String t1price[] = new String[20];			// 1번  Table 음식 금액을 임시로 저장하기 위한 JLabel
	String t2price[] = new String[20];			// 2번  Table 음식 금액을 임시로 저장하기 위한 JLabel
	String t3price[] = new String[20];			// 3번  Table 음식 금액을 임시로 저장하기 위한 JLabel
	String t4price[] = new String[20];			// 4번  Table 음식 금액을 임시로 저장하기 위한 JLabel
	String t5price[] = new String[20];			// 5번  Table 음식 금액을 임시로 저장하기 위한 JLabel
	String t6price[] = new String[20];			// 6번  Table 음식 금액을 임시로 저장하기 위한 JLabel
	String t7price[] = new String[20];			// 7번  Table 음식 금액을 임시로 저장하기 위한 JLabel
	String t8price[] = new String[20];			// 8번  Table 음식 금액을 임시로 저장하기 위한 JLabel
	String t9price[] = new String[20];			// 9번  Table 음식 금액을 임시로 저장하기 위한 JLabel
	String t10price[] = new String[20];			// 10번  Table 음식 금액을 임시로 저장하기 위한 JLabel
	String t11price[] = new String[20];			// 11번  Table 음식 금액을 임시로 저장하기 위한 JLabel
	String t12price[] = new String[20];			// 12번  Table 음식 금액을 임시로 저장하기 위한 JLabel

	Container contentpane;				//Container를 사용하기 위해 선언
	FoodMenu fdmenu; 					//FoodMenu를 사용하기 위해 선언
	SubMenu clk; 						//Click0를 사용하기 위해 선언
	SteakPanel stp;  					//Steak Panel을 사용하기 위해 선언
	PastaPanel psp;	 					//Pasta Panel을 사용하기 위해 선언
	PilafPanel plp;  					//Pilaf Panel을 사용하기 위해 선언
	PizzaPanel pzp;  					//Pizza Panel을 사용하기 위해 선언
	SidePanel sdp;   					//Side Panel을 사용하기 위해 선언
	DrinkPanel dkp;  					//Drink Panel을 사용하기 위해 선언
	OrderInfo od;    					//OrderInfo를 사용하기 위해 선언
	Mysetting set;						//Mysetting을 사용하기 위해 선언
	showStat rec;						//showStat를 사용하기 위해 선언
 	SignPanel spsp;  					//Sign Panel을 사용하기 위해 선언
	Payment pay;   						//Payment를 사용하기 위해 선언
	Survey sv;     						//Survey를 사용하기 위해 선언
	SurveyWindow sw; 					//SurveryWindow를 사용하기 위해 선언
	Reservation reser;					//Reservation을 사용하기 위해 선언
	Event event;						//Event를 사용하기 위해 선언
	CurrentTime currenttime;			//CurrentTime을 사용하기 위해 선언
	MyThread mth;						//MyThread를 사용하기 위해 선언

	JButton paybtn1 = new JButton(images.cashcimg());	//결제 상황에서 현금 결제를 처리 하기 위한 JButton
	JButton paybtn2 = new JButton(images.cardimg());	//결제 상황에서 카드 결제를 처리 하기 위한 JButton
	
	JButton surveyok = new JButton("하겠습니다");			//설문조사 상황에서 참여여부를 처리 하기 위한 JButton
	JButton surveycancel = new JButton("하지않겠습니다");	//설문조사 상황에서 미참여여부를 처리 하기 위한 JButton
	JTextField surveytxt[] = new JTextField[5];			//설문조사에 대한 답변을 받아오기 위한 JTextField
	
	JButton surveyre = new JButton(images.chartimg());	//우수 설문조사로 선정된 항목을 조회하기 위한 JButton
	JLabel mainsign = new JLabel(images.mainsignimg());	//mainsign을 표시하기 위한 JLabel
	JButton setting = new JButton(images.settingimg());	//volume setting을 처리하기 위한 JButton
	JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 500, 250); 	//volume setting 과정에서 직관적으로 표현하기 위한 JSlider

	JLabel foodinfo[] = new JLabel[20];								//미결제된 메뉴 리스트를 표현하기 위한 JLabel
	JLabel north = new JLabel("< 결 제 내 용  >", JLabel.CENTER);		//결제 과정에서 앞으로 결제해야할 내용이 나와야함을 암시하는 문구를 표현하기 위한 JLabel
	JLabel south2 = new JLabel("",JLabel.CENTER);					//결제 과정에서 합계 금액을 표현하기 위한 JLabel(현재는 default값)
	Scanner sc;														//Scanner를 사용하기 위해 선언

	public main() { 							//main 생성자
		super("Kiosk - SEOGA&COOK");			//title 지정

		for (int i = 0; i < 12; i++) {			//money, num에 대한 초기화
			money[i] = 0;
			num[i] = 0;
		}
		menuoption.add(tbinfo); 				//tbinfo를 menuoption에 적용
		optionbar.add(menuoption); 				//menuoption을 optionbar에 적용
		fdmenu = new FoodMenu(); 				//FoodMenu를 사용하기 위해 생성자 호출
		sw = new SurveyWindow(); 				//SurveyWindow를 사용하기 위해 생성자 호출
		spsp = new SignPanel(); 				//SignPanel을 사용하기 위해 생성자 호출
		clk = new SubMenu(); 					//Click0를 사용하기 위해 생성자 호출
		stp = new SteakPanel(); 				//SteakPanel을 사용하기 위해 생성자 호출
		psp = new PastaPanel(); 				//PastaPanel을 사용하기 위해 생성자 호출
		plp = new PilafPanel(); 				//PilafPanel을 사용하기 위해 생성자 호출
		pzp = new PizzaPanel(); 				//PizzaPanel을 사용하기 위해 생성자 호출
		sdp = new SidePanel(); 					//SidePanel을 사용하기 위해 생성자 호출
		dkp = new DrinkPanel(); 				//DrinkPanel을 사용하기 위해 생성자 호출
		set = new Mysetting(); 					//Mysetting을 사용하기 위해 생성자 호출
		rec = new showStat(); 					//showStat을 사용하기 위해 생성자 호출
		reser = new Reservation(); 				//Reservation을 사용하기 위해 생성자 호출
		event = new Event(); 					//Event를 사용하기 위해 생성자 호출
		pay = new Payment(); 					//Payment를 사용하기 위해 생성자 호출
		currenttime = new CurrentTime(); 		//CurrentTime을를 사용하기 위해 생성자 호출
		mth = new MyThread(); 					//MyThread를 사용하기 위해 생성자 호출
		
		Thread th = new Thread(currenttime); 	//currenttime을 thread class를 통해 선언
		Thread th2 = new Thread(mth);    	 	//mth를 thread class를 통해 선언
		th.start();								//thread 시작
		th2.start();							//thread 시작

		lucky = (int) (Math.random() * 10);		//무료식사 이벤트 당시 생성되는 랜덤숫자

		//ContentPane setting
		getContentPane();										//현재 작동중인 ContentPane 호출
		getContentPane().setBackground(Color.WHITE);			//현재 구동되고 있는 contentpane의 배경색 설정
		setLayout(null);										//절대 경로 배치관리자 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		
		for (int i = 0; i < 12; i++) {							
			tblabel[i] = new JLabel((i + 1) + " 번");			//table 번호 표시
			tblabel2[i] = new JLabel("", JLabel.CENTER);		//주문, 예약이 된 시간 표시
			tbtn[i] = new JButton("입석 가능");					//주문, 예약이 가능한 상태임을 표시
			tbtn[i].setLayout(new GridLayout(2, 1));			//GridLayout 설정
			tbtn[i].add(tblabel[i]);							//tblabel을 tbtn에 적용
			tbtn[i].add(tblabel2[i]);							//tblabel2를 tbtn에 적용
			label.add(tbtn[i]);									//tbtn을 label에 적용
			tbtn[i].addActionListener(new MyActionListener());	//tbtn에 ActionListener 적용
			tbtn[i].setBackground(Color.WHITE);					//tbtn 배경색 설정
			tbtn[i].addMouseListener(new MyMouseListener());	//tbtn에 MouseListener 적용
		}
		
		//tbtn의 boundary 설정
		for (int j = 0; j < 4; j++) {								
			tbtn[j].setBounds(37 + (j * 251), 45, 174, 83);
			tbtn[j + 4].setBounds(37 + (j * 251), 220, 174, 83);
			tbtn[j + 8].setBounds(37 + (j * 251), 395, 174, 83);
		}
		
		surveyre.setBounds(1040, 250, 122, 109);				//surveyre의 boundary 설정
		setting.setBounds(1040, 400, 124, 112);					//setting의 boundary 설정
		label.setBounds(0, 154, 1000, 526);						//label의 boundary 설정
		mainsign.setBounds(0, 0, 1200, 154);					//mainsign의 boundary 설정
		timelabel1.setBounds(1020, 530, 200, 40);				//timelabel1의 boundary 설정
		timelabel2.setBounds(1010, 590, 200, 40);				//timelabel2의 boundary 설정
		
		timelabel1.setFont(new Font("Bold", Font.BOLD, 25));	//timelabel1의 폰트 설정
		timelabel2.setFont(new Font("Bold", Font.BOLD, 35));	//timelabel2의 폰트 설정
		welcome.setFont(new Font("Bold", Font.BOLD, 40));		//welcome의 폰트 설정
		
		//각 ContentPane을 적용
		add(timelabel1);
		add(timelabel2);
		add(welcome);
		add(label);
		add(surveyre);
		add(setting);
		add(mainsign);
		
		//setting을 불러오기 위한 ActionListener
		setting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				set.setVisible(true);
			}
		});
		
		//surveyre를 불러오기 위한 ActionListener
		surveyre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				rec.setVisible(true);
			}
		});
		setResizable(false);			//사이즈조절 불가능하게 설정
		setSize(1200, 800);				//사이즈 지정
		setLocation(165, 100);			//위치 지정
		setVisible(true);				//Visible 대상 지정
	}

	class Mysetting extends JFrame {						// volume 설정을 위한 class
		JLabel vol = new JLabel(images.soundimg());			// Mysetting에 대한 작업을 해주기 위한 JLabel
		JButton ok = new JButton(" Set ");					// JSlider에 대한 set 작업을 해주기 위한 JButton
		JLabel setv = new JLabel("(Vol)");					// vol의 단위를 표시해주기 위한 JLabel

		Mysetting() {										// Mysetting 생성자, slider setting
			getContentPane();								//현재 작동중인 ContentPane 호출
			getContentPane().setLayout(null);				// 절대경로 배치관리자 설정

			vol.setBounds(0, -30, 450, 400);				//vol boundary 설정
			slider.setBounds(15, 190, 400, 60);				//slider boundary 설정
			setv.setBounds(390, 245, 50, 30);				//setv boundary 설정
			ok.setBounds(180, 260, 70, 40);					//ok boundary 설정
			slider.setPaintLabels(true);					// slider label 설정
			slider.setPaintTicks(true);						// slider tick 설정
			slider.setMajorTickSpacing(50);					// slider majortick setting
			slider.setMinorTickSpacing(10);					// slider minortick setting
			slider.setBackground(Color.WHITE);				// slider 배경색 설정
			slider.setFont(new Font("", Font.BOLD, 15));	// slider 폰트 설정
			slider.setValue(500);							// slider default value 설정
			
			//각 ContentPane 적용
			vol.add(ok);				
			vol.add(setv);
			vol.add(slider);
			add(vol);
			setSize(450, 330);				//사이즈 지정
			setLocation(800, 300);			//위치 지정
			setResizable(false);			//사이즈조절 불가능하게 설정
			setVisible(false);				//Visible 대상 지정
		}
	}
	
	class showStat extends JFrame {								//stat를 보여주기 위한 class
		showStat() {											//showStat 생성자, showStat setting
			Scanner sc = null;									//scanner 초기화
			try {
				sc = new Scanner(texts.goodSurvey(), "UTF-8");	//한글을 정상적으로 입출력하기 이해 UTF-8 사용하여 scanner 선언
			} catch (FileNotFoundException e1) {				//FileNotFoundException 예외처리
				e1.printStackTrace();
			}
			
			//goodSurvey에 선정된 설문조사의 항목별 설문답변 사항을 가져오기 위한 JLabel
			JLabel stats1 = new JLabel(sc.nextLine());		
			JLabel stats2 = new JLabel(sc.nextLine());		
			JLabel stats3 = new JLabel(sc.nextLine());		
			JLabel stats4 = new JLabel(sc.nextLine());
			
			setTitle("best stat");								//title 설정
			setBackground(Color.WHITE);							//배경색 설정
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
			setLayout(new FlowLayout());						//FlowLayout 배치관리자 설정
			
			//각 ContentPane을 적용
			add(stats1);
			add(stats2);
			add(stats3);
			add(stats4);
			setLocation(550,300);		//위치 지정
			setResizable(false);		//사이즈조절 불가능하게 설정
			setSize(400, 400);			//사이즈 지정
		}
	}
	
	class SignPanel extends JFrame {				// 카드 결제를 선택할 경우 싸인처리를 하기 위한 class
		BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);	//싸인을 이미지로 처리하기 위한 BufferedImage
		Graphics graphics = image.createGraphics(); 					//image를 만들기 위한 Graphics 생성
		JButton yesbtn = new JButton("결제");								//결제처리를 위한 JButton
		Point stpoint = null, epoint = null;							//싸인을 그렸을 때 이의 시작점과 끝점을 구별하기 위한 Point 변수
		JPanel signpanel = new JPanel();								//싸인을 그리기 위한 panel을 위한 JPanel
		JPanel southpanel = new JPanel();								//yesbtn을 표현하기 위한 JPanel

		SignPanel() {													//SignPanel 생성자
			setTitle("Your Sign Plz");									//title 설정
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			southpanel.setLayout(new FlowLayout());						//FlowLayout 배치관리자 설정
			southpanel.add(yesbtn);										//southpanel에 yesbtn 적용
			
			//각 ContentPane을 적용
			add(southpanel, BorderLayout.SOUTH);
			add(signpanel, BorderLayout.CENTER);
			signpanel.addMouseListener(new MyMouseAdapter());			//signpanel에 MouseAdapter 적용
			signpanel.addMouseMotionListener(new MyMouseMotion());		//signpanel에 MouseMotionListener 적용
			yesbtn.addActionListener(new ActionListener() { 			//yesbtn에 ActionListener 적용
				public void actionPerformed(ActionEvent e) {
					try {
						File file = new File("싸인" + ran + ".jpeg"); 	//싸인을 저장할 file type 생성
						ImageIO.write(image, "jpeg", file);				//지정한 file을 생성
					} catch (Exception e1) {							//Exception 예외 처리
						e1.printStackTrace();
					}
					setVisible(false);									//Visible 대상 변경
				}
			});
			setResizable(false);										//사이즈조절 불가능하게 설정
			setSize(400, 400);											//사이즈 지정
		}
		class MyMouseAdapter extends MouseAdapter {			//싸인을 그리기 위해 처음 마우스를 눌렀을 당시 point를 가져오는 class
			public void mousePressed(MouseEvent e) {
				stpoint = e.getPoint();
			}
			public void mouseReleased(MouseEvent e) {		//싸인을 그리기 위해 마우스를 누르고 다시 땠을 당시 point를 가져오는 class
				epoint = e.getPoint();
				repaint();								//초기 화면으로 초기화
			}
		}
		class MyMouseMotion extends MouseMotionAdapter {	//싸인을 그리는 과정마다 해당 point를 가져오는 class
			public void mouseDragged(MouseEvent e) {
				epoint = e.getPoint();
				repaint();								//초기 화면으로 초기화
			}
		}
		public void paint(Graphics g) { 										//싸인을 그리는 과정에서 가져온 point를 통해 graph처리하여 데이터화하는 class
			if (stpoint != null && epoint != null) {
				g.drawLine(stpoint.x, stpoint.y, epoint.x, epoint.y);			//시작점에서 끝점까지의 라인 생성
				graphics.drawLine(stpoint.x, stpoint.y, epoint.x, epoint.y);	//시작점에서 끝점까지의 라인 생성
				stpoint = epoint;												//추가 선이 발생하지않도록 초기화
			}
		}
	}
	
	class SurveyWindow extends JDialog {          								//현금 결제 후 설문조사 참여여부를 처리하는 class
		JLabel la2 = new JLabel(images.discountimg());							//차후의 할인 여부를 직관적으로 보여주기 위한 JLabel

		SurveyWindow() {														//SurveyWindow 생성자
			getContentPane();													//현재 작동중인 ContentPane 호출
			getContentPane().setBackground(Color.WHITE);						//현재 작동중인 ContentPane 배경색 지정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));				//FlowLayout 배치관리자 설정
			
			JLabel mysur = new JLabel("  설문에 참여하시면 다음번에 5%할인 해드립니다.  ");	//지정된 문구를 보여주기 위한 JLabel
			
			//각 ContentPane을 적용
			add(mysur);
			add(la2);
			add(surveyok);
			add(surveycancel);
			
			surveyok.addActionListener(new ActionListener() { 			//surveyok에 ActionListener 적용
				public void actionPerformed(ActionEvent e) {
					setModal(false);									//모달리스 설정
					new Survey();										//설문조사를 진행하기 위해 Survey 생성자 호출
					setVisible(false);									//Visible 대상 변경
				}
			});
			
			surveycancel.addActionListener(new ActionListener() { 		//surveycancel에 ActionListener 적용
				public void actionPerformed(ActionEvent e) {
					setModal(false);									//모달리스 설정
					setVisible(false);									//Visible 대상 변경
				}
			});
			setResizable(false);										//사이즈조절 불가능하게 설정
			setSize(370, 300);											//사이즈 지정
		}
	}
	
	class Survey extends JDialog { 												//설문조사에 참여하고자 하는 경우 설문조사를 진행하는 class
		Survey() {																//Survey 생성자
			Scanner sc = null;													//Scanner 초기화
			try {
				sc = new Scanner(texts.survey(), "UTF-8");      				//survey.txt에서 survey 과정에 필요한 정보 scan
			} catch (FileNotFoundException e1) {								//FileNotFoundException 예외 처리
				e1.printStackTrace();
			}
			
			//survey 과정에 필요한 정보를 표현하기 위한 JLabel
			JLabel sv1 = new JLabel(sc.nextLine(), JLabel.LEFT);
			JLabel sv2 = new JLabel(sc.nextLine(), JLabel.LEFT);
			JLabel sv3 = new JLabel(sc.nextLine(), JLabel.LEFT);
			JLabel sv4 = new JLabel(sc.nextLine(), JLabel.LEFT);
			JButton submit = new JButton("제출하기");					//제출 처리를 하기 위한 JButton
			
			setTitle("매장 평가");										//title 설정	
			getContentPane();										//현재 작동중인 ContentPane 호출
			setLayout(new GridLayout(10, 1));						//GridLayout 배치관리자 설정
			setModal(true);											//모달 설정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			//폰트 설정
			sv1.setFont(new Font("고딕체", Font.BOLD, 16));
			sv2.setFont(new Font("고딕체", Font.BOLD, 16));
			sv3.setFont(new Font("고딕체", Font.BOLD, 16));
			sv4.setFont(new Font("고딕체", Font.BOLD, 16));
			
			for (int i = 0; i < 5; i++)
				surveytxt[i] = new JTextField(40);					//설문조사 항목을 받아오기 위한 JTextField 설정
			
			//각 ContentPane을 적용
			add(sv1);
			add(surveytxt[0]);
			add(sv2);
			add(surveytxt[1]);
			add(sv3);
			add(surveytxt[2]);
			add(sv4);
			add(surveytxt[3]);
			add(submit);
			
			submit.addActionListener(new ActionListener() { 	//submit에 ActionListener 적용
				public void actionPerformed(ActionEvent e) {
					setVisible(false);							//Visible 대상 변경
					System.out.println("");
					new SurveyWrite();							//Survey에서 입력한 정보를 데이터화하기 위해 SurveyWrite 생성자 호출
				}
			});
			setSize(500, 600);									//사이즈 지정
			setResizable(false);								//사이즈조절 불가능하게 설정
			setVisible(true);									//Visible 대상 지정
		}
	}
	
	class SurveyWrite {											//설문조사 과정에서 JTextField에 입력된 정보를 데이터화하는 class
		SurveyWrite() {											//SurveyWrite 생성자
			String fileName = "설문조사" + ran + ".txt";			//정보를 데이터화하여 저장할 File 이름 지정
			
			try {
				File file = new File(fileName);					//정보를 데이터화하여 저장할 File type 지정
				FileWriter fw = new FileWriter(file);			//데이터를 저장하기 위한 FileWriter 생성
				for (int i = 0; i < 5; i++)
					fw.write(surveytxt[i].getText() + "  ");	//설문조사 과정에서 JTextField에 입력된 정보를 해당 File에 저장
				fw.flush();										//출력안된 정보가 없도록 flush 처리
				fw.close();										
			} catch (Exception e) {								//Exception 예외처리
				e.printStackTrace();
			}
		}
	}

	class OrderInfo extends JDialog {																//table정보를 조회했을 때 주문현황을 조회할 수 있도록 하는 class
		JLabel foodinfo[] = new JLabel[20];															//현재 주문현황을 저장하기 위한 JLabel
		JLabel north = new JLabel("< 주 문 내 역  >", JLabel.CENTER);									//앞으로 나올 내용이 현재 주문현황임을 표시하기 위한 JLabel
		JLabel south;																				//앞으로 나올 내용이 현재 주문총액임을 표시하기 위한 JLabel

		OrderInfo() {																				//OrderInfo 생성자	
			setTitle("주문 현황");																		//title 지정													
			getContentPane();																		//현재 작동중인 ContentPane 호출
			getContentPane().setBackground(Color.WHITE);											//현재 작동중인 ContentPane의 배경색 설정
			setLayout(null);																		//절대 경로 배치관리자 설정
			setModal(true);																			//모달 설정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

			north.setBounds(10, 10, 360, 25);														//north boundary 설정
			add(north);																				//north 적용
			
			if (select == 1) {																		//1번 Table이 선택되었을 때
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t1info[i]);											//t1info를 표현하기 위해 foodinfo로 전달
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary 설정
					t1money[i] = new JLabel(t1price[i]);											//t1price를 표현하기 위해 t1money로 전달
					t1money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t1money boundary 설정
					add(t1money[i]);																//t1money 적용
					south = new JLabel("< 합 계 금 액  > : " + money[0] + " 원입니다.", JLabel.CENTER);	//south에 표현할 내용 덮어쓰기
				}
			} 
			else if (select == 2) {																	//2번 Table이 선택되었을 때
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t2info[i]);											//t2info를 표현하기 위해 foodinfo로 전달
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary 설정
					t2money[i] = new JLabel(t2price[i]);											//t2price를 표현하기 위해 t2money로 전달
					t2money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t2money boundary 설정
					add(t2money[i]);																//t2money 적용
					south = new JLabel("< 합 계 금 액  > : " + money[1] + " 원입니다.", JLabel.CENTER);	//south에 표현할 내용 덮어쓰기
				}
			}
			else if (select == 3) {																	//3번 Table이 선택되었을 때
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t3info[i]);											//t3info를 표현하기 위해 foodinfo로 전달
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary 설정
					t3money[i] = new JLabel(t3price[i]);											//t3price를 표현하기 위해 t3money로 전달
					t3money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t3money boundary 설정
					add(t3money[i]);																//t3money 적용
					south = new JLabel("< 합 계 금 액  > : " + money[2] + " 원입니다.", JLabel.CENTER);	//south에 표현할 내용 덮어쓰기
				}
			}
			else if (select == 4) {																	//4번 Table이 선택되었을 때
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t4info[i]);											//t4info를 표현하기 위해 foodinfo로 전달
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary 설정
					t4money[i] = new JLabel(t4price[i]);											//t4price를 표현하기 위해 t4money로 전달
					t4money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t4money boundary 설정
					add(t4money[i]);																//t4money 적용
					south = new JLabel("< 합 계 금 액  > : " + money[3] + " 원입니다.", JLabel.CENTER);	//south에 표현할 내용 덮어쓰기
				}
			}
			else if (select == 5) {																	//5번 Table이 선택되었을 때
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t5info[i]);											//t5info를 표현하기 위해 foodinfo로 전달
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary 설정
					t5money[i] = new JLabel(t5price[i]);											//t5price를 표현하기 위해 t5money로 전달
					t5money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t5money boundary 설정
					add(t5money[i]);																//t5money 적용
					south = new JLabel("< 합 계 금 액  > : " + money[4] + " 원입니다.", JLabel.CENTER);	//south에 표현할 내용 덮어쓰기
				}
			}
			else if (select == 6) {																	//6번 Table이 선택되었을 때
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t6info[i]);											//t6info를 표현하기 위해 foodinfo로 전달
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary 설정
					t6money[i] = new JLabel(t6price[i]);											//t6price를 표현하기 위해 t6money로 전달
					t6money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t6money boundary 설정
					add(t6money[i]);																//t6money 적용
					south = new JLabel("< 합 계 금 액  > : " + money[5] + " 원입니다.", JLabel.CENTER);	//south에 표현할 내용 덮어쓰기
				}
			}
			else if (select == 7) {																	//7번 Table이 선택되었을 때
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t7info[i]);											//t7info를 표현하기 위해 foodinfo로 전달
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary 설정
					t7money[i] = new JLabel(t7price[i]);											//t7price를 표현하기 위해 t7money로 전달
					t7money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t7money boundary 설정
					add(t7money[i]);																//t7money 적용
					south = new JLabel("< 합 계 금 액  > : " + money[6] + " 원입니다.", JLabel.CENTER);	//south에 표현할 내용 덮어쓰기
				}
			}
			else if (select == 8) {																	//8번 Table이 선택되었을 때
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t8info[i]);											//t8info를 표현하기 위해 foodinfo로 전달
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary 설정
					t8money[i] = new JLabel(t8price[i]);											//t8price를 표현하기 위해 t8money로 전달
					t8money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t8money boundary 설정
					add(t8money[i]);																//t8money 적용
					south = new JLabel("< 합 계 금 액  > : " + money[7] + " 원입니다.", JLabel.CENTER);	//south에 표현할 내용 덮어쓰기
				}
			}
			else if (select == 9) {																	//9번 Table이 선택되었을 때
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t9info[i]);											//t9info를 표현하기 위해 foodinfo로 전달
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary 설정
					t9money[i] = new JLabel(t9price[i]);											//t9price를 표현하기 위해 t9money로 전달
					t9money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t9money boundary 설정
					add(t9money[i]);																//t9money 적용
					south = new JLabel("< 합 계 금 액  > : " + money[8] + " 원입니다.", JLabel.CENTER);	//south에 표현할 내용 덮어쓰기
				}
			}
			else if (select == 10) {																//10번 Table이 선택되었을 때
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t10info[i]);											//t10info를 표현하기 위해 foodinfo로 전달
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary 설정
					t10money[i] = new JLabel(t10price[i]);											//t10price를 표현하기 위해 t10money로 전달
					t10money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t10money boundary 설정
					add(t10money[i]);																//t10money 적용
					south = new JLabel("< 합 계 금 액  > : " + money[9] + " 원입니다.", JLabel.CENTER);	//south에 표현할 내용 덮어쓰기
				}
			}
			else if (select == 11) {																//11번 Table이 선택되었을 때
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t11info[i]);											//t11info를 표현하기 위해 foodinfo로 전달
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary 설정
					t11money[i] = new JLabel(t11price[i]);											//t11price를 표현하기 위해 t11money로 전달
					t11money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t11money boundary 설정
					add(t11money[i]);																//t11money 적용
					south = new JLabel("< 합 계 금 액  > : " + money[10] + " 원입니다.", JLabel.CENTER);	//south에 표현할 내용 덮어쓰기
				}
			}
			else if (select == 12) {																//12번 Table이 선택되었을 때
				for (int i = 0; i < 20; i++) {
					foodinfo[i] = new JLabel(t12info[i]);											//t12info를 표현하기 위해 foodinfo로 전달
					foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);								//foodinfo boundary 설정
					t12money[i] = new JLabel(t12price[i]);											//t12price를 표현하기 위해 t12money로 전달
					t12money[i].setBounds(195, 40 + (i * 30), 100, 25);								//t12money boundary 설정
					add(t12money[i]);																//t12money 적용
					south = new JLabel("< 합 계 금 액  > : " + money[11] + " 원입니다.", JLabel.CENTER);	//south에 표현할 내용 덮어쓰기
				}
			}
			
			for (int i = 0; i < 20; i++)			
				add(foodinfo[i]);					//foodinfo 적용
			south.setBounds(100, 300, 300, 30);		//south boundary 설정
			add(south);								//south 적용
			setSize(400, 500);						//사이즈 지정
			setVisible(true);						//Visible 대상 지정
		}
	}

	class Payment extends JFrame {															//결제 처리를 하기 위한 class
		Payment() {																			//Payment 생성자
			for (int i = 0; i < 20; i++)
				foodinfo[i] = new JLabel();													//현재 주문현황을 저장하기 위한 JLabel
			setTitle("Payment Security 1.0");												//title 지정
			getContentPane();																//현재 작동중인 ContentPane 호출
			getContentPane().setBackground(Color.WHITE);									//현재 작동중인 ContentPane 배경색 지정
			setLayout(null);																//절대 경로 배치관리자 설정													
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			for (int i = 0; i < 20; i++) {
				foodinfo[i].setBounds(40, 40 + (i * 30), 150, 25);							//foodinfo boundary 설정
				add(foodinfo[i]);															//foodinfo 적용
			}
			
			paybtn1.addActionListener(new ActionListener() { 								//paybtn1에 ActionListener 적용
				public void actionPerformed(ActionEvent e) {
					setVisible(false);														//Visible 대상 변경
					for (int i = 0; i < 20; i++)
						foodinfo[i].setText("");											//foodinfo 초기화
					
					if (select == 1) {														//1번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[0] = 0;															
						System.out.println("1번 테이블에서 " + money[0] + " 원이 계산되었습니다.");	
						tbtn[0].setText("입석 가능");											
						tbtn[0].setBackground(Color.WHITE);									
						tblabel2[0].setText("");											
						money[0] = 0;														
						for (int i = 0; i < 20; i++) {
							t1money[i].setText("");
							t1info[i] = "";
							t1price[i] = "";
						}
					}else if (select == 2) {												//2번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[1] = 0;
						System.out.println("2번 테이블에서 " + money[1] + " 원이 계산되었습니다.");
						tbtn[1].setText("입석 가능");
						tbtn[1].setBackground(Color.WHITE);
						tblabel2[1].setText("");
						money[1] = 0;
						for (int i = 0; i < 20; i++) {
							t2money[i].setText("");
							t2info[i] = "";
							t2price[i] = "";
						}
					}else if (select == 3) {												//3번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[2] = 0;
						System.out.println("3번 테이블에서 " + money[2] + " 원이 계산되었습니다.");
						tbtn[2].setText("입석 가능");
						tbtn[2].setBackground(Color.WHITE);
						tblabel2[2].setText("");
						money[2] = 0;
						for (int i = 0; i < 20; i++) {
							t3money[i].setText("");
							t3info[i] = "";
							t3price[i] = "";
						}
					}else if (select == 4) {												//4번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[3] = 0;
						System.out.println("4번 테이블에서 " + money[3] + " 원이 계산되었습니다.");
						tbtn[3].setText("입석 가능");
						tbtn[3].setBackground(Color.WHITE);
						tblabel2[3].setText("");
						money[3] = 0;
						for (int i = 0; i < 20; i++) {
							t4money[i].setText("");
							t4info[i] = "";
							t4price[i] = "";
						}
					}else if (select == 5) {												//5번 Table이 선택되었을 때  존재하던 데이터를 기본 값으로 초기화
						num[4] = 0;
						System.out.println("5번 테이블에서 " + money[4] + " 원이 계산되었습니다.");
						tbtn[4].setText("입석 가능");
						tbtn[4].setBackground(Color.WHITE);
						tblabel2[4].setText("");
						money[4] = 0;
						for (int i = 0; i < 20; i++) {
							t5money[i].setText("");
							t5info[i] = "";
							t5price[i] = "";
						}
					}else if (select == 6) {												//6번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[5] = 0;
						System.out.println("6번 테이블에서 " + money[5] + " 원이 계산되었습니다.");
						tbtn[5].setText("입석 가능");
						tbtn[5].setBackground(Color.WHITE);
						tblabel2[5].setText("");
						money[5] = 0;
						for (int i = 0; i < 20; i++) {
							t6money[i].setText("");
							t6info[i] = "";
							t6price[i] = "";
						}
					} else if (select == 7) {												//7번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[6] = 7;
						System.out.println("7번 테이블에서 " + money[6] + " 원이 계산되었습니다.");
						tbtn[6].setText("입석 가능");
						tbtn[6].setBackground(Color.WHITE);
						tblabel2[6].setText("");
						money[6] = 0;
						for (int i = 0; i < 20; i++) {
							t7money[i].setText("");
							t7info[i] = "";
							t7price[i] = "";
						}
					} else if (select == 8) {												//8번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[7] = 0;
						System.out.println("8번 테이블에서 " + money[7] + " 원이 계산되었습니다.");
						tbtn[7].setText("입석 가능");
						tbtn[7].setBackground(Color.WHITE);
						tblabel2[7].setText("");
						money[7] = 0;
						for (int i = 0; i < 20; i++) {
							t8money[i].setText("");
							t8info[i] = "";
							t8price[i] = "";
						}
					} else if (select == 9) {												//9번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[8] = 0;
						System.out.println("9번 테이블에서 " + money[8] + " 원이 계산되었습니다.");
						tbtn[8].setText("입석 가능");
						tbtn[8].setBackground(Color.WHITE);
						tblabel2[8].setText("");
						money[8] = 0;
						for (int i = 0; i < 20; i++) {
							t9money[i].setText("");
							t9info[i] = "";
							t9price[i] = "";
						}
					} else if (select == 10) {												//10번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[9] = 10;
						System.out.println("10번 테이블에서 " + money[9] + " 원이 계산되었습니다.");
						tbtn[9].setText("입석 가능");
						tbtn[9].setBackground(Color.WHITE);
						tblabel2[9].setText("");
						money[9] = 0;
						for (int i = 0; i < 20; i++) {
							t10money[i].setText("");
							t10info[i] = "";
							t10price[i] = "";
						}
					} else if (select == 11) {												//11번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[10] = 0;
						System.out.println("11번 테이블에서 " + money[10] + " 원이 계산되었습니다.");
						tbtn[10].setText("입석 가능");
						tbtn[10].setBackground(Color.WHITE);
						tblabel2[10].setText("");
						money[10] = 0;
						for (int i = 0; i < 20; i++) {
							t11money[i].setText("");
							t11info[i] = "";
							t11price[i] = "";
						}
					} else if (select == 12) {												//12번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[11] = 0;
						System.out.println("12번 테이블에서 " + money[11] + " 원이 계산되었습니다.");
						tbtn[11].setText("입석 가능");
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
			
			paybtn2.addActionListener(new ActionListener() { 								//paybtn2에 ActionListener 적용
				public void actionPerformed(ActionEvent e) {
					setVisible(false);														//Visible 대상 변경
					spsp.setVisible(true);													//spsp를 Visible 대상으로 지정
					for (int i = 0; i < 20; i++)
						foodinfo[i].setText("");											//foodinfo 초기화
					if (select == 1) {														//1번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[0] = 0;
						System.out.println("1번 테이블에서 " + money[0] + " 원이 계산되었습니다.");
						tbtn[0].setText("입석 가능");
						tbtn[0].setBackground(Color.WHITE);
						tblabel2[0].setText("");
						money[0] = 0;
						for (int i = 0; i < 20; i++) {
							t1money[i].setText("");
							t1info[i] = "";
							t1price[i] = "";
						}
					} else if (select == 2) {												//2번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[1] = 0;
						System.out.println("2번 테이블에서 " + money[1] + " 원이 계산되었습니다.");
						tbtn[1].setText("입석 가능");
						tbtn[1].setBackground(Color.WHITE);
						tblabel2[1].setText("");
						money[1] = 0;
						for (int i = 0; i < 20; i++) {
							t2money[i].setText("");
							t2info[i] = "";
							t2price[i] = "";
						}
					} else if (select == 3) {												//3번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[2] = 0;
						System.out.println("3번 테이블에서 " + money[2] + " 원이 계산되었습니다.");
						tbtn[2].setText("입석 가능");
						tbtn[2].setBackground(Color.WHITE);
						tblabel2[2].setText("");
						money[2] = 0;
						for (int i = 0; i < 20; i++) {
							t3money[i].setText("");
							t3info[i] = "";
							t3price[i] = "";
						}
					} else if (select == 4) {												//4번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[3] = 0;
						System.out.println("4번 테이블에서 " + money[3] + " 원이 계산되었습니다.");
						tbtn[3].setText("입석 가능");
						tbtn[3].setBackground(Color.WHITE);
						tblabel2[3].setText("");
						money[3] = 0;
						for (int i = 0; i < 20; i++) {
							t4money[i].setText("");
							t4info[i] = "";
							t4price[i] = "";
						}
					} else if (select == 5) {												//5번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[4] = 0;
						System.out.println("5번 테이블에서 " + money[4] + " 원이 계산되었습니다.");
						tbtn[4].setText("입석 가능");
						tbtn[4].setBackground(Color.WHITE);
						tblabel2[4].setText("");
						money[4] = 0;
						for (int i = 0; i < 20; i++) {
							t5money[i].setText("");
							t5info[i] = "";
							t5price[i] = "";
						}
					} else if (select == 6) {												//6번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[5] = 0;
						System.out.println("6번 테이블에서 " + money[5] + " 원이 계산되었습니다.");
						tbtn[5].setText("입석 가능");
						tbtn[5].setBackground(Color.WHITE);
						tblabel2[5].setText("");
						money[5] = 0;
						for (int i = 0; i < 20; i++) {
							t6money[i].setText("");
							t6info[i] = "";
							t6price[i] = "";
						}
					} else if (select == 7) {												//7번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[6] = 7;
						System.out.println("7번 테이블에서 " + money[6] + " 원이 계산되었습니다.");
						tbtn[6].setText("입석 가능");
						tbtn[6].setBackground(Color.WHITE);
						tblabel2[6].setText("");
						money[6] = 0;
						for (int i = 0; i < 20; i++) {
							t7money[i].setText("");
							t7info[i] = "";
							t7price[i] = "";
						}
					} else if (select == 8) {												//8번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[7] = 0;
						System.out.println("8번 테이블에서 " + money[7] + " 원이 계산되었습니다.");
						tbtn[7].setText("입석 가능");
						tbtn[7].setBackground(Color.WHITE);
						tblabel2[7].setText("");
						money[7] = 0;
						for (int i = 0; i < 20; i++) {
							t8money[i].setText("");
							t8info[i] = "";
							t8price[i] = "";
						}
					} else if (select == 9) {												//9번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[8] = 0;
						System.out.println("9번 테이블에서 " + money[8] + " 원이 계산되었습니다.");
						tbtn[8].setText("입석 가능");
						tbtn[8].setBackground(Color.WHITE);
						tblabel2[8].setText("");
						money[8] = 0;
						for (int i = 0; i < 20; i++) {
							t9money[i].setText("");
							t9info[i] = "";
							t9price[i] = "";
						}
					} else if (select == 10) {												//10번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[9] = 10;
						System.out.println("10번 테이블에서 " + money[9] + " 원이 계산되었습니다.");
						tbtn[9].setText("입석 가능");
						tbtn[9].setBackground(Color.WHITE);
						tblabel2[9].setText("");
						money[9] = 0;
						for (int i = 0; i < 20; i++) {
							t10money[i].setText("");
							t10info[i] = "";
							t10price[i] = "";
						}
					} else if (select == 11) {												//11번 Table이 선택되었을 때  존재하던 데이터를 기본 값으로 초기화
						num[10] = 0;
						System.out.println("11번 테이블에서 " + money[10] + " 원이 계산되었습니다.");
						tbtn[10].setText("입석 가능");
						tbtn[10].setBackground(Color.WHITE);
						tblabel2[10].setText("");
						money[10] = 0;
						for (int i = 0; i < 20; i++) {
							t11money[i].setText("");
							t11info[i] = "";
							t11price[i] = "";
						}
					} else if (select == 12) {												//12번 Table이 선택되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[11] = 0;
						System.out.println("12번 테이블에서 " + money[11] + " 원이 계산되었습니다.");
						tbtn[11].setText("입석 가능");
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
			
			south2.setBounds(30, 435, 400, 30);						//south2 boundary 설정
			north.setBounds(10, 10, 360, 25);						//north boundary 설정
			paybtn1.setBounds(60, 480, 117, 104);					//paybtn1 boundary 설정
			paybtn2.setBounds(190, 480, 117, 104);					//paybtn2 boundary 설정
			south2.setFont(new Font("GOOD", Font.BOLD, 16));		//south2 Font 설정

			//각 ContentPane을 적용
			add(north);
			add(south2);
			add(paybtn1);
			add(paybtn2);
			paybtn1.setVisible(true);							//paybtn1을 Visible 대상으로 지정
			paybtn2.setVisible(true);							//paybtn2를 Visible 대상으로 지정
			setResizable(false);								//사이즈조절 불가능하게 설정
			setSize(400, 650);									//사이즈 지정
			setVisible(false);									//Visible 대상 변경
		}
	}
	
	class SteakPanel extends JDialog {									//menu중 steak menu에 관련된 처리를 하기 위한 class
		SteakPanel() {													//SteakPanel 생성자
			steakimg steakimg = new steakimg();							//steak menu image를 사용하기 위해 steakimg 생성자 호출
			Scanner sc = null;											//scanner 초기화
			try {
				sc = new Scanner(texts.steak(), "UTF-8");      			//steak.txt에서 steak panel에 필요한 정보 scan
			} catch (FileNotFoundException e1) {						//FileNotFoundException 예외 처리
				e1.printStackTrace();
			}
			
			setTitle("Menu - Steak");									//title 지정
			getContentPane();											//현재 작동중인 ContentPane 호출
			setLayout(null);											//절대 경로 배치관리자 지정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);												//모달 설정
			
			//steak menu를 직관적으로 표현하기 위한 JLabel
			steaklabel[0] = new JLabel(steakimg.steak1img());			
			steaklabel[1] = new JLabel(steakimg.steak2img());
			steaklabel[2] = new JLabel(steakimg.steak3img());
			steaklabel[3] = new JLabel(steakimg.steak4img());
			steaklabel[4] = new JLabel(steakimg.steak5img());
			steaklabel[5] = new JLabel(steakimg.steak6img());
			steaklabel[6] = new JLabel(steakimg.steak7img());
			
			//steak menu를 표현하기 위한 JLabel
			steakname[0] = new JLabel(sc.nextLine(), JLabel.CENTER);
			steakname[1] = new JLabel(sc.nextLine(), JLabel.CENTER);
			steakname[2] = new JLabel(sc.nextLine(), JLabel.CENTER);
			steakname[3] = new JLabel(sc.nextLine(), JLabel.CENTER);
			steakname[4] = new JLabel(sc.nextLine(), JLabel.CENTER);
			steakname[5] = new JLabel(sc.nextLine(), JLabel.CENTER);
			steakname[6] = new JLabel(sc.nextLine(), JLabel.CENTER);
			
			for (int i = 0; i < 7; i++) {
				steakorder[i] = new JButton(images.orderimg());			//주문 요청을 처리하기 위한 JButton
				steakname[i].setForeground(Color.BLACK);				//steakname의 색 지정
				steakorder[i].addActionListener(new SteakAction());		//steakorder에 ActionListener 적용
				//각 ContentPane을 적용
				stkpic.add(steaklabel[i]);
				stkpic.add(steakname[i]);
				stkpic.add(steakorder[i]);

			}
			
			//steaklabel boundary 설정
			steaklabel[0].setBounds(10, 50, 196, 126);
			steaklabel[1].setBounds(260, 50, 196, 126);
			steaklabel[2].setBounds(510, 50, 196, 126);
			steaklabel[3].setBounds(10, 260, 196, 126);
			steaklabel[4].setBounds(260, 260, 196, 126);
			steaklabel[5].setBounds(510, 260, 196, 126);
			steaklabel[6].setBounds(10, 470, 196, 126);

			//steakname boundary 설정
			steakname[0].setBounds(10, 190, 196, 20);
			steakname[1].setBounds(260, 190, 196, 20);
			steakname[2].setBounds(510, 190, 196, 20);
			steakname[3].setBounds(10, 400, 196, 20);
			steakname[4].setBounds(260, 400, 196, 20);
			steakname[5].setBounds(510, 400, 196, 20);
			steakname[6].setBounds(10, 610, 196, 20);

			//steakorder boundary 설정
			steakorder[0].setBounds(50, 212, 116, 35);
			steakorder[1].setBounds(300, 212, 116, 35);
			steakorder[2].setBounds(550, 212, 116, 35);
			steakorder[3].setBounds(50, 422, 116, 35);
			steakorder[4].setBounds(300, 422, 116, 35);
			steakorder[5].setBounds(550, 422, 116, 35);
			steakorder[6].setBounds(50, 632, 116, 35);
			stkpic.setBounds(0, 0, 750, 690);
			
			add(stkpic);				//stkpic 적용
			setSize(750, 730);			//사이즈 지정
			setLocation(165, 100);		//위치 지정
			setResizable(false);		//사이즈조절 불가능하게 설정
			setVisible(false);			//Visible 대상 변경
		}

		class SteakAction implements ActionListener { 													//주문요청을 처리 하기 위한 class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == steakorder[0]) {													//닭가슴살 스테이크가 선택되었을 때
					if (select == 1) {																	//1번 Table이 선택되었다면
						money[0] += 19800;																//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t1info[num[0]] = "닭가슴살 스테이크";												//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 2) {															//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가															//총액에 지정된 값 추가   															//총액에 지정된 값 추가
						t2info[num[1]] = "닭가슴살 스테이크";												//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 3) {															//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t3info[num[2]] = "닭가슴살 스테이크";												//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 4) {															//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t4info[num[3]] = "닭가슴살 스테이크";												//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 5) {															//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t5info[num[4]] = "닭가슴살 스테이크";												//지정된 메뉴 추가
						t1price[num[4]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 6) {															//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t6info[num[5]] = "닭가슴살 스테이크";												//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 7) {															//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t7info[num[6]] = "닭가슴살 스테이크";												//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 8) {															//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t8info[num[7]] = "닭가슴살 스테이크";												//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 9) {															//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t9info[num[8]] = "닭가슴살 스테이크";												//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 10) {															//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t10info[num[9]] = "닭가슴살 스테이크";												//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t11info[num[10]] = "닭가슴살 스테이크";												//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t12info[num[11]] = "닭가슴살 스테이크";												//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					}
				} else if (e.getSource() == steakorder[1]) {											//목살 스테이크가 선택되었을 때
					if (select == 1) {																	//1번 Table이 선택되었다면
						money[0] += 19800;																//총액에 지정된 값 추가
						t1info[num[0]] = "목살 스테이크";													//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																		//총 주문갯수 증가
					} else if (select == 2) {															//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t2info[num[1]] = "목살 스테이크";													//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 3) {															//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t3info[num[2]] = "목살 스테이크";													//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 4) {															//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t4info[num[3]] = "목살 스테이크";													//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[0]] + " 합계금액 : " + money[3]);
						num[3]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 5) {															//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t5info[num[4]] = "목살 스테이크";													//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 6) {															//6번 Table이 선택되었다면			
						money[5] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t6info[num[5]] = "목살 스테이크";													//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 7) {															//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t7info[num[6]] = "목살 스테이크";													//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[0]] + " 합계금액 : " + money[6]);
						num[6]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 8) {															//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t1info[num[7]] = "목살 스테이크";													//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 9) {															//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t9info[num[8]] = "목살 스테이크";													//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 10) {															//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t10info[num[9]] = "목살 스테이크";													//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t11info[num[10]] = "목살 스테이크";													//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t12info[num[11]] = "목살 스테이크";													//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					}
				} else if (e.getSource() == steakorder[2]) {											//스파이시 스테이크가 선택되었을 때
					if (select == 1) {																	//1번 Table이 선택되었다면
						money[0] += 19800;																//총액에 지정된 값 추가
						t1info[num[0]] = "스파이시 스테이크";												//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																		//총 주문갯수 증가
					} else if (select == 2) {															//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t2info[num[1]] = "스파이시 스테이크";												//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 3) {															//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t3info[num[2]] = "스파이시 스테이크";												//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 4) {															//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t4info[num[3]] = "스파이시 스테이크";												//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 5) {															//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t5info[num[4]] = "스파이시 스테이크";												//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 6) {															//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t6info[num[5]] = "스파이시 스테이크";												//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 7) {															//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t7info[num[6]] = "스파이시 스테이크";												//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 8) {															//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t8info[num[7]] = "스파이시 스테이크";												//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 9) {															//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t9info[num[8]] = "스파이시 스테이크";												//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 10) {															//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t10info[num[9]] = "스파이시 스테이크";												//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t11info[num[10]] = "스파이시 스테이크";												//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t12info[num[11]] = "스파이시 스테이크";												//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					}
				} else if (e.getSource() == steakorder[3]) {											//닭다리살 스테이크가 선택되었을 때
					if (select == 1) {																	//1번 Table이 선택되었다면
						money[0] += 19800;																//총액에 지정된 값 추가
						t1info[num[0]] = "닭다리살 스테이크";												//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																		//총 주문갯수 증가
					} else if (select == 2) {															//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t2info[num[1]] = "닭다리살 스테이크";												//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 3) {															//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t3info[num[2]] = "닭다리살 스테이크";												//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 4) {															//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t4info[num[3]] = "닭다리살 스테이크";												//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 5) {															//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t5info[num[4]] = "닭다리살 스테이크";												//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 6) {															//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t6info[num[5]] = "닭다리살 스테이크";												//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 7) {															//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t7info[num[6]] = "닭다리살 스테이크";												//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 8) {															//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t8info[num[7]] = "닭다리살 스테이크";												//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[8]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 9) {															//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t9info[num[8]] = "닭다리살 스테이크";												//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 10) {															//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t10info[num[9]] = "닭다리살 스테이크";												//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t11info[num[0]] = "닭다리살 스테이크";												//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t12info[num[11]] = "닭다리살 스테이크";												//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					}
				} else if (e.getSource() == steakorder[4]) {											//통삼겹 스테이크가 선택되었을 때
					if (select == 1) {																	//1번 Table이 선택되었다면
						money[0] += 19800;																//총액에 지정된 값 추가
						t1info[num[0]] = "통삼겹 스테이크";													//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																		//총 주문갯수 증가
					} else if (select == 2) {															//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t2info[num[1]] = "통삼겹 스테이크";													//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 3) {															//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t3info[num[2]] = "통삼겹 스테이크";													//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 4) {															//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가	
						t4info[num[3]] = "통삼겹 스테이크";													//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 5) {															//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t5info[num[4]] = "통삼겹 스테이크";													//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 6) {															//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가	
						t6info[num[5]] = "통삼겹 스테이크";													//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 7) {															//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t7info[num[6]] = "통삼겹 스테이크";													//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 8) {															//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t8info[num[7]] = "통삼겹 스테이크";													//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 9) {															//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t9info[num[8]] = "통삼겹 스테이크";													//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 10) {															//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t10info[num[9]] = "통삼겹 스테이크";													//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t11info[num[10]] = "통삼겹 스테이크";												//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t1info[num[11]] = "통삼겹 스테이크";													//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					}
				} else if (e.getSource() == steakorder[5]) {											//폭찹 스테이크가 선택되었을 때
					if (select == 1) {																	//1번 Table이 선택되었다면
						money[0] += 19800;																//총액에 지정된 값 추가
						t1info[num[0]] = "폭찹 스테이크";													//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																		//총 주문갯수 증가
					} else if (select == 2) {															//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t2info[num[1]] = "폭찹 스테이크";													//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 3) {															//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t3info[num[2]] = "폭찹 스테이크";													//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 4) {															//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t4info[num[3]] = "폭찹 스테이크";													//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 5) {															//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t5info[num[4]] = "폭찹 스테이크";													//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 6) {															//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t6info[num[5]] = "폭찹 스테이크";													//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 7) {															//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t7info[num[6]] = "폭찹 스테이크";													//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 8) {															//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t8info[num[7]] = "폭찹 스테이크";													//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 9) {															//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t9info[num[8]] = "폭찹 스테이크";													//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 10) {															//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t10info[num[9]] = "폭찹 스테이크";													//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t11info[num[10]] = "폭찹 스테이크";													//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t12info[num[11]] = "폭찹 스테이크";													//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					}
				} else if (e.getSource() == steakorder[6]) {											//항정살 스테이크가 선택되었을 때
					if (select == 1) {																	//1번 Table이 선택되었다면
						money[0] += 19800;																//총액에 지정된 값 추가
						t1info[num[0]] = "항정살 스테이크";													//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																		//총 주문갯수 증가
					} else if (select == 2) {															//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t2info[num[1]] = "항정살 스테이크";													//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 3) {															//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t3info[num[2]] = "항정살 스테이크";													//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 4) {															//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t4info[num[3]] = "항정살 스테이크";													//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 5) {															//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t5info[num[4]] = "항정살 스테이크";													//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 6) {															//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t6info[num[5]] = "항정살 스테이크";													//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 7) {															//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t7info[num[6]] = "항정살 스테이크";													//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 8) {															//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t8info[num[7]] = "항정살 스테이크";													//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 9) {															//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t9info[num[8]] = "항정살 스테이크";													//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 10) {															//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t10info[num[9]] = "항정살 스테이크";													//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t11info[num[10]] = "항정살 스테이크";												//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;															//총액에 지정된 값 추가																//총액에 지정된 값 추가
						t12info[num[11]] = "항정살 스테이크";												//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가																		//총 주문갯수 증가
					}
				}
			}
		}
	}

	class PastaPanel extends JDialog {									//menu중 pasta menu에 관련된 처리를 하기 위한 class
		PastaPanel() {													//PastaPanel 생성자
			pastaimg pastaimg = new pastaimg();							//Pasta image를 사용하기 위해 pastaimg 생성자 호출
			Scanner sc = null;											//scanner 초기화
			try {
				sc = new Scanner(texts.pasta(), "UTF-8");      			//pasta.txt에서 pasta panel에 필요한 정보 scan
			} catch (FileNotFoundException e1) {						//FileNotFoundException 예외 처리
				e1.printStackTrace();
			}
			
			setTitle("Menu - Pasta");									//title 지정
			getContentPane();											//현재 작동중인 ContentPane 호출
			setLayout(null);											//절대 경로 배치관리자 설정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);												//모달 설정
			
			//pasta menu를 직관적으로 표현하기 위한 JLabel
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
			
			//pasta menu를 표현하기 위한 JLabel
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
				pastaorder[i] = new JButton(images.orderimg());			//주문 요청을 처리하기 위한 JButton
				pastaname[i].setForeground(Color.BLACK);				//pastaname의 색 지정
				//각 ContentPane을 적용
				pstpic.add(pastalabel[i]);								
				pstpic.add(pastaname[i]);
				pstpic.add(pastaorder[i]);
				pastaorder[i].addActionListener(new PastaAction());		//pastaorder에 ActionListener 적용
			}
			
			//pastalabel boundary 설정
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

			//pastaname boundary 설정
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

			//pastaorder boundary 설정
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

			pstpic.setBounds(0, 0, 750, 690);				//pstpic boundary 설정
			add(pstpic);									//pstpic 적용
			setLocation(165, 100);							//위치 지정
			setSize(750, 690);								//사이즈 지정
			setResizable(false);							//사이즈조절 불가능하게 설정
			setVisible(false);								//Visible 대상 변경
		}

		class PastaAction implements ActionListener {												//주문요청을 처리 하기 위한 class
			public void actionPerformed(ActionEvent e) { 	
				if (e.getSource() == pastaorder[0]) {												//머쉬룸 치킨 파스타가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "머쉬룸 치킨 파스타";											//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면	
						money[1] += 19800;															//총액에 지정된 값 추가
						t2info[num[1]] = "머쉬룸 치킨 파스타";											//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "머쉬룸 치킨 파스타";											//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면	
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "머쉬룸 치킨 파스타";											//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면	
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "머쉬룸 치킨 파스타";											//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면		
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "머쉬룸 치킨 파스타";											//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면	
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "머쉬룸 치킨 파스타";											//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면		
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "머쉬룸 치킨 파스타";											//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면		
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "머쉬룸 치킨 파스타";											//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면		
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "머쉬룸 치킨 파스타";											//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {														//11번 Table이 선택되었다면		
						money[10] += 19800;															//총액에 지정된 값 추가
						t11info[num[10]] = "머쉬룸 치킨 파스타";											//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																	//총 주문갯수 증가
					} else if (select == 12) {														//12번 Table이 선택되었다면		
						money[11] += 19800;															//총액에 지정된 값 추가
						t12info[num[11]] = "머쉬룸 치킨 파스타";											//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																	//총 주문갯수 증가
					}
				} else if (e.getSource() == pastaorder[1]) { 										//머쉬룸 씨푸드 파스타가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면	
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "머쉬룸 씨푸드 파스타";											//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면	
						money[1] += 19800;															//총액에 지정된 값 추가								
						t2info[num[1]] = "머쉬룸 씨푸드 파스타";											//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "머쉬룸 씨푸드 파스타";											//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "머쉬룸 씨푸드 파스타";											//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면	
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "머쉬룸 씨푸드 파스타";											//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면	
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "머쉬룸 씨푸드 파스타";											//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면	
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "머쉬룸 씨푸드 파스타";											//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면	
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "머쉬룸 씨푸드 파스타";											//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면	
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "머쉬룸 씨푸드 파스타";											//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면	
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "머쉬룸 씨푸드 파스타";											//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																		//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면	
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "머쉬룸 씨푸드 파스타";											//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면	
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "머쉬룸 씨푸드 파스타";											//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pastaorder[2]) {										//미트 토마토 파스타가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "미트 토마토 파스타";											//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면		
						money[1] += 19800;															//총액에 지정된 값 추가		
						t2info[num[1]] = "미트 토마토 파스타";											//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면	
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "미트 토마토 파스타";											//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면		
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "미트 토마토 파스타";											//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면		
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "미트 토마토 파스타";											//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면	
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "미트 토마토 파스타";											//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면		
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "미트 토마토 파스타";											//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면		
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "미트 토마토 파스타";											//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면		
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "미트 토마토 파스타";											//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면		
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "미트 토마토 파스타";											//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면	
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "미트 토마토 파스타";												//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면	
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "미트 토마토 파스타";												//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pastaorder[3]) {										//까르보나라 파스타가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "까르보나라 파스타";											//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면	
						money[1] += 19800;															//총액에 지정된 값 추가							
						t2info[num[1]] = "까르보나라 파스타";											//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면	
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "까르보나라 파스타";											//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "까르보나라 파스타";											//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면	
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "까르보나라 파스타";											//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "까르보나라 파스타";											//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면	
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "까르보나라 파스타";											//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면	
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "까르보나라 파스타";											//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면	
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "까르보나라 파스타";											//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면	
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "까르보나라 파스타";											//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면	
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "까르보나라 파스타";												//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면	
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "까르보나라 파스타";												//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pastaorder[4]) {										//베이컨 크림 파스타가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "베이컨 크림 파스타";											//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가		
						t2info[num[1]] = "베이컨 크림 파스타";											//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "베이컨 크림 파스타";											//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "베이컨 크림 파스타";											//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "베이컨 크림 파스타";											//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "베이컨 크림 파스타";											//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "베이컨 크림 파스타";											//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "베이컨 크림 파스타";											//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "베이컨 크림 파스타";											//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "베이컨 크림 파스타";											//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "베이컨 크림 파스타";												//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "베이컨 크림 파스타";												//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pastaorder[5]) {										//스퀴드 파스타가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "스퀴드 파스타";												//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가														
						t2info[num[1]] = "스퀴드 파스타";												//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "스퀴드 파스타";												//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "스퀴드 파스타";												//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "스퀴드 파스타";												//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "스퀴드 파스타";												//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "스퀴드 파스타";												//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "스퀴드 파스타";												//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "스퀴드 파스타";												//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "스퀴드 파스타";												//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "스퀴드 파스타";													//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "스퀴드 파스타";													//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}	
				} else if (e.getSource() == pastaorder[6]) {										//스파이시 씨푸드 파스타가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "스파이시 씨푸드 파스타";											//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가															
						t2info[num[1]] = "스파이시 씨푸드 파스타";											//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "스파이시 씨푸드 파스타";											//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "스파이시 씨푸드 파스타";											//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "스파이시 씨푸드 파스타";											//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "스파이시 씨푸드 파스타";											//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "스파이시 씨푸드 파스타";											//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "스파이시 씨푸드 파스타";											//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "스파이시 씨푸드 파스타";											//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "스파이시 씨푸드 파스타";										//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "스파이시 씨푸드 파스타";											//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "스파이시 씨푸드 파스타";											//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pastaorder[7]) {										//씨푸드 토마토 파스타가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "씨푸드 토마토 파스타";											//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가															
						t2info[num[1]] = "씨푸드 토마토 파스타";											//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "씨푸드 토마토 파스타";											//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "씨푸드 토마토 파스타";											//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "씨푸드 토마토 파스타";											//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "씨푸드 토마토 파스타";											//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "씨푸드 토마토 파스타";											//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "씨푸드 토마토 파스타";											//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "씨푸드 토마토 파스타";											//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "씨푸드 토마토 파스타";											//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "씨푸드 토마토 파스타";											//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "씨푸드 토마토 파스타";											//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pastaorder[8]) {										//씨푸드 올리브 파스타가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "씨푸드 올리브 파스타";											//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가														
						t2info[num[1]] = "씨푸드 올리브 파스타";											//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "씨푸드 올리브 파스타";											//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "씨푸드 올리브 파스타";											//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "씨푸드 올리브 파스타";											//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "씨푸드 올리브 파스타";											//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "씨푸드 올리브 파스타";											//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "씨푸드 올리브 파스타";											//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "씨푸드 올리브 파스타";											//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "씨푸드 올리브 파스타";											//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "씨푸드 올리브 파스타";											//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "씨푸드 올리브 파스타";											//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pastaorder[9]) {										//씨푸드 크림 파스타가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "씨푸드 크림 파스타";											//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가														
						t2info[num[1]] = "씨푸드 크림 파스타";											//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "씨푸드 크림 파스타";											//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "씨푸드 크림 파스타";											//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "씨푸드 크림 파스타";											//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "씨푸드 크림 파스타";											//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "씨푸드 크림 파스타";											//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "씨푸드 크림 파스타";											//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "씨푸드 크림 파스타";											//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "씨푸드 크림 파스타";											//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "씨푸드 크림 파스타";												//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "씨푸드 크림 파스타";												//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} 
			}
		}
	}

	class PilafPanel extends JDialog {									//menu중 pilaf menu에 관련된 처리를 하기 위한 class
		PilafPanel() {													//PilafPanel 생성자 호출
			pilafimg pilafimg = new pilafimg();							//pilaf image를 사용하기 위해 pilafimg 생성자 호출
			Scanner sc = null;											//scanner 초기화
			try {
				sc = new Scanner(texts.pilaf(), "UTF-8");      			//pilaf.txt에서 steak panel에 필요한 정보 scan
			} catch (FileNotFoundException e1) {						//FileNotFoundException 예외 처리
				e1.printStackTrace();
			}
			setTitle("Menu - Pilaf");									//title 지정
			getContentPane();											//현재 작동중인 ContentPane 호출
			setLayout(null);											//절대 경로 배치관리자 설정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);												//모달 설정
			
			//pilaf menu를 직관적으로 표현하기 위한 JLabel
			pilaflabel[0] = new JLabel(pilafimg.pilaf1img());
			pilaflabel[1] = new JLabel(pilafimg.pilaf2img());
			pilaflabel[2] = new JLabel(pilafimg.pilaf3img());
			pilaflabel[3] = new JLabel(pilafimg.pilaf4img());
			
			//pilaf menu를 표현하기 위한 JLabel
			pilafname[0] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pilafname[1] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pilafname[2] = new JLabel(sc.nextLine(), JLabel.CENTER);
			pilafname[3] = new JLabel(sc.nextLine(), JLabel.CENTER);
			
			
			for (int i = 0; i < 4; i++) {
				pilaforder[i] = new JButton(images.orderimg());			//주문 요청을 처리하기 위한 JButton
				pilafname[i].setForeground(Color.BLACK);				//pilafname의 색 지정
				//각 ContentPane을 적용
				pilpic.add(pilaflabel[i]);
				pilpic.add(pilafname[i]);
				pilpic.add(pilaforder[i]);
				pilaforder[i].addActionListener(new PilafAction());		//pilaforder에 ActionListener 적용
			}
			
			//pilaflabel boundary 설정
			pilaflabel[0].setBounds(10, 50, 168, 108);
			pilaflabel[1].setBounds(195, 50, 168, 108);
			pilaflabel[2].setBounds(375, 50, 168, 108);
			pilaflabel[3].setBounds(555, 50, 168, 108);

			//pilafname boundary 설정
			pilafname[0].setBounds(10, 160, 175, 20);
			pilafname[1].setBounds(195, 160, 175, 20);
			pilafname[2].setBounds(375, 160, 175, 20);
			pilafname[3].setBounds(555, 160, 175, 20);

			//pilaforder boundary 설정
			pilaforder[0].setBounds(40, 190, 116, 30);
			pilaforder[1].setBounds(220, 190, 116, 30);
			pilaforder[2].setBounds(400, 190, 116, 30);
			pilaforder[3].setBounds(580, 190, 116, 30);
			pilpic.setBounds(0, 0, 750, 690);
			
			add(pilpic);				//pilpic 적용
			setLocation(165, 100);		//위치 지정
			setResizable(false);		//사이즈조절 불가능하게 설정
			setSize(750, 690);			//사이즈 지정
			setVisible(false);			//Visible 대상 변경
		}

		class PilafAction implements ActionListener { 												//주문요청을 처리 하기 위한 class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == pilaforder[0]) {												//김치 필라프가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "김치 필라프";													//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가														
						t2info[num[1]] = "김치 필라프";													//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "김치 필라프";													//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "김치 필라프";													//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "김치 필라프";													//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "김치 필라프";													//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "김치 필라프";													//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "김치 필라프";													//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "김치 필라프";													//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "김치 필라프";												//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "김치 필라프";													//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "김치 필라프";													//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pilaforder[1]) {										//목살 필라프가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "목살 필라프";													//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가
						t2info[num[1]] = "목살 필라프";													//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "목살 필라프";													//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "목살 필라프";													//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "목살 필라프";													//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "목살 필라프";													//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "목살 필라프";													//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "목살 필라프";													//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "목살 필라프";													//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "목살 필라프";												//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "목살 필라프";													//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "목살 필라프";													//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pilaforder[2]) {										//베이컨 필라프가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "베이컨 필라프";												//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가									
						t2info[num[1]] = "베이컨 필라프";												//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "베이컨 필라프";												//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "베이컨 필라프";												//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "베이컨 필라프";												//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "베이컨 필라프";												//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "베이컨 필라프";												//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "베이컨 필라프";												//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "베이컨 필라프";												//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "베이컨 필라프";												//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "베이컨 필라프";													//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "베이컨 필라프";													//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pilaforder[3]) {										//새우 필라프가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "새우 필라프";													//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가															
						t2info[num[1]] = "새우 필라프";													//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "새우 필라프";													//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "새우 필라프";													//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "새우 필라프";													//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "새우 필라프";													//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "새우 필라프";													//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "새우 필라프";													//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "새우 필라프";													//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "새우 필라프";												//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "새우 필라프";													//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "새우 필라프";													//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				}
			}
		}
	}

	class PizzaPanel extends JDialog {								//menu중 pizza menu에 관련된 처리를 하기 위한 class
		PizzaPanel() {												//PizzaPanel 생성자
			pizzaimg pizzaimg = new pizzaimg();						//pizza image를 사용하기 위해 pizzaimg 생성자 호출
			Scanner sc = null;										//scanner 초기화
			try {
				sc = new Scanner(texts.pizza(), "UTF-8");      		//pizza.txt에서 pizza panel에 필요한 정보 scan
			} catch (FileNotFoundException e1) {					//FileNotFoundException 예외 처리
				e1.printStackTrace();
			}
			
			setTitle("Menu - Pizza");								//title 지정
			getContentPane();										//현재 작동중인 ContentPane 호출
			setLayout(null);										//절대 경로 배치관리자 설정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);											//모달 설정
			
			//pizza menu를 직관적으로 표현하기 위한 JLabel
			pizzalabel[0] = new JLabel(pizzaimg.pizza1img());
			pizzalabel[1] = new JLabel(pizzaimg.pizza2img());
			pizzalabel[2] = new JLabel(pizzaimg.pizza3img());
			pizzalabel[3] = new JLabel(pizzaimg.pizza4img());
			pizzalabel[4] = new JLabel(pizzaimg.pizza5img());
			pizzalabel[5] = new JLabel(pizzaimg.pizza6img());
			pizzalabel[6] = new JLabel(pizzaimg.pizza7img());
			pizzalabel[7] = new JLabel(pizzaimg.pizza8img());
			pizzalabel[8] = new JLabel(pizzaimg.pizza9img());

			//pizza menu를 표현하기 위한 JLabel
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
				pizzaorder[i] = new JButton(images.orderimg());			//주문 요청을 처리하기 위한 JButton
				pizzaname[i].setForeground(Color.BLACK);				//pizzaname의 색 지정
				pizzaorder[i].addActionListener(new PizzaAction());		//pizzaorder에 ActionListener 적용
				//각 ContentPane을 적용
				pizpic.add(pizzalabel[i]);
				pizpic.add(pizzaname[i]);
				pizpic.add(pizzaorder[i]);
			}

			//pizzalabel boundary 설정
			pizzalabel[0].setBounds(10, 50, 196, 126);
			pizzalabel[1].setBounds(260, 50, 196, 126);
			pizzalabel[2].setBounds(510, 50, 196, 126);
			pizzalabel[3].setBounds(10, 260, 196, 126);
			pizzalabel[4].setBounds(260, 260, 196, 126);
			pizzalabel[5].setBounds(510, 260, 196, 126);
			pizzalabel[6].setBounds(10, 470, 196, 126);
			pizzalabel[7].setBounds(260, 470, 196, 126);
			pizzalabel[8].setBounds(510, 470, 196, 126);

			//pizzaname boundary 설정
			pizzaname[0].setBounds(10, 190, 196, 20);
			pizzaname[1].setBounds(260, 190, 196, 20);
			pizzaname[2].setBounds(510, 190, 196, 20);
			pizzaname[3].setBounds(10, 400, 196, 20);
			pizzaname[4].setBounds(260, 400, 196, 20);
			pizzaname[5].setBounds(510, 400, 196, 20);
			pizzaname[6].setBounds(10, 610, 196, 20);
			pizzaname[7].setBounds(260, 610, 196, 20);
			pizzaname[8].setBounds(510, 610, 196, 20);

			//pizzaorder boundary 설정
			pizzaorder[0].setBounds(50, 212, 116, 35);
			pizzaorder[1].setBounds(300, 212, 116, 35);
			pizzaorder[2].setBounds(550, 212, 116, 35);
			pizzaorder[3].setBounds(50, 422, 116, 35);
			pizzaorder[4].setBounds(300, 422, 116, 35);
			pizzaorder[5].setBounds(550, 422, 116, 35);
			pizzaorder[6].setBounds(50, 632, 116, 35);
			pizzaorder[7].setBounds(300, 632, 116, 35);
			pizzaorder[8].setBounds(550, 632, 116, 35);
			pizpic.setBounds(0, 0, 750, 690);			//pizpic boundary 설정
			
			add(pizpic);				//pizpic 적용
			setSize(750, 750);			//사이즈 지정
			setLocation(165, 100);		//위치 지정
			setResizable(false);		//사이즈조절 불가능하게 설정
			setVisible(false);			//Visible 대상 변경
		}

		class PizzaAction implements ActionListener { 												//주문요청을 처리 하기 위한 class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == pizzaorder[0]) {												//고르곤졸라 피자를 선택했을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 9800;															//총액에 지정된 값 추가
						t1info[num[0]] = "고르곤졸라 피자";												//지정된 메뉴 추가
						t1price[num[0]] = " 9.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 9800;															//총액에 지정된 값 추가
						t2info[num[1]] = "고르곤졸라 피자";												//지정된 메뉴 추가
						t2price[num[1]] = " 9.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 9800;															//총액에 지정된 값 추가
						t3info[num[2]] = "고르곤졸라 피자";												//지정된 메뉴 추가
						t3price[num[2]] = " 9.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 9800;															//총액에 지정된 값 추가
						t4info[num[3]] = "고르곤졸라 피자";												//지정된 메뉴 추가
						t4price[num[3]] = " 9.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 9800;															//총액에 지정된 값 추가
						t5info[num[4]] = "고르곤졸라 피자";												//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 9800;															//총액에 지정된 값 추가
						t6info[num[5]] = "고르곤졸라 피자";												//지정된 메뉴 추가
						t6price[num[5]] = " 9.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 9800;															//총액에 지정된 값 추가
						t7info[num[6]] = "고르곤졸라 피자";												//지정된 메뉴 추가
						t7price[num[6]] = " 9.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 9800;															//총액에 지정된 값 추가
						t8info[num[7]] = "고르곤졸라 피자";												//지정된 메뉴 추가
						t8price[num[7]] = " 9.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 9800;															//총액에 지정된 값 추가
						t9info[num[8]] = "고르곤졸라 피자";												//지정된 메뉴 추가
						t9price[num[8]] = " 9.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 9800;															//총액에 지정된 값 추가
						t10info[num[9]] = "고르곤졸라 피자";												//지정된 메뉴 추가
						t10price[num[9]] = " 9.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 9800;																//총액에 지정된 값 추가
						t11info[num[10]] = "고르곤졸라 피자";												//지정된 메뉴 추가
						t11price[num[10]] = " 9.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 9800;																//총액에 지정된 값 추가
						t12info[num[11]] = "고르곤졸라 피자";												//지정된 메뉴 추가
						t12price[num[11]] = " 9.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pizzaorder[1]) {										//달콤감자 피자를 선택했을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "달콤감자 피자";												//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가														
						t2info[num[1]] = "달콤감자 피자";												//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "달콤감자 피자";												//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "달콤감자 피자";												//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "달콤감자 피자";												//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "달콤감자 피자";												//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "달콤감자 피자";												//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "달콤감자 피자";												//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "달콤감자 피자";												//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "달콤감자 피자";												//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "달콤감자 피자";													//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "달콤감자 피자";													//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pizzaorder[2]) {										//더블미트 피자가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 14800;															//총액에 지정된 값 추가
						t1info[num[0]] = "더블미트 피자";												//지정된 메뉴 추가
						t1price[num[0]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 14800;															//총액에 지정된 값 추가
						t2info[num[1]] = "더블미트 피자";												//지정된 메뉴 추가
						t2price[num[1]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 14800;															//총액에 지정된 값 추가
						t3info[num[2]] = "더블미트 피자";												//지정된 메뉴 추가
						t3price[num[2]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 14800;															//총액에 지정된 값 추가
						t4info[num[3]] = "더블미트 피자";												//지정된 메뉴 추가
						t4price[num[3]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 14800;															//총액에 지정된 값 추가
						t5info[num[4]] = "더블미트 피자";												//지정된 메뉴 추가
						t5price[num[4]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 14800;															//총액에 지정된 값 추가
						t6info[num[5]] = "더블미트 피자";												//지정된 메뉴 추가
						t6price[num[5]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 14800;															//총액에 지정된 값 추가
						t7info[num[6]] = "더블미트 피자";												//지정된 메뉴 추가
						t7price[num[6]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 14800;															//총액에 지정된 값 추가
						t8info[num[7]] = "더블미트 피자";												//지정된 메뉴 추가
						t8price[num[7]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 14800;															//총액에 지정된 값 추가
						t9info[num[8]] = "더블미트 피자";												//지정된 메뉴 추가
						t9price[num[8]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 14800;															//총액에 지정된 값 추가
						t10info[num[9]] = "더블미트 피자";												//지정된 메뉴 추가
						t10price[num[9]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 14800;																//총액에 지정된 값 추가
						t11info[num[10]] = "더블미트 피자";													//지정된 메뉴 추가
						t11price[num[10]] = " 14.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 14800;																//총액에 지정된 값 추가
						t12info[num[11]] = "더블미트 피자";													//지정된 메뉴 추가
						t12price[num[11]] = " 14.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pizzaorder[3]) {										//더블포테이토 피자가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 14800;															//총액에 지정된 값 추가
						t1info[num[0]] = "더블포테이토 피자";											//지정된 메뉴 추가
						t1price[num[0]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 14800;															//총액에 지정된 값 추가
						t2info[num[1]] = "더블포테이토 피자";											//지정된 메뉴 추가
						t2price[num[1]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 14800;															//총액에 지정된 값 추가
						t3info[num[2]] = "더블포테이토 피자";											//지정된 메뉴 추가
						t3price[num[2]] = " 14.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 14800;															//총액에 지정된 값 추가
						t4info[num[3]] = "더블포테이토 피자";											//지정된 메뉴 추가
						t4price[num[3]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 14800;															//총액에 지정된 값 추가
						t5info[num[4]] = "더블포테이토 피자";											//지정된 메뉴 추가
						t5price[num[4]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 14800;															//총액에 지정된 값 추가
						t6info[num[5]] = "더블포테이토 피자";											//지정된 메뉴 추가
						t6price[num[5]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 14800;															//총액에 지정된 값 추가
						t7info[num[6]] = "더블포테이토 피자";											//지정된 메뉴 추가
						t7price[num[6]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 14800;															//총액에 지정된 값 추가
						t8info[num[7]] = "더블포테이토 피자";											//지정된 메뉴 추가
						t8price[num[7]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 14800;															//총액에 지정된 값 추가
						t9info[num[8]] = "더블포테이토 피자";											//지정된 메뉴 추가
						t9price[num[8]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 14800;															//총액에 지정된 값 추가
						t10info[num[9]] = "더블포테이토 피자";											//지정된 메뉴 추가
						t10price[num[9]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 14800;																//총액에 지정된 값 추가
						t11info[num[10]] = "더블포테이토 피자";												//지정된 메뉴 추가
						t11price[num[10]] = " 14.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 14800;																//총액에 지정된 값 추가
						t12info[num[11]] = "더블포테이토 피자";												//지정된 메뉴 추가
						t12price[num[11]] = " 14.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pizzaorder[4]) {										//불고구마 피자가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "불고구마 피자";												//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가	
						t2info[num[1]] = "불고구마 피자";												//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "불고구마 피자";												//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "불고구마 피자";												//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "불고구마 피자";												//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "불고구마 피자";												//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "불고구마 피자";												//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "불고구마 피자";												//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "불고구마 피자";												//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "불고구마 피자";												//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "불고구마 피자";													//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "불고구마 피자";													//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pizzaorder[5]) {										//스테이크샐러드 피자가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 14800;															//총액에 지정된 값 추가
						t1info[num[0]] = "스테이크샐러드 피자";											//지정된 메뉴 추가
						t1price[num[0]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 14800;															//총액에 지정된 값 추가
						t2info[num[1]] = "스테이크샐러드 피자";											//지정된 메뉴 추가
						t2price[num[1]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 14800;															//총액에 지정된 값 추가
						t3info[num[2]] = "스테이크샐러드 피자";											//지정된 메뉴 추가
						t3price[num[2]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 14800;															//총액에 지정된 값 추가
						t4info[num[3]] = "스테이크샐러드 피자";											//지정된 메뉴 추가
						t4price[num[3]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 14800;															//총액에 지정된 값 추가
						t5info[num[4]] = "스테이크샐러드 피자";											//지정된 메뉴 추가
						t5price[num[4]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 14800;															//총액에 지정된 값 추가
						t6info[num[5]] = "스테이크샐러드 피자";											//지정된 메뉴 추가
						t6price[num[5]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 14800;															//총액에 지정된 값 추가
						t7info[num[6]] = "스테이크샐러드 피자";											//지정된 메뉴 추가
						t7price[num[6]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 14800;															//총액에 지정된 값 추가
						t8info[num[7]] = "스테이크샐러드 피자";											//지정된 메뉴 추가
						t8price[num[7]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 14800;															//총액에 지정된 값 추가
						t9info[num[8]] = "스테이크샐러드 피자";											//지정된 메뉴 추가
						t9price[num[8]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 14800;															//총액에 지정된 값 추가
						t10info[num[9]] = "스테이크샐러드 피자";											//지정된 메뉴 추가
						t10price[num[9]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 14800;																//총액에 지정된 값 추가
						t11info[num[10]] = "스테이크샐러드 피자";												//지정된 메뉴 추가
						t11price[num[10]] = " 14.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 14800;																//총액에 지정된 값 추가
						t12info[num[11]] = "스테이크샐러드 피자";												//지정된 메뉴 추가
						t12price[num[11]] = " 14.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pizzaorder[6]) {										//스텔라 피자가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 13800;															//총액에 지정된 값 추가
						t1info[num[0]] = "스텔라 피자";													//지정된 메뉴 추가
						t1price[num[0]] = " 13.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 13800;															//총액에 지정된 값 추가
						t2info[num[1]] = "스텔라 피자";													//지정된 메뉴 추가
						t2price[num[1]] = " 13.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 13800;															//총액에 지정된 값 추가
						t3info[num[2]] = "스텔라 피자";													//지정된 메뉴 추가
						t3price[num[2]] = " 13.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 13800;															//총액에 지정된 값 추가
						t4info[num[3]] = "스텔라 피자";													//지정된 메뉴 추가
						t4price[num[3]] = " 13.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 13800;															//총액에 지정된 값 추가
						t5info[num[4]] = "스텔라 피자";													//지정된 메뉴 추가
						t5price[num[4]] = " 13.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 13800;															//총액에 지정된 값 추가
						t6info[num[5]] = "스텔라 피자";													//지정된 메뉴 추가
						t6price[num[5]] = " 13.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 13800;															//총액에 지정된 값 추가
						t7info[num[6]] = "스텔라 피자";													//지정된 메뉴 추가
						t7price[num[6]] = " 13.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 13800;															//총액에 지정된 값 추가
						t8info[num[7]] = "스텔라 피자";													//지정된 메뉴 추가
						t8price[num[7]] = " 13.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 13800;															//총액에 지정된 값 추가
						t9info[num[8]] = "스텔라 피자";													//지정된 메뉴 추가
						t9price[num[8]] = " 13.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 13800;															//총액에 지정된 값 추가
						t10info[num[9]] = "스텔라 피자";												//지정된 메뉴 추가
						t10price[num[9]] = " 13.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 13800;																//총액에 지정된 값 추가
						t11info[num[10]] = "스텔라 피자";													//지정된 메뉴 추가
						t11price[num[10]] = " 13.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 13800;																//총액에 지정된 값 추가
						t12info[num[11]] = "스텔라 피자";													//지정된 메뉴 추가
						t12price[num[11]] = " 13.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pizzaorder[7]) {										//애플시나몬 피자가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 14800;															//총액에 지정된 값 추가
						t1info[num[0]] = "애플시나몬 피자";												//지정된 메뉴 추가
						t1price[num[0]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 14800;															//총액에 지정된 값 추가
						t2info[num[1]] = "애플시나몬 피자";												//지정된 메뉴 추가
						t2price[num[1]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 14800;															//총액에 지정된 값 추가
						t3info[num[2]] = "애플시나몬 피자";												//지정된 메뉴 추가
						t3price[num[2]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 14800;															//총액에 지정된 값 추가
						t4info[num[3]] = "애플시나몬 피자";												//지정된 메뉴 추가
						t4price[num[3]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 14800;															//총액에 지정된 값 추가
						t5info[num[4]] = "애플시나몬 피자";												//지정된 메뉴 추가
						t5price[num[4]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 14800;															//총액에 지정된 값 추가
						t6info[num[5]] = "애플시나몬 피자";												//지정된 메뉴 추가
						t6price[num[5]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 14800;															//총액에 지정된 값 추가
						t7info[num[6]] = "애플시나몬 피자";												//지정된 메뉴 추가
						t7price[num[6]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 14800;															//총액에 지정된 값 추가
						t8info[num[7]] = "애플시나몬 피자";												//지정된 메뉴 추가
						t8price[num[7]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 14800;															//총액에 지정된 값 추가
						t9info[num[8]] = "애플시나몬 피자";												//지정된 메뉴 추가
						t9price[num[8]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 14800;															//총액에 지정된 값 추가
						t10info[num[9]] = "애플시나몬 피자";												//지정된 메뉴 추가
						t10price[num[9]] = " 14.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 14800;																//총액에 지정된 값 추가
						t11info[num[10]] = "애플시나몬 피자";												//지정된 메뉴 추가
						t11price[num[10]] = " 14.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 14800;																//총액에 지정된 값 추가
						t12info[num[11]] = "애플시나몬 피자";												//지정된 메뉴 추가
						t12price[num[11]] = " 14.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == pizzaorder[8]) {										//토마토미트 피자가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 19800;															//총액에 지정된 값 추가
						t1info[num[0]] = "토마토미트 피자";												//지정된 메뉴 추가
						t1price[num[0]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 19800;															//총액에 지정된 값 추가															
						t2info[num[1]] = "토마토미트 피자";												//지정된 메뉴 추가
						t2price[num[1]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 19800;															//총액에 지정된 값 추가
						t3info[num[2]] = "토마토미트 피자";												//지정된 메뉴 추가
						t3price[num[2]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 19800;															//총액에 지정된 값 추가
						t4info[num[3]] = "토마토미트 피자";												//지정된 메뉴 추가
						t4price[num[3]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 19800;															//총액에 지정된 값 추가
						t5info[num[4]] = "토마토미트 피자";												//지정된 메뉴 추가
						t5price[num[4]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 19800;															//총액에 지정된 값 추가
						t6info[num[5]] = "토마토미트 피자";												//지정된 메뉴 추가
						t6price[num[5]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 19800;															//총액에 지정된 값 추가
						t7info[num[6]] = "토마토미트 피자";												//지정된 메뉴 추가
						t7price[num[6]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 19800;															//총액에 지정된 값 추가
						t8info[num[7]] = "토마토미트 피자";												//지정된 메뉴 추가
						t8price[num[7]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 19800;															//총액에 지정된 값 추가
						t9info[num[8]] = "토마토미트 피자";												//지정된 메뉴 추가
						t9price[num[8]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 19800;															//총액에 지정된 값 추가
						t10info[num[9]] = "토마토미트 피자";												//지정된 메뉴 추가
						t10price[num[9]] = " 19.800";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 19800;																//총액에 지정된 값 추가
						t11info[num[10]] = "토마토미트 피자";												//지정된 메뉴 추가
						t11price[num[10]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 19800;																//총액에 지정된 값 추가
						t12info[num[11]] = "토마토미트 피자";												//지정된 메뉴 추가
						t12price[num[11]] = " 19.800";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				}
			}
		}
	}

	class SidePanel extends JDialog {									//menu중 sidedish menu에 관련된 처리를 하기 위한 class
		SidePanel() {													//SidePanel 생성자 
			sidedishimg sidedishimg = new sidedishimg();				//sidedish image를 사용하기 위해 sidedishimg 생성자 호출
			Scanner sc = null;											//scanner 초기화
			try {
				sc = new Scanner(texts.sidedish(), "UTF-8");      		//sidedish.txt에서 steak panel에 필요한 정보 scan
			} catch (FileNotFoundException e1) {						//FileNotFoundException 예외 처리
				e1.printStackTrace();
			}
			
			setTitle("Menu - Sidedish");								//title 지정
			getContentPane();											//현재 작동중인 ContentPane 호출
			setLayout(null);											//절대 경로 배치관리자 설정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);												//모달 설정
			
			//sidedish menu를 직관적으로 표현하기 위한 JLabel
			sidelabel[0] = new JLabel(sidedishimg.sidedish1img());
			sidelabel[1] = new JLabel(sidedishimg.sidedish2img());
			sidelabel[2] = new JLabel(sidedishimg.sidedish3img());
			sidelabel[3] = new JLabel(sidedishimg.sidedish4img());
			sidelabel[4] = new JLabel(sidedishimg.sidedish5img());
			sidelabel[5] = new JLabel(sidedishimg.sidedish6img());

			//sidedish menu를 표현하기 위한 JLabel
			sidename[0] = new JLabel(sc.nextLine(), JLabel.CENTER);
			sidename[1] = new JLabel(sc.nextLine(), JLabel.CENTER);
			sidename[2] = new JLabel(sc.nextLine(), JLabel.CENTER);
			sidename[3] = new JLabel(sc.nextLine(), JLabel.CENTER);
			sidename[4] = new JLabel(sc.nextLine(), JLabel.CENTER);
			sidename[5] = new JLabel(sc.nextLine(), JLabel.CENTER);

			for (int i = 0; i < 6; i++) {
				sideorder[i] = new JButton(images.orderimg());			//주문 요청을 처리하기 위한 JButton
				sidename[i].setForeground(Color.BLACK);					//sidename의 색 지정
				sideorder[i].addActionListener(new SideAction());		//sideorder에 ActionListener 적용
				//각 ContentPane을 적용
				sidepic.add(sidelabel[i]);
				sidepic.add(sidename[i]);
				sidepic.add(sideorder[i]);
			}

			//sidelabel boundary 설정
			sidelabel[0].setBounds(10, 50, 196, 126);
			sidelabel[1].setBounds(260, 50, 196, 126);
			sidelabel[2].setBounds(510, 50, 196, 126);
			sidelabel[3].setBounds(10, 260, 196, 126);
			sidelabel[4].setBounds(260, 260, 196, 126);
			sidelabel[5].setBounds(510, 260, 196, 126);

			//sidename boundary 설정
			sidename[0].setBounds(10, 190, 196, 20);
			sidename[1].setBounds(260, 190, 196, 20);
			sidename[2].setBounds(510, 190, 196, 20);
			sidename[3].setBounds(10, 400, 196, 20);
			sidename[4].setBounds(260, 400, 196, 20);
			sidename[5].setBounds(510, 400, 196, 20);

			//sideorder boundary 설정
			sideorder[0].setBounds(50, 212, 116, 35);
			sideorder[1].setBounds(300, 212, 116, 35);
			sideorder[2].setBounds(550, 212, 116, 35);
			sideorder[3].setBounds(50, 422, 116, 35);
			sideorder[4].setBounds(300, 422, 116, 35);
			sideorder[5].setBounds(550, 422, 116, 35);
			sidepic.setBounds(0, 0, 750, 690);			//sidepic boundary 설정
			
			add(sidepic);			//sidepic 적용
			setSize(750, 690);		//사이즈 지정	
			setResizable(false);	//사이즈조절 불가능하게 설정
			setLocation(165, 100);	//위치 지정
			setVisible(false);		//Visible 대상 변경
		}

		class SideAction implements ActionListener { 												//주문요청을 처리 하기 위한 class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == sideorder[0]) {												//갈릭 브레드가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 1000;															//총액에 지정된 값 추가
						t1info[num[0]] = "갈릭 브레드";													//지정된 메뉴 추가
						t1price[num[0]] = " 1.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 1000;															//총액에 지정된 값 추가
						t2info[num[1]] = "갈릭 브레드";													//지정된 메뉴 추가
						t2price[num[1]] = " 1.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 1000;															//총액에 지정된 값 추가
						t3info[num[2]] = "갈릭 브레드";													//지정된 메뉴 추가
						t3price[num[2]] = " 1.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 1000;															//총액에 지정된 값 추가
						t4info[num[3]] = "갈릭 브레드";													//지정된 메뉴 추가
						t4price[num[3]] = " 1.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 1000;															//총액에 지정된 값 추가
						t5info[num[4]] = "갈릭 브레드";													//지정된 메뉴 추가
						t5price[num[4]] = " 1.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 1000;															//총액에 지정된 값 추가
						t6info[num[5]] = "갈릭 브레드";													//지정된 메뉴 추가
						t6price[num[5]] = " 1.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 1000;															//총액에 지정된 값 추가
						t7info[num[6]] = "갈릭 브레드";													//지정된 메뉴 추가
						t7price[num[6]] = " 1.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 1000;															//총액에 지정된 값 추가
						t8info[num[7]] = "갈릭 브레드";													//지정된 메뉴 추가
						t8price[num[7]] = " 1.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 1000;															//총액에 지정된 값 추가
						t9info[num[8]] = "갈릭 브레드";													//지정된 메뉴 추가
						t9price[num[8]] = " 1.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 1000;															//총액에 지정된 값 추가
						t10info[num[9]] = "갈릭 브레드";												//지정된 메뉴 추가
						t10price[num[9]] = " 1.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 1000;																//총액에 지정된 값 추가
						t11info[num[10]] = "갈릭 브레드";													//지정된 메뉴 추가
						t11price[num[10]] = " 1.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 1000;																//총액에 지정된 값 추가
						t12info[num[11]] = "갈릭 브레드";													//지정된 메뉴 추가
						t12price[num[11]] = " 1.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == sideorder[1]) {											//리코타그린 샐러드가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 12000;															//총액에 지정된 값 추가
						t1info[num[0]] = "리코타그린 샐러드";											//지정된 메뉴 추가
						t1price[num[0]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 12000;															//총액에 지정된 값 추가
						t2info[num[1]] = "리코타그린 샐러드";											//지정된 메뉴 추가
						t2price[num[1]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 12000;															//총액에 지정된 값 추가
						t3info[num[2]] = "리코타그린 샐러드";											//지정된 메뉴 추가
						t3price[num[2]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 12000;															//총액에 지정된 값 추가
						t4info[num[3]] = "리코타그린 샐러드";											//지정된 메뉴 추가
						t4price[num[3]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 12000;															//총액에 지정된 값 추가
						t5info[num[4]] = "리코타그린 샐러드";											//지정된 메뉴 추가
						t5price[num[4]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 12000;															//총액에 지정된 값 추가
						t6info[num[5]] = "리코타그린 샐러드";											//지정된 메뉴 추가
						t6price[num[5]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 12000;															//총액에 지정된 값 추가
						t7info[num[6]] = "리코타그린 샐러드";											//지정된 메뉴 추가
						t7price[num[6]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 12000;															//총액에 지정된 값 추가
						t8info[num[7]] = "리코타그린 샐러드";											//지정된 메뉴 추가
						t8price[num[7]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 12000;															//총액에 지정된 값 추가
						t9info[num[8]] = "리코타그린 샐러드";											//지정된 메뉴 추가
						t9price[num[8]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 12000;															//총액에 지정된 값 추가
						t10info[num[9]] = "리코타그린 샐러드";											//지정된 메뉴 추가
						t10price[num[9]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 12000;																//총액에 지정된 값 추가
						t11info[num[10]] = "리코타그린 샐러드";												//지정된 메뉴 추가
						t11price[num[10]] = " 12.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 12000;																//총액에 지정된 값 추가
						t12info[num[11]] = "리코타그린 샐러드";												//지정된 메뉴 추가
						t12price[num[11]] = " 12.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == sideorder[2]) {											//연어 샐러드가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 12000;															//총액에 지정된 값 추가
						t1info[num[0]] = "연어 샐러드";													//지정된 메뉴 추가
						t1price[num[0]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 12000;															//총액에 지정된 값 추가
						t2info[num[1]] = "연어 샐러드";													//지정된 메뉴 추가
						t2price[num[1]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 12000;															//총액에 지정된 값 추가
						t3info[num[2]] = "연어 샐러드";													//지정된 메뉴 추가
						t3price[num[2]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 12000;															//총액에 지정된 값 추가
						t4info[num[3]] = "연어 샐러드";													//지정된 메뉴 추가
						t4price[num[3]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 12000;															//총액에 지정된 값 추가
						t5info[num[4]] = "연어 샐러드";													//지정된 메뉴 추가
						t5price[num[4]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 12000;															//총액에 지정된 값 추가
						t6info[num[5]] = "연어 샐러드";													//지정된 메뉴 추가
						t6price[num[5]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 12000;															//총액에 지정된 값 추가
						t7info[num[6]] = "연어 샐러드";													//지정된 메뉴 추가
						t7price[num[6]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 12000;															//총액에 지정된 값 추가
						t8info[num[7]] = "연어 샐러드";													//지정된 메뉴 추가
						t8price[num[7]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 12000;															//총액에 지정된 값 추가
						t9info[num[8]] = "연어 샐러드";													//지정된 메뉴 추가
						t9price[num[8]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 12000;															//총액에 지정된 값 추가
						t10info[num[9]] = "연어 샐러드";												//지정된 메뉴 추가
						t10price[num[9]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 12000;																//총액에 지정된 값 추가
						t11info[num[10]] = "연어 샐러드";													//지정된 메뉴 추가
						t11price[num[10]] = " 12.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 12000;																//총액에 지정된 값 추가
						t12info[num[11]] = "연어 샐러드";													//지정된 메뉴 추가
						t12price[num[11]] = " 12.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == sideorder[3]) {											//치킨텐더 샐러드가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 12000;															//총액에 지정된 값 추가
						t1info[num[0]] = "치킨텐더 샐러드";												//지정된 메뉴 추가
						t1price[num[0]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 12000;															//총액에 지정된 값 추가
						t2info[num[1]] = "치킨텐더 샐러드";												//지정된 메뉴 추가
						t2price[num[1]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 12000;															//총액에 지정된 값 추가
						t3info[num[2]] = "치킨텐더 샐러드";												//지정된 메뉴 추가
						t3price[num[2]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 12000;															//총액에 지정된 값 추가
						t4info[num[3]] = "치킨텐더 샐러드";												//지정된 메뉴 추가
						t4price[num[3]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 12000;															//총액에 지정된 값 추가
						t5info[num[4]] = "치킨텐더 샐러드";												//지정된 메뉴 추가
						t5price[num[4]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 12000;															//총액에 지정된 값 추가
						t6info[num[5]] = "치킨텐더 샐러드";												//지정된 메뉴 추가
						t6price[num[5]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 12000;															//총액에 지정된 값 추가
						t7info[num[6]] = "치킨텐더 샐러드";												//지정된 메뉴 추가
						t7price[num[6]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 12000;															//총액에 지정된 값 추가
						t8info[num[7]] = "치킨텐더 샐러드";												//지정된 메뉴 추가
						t8price[num[7]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 12000;															//총액에 지정된 값 추가
						t9info[num[8]] = "치킨텐더 샐러드";												//지정된 메뉴 추가
						t9price[num[8]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 12000;															//총액에 지정된 값 추가
						t10info[num[9]] = "치킨텐더 샐러드";												//지정된 메뉴 추가
						t10price[num[9]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 12000;																//총액에 지정된 값 추가
						t11info[num[10]] = "치킨텐더 샐러드";												//지정된 메뉴 추가
						t11price[num[10]] = " 12.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 12000;																//총액에 지정된 값 추가
						t12info[num[11]] = "치킨텐더 샐러드";												//지정된 메뉴 추가
						t12price[num[11]] = " 12.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == sideorder[4]) {											//칠리피즈 프라이가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 12000;															//총액에 지정된 값 추가
						t1info[num[0]] = "칠리피즈 프라이";												//지정된 메뉴 추가
						t1price[num[0]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 12000;															//총액에 지정된 값 추가
						t2info[num[1]] = "칠리피즈 프라이";												//지정된 메뉴 추가
						t2price[num[1]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 12000;															//총액에 지정된 값 추가
						t3info[num[2]] = "칠리피즈 프라이";												//지정된 메뉴 추가
						t3price[num[2]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 12000;															//총액에 지정된 값 추가
						t4info[num[3]] = "칠리피즈 프라이";												//지정된 메뉴 추가
						t4price[num[3]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 12000;															//총액에 지정된 값 추가
						t5info[num[4]] = "칠리피즈 프라이";												//지정된 메뉴 추가
						t5price[num[4]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 12000;															//총액에 지정된 값 추가
						t6info[num[5]] = "칠리피즈 프라이";												//지정된 메뉴 추가
						t6price[num[5]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 12000;															//총액에 지정된 값 추가
						t7info[num[6]] = "칠리피즈 프라이";												//지정된 메뉴 추가
						t7price[num[6]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 12000;															//총액에 지정된 값 추가
						t8info[num[7]] = "칠리피즈 프라이";												//지정된 메뉴 추가
						t8price[num[7]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 12000;															//총액에 지정된 값 추가
						t9info[num[8]] = "칠리피즈 프라이";												//지정된 메뉴 추가
						t9price[num[8]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 12000;															//총액에 지정된 값 추가
						t10info[num[9]] = "칠리피즈 프라이";												//지정된 메뉴 추가
						t10price[num[9]] = " 12.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 12000;																//총액에 지정된 값 추가
						t11info[num[10]] = "칠리피즈 프라이";												//지정된 메뉴 추가
						t11price[num[10]] = " 12.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 12000;																//총액에 지정된 값 추가
						t12info[num[11]] = "칠리피즈 프라이";												//지정된 메뉴 추가
						t12price[num[11]] = " 12.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == sideorder[5]) {											//프렌치 프라이가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 4000;															//총액에 지정된 값 추가
						t1info[num[0]] = "프렌치 프라이";												//지정된 메뉴 추가
						t1price[num[0]] = " 4.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 4000;															//총액에 지정된 값 추가
						t2info[num[1]] = "프렌치 프라이";												//지정된 메뉴 추가
						t2price[num[1]] = " 4.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 4000;															//총액에 지정된 값 추가
						t3info[num[2]] = "프렌치 프라이";												//지정된 메뉴 추가
						t3price[num[2]] = " 4.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 4000;															//총액에 지정된 값 추가
						t4info[num[3]] = "프렌치 프라이";												//지정된 메뉴 추가
						t4price[num[3]] = " 4.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 4000;															//총액에 지정된 값 추가
						t5info[num[4]] = "프렌치 프라이";												//지정된 메뉴 추가
						t5price[num[4]] = " 4.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 4000;															//총액에 지정된 값 추가
						t6info[num[5]] = "프렌치 프라이";												//지정된 메뉴 추가
						t6price[num[5]] = " 4.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 4000;															//총액에 지정된 값 추가
						t7info[num[6]] = "프렌치 프라이";												//지정된 메뉴 추가
						t7price[num[6]] = " 4.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 4000;															//총액에 지정된 값 추가
						t8info[num[7]] = "프렌치 프라이";												//지정된 메뉴 추가
						t8price[num[7]] = " 4.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 4000;															//총액에 지정된 값 추가
						t9info[num[8]] = "프렌치 프라이";												//지정된 메뉴 추가
						t9price[num[8]] = " 4.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 4000;															//총액에 지정된 값 추가
						t10info[num[9]] = "프렌치 프라이";												//지정된 메뉴 추가
						t10price[num[9]] = " 4.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 4000;																//총액에 지정된 값 추가
						t11info[num[10]] = "프렌치 프라이";													//지정된 메뉴 추가
						t11price[num[10]] = " 4.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 4000;																//총액에 지정된 값 추가
						t12info[num[11]] = "프렌치 프라이";													//지정된 메뉴 추가
						t12price[num[11]] = " 4.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				}
			}
		}
	}

	class DrinkPanel extends JDialog {									//menu중 beverage menu에 관련된 처리를 하기 위한 class
		DrinkPanel() {													//DrinkPanel 생성자 호출
			beverageimg beverageimg = new beverageimg();				//beverage image를 사용하기 위해 beverageimg 생성자 호출
			Scanner sc = null;											//scanner 초기화
			try {
				sc = new Scanner(texts.beverage(), "UTF-8");      		//beverage.txt에서 drink panel에 필요한 정보 scan
			} catch (FileNotFoundException e1) {						//FileNotFoundException 예외 처리
				e1.printStackTrace();
			}
			
			setTitle("Menu - Beverage");								//title 설정
			getContentPane();											//현재 작동중인 ContentPane 호출
			setLayout(null);											//절대 경로 배치관리자 설정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);												//모달 설정
			
			//beverage menu를 직관적으로 표현하기 위한 JLabel
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
			
			//beverage menu를 표현하기 위한 JLabel
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
				drinkorder[i] = new JButton(images.orderimg());			//주문 요청을 처리하기 위한 JButton
				drinkname[i].setForeground(Color.BLACK);				//drinkname의 색 지정
				drinkorder[i].addActionListener(new DrinkAction());		//drinkorder에 ActionListener 적용
				//각 ContentPane을 적용
				drinkpic.add(drinklabel[i]);	
				drinkpic.add(drinkname[i]);
				drinkpic.add(drinkorder[i]);
			}

			//drinklabel boundary 설정
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

			//drinkname boundary 설정
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

			//drinkorder boundary 설정
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
			drinkpic.setBounds(0, 0, 750, 690);				//drinkpic boundary 설정
			
			add(drinkpic);				//drinkpic 적용
			setLocation(165, 100);		//위치 지정	
			setResizable(false);		//사이즈조절 불가능하게 설정
			setSize(750, 690);			//사이즈 지정
			setVisible(false);			//Visible 대상 변경
		}

		class DrinkAction implements ActionListener { 												//주문요청을 처리 하기 위한 class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == drinkorder[0]) {												//딸기 에이드를 선택했을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 7000;															//총액에 지정된 값 추가
						t1info[num[0]] = "딸기 에이드";													//지정된 메뉴 추가
						t1price[num[0]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 7000;															//총액에 지정된 값 추가
						t2info[num[1]] = "딸기 에이드";													//지정된 메뉴 추가
						t2price[num[1]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 7000;															//총액에 지정된 값 추가
						t3info[num[2]] = "딸기 에이드";													//지정된 메뉴 추가
						t3price[num[2]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 7000;															//총액에 지정된 값 추가
						t4info[num[3]] = "딸기 에이드";													//지정된 메뉴 추가
						t4price[num[3]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 7000;															//총액에 지정된 값 추가
						t5info[num[4]] = "딸기 에이드";													//지정된 메뉴 추가
						t5price[num[4]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 7000;															//총액에 지정된 값 추가
						t6info[num[5]] = "딸기 에이드";													//지정된 메뉴 추가
						t6price[num[5]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 7000;															//총액에 지정된 값 추가
						t7info[num[6]] = "딸기 에이드";													//지정된 메뉴 추가
						t7price[num[6]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 7000;															//총액에 지정된 값 추가
						t8info[num[7]] = "딸기 에이드";													//지정된 메뉴 추가
						t8price[num[7]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 7000;															//총액에 지정된 값 추가
						t9info[num[8]] = "딸기 에이드";													//지정된 메뉴 추가
						t9price[num[8]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 7000;															//총액에 지정된 값 추가
						t10info[num[9]] = "딸기 에이드";												//지정된 메뉴 추가
						t10price[num[9]] = " 7.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 7000;																//총액에 지정된 값 추가
						t11info[num[10]] = "딸기 에이드";													//지정된 메뉴 추가
						t11price[num[10]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 7000;																//총액에 지정된 값 추가
						t12info[num[11]] = "딸기 에이드";													//지정된 메뉴 추가
						t12price[num[11]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == drinkorder[1]) {										//라즈베리 에이드가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 7000;															//총액에 지정된 값 추가
						t1info[num[0]] = "라즈베리 에이드";												//지정된 메뉴 추가
						t1price[num[0]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 7000;															//총액에 지정된 값 추가
						t2info[num[1]] = "라즈베리 에이드";												//지정된 메뉴 추가
						t2price[num[1]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 7000;															//총액에 지정된 값 추가
						t3info[num[2]] = "라즈베리 에이드";												//지정된 메뉴 추가
						t3price[num[2]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 7000;															//총액에 지정된 값 추가
						t4info[num[3]] = "라즈베리 에이드";												//지정된 메뉴 추가
						t4price[num[3]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 7000;															//총액에 지정된 값 추가
						t5info[num[4]] = "라즈베리 에이드";												//지정된 메뉴 추가
						t5price[num[4]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 7000;															//총액에 지정된 값 추가
						t6info[num[5]] = "라즈베리 에이드";												//지정된 메뉴 추가
						t6price[num[5]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 7000;															//총액에 지정된 값 추가
						t7info[num[6]] = "라즈베리 에이드";												//지정된 메뉴 추가
						t7price[num[6]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 7000;															//총액에 지정된 값 추가
						t8info[num[7]] = "라즈베리 에이드";												//지정된 메뉴 추가
						t8price[num[7]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 7000;															//총액에 지정된 값 추가
						t9info[num[8]] = "라즈베리 에이드";												//지정된 메뉴 추가
						t9price[num[8]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 7000;															//총액에 지정된 값 추가
						t10info[num[9]] = "라즈베리 에이드";												//지정된 메뉴 추가
						t10price[num[9]] = " 7.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 7000;																//총액에 지정된 값 추가
						t11info[num[10]] = "라즈베리 에이드";												//지정된 메뉴 추가
						t11price[num[10]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 7000;																//총액에 지정된 값 추가
						t12info[num[11]] = "라즈베리 에이드";												//지정된 메뉴 추가
						t12price[num[11]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}	
				} else if (e.getSource() == drinkorder[2]) {										//레몬 에이드가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 7000;															//총액에 지정된 값 추가
						t1info[num[0]] = "레몬 에이드";													//지정된 메뉴 추가
						t1price[num[0]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 7000;															//총액에 지정된 값 추가
						t2info[num[1]] = "레몬 에이드";													//지정된 메뉴 추가
						t2price[num[1]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 7000;															//총액에 지정된 값 추가
						t3info[num[2]] = "레몬 에이드";													//지정된 메뉴 추가
						t3price[num[2]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 7000;															//총액에 지정된 값 추가
						t4info[num[3]] = "레몬 에이드";													//지정된 메뉴 추가
						t4price[num[3]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 7000;															//총액에 지정된 값 추가
						t5info[num[4]] = "레몬 에이드";													//지정된 메뉴 추가
						t5price[num[4]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 7000;															//총액에 지정된 값 추가
						t6info[num[5]] = "레몬 에이드";													//지정된 메뉴 추가
						t6price[num[5]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 7000;															//총액에 지정된 값 추가
						t7info[num[6]] = "레몬 에이드";													//지정된 메뉴 추가
						t7price[num[6]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 7000;															//총액에 지정된 값 추가
						t8info[num[7]] = "레몬 에이드";													//지정된 메뉴 추가
						t8price[num[7]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 7000;															//총액에 지정된 값 추가
						t9info[num[8]] = "레몬 에이드";													//지정된 메뉴 추가
						t9price[num[8]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 7000;															//총액에 지정된 값 추가
						t10info[num[9]] = "레몬 에이드";												//지정된 메뉴 추가
						t10price[num[9]] = " 7.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 7000;																//총액에 지정된 값 추가
						t11info[num[10]] = "레몬 에이드";													//지정된 메뉴 추가
						t11price[num[10]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 7000;																//총액에 지정된 값 추가
						t12info[num[11]] = "레몬 에이드";													//지정된 메뉴 추가
						t12price[num[11]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == drinkorder[3]) {										//망고 에이드가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 7000;															//총액에 지정된 값 추가
						t1info[num[0]] = "망고 에이드";													//지정된 메뉴 추가
						t1price[num[0]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 7000;															//총액에 지정된 값 추가
						t2info[num[1]] = "망고 에이드";													//지정된 메뉴 추가
						t2price[num[1]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 7000;															//총액에 지정된 값 추가
						t3info[num[2]] = "망고 에이드";													//지정된 메뉴 추가
						t3price[num[2]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 7000;															//총액에 지정된 값 추가
						t4info[num[3]] = "망고 에이드";													//지정된 메뉴 추가
						t4price[num[3]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 7000;															//총액에 지정된 값 추가
						t5info[num[4]] = "망고 에이드";													//지정된 메뉴 추가
						t5price[num[4]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 7000;															//총액에 지정된 값 추가
						t6info[num[5]] = "망고 에이드";													//지정된 메뉴 추가
						t6price[num[5]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 7000;															//총액에 지정된 값 추가
						t7info[num[6]] = "망고 에이드";													//지정된 메뉴 추가
						t7price[num[6]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 7000;															//총액에 지정된 값 추가
						t8info[num[7]] = "망고 에이드";													//지정된 메뉴 추가
						t8price[num[7]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 7000;															//총액에 지정된 값 추가
						t9info[num[8]] = "망고 에이드";													//지정된 메뉴 추가
						t9price[num[8]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 7000;															//총액에 지정된 값 추가
						t10info[num[9]] = "망고 에이드";												//지정된 메뉴 추가
						t10price[num[9]] = " 7.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 7000;																//총액에 지정된 값 추가
						t11info[num[10]] = "망고 에이드";													//지정된 메뉴 추가
						t11price[num[10]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 7000;																//총액에 지정된 값 추가
						t12info[num[11]] = "망고 에이드";													//지정된 메뉴 추가
						t12price[num[11]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == drinkorder[4]) {										//한라봉 에이드가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 7000;															//총액에 지정된 값 추가
						t1info[num[0]] = "한라봉 에이드";												//지정된 메뉴 추가
						t1price[num[0]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 7000;															//총액에 지정된 값 추가
						t2info[num[1]] = "한라봉 에이드";												//지정된 메뉴 추가
						t2price[num[1]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 7000;															//총액에 지정된 값 추가
						t3info[num[2]] = "한라봉 에이드";												//지정된 메뉴 추가
						t3price[num[2]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 7000;															//총액에 지정된 값 추가
						t4info[num[3]] = "한라봉 에이드";												//지정된 메뉴 추가
						t4price[num[3]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 7000;															//총액에 지정된 값 추가
						t5info[num[4]] = "한라봉 에이드";												//지정된 메뉴 추가
						t5price[num[4]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 7000;															//총액에 지정된 값 추가
						t6info[num[5]] = "한라봉 에이드";												//지정된 메뉴 추가
						t6price[num[5]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 7000;															//총액에 지정된 값 추가
						t7info[num[6]] = "한라봉 에이드";												//지정된 메뉴 추가
						t7price[num[6]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 7000;															//총액에 지정된 값 추가
						t8info[num[7]] = "한라봉 에이드";												//지정된 메뉴 추가
						t8price[num[7]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 7000;															//총액에 지정된 값 추가
						t9info[num[8]] = "한라봉 에이드";												//지정된 메뉴 추가
						t9price[num[8]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 7000;															//총액에 지정된 값 추가
						t10info[num[9]] = "한라봉 에이드";												//지정된 메뉴 추가
						t10price[num[9]] = " 7.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 7000;																//총액에 지정된 값 추가
						t11info[num[10]] = "한라봉 에이드";													//지정된 메뉴 추가
						t11price[num[10]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 7000;																//총액에 지정된 값 추가
						t12info[num[11]] = "한라봉 에이드";													//지정된 메뉴 추가
						t12price[num[11]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == drinkorder[5]) {										//자몽 에이드가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 7000;															//총액에 지정된 값 추가
						t1info[num[0]] = "자몽 에이드";													//지정된 메뉴 추가
						t1price[num[0]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 7000;															//총액에 지정된 값 추가
						t2info[num[1]] = "자몽 에이드";													//지정된 메뉴 추가
						t2price[num[1]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 7000;															//총액에 지정된 값 추가
						t3info[num[2]] = "자몽 에이드";													//지정된 메뉴 추가
						t3price[num[2]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 7000;															//총액에 지정된 값 추가
						t4info[num[3]] = "자몽 에이드";													//지정된 메뉴 추가
						t4price[num[3]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 7000;															//총액에 지정된 값 추가
						t5info[num[4]] = "자몽 에이드";													//지정된 메뉴 추가
						t5price[num[4]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 7000;															//총액에 지정된 값 추가
						t6info[num[5]] = "자몽 에이드";													//지정된 메뉴 추가
						t6price[num[5]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 7000;															//총액에 지정된 값 추가
						t7info[num[6]] = "자몽 에이드";													//지정된 메뉴 추가
						t7price[num[6]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 7000;															//총액에 지정된 값 추가
						t8info[num[7]] = "자몽 에이드";													//지정된 메뉴 추가
						t8price[num[7]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 7000;															//총액에 지정된 값 추가
						t9info[num[8]] = "자몽 에이드";													//지정된 메뉴 추가
						t9price[num[8]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 7000;															//총액에 지정된 값 추가
						t10info[num[9]] = "자몽 에이드";												//지정된 메뉴 추가
						t10price[num[9]] = " 7.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 7000;																//총액에 지정된 값 추가
						t11info[num[10]] = "자몽 에이드";													//지정된 메뉴 추가
						t11price[num[10]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 7000;																//총액에 지정된 값 추가
						t12info[num[11]] = "자몽 에이드";													//지정된 메뉴 추가
						t12price[num[11]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == drinkorder[6]) {										//청포도 에이드가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 7000;															//총액에 지정된 값 추가
						t1info[num[0]] = "청포도 에이드";												//지정된 메뉴 추가
						t1price[num[0]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 7000;															//총액에 지정된 값 추가
						t2info[num[1]] = "청포도 에이드";												//지정된 메뉴 추가
						t2price[num[1]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 7000;															//총액에 지정된 값 추가
						t3info[num[2]] = "청포도 에이드";												//지정된 메뉴 추가
						t3price[num[2]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 7000;															//총액에 지정된 값 추가
						t4info[num[3]] = "청포도 에이드";												//지정된 메뉴 추가
						t4price[num[3]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 7000;															//총액에 지정된 값 추가
						t5info[num[4]] = "청포도 에이드";												//지정된 메뉴 추가
						t5price[num[4]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 7000;															//총액에 지정된 값 추가
						t6info[num[5]] = "청포도 에이드";												//지정된 메뉴 추가
						t6price[num[5]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 7000;															//총액에 지정된 값 추가
						t7info[num[6]] = "청포도 에이드";												//지정된 메뉴 추가
						t7price[num[6]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 7000;															//총액에 지정된 값 추가
						t8info[num[7]] = "청포도 에이드";												//지정된 메뉴 추가
						t8price[num[7]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 7000;															//총액에 지정된 값 추가
						t9info[num[8]] = "청포도 에이드";												//지정된 메뉴 추가
						t9price[num[8]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 7000;															//총액에 지정된 값 추가
						t10info[num[9]] = "청포도 에이드";												//지정된 메뉴 추가
						t10price[num[9]] = " 7.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 7000;																//총액에 지정된 값 추가
						t11info[num[10]] = "청포도 에이드";													//지정된 메뉴 추가
						t11price[num[10]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 7000;																//총액에 지정된 값 추가
						t12info[num[11]] = "청포도 에이드";													//지정된 메뉴 추가
						t12price[num[11]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == drinkorder[7]) {										//체리 에이드가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 7000;															//총액에 지정된 값 추가
						t1info[num[0]] = "체리 에이드";													//지정된 메뉴 추가
						t1price[num[0]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 7000;															//총액에 지정된 값 추가
						t2info[num[1]] = "체리 에이드";													//지정된 메뉴 추가
						t2price[num[1]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 7000;															//총액에 지정된 값 추가
						t3info[num[2]] = "체리 에이드";													//지정된 메뉴 추가
						t3price[num[2]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 7000;															//총액에 지정된 값 추가
						t4info[num[3]] = "체리 에이드";													//지정된 메뉴 추가
						t4price[num[3]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 7000;															//총액에 지정된 값 추가
						t5info[num[4]] = "체리 에이드";													//지정된 메뉴 추가
						t5price[num[4]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 7000;															//총액에 지정된 값 추가
						t6info[num[5]] = "체리 에이드";													//지정된 메뉴 추가
						t6price[num[5]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 7000;															//총액에 지정된 값 추가
						t7info[num[6]] = "체리 에이드";													//지정된 메뉴 추가
						t7price[num[6]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 7000;															//총액에 지정된 값 추가
						t8info[num[7]] = "체리 에이드";													//지정된 메뉴 추가
						t8price[num[7]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 7000;															//총액에 지정된 값 추가
						t9info[num[8]] = "체리 에이드";													//지정된 메뉴 추가
						t9price[num[8]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 7000;															//총액에 지정된 값 추가
						t10info[num[9]] = "체리 에이드";												//지정된 메뉴 추가
						t10price[num[9]] = " 7.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 7000;																//총액에 지정된 값 추가
						t11info[num[10]] = "체리 에이드";													//지정된 메뉴 추가
						t11price[num[10]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 7000;																//총액에 지정된 값 추가
						t12info[num[11]] = "체리 에이드";													//지정된 메뉴 추가
						t12price[num[11]] = " 7.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == drinkorder[8]) {										//콜라가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 2000;															//총액에 지정된 값 추가
						t1info[num[0]] = "콜라";														//지정된 메뉴 추가
						t1price[num[0]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 2000;															//총액에 지정된 값 추가
						t2info[num[1]] = "콜라";														//지정된 메뉴 추가
						t2price[num[1]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 2000;															//총액에 지정된 값 추가
						t3info[num[2]] = "콜라";														//지정된 메뉴 추가
						t3price[num[2]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 2000;															//총액에 지정된 값 추가
						t4info[num[3]] = "콜라";														//지정된 메뉴 추가
						t4price[num[3]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 2000;															//총액에 지정된 값 추가
						t5info[num[4]] = "콜라";														//지정된 메뉴 추가
						t5price[num[4]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 2000;															//총액에 지정된 값 추가
						t6info[num[5]] = "콜라";														//지정된 메뉴 추가
						t6price[num[5]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 2000;															//총액에 지정된 값 추가
						t7info[num[6]] = "콜라";														//지정된 메뉴 추가
						t7price[num[6]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 2000;															//총액에 지정된 값 추가
						t8info[num[7]] = "콜라";														//지정된 메뉴 추가
						t8price[num[7]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 2000;															//총액에 지정된 값 추가
						t9info[num[8]] = "콜라";														//지정된 메뉴 추가
						t9price[num[8]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 2000;															//총액에 지정된 값 추가
						t10info[num[9]] = "콜라";														//지정된 메뉴 추가
						t10price[num[9]] = " 2.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 2000;																//총액에 지정된 값 추가
						t11info[num[10]] = "콜라";														//지정된 메뉴 추가
						t11price[num[10]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 2000;																//총액에 지정된 값 추가
						t12info[num[11]] = "콜라";														//지정된 메뉴 추가
						t12price[num[11]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == drinkorder[9]) {										//사이다가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 2000;															//총액에 지정된 값 추가
						t1info[num[0]] = "사이다";													//지정된 메뉴 추가
						t1price[num[0]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 2000;															//총액에 지정된 값 추가
						t2info[num[1]] = "사이다";													//지정된 메뉴 추가
						t2price[num[1]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 2000;															//총액에 지정된 값 추가
						t3info[num[2]] = "사이다";													//지정된 메뉴 추가
						t3price[num[2]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 2000;															//총액에 지정된 값 추가
						t4info[num[3]] = "사이다";													//지정된 메뉴 추가
						t4price[num[3]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 2000;															//총액에 지정된 값 추가
						t5info[num[4]] = "사이다";													//지정된 메뉴 추가
						t5price[num[4]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 2000;															//총액에 지정된 값 추가
						t6info[num[5]] = "사이다";													//지정된 메뉴 추가
						t6price[num[5]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 2000;															//총액에 지정된 값 추가
						t7info[num[6]] = "사이다";													//지정된 메뉴 추가
						t7price[num[6]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 2000;															//총액에 지정된 값 추가
						t8info[num[7]] = "사이다";													//지정된 메뉴 추가
						t8price[num[7]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 2000;															//총액에 지정된 값 추가
						t9info[num[8]] = "사이다";													//지정된 메뉴 추가
						t9price[num[8]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 2000;															//총액에 지정된 값 추가
						t10info[num[9]] = "사이다";													//지정된 메뉴 추가
						t10price[num[9]] = " 2.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 2000;																//총액에 지정된 값 추가
						t11info[num[10]] = "사이다";														//지정된 메뉴 추가
						t11price[num[10]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 2000;																//총액에 지정된 값 추가
						t12info[num[11]] = "사이다";														//지정된 메뉴 추가
						t12price[num[11]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				} else if (e.getSource() == drinkorder[10]) {										//환타가 선택되었을 때
					if (select == 1) {																//1번 Table이 선택되었다면
						money[0] += 2000;															//총액에 지정된 값 추가
						t1info[num[0]] = "환타";														//지정된 메뉴 추가
						t1price[num[0]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t1info[num[0]] + " 합계금액 : " + money[0]);
						num[0]++;																	//총 주문갯수 증가
					} else if (select == 2) {														//2번 Table이 선택되었다면
						money[1] += 2000;															//총액에 지정된 값 추가
						t2info[num[1]] = "환타";														//지정된 메뉴 추가
						t2price[num[1]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t2info[num[1]] + " 합계금액 : " + money[1]);
						num[1]++;																	//총 주문갯수 증가
					} else if (select == 3) {														//3번 Table이 선택되었다면
						money[2] += 2000;															//총액에 지정된 값 추가
						t3info[num[2]] = "환타";														//지정된 메뉴 추가
						t3price[num[2]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t3info[num[2]] + " 합계금액 : " + money[2]);
						num[2]++;																	//총 주문갯수 증가
					} else if (select == 4) {														//4번 Table이 선택되었다면
						money[3] += 2000;															//총액에 지정된 값 추가
						t4info[num[3]] = "환타";														//지정된 메뉴 추가
						t4price[num[3]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t4info[num[3]] + " 합계금액 : " + money[3]);
						num[3]++;																	//총 주문갯수 증가
					} else if (select == 5) {														//5번 Table이 선택되었다면
						money[4] += 2000;															//총액에 지정된 값 추가
						t5info[num[4]] = "환타";														//지정된 메뉴 추가
						t5price[num[4]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t5info[num[4]] + " 합계금액 : " + money[4]);
						num[4]++;																	//총 주문갯수 증가
					} else if (select == 6) {														//6번 Table이 선택되었다면
						money[5] += 2000;															//총액에 지정된 값 추가
						t6info[num[5]] = "환타";														//지정된 메뉴 추가
						t6price[num[5]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t6info[num[5]] + " 합계금액 : " + money[5]);
						num[5]++;																	//총 주문갯수 증가
					} else if (select == 7) {														//7번 Table이 선택되었다면
						money[6] += 2000;															//총액에 지정된 값 추가
						t7info[num[6]] = "환타";														//지정된 메뉴 추가
						t7price[num[6]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t7info[num[6]] + " 합계금액 : " + money[6]);
						num[6]++;																	//총 주문갯수 증가
					} else if (select == 8) {														//8번 Table이 선택되었다면
						money[7] += 2000;															//총액에 지정된 값 추가
						t8info[num[7]] = "환타";														//지정된 메뉴 추가
						t8price[num[7]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t8info[num[7]] + " 합계금액 : " + money[7]);
						num[7]++;																	//총 주문갯수 증가
					} else if (select == 9) {														//9번 Table이 선택되었다면
						money[8] += 2000;															//총액에 지정된 값 추가
						t9info[num[8]] = "환타";														//지정된 메뉴 추가
						t9price[num[8]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t9info[num[8]] + " 합계금액 : " + money[8]);
						num[8]++;																	//총 주문갯수 증가
					} else if (select == 10) {														//10번 Table이 선택되었다면
						money[9] += 2000;															//총액에 지정된 값 추가
						t10info[num[9]] = "환타";														//지정된 메뉴 추가
						t10price[num[9]] = " 2.000";												//지정된 값 추가
						System.out.println("주문 음식 : " + t10info[num[9]] + " 합계금액 : " + money[9]);
						num[9]++;																	//총 주문갯수 증가
					} else if (select == 11) {															//11번 Table이 선택되었다면
						money[10] += 2000;																//총액에 지정된 값 추가
						t11info[num[10]] = "환타";														//지정된 메뉴 추가
						t11price[num[10]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t11info[num[10]] + " 합계금액 : " + money[10]);
						num[10]++;																		//총 주문갯수 증가
					} else if (select == 12) {															//12번 Table이 선택되었다면
						money[11] += 2000;																//총액에 지정된 값 추가
						t12info[num[11]] = "환타";														//지정된 메뉴 추가
						t12price[num[11]] = " 2.000";													//지정된 값 추가
						System.out.println("주문 음식 : " + t12info[num[11]] + " 합계금액 : " + money[11]);
						num[11]++;																		//총 주문갯수 증가
					}
				}
			}
		}						
	}

	class FoodMenu extends JDialog {										//주문할 때 Restaurant의 Menu를 조회하고 이에 대한 작업을 하는 class
		JPanel menupanel = new JPanel();									//menu를 시각적으로 나타내기 위해 사용하는 JPanel
		JLabel menupimg = new JLabel(images.menuimg());						//앞으로 나올 내용이 menu라는 것을 시각적으로 나타내기 위해 사용하는 JLabel

		FoodMenu() {														//FoodMenu 생성자
			//각 button의 내부영역 비움 설정
			steak.setContentAreaFilled(false);	
			pasta.setContentAreaFilled(false);
			pilaf.setContentAreaFilled(false);
			pizza.setContentAreaFilled(false);
			side.setContentAreaFilled(false);
			drink.setContentAreaFilled(false);
			endbtn.setContentAreaFilled(false);
			
			//각 button에 ActionListener 적용
			steak.addActionListener(new FoodAction());
			pasta.addActionListener(new FoodAction());
			pilaf.addActionListener(new FoodAction());
			pizza.addActionListener(new FoodAction());
			side.addActionListener(new FoodAction());
			drink.addActionListener(new FoodAction());
			endbtn.addActionListener(new FoodAction());
			
			getContentPane();												//현재 작동중인 ContentPane 호출									
			setLayout(null);												//절대 경로 배치관리자 설정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			menupanel.setSize(160, 600);									//menupanel 사이즈 지정							
			menupanel.setBackground(Color.WHITE);							//menupanel 배경색 지정
			menupanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));	//menupanel는 FlowLayout 배치관리자로 설정
			//menupanel에 각 ContentPane을 적용
			menupanel.add(menupimg);
			menupanel.add(steak);
			menupanel.add(pasta);
			menupanel.add(pilaf);
			menupanel.add(pizza);
			menupanel.add(side);
			menupanel.add(drink);
			menupanel.add(endbtn);
			add(menupanel);					//menupanel 적용
			
			endbtn.addActionListener(new ActionListener() {							//endbtn에 ActionListener 적용
				public void actionPerformed(ActionEvent e) { 
					if (select == 1) {												//1번 Table이 선택되었다면
						if (money[0] > 0) {
							lucknum[0] = (int) (Math.random() * 10);				//랜덤숫자를 생성하고 해당 table의 lucknum에 저장
							tbtn[0].setBackground(Color.GREEN);						//tbtn의 배경색 설정
							tbtn[0].setForeground(Color.BLACK);						//tbtn의 색 설정
							mon1 = "금액: " + Integer.toString(money[0]) + " 원";		//Table의 총 주문금액을 출력하기 위한 문자열 저장
							tbtn[0].setText(mon1);									//tbtn에 mon1을 출력
							tblabel2[0].setText("시간: " + nowDate);					//tblable2에 처리된 시간을 출력
						}
					} else if (select == 2) {										//2번 Table이 선택되었다면
						if (money[1] > 0) {
							lucknum[1] = (int) (Math.random() * 10);				//랜덤숫자를 생성하고 해당 table의 lucknum에 저장
							tbtn[1].setBackground(Color.GREEN);						//tbtn의 배경색 설정
							tbtn[1].setForeground(Color.BLACK);						//tbtn의 색 설정
							mon2 = "금액: " + Integer.toString(money[1]) + " 원";		//Table의 총 주문금액을 출력하기 위한 문자열 저장
							tbtn[1].setText(mon2);									//tbtn에 mon2을 출력
							tblabel2[1].setText("시간: " + nowDate);					//tblable2에 처리된 시간을 출력
						}
					} else if (select == 3) {										//3번 Table이 선택되었다면	
						if (money[2] > 0) {
							lucknum[2] = (int) (Math.random() * 10);				//랜덤숫자를 생성하고 해당 table의 lucknum에 저장
							tbtn[2].setBackground(Color.GREEN);						//tbtn의 배경색 설정
							tbtn[2].setForeground(Color.BLACK);						//tbtn의 색 설정
							mon3 = "금액: " + Integer.toString(money[2]) + " 원";		//Table의 총 주문금액을 출력하기 위한 문자열 저장
							tbtn[2].setText(mon3);									//tbtn에 mon3을 출력
							tblabel2[2].setText("시간: " + nowDate);					//tblable2에 처리된 시간을 출력
						}
					} else if (select == 4) {										//4번 Table이 선택되었다면	
						if (money[3] > 0) {
							lucknum[3] = (int) (Math.random() * 10);				//랜덤숫자를 생성하고 해당 table의 lucknum에 저장
							tbtn[3].setBackground(Color.GREEN);						//tbtn의 배경색 설정
							tbtn[3].setForeground(Color.BLACK);						//tbtn의 색 설정
							mon4 = "금액: " + Integer.toString(money[3]) + " 원";		//Table의 총 주문금액을 출력하기 위한 문자열 저장
							tbtn[3].setText(mon4);									//tbtn에 mon4을 출력
							tblabel2[3].setText("시간: " + nowDate);					//tblable2에 처리된 시간을 출력
						}
					} else if (select == 5) {										//5번 Table이 선택되었다면	
						if (money[4] > 0) {
							lucknum[4] = (int) (Math.random() * 10);				//랜덤숫자를 생성하고 해당 table의 lucknum에 저장
							tbtn[4].setBackground(Color.GREEN);						//tbtn의 배경색 설정
							tbtn[4].setForeground(Color.BLACK);						//tbtn의 색 설정
							mon5 = "금액: " + Integer.toString(money[4]) + " 원";		//Table의 총 주문금액을 출력하기 위한 문자열 저장
							tbtn[4].setText(mon5);									//tbtn에 mon5을 출력
							tblabel2[4].setText("시간: " + nowDate);					//tblable2에 처리된 시간을 출력
						}
					} else if (select == 6) {										//6번 Table이 선택되었다면	
						if (money[5] > 0) {
							lucknum[5] = (int) (Math.random() * 10);				//랜덤숫자를 생성하고 해당 table의 lucknum에 저장
							tbtn[5].setBackground(Color.GREEN);						//tbtn의 배경색 설정
							tbtn[5].setForeground(Color.BLACK);						//tbtn의 색 설정
							mon6 = "금액: " + Integer.toString(money[5]) + " 원";		//Table의 총 주문금액을 출력하기 위한 문자열 저장
							tbtn[5].setText(mon6);									//tbtn에 mon6을 출력
							tblabel2[5].setText("시간: " + nowDate);					//tblable2에 처리된 시간을 출력
						}
					} else if (select == 7) {										//7번 Table이 선택되었다면
						if (money[6] > 0) {
							lucknum[6] = (int) (Math.random() * 10);				//랜덤숫자를 생성하고 해당 table의 lucknum에 저장
							tbtn[6].setBackground(Color.GREEN);						//tbtn의 배경색 설정
							tbtn[6].setForeground(Color.BLACK);						//tbtn의 색 설정
							mon7 = "금액: " + Integer.toString(money[6]) + " 원";		//Table의 총 주문금액을 출력하기 위한 문자열 저장
							tbtn[6].setText(mon7);									//tbtn에 mon7을 출력
							tblabel2[6].setText("시간: " + nowDate);					//tblable2에 처리된 시간을 출력
						}
					} else if (select == 8) {										//8번 Table이 선택되었다면
						if (money[7] > 0) {
							lucknum[7] = (int) (Math.random() * 10);				//랜덤숫자를 생성하고 해당 table의 lucknum에 저장
							tbtn[7].setBackground(Color.GREEN);						//tbtn의 배경색 설정
							tbtn[7].setForeground(Color.BLACK);						//tbtn의 색 설정
							mon8 = "금액: " + Integer.toString(money[7]) + " 원";		//Table의 총 주문금액을 출력하기 위한 문자열 저장
							tbtn[7].setText(mon8);									//tbtn에 mon8을 출력
							tblabel2[7].setText("시간: " + nowDate);					//tblable2에 처리된 시간을 출력
						}
					} else if (select == 9) {										//9번 Table이 선택되었다면
						if (money[8] > 0) {
							lucknum[8] = (int) (Math.random() * 10);				//랜덤숫자를 생성하고 해당 table의 lucknum에 저장
							tbtn[8].setBackground(Color.GREEN);						//tbtn의 배경색 설정
							tbtn[8].setForeground(Color.BLACK);						//tbtn의 색 설정
							mon9 = "금액: " + Integer.toString(money[8]) + " 원";		//Table의 총 주문금액을 출력하기 위한 문자열 저장
							tbtn[8].setText(mon9);									//tbtn에 mon9을 출력
							tblabel2[8].setText("시간: " + nowDate);					//tblable2에 처리된 시간을 출력
						}
					} else if (select == 10) {										//10번 Table이 선택되었다면	
						if (money[9] > 0) {
							lucknum[9] = (int) (Math.random() * 10);				//랜덤숫자를 생성하고 해당 table의 lucknum에 저장
							tbtn[9].setBackground(Color.GREEN);						//tbtn의 배경색 설정
							tbtn[9].setForeground(Color.BLACK);						//tbtn의 색 설정
							mon10 = "금액: " + Integer.toString(money[9]) + " 원";	//Table의 총 주문금액을 출력하기 위한 문자열 저장
							tbtn[9].setText(mon10);									//tbtn에 mon10을 출력
							tblabel2[9].setText("시간: " + nowDate);					//tblable2에 처리된 시간을 출력
						}
					} else if (select == 11) {										//11번 Table이 선택되었다면	
						if (money[10] > 0) {
							lucknum[10] = (int) (Math.random() * 10);				//랜덤숫자를 생성하고 해당 table의 lucknum에 저장
							tbtn[10].setBackground(Color.GREEN);					//tbtn의 배경색 설정
							tbtn[10].setForeground(Color.BLACK);					//tbtn의 색 설정
							mon11 = "금액: " + Integer.toString(money[10]) + " 원";	//Table의 총 주문금액을 출력하기 위한 문자열 저장
							tbtn[10].setText(mon11);								//tbtn에 mon11을 출력
							tblabel2[10].setText("시간: " + nowDate);					//tblable2에 처리된 시간을 출력
						}
					} else if (select == 12) {										//12번 Table이 선택되었다면	
						if (money[11] > 0) {
							lucknum[11] = (int) (Math.random() * 10);				//랜덤숫자를 생성하고 해당 table의 lucknum에 저장
							tbtn[11].setBackground(Color.GREEN);					//tbtn의 배경색 설정
							tbtn[11].setForeground(Color.BLACK);					//tbtn의 색 설정
							mon12 = "금액: " + Integer.toString(money[11]) + " 원";	//Table의 총 주문금액을 출력하기 위한 문자열 저장
							tbtn[11].setText(mon12);								//tbtn에 mon12을 출력
							tblabel2[11].setText("시간: " + nowDate);					//tblable2에 처리된 시간을 출력
						}
					}
					setVisible(false);			//Visible 대상 변경
				}
			});
			setSize(160, 450);					//사이즈 지정
			setLocation(0, 100);				//위치 지정
			setResizable(false);				//사이즈조절 불가능하게 설정
		}

		class FoodAction implements ActionListener { 		//menu별로 각각의 panel을 불러오기 위한 class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == steak)					
					stp.setVisible(true);					//steak panel로 Visible 대상 변경
				else if (e.getSource() == pasta)			
					psp.setVisible(true);					//pasta panel로 Visible 대상 변경
				else if (e.getSource() == pilaf)			
					plp.setVisible(true);					//pilaf panel로 Visible 대상 변경
				else if (e.getSource() == pizza)			
					pzp.setVisible(true);					//pizza panel로 Visible 대상 변경
				else if (e.getSource() == side)				
					sdp.setVisible(true);					//side panel로 Visible 대상 변경
				else if (e.getSource() == drink)			
					dkp.setVisible(true);					//drink panel로 Visible 대상 변경
			}
		}
	}

	class SubMenu extends JDialog {										//주문, 계산, 예약, 취소에 관련된 작업을 처리하는 class 
		SubMenu() {														//SubMenu 생성자													
			getContentPane();											//현재 작동중인 ContentPane 호출
			setTitle("주문 / 계산  / 예약 / 취소");							//title 지정
			setLayout(new GridLayout(1, 4));							//GridLayout 배치관리자 설정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);												//모달 설정
			
			Clickbtn1 = new JButton("주문", images.orderingimg()); 		//주문 요청을 처리하기 위한 JButton
			Clickbtn2 = new JButton("계산", images.cashimg());	 		//계산 요청을 처리하기 위한 JButton
			Clickbtn3 = new JButton("예약", images.reservationimg());	 	//예약 요청을 처리하기 위한 JButton
			Clickbtn4 = new JButton("취소", images.cancelimg());	 		//취소 요청을 처리하기 위한 JButton
			
			//각 ContentPane을 적용
			add(Clickbtn1);
			add(Clickbtn2);
			add(Clickbtn3);
			add(Clickbtn4);
			
			Clickbtn2.setEnabled(false);						//주어진 조건이 만족될때만 Clickbtn2를 enable할 수 있도록 설정
			
			//각 Clickbtn의 사이즈 지정
			Clickbtn1.setSize(134, 108);						
			Clickbtn2.setSize(134, 108);						
			Clickbtn3.setSize(134, 108);						
			Clickbtn4.setSize(134, 108);				
			
			//각 Clickbtn에 ActionListener 적용
			Clickbtn1.addActionListener(new ClickAction());		
			Clickbtn2.addActionListener(new ClickAction());
			Clickbtn3.addActionListener(new ClickAction());
			Clickbtn4.addActionListener(new ClickAction());
			
			setJMenuBar(optionbar);							//optionbar를 Menubar로 적용
			tbinfo.addActionListener(new ClickAction());	//tbinfo에 ActionListener 적용
			
			setSize(385, 165);			//사이즈 지정
			setLocation(500, 300);		//위치 지정
			setResizable(false);		//사이즈조절 불가능하게 설정
			setVisible(false);			//Visible 대상 변경
		}

		class Table1 extends JFrame {				//1번 Table의 주문 정보 저장하고 출력하는 class
			JLabel name = new JLabel(t1name);		//예약시 입력했던 이름을 저장하기 위한 JLabel
			JLabel birth = new JLabel(t1birth);		//예약시 입력했던 생년월일을 저장하기 위한 JLabel
			JLabel main = new JLabel(t1main);		//예약시 입력했던 메인 메뉴를 저장하기 위한 JLabel
			JLabel side = new JLabel(t1side);		//예약시 입력했던 사이드 메뉴를 저장하기 위한 JLabel
			JLabel person = new JLabel(t1person);	//예약시 입력했던 방문인원 수를 저장하기 위한 JLabel
			JLabel phone = new JLabel(t1phone);		//예약시 입력했던 전화번호를 저장하기 위한 JLabel
			JLabel num = new JLabel(t1num);			//예약시 입력했던 테이블 번호를 저장하기 위한 JLabel
			JLabel time = new JLabel(t1time);		//예약시 입력했던 방문시간을 저장하기 위한 JLabel
			
			public Table1() {										//Table1 생성자
				setTitle("Table 1");								//title 지정
				getContentPane();									//현재 작동중인 ContentPane 호출
				setLayout(null);									//절대 경로 배치관리자 설정
				setModal(true);										//모달 설정
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//각 JLabel의 boundary 설정
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//각 JLabel의 boundary 설정
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//각 ContentPane을 적용
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
				setSize(450, 400);		//사이즈 지정
				setResizable(false);	//사이즈조절 불가능하게 설정
				setVisible(true);		//Visible 대상 지정
			}
		}

		class Table2 extends JFrame {				//2번 Table의 주문 정보 저장하고 출력하는 class
			JLabel name = new JLabel(t2name);		//예약시 입력했던 이름을 저장하기 위한 JLabel
			JLabel birth = new JLabel(t2birth);		//예약시 입력했던 생년월일을 저장하기 위한 JLabel
			JLabel main = new JLabel(t2main);		//예약시 입력했던 메인 메뉴를 저장하기 위한 JLabel
			JLabel side = new JLabel(t2side);		//예약시 입력했던 사이드 메뉴를 저장하기 위한 JLabel
			JLabel person = new JLabel(t2person);	//예약시 입력했던 방문인원 수를 저장하기 위한 JLabel
			JLabel phone = new JLabel(t2phone);		//예약시 입력했던 전화번호를 저장하기 위한 JLabel
			JLabel num = new JLabel(t2num);			//예약시 입력했던 테이블 번호를 저장하기 위한 JLabel
			JLabel time = new JLabel(t2time);		//예약시 입력했던 방문시간을 저장하기 위한 JLabel

			public Table2() {										//Table2 생성자
				setTitle("Table 2");								//title 지정
				getContentPane();									//현재 작동중인 ContentPane 호출
				setLayout(null);									//절대 경로 배치관리자 설정
				setModal(true);										//모달 설정
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//각 JLabel의 boundary 설정
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//각 JLabel의 boundary 설정
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//각 ContentPane을 적용
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
				setSize(600, 400);			//사이즈 지정
				setResizable(false);		//사이즈조절 불가능하게 설정
				setVisible(true);			//Visible 대상 지정
			}
		}

		class Table3 extends JFrame {				//3번 Table의 주문 정보 저장하고 출력하는 class
			JLabel name = new JLabel(t3name);		//예약시 입력했던 이름을 저장하기 위한 JLabel
			JLabel birth = new JLabel(t3birth);		//예약시 입력했던 생년월일을 저장하기 위한 JLabel
			JLabel main = new JLabel(t3main);		//예약시 입력했던 메인 메뉴를 저장하기 위한 JLabel
			JLabel side = new JLabel(t3side);		//예약시 입력했던 사이드 메뉴를 저장하기 위한 JLabel
			JLabel person = new JLabel(t3person);	//예약시 입력했던 방문인원 수를 저장하기 위한 JLabel
			JLabel phone = new JLabel(t3phone);		//예약시 입력했던 전화번호를 저장하기 위한 JLabel
			JLabel num = new JLabel(t3num);			//예약시 입력했던 테이블 번호를 저장하기 위한 JLabel
			JLabel time = new JLabel(t3time);		//예약시 입력했던 방문시간을 저장하기 위한 JLabel

			public Table3() {										//Table3 생성자
				setTitle("Table 3");								//title 지정
				getContentPane();									//현재 작동중인 ContentPane 호출
				setLayout(null);									//절대 경로 배치관리자 설정
				setModal(true);										//모달 설정
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//각 JLabel의 boundary 설정
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//각 JLabel의 boundary 설정
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//각 ContentPane을 적용
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
				setSize(600, 400);			//사이즈 지정
				setResizable(false);		//사이즈조절 불가능하게 설정
				setVisible(true);			//Visible 대상 지정
			}
		}

		class Table4 extends JFrame {				//4번 Table의 주문 정보 저장하고 출력하는 class
			JLabel name = new JLabel(t4name);		//예약시 입력했던 이름을 저장하기 위한 JLabel
			JLabel birth = new JLabel(t4birth);		//예약시 입력했던 생년월일을 저장하기 위한 JLabel
			JLabel main = new JLabel(t4main);		//예약시 입력했던 메인 메뉴를 저장하기 위한 JLabel
			JLabel side = new JLabel(t4side);		//예약시 입력했던 사이드 메뉴를 저장하기 위한 JLabel
			JLabel person = new JLabel(t4person);	//예약시 입력했던 방문인원 수를 저장하기 위한 JLabel
			JLabel phone = new JLabel(t4phone);		//예약시 입력했던 전화번호를 저장하기 위한 JLabel
			JLabel num = new JLabel(t4num);			//예약시 입력했던 테이블 번호를 저장하기 위한 JLabel
			JLabel time = new JLabel(t4time);		//예약시 입력했던 방문시간을 저장하기 위한 JLabel

			public Table4() {										//Table4 생성자
				setTitle("Table 4");								//title 지정
				getContentPane();									//현재 작동중인 ContentPane 호출
				setLayout(null);									//절대 경로 배치관리자 설정
				setModal(true);										//모달 설정
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//각 JLabel의 boundary 설정
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//각 JLabel의 boundary 설정
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//각 ContentPane을 적용
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
				setSize(600, 400);			//사이즈 지정
				setResizable(false);		//사이즈조절 불가능하게 설정
				setVisible(true);			//Visible 대상 지정
			}
		}

		class Table5 extends JFrame {				//5번 Table의 주문 정보 저장하고 출력하는 class
			JLabel name = new JLabel(t5name);		//예약시 입력했던 이름을 저장하기 위한 JLabel
			JLabel birth = new JLabel(t5birth);		//예약시 입력했던 생년월일을 저장하기 위한 JLabel
			JLabel main = new JLabel(t5main);		//예약시 입력했던 메인 메뉴를 저장하기 위한 JLabel
			JLabel side = new JLabel(t5side);		//예약시 입력했던 사이드 메뉴를 저장하기 위한 JLabel
			JLabel person = new JLabel(t5person);	//예약시 입력했던 방문인원 수를 저장하기 위한 JLabel
			JLabel phone = new JLabel(t5phone);		//예약시 입력했던 전화번호를 저장하기 위한 JLabel
			JLabel num = new JLabel(t5num);			//예약시 입력했던 테이블 번호를 저장하기 위한 JLabel
			JLabel time = new JLabel(t5time);		//예약시 입력했던 방문시간을 저장하기 위한 JLabel

			public Table5() {										//Table5 생성자
				setTitle("Table 5");								//title 지정
				getContentPane();									//현재 작동중인 ContentPane 호출
				setLayout(null);									//절대 경로 배치관리자 설정
				setModal(true);										//모달 설정
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//각 JLabel의 boundary 설정
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//각 JLabel의 boundary 설정
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//각 ContentPane을 적용
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
				setSize(600, 400);			//사이즈 지정
				setResizable(false);		//사이즈조절 불가능하게 설정
				setVisible(true);			//Visible 대상 지정
			}
		}

		class Table6 extends JFrame {				//6번 Table의 주문 정보 저장하고 출력하는 class
			JLabel name = new JLabel(t6name);		//예약시 입력했던 이름을 저장하기 위한 JLabel
			JLabel birth = new JLabel(t6birth);		//예약시 입력했던 생년월일을 저장하기 위한 JLabel
			JLabel main = new JLabel(t6main);		//예약시 입력했던 메인 메뉴를 저장하기 위한 JLabel
			JLabel side = new JLabel(t6side);		//예약시 입력했던 사이드 메뉴를 저장하기 위한 JLabel
			JLabel person = new JLabel(t6person);	//예약시 입력했던 방문인원 수를 저장하기 위한 JLabel
			JLabel phone = new JLabel(t6phone);		//예약시 입력했던 전화번호를 저장하기 위한 JLabel
			JLabel num = new JLabel(t6num);			//예약시 입력했던 테이블 번호를 저장하기 위한 JLabel
			JLabel time = new JLabel(t6time);		//예약시 입력했던 방문시간을 저장하기 위한 JLabel

			public Table6() {										//Table6 생성자
				setTitle("Table 6");								//title 지정
				getContentPane();									//현재 작동중인 ContentPane 호출
				setLayout(null);									//절대 경로 배치관리자 설정
				setModal(true);										//모달 설정
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//각 JLabel의 boundary 설정
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//각 JLabel의 boundary 설정
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//각 ContentPane을 적용
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
				setSize(600, 400);			//사이즈 지정
				setResizable(false);		//사이즈조절 불가능하게 설정
				setVisible(true);			//Visible 대상 지정
			}
		}

		class Table7 extends JFrame {				//7번 Table의 주문 정보 저장하고 출력하는 class
			JLabel name = new JLabel(t7name);		//예약시 입력했던 이름을 저장하기 위한 JLabel
			JLabel birth = new JLabel(t7birth);		//예약시 입력했던 생년월일을 저장하기 위한 JLabel
			JLabel main = new JLabel(t7main);		//예약시 입력했던 메인 메뉴를 저장하기 위한 JLabel
			JLabel side = new JLabel(t7side);		//예약시 입력했던 사이드 메뉴를 저장하기 위한 JLabel
			JLabel person = new JLabel(t7person);	//예약시 입력했던 방문인원 수를 저장하기 위한 JLabel
			JLabel phone = new JLabel(t7phone);		//예약시 입력했던 전화번호를 저장하기 위한 JLabel
			JLabel num = new JLabel(t7num);			//예약시 입력했던 테이블 번호를 저장하기 위한 JLabel
			JLabel time = new JLabel(t7time);		//예약시 입력했던 방문시간을 저장하기 위한 JLabel

			public Table7() {										//Table7 생성자
				setTitle("Table 7");								//title 지정
				getContentPane();									//현재 작동중인 ContentPane 호출
				setLayout(null);									//절대 경로 배치관리자 설정
				setModal(true);										//모달 설정
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//각 JLabel의 boundary 설정
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//각 JLabel의 boundary 설정
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//각 ContentPane을 적용
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
				setSize(600, 400);		//사이즈 지정
				setResizable(false);	//사이즈조절 불가능하게 설정
				setVisible(true);		//Visible 대상 지정
			}
		}

		class Table8 extends JFrame {				//8번 Table의 주문 정보 저장하고 출력하는 class
			JLabel name = new JLabel(t8name);		//예약시 입력했던 이름을 저장하기 위한 JLabel
			JLabel birth = new JLabel(t8birth);		//예약시 입력했던 생년월일을 저장하기 위한 JLabel
			JLabel main = new JLabel(t8main);		//예약시 입력했던 메인 메뉴를 저장하기 위한 JLabel
			JLabel side = new JLabel(t8side);		//예약시 입력했던 사이드 메뉴를 저장하기 위한 JLabel
			JLabel person = new JLabel(t8person);	//예약시 입력했던 방문인원 수를 저장하기 위한 JLabel
			JLabel phone = new JLabel(t8phone);		//예약시 입력했던 전화번호를 저장하기 위한 JLabel
			JLabel num = new JLabel(t8num);			//예약시 입력했던 테이블 번호를 저장하기 위한 JLabel
			JLabel time = new JLabel(t8time);		//예약시 입력했던 방문시간을 저장하기 위한 JLabel

			public Table8() {										//Table8 생성자
				setTitle("Table 8");								//title 지정
				getContentPane();									//현재 작동중인 ContentPane 호출
				setLayout(null);									//절대 경로 배치관리자 설정
				setModal(true);										//모달 설정
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//각 JLabel의 boundary 설정
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//각 JLabel의 boundary 설정
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//각 ContentPane을 적용
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
				setSize(600, 400);		//사이즈 지정
				setResizable(false);	//사이즈조절 불가능하게 설정
				setVisible(true);		//Visible 대상 지정
			}
		}

		class Table9 extends JFrame {				//9번 Table의 주문 정보 저장하고 출력하는 class
			JLabel name = new JLabel(t9name);		//예약시 입력했던 이름을 저장하기 위한 JLabel
			JLabel birth = new JLabel(t9birth);		//예약시 입력했던 생년월일을 저장하기 위한 JLabel
			JLabel main = new JLabel(t9main);		//예약시 입력했던 메인 메뉴를 저장하기 위한 JLabel
			JLabel side = new JLabel(t9side);		//예약시 입력했던 사이드 메뉴를 저장하기 위한 JLabel
			JLabel person = new JLabel(t9person);	//예약시 입력했던 방문인원 수를 저장하기 위한 JLabel
			JLabel phone = new JLabel(t9phone);		//예약시 입력했던 전화번호를 저장하기 위한 JLabel
			JLabel num = new JLabel(t9num);			//예약시 입력했던 테이블 번호를 저장하기 위한 JLabel
			JLabel time = new JLabel(t9time);		//예약시 입력했던 방문시간을 저장하기 위한 JLabel

			public Table9() {										//Table9 생성자
				setTitle("Table 9");								//title 지정
				getContentPane();									//현재 작동중인 ContentPane 호출
				setLayout(null);									//절대 경로 배치관리자 설정
				setModal(true);										//모달 설정
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//각 JLabel의 boundary 설정
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//각 JLabel의 boundary 설정
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//각 ContentPane을 적용
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
				setSize(600, 400);		//사이즈 지정
				setResizable(false);	//사이즈조절 불가능하게 설정
				setVisible(true);		//Visible 대상 지정
			}
		}

		class Table10 extends JFrame {				//10번 Table의 주문 정보 저장하고 출력하는 class
			JLabel name = new JLabel(t10name);		//예약시 입력했던 이름을 저장하기 위한 JLabel
			JLabel birth = new JLabel(t10birth);	//예약시 입력했던 생년월일을 저장하기 위한 JLabel
			JLabel main = new JLabel(t10main);		//예약시 입력했던 메인 메뉴를 저장하기 위한 JLabel
			JLabel side = new JLabel(t10side);		//예약시 입력했던 사이드 메뉴를 저장하기 위한 JLabel
			JLabel person = new JLabel(t10person);	//예약시 입력했던 방문인원 수를 저장하기 위한 JLabel
			JLabel phone = new JLabel(t10phone);	//예약시 입력했던 전화번호를 저장하기 위한 JLabel
			JLabel num = new JLabel(t10num);		//예약시 입력했던 테이블 번호를 저장하기 위한 JLabel
			JLabel time = new JLabel(t10time);		//예약시 입력했던 방문시간을 저장하기 위한 JLabel

			public Table10() {										//Table10 생성자
				setTitle("Table 10");								//title 지정
				getContentPane();									//현재 작동중인 ContentPane 호출							
				setLayout(null);									//절대 경로 배치관리자 설정
				setModal(true);										//모달 설정
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//각 JLabel의 boundary 설정
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//각 JLabel의 boundary 설정
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//각 ContentPane을 적용
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
				setSize(600, 400);		//사이즈 지정
				setResizable(false);	//사이즈조절 불가능하게 설정
				setVisible(true);		//Visible 대상 지정
			}
		}

		class Table11 extends JFrame {				//11번 Table의 주문 정보 저장하고 출력하는 class
			JLabel name = new JLabel(t11name);		//예약시 입력했던 이름을 저장하기 위한 JLabel
			JLabel birth = new JLabel(t11birth);	//예약시 입력했던 생년월일을 저장하기 위한 JLabel
			JLabel main = new JLabel(t11main);		//예약시 입력했던 메인 메뉴를 저장하기 위한 JLabel
			JLabel side = new JLabel(t11side);		//예약시 입력했던 사이드 메뉴를 저장하기 위한 JLabel
			JLabel person = new JLabel(t11person);	//예약시 입력했던 방문인원 수를 저장하기 위한 JLabel
			JLabel phone = new JLabel(t11phone);	//예약시 입력했던 전화번호를 저장하기 위한 JLabel
			JLabel num = new JLabel(t11num);		//예약시 입력했던 테이블 번호를 저장하기 위한 JLabel
			JLabel time = new JLabel(t11time);		//예약시 입력했던 방문시간을 저장하기 위한 JLabel

			public Table11() {										//Table11 생성자
				setTitle("Table 11");								//title 지정
				getContentPane();									//현재 작동중인 ContentPane 호출
				setLayout(null);									//절대 경로 배치관리자 설정
				setModal(true);										//모달 설정
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//각 JLabel의 boundary 설정
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//각 JLabel의 boundary 설정
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//각 ContentPane을 적용
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
				setSize(600, 400);		//사이즈 지정
				setResizable(false);	//사이즈조절 불가능하게 설정
				setVisible(true);		//Visible 대상 지정
			}
		}

		class Table12 extends JFrame {				//12번 Table의 주문 정보 저장하고 출력하는 class
			JLabel name = new JLabel(t12name);		//예약시 입력했던 이름을 저장하기 위한 JLabel
			JLabel birth = new JLabel(t12birth);	//예약시 입력했던 생년월일을 저장하기 위한 JLabel
			JLabel main = new JLabel(t12main);		//예약시 입력했던 메인 메뉴를 저장하기 위한 JLabel
			JLabel side = new JLabel(t12side);		//예약시 입력했던 사이드 메뉴를 저장하기 위한 JLabel
			JLabel person = new JLabel(t12person);	//예약시 입력했던 방문인원 수를 저장하기 위한 JLabel
			JLabel phone = new JLabel(t12phone);	//예약시 입력했던 전화번호를 저장하기 위한 JLabel
			JLabel num = new JLabel(t12num);		//예약시 입력했던 테이블 번호를 저장하기 위한 JLabel
			JLabel time = new JLabel(t12time);		//예약시 입력했던 방문시간을 저장하기 위한 JLabel

			public Table12() {										//Table12 생성자
				setTitle("Table 12");								//title 지정
				getContentPane();									//현재 작동중인 ContentPane 호출
				setLayout(null);									//절대 경로 배치관리자 설정
				setModal(true);										//모달 설정
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				//각 JLabel의 boundary 설정
				t_name.setBounds(30, 20, 100, 30);
				t_birth.setBounds(30, 60, 100, 30);
				t_main.setBounds(30, 100, 100, 30);
				t_side.setBounds(30, 140, 100, 30);
				t_person.setBounds(30, 180, 100, 30);
				t_phone.setBounds(30, 220, 100, 30);
				t_num.setBounds(30, 260, 100, 30);
				t_time.setBounds(30, 300, 100, 30);

				//각 JLabel의 boundary 설정
				name.setBounds(150, 20, 100, 30);
				birth.setBounds(150, 60, 100, 30);
				main.setBounds(150, 100, 600, 30);
				side.setBounds(150, 140, 600, 30);
				person.setBounds(150, 180, 100, 30);
				phone.setBounds(150, 220, 100, 30);
				num.setBounds(150, 260, 100, 30);
				time.setBounds(150, 300, 100, 30);

				//각 ContentPane을 적용
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
				setSize(600, 400);		//사이즈 지정
				setResizable(false);	//사이즈조절 불가능하게 설정
				setVisible(true);		//Visible 대상 지정
			}
		}

		class ClickAction implements ActionListener { 									//submenu의 주문, 계산, 예약, 취소, table 정보 조회에 대한 작업을 수행하는 class
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Clickbtn1) {										//발생한 event가 주문에 대한 처리일 때
					setModal(false);													//모달리스 설정
					setVisible(false);													//Visible 대상 변경
					fdmenu.setVisible(true);											//fdmenu를 Visible 대상으로 지정
				} 
				else if (e.getSource() == Clickbtn2) {									//발생한 event가 계산에 대한 처리일 때
					setModal(false);													//모달리스 설정
					setVisible(false);													//Visible 대상 변경
					if (select == 1 & lucknum[0] == lucky) {			//1번 Table이 선택되었는데 무료식사에 당첨되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[0] = 0;																	
						System.out.println("1번 테이블에서 무료 식사를 하였습니다.");
						tbtn[0].setText("입석 가능"); 								
						tbtn[0].setBackground(Color.WHITE); 
						tblabel2[0].setText(""); 
						money[0] = 0; 
						for (int i = 0; i < 20; i++) {
							t1money[i] = new JLabel("");
							t1info[i] = "";
							t1price[i] = "";
						}
						event.setVisible(true);								//event를 Visible 대상으로 지정
					} else if (select == 2 & lucknum[1] == lucky) {			//2번 Table이 선택되었는데 무료식사에 당첨되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[1] = 0;	
						System.out.println("2번 테이블에서 무료 식사를 하였습니다.");
						tbtn[1].setText("입석 가능");
						tbtn[1].setBackground(Color.WHITE);
						tblabel2[1].setText("");
						money[1] = 0;
						for (int i = 0; i < 20; i++) {
							t2money[i] = new JLabel("");
							t2info[i] = "";
							t2price[i] = "";
						}
						event.setVisible(true);								//event를 Visible 대상으로 지정
					} else if (select == 3 & lucknum[2] == lucky) {			//3번 Table이 선택되었는데 무료식사에 당첨되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[2] = 0;							
						System.out.println("3번 테이블에서 무료 식사를 하였습니다.");
						tbtn[2].setText("입석 가능");
						tbtn[2].setBackground(Color.WHITE);
						tblabel2[2].setText("");
						money[2] = 0;
						for (int i = 0; i < 20; i++) {
							t3money[i] = new JLabel("");
							t3info[i] = "";
							t3price[i] = "";
						}
						event.setVisible(true);								//event를 Visible 대상으로 지정
					} else if (select == 4 & lucknum[3] == lucky) {			//4번 Table이 선택되었는데 무료식사에 당첨되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[3] = 0;							
						System.out.println("4번 테이블에서 무료 식사를 하였습니다.");
						tbtn[3].setText("입석 가능");
						tbtn[3].setBackground(Color.WHITE);
						tblabel2[3].setText("");
						money[3] = 0;
						for (int i = 0; i < 20; i++) {
							t4money[i] = new JLabel("");
							t4info[i] = "";
							t4price[i] = "";
						}
						event.setVisible(true);								//event를 Visible 대상으로 지정
					} else if (select == 5 & lucknum[4] == lucky) {			//5번 Table이 선택되었는데 무료식사에 당첨되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[4] = 0;							
						System.out.println("5번 테이블에서 무료 식사를 하였습니다.");
						tbtn[4].setText("입석 가능");
						tbtn[4].setBackground(Color.WHITE);
						tblabel2[4].setText("");
						money[4] = 0;
						for (int i = 0; i < 20; i++) {
							t5money[i] = new JLabel("");
							t5info[i] = "";
							t5price[i] = "";
						}
						event.setVisible(true);								//event를 Visible 대상으로 지정
					} else if (select == 6 & lucknum[5] == lucky) {			//6번 Table이 선택되었는데 무료식사에 당첨되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[5] = 0;							
						System.out.println("6번 테이블에서 무료 식사를 하였습니다.");
						tbtn[5].setText("입석 가능");
						tbtn[5].setBackground(Color.WHITE);
						tblabel2[5].setText("");
						money[5] = 0;
						for (int i = 0; i < 20; i++) {
							t6money[i] = new JLabel("");
							t6info[i] = "";
							t6price[i] = "";
						}
						event.setVisible(true);								//event를 Visible 대상으로 지정
					} else if (select == 7 & lucknum[6] == lucky) {			//7번 Table이 선택되었는데 무료식사에 당첨되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[6] = 0;							
						System.out.println("7번 테이블에서 무료 식사를 하였습니다.");
						tbtn[6].setText("입석 가능");
						tbtn[6].setBackground(Color.WHITE);
						tblabel2[6].setText("");
						money[6] = 0;
						for (int i = 0; i < 20; i++) {
							t7money[i] = new JLabel();
							t7info[i] = "";
							t7price[i] = "";
						}
						event.setVisible(true);								//event를 Visible 대상으로 지정
					} else if (select == 8 & lucknum[7] == lucky) {			//8번 Table이 선택되었는데 무료식사에 당첨되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[7] = 0;							
						System.out.println("8번 테이블에서 무료 식사를 하였습니다.");
						tbtn[7].setText("입석 가능");
						tbtn[7].setBackground(Color.WHITE);
						tblabel2[7].setText("");
						money[7] = 0;
						for (int i = 0; i < 20; i++) {
							t8money[i] = new JLabel("");
							t8info[i] = "";
							t8price[i] = "";
						}
						event.setVisible(true);								//event를 Visible 대상으로 지정
					} else if (select == 9 & lucknum[8] == lucky) {			//9번 Table이 선택되었는데 무료식사에 당첨되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[8] = 0;							
						System.out.println("9번 테이블에서 무료 식사를 하였습니다.");
						tbtn[8].setText("입석 가능");
						tbtn[8].setBackground(Color.WHITE);
						tblabel2[8].setText("");
						money[8] = 0;
						for (int i = 0; i < 20; i++) {
							t9money[i] = new JLabel("");
							t9info[i] = "";
							t9price[i] = "";
						}
						event.setVisible(true);								//event를 Visible 대상으로 지정
					} else if (select == 10 & lucknum[9] == lucky) {		//10번 Table이 선택되었는데 무료식사에 당첨되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[9] = 0;							
						System.out.println("10번 테이블에서 무료 식사를 하였습니다.");
						tbtn[9].setText("입석 가능");
						tbtn[9].setBackground(Color.WHITE);
						tblabel2[9].setText("");
						money[9] = 0;
						for (int i = 0; i < 20; i++) {
							t10money[i] = new JLabel("");
							t10info[i] = "";
							t10price[i] = "";
						}
						event.setVisible(true);								//event를 Visible 대상으로 지정
					} else if (select == 11 & lucknum[10] == lucky) {		//11번 Table이 선택되었는데 무료식사에 당첨되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[10] = 0;							
						System.out.println("11번 테이블에서 무료 식사를 하였습니다.");
						tbtn[10].setText("입석 가능");
						tbtn[10].setBackground(Color.WHITE);
						tblabel2[10].setText("");
						money[10] = 0;
						for (int i = 0; i < 20; i++) {
							t11money[i] = new JLabel("");
							t11info[i] = "";
							t11price[i] = "";
						}
						event.setVisible(true);								//event를 Visible 대상으로 지정
					} else if (select == 12 & lucknum[11] == lucky) {		//12번 Table이 선택되었는데 무료식사에 당첨되었을 때 존재하던 데이터를 기본 값으로 초기화
						num[11] = 0;							
						System.out.println("12번 테이블에서 무료 식사를 하였습니다.");
						tbtn[11].setText("입석 가능");
						tbtn[11].setBackground(Color.WHITE);
						tblabel2[11].setText("");
						money[11] = 0;
						for (int i = 0; i < 20; i++) {
							t12money[i] = new JLabel("");
							t12info[i] = "";
							t12price[i] = "";
						}
						event.setVisible(true);								//event를 Visible 대상으로 지정
					} else if (select == 1) {											//1번 Table이 선택되었다면	
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t1info[i]);								//주문한 음식 이름을 출력하기 위해 전달
							t1money[i] = new JLabel(t1price[i]); 						//주문한 음식 값을 출력하기 위해 전달
							t1money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t1money boundary 설정
							pay.add(t1money[i]);										//pay에 t1money 적용
							south2.setText("< 합 계 금 액  > : " + money[0] + " 원입니다."); 	//south2에 표현할 내용 덮어쓰기
						}
						pay.setVisible(true);  											//Pay를 Visible 대상으로 지정
					} else if (select == 2) {											//2번 Table이 선택되었다면	
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t2info[i]);								//주문한 음식 이름을 출력하기 위해 전달
							t2money[i] = new JLabel(t2price[i]); 						//주문한 음식 값을 출력하기 위해 전달
							t2money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t2money boundary 설정
							pay.add(t2money[i]);										//pay에 t2money 적용
							south2.setText("< 합 계 금 액  > : " + money[1] + " 원입니다."); 	//south2에 표현할 내용 덮어쓰기
						}
						pay.setVisible(true);  											//Pay를 Visible 대상으로 지정
					} else if (select == 3) {											//3번 Table이 선택되었다면		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t3info[i]);								//주문한 음식 이름을 출력하기 위해 전달
							t3money[i] = new JLabel(t3price[i]); 						//주문한 음식 값을 출력하기 위해 전달
							t3money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t3money boundary 설정
							pay.add(t3money[i]);										//pay에 t3money 적용
							south2.setText("< 합 계 금 액  > : " + money[2] + " 원입니다."); 	//south2에 표현할 내용 덮어쓰기
						}
						pay.setVisible(true);  											//Pay를 Visible 대상으로 지정
					} else if (select == 4) {											//4번 Table이 선택되었다면		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t4info[i]);								//주문한 음식 이름을 출력하기 위해 전달
							t4money[i] = new JLabel(t4price[i]); 						//주문한 음식 값을 출력하기 위해 전달
							t4money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t4money boundary 설정
							pay.add(t4money[i]);										//pay에 t4money 적용
							south2.setText("< 합 계 금 액  > : " + money[3] + " 원입니다."); 	//south2에 표현할 내용 덮어쓰기
						}
						pay.setVisible(true);  											//Pay를 Visible 대상으로 지정
					} else if (select == 5) {											//5번 Table이 선택되었다면	
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t5info[i]);								//주문한 음식 이름을 출력하기 위해 전달
							t5money[i] = new JLabel(t5price[i]); 						//주문한 음식 값을 출력하기 위해 전달
							t5money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t5money boundary 설정
							pay.add(t5money[i]);										//pay에 t5money 적용
							south2.setText("< 합 계 금 액  > : " + money[4] + " 원입니다."); 	//south2에 표현할 내용 덮어쓰기
						}
						pay.setVisible(true);  											//Pay를 Visible 대상으로 지정
					} else if (select == 6) {											//6번 Table이 선택되었다면		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t6info[i]);								//주문한 음식 이름을 출력하기 위해 전달
							t6money[i] = new JLabel(t6price[i]); 						//주문한 음식 값을 출력하기 위해 전달
							t6money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t6money boundary 설정
							pay.add(t6money[i]);										//pay에 t6money 적용
							south2.setText("< 합 계 금 액  > : " + money[5] + " 원입니다."); 	//south2에 표현할 내용 덮어쓰기
						}
						pay.setVisible(true);  											//Pay를 Visible 대상으로 지정
					} else if (select == 7) {											//7번 Table이 선택되었다면		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t7info[i]);								//주문한 음식 이름을 출력하기 위해 전달
							t7money[i] = new JLabel(t7price[i]); 						//주문한 음식 값을 출력하기 위해 전달
							t7money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t7money boundary 설정
							pay.add(t7money[i]);										//pay에 t7money 적용
							south2.setText("< 합 계 금 액  > : " + money[6] + " 원입니다."); 	//south2에 표현할 내용 덮어쓰기
						}
						pay.setVisible(true);  											//Pay를 Visible 대상으로 지정
					} else if (select == 8) {											//8번 Table이 선택되었다면	
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t8info[i]);								//주문한 음식 이름을 출력하기 위해 전달
							t8money[i] = new JLabel(t8price[i]); 						//주문한 음식 값을 출력하기 위해 전달
							t8money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t8money boundary 설정
							pay.add(t8money[i]);										//pay에 t8money 적용
							south2.setText("< 합 계 금 액  > : " + money[7] + " 원입니다."); 	//south2에 표현할 내용 덮어쓰기
						}
						pay.setVisible(true);  											//Pay를 Visible 대상으로 지정
					} else if (select == 9) {											//9번 Table이 선택되었다면		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t9info[i]);								//주문한 음식 이름을 출력하기 위해 전달
							t9money[i] = new JLabel(t9price[i]); 						//주문한 음식 값을 출력하기 위해 전달
							t9money[i].setBounds(195, 40 + (i * 30), 100, 25); 			//t9money boundary 설정
							pay.add(t9money[i]);										//pay에 t9money 적용
							south2.setText("< 합 계 금 액  > : " + money[8] + " 원입니다."); 	//south2에 표현할 내용 덮어쓰기
						}
						pay.setVisible(true);  											//Pay를 Visible 대상으로 지정
					} else if (select == 10) {											//10번 Table이 선택되었다면		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t10info[i]);							//주문한 음식 이름을 출력하기 위해 전달
							t10money[i] = new JLabel(t10price[i]); 						//주문한 음식 값을 출력하기 위해 전달
							t10money[i].setBounds(195, 40 + (i * 30), 100, 25); 		//t10money boundary 설정
							pay.add(t10money[i]);										//pay에 t10money 적용
							south2.setText("< 합 계 금 액  > : " + money[9] + " 원입니다."); 	//south2에 표현할 내용 덮어쓰기
						}
						pay.setVisible(true);  											//Pay를 Visible 대상으로 지정
					} else if (select == 11) {											//11번 Table이 선택되었다면	
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t11info[i]);							//주문한 음식 이름을 출력하기 위해 전달
							t11money[i] = new JLabel(t11price[i]); 						//주문한 음식 값을 출력하기 위해 전달
							t11money[i].setBounds(195, 40 + (i * 30), 100, 25); 		//t11money boundary 설정
							pay.add(t11money[i]);										//pay에 t11money 적용
							south2.setText("< 합 계 금 액  > : " + money[10] + " 원입니다."); 	//south2에 표현할 내용 덮어쓰기
						}
						pay.setVisible(true);  											//Pay를 Visible 대상으로 지정
					} else if (select == 12) {											//12번 Table이 선택되었다면		
						for (int i = 0; i < 20; i++) {
							foodinfo[i].setText(t12info[i]);							//주문한 음식 이름을 출력하기 위해 전달
							t12money[i] = new JLabel(t12price[i]); 						//주문한 음식 값을 출력하기 위해 전달
							t12money[i].setBounds(195, 40 + (i * 30), 100, 25); 		//t12money boundary 설정
							pay.add(t12money[i]);										//pay에 t12money 적용
							south2.setText("< 합 계 금 액  > : " + money[11] + " 원입니다."); 	//south2에 표현할 내용 덮어쓰기
						}
						pay.setVisible(true);  											//Pay를 Visible 대상으로 지정
					} 
				} else if (e.getSource() == Clickbtn3) { 								//발생한 event가 예약에 대한 처리일 때	
					setModal(false);													//모달리스 설정
					setVisible(false);													//Visible 대상 변경
					int result = JOptionPane.showConfirmDialog(null, "예약하시겠습니까 ?", 	//예약여부를 재확인하기 위한 confirmDialog
							"Confirm", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) { 		//confirmDialog에서 Yes를 선택했을 때
						setVisible(false);							//Visible 대상 변경
						//Reservation에 필요한 정보를 입력받을 때 필요한 JTextField 초기화
						namefield.setText("");						
						birthfield.setText("");
						man.setSelected(false);
						hpfield1.setText("");
						hpfield2.setText("");
						hpfield3.setText("");
						reser.setVisible(true);
					}					
				} else if (e.getSource() == Clickbtn4) {		//발생한 event가 취소에 대한 처리일 때
					setVisible(false);							//Visible 대상 변경
					
					for (int i = 0; i < 20; i++)
						foodinfo[i].setText("");				//foodinfo 초기화
					
					if (select == 1) {							//1번 Table이 선택되었다면 존재하던 데이터를 기본 값으로 초기화
						num[0] = 0;
						tbtn[0].setText("입석 가능");
						tbtn[0].setBackground(Color.WHITE);
						tblabel2[0].setText("");
						money[0] = 0;
						for (int i = 0; i < 20; i++) {
							t1money[i].setText("");
							t1info[i] = "";
							t1price[i] = "";
						}
					}else if (select == 2) {					//2번 Table이 선택되었다면 존재하던 데이터를 기본 값으로 초기화
						num[1] = 0;
						tbtn[1].setText("입석 가능");
						tbtn[1].setBackground(Color.WHITE);
						tblabel2[1].setText("");
						money[1] = 0;
						for (int i = 0; i < 20; i++) {
							t2money[i].setText("");
							t2info[i] = "";
							t2price[i] = "";
						}
					}else if (select == 3) {					//3번 Table이 선택되었다면 존재하던 데이터를 기본 값으로 초기화
						num[2] = 0;
						tbtn[2].setText("입석 가능");
						tbtn[2].setBackground(Color.WHITE);
						tblabel2[2].setText("");
						money[2] = 0;
						for (int i = 0; i < 20; i++) {
							t3money[i].setText("");
							t3info[i] = "";
							t3price[i] = "";
						}
					}else if (select == 4) {					//4번 Table이 선택되었다면 존재하던 데이터를 기본 값으로 초기화
						num[3] = 0;
						tbtn[3].setText("입석 가능");
						tbtn[3].setBackground(Color.WHITE);
						tblabel2[3].setText("");
						money[3] = 0;
						for (int i = 0; i < 20; i++) {
							t4money[i].setText("");
							t4info[i] = "";
							t4price[i] = "";
						}
					}else if (select == 5) {					//5번 Table이 선택되었다면 존재하던 데이터를 기본 값으로 초기화
						num[4] = 0;
						tbtn[4].setText("입석 가능");
						tbtn[4].setBackground(Color.WHITE);
						tblabel2[4].setText("");
						money[4] = 0;
						for (int i = 0; i < 20; i++) {
							t5money[i].setText("");
							t5info[i] = "";
							t5price[i] = "";
						}
					}else if (select == 6) {					//6번 Table이 선택되었다면 존재하던 데이터를 기본 값으로 초기화
						num[5] = 0;
						tbtn[5].setText("입석 가능");
						tbtn[5].setBackground(Color.WHITE);
						tblabel2[5].setText("");
						money[5] = 0;
						for (int i = 0; i < 20; i++) {
							t6money[i].setText("");
							t6info[i] = "";
							t6price[i] = "";
						}
					} else if (select == 7) {					//7번 Table이 선택되었다면 존재하던 데이터를 기본 값으로 초기화
						num[6] = 7;
						tbtn[6].setText("입석 가능");
						tbtn[6].setBackground(Color.WHITE);
						tblabel2[6].setText("");
						money[6] = 0;
						for (int i = 0; i < 20; i++) {
							t7money[i].setText("");
							t7info[i] = "";
							t7price[i] = "";
						}
					} else if (select == 8) {					//8번 Table이 선택되었다면 존재하던 데이터를 기본 값으로 초기화
						num[7] = 0;
						tbtn[7].setText("입석 가능");
						tbtn[7].setBackground(Color.WHITE);
						tblabel2[7].setText("");
						money[7] = 0;
						for (int i = 0; i < 20; i++) {
							t8money[i].setText("");
							t8info[i] = "";
							t8price[i] = "";
						}
					} else if (select == 9) {					//9번 Table이 선택되었다면 존재하던 데이터를 기본 값으로 초기화
						num[8] = 0;
						tbtn[8].setText("입석 가능");
						tbtn[8].setBackground(Color.WHITE);
						tblabel2[8].setText("");
						money[8] = 0;
						for (int i = 0; i < 20; i++) {
							t9money[i].setText("");
							t9info[i] = "";
							t9price[i] = "";
						}
					} else if (select == 10) {					//10번 Table이 선택되었다면 존재하던 데이터를 기본 값으로 초기화
						num[9] = 10;
						tbtn[9].setText("입석 가능");
						tbtn[9].setBackground(Color.WHITE);
						tblabel2[9].setText("");
						money[9] = 0;
						for (int i = 0; i < 20; i++) {
							t10money[i].setText("");
							t10info[i] = "";
							t10price[i] = "";
						}
					} else if (select == 11) {					//11번 Table이 선택되었다면 존재하던 데이터를 기본 값으로 초기화
						num[10] = 0;
						tbtn[10].setText("입석 가능");
						tbtn[10].setBackground(Color.WHITE);
						tblabel2[10].setText("");
						money[10] = 0;
						for (int i = 0; i < 20; i++) {
							t11money[i].setText("");
							t11info[i] = "";
							t11price[i] = "";
						}
					} else if (select == 12) {					//12번 Table이 선택되었다면 존재하던 데이터를 기본 값으로 초기화
						num[11] = 0;
						tbtn[11].setText("입석 가능");
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
				if (e.getSource() == tbinfo) {								//발생한 event가 table 정보 조회에 대한 처리일 때
					if (select == 1) {										//1번 Table이 선택되었다면
						if (tbtn[0].getBackground() == Color.YELLOW)		//예약되어 있는 경우에는
							new Table1();									//예약정보를 보여주기 위해 Table1 생성자 호출
						else if (tbtn[0].getBackground() == Color.GREEN)	//주문되어 있는 경우에는
							new OrderInfo();								//주문정보를 보여주기 위해 OrderInfo 생성자 호출
					} else if (select == 2) {								//2번 Table이 선택되었다면
						if (tbtn[1].getBackground() == Color.YELLOW)		//예약되어 있는 경우에는
							new Table2();									//예약정보를 보여주기 위해 Table2 생성자 호출
						else if (tbtn[1].getBackground() == Color.GREEN)	//주문되어 있는 경우에는
							new OrderInfo();								//주문정보를 보여주기 위해 OrderInfo 생성자 호출
					} else if (select == 3) {								//3번 Table이 선택되었다면
						if (tbtn[2].getBackground() == Color.YELLOW)		//예약되어 있는 경우에는
							new Table3();									//예약정보를 보여주기 위해 Table3 생성자 호출
						else if (tbtn[2].getBackground() == Color.GREEN)	//주문되어 있는 경우에는
							new OrderInfo();								//주문정보를 보여주기 위해 OrderInfo 생성자 호출
					} else if (select == 4) {								//4번 Table이 선택되었다면
						if (tbtn[3].getBackground() == Color.YELLOW)		//예약되어 있는 경우에는
							new Table4();									//예약정보를 보여주기 위해 Table4 생성자 호출
						else if (tbtn[3].getBackground() == Color.GREEN)	//주문되어 있는 경우에는
							new OrderInfo();								//주문정보를 보여주기 위해 OrderInfo 생성자 호출
					} else if (select == 5) {								//5번 Table이 선택되었다면
						if (tbtn[4].getBackground() == Color.YELLOW)		//예약되어 있는 경우에는
							new Table5();									//예약정보를 보여주기 위해 Table5 생성자 호출
						else if (tbtn[4].getBackground() == Color.GREEN)	//주문되어 있는 경우에는
							new OrderInfo();								//주문정보를 보여주기 위해 OrderInfo 생성자 호출
					} else if (select == 6) {								//6번 Table이 선택되었다면
						if (tbtn[5].getBackground() == Color.YELLOW)		//예약되어 있는 경우에는
							new Table6();									//예약정보를 보여주기 위해 Table6 생성자 호출
						else if (tbtn[5].getBackground() == Color.GREEN)	//주문되어 있는 경우에는
							new OrderInfo();								//주문정보를 보여주기 위해 OrderInfo 생성자 호출
					} else if (select == 7) {								//7번 Table이 선택되었다면
						if (tbtn[6].getBackground() == Color.YELLOW)		//예약되어 있는 경우에는
							new Table7();									//예약정보를 보여주기 위해 Table7 생성자 호출
						else if (tbtn[6].getBackground() == Color.GREEN)	//주문되어 있는 경우에는
							new OrderInfo();								//주문정보를 보여주기 위해 OrderInfo 생성자 호출
					} else if (select == 8) {								//8번 Table이 선택되었다면
						if (tbtn[7].getBackground() == Color.YELLOW)		//예약되어 있는 경우에는
							new Table8();									//예약정보를 보여주기 위해 Table8 생성자 호출
						else if (tbtn[7].getBackground() == Color.GREEN)	//주문되어 있는 경우에는
							new OrderInfo();								//주문정보를 보여주기 위해 OrderInfo 생성자 호출
					} else if (select == 9) {								//9번 Table이 선택되었다면
						if (tbtn[8].getBackground() == Color.YELLOW)		//예약되어 있는 경우에는
							new Table9();									//예약정보를 보여주기 위해 Table9 생성자 호출
						else if (tbtn[8].getBackground() == Color.GREEN)	//주문되어 있는 경우에는
							new OrderInfo();								//주문정보를 보여주기 위해 OrderInfo 생성자 호출
					} else if (select == 10) {								//10번 Table이 선택되었다면
						if (tbtn[9].getBackground() == Color.YELLOW)		//예약되어 있는 경우에는
							new Table10();									//예약정보를 보여주기 위해 Table10 생성자 호출
						else if (tbtn[9].getBackground() == Color.GREEN)	//주문되어 있는 경우에는
							new OrderInfo();								//주문정보를 보여주기 위해 OrderInfo 생성자 호출
					} else if (select == 11) {								//11번 Table이 선택되었다면
						if (tbtn[10].getBackground() == Color.YELLOW)		//예약되어 있는 경우에는
							new Table11();									//예약정보를 보여주기 위해 Table11 생성자 호출
						else if (tbtn[10].getBackground() == Color.GREEN)	//주문되어 있는 경우에는
							new OrderInfo();								//주문정보를 보여주기 위해 OrderInfo 생성자 호출
					} else if (select == 12) {								//12번 Table이 선택되었다면
						if (tbtn[11].getBackground() == Color.YELLOW)		//예약되어 있는 경우에는
							new Table12();									//예약정보를 보여주기 위해 Table12 생성자 호출
						else if (tbtn[11].getBackground() == Color.GREEN)	//주문되어 있는 경우에는
							new OrderInfo();								//주문정보를 보여주기 위해 OrderInfo 생성자 호출
					}
				}
			}
		}
	}

	class CurrentTime implements Runnable {												//현재시간을 출력하거나 주문할 당시 시간을 표시할 때 해당 시간을 전달하는 class
		int n = 0;																		//:의 깜빡거리를 지정해주기 위한 변수
		public void run() {																//Runnable 인터페이스의 run 메소드 오버라이딩
			while (true) {
				Date dt = new Date();													//현재 날짜와 시간이 저장된 객체를 생성하기 위해 Date 생성자 호출
				//각각 다른 필요한 형태로 형식 지정
				SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				SimpleDateFormat nowtime2 = new SimpleDateFormat("yyyy - MM - dd");
				SimpleDateFormat nowtime3;
				if (n % 2 == 1)															//if문이 성립될때만 :이 나타나게 설정
					nowtime3 = new SimpleDateFormat("a hh:mm");
				else
					nowtime3 = new SimpleDateFormat("a hh mm");
				SimpleDateFormat nowtime4 = new SimpleDateFormat("MMddhhmmss");
				
				//각각 필요한 변수에 변형된 형태를 저장
				ran = Integer.parseInt(nowtime4.format(dt));
				nowDate = nowtime.format(dt);
				timelabel1.setText(nowtime2.format(dt));
				timelabel2.setText(nowtime3.format(dt));
				n++;
				try {
					Thread.sleep(500);													//thread를 0.5초동안 sleep 처리
				} catch (InterruptedException e) {										//InterruptedException 예외 처리
					return;
				}
			}
		}
	}
	
	class MyThread implements Runnable {							//main 하단에 색이 바뀌면서 이동하는 문구를 출력하는 class
		int m = 1200;												//문구의 x좌표를 지정해주기 위한 변수
		int a = 30, b = 30, c = 30, d = 0;							//문구의 색을 정해진 패턴에 의해 바뀌도록 하기 위한 변수
		public void run() {											//Runnable 인터페이스의 run 메소드 오버라이딩
			while (true) {
				welcome.setBounds(m, 700, 50000, 40);				//welcome boundary 설정
				m--;
				//d의 값에 따라 rgb값을 a,b,c로 지정하여 일정한 패턴에 의해 색이 변하도록 설정
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
					Thread.sleep(5);					//thread를 0.005초동안 sleep 처리
				} catch (InterruptedException e) {		//InterruptedException 예외 처리
					return;
				}
			}
		}
	}
	
	class Event extends JDialog {									//무료식사에 당첨되었을 경우를 처리하는 class
		Event() {													//Event 생성자
			setTitle("Event 당첨!");									//title 지정
			getContentPane();										//현재 작동중인 ContentPane 호출
			setModal(true);											//모달 설정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setSize(700, 500);										//사이즈 지정
			setVisible(false);										//Visible 대상 변경
		}
		public void paint(Graphics g) { 								
			Image img = images.eventimg().getImage();				//event 당첨사실을 표현하기 위한 image를 사용하기 위해 eventimg 생성자 호출 
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);	//img를 graphics처리를 통해 image로 표현
		}
	}
	
	class Reservation extends JDialog { 							//Reservation에 관련된 처리를 하는 class
		Reservation() {												//Reservation 생성자
			setTitle("통합 예약 시스템");								//title 지정
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//VIP와 관련된 처리를 하기 위한 JMenuItem
			mn1 = new JMenuItem("VIP 1");  											
			mn2 = new JMenuItem("VIP 2"); 				
			mn3 = new JMenuItem("VIP 3"); 				
			mn4 = new JMenuItem("VIP 4"); 				
			mn5 = new JMenuItem("초기화 "); 				
			mn6 = new JMenuItem("Close"); 				

			//menu에 각 menu item을 적용
			menu.add(mn1); 				
			menu.add(mn2); 				
			menu.add(mn3); 				
			menu.add(mn4); 				
			menu.add(mn5); 				
			menu.add(mn6); 			
			menubar.add(menu);			//menubar에 menu 적용 				
			setJMenuBar(menubar); 		//menubar를 JMenubar로 적용
			
			//각 menu item에 ActionListener를 적용
			mn1.addActionListener(new MyActionListener()); 				
			mn2.addActionListener(new MyActionListener()); 				
			mn3.addActionListener(new MyActionListener()); 				
			mn4.addActionListener(new MyActionListener()); 				
			mn5.addActionListener(new MyActionListener()); 				
			mn6.addActionListener(new MyActionListener()); 				
			menu.addActionListener(new MyActionListener()); 			

			contentpane = getContentPane();						//현재 작동중인 ContentPane 호출
			contentpane.setLayout(new BorderLayout());			//BorderLayout 배치관리자 설정
			
			//BorderLayout 각각의 area에 panel 적용
			add(new SouthPanel(), BorderLayout.SOUTH);
			add(new NorthPanel(), BorderLayout.NORTH);
			add(new CenterPanel(), BorderLayout.CENTER);

			setSize(420, 600);			//사이즈 지정
			setLocation(1365, 100);		//위치 지정
			setResizable(false);		//사이즈조절 불가능하게 설정
			setVisible(false);			//Visible 대상 변경
			la.setFocusable(true);		//포커스를 지정할 수 있도록 설정
			la.requestFocus();			//포커스 요청
		}

		class SouthPanel extends JPanel {								//Reservation 과정에 필요한 예약, 예약취소를 처리하는 class
			SouthPanel() {												//SouthPanel 생성자
				getContentPane();										//현재 작동중인 ContentPane 호출
				setBackground(Color.LIGHT_GRAY);						//배경색 설정

				ok = new JButton("예약", images.yesimg());				//yes image를 활용하여 예약을 시각적으로 표현하는 JButton
				ok.addActionListener(new MyActionListener());			//ok에 ActionListener 적용
				add(ok);												//ok 적용
				cancel = new JButton("예약취소", images.noimg());			//no image를 활용하여 예약취소를 시각적으로 표현하는 JButton
				cancel.addActionListener(new MyActionListener()); 		//cancel에 ActionListener 적용
				add(cancel);											//cancel 적용
			}
		}

		class NorthPanel extends JPanel {								//Reservation 과정에 출력되는 문구에 대한 event를 처리하는 class
			NorthPanel() {												//NorthPanel 생성자
				getContentPane();										//현재 작동중인 ContentPane 호출
				add(la);												//la 적용
				la.addMouseMotionListener(new MyMouseAdapter());		//la에 MouseMotionListener 적용
			}
		}

		class CenterPanel extends JPanel {								//Reservation 과정에 필요한 정보를 입력받는 class
			public CenterPanel() {										//CenterPanel 생성자
				getContentPane();										//현재 작동중인 ContentPane 호출
				setLayout(null);										//절대 경로 배치관리자 설정
				setBackground(Color.WHITE);								//배경색 지정	

				//reservation 과정에 필요한 정보를 입력받기 위한 JLabel
				manofwoman = new JLabel();
				myperson = new JLabel();
				name = new JLabel("이 름");
				birth = new JLabel("생년월일");
				mainmenu = new JLabel("MAIN DISH");
				sidemenu = new JLabel("SIDE DISH");
				person = new JLabel("성 별");
				phone = new JLabel("휴대폰");
				time = new JLabel("방문시간");
				sum = new JLabel("인원수");
				led = new JLabel("성별을 선택해주세요.");
				ttable = new JLabel("Table");
				man = new JRadioButton("남자"); 						
				woman = new JCheckBox("여자"); 

				//reservation 과정에 필요한 정보를 입력받기 위한 JLabel의 폰트 설정
				name.setFont(new Font("고딕체", Font.BOLD, 15));
				birth.setFont(new Font("고딕체", Font.BOLD, 15));
				phone.setFont(new Font("고딕체", Font.BOLD, 15));
				mainmenu.setFont(new Font("고딕체", Font.BOLD, 15));
				sidemenu.setFont(new Font("고딕체", Font.BOLD, 15));
				person.setFont(new Font("고딕체", Font.BOLD, 15));
				time.setFont(new Font("고딕체", Font.BOLD, 15));
				sum.setFont(new Font("고딕체", Font.BOLD, 15));
				led.setFont(new Font("고딕체", Font.BOLD, 15));
				ttable.setFont(new Font("고딕체", Font.BOLD, 15)); 
				man.setFont(new Font("", Font.BOLD, 12));
				woman.setFont(new Font("", Font.BOLD, 12));
				
				g = new ButtonGroup();								//하나의 처리 과정으로 지정하기 위해 필요한 ButtonGroup
				g.add(man);											//ButtonGroup에 man 추가
				g.add(woman);										//ButtonGroup에 woman 추가
				
				man.addItemListener(new MyItemListener());			//man에 ItemListener 적용
				woman.addItemListener(new MyItemListener());		//woman에 ItemListener 적용

				//reservation 과정에 필요한 정보를 입력받기 위한 JTextField, JLabel, JComboBox
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
	
				//각각의 JTextField, JLabel, JComboBox에 ActionListener 적용
				namefield.addActionListener(new MyActionListener());
				birthfield.addActionListener(new MyActionListener());
				hpfield3.addActionListener(new MyActionListener());
				combox.addActionListener(new MyActionListener()); 
				mainbox.addActionListener(new MyActionListener()); 
				sidebox.addActionListener(new MyActionListener()); 

				man.setBackground(Color.WHITE);							//man의 배경색 설정
				woman.setBackground(Color.WHITE);						//woman의 배경색 설정
				
				//각각의 JTextField, JLabel, JComboBox Boundary 설정
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

				//각 ContentPane을 적용
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
				
				namefield.setFocusable(true);		//포커스를 지정할 수 있도록 설정	
				namefield.requestFocus();			//포커스 요청
				birthfield.setFocusable(true);		//포커스를 지정할 수 있도록 설정	
				birthfield.requestFocus();			//포커스 요청
				hpfield3.setFocusable(true);		//포커스를 지정할 수 있도록 설정	
				hpfield3.requestFocus();			//포커스 요청
			}
		}

		class MyActionListener implements ActionListener { 			//Reservation 과정에서 필요한 event를 처리하는 class
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == namefield){	 					//발생한 event가 namefield에서 일 때
					System.out.println(namefield.getText()); 		//namefield에 입력된 값을 출력
					namefield.setVisible(false);					//namefield Visible 대상 변경
				}
				if(e.getSource() == birthfield){					//발생한 event가 birthfield에서 일 때
					System.out.println(birthfield.getText());		//birthfield에 입력된 값을 출력
					birthfield.setVisible(false);					//birthfield Visible 대상 변경
				}
				if(e.getSource() == hpfield3){														//발생한 event가 hpfield3에서 일 때
					System.out.println(hpfield1.getText()+hpfield2.getText()+hpfield3.getText());	//hpfield에 입력된 값을 출력
					hpfield1.setVisible(false); 													//hpfield1 Visible 대상 변경
					hpfield2.setVisible(false); 													//hpfield2 Visible 대상 변경
					hpfield2.setVisible(false); 													//hpfield3 Visible 대상 변경
				}

				if (e.getSource() == mn1) { 						//발생한 event가 mn1에서 일 때
					Stringindex = 0;								//Stringindex 초기화
					Scanner sc = null;								//scanner 초기화
					try {
						sc = new Scanner(texts.vip1()); 			//VIP 1의 정보를 scan
					} catch (FileNotFoundException e1) {			//FileNotFoundException 예외 처리
						e1.printStackTrace();
					}
					
					while (sc.hasNext()) {							//파일의 끝에 도달할때까지 반복
						Stringtxt[Stringindex] = sc.nextLine();		//Stringindex를 증가시키면서 순서대로 Stringtxt에 저장
						Stringindex++;
					}
					led.setOpaque(true);							//led에 불투명 설정
					woman.setSelected(true);						//여자로 설정
					namefield.setText(Stringtxt[0]);				//파일에서 불러온 문자열을 namefield에 저장시킵니다
					birthfield.setText(Stringtxt[1]);				//파일에서 불러온 문자열을 birthfield에 저장시킵니다
					hpfield1.setText(Stringtxt[2]);					//파일에서 불러온 문자열을 hpfield1에 저장시킵니다
					hpfield2.setText(Stringtxt[3]);					//파일에서 불러온 문자열을 hpfield2에 저장시킵니다
					hpfield3.setText(Stringtxt[4]);					//파일에서 불러온 문자열을 hpfield3에 저장시킵니다
					man.setSelected(true);
				} else if (e.getSource() == mn2) { 					//발생한 event가 mn2에서 일 때
					Stringindex = 0;								//Stringindex 초기화
					try {
						sc = new Scanner(texts.vip2()); 			//VIP 2의 정보를 scan
					} catch (FileNotFoundException e1) {			//FileNotFoundException 예외 처리
						e1.printStackTrace();
					}
					while (sc.hasNext()) {							//파일의 끝에 도달할때까지 반복
						Stringtxt[Stringindex] = sc.nextLine();		//Stringindex를 증가시키면서 순서대로 Stringtxt에 저장
						Stringindex++;
					}
					led.setOpaque(true);							//led에 불투명 설정
					man.setSelected(true);							//남자로 설정
					namefield.setText(Stringtxt[0]);				//파일에서 불러온 문자열을 namefield에 저장시킵니다
					birthfield.setText(Stringtxt[1]);				//파일에서 불러온 문자열을 birthfield에 저장시킵니다
					hpfield1.setText(Stringtxt[2]);					//파일에서 불러온 문자열을 hpfield1에 저장시킵니다
					hpfield2.setText(Stringtxt[3]);					//파일에서 불러온 문자열을 hpfield2에 저장시킵니다
					hpfield3.setText(Stringtxt[4]);					//파일에서 불러온 문자열을 hpfield3에 저장시킵니다
				} else if (e.getSource() == mn3) { 					//발생한 event가 mn3에서 일 때
					Stringindex = 0;								//Stringindex 초기화
					try {
						sc = new Scanner(texts.vip3()); 			//VIP 3의 정보를 scan
					} catch (FileNotFoundException e1) {			//FileNotFoundException 예외 처리
						e1.printStackTrace();
					}
					while (sc.hasNext()) {							//파일의 끝에 도달할때까지 반복
						Stringtxt[Stringindex] = sc.nextLine();		//Stringindex를 증가시키면서 순서대로 Stringtxt에 저장
						Stringindex++;
					}
					led.setOpaque(true);							//led에 불투명 설정
					woman.setSelected(true);						//여자로 설정
					namefield.setText(Stringtxt[0]);				//파일에서 불러온 문자열을 namefield에 저장시킵니다
					birthfield.setText(Stringtxt[1]);				//파일에서 불러온 문자열을 birthfield에 저장시킵니다
					hpfield1.setText(Stringtxt[2]);					//파일에서 불러온 문자열을 hpfield1에 저장시킵니다
					hpfield2.setText(Stringtxt[3]);					//파일에서 불러온 문자열을 hpfield2에 저장시킵니다
					hpfield3.setText(Stringtxt[4]);					//파일에서 불러온 문자열을 hpfield3에 저장시킵니다
				} else if (e.getSource() == mn4) { 					//발생한 event가 mn4에서 일 때
					Stringindex = 0;								//Stringindex 초기화
					try {
						sc = new Scanner(texts.vip4()); 			//VIP 4의 정보를 scan
					} catch (FileNotFoundException e1) {			//FileNotFoundException 예외 처리
						e1.printStackTrace();
					}
					while (sc.hasNext()) {							//파일의 끝에 도달할때까지 반복
						Stringtxt[Stringindex] = sc.nextLine();		//Stringindex를 증가시키면서 순서대로 Stringtxt에 저장
						Stringindex++;
					}
					led.setOpaque(true);							//led에 불투명 설정
					man.setSelected(true);							//남자로 설정
					namefield.setText(Stringtxt[0]);				//파일에서 불러온 문자열을 namefield에 저장시킵니다
					birthfield.setText(Stringtxt[1]);				//파일에서 불러온 문자열을 birthfield에 저장시킵니다
					hpfield1.setText(Stringtxt[2]);					//파일에서 불러온 문자열을 hpfield1에 저장시킵니다
					hpfield2.setText(Stringtxt[3]);					//파일에서 불러온 문자열을 hpfield2에 저장시킵니다
					hpfield3.setText(Stringtxt[4]);					//파일에서 불러온 문자열을 hpfield3에 저장시킵니다
				} else if (e.getSource() == mn5) { 		//발생한 event가 mn5에서 일 때 기존에 저장되어 있던 데이터 초기화
					namefield.setText("");				
					birthfield.setText("");				
					man.setSelected(false);				
					hpfield1.setText("");			
					hpfield2.setText("");			
					hpfield3.setText("");			
				} else if (e.getSource() == mn6 || e.getSource() == cancel) { 	//발생한 event가 mn6에서 이거나 cancel에서 일 때 기존에 저장되어 있는 데이터 초기화
					reser.setVisible(false);
					namefield.setText("");
					birthfield.setText("");
					man.setSelected(false);
					hpfield1.setText("");
					hpfield2.setText("");
					hpfield3.setText("");
				}
				if (e.getSource() == mainbox) { 										//발생한 event가 mainbox에서 일 때							
					int result = JOptionPane.showConfirmDialog(null, "고르시겠습니까 ?", 	//선택을 재확인하기 위한 confirmDialog 
							"", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {								//confirmDialog에서 Yes를 선택했을 때
						String b = (String) mainbox.getSelectedItem();  				//고른 메뉴를 String 변수에 저장
						if (!mainbox.getSelectedItem().equals("Main Select")) { 		//고른 메뉴가 default값이 아니라면 주문 처리
							info[numm] = b; 
							numm++;   	
							System.out.println(b);
						}
					}
				} 
				if (e.getSource() == sidebox) {											//발생한 event가 sidebox에서 일 때
					int result = JOptionPane.showConfirmDialog(null, "고르시겠습니까 ?", 	//선택을 재확인하기 위한 confirmDialog
							"", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {								//confirmDialog에서 Yes를 선택했을 때
						String b = (String) sidebox.getSelectedItem();  				//고른 메뉴를 String 변수에 저장
						if (!sidebox.getSelectedItem().equals("Side Select")) { 		//고른 메뉴가 default값이 아니라면 주문 처리
							info2[numm2] = b;	
							numm2++;  
							System.out.println(b);
						}
					}
				}
				if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 1번  ")) { 	//발생한 event가 ok에서 이고 tablebox의 값이 1번일 때
					if (tbtn[0].getBackground() == Color.YELLOW) {							//중복으로 예약함을 방지
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.",				//중복으로 예약을 시도함을 알려주기 위한 MessageDialog
								"", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[0].setForeground(Color.GREEN);														//tbtn 색 설정
						tbtn[0].setBackground(Color.YELLOW);													//tbtn 배경색 설정
						tbtn[0].setText("<예약> " + namefield.getText());											//tbtn에 예약상태 출력
						//예약 당시 입력했던 정보를 해당 table로 전달
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
						setVisible(false);																		//Visible 대상 변경
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 2번  ")) { 	//발생한 event가 ok에서 이고 tablebox의 값이 2번일 때
					if (tbtn[1].getBackground() == Color.YELLOW) {								//중복으로 예약함을 방지
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.", 				//중복으로 예약을 시도함을 알려주기 위한 MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[1].setForeground(Color.GREEN);														//tbtn 색 설정
						tbtn[1].setBackground(Color.YELLOW);													//tbtn 배경색 설정
						tbtn[1].setText("<예약> " + namefield.getText());											//tbtn에 예약상태 출력
						//예약 당시 입력했던 정보를 해당 table로 전달
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
						setVisible(false);																		//Visible 대상 변경
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 3번  ")) { 	//발생한 event가 ok에서 이고 tablebox의 값이 3번일 때
					if (tbtn[2].getBackground() == Color.YELLOW) {								//중복으로 예약함을 방지
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.", 				//중복으로 예약을 시도함을 알려주기 위한 MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[2].setForeground(Color.GREEN);														//tbtn 색 설정
						tbtn[2].setBackground(Color.YELLOW);													//tbtn 배경색 설정
						tbtn[2].setText("<예약> " + namefield.getText());											//tbtn에 예약상태 출력
						//예약 당시 입력했던 정보를 해당 table로 전달
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
						setVisible(false);																		//Visible 대상 변경
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 4번  ")) { 	//발생한 event가 ok에서 이고 tablebox의 값이 4번일 때
					if (tbtn[3].getBackground() == Color.YELLOW) {								//중복으로 예약함을 방지
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.", 				//중복으로 예약을 시도함을 알려주기 위한 MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[3].setForeground(Color.GREEN);														//tbtn 색 설정
						tbtn[3].setBackground(Color.YELLOW);													//tbtn 배경색 설정
						tbtn[3].setText("<예약> " + namefield.getText());											//tbtn에 예약상태 출력
						//예약 당시 입력했던 정보를 해당 table로 전달
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
						setVisible(false);																		//Visible 대상 변경
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 5번  ")) { 	//발생한 event가 ok에서 이고 tablebox의 값이 5번일 때
					if (tbtn[0].getBackground() == Color.YELLOW) {								//중복으로 예약함을 방지
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.", 				//중복으로 예약을 시도함을 알려주기 위한 MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[4].setForeground(Color.GREEN);														//tbtn 색 설정
						tbtn[4].setBackground(Color.YELLOW);													//tbtn 배경색 설정
						tbtn[4].setText("<예약> " + namefield.getText());											//tbtn에 예약상태 출력
						//예약 당시 입력했던 정보를 해당 table로 전달
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
						setVisible(false);																		//Visible 대상 변경
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 6번  ")) { 	//발생한 event가 ok에서 이고 tablebox의 값이 6번일 때
					if (tbtn[0].getBackground() == Color.YELLOW) {								//중복으로 예약함을 방지
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.", 				//중복으로 예약을 시도함을 알려주기 위한 MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[5].setForeground(Color.GREEN);														//tbtn 색 설정
						tbtn[5].setBackground(Color.YELLOW);													//tbtn 배경색 설정
						tbtn[5].setText("<예약> " + namefield.getText());											//tbtn에 예약상태 출력
						//예약 당시 입력했던 정보를 해당 table로 전달
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
						setVisible(false);																		//Visible 대상 변경
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 7번  ")) { 	//발생한 event가 ok에서 이고 tablebox의 값이 7번일 때
					if (tbtn[0].getBackground() == Color.YELLOW) {								//중복으로 예약함을 방지
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.",					//중복으로 예약을 시도함을 알려주기 위한 MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[6].setForeground(Color.GREEN);														//tbtn 색 설정
						tbtn[6].setBackground(Color.YELLOW);													//tbtn 배경색 설정
						tbtn[6].setText("<예약> " + namefield.getText());											//tbtn에 예약상태 출력
						//예약 당시 입력했던 정보를 해당 table로 전달
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
						setVisible(false);																		//Visible 대상 변경
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 8번  ")) { 	//발생한 event가 ok에서 이고 tablebox의 값이 8번일 때
					if (tbtn[0].getBackground() == Color.YELLOW) {								//중복으로 예약함을 방지
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.", 				//중복으로 예약을 시도함을 알려주기 위한 MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[7].setForeground(Color.GREEN);														//tbtn 색 설정
						tbtn[7].setBackground(Color.YELLOW);													//tbtn 배경색 설정
						tbtn[7].setText("<예약> " + namefield.getText());											//tbtn에 예약상태 출력
						//예약 당시 입력했던 정보를 해당 table로 전달
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
						setVisible(false);																		//Visible 대상 변경
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 9번  ")) { 	//발생한 event가 ok에서 이고 tablebox의 값이 9번일 때
					if (tbtn[0].getBackground() == Color.YELLOW) {								//중복으로 예약함을 방지
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.",					//중복으로 예약을 시도함을 알려주기 위한 MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[8].setForeground(Color.GREEN);														//tbtn 색 설정
						tbtn[8].setBackground(Color.YELLOW);													//tbtn 배경색 설정
						tbtn[8].setText("<예약> " + namefield.getText());											//tbtn에 예약상태 출력
						//예약 당시 입력했던 정보를 해당 table로 전달
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
						setVisible(false);																		//Visible 대상 변경
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 10번  ")) {		//발생한 event가 ok에서 이고 tablebox의 값이 10번일 때
					if (tbtn[0].getBackground() == Color.YELLOW) {									//중복으로 예약함을 방지
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.", 					//중복으로 예약을 시도함을 알려주기 위한 MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[9].setForeground(Color.GREEN);														//tbtn 색 설정
						tbtn[9].setBackground(Color.YELLOW);													//tbtn 배경색 설정
						tbtn[9].setText("<예약> " + namefield.getText());											//tbtn에 예약상태 출력
						//예약 당시 입력했던 정보를 해당 table로 전달
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
						setVisible(false);																		//Visible 대상 변경
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 11번  ")) { 	//발생한 event가 ok에서 이고 tablebox의 값이 11번일 때
					if (tbtn[0].getBackground() == Color.YELLOW) {									//중복으로 예약함을 방지
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.", 					//중복으로 예약을 시도함을 알려주기 위한 MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[10].setForeground(Color.GREEN);													//tbtn 색 설정
						tbtn[10].setBackground(Color.YELLOW);													//tbtn 배경색 설정
						tbtn[10].setText("<예약> " + namefield.getText());										//tbtn에 예약상태 출력
						//예약 당시 입력했던 정보를 해당 table로 전달
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
						setVisible(false);																		//Visible 대상 변경
					}
				} else if (e.getSource() == ok && tablebox.getSelectedItem().equals(" 12번  ")) { 	//발생한 event가 ok에서 이고 tablebox의 값이 12번일 때
					if (tbtn[0].getBackground() == Color.YELLOW) {									//중복으로 예약함을 방지
						JOptionPane.showMessageDialog(null, "이미 예약된 자리입니다.",						//중복으로 예약을 시도함을 알려주기 위한 MessageDialog
								"Message", JOptionPane.ERROR_MESSAGE);
					} else {
						tbtn[11].setForeground(Color.GREEN);													//tbtn 색 설정
						tbtn[11].setBackground(Color.YELLOW);													//tbtn 배경색 설정
						tbtn[11].setText("<예약> " + namefield.getText());										//tbtn에 예약상태 출력
						//예약 당시 입력했던 정보를 해당 table로 전달
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
						setVisible(false);																		//Visible 대상 변경
					}
				}
			}
		}

		class MyMouseAdapter extends MouseAdapter {				//reservation의 northpanel에 대한 mouse event를 처리하는 class
			public void mouseDragged(MouseEvent e) {
				la.setText("정확한 개인정보를 입력해 주세요.");			//mouse dragged event가 발생하면 지정한 문구 출력					
			}
			public void mouseMoved(MouseEvent e) {
				la.setText(" 개인정보는 타기관에 사용되지 않습니다.");		//mouse moved event가 발생하면 지정한 문구 출력
			}
		}
		class MyItemListener implements ItemListener { 			//reservation의 groupbutton에 대한 item event를 처리하는 class
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem() == man)		
					led.setText("남자입니다.");					//man이 선택되면 led에 지정한 문구 출력
				else if (e.getItem() == woman)   
					led.setText("여자입니다"); 					//woman이 선택되면 led에 지정한 문구 출력
				if (man.isSelected())
					manofwoman.setIcon(images.manimg());		//man이 선택되면 man image를 출력합니다
				else if (woman.isSelected())
					manofwoman.setIcon(images.womanimg()); 		//woman이 선택되면 woman image를 출력합니다
			}
		}
	}

	class MyMouseListener extends MouseAdapter {												//table에 대한 mouse event를 처리하는 class
		public void mouseEntered(MouseEvent e) {
			for (int i = 0; i < 12; i++)														
				if (e.getSource() == tbtn[i] && tbtn[i].getBackground() == Color.WHITE) 
					tbtn[i].setBackground(Color.LIGHT_GRAY); 									//table button위에 마우스가 올라가면 table의 배경색을 회색으로 설정
		}
		public void mouseExited(MouseEvent e) {
			for (int i = 0; i < 12; i++)           
				if (e.getSource() == tbtn[i] && tbtn[i].getBackground() == Color.LIGHT_GRAY)
					tbtn[i].setBackground(Color.WHITE);											//table button위에서 마우스가 내려가면 table의 배경색을 흰색으로 설정
		}
	}
	class MyActionListener implements ActionListener {															//table에 대한 action event를 처리하는 class
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tbtn[0]) {																		//1번 table이 선택되었을 때
				if (tbtn[0].getBackground() == Color.LIGHT_GRAY || tbtn[0].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//주문된 상태가 아니라면 계산 버튼 비활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				} else if (tbtn[0].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//주문된 상태라면 계산 버튼 활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				}
				select = 1;																						//table 번호 저장
			} else if (e.getSource() == tbtn[1]) {																//2번 table이 선택되었을때
				if (tbtn[1].getBackground() == Color.LIGHT_GRAY || tbtn[1].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//주문된 상태가 아니라면 계산 버튼 비활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				} else if (tbtn[1].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//주문된 상태라면 계산 버튼 활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				}
				select = 2;																						//table 번호 저장
			} else if (e.getSource() == tbtn[2]) {																//3번 table이 선택되었을때
				if (tbtn[2].getBackground() == Color.LIGHT_GRAY || tbtn[2].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//주문된 상태가 아니라면 계산 버튼 비활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				} else if (tbtn[2].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//주문된 상태라면 계산 버튼 활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				}
				select = 3;																						//table 번호 저장
			} else if (e.getSource() == tbtn[3]) {																//4번 table이 선택되었을때
				if (tbtn[3].getBackground() == Color.LIGHT_GRAY || tbtn[3].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//주문된 상태가 아니라면 계산 버튼 비활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				} else if (tbtn[3].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//주문된 상태라면 계산 버튼 활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				}
				select = 4;																						//table 번호 저장
			} else if (e.getSource() == tbtn[4]) {																//5번 table이 선택되었을때
				if (tbtn[4].getBackground() == Color.LIGHT_GRAY || tbtn[4].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//주문된 상태가 아니라면 계산 버튼 비활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				} else if (tbtn[4].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//주문된 상태라면 계산 버튼 활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				}
				select = 5;																						//table 번호 저장
			} else if (e.getSource() == tbtn[5]) {																//6번 table이 선택되었을때
				if (tbtn[5].getBackground() == Color.LIGHT_GRAY || tbtn[5].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//주문된 상태가 아니라면 계산 버튼 비활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				} else if (tbtn[5].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//주문된 상태라면 계산 버튼 활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				}
				select = 6;																						//table 번호 저장
			} else if (e.getSource() == tbtn[6]) {																//7번 table이 선택되었을때
				if (tbtn[6].getBackground() == Color.LIGHT_GRAY || tbtn[6].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//주문된 상태가 아니라면 계산 버튼 비활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				} else if (tbtn[6].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//주문된 상태라면 계산 버튼 활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				}
				select = 7;																						//table 번호 저장
			} else if (e.getSource() == tbtn[7]) {																//8번 table이 선택되었을때 
				if (tbtn[7].getBackground() == Color.LIGHT_GRAY || tbtn[7].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//주문된 상태가 아니라면 계산 버튼 비활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				} else if (tbtn[7].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//주문된 상태라면 계산 버튼 활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				}
				select = 8;																						//table 번호 저장
			} else if (e.getSource() == tbtn[8]) {																//9번 table이 선택되었을때
				if (tbtn[8].getBackground() == Color.LIGHT_GRAY || tbtn[8].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//주문된 상태가 아니라면 계산 버튼 비활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				} else if (tbtn[8].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//주문된 상태라면 계산 버튼 활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				}
				select = 9;																						//table 번호 저장
			} else if (e.getSource() == tbtn[9]) {																//10번 table이 선택되었을때
				if (tbtn[9].getBackground() == Color.LIGHT_GRAY || tbtn[9].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//주문된 상태가 아니라면 계산 버튼 비활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				} else if (tbtn[9].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//주문된 상태라면 계산 버튼 활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				}
				select = 10;																					//table 번호 저장
			} else if (e.getSource() == tbtn[10]) {																//11번 table이 선택되었을때
				if (tbtn[10].getBackground() == Color.LIGHT_GRAY || tbtn[10].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//주문된 상태가 아니라면 계산 버튼 비활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				} else if (tbtn[10].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//주문된 상태라면 계산 버튼 활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				}
				select = 11;																					//table 번호 저장
			} else if (e.getSource() == tbtn[11]) {																//12번 table이 선택되었을때
				if (tbtn[11].getBackground() == Color.LIGHT_GRAY || tbtn[11].getBackground() == Color.YELLOW) {
					Clickbtn2.setEnabled(false);																//주문된 상태가 아니라면 계산 버튼 비활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				} else if (tbtn[11].getBackground() == Color.GREEN) {
					Clickbtn2.setEnabled(true);     															//주문된 상태라면 계산 버튼 활성화
					clk.setVisible(true);  																		//clk를 Visible 대상으로 지정
				}
				select = 12;																					//table 번호 저장
			}
		}
	}
	
	public static void main(String[] args) {
		new login.login();			//맨처음 로그인 작업을 진행하기 위해 login 생성자 호출
	}
}