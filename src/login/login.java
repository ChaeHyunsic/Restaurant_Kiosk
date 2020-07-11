package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import images.*;
import texts.*;

public class login extends JFrame {											// ��ó�� �α��ο� ���õ� �۾��� ó���ϴ� class
	images images = new images();											// login�� ���õ� image�� ����ϱ� ���� ������ ȣ��
	texts texts = new texts();												// login�� ���õ� file�� ����ϱ� ���� ������ ȣ��
	
	JLabel back = new JLabel(images.loginbackimg()); 						// �α��� â�� ����� ���� JLabel
	JLabel login = new JLabel("�� �� ��");										// ���̵� ���õ� �۾��� ó���ϱ� ���� JLabel
	JLabel pw = new JLabel("��й�ȣ");										// ��й�ȣ�� ���õ� �۾��� ó���ϱ� ���� JLabel
	JTextField id = new JTextField(10);										// ���̵� �Է��� �ޱ� ���� JTextField 
	JPasswordField password = new JPasswordField(10); 						// ��й�ȣ �Է��� �ޱ� ���� JPasswordField
	
	String idconfirm, pwconfirm, c;											// ���̵�, ��й�ȣ Ȯ�� ������ ���� ���ڿ�
	JButton okbtn = new JButton(images.loginbtnimg());						// login �õ� �Է��� �ޱ� ���� JButton
	JLabel fail = new JLabel("");											// login �õ� ���н� �۾��� ó���ϱ� ���� JLabel
	
	public login() {														// login ������, login setting
		Scanner sc;
		try {
			sc = new Scanner(texts.idpw());      							// file�� ����� ���̵�� ��й�ȣ�� idconfirm, pwconfirm�� �����մϴ�
			while(sc.hasNext()){											// file�� ������ �ݺ�
				idconfirm = sc.nextLine();
				pwconfirm = sc.nextLine();
			}
		} catch (FileNotFoundException e1) {								// ���� ó��
			e1.printStackTrace();
		}
		
		setTitle("Login");													// login title ����
		// ContentPane setting
		getContentPane();
		setLayout(null);													// ���� ��� layout ����
		fail.setForeground(Color.RED);										// ���� �� foreground�� red�� ����
		okbtn.setContentAreaFilled(false);									// okbtn ���� ���� ��� ����
		okbtn.setFocusable(false);											// okbtn focus ���� �� ������ ����
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
		
		id.addKeyListener(new MyKeyAdapter());				// ���̵� ���� Ű���� �̺�Ʈ�� ���� KeyAdapter
		password.addKeyListener(new MyKeyAdapter());		// �н����忡 ���� Ű���� �̺�Ʈ�� ���� KeyAdapter
		okbtn.addKeyListener(new MyKeyAdapter());			// �α��νõ��� ���� Ű���� �̺�Ʈ�� ���� KeyAdapter
		
		okbtn.addActionListener(new ActionListener(){						// �α��� �õ��� ���� ���� ó���� ���� ActionListener
			public void actionPerformed(ActionEvent e){						
				c = new String(password.getPassword());						// �Էµ� passward�� ó���ϱ� ���� ���ڿ��� ��ȯ
				if(id.getText().equals(idconfirm) & c.equals(pwconfirm)){	// ������ ó���� file�� ���̵�� ��й�ȣ�� ������ �α��� ó��
					System.out.println("�α��� �Ǿ����ϴ�.");
					setVisible(false);										// Visible ��� ����
					new main.main();										// ���� �ܰ��� �۾��� ���� main������ ȣ��
				}
				else{																// ������ ó���� file�� ���̵�� ��й�ȣ�� ������ id, password text �ʱ�ȭ
					JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� Ʋ���ϴ�.",
							"", JOptionPane.WARNING_MESSAGE);
					id.setText("");
					password.setText("");
					id.requestFocus();										// focus ����
				}
			}
		});
		setResizable(false);			//ContentPane ���������� �Ұ����ϰ� ����
		setSize(593,503);
		setLocation(500,200);
		setVisible(true);				//ContentPane Visible set
		id.requestFocus();				// focus ����
		back.setFocusable(true);		// focus ���� �� �ֵ��� ����
	}
	
	class MyKeyAdapter extends KeyAdapter {									// keyboard �Է¿� ���� �̺�Ʈ ó���� ���� KeyAdapter
		public void keyPressed(KeyEvent e){									// keyPressed �߻���
			if(e.getKeyCode() == KeyEvent.VK_ENTER){ 						// Enter�� �ԷµǾ�����
				c = new String(password.getPassword());						// �Էµ� passward�� ���ڿ��� ó��
				if(id.getText().equals(idconfirm) & c.equals(pwconfirm)){	// ������ ó���� file�� ���̵�� ��й�ȣ�� ������ �α��� ó��
					System.out.println("�α��� �Ǿ����ϴ�.");
					setVisible(false);										// Visible ��� ����
					new main.main();										// ���� �ܰ��� �۾��� ���� main������ ȣ��
				}
				else{														// ������ ó���� file�� ���̵�� ��й�ȣ�� ������ id, password JText �ʱ�ȭ
					JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� Ʋ���ϴ�.",
							"", JOptionPane.WARNING_MESSAGE);
					id.setText("");
					password.setText("");
					id.requestFocus();										// focus ����
				}
			}
		}
	}
}