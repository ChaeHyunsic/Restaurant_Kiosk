package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import images.*;
import texts.*;

public class login extends JFrame {											// 맨처음 로그인에 관련된 작업을 처리하는 class
	images images = new images();											// login과 관련된 image를 사용하기 위해 생성자 호출
	texts texts = new texts();												// login과 관련된 file을 사용하기 위해 생성자 호출
	
	JLabel back = new JLabel(images.loginbackimg()); 						// 로그인 창의 배경을 위한 JLabel
	JLabel login = new JLabel("아 이 디");										// 아이디에 관련된 작업을 처리하기 위한 JLabel
	JLabel pw = new JLabel("비밀번호");										// 비밀번호에 관련된 작업을 처리하기 위한 JLabel
	JTextField id = new JTextField(10);										// 아이디 입력을 받기 위한 JTextField 
	JPasswordField password = new JPasswordField(10); 						// 비밀번호 입력을 받기 위한 JPasswordField
	
	String idconfirm, pwconfirm, c;											// 아이디, 비밀번호 확인 절차를 위한 문자열
	JButton okbtn = new JButton(images.loginbtnimg());						// login 시도 입력을 받기 위한 JButton
	JLabel fail = new JLabel("");											// login 시도 실패시 작업을 처리하기 위한 JLabel
	
	public login() {														// login 생성자, login setting
		Scanner sc;
		try {
			sc = new Scanner(texts.idpw());      							// file에 저장된 아이디와 비밀번호를 idconfirm, pwconfirm에 저장합니다
			while(sc.hasNext()){											// file의 끝까지 반복
				idconfirm = sc.nextLine();
				pwconfirm = sc.nextLine();
			}
		} catch (FileNotFoundException e1) {								// 예외 처리
			e1.printStackTrace();
		}
		
		setTitle("Login");													// login title 설정
		// ContentPane setting
		getContentPane();
		setLayout(null);													// 절대 경로 layout 설정
		fail.setForeground(Color.RED);										// 실패 시 foreground를 red로 설정
		okbtn.setContentAreaFilled(false);									// okbtn 내부 영역 비움 설정
		okbtn.setFocusable(false);											// okbtn focus 받을 수 없도록 설정
		add(back);
		back.setBounds(0, 0, 593, 503);
		back.add(okbtn); 
		okbtn.setBounds(350, 380, 113, 70);
		back.add(login); 
		login.setBounds(100, 380, 100, 30);
		back.add(id);	
		id.setBounds(170, 380, 150, 30);
		back.add(pw);	
		pw.setBounds(100, 420, 100, 30);
		back.add(password); 
		password.setBounds(170, 420, 150, 30);
		back.add(fail); 
		fail.setBounds(170, 460, 150, 30);
		
		id.addKeyListener(new MyKeyAdapter());				// 아이디에 대한 키보드 이벤트를 위한 KeyAdapter
		password.addKeyListener(new MyKeyAdapter());		// 패스워드에 대한 키보드 이벤트를 위한 KeyAdapter
		okbtn.addKeyListener(new MyKeyAdapter());			// 로그인시도에 대한 키보드 이벤트를 위한 KeyAdapter
		
		okbtn.addActionListener(new ActionListener(){						// 로그인 시도에 대한 차후 처리를 위한 ActionListener
			public void actionPerformed(ActionEvent e){						
				c = new String(password.getPassword());						// 입력된 passward를 처리하기 위해 문자열로 변환
				if(id.getText().equals(idconfirm) & c.equals(pwconfirm)){	// 사전에 처리된 file에 아이디와 비밀번호가 있으면 로그인 처리
					System.out.println("로그인 되었습니다.");
					setVisible(false);										// Visible 대상 변경
					new main.main();										// 다음 단계의 작업을 위해 main생성자 호출
				}
				else{																// 사전에 처리된 file에 아이디와 비밀번호가 없으면 id, password text 초기화
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 틀립니다.",
							"", JOptionPane.WARNING_MESSAGE);
					id.setText("");
					password.setText("");
					id.requestFocus();										// focus 설정
				}
			}
		});
		setResizable(false);			//ContentPane 사이즈조절 불가능하게 설정
		setSize(593,503);
		setLocation(500,200);
		setVisible(true);				//ContentPane Visible set
		id.requestFocus();				// focus 설정
		back.setFocusable(true);		// focus 받을 수 있도록 설정
	}
	
	class MyKeyAdapter extends KeyAdapter {									// keyboard 입력에 대한 이벤트 처리를 위한 KeyAdapter
		public void keyPressed(KeyEvent e){									// keyPressed 발생시
			if(e.getKeyCode() == KeyEvent.VK_ENTER){ 						// Enter가 입력되었으면
				c = new String(password.getPassword());						// 입력된 passward를 문자열로 처리
				if(id.getText().equals(idconfirm) & c.equals(pwconfirm)){	// 사전에 처리된 file에 아이디와 비밀번호가 있으면 로그인 처리
					System.out.println("로그인 되었습니다.");
					setVisible(false);										// Visible 대상 변경
					new main.main();										// 다음 단계의 작업을 위해 main생성자 호출
				}
				else{														// 사전에 처리된 file에 아이디와 비밀번호가 없으면 id, password JText 초기화
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 틀립니다.",
							"", JOptionPane.WARNING_MESSAGE);
					id.setText("");
					password.setText("");
					id.requestFocus();										// focus 설정
				}
			}
		}
	}
}