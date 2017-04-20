package client.view;

import client.controller.ClientController;

public interface ViewInterface {
	ClientController controller = ClientController.getInstance();
	Window LOGIN = new LoginWindow();
	Window MAIN = new MainWindow();
	
	void viewLogin();
    void showMain();
    void createEvents();
    void initComponents();
    void loadData();
}
