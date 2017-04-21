package client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static client.view.Window.view;

public class View extends JFrame implements ViewInterface {

	private final JDesktopPane desktopPane = new JDesktopPane();
	private Window currentWindow;

	public View() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit and close?")==0){
					System.exit(0);
				}
			}
		});
		//setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/resources/icon.png")));
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//setLoginSize();
		setVisible(true);


		desktopPane.setLayout(new CardLayout(0,0));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		setCurrentWindow(MAIN);
		view = this;
	}

	public void setCurrentWindow(Window window) {
		if(desktopPane.getComponentCount() == 0) {
			window.loadData();
			window.setVisible(true);
			desktopPane.add(window);
			currentWindow = window;
		}
		else{
			desktopPane.getComponent(0).setVisible(false);
			desktopPane.removeAll();
			window.loadData();
			window.setVisible(true);
			desktopPane.add(window);
			currentWindow = window;
		}
	}

	@Override
	public void showLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMain() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createEvents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		
	}

}
