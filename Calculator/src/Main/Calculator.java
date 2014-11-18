package Main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends Frame implements ActionListener {/* Начало класса App */

	private static final long serialVersionUID = 1;

	public static String s1, /* Строка которую вводит пользователь для вычисления */
	s; /* Строка с результатом */

	public TextField text, text2;
	
	Button res, sqrt, sin, cos, tan;

	Calculator(String title) {/* Конструктор класса App */
		super(title);
		setLayout(null);
		setFont(new Font("Times New Roman", Font.LAYOUT_NO_LIMIT_CONTEXT, 13));
		add(res = new Button("Вычислить"));
		res.setBounds(260, 82, 100, 82);
		res.addActionListener(this);
		
		add(sqrt = new Button("Квад.корень"));
		sqrt.setBounds(40, 172, 90, 42);
		sqrt.addActionListener(this);
		
		add(sin = new Button("Синус"));
		sin.setBounds(132, 172, 70, 42);
		sin.addActionListener(this);
		
		add(cos = new Button("Косинус"));
		cos.setBounds(204, 172, 70, 42);
		cos.addActionListener(this);
		
		add(tan = new Button("Тангенс"));
		tan.setBounds(276, 172, 70, 42);
		tan.addActionListener(this);

		add(text = new TextField());
		text.setBounds(40, 85, 210, 30);
		

		add(text2 = new TextField());
		text2.setBounds(40, 136, 210, 30);
		text2.setBackground(new Color(0xFFFF00));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public void paint(Graphics g) {
		g.setFont(new Font("Verdana", Font.TRUETYPE_FONT, 13));
		g.drawString("Введите математическое выражение:", 35, 74);
		g.drawString("Результат:", 35, 127);
	}

	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		
		if(str.equals("Вычислить")){
			GetString();
			}
		else if (str.equals("Квад.корень")){
			GetSqrt();
		}else if (str.equals("Синус")){
			GetSin();
		}else if (str.equals("Косинус")){
			GetCos();
		}else if (str.equals("Тангенс")){
			GetTan();
		}
	}

	public String GetString() {
		s1 = text.getText();
		if (s1.length() != 0) {
			// System.out.println("Была введена строка: " + s1 + ".");
			// System.out.println("Результат: " +Solution.eval(s1));
			s = Double.toString(Solution.eval(s1));
			text2.setText(s);	
		}
		return null;
	}
	
	public String GetSqrt() {
		s1 = text.getText();
		if (s1.length() != 0) {
			// System.out.println("Была введена строка: " + s1 + ".");
			// System.out.println("Результат: " +Solution.eval(s1));
			
			s = Double.toString(Math.sqrt(Solution.eval(s1)));
			text2.setText(s);
		}
		
		return null;
	}

	public String GetSin() {
			s1 = text.getText();
			if (s1.length() != 0) {
				// System.out.println("Была введена строка: " + s1 + ".");
				// System.out.println("Результат: " +Solution.eval(s1));
				
				s = Double.toString(Math.sin(Math.toRadians(Solution.eval(s1))));
				text2.setText(s);
			}
			
			return null;
		}
		
	public String GetCos() {
			s1 = text.getText();
			if (s1.length() != 0) {
				// System.out.println("Была введена строка: " + s1 + ".");
				// System.out.println("Результат: " +Solution.eval(s1));
				
				s = Double.toString(Math.cos(Math.toRadians(Solution.eval(s1))));
				text2.setText(s);
			}
			
			return null;
		}
		
	public String GetTan() {
			s1 = text.getText();
			if (s1.length() != 0) {
				// System.out.println("Была введена строка: " + s1 + ".");
				// System.out.println("Результат: " +Solution.eval(s1));
				
				s = Double.toString(Math.tan(Math.toRadians(Solution.eval(s1))));
				text2.setText(s);
			}
			return null;
		}
} /* Окончание класса Calculator */