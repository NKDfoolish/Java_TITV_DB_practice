package Main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import View.LoginFrame;
import View.QLSINHVIEN;

public class Main {
  public static void main(String...asrg) {
	  try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new LoginFrame();
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e) {
		
		e.printStackTrace();
	}
  }
}
