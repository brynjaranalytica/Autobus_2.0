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
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?", "", JOptionPane.YES_NO_OPTION)==0){
					System.exit(0);
				}
			}
		});
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 415, 280);
		setLocationRelativeTo(null);
		setVisible(true);


		desktopPane.setLayout(new CardLayout(0,0));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		setCurrentWindow(LOGIN);
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
			setBounds(600, 200, 635, 600);
		}
	}

	@Override
	public void showLogin() {
		currentWindow.showLogin();
		
	}

	@Override
	public void showMain() {
		currentWindow.showMain();
	}

	@Override
	public void createEvents() {
		currentWindow.createEvents();
	}

	@Override
	public void initComponents() {
		currentWindow.initComponents();
	}

	@Override
	public void loadData() {
		currentWindow.loadData();
	}

}
