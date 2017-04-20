package autoBus;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.time.temporal.ChronoUnit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Autobus extends JFrame {

	Passenger currentlyUpdatingPassenger;
	Customer currentlyUpdatingCustomer;
	JLabel lblDeletePassengerButton;
	private static final long serialVersionUID = 1L;
	JPanel updateTourPanel;
	JPanel updateTourReservationPanel;
	JPanel updateBusReservationsNext;
	JMenuItem mntmAboutAutobus;
	JMenuItem mntmExit;
	ImageIcon icon;
	ChauffeursArchive chauffeursArchive;
	BusesArchive busesArchive;
	ToursArchive toursArchive;
	CustomersArchive customersArchive;
	PassengersArchive passengersArchive;
	ReservationsArchive reservationsArchive;
	PriceList priceList;
	ReservationNumber reservationNumberGenerator;
	int reservationNumber;
	JMenuItem mntmTourReservations;
	JMenuItem mntmBusReservations;
	JPanel panelTourReservations;
	JPanel panelBusReservations;
	JPanel panelChauffeurs;
	JMenuItem mntmEditChauffeur;
	JTable tableChauffeurs;
	JLabel lblAddChauffeurButton;
	JTextField textFieldChauffeurName;
	JTextField textFieldChauffeurAddress;
	JTextField textFieldEmployeeNo;
	JTextField textFieldChauffeurEmail;
	JTextField textFieldChauffeurPhone;
	JTextField textFieldChauffeurBirthMonth;
	JTextField textFieldChauffeurBirthDay;
	JTextField textFieldChauffeurBirthYear;
	JCheckBox chckbxExternalEmployee;
	JCheckBox chckbxOnlyOneDayTrips;
	DefaultTableModel chauffeursTable;
	JLabel lblDeleteChauffeurBtn;
	JPanel panelBuses;
	JMenuItem mntmEditBus;
	JPanel panelTours;
	JMenuItem mntmEditTours;
	JMenuItem mntmEditCustomers;
	JPanel panelCustomers;
	JMenuItem mntmPassengers;
	JPanel panelPassengers;
	JMenuItem mntmNewTourReservation;
	JPanel panelNewTourReservation;
	JMenuItem mntmNewBusReservation;
	JPanel panelNewBusReservation;
	JTable tableBuses;
	DefaultTableModel busesTable;
	JLabel labelAddBusBtn;
	JTextField textFieldVehicleID;
	JTextField textFieldPriceHour;
	JTextField textFieldNumberSeats;
	JRadioButton rdbtnStandardBus;
	JRadioButton rdbtnPartyBus;
	JRadioButton rdbtnLuxuryBus;
	JLabel labelDeleteBusBtn;
	JPanel panelAddTour;
	JTextField textFieldDestination;
	JLabel lblStartDate;
	JTextField textFieldStartMonth;
	JTextField textFieldStartDay;
	JTextField textFieldStartYear;
	JLabel lblEndDate;
	JTextField textFieldEndMonth;
	JTextField textFieldEndDay;
	JTextField textFieldEndYear;
	JLabel lblClearPickUpBtn;
	JLabel lblAddTourBtn;
	JLabel lblDeleteTourBtn;
	JCheckBox chckbxBreakfast;
	JCheckBox chckbxAllInclusive;
	JCheckBox chckbxLunch;
	JTable tableTours;
	DefaultTableModel toursTable;
	JPanel panelTopPrices;
	JLabel labelPrices;
	JMenuItem mntmPrices;
	JPanel panelPrices;
	JTable tablePickups;
	DefaultTableModel pickupsTable;
	JTextField textFieldAddPickup;
	JLabel lblAddPickUpBtn;
	JScrollPane scrollPanePickUps;
	JScrollPane scrollPaneSelectBus;
	JScrollPane scrollPaneSelectChauffeur;
	JTable tableSelectBus;
	DefaultTableModel selectBusTable;
	JTable tableSelectChauffeur;
	DefaultTableModel selectChauffeurTable;
	JCheckBox chckbxEntranceTickets;
	JTextField textFieldPriceAllinclusive;
	JTextField textFieldPriceEntranceTickets;
	JTextField textFieldPriceBreakfast;
	JTextField textFieldPriceLunch;
	JLabel lblUpdatePriceBtn;
	JTable tableCustomers;
	DefaultTableModel customersTable;
	JScrollPane scrollPanePassengers;
	JTable tablePassengers;
	DefaultTableModel passengersTable;
	JScrollPane scrollPaneTourReservations;
	JTable tableTourReservations;
	DefaultTableModel tourReservationsTable;
	JScrollPane scrollPaneBusReservations;
	JTable tableBusReservations;
	DefaultTableModel busReservationsTable;
	JPanel panel;
	JLabel lblNewBusOrganisationName;
	JTextField textFieldNewBusOrganisationName;
	JTextField textFieldNewBusCustomerName;
	JTextField textFieldNewBusCustomerAddress;
	JTextField textFieldNewBusCustomerPhone;
	JTextField textFieldNewBusCustomerEmail;
	JTextField textFieldNewBusCustomerBmonth;
	JTextField textFieldNewBusCustomerBday;
	JTextField textFieldNewBusCustomerByear;
	JLabel lblNewBusSearchCustomerBtn;
	JRadioButton rdbtnNewBusCompany;
	JRadioButton rdbtnNewBusSchool;
	JRadioButton rdbtnNewBusPrivate;
	JLabel lblNewBusCustomerClear;
	JPanel panelNewBusAddPassenger;
	JScrollPane scrollPaneNewBusPassengers;
	JTable tableNewBusPassengers;
	DefaultTableModel newBusPassengersTable;
	JLabel lblNewBusRemovePassengerBtn;
	JLabel lblNewBusPassengerPhone;
	JLabel lblNewBusPassengerName;
	JLabel lblNewBusPassengerAddress;
	JLabel lblNewBusPassengerEmail;
	JLabel lblNewBusPassengerBirthday;
	JTextField textFieldNewBusPassengerPhone;
	JTextField textFieldNewBusPassengerName;
	JTextField textFieldNewBusPassengerAddress;
	JTextField textFieldNewBusPassengerEmail;
	JLabel lblNewBusSearchPassengerBtn;
	JTextField textFieldNewBusPassengerBmonth;
	JTextField textFieldNewBusPassengerBday;
	JTextField textFieldNewBusPassengerByear;
	JLabel lblNewBusPassengerClearBtn;
	JLabel lblNewBusAddPassengerBtn;
	JLabel lblNewBusNextBtn;
	JLabel lblNewBusClearAllBtn;
	JCheckBox chckbxNewBusIsPassenger;
	JPanel panelNewBusReservationNext;
	JLabel lblCancel;
	JLabel lblOkNewBusResevation;
	JScrollPane scrollPaneNewBusSelectChauffeur;
	JPanel panel_5;
	JLabel label_19;
	JTable tableNewBusSelectChauffeur;
	DefaultTableModel newBusSelectChauffeurTable;
	JPanel panelSelectBus;
	JScrollPane scrollPaneNewBusSelectBus;
	JTable tableNewBusSelectBus;
	DefaultTableModel newBusSelectBusTable;
	JTextField textFieldNewBusStartMonth;
	JTextField textFieldNewBusStartDay;
	JTextField textFieldNewBusEndYear;
	JTextField textFieldNewBusEndDay;
	JTextField textFieldNewBusEndMonth;
	JTextField textFieldNewBusStartYear;
	JPanel panelServicesNewBus;
	JCheckBox chckbxBreakfastNewBus;
	JCheckBox chckbxLunchNewBus;
	JCheckBox chckbxAllInclusiveNewBus;
	JCheckBox chckbxEntranceTicketsNewBus;
	JTextPane textPaneSummaryNewBus;
	JLabel lblCreateReservationButton;
	JTextField searchTourTextField;
	/* Fixed manually */JTextField searchCustomerTextField;
	JLabel lblSearchCustomerByName;
	JTextField lblPhoneInNewTourReservationtextField;
	JTextField customerNameNewTourReservationTextField;
	JTextField customerOrganisationtextField;
	JTextField customerEmailNewTourReservationtextField;
	JTextField customerAddressIncustomerEmailNewTourReservationTextField;
	JTextField customerMonthInNewTourReservationTextField;
	JTextField customerDayInNewTourReservationTextField;
	JTextField customerYearInNewTourReservationTextField;
	JTable customersTableInNewTourReservation;
	JTable tablePassengersInNewTourReservation;
	JScrollPane selectTourInNewTourReservationScrollPanel;
	JTable tableToursInNewTourReservation;
	DefaultTableModel toursTableInNewTourReservation;
	JPanel addNewPassengerInNewTourReservationPanel;
	JLabel lblClearButtonPassengerInNewTourReservation;
	JLabel lblAddNewPassengerInNewTourReservation;
	JLabel label_3;
	JLabel label_5;
	JTextField passengerEmailInNewTourReservation;
	JTextField passengerAddressInNewTourReservation;
	JLabel label_12;
	JLabel label_14;
	JTextField passengerPhoneInNewTourReservation;
	JTextField passengerNameInNewReservation;
	JLabel label_15;
	JTextField passengerMonthInNewTourReservation;
	JTextField passengerDayInNewTourReservation;
	JTextField passengerYearInNewTourReservation;
	JLabel lblAddCusomerButtonNewTourReservation;
	JRadioButton radioButtonIsCompanyNewTourReservation;
	JRadioButton radioButtonIsSchoolNewTourReservation;
	JCheckBox boxIsAPassengerNewTourReservation;
	JLabel lblClearCustomerButtonNewTourReservation;
	JRadioButton radioButtonIsPrivateInNewTourReservation;
	JPanel summaryPanel;
	JLabel lblSelectedTour;
	JLabel lblSelectedCustomer;
	JLabel lblSearchForPassengerInNewTourReservationButton;
	JLabel lblRemoveButtonInNewTourReservation;
	JLabel lblClearAlButtonInNewTourReservation;
	JLabel lblCancelButtonInNewTourReservation;
	JLabel lblDeleteTourReservation;
	DefaultTableModel newBusPassengerReservationTable;
	JLabel lblUpdateBusReservation;
	JLabel lblDeleteBus;
	JList<String> lblSelectedPassengers;
	public static Autobus frame;
	JLabel lblSearchForAvailableInToursPanel;
	JTextField textFieldStartHour;
	JTextField textFieldStartMinute;
	JTextField textFieldEndHour;
	JTextField textFieldEndMinute;
	JPanel updateBusReservations;
	JDesktopPane desktopPane;
	JTextField startHourInNewBusRes;
	JTextField startMinuteInNewBusRes;
	JTextField endtHourInNewBusRes;
	JTextField endMinuteInNewBusRes;
	JLabel lblSearchForAvailableInNewBusRes;
	JLabel lblUpdateTourReservation;
	JLabel lblUpdateTourButton;
	private JLabel lblSelectCustomerButtonInNewTourRes;
	private JLabel lblSelectTourButtonInNewTourRes;
	private JTextField customerPhone;
	private JTextField customerName;
	private JTextField customerOrganisation;
	private JTextField customerEmail;
	private JTextField customerAddress;
	private JTextField customerMonth;
	private JTextField customerDay;
	private JTextField customerYear;
	private JTextField passengerEmail;
	private JTextField passengerAddress;
	private JTextField passengerPhone;
	private JTextField passengerName;
	private JTextField passengerMonth;
	private JTextField passengerDay;
	private JTextField passengerYear;
	private JLabel lblUpdatePassengerButton;
	private JLabel lblClearPassengerButton;
	private JLabel lblAddNewPassengerButton;
	private JLabel lblSaveChangesCustomerButton;
	private JRadioButton radioButtonCompany;
	private JRadioButton radioButtonSchool;
	private JLabel lblClearButtonCustomer;
	JRadioButton radioButtonPrivate;
	private JLabel lblDeleteCustomerPanel;
	private JLabel lblUpdateCustomerButton;
	JPanel updateBusPanel;
	JPanel updateChauffeurPanel;
	JLabel lblShowFullDescriptionChauffeurButton;
	JLabel lblShowFullDescription;
	private JLabel lblSelectBusNewBusResButton;
	private JTextField searchBusTextField;
	private JTextField searchTourTExtField;
	private JTextField searchChauffeurTextField;
	private JTextField searchBusResTextField;
	private JTextField searchTourResTextField;
	private JTextField searchCustomerInCustomerPanelTextField;
	private JTextField searchPassengerTextField;
	private JLabel lblDiscount;
	private JTextField customerDiscountUpdCustomerTextField;
	private JLabel dicount;
	private JTextField customerMoneySpentTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			frame = null;
			try {
				frame = new Autobus();
				frame.initExternalComponents();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			frame.setVisible(true);
			frame.setExtendedState(MAXIMIZED_BOTH);
		});

	}

	/**
	 * This is constructor for Autobus initComponents() - creates and
	 * initializes components createEvents() - create events loadArchive() -
	 * loads the archives
	 * 
	 * @throws Exception
	 */
	public Autobus() throws Exception {

		initComponents();
		createEvents();
		loadArchives();

	}

	/**
	 * This method contains all code for loading the archives
	 * 
	 * @throws Exception
	 */
	private void loadArchives() throws Exception {

		chauffeursArchive = new ChauffeursArchive();
		if (chauffeursArchive.isFileFound()) {
			chauffeursArchive.loadChauffeursArchive();
			listChauffeurs();
			// listSelectChauffeur();
		} else {
			chauffeursArchive.createFile();
			listChauffeurs();
			// listSelectChauffeur();
		}

		busesArchive = new BusesArchive();
		if (busesArchive.isFileFound()) {
			busesArchive.loadBusesArchive();
			listBuses();
			// listSelectBus();
		} else {
			busesArchive.createFile();
			listBuses();
			// listSelectBus();
		}

		priceList = new PriceList();
		if (priceList.isFileFound()) {
			priceList.loadPriceList();
			updatePrices();
		} else {
			priceList.createFile();
			updatePrices();
		}

		customersArchive = new CustomersArchive();
		if (customersArchive.isFileFound()) {
			customersArchive.loadCustomersArchive();
			listCustomers();
		} else {
			customersArchive.createFile();
			listCustomers();
		}

		passengersArchive = new PassengersArchive();
		if (passengersArchive.isFileFound()) {
			passengersArchive.loadPassengersArchive();
			listPassengers();
		} else {
			passengersArchive.createFile();
			listPassengers();
		}

		reservationNumberGenerator = new ReservationNumber();
		if (reservationNumberGenerator.isFileFound()) {
			reservationNumberGenerator.loadReservationNumber();
			;
		} else {
			reservationNumberGenerator.createFile();
		}

		toursArchive = new ToursArchive();
		if (toursArchive.isFileFound()) {
			toursArchive.loadToursArchive();
			listTours();
		} else {
			toursArchive.createFile();
			listTours();
		}

		reservationsArchive = new ReservationsArchive();
		if (reservationsArchive.isFileFound()) {
			reservationsArchive.loadReservationsArchive();
			listBusReservations();
			listTourReservations();
		} else {
			reservationsArchive.createFile();
			listBusReservations();
			listTourReservations();
		}
	}

	/**
	 * This method contains all code for creating events
	 */
	private void createEvents() {

		/**
		 * This searches for BusReservtions in reservationsArchive by name of
		 * customer according to the symbols in searchBusResTextField TextField.
		 * Adds suitable Tour in tableToursInUpdTourRes and always refreshing
		 * tableBusReservations table every time a symbol was added in
		 * searchBusResTextField TextField by removing no more unsuitable Bus &
		 * Chauffeurs Reservations from the tableBusReservations table and
		 * adding new once that are suitable
		 */
		searchBusResTextField.getDocument().addDocumentListener(new DocumentListener() {
			public void deleteAllRows(final DefaultTableModel model) {
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				DefaultTableModel tourResTableModel;
				deleteAllRows(tourResTableModel = (DefaultTableModel) tableBusReservations.getModel());
				String searchText;
				if (!(searchText = searchBusResTextField.getText()).equals("")) {
					Object[] rowData = new Object[8];
					for (int i = 0; i < reservationsArchive.size(); i++) {
						String name = reservationsArchive.get(i).getCustomer().getName();
						String substringOfName = name.substring(0,
								searchText.length() <= name.length() ? searchText.length() : name.length());
						if (substringOfName.equals(searchText)
								&& reservationsArchive.get(i) instanceof BusReservation) {
							BusReservation otherBusReservation = (BusReservation) reservationsArchive.get(i);
							rowData[0] = otherBusReservation.getReservationNumber();
							rowData[1] = otherBusReservation.getDepartureDate();
							rowData[2] = otherBusReservation.getCustomer().getName();
							rowData[3] = otherBusReservation.getPassengersString();
							rowData[4] = otherBusReservation.getChauffeur().getName();
							rowData[5] = "#" + otherBusReservation.getBus().getVehicleID() + " "
									+ otherBusReservation.getBus().getModel();
							rowData[6] = otherBusReservation.getServices().getServicesString();
							rowData[7] = otherBusReservation.getTotalPrice();
							tourResTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(tourResTableModel = (DefaultTableModel) tableBusReservations.getModel());
					Object[] rowData = new Object[8];
					for (int i = 0; i < reservationsArchive.size(); i++) {
						if (reservationsArchive.get(i) instanceof BusReservation) {
							BusReservation otherBusReservation = (BusReservation) reservationsArchive.get(i);
							rowData[0] = otherBusReservation.getReservationNumber();
							rowData[1] = otherBusReservation.getDepartureDate();
							rowData[2] = otherBusReservation.getCustomer().getName();
							rowData[3] = otherBusReservation.getPassengersString();
							rowData[4] = otherBusReservation.getChauffeur().getName();
							rowData[5] = "#" + otherBusReservation.getBus().getVehicleID() + " "
									+ otherBusReservation.getBus().getModel();
							rowData[6] = otherBusReservation.getServices().getServicesString();
							rowData[7] = otherBusReservation.getTotalPrice();
							tourResTableModel.addRow(rowData);
						}
					}
				}
			}

			public void removeUpdate(DocumentEvent e) {
				DefaultTableModel tourResTableModel;
				deleteAllRows(tourResTableModel = (DefaultTableModel) tableBusReservations.getModel());
				String searchText;
				if (!(searchText = searchBusResTextField.getText()).equals("")) {
					Object[] rowData = new Object[8];
					for (int i = 0; i < reservationsArchive.size(); i++) {
						String name = reservationsArchive.get(i).getCustomer().getName();
						String substringOfName = name.substring(0,
								searchText.length() <= name.length() ? searchText.length() : name.length());
						if (substringOfName.equals(searchText)
								&& reservationsArchive.get(i) instanceof BusReservation) {
							BusReservation otherBusReservation = (BusReservation) reservationsArchive.get(i);
							rowData[0] = otherBusReservation.getReservationNumber();
							rowData[1] = otherBusReservation.getDepartureDate();
							rowData[2] = otherBusReservation.getCustomer().getName();
							rowData[3] = otherBusReservation.getPassengersString();
							rowData[4] = otherBusReservation.getChauffeur().getName();
							rowData[5] = "#" + otherBusReservation.getBus().getVehicleID() + " "
									+ otherBusReservation.getBus().getModel();
							rowData[6] = otherBusReservation.getServices().getServicesString();
							rowData[7] = otherBusReservation.getTotalPrice();
							tourResTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(tourResTableModel = (DefaultTableModel) tableBusReservations.getModel());
					Object[] rowData = new Object[8];
					for (int i = 0; i < reservationsArchive.size(); i++) {
						if (reservationsArchive.get(i) instanceof BusReservation) {
							BusReservation otherBusReservation = (BusReservation) reservationsArchive.get(i);
							rowData[0] = otherBusReservation.getReservationNumber();
							rowData[1] = otherBusReservation.getDepartureDate();
							rowData[2] = otherBusReservation.getCustomer().getName();
							rowData[3] = otherBusReservation.getPassengersString();
							rowData[4] = otherBusReservation.getChauffeur().getName();
							rowData[5] = "#" + otherBusReservation.getBus().getVehicleID() + " "
									+ otherBusReservation.getBus().getModel();
							rowData[6] = otherBusReservation.getServices().getServicesString();
							rowData[7] = otherBusReservation.getTotalPrice();
							tourResTableModel.addRow(rowData);
						}
					}
				}
			}

			public void insertUpdate(DocumentEvent e) {
				DefaultTableModel tourResTableModel;
				deleteAllRows(tourResTableModel = (DefaultTableModel) tableBusReservations.getModel());
				String searchText;
				if (!(searchText = searchBusResTextField.getText()).equals("")) {
					Object[] rowData = new Object[8];
					for (int i = 0; i < reservationsArchive.size(); i++) {
						String name = reservationsArchive.get(i).getCustomer().getName();
						String substringOfName = name.substring(0,
								searchText.length() <= name.length() ? searchText.length() : name.length());
						if (substringOfName.equals(searchText)
								&& reservationsArchive.get(i) instanceof BusReservation) {
							BusReservation otherBusReservation = (BusReservation) reservationsArchive.get(i);
							rowData[0] = otherBusReservation.getReservationNumber();
							rowData[1] = otherBusReservation.getDepartureDate();
							rowData[2] = otherBusReservation.getCustomer().getName();
							rowData[3] = otherBusReservation.getPassengersString();
							rowData[4] = otherBusReservation.getChauffeur().getName();
							rowData[5] = "#" + otherBusReservation.getBus().getVehicleID() + " "
									+ otherBusReservation.getBus().getModel();
							rowData[6] = otherBusReservation.getServices().getServicesString();
							rowData[7] = otherBusReservation.getTotalPrice();
							tourResTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(tourResTableModel = (DefaultTableModel) tableBusReservations.getModel());
					Object[] rowData = new Object[8];
					for (int i = 0; i < reservationsArchive.size(); i++) {
						if (reservationsArchive.get(i) instanceof BusReservation) {
							BusReservation otherBusReservation = (BusReservation) reservationsArchive.get(i);
							rowData[0] = otherBusReservation.getReservationNumber();
							rowData[1] = otherBusReservation.getDepartureDate();
							rowData[2] = otherBusReservation.getCustomer().getName();
							rowData[3] = otherBusReservation.getPassengersString();
							rowData[4] = otherBusReservation.getChauffeur().getName();
							rowData[5] = "#" + otherBusReservation.getBus().getVehicleID() + " "
									+ otherBusReservation.getBus().getModel();
							rowData[6] = otherBusReservation.getServices().getServicesString();
							rowData[7] = otherBusReservation.getTotalPrice();
							tourResTableModel.addRow(rowData);
						}
					}
				}
			}
		});

		/**
		 * This searches for TourReservtions in reservationsArchive by name of
		 * customer according to the symbols in searchTourResTextField
		 * TextField. Adds suitable TourReservations in tableTourReservations
		 * and always refreshing tableTourReservations table every time a symbol
		 * was added in searchTourResTextField TextField by removing no more
		 * unsuitable Tour Reservations from the tableTourReservations table and
		 * adding new once that are suitable
		 */
		searchTourResTextField.getDocument().addDocumentListener(new DocumentListener() {

			public void deleteAllRows(final DefaultTableModel model) {
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				DefaultTableModel tourResTableModel;
				deleteAllRows(tourResTableModel = (DefaultTableModel) tableTourReservations.getModel());
				String searchText;
				if (!(searchText = searchTourResTextField.getText()).equals("")) {
					Object[] rowData = new Object[5];
					for (int i = 0; i < reservationsArchive.size(); i++) {
						String name = reservationsArchive.get(i).getCustomer().getName();
						String substringOfName = name.substring(0,
								searchText.length() <= name.length() ? searchText.length() : name.length());
						if (substringOfName.equals(searchText)
								&& reservationsArchive.get(i) instanceof TourReservation) {
							TourReservation otherTourReservation = (TourReservation) reservationsArchive.get(i);
							rowData[0] = otherTourReservation.getReservationNumber();
							rowData[1] = otherTourReservation.getTour().getDestination() + " "
									+ otherTourReservation.getTour().getDateIntervalString();
							rowData[2] = otherTourReservation.getCustomer().getName();
							rowData[3] = otherTourReservation.getPassengersString();
							rowData[4] = otherTourReservation.getTotalPrice();
							tourResTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(tourResTableModel = (DefaultTableModel) tableTourReservations.getModel());
					Object[] rowData = new Object[5];
					for (int i = 0; i < reservationsArchive.size(); i++) {
						if (reservationsArchive.get(i) instanceof TourReservation) {
							TourReservation otherTourReservation = (TourReservation) reservationsArchive.get(i);
							rowData[0] = otherTourReservation.getReservationNumber();
							rowData[1] = otherTourReservation.getTour().getDestination() + " "
									+ otherTourReservation.getTour().getDateIntervalString();
							rowData[2] = otherTourReservation.getCustomer().getName();
							rowData[3] = otherTourReservation.getPassengersString();
							rowData[4] = otherTourReservation.getTotalPrice();
							tourResTableModel.addRow(rowData);
						}
					}
				}
			}

			public void removeUpdate(DocumentEvent e) {
				DefaultTableModel tourResTableModel;
				deleteAllRows(tourResTableModel = (DefaultTableModel) tableTourReservations.getModel());
				String searchText;
				if (!(searchText = searchTourResTextField.getText()).equals("")) {
					Object[] rowData = new Object[5];
					for (int i = 0; i < reservationsArchive.size(); i++) {
						String name = reservationsArchive.get(i).getCustomer().getName();
						String substringOfName = name.substring(0,
								searchText.length() <= name.length() ? searchText.length() : name.length());
						if (substringOfName.equals(searchText)
								&& reservationsArchive.get(i) instanceof TourReservation) {
							TourReservation otherTourReservation = (TourReservation) reservationsArchive.get(i);
							rowData[0] = otherTourReservation.getReservationNumber();
							rowData[1] = otherTourReservation.getTour().getDestination() + " "
									+ otherTourReservation.getTour().getDateIntervalString();
							rowData[2] = otherTourReservation.getCustomer().getName();
							rowData[3] = otherTourReservation.getPassengersString();
							rowData[4] = otherTourReservation.getTotalPrice();
							tourResTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(tourResTableModel = (DefaultTableModel) tableTourReservations.getModel());
					Object[] rowData = new Object[5];
					for (int i = 0; i < reservationsArchive.size(); i++) {
						if (reservationsArchive.get(i) instanceof TourReservation) {
							TourReservation otherTourReservation = (TourReservation) reservationsArchive.get(i);
							rowData[0] = otherTourReservation.getReservationNumber();
							rowData[1] = otherTourReservation.getTour().getDestination() + " "
									+ otherTourReservation.getTour().getDateIntervalString();
							rowData[2] = otherTourReservation.getCustomer().getName();
							rowData[3] = otherTourReservation.getPassengersString();
							rowData[4] = otherTourReservation.getTotalPrice();
							tourResTableModel.addRow(rowData);
						}
					}
				}
			}

			public void insertUpdate(DocumentEvent e) {
				DefaultTableModel tourResTableModel;
				deleteAllRows(tourResTableModel = (DefaultTableModel) tableTourReservations.getModel());
				String searchText;
				if (!(searchText = searchTourResTextField.getText()).equals("")) {
					Object[] rowData = new Object[5];
					for (int i = 0; i < reservationsArchive.size(); i++) {
						String name = reservationsArchive.get(i).getCustomer().getName();
						String substringOfName = name.substring(0,
								searchText.length() <= name.length() ? searchText.length() : name.length());
						if (substringOfName.equals(searchText)
								&& reservationsArchive.get(i) instanceof TourReservation) {
							TourReservation otherTourReservation = (TourReservation) reservationsArchive.get(i);
							rowData[0] = otherTourReservation.getReservationNumber();
							rowData[1] = otherTourReservation.getTour().getDestination() + " "
									+ otherTourReservation.getTour().getDateIntervalString();
							rowData[2] = otherTourReservation.getCustomer().getName();
							rowData[3] = otherTourReservation.getPassengersString();
							rowData[4] = otherTourReservation.getTotalPrice();
							tourResTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(tourResTableModel = (DefaultTableModel) tableTourReservations.getModel());
					Object[] rowData = new Object[5];
					for (int i = 0; i < reservationsArchive.size(); i++) {
						if (reservationsArchive.get(i) instanceof TourReservation) {
							TourReservation otherTourReservation = (TourReservation) reservationsArchive.get(i);
							rowData[0] = otherTourReservation.getReservationNumber();
							rowData[1] = otherTourReservation.getTour().getDestination() + " "
									+ otherTourReservation.getTour().getDateIntervalString();
							rowData[2] = otherTourReservation.getCustomer().getName();
							rowData[3] = otherTourReservation.getPassengersString();
							rowData[4] = otherTourReservation.getTotalPrice();
							tourResTableModel.addRow(rowData);
						}
					}
				}
			}
		});

		/**
		 * This searches for Tour in tourrArchive by name of destination
		 * according to the symbols in searchTourTExtField TextField. Adds
		 * suitable Tours in tableTours table and always refreshing tableTours
		 * table every time a symbol was added in searchTourTExtField TextField
		 * by removing no more unsuitable Tours from the tableTours table and
		 * adding new once that are suitable
		 */

		searchTourTExtField.getDocument().addDocumentListener(new DocumentListener() {
			public void deleteAllRows(final DefaultTableModel model) {
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				DefaultTableModel toursTableModel;
				deleteAllRows(toursTableModel = (DefaultTableModel) tableTours.getModel());
				String searchText;
				if (!(searchText = searchTourTExtField.getText()).equals("")) {
					Object[] rowData = new Object[9];
					for (int i = 0; i < toursArchive.size(); i++) {
						String destination = toursArchive.get(i).getDestination();
						String substringOfDestination = destination.substring(0,
								searchText.length() <= destination.length() ? searchText.length()
										: destination.length());
						if (substringOfDestination.equals(searchText)) {
							rowData[0] = toursArchive.get(i).getDepartureDate();
							rowData[1] = toursArchive.get(i).getDestination();
							rowData[2] = toursArchive.get(i).getPickUpPlacesString();
							rowData[3] = toursArchive.get(i).getSeatsAvailable();
							rowData[4] = toursArchive.get(i).getTotalPrice();
							rowData[5] = toursArchive.get(i).getPricePerPassenger();
							rowData[6] = toursArchive.get(i).getBusAndType();
							rowData[7] = toursArchive.get(i).getChauffeur();
							rowData[8] = toursArchive.get(i).getServicesString();
							toursTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(toursTableModel = (DefaultTableModel) tableTours.getModel());
					Object[] rowData = new Object[9];
					for (int i = 0; i < toursArchive.size(); i++) {
						rowData[0] = toursArchive.get(i).getDepartureDate();
						rowData[1] = toursArchive.get(i).getDestination();
						rowData[2] = toursArchive.get(i).getPickUpPlacesString();
						rowData[3] = toursArchive.get(i).getSeatsAvailable();
						rowData[4] = toursArchive.get(i).getTotalPrice();
						rowData[5] = toursArchive.get(i).getPricePerPassenger();
						rowData[6] = toursArchive.get(i).getBusAndType();
						rowData[7] = toursArchive.get(i).getChauffeur();
						rowData[8] = toursArchive.get(i).getServicesString();
						toursTableModel.addRow(rowData);
					}
				}
			}

			public void removeUpdate(DocumentEvent e) {
				DefaultTableModel toursTableModel;
				deleteAllRows(toursTableModel = (DefaultTableModel) tableTours.getModel());
				String searchText;
				if (!(searchText = searchTourTExtField.getText()).equals("")) {
					Object[] rowData = new Object[9];
					for (int i = 0; i < toursArchive.size(); i++) {
						String destination = toursArchive.get(i).getDestination();
						String substringOfDestination = destination.substring(0,
								searchText.length() <= destination.length() ? searchText.length()
										: destination.length());
						if (substringOfDestination.equals(searchText)) {
							rowData[0] = toursArchive.get(i).getDepartureDate();
							rowData[1] = toursArchive.get(i).getDestination();
							rowData[2] = toursArchive.get(i).getPickUpPlacesString();
							rowData[3] = toursArchive.get(i).getSeatsAvailable();
							rowData[4] = toursArchive.get(i).getTotalPrice();
							rowData[5] = toursArchive.get(i).getPricePerPassenger();
							rowData[6] = toursArchive.get(i).getBusAndType();
							rowData[7] = toursArchive.get(i).getChauffeur();
							rowData[8] = toursArchive.get(i).getServicesString();
							toursTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(toursTableModel = (DefaultTableModel) tableTours.getModel());
					Object[] rowData = new Object[9];
					for (int i = 0; i < toursArchive.size(); i++) {
						rowData[0] = toursArchive.get(i).getDepartureDate();
						rowData[1] = toursArchive.get(i).getDestination();
						rowData[2] = toursArchive.get(i).getPickUpPlacesString();
						rowData[3] = toursArchive.get(i).getSeatsAvailable();
						rowData[4] = toursArchive.get(i).getTotalPrice();
						rowData[5] = toursArchive.get(i).getPricePerPassenger();
						rowData[6] = toursArchive.get(i).getBusAndType();
						rowData[7] = toursArchive.get(i).getChauffeur();
						rowData[8] = toursArchive.get(i).getServicesString();
						toursTableModel.addRow(rowData);
					}
				}
			}

			public void insertUpdate(DocumentEvent e) {
				DefaultTableModel toursTableModel;
				deleteAllRows(toursTableModel = (DefaultTableModel) tableTours.getModel());
				String searchText;
				if (!(searchText = searchTourTExtField.getText()).equals("")) {
					Object[] rowData = new Object[9];
					for (int i = 0; i < toursArchive.size(); i++) {
						String destination = toursArchive.get(i).getDestination();
						String substringOfDestination = destination.substring(0,
								searchText.length() <= destination.length() ? searchText.length()
										: destination.length());
						if (substringOfDestination.equals(searchText)) {
							rowData[0] = toursArchive.get(i).getDepartureDate();
							rowData[1] = toursArchive.get(i).getDestination();
							rowData[2] = toursArchive.get(i).getPickUpPlacesString();
							rowData[3] = toursArchive.get(i).getSeatsAvailable();
							rowData[4] = toursArchive.get(i).getTotalPrice();
							rowData[5] = toursArchive.get(i).getPricePerPassenger();
							rowData[6] = toursArchive.get(i).getBusAndType();
							rowData[7] = toursArchive.get(i).getChauffeur();
							rowData[8] = toursArchive.get(i).getServicesString();
							toursTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(toursTableModel = (DefaultTableModel) tableTours.getModel());
					Object[] rowData = new Object[9];
					for (int i = 0; i < toursArchive.size(); i++) {
						rowData[0] = toursArchive.get(i).getDepartureDate();
						rowData[1] = toursArchive.get(i).getDestination();
						rowData[2] = toursArchive.get(i).getPickUpPlacesString();
						rowData[3] = toursArchive.get(i).getSeatsAvailable();
						rowData[4] = toursArchive.get(i).getTotalPrice();
						rowData[5] = toursArchive.get(i).getPricePerPassenger();
						rowData[6] = toursArchive.get(i).getBusAndType();
						rowData[7] = toursArchive.get(i).getChauffeur();
						rowData[8] = toursArchive.get(i).getServicesString();
						toursTableModel.addRow(rowData);
					}
				}
			}
		});

		/**
		 * This searches for Chauffeurs in chauffeursArchive by name of this
		 * Chauffeur according to the symbols in searchChauffeurTextField
		 * TextField. Adds suitable Chauffeurs in tableChauffeurs table and
		 * always refreshing tableChauffeurs table every time a symbol was added
		 * in searchChauffeurTextField TextField by removing no more unsuitable
		 * Chauffeurs from the tableChauffeurs table and adding new once that
		 * are suitable
		 */

		searchChauffeurTextField.getDocument().addDocumentListener(new DocumentListener() {
			public void deleteAllRows(final DefaultTableModel model) {
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				DefaultTableModel chauffeurTableModel;
				deleteAllRows(chauffeurTableModel = (DefaultTableModel) tableChauffeurs.getModel());
				String searchText;
				if (!(searchText = searchChauffeurTextField.getText()).equals("")) {
					Object[] rowData = new Object[8];
					for (int i = 0; i < chauffeursArchive.size(); i++) {
						String name = chauffeursArchive.get(i).getName();
						String substringOfName = name.substring(0,
								searchText.length() <= name.length() ? searchText.length() : name.length());
						if (substringOfName.equals(searchText)) {
							rowData[0] = chauffeursArchive.get(i).getEmployeeNumber();
							rowData[1] = chauffeursArchive.get(i).getEarliestDepartureString();
							rowData[2] = chauffeursArchive.get(i).getName();
							rowData[3] = chauffeursArchive.get(i).getAddress();
							rowData[4] = chauffeursArchive.get(i).getEmail();
							rowData[5] = chauffeursArchive.get(i).getPhonenumber();
							rowData[6] = chauffeursArchive.get(i).getBirthDay();
							rowData[7] = chauffeursArchive.get(i).isOnlyOneDayTrips();
							chauffeurTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(chauffeurTableModel = (DefaultTableModel) tableChauffeurs.getModel());
					Object[] rowData = new Object[8];
					for (int i = 0; i < chauffeursArchive.size(); i++) {
						rowData[0] = chauffeursArchive.get(i).getEmployeeNumber();
						rowData[1] = chauffeursArchive.get(i).getEarliestDepartureString();
						rowData[2] = chauffeursArchive.get(i).getName();
						rowData[3] = chauffeursArchive.get(i).getAddress();
						rowData[4] = chauffeursArchive.get(i).getEmail();
						rowData[5] = chauffeursArchive.get(i).getPhonenumber();
						rowData[6] = chauffeursArchive.get(i).getBirthDay();
						rowData[7] = chauffeursArchive.get(i).isOnlyOneDayTrips();
						chauffeurTableModel.addRow(rowData);
					}
				}
			}

			public void removeUpdate(DocumentEvent e) {
				DefaultTableModel chauffeurTableModel;
				deleteAllRows(chauffeurTableModel = (DefaultTableModel) tableChauffeurs.getModel());
				String searchText;
				if (!(searchText = searchChauffeurTextField.getText()).equals("")) {
					Object[] rowData = new Object[8];
					for (int i = 0; i < chauffeursArchive.size(); i++) {
						String name = chauffeursArchive.get(i).getName();
						String substringOfName = name.substring(0,
								searchText.length() <= name.length() ? searchText.length() : name.length());
						if (substringOfName.equals(searchText)) {
							rowData[0] = chauffeursArchive.get(i).getEmployeeNumber();
							rowData[1] = chauffeursArchive.get(i).getEarliestDepartureString();
							rowData[2] = chauffeursArchive.get(i).getName();
							rowData[3] = chauffeursArchive.get(i).getAddress();
							rowData[4] = chauffeursArchive.get(i).getEmail();
							rowData[5] = chauffeursArchive.get(i).getPhonenumber();
							rowData[6] = chauffeursArchive.get(i).getBirthDay();
							rowData[7] = chauffeursArchive.get(i).isOnlyOneDayTrips();
							chauffeurTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(chauffeurTableModel = (DefaultTableModel) tableChauffeurs.getModel());
					Object[] rowData = new Object[8];
					for (int i = 0; i < chauffeursArchive.size(); i++) {
						rowData[0] = chauffeursArchive.get(i).getEmployeeNumber();
						rowData[1] = chauffeursArchive.get(i).getEarliestDepartureString();
						rowData[2] = chauffeursArchive.get(i).getName();
						rowData[3] = chauffeursArchive.get(i).getAddress();
						rowData[4] = chauffeursArchive.get(i).getEmail();
						rowData[5] = chauffeursArchive.get(i).getPhonenumber();
						rowData[6] = chauffeursArchive.get(i).getBirthDay();
						rowData[7] = chauffeursArchive.get(i).isOnlyOneDayTrips();
						chauffeurTableModel.addRow(rowData);
					}
				}
			}

			public void insertUpdate(DocumentEvent e) {
				DefaultTableModel chauffeurTableModel;
				deleteAllRows(chauffeurTableModel = (DefaultTableModel) tableChauffeurs.getModel());
				String searchText;
				if (!(searchText = searchChauffeurTextField.getText()).equals("")) {
					Object[] rowData = new Object[8];
					for (int i = 0; i < chauffeursArchive.size(); i++) {
						String name = chauffeursArchive.get(i).getName();
						String substringOfName = name.substring(0,
								searchText.length() <= name.length() ? searchText.length() : name.length());
						if (substringOfName.equals(searchText)) {
							rowData[0] = chauffeursArchive.get(i).getEmployeeNumber();
							rowData[1] = chauffeursArchive.get(i).getEarliestDepartureString();
							rowData[2] = chauffeursArchive.get(i).getName();
							rowData[3] = chauffeursArchive.get(i).getAddress();
							rowData[4] = chauffeursArchive.get(i).getEmail();
							rowData[5] = chauffeursArchive.get(i).getPhonenumber();
							rowData[6] = chauffeursArchive.get(i).getBirthDay();
							rowData[7] = chauffeursArchive.get(i).isOnlyOneDayTrips();
							chauffeurTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(chauffeurTableModel = (DefaultTableModel) tableChauffeurs.getModel());
					Object[] rowData = new Object[8];
					for (int i = 0; i < chauffeursArchive.size(); i++) {
						rowData[0] = chauffeursArchive.get(i).getEmployeeNumber();
						rowData[1] = chauffeursArchive.get(i).getEarliestDepartureString();
						rowData[2] = chauffeursArchive.get(i).getName();
						rowData[3] = chauffeursArchive.get(i).getAddress();
						rowData[4] = chauffeursArchive.get(i).getEmail();
						rowData[5] = chauffeursArchive.get(i).getPhonenumber();
						rowData[6] = chauffeursArchive.get(i).getBirthDay();
						rowData[7] = chauffeursArchive.get(i).isOnlyOneDayTrips();
						chauffeurTableModel.addRow(rowData);
					}
				}
			}
		});

		/**
		 * This searches for Buses in busesArchive by vechicleID of this Bus
		 * according to the symbols in searchBusTextField TextField. Adds
		 * suitable Buses in tableBuses table and always refreshing
		 * tableChauffeurs table every time a symbol was added in
		 * searchBusTextField TextField by removing no more unsuitable Buses
		 * from the tableBuses table and adding new once that are suitable
		 */

		searchBusTextField.getDocument().addDocumentListener(new DocumentListener() {
			public void deleteAllRows(final DefaultTableModel model) {
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				DefaultTableModel busTableModel;
				deleteAllRows(busTableModel = (DefaultTableModel) tableBuses.getModel());
				String searchText;
				if (!(searchText = searchBusTextField.getText()).equals("")) {
					Object[] rowData = new Object[6];
					for (int i = 0; i < busesArchive.size(); i++) {
						String vehicleID = busesArchive.get(i).getVehicleID();
						String substringOfVehicleID = vehicleID.substring(0,
								searchText.length() <= vehicleID.length() ? searchText.length() : vehicleID.length());
						if (substringOfVehicleID.equals(searchText)) {
							rowData[0] = busesArchive.get(i).getVehicleID();
							rowData[1] = busesArchive.get(i).getPricePerHour();
							rowData[2] = busesArchive.get(i).getMaxNumberOfSeats();
							rowData[3] = busesArchive.get(i).getEarliestDepartureString();
							rowData[4] = busesArchive.get(i).getModelString();
							rowData[5] = busesArchive.get(i).isAvailableForTours();
							busTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(busTableModel = (DefaultTableModel) tableBuses.getModel());
					Object[] rowData = new Object[6];
					for (int i = 0; i < busesArchive.size(); i++) {
						rowData[0] = busesArchive.get(i).getVehicleID();
						rowData[1] = busesArchive.get(i).getPricePerHour();
						rowData[2] = busesArchive.get(i).getMaxNumberOfSeats();
						rowData[3] = busesArchive.get(i).getEarliestDepartureString();
						rowData[4] = busesArchive.get(i).getModelString();
						rowData[5] = busesArchive.get(i).isAvailableForTours();
						busTableModel.addRow(rowData);
					}
				}
			}

			public void removeUpdate(DocumentEvent e) {
				DefaultTableModel busTableModel;
				deleteAllRows(busTableModel = (DefaultTableModel) tableBuses.getModel());
				String searchText;
				if (!(searchText = searchBusTextField.getText()).equals("")) {
					Object[] rowData = new Object[6];
					for (int i = 0; i < busesArchive.size(); i++) {
						String vehicleID = busesArchive.get(i).getVehicleID();
						String substringOfVehicleID = vehicleID.substring(0,
								searchText.length() <= vehicleID.length() ? searchText.length() : vehicleID.length());
						if (substringOfVehicleID.equals(searchText)) {
							rowData[0] = busesArchive.get(i).getVehicleID();
							rowData[1] = busesArchive.get(i).getPricePerHour();
							rowData[2] = busesArchive.get(i).getMaxNumberOfSeats();
							rowData[3] = busesArchive.get(i).getEarliestDepartureString();
							rowData[4] = busesArchive.get(i).getModelString();
							rowData[5] = busesArchive.get(i).isAvailableForTours();
							busTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(busTableModel = (DefaultTableModel) tableBuses.getModel());
					Object[] rowData = new Object[6];
					for (int i = 0; i < busesArchive.size(); i++) {
						rowData[0] = busesArchive.get(i).getVehicleID();
						rowData[1] = busesArchive.get(i).getPricePerHour();
						rowData[2] = busesArchive.get(i).getMaxNumberOfSeats();
						rowData[3] = busesArchive.get(i).getEarliestDepartureString();
						rowData[4] = busesArchive.get(i).getModelString();
						rowData[5] = busesArchive.get(i).isAvailableForTours();
						busTableModel.addRow(rowData);
					}
				}
			}

			public void insertUpdate(DocumentEvent e) {
				DefaultTableModel busTableModel;
				deleteAllRows(busTableModel = (DefaultTableModel) tableBuses.getModel());
				String searchText;
				if (!(searchText = searchBusTextField.getText()).equals("")) {
					Object[] rowData = new Object[6];
					for (int i = 0; i < busesArchive.size(); i++) {
						String vehicleID = busesArchive.get(i).getVehicleID();
						String substringOfVehicleID = vehicleID.substring(0,
								searchText.length() <= vehicleID.length() ? searchText.length() : vehicleID.length());
						if (substringOfVehicleID.equals(searchText)) {
							rowData[0] = busesArchive.get(i).getVehicleID();
							rowData[1] = busesArchive.get(i).getPricePerHour();
							rowData[2] = busesArchive.get(i).getMaxNumberOfSeats();
							rowData[3] = busesArchive.get(i).getEarliestDepartureString();
							rowData[4] = busesArchive.get(i).getModelString();
							rowData[5] = busesArchive.get(i).isAvailableForTours();
							busTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(busTableModel = (DefaultTableModel) tableBuses.getModel());
					Object[] rowData = new Object[6];
					for (int i = 0; i < busesArchive.size(); i++) {
						rowData[0] = busesArchive.get(i).getVehicleID();
						rowData[1] = busesArchive.get(i).getPricePerHour();
						rowData[2] = busesArchive.get(i).getMaxNumberOfSeats();
						rowData[3] = busesArchive.get(i).getEarliestDepartureString();
						rowData[4] = busesArchive.get(i).getModelString();
						rowData[5] = busesArchive.get(i).isAvailableForTours();
						busTableModel.addRow(rowData);
					}
				}
			}
		});

		/**
		 * This searches for Customers in customersArchive by name of this
		 * Customer according to the symbols in
		 * searchCustomerInCustomerPanelTextField TextField. Adds suitable
		 * Customers in tableCustomers table and always refreshing
		 * tableCustomers table every time a symbol was added in
		 * searchCustomerInCustomerPanelTextField TextField by removing no more
		 * unsuitable Customers from the tableCustomers table and adding new
		 * once that are suitable
		 */

		searchCustomerInCustomerPanelTextField.getDocument().addDocumentListener(new DocumentListener() {
			public void deleteAllRows(final DefaultTableModel model) {
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				DefaultTableModel customersTableModel;
				deleteAllRows(customersTableModel = (DefaultTableModel) tableCustomers.getModel());
				String searchText;
				if (!(searchText = searchCustomerInCustomerPanelTextField.getText()).equals("")) {
					Object[] rowData = new Object[9];
					for (int i = 0; i < customersArchive.getListOfCustomers().size(); i++) {
						String customersName = customersArchive.getListOfCustomers().get(i).getName();
						String substringOfName = customersName.substring(0,
								searchText.length() <= customersName.length() ? searchText.length()
										: customersName.length());
						if (substringOfName.equals(searchText)) {
							rowData[0] = customersArchive.get(i).getName();
							rowData[1] = customersArchive.get(i).getOrganisationType();
							rowData[2] = customersArchive.get(i).getPhonenumber();
							rowData[3] = customersArchive.get(i).getName();
							rowData[4] = customersArchive.get(i).getAddress();
							rowData[5] = customersArchive.get(i).getEmail();
							rowData[6] = customersArchive.get(i).getBirthday().displayDate();
							rowData[7] = customersArchive.get(i).getMoneySpent();
							rowData[8] = customersArchive.get(i).getDiscount();
							customersTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(customersTableModel = (DefaultTableModel) tableCustomers.getModel());
					Object[] rowData = new Object[9];
					for (int i = 0; i < customersArchive.getListOfCustomers().size(); i++) {
						rowData[0] = customersArchive.get(i).getName();
						rowData[1] = customersArchive.get(i).getOrganisationType();
						rowData[2] = customersArchive.get(i).getPhonenumber();
						rowData[3] = customersArchive.get(i).getName();
						rowData[4] = customersArchive.get(i).getAddress();
						rowData[5] = customersArchive.get(i).getEmail();
						rowData[6] = customersArchive.get(i).getBirthday().displayDate();
						rowData[7] = customersArchive.get(i).getMoneySpent();
						rowData[8] = customersArchive.get(i).getDiscount();
						customersTableModel.addRow(rowData);
					}
				}
			}

			public void removeUpdate(DocumentEvent e) {
				DefaultTableModel customersTableModel;
				deleteAllRows(customersTableModel = (DefaultTableModel) tableCustomers.getModel());
				String searchText;
				if (!(searchText = searchCustomerInCustomerPanelTextField.getText()).equals("")) {
					Object[] rowData = new Object[9];
					for (int i = 0; i < customersArchive.getListOfCustomers().size(); i++) {
						String customersName = customersArchive.getListOfCustomers().get(i).getName();
						String substringOfName = customersName.substring(0,
								searchText.length() <= customersName.length() ? searchText.length()
										: customersName.length());
						if (substringOfName.equals(searchText)) {
							rowData[0] = customersArchive.get(i).getName();
							rowData[1] = customersArchive.get(i).getOrganisationType();
							rowData[2] = customersArchive.get(i).getPhonenumber();
							rowData[3] = customersArchive.get(i).getName();
							rowData[4] = customersArchive.get(i).getAddress();
							rowData[5] = customersArchive.get(i).getEmail();
							rowData[6] = customersArchive.get(i).getBirthday().displayDate();
							rowData[7] = customersArchive.get(i).getMoneySpent();
							rowData[8] = customersArchive.get(i).getDiscount();
							customersTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(customersTableModel = (DefaultTableModel) tableCustomers.getModel());
					Object[] rowData = new Object[9];
					for (int i = 0; i < customersArchive.getListOfCustomers().size(); i++) {
						rowData[0] = customersArchive.get(i).getName();
						rowData[1] = customersArchive.get(i).getOrganisationType();
						rowData[2] = customersArchive.get(i).getPhonenumber();
						rowData[3] = customersArchive.get(i).getName();
						rowData[4] = customersArchive.get(i).getAddress();
						rowData[5] = customersArchive.get(i).getEmail();
						rowData[6] = customersArchive.get(i).getBirthday().displayDate();
						rowData[7] = customersArchive.get(i).getMoneySpent();
						rowData[8] = customersArchive.get(i).getDiscount();
						customersTableModel.addRow(rowData);
					}
				}
			}

			public void insertUpdate(DocumentEvent e) {
				DefaultTableModel customersTableModel;
				deleteAllRows(customersTableModel = (DefaultTableModel) tableCustomers.getModel());
				String searchText;
				if (!(searchText = searchCustomerInCustomerPanelTextField.getText()).equals("")) {
					Object[] rowData = new Object[9];
					for (int i = 0; i < customersArchive.getListOfCustomers().size(); i++) {
						String customersName = customersArchive.getListOfCustomers().get(i).getName();
						String substringOfName = customersName.substring(0,
								searchText.length() <= customersName.length() ? searchText.length()
										: customersName.length());
						if (substringOfName.equals(searchText)) {
							rowData[0] = customersArchive.get(i).getName();
							rowData[1] = customersArchive.get(i).getOrganisationType();
							rowData[2] = customersArchive.get(i).getPhonenumber();
							rowData[3] = customersArchive.get(i).getName();
							rowData[4] = customersArchive.get(i).getAddress();
							rowData[5] = customersArchive.get(i).getEmail();
							rowData[6] = customersArchive.get(i).getBirthday().displayDate();
							rowData[7] = customersArchive.get(i).getMoneySpent();
							rowData[8] = customersArchive.get(i).getDiscount();
							customersTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(customersTableModel = (DefaultTableModel) tableCustomers.getModel());
					Object[] rowData = new Object[9];
					for (int i = 0; i < customersArchive.getListOfCustomers().size(); i++) {
						rowData[0] = customersArchive.get(i).getName();
						rowData[1] = customersArchive.get(i).getOrganisationType();
						rowData[2] = customersArchive.get(i).getPhonenumber();
						rowData[3] = customersArchive.get(i).getName();
						rowData[4] = customersArchive.get(i).getAddress();
						rowData[5] = customersArchive.get(i).getEmail();
						rowData[6] = customersArchive.get(i).getBirthday().displayDate();
						rowData[7] = customersArchive.get(i).getMoneySpent();
						rowData[8] = customersArchive.get(i).getDiscount();
						customersTableModel.addRow(rowData);
					}
				}
			}
		});

		/**
		 * This searches for Passengers in passengersArchive by name of this
		 * Passenger according to the symbols in searchPassengerTextField
		 * TextField. Adds suitable Passengers in tablePassengers table and
		 * always refreshing tablePassengers table every time a symbol was added
		 * in searchPassengerTextField TextField by removing no more unsuitable
		 * Passengers from the tablePassengers table and adding new once that
		 * are suitable
		 */

		searchPassengerTextField.getDocument().addDocumentListener(new DocumentListener() {
			public void deleteAllRows(final DefaultTableModel model) {
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				DefaultTableModel passengersTableModel;
				deleteAllRows(passengersTableModel = (DefaultTableModel) tablePassengers.getModel());
				String searchText;
				if (!(searchText = searchPassengerTextField.getText()).equals("")) {
					Object[] rowData = new Object[5];
					for (int i = 0; i < passengersArchive.size(); i++) {
						String passengersName = passengersArchive.get(i).getName();
						String substringOfName = passengersName.substring(0,
								searchText.length() <= passengersName.length() ? searchText.length()
										: passengersName.length());
						if (substringOfName.equals(searchText)) {
							rowData[0] = passengersArchive.get(i).getName();
							;
							rowData[1] = passengersArchive.get(i).getAddress();
							rowData[2] = passengersArchive.get(i).getPhonenumber();
							rowData[3] = passengersArchive.get(i).getEmail();
							rowData[4] = passengersArchive.get(i).getBirthday().displayDate();
							passengersTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(passengersTableModel = (DefaultTableModel) tablePassengers.getModel());
					Object[] rowData = new Object[5];
					for (int i = 0; i < passengersArchive.size(); i++) {
						rowData[0] = passengersArchive.get(i).getName();
						;
						rowData[1] = passengersArchive.get(i).getAddress();
						rowData[2] = passengersArchive.get(i).getPhonenumber();
						rowData[3] = passengersArchive.get(i).getEmail();
						rowData[4] = passengersArchive.get(i).getBirthday().displayDate();
						passengersTableModel.addRow(rowData);
					}
				}
			}

			public void removeUpdate(DocumentEvent e) {
				DefaultTableModel passengersTableModel;
				deleteAllRows(passengersTableModel = (DefaultTableModel) tablePassengers.getModel());
				String searchText;
				if (!(searchText = searchPassengerTextField.getText()).equals("")) {
					Object[] rowData = new Object[5];
					for (int i = 0; i < passengersArchive.size(); i++) {
						String passengersName = passengersArchive.get(i).getName();
						String substringOfName = passengersName.substring(0,
								searchText.length() <= passengersName.length() ? searchText.length()
										: passengersName.length());
						if (substringOfName.equals(searchText)) {
							rowData[0] = passengersArchive.get(i).getName();
							;
							rowData[1] = passengersArchive.get(i).getAddress();
							rowData[2] = passengersArchive.get(i).getPhonenumber();
							rowData[3] = passengersArchive.get(i).getEmail();
							rowData[4] = passengersArchive.get(i).getBirthday().displayDate();
							passengersTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(passengersTableModel = (DefaultTableModel) tablePassengers.getModel());
					Object[] rowData = new Object[5];
					for (int i = 0; i < passengersArchive.size(); i++) {
						rowData[0] = passengersArchive.get(i).getName();
						;
						rowData[1] = passengersArchive.get(i).getAddress();
						rowData[2] = passengersArchive.get(i).getPhonenumber();
						rowData[3] = passengersArchive.get(i).getEmail();
						rowData[4] = passengersArchive.get(i).getBirthday().displayDate();
						passengersTableModel.addRow(rowData);
					}
				}
			}

			public void insertUpdate(DocumentEvent e) {
				DefaultTableModel passengersTableModel;
				deleteAllRows(passengersTableModel = (DefaultTableModel) tablePassengers.getModel());
				String searchText;
				if (!(searchText = searchPassengerTextField.getText()).equals("")) {
					Object[] rowData = new Object[5];
					for (int i = 0; i < passengersArchive.size(); i++) {
						String passengersName = passengersArchive.get(i).getName();
						String substringOfName = passengersName.substring(0,
								searchText.length() <= passengersName.length() ? searchText.length()
										: passengersName.length());
						if (substringOfName.equals(searchText)) {
							rowData[0] = passengersArchive.get(i).getName();
							;
							rowData[1] = passengersArchive.get(i).getAddress();
							rowData[2] = passengersArchive.get(i).getPhonenumber();
							rowData[3] = passengersArchive.get(i).getEmail();
							rowData[4] = passengersArchive.get(i).getBirthday().displayDate();
							passengersTableModel.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(passengersTableModel = (DefaultTableModel) tablePassengers.getModel());
					Object[] rowData = new Object[5];
					for (int i = 0; i < passengersArchive.size(); i++) {
						rowData[0] = passengersArchive.get(i).getName();
						;
						rowData[1] = passengersArchive.get(i).getAddress();
						rowData[2] = passengersArchive.get(i).getPhonenumber();
						rowData[3] = passengersArchive.get(i).getEmail();
						rowData[4] = passengersArchive.get(i).getBirthday().displayDate();
						passengersTableModel.addRow(rowData);
					}
				}
			}
		});

		lblSelectBusNewBusResButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This updates textPaneSummaryNewBus from
			 * panelNewBusReservationNext JPanel with the information filled in
			 * panelNewBusReservation JPanel fields after the button has been
			 * pressed
			 */
			public void mouseReleased(MouseEvent e) {
				updateSummaryNewBus();
			}
		});
		textFieldNewBusStartMonth.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusStartMonth field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusStartMonth field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusStartMonth field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());

			}

		});

		textFieldNewBusStartDay.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusStartDay field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusStartMonth field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusStartMonth field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());

			}

		});

		textFieldNewBusStartYear.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusStartYear field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusStartYear field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusStartYear field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());

			}

		});

		startHourInNewBusRes.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * startHourInNewBus field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * startHourInNewBus field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * startHourInNewBus field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());

			}

		});

		startMinuteInNewBusRes.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * startMinuteInNewBus field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * startMinuteInNewBus field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * startMinuteInNewBus field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());

			}

		});

		textFieldNewBusEndMonth.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusEndMonth field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusEndMonth field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusEndMonth field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());

			}

		});

		textFieldNewBusEndDay.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusEndDay field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusEndDay field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusEndDay field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());

			}

		});

		textFieldNewBusEndYear.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusEndYear field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusEndYear field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldNewBusEndYear field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());

			}

		});

		endtHourInNewBusRes.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * endtHourInNewBusRes field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * endtHourInNewBusRes field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * endtHourInNewBusResfield field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());

			}

		});

		endMinuteInNewBusRes.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * endtMinutesInNewBusRes field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * endtMinutesInNewBusRes field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * endtMinutesInNewBusRes field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableNewBusSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableNewBusSelectChauffeur.getModel());

			}
		});

		lblClearButtonCustomer.addMouseListener(new MouseAdapter() {
			/**
			 * This cancels Updating Existing Customer. After the button has
			 * been pressed, an okOrCancel notification pops and asks the user
			 * if he really wants to cancel updating. If the user clicks yes,
			 * customerPhone, customerName, customerEmail, customerAddress,
			 * customerMonth, customerDay, customerYear, customerOrganisation,
			 * radioButtonCompany, radioButtonSchool, radioButtonPrivate are
			 * cleared
			 */
			@Override
			public void mouseReleased(MouseEvent e) {
				if (okOrCancel("Are you sure you want to cancel updating?") == 0) {
					currentlyUpdatingCustomer = null;
					customerPhone.setText("");
					customerName.setText("");
					customerEmail.setText("");
					customerAddress.setText("");
					customerMonth.setText("");
					customerDay.setText("");
					customerYear.setText("");
					customerOrganisation.setText("");
					radioButtonCompany.setSelected(false);
					radioButtonSchool.setSelected(false);
					radioButtonPrivate.setSelected(false);

				}
			}
		});

		lblDeleteCustomerPanel.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This deletes selected Customer from tableCustomers. After the
			 * button was pressed, an okOrCancel notification pops up and asks
			 * the user if he really wants to delete this customer. If the user
			 * clicks OK, the selected Customer is deleted from tableCustomers
			 * table and from the customersArchive. CustomerArchive is saved
			 */
			public void mouseReleased(MouseEvent e) {
				if (okOrCancel("Are you sure you want to delete this customer?") == 0) {
					customersArchive.removeCustomer(tableCustomers.getSelectedRow());
					try {
						customersArchive.saveCustomersArchive();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					listCustomers();
				}
			}
		});

		lblUpdateCustomerButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			/**
			 * This button adds information of the selected Customer from
			 * tableCustomers table in customerPhone,
			 * customerMoneySpentTextField, customerOrganisation, customerName,
			 * customerAddress, customerEmail, customerMonth, customerDay,
			 * customerYear fields. If the organisation type is PRIVATE, then
			 * radioButtonPrivate is selected, radioButtonCompany and
			 * radioButtonSchool aren't selected. If the organisation type is
			 * SCHOOL, then radioButtonSchool is selected, radioButtonCompany
			 * and radioButtonPrivate aren't selected. If the organisation type
			 * is PARTY, then radioButtonParty is selected, radioButtonCompany
			 * and radioButtonPrivate aren't selected. If the Customer isn't
			 * selected from tableCustomers table and button was pressed, then
			 * the notification pops up with the message: "You need to select
			 * one of the customers from the table above!"
			 */
			public void mouseReleased(MouseEvent arg0) {
				if (tableCustomers.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"You need to select one of the customers from the table above!");
				} else {
					tableCustomers.disable();
					currentlyUpdatingCustomer = customersArchive.get(tableCustomers.getSelectedRow());
					customerPhone.setText(currentlyUpdatingCustomer.getPhonenumber());
					customerMoneySpentTextField.setText(String.valueOf(currentlyUpdatingCustomer.getMoneySpent()));
					customerOrganisation.setText(currentlyUpdatingCustomer.getOrganisationName());
					customerName.setText(currentlyUpdatingCustomer.getName());
					customerAddress.setText(currentlyUpdatingCustomer.getAddress());
					customerEmail.setText(currentlyUpdatingCustomer.getEmail());
					customerMonth.setText(Integer.toString(currentlyUpdatingCustomer.getBirthday().getMonth()));
					customerDay.setText(Integer.toString(currentlyUpdatingCustomer.getBirthday().getDay()));
					customerYear.setText(Integer.toString(currentlyUpdatingCustomer.getBirthday().getYear()));
					customerDiscountUpdCustomerTextField
							.setText(String.valueOf(currentlyUpdatingCustomer.getDiscount()));
					if (currentlyUpdatingCustomer.getOrganisationType().equalsIgnoreCase("PRIVATE")) {
						radioButtonCompany.setSelected(false);
						radioButtonPrivate.setSelected(true);
						radioButtonSchool.setSelected(false);
					}
					if (currentlyUpdatingCustomer.getOrganisationType().equalsIgnoreCase("COMPANY")) {
						radioButtonCompany.setSelected(true);
						radioButtonPrivate.setSelected(false);
						radioButtonSchool.setSelected(false);
					}
					if (currentlyUpdatingCustomer.getOrganisationType().equalsIgnoreCase("SCHOOL")) {
						radioButtonCompany.setSelected(false);
						radioButtonPrivate.setSelected(false);
						radioButtonSchool.setSelected(true);
					}
				}
			}
		});

		lblSaveChangesCustomerButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			/**
			 * This updates Changes for the selected Chauffeur from
			 * tableCustomers table according to customerPhone,
			 * customerMoneySpentTextField, customerOrganisation, customerName,
			 * customerAddress, customerEmail, customerMonth, customerDay,
			 * customerYear fields. If some fields aren't filled correctly, the
			 * notification pops up that says what fields are incorrect
			 */
			public void mouseReleased(MouseEvent e) {
				if (currentlyUpdatingCustomer == null)
					JOptionPane.showMessageDialog(null,
							"You should first select one of the customers and then click 'Update' button!");
				String str = new String();
				int month = 0;
				int day = 0;
				int year = 0;
				Calendar timeNow = Calendar.getInstance();
				int currentYear = timeNow.get(Calendar.YEAR);
				try {
					int phone = Integer.parseInt(customerPhone.getText());
					if (!(10000000 < phone && phone <= 99999999)) {
						str += "\nPhone number does not have 8 digits!";
					}
				} catch (Exception e3) {
					str += "\nEntered phone number does not appear to be digits!";
				}
				if (customerOrganisation.getText().equalsIgnoreCase("")) {
					str += "\nName/organisation cannot be empty!";
				}
				if (customerName.getText().equalsIgnoreCase("")) {
					str += "\nName/contact cannot be empty!";
				}
				if (customerAddress.getText().equalsIgnoreCase("")) {
					str += "\nAddress cannot be empty!";
				}
				if (customerEmail.getText().equalsIgnoreCase("")) {
					str += "\nEmail address cannot be empty!";
				}
				if (!(customerEmail.getText().contains("@") && customerEmail.getText().contains("."))) {
					str += "\nEmail address does not appear to be in correct format!";
				}

				try {
					month = Integer.parseInt(customerMonth.getText());
					if (month > 12 || month < 1)
						str = str + "\nMonth does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nMonth does not seem to be a number between 1-12!";
				}
				try {
					day = Integer.parseInt(customerDay.getText());
					if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
							|| month == 12) {
						if (!(1 <= day && day <= 31)) {
							str = str + "\nDay does not seem to be a number between 1-31!";
						}
					} else if (month == 2) {
						if (!(1 <= day && day <= 28)) {
							str = str + "\nDay does not seem to be a number between 1-28!";
						}
					} else if (month == 4 || month == 6 || month == 9 || month == 11) {
						if (!(1 <= day && day <= 30)) {
							str = str + "\nDay does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nDay does not seem to be a number between 1-31!";
				}
				try {
					year = Integer.parseInt(customerYear.getText());
					if (year > currentYear || year < currentYear - 120)
						str = str + "\nYear does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nYear does not appear to be a valid number!";
				}
				if (customerDiscountUpdCustomerTextField.getText().length() < 1
						&& customerDiscountUpdCustomerTextField.getText().length() > 5) {
					str = str + "\nDiscount is supposed to be a number between 1-3 digits!";
				}
				try {
					Double.parseDouble(customerDiscountUpdCustomerTextField.getText());

				} catch (NumberFormatException e1) {
					str = str + "\nDiscount does not appear to be a valid number!";
				}
				try {
					Double.parseDouble(customerMoneySpentTextField.getText());

				} catch (NumberFormatException e1) {
					str = str + "\nMoney spent amount does not appear to be a valid number!";
				}
				if (customerMoneySpentTextField.getText().length() < 1
						&& customerMoneySpentTextField.getText().length() > 8) {
					str = str + "\nMoney spent amount is supposed to be a number between 1-8 digits!";
				}

				if (str.equals("")) {
					if (okOrCancel("Are you sure you want to save these changes?") == 0) {

						currentlyUpdatingCustomer.setPhonenumber(customerPhone.getText());
						currentlyUpdatingCustomer
								.setMoneySpent(Double.parseDouble(customerMoneySpentTextField.getText()));
						currentlyUpdatingCustomer
								.setDiscount(Double.parseDouble(customerDiscountUpdCustomerTextField.getText()) / 100);
						currentlyUpdatingCustomer.setName(customerName.getText());
						currentlyUpdatingCustomer.setPhonenumber(customerPhone.getText());
						currentlyUpdatingCustomer.setAddress(customerAddress.getText());
						currentlyUpdatingCustomer.setEmail(customerEmail.getText());
						currentlyUpdatingCustomer.setBirthday(new Date(Integer.parseInt(customerMonth.getText()),
								Integer.parseInt(customerDay.getText()), Integer.parseInt(customerYear.getText())));
						currentlyUpdatingCustomer.setOrganisationName(customerOrganisation.getText());
						String organisationType = "PRIVATE";
						if (radioButtonCompany.isSelected()) {
							organisationType = "COMPANY";
						}
						if (radioButtonSchool.isSelected()) {
							organisationType = "SCHOOL";
						}
						currentlyUpdatingCustomer.setOrganisationType(organisationType);
						try {
							customersArchive.saveCustomersArchive();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						currentlyUpdatingCustomer = null;
						tableCustomers.enable();
						customerPhone.setText("");
						customerName.setText("");
						customerEmail.setText("");
						customerAddress.setText("");
						customerMonth.setText("");
						customerDay.setText("");
						customerYear.setText("");
						customerOrganisation.setText("");
						radioButtonCompany.setSelected(false);
						radioButtonSchool.setSelected(false);
						radioButtonPrivate.setSelected(false);
						listCustomers();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You have to fill out the fields correctly:\n" + str);
				}
			}
		});

		lblDeletePassengerButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This deletes selected Passenger from tablePassengers. After the
			 * button was pressed, an okOrCancel notification pops up and asks
			 * the user if he really wants to delete this passenger. If the user
			 * clicks OK, the selected Passenger is deleted from tablePsasengers
			 * table and from the passengersArchive. PassengersArchive is saved
			 */
			public void mouseReleased(MouseEvent e) {
				if (okOrCancel("Are you sure you want to delete this passenger?") == 0) {
					passengersArchive.removePassenger(tablePassengers.getSelectedRow());
					try {
						passengersArchive.savePassengersArchive();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					listPassengers();
					tablePassengersInNewTourReservation.removeAll();
				}
			}
		});

		/**
		 * This button adds information of the selected Passenger from
		 * tablePasengers table in passengerPhone, passengerName,
		 * passengerEmail, passengerAddress, passengerMonth, passengerDay,
		 * passengerYear after the button was pressed
		 */
		lblUpdatePassengerButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				tablePassengers.disable();
				currentlyUpdatingPassenger = passengersArchive.get(tablePassengers.getSelectedRow());
				passengerPhone.setText(currentlyUpdatingPassenger.getPhonenumber());
				passengerName.setText(currentlyUpdatingPassenger.getName());
				passengerEmail.setText(currentlyUpdatingPassenger.getEmail());
				passengerAddress.setText(currentlyUpdatingPassenger.getAddress());
				passengerMonth.setText(String.valueOf(currentlyUpdatingPassenger.getBirthday().getMonth()));
				passengerDay.setText(String.valueOf(currentlyUpdatingPassenger.getBirthday().getDay()));
				passengerYear.setText(String.valueOf(currentlyUpdatingPassenger.getBirthday().getYear()));

			}
		});

		/**
		 * This updates Changes for the selected Passenger from tablePassenger
		 * table according to passengerPhone, passengerName, passengerAddress,
		 * passengerEmail, passengerMonth, passengerDay, passengerYear fields.
		 * If some fields aren't filled correctly, the notification pops up that
		 * says what fields are incorrect
		 */
		lblAddNewPassengerButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseReleased(MouseEvent e) {
				if (currentlyUpdatingPassenger == null)
					JOptionPane.showMessageDialog(null,
							"You should first select one of the passengers and then click 'Update' button!");
				else {
					String str = "";
					int month = 0;
					int day = 0;
					int year = 0;
					Calendar timeNow = Calendar.getInstance();
					int currentYear = timeNow.get(Calendar.YEAR);
					try {
						int phone = Integer.parseInt(passengerPhone.getText());
						if (!(10000000 < phone && phone <= 99999999)) {
							str += "\nPhone number does not have 8 digits!";
						}
					} catch (Exception e3) {
						str += "\nEntered phone number does not appear to be digits!";
					}
					if (passengerName.getText().equalsIgnoreCase("")) {
						str += "\nName cannot be empty!";
					}
					if (passengerAddress.getText().equalsIgnoreCase("")) {
						str += "\nAddress cannot be empty!";
					}

					if (!(passengerEmail.getText().contains("@") && passengerEmail.getText().contains("."))) {
						str += "\nEmail appears to be either empty or incorrect format!";
					}

					try {
						month = Integer.parseInt(passengerMonth.getText());
						if (month > 12 || month < 1)
							str = str + "\nMonth does not seem to be a number between 1-12!";
					} catch (NumberFormatException e1) {
						str = str + "\nMonth does not seem to be a number between 1-12!";
					}
					try {
						day = Integer.parseInt(passengerDay.getText());
						if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
								|| month == 12) {
							if (!(1 <= day && day <= 31)) {
								str = str + "\nDay does not seem to be a number between 1-31!";
							}
						} else if (month == 2) {
							if (!(1 <= day && day <= 28)) {
								str = str + "\nDay does not seem to be a number between 1-28!";
							}
						} else if (month == 4 || month == 6 || month == 9 || month == 11) {
							if (!(1 <= day && day <= 30)) {
								str = str + "\nDay does not seem to be a number between 1-30!";
							}
						}
					} catch (NumberFormatException e1) {
						str = str + "\nDay does not seem to be a number between 1-31!";
					}
					try {
						year = Integer.parseInt(passengerYear.getText());
						if (year > currentYear || year < currentYear - 120)
							str = str + "\nYear does not appear to be a valid number!";
					} catch (NumberFormatException e1) {
						str = str + "\nYear does not appear to be a valid number!";
					}

					if (str.equals("")) {
						if (okOrCancel("Are you sure you want to save these changes?") == 0) {
							currentlyUpdatingPassenger.setName(passengerName.getText());
							currentlyUpdatingPassenger.setPhonenumber(passengerPhone.getText());
							currentlyUpdatingPassenger.setAddress(passengerAddress.getText());
							currentlyUpdatingPassenger.setEmail(passengerEmail.getText());
							currentlyUpdatingPassenger.setBirthday(new Date(Integer.parseInt(passengerMonth.getText()),
									Integer.parseInt(passengerDay.getText()),
									Integer.parseInt(passengerYear.getText())));
							currentlyUpdatingPassenger = null;
							tablePassengers.enable();
							try {
								passengersArchive.savePassengersArchive();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
							passengerPhone.setText("");
							passengerName.setText("");
							passengerEmail.setText("");
							passengerAddress.setText("");
							passengerMonth.setText("");
							passengerDay.setText("");
							passengerYear.setText("");
							listPassengers();
							tablePassengersInNewTourReservation.removeAll();
						}
					} else {
						JOptionPane.showMessageDialog(null, "You have to fill out the fields correctly:\n" + str);
					}
				}
			}
		});

		lblClearPassengerButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This cancels Updating Existing Passengers. After the button has
			 * been pressed, an okOrCancel notification pops and asks the user
			 * if he really wants to cancel updating. If the user clicks yes,
			 * passengerPhone, passengerName, passengerAddress, passengerEmail,
			 * passengerMonth, passengerDay, passengerYear fields are cleared
			 */
			public void mouseReleased(MouseEvent e) {
				if (okOrCancel("Are you sure you want to cancel updating?") == 0) {
					currentlyUpdatingPassenger = null;
					passengerPhone.setText("");
					passengerName.setText("");
					passengerEmail.setText("");
					passengerAddress.setText("");
					passengerMonth.setText("");
					passengerDay.setText("");
					passengerYear.setText("");

				}
			}
		});

		textFieldStartMonth.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartMonth field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartMonth field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartMonth field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());

			}

		});

		textFieldStartDay.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartDay field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartDay field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartDay field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());

			}

		});

		textFieldStartYear.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartYear field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartYear field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartYear field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());

			}

		});

		textFieldStartHour.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartHour field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartHour field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartHour field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());

			}

		});

		textFieldStartMinute.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartMinute field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartMinute field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldStartMinute field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());

			}

		});

		textFieldEndMonth.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndMonth field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndMonth field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndMonth field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());

			}

		});

		textFieldEndDay.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndDay field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndDay field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndDay field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());

			}

		});

		textFieldEndYear.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndYear field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndYear field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndYear field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());

			}

		});

		textFieldEndHour.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndHour field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndHour field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndHour field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());

			}

		});

		textFieldEndMinute.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndMinute field
			 */
			public void changedUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndMinute field
			 */
			public void insertUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
			}

			/**
			 * Deletes all rows in tableNewBusSelectBus and
			 * tableNewBusSelectChauffeur after a symbols was added in
			 * textFieldEndMinute field
			 */
			public void removeUpdate(DocumentEvent e) {
				deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
				deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());

			}

		});

		lblSearchForAvailableInNewBusRes.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This searches for suitable bus in busesArchive, adds them in
			 * tableNewBusSelectBus, searches for Chauffeurs in
			 * chauffeursArchive, add them in tableNewBusSelectChauffeur in
			 * panelNewBusReservationNext according to the information in
			 * textFieldNewBusStartMonth, textFieldNewBusStartDay,
			 * textFieldNewBusStartYear, startHourInNewBusRes,
			 * startMinuteInNewBusRes, textFieldNewBusEndMonth,
			 * textFieldNewBusEndYear, endtHourInNewBusRes, endMinuteInNewBusRes
			 * fields. If some of the field are filled incorrectly, the
			 * notification pops up and tells what fields are incorrect
			 */
			public void mouseReleased(MouseEvent e) {
				String str = new String("");
				int monthStart = 0;
				int monthEnd = 0;
				int dayStart = 0;
				int dayEnd = 0;
				int yearStart = 0;
				int yearEnd = 0;
				int hourStart = 0;
				int hourEnd = 0;
				int minuteStart = 0;
				int minuteEnd = 0;
				java.util.Date startDate = null;
				java.util.Date endDate = null;
				// int dayCount = -1;
				// int workHoursPerDay = 8; //for calculating price per
				// passenger (8 hours per day * price per hour = day price)
				Calendar timeNow = Calendar.getInstance();
				int currentYear = timeNow.get(Calendar.YEAR);
				try {
					monthStart = Integer.parseInt(textFieldNewBusStartMonth.getText());
					if (monthStart > 12 || monthStart < 1)
						str = str + "\nStart month does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart month does not seem to be a number between 1-12!";
				}
				try {
					dayStart = Integer.parseInt(textFieldNewBusStartDay.getText());
					if (monthStart == 1 || monthStart == 3 || monthStart == 5 || monthStart == 7 || monthStart == 8
							|| monthStart == 10 || monthStart == 12) {
						if (!(1 <= dayStart && dayStart <= 31)) {
							str = str + "\nStart day does not seem to be a number between 1-31!";
						}
					} else if (monthStart == 2) {
						if (!(1 <= dayStart && dayStart <= 28)) {
							str = str + "\nStart day does not seem to be a number between 1-28!";
						}
					} else if (monthStart == 4 || monthStart == 6 || monthStart == 9 || monthStart == 11) {
						if (!(1 <= dayStart && dayStart <= 30)) {
							str = str + "\nStart day does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nStart day does not seem to be a number between 1-31!";
				}
				try {
					yearStart = Integer.parseInt(textFieldNewBusStartYear.getText());
					if (yearStart < currentYear)
						str = str + "\nStart year does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart year does not appear to be a valid number!";
				}
				try {
					monthEnd = Integer.parseInt(textFieldNewBusEndMonth.getText());
					if (monthEnd > 12 || monthEnd < 1)
						str = str + "\nEnd month does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nEndt month does not seem to be a number between 1-12!";
				}
				try {
					dayEnd = Integer.parseInt(textFieldNewBusEndDay.getText());
					if (monthEnd == 1 || monthEnd == 3 || monthEnd == 5 || monthEnd == 7 || monthEnd == 8
							|| monthEnd == 10 || monthEnd == 12) {
						if (!(1 <= dayEnd && dayEnd <= 31)) {
							str = str + "\nEnd day does not seem to be a number between 1-31!";
						}
					} else if (monthEnd == 2) {
						if (!(1 <= dayEnd && dayEnd <= 28)) {
							str = str + "\nEnd day does not seem to be a number between 1-28!";
						}
					} else if (monthEnd == 4 || monthEnd == 6 || monthEnd == 9 || monthEnd == 11) {
						if (!(1 <= dayEnd && dayEnd <= 30)) {
							str = str + "\nEnd day does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nEnd day does not seem to be a number between 1-31!";
				}
				try {
					yearEnd = Integer.parseInt(textFieldNewBusEndYear.getText());
					if (yearEnd < currentYear)
						str = str + "\nEnd year does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nEnd year does not appear to be a valid number!";
				}
				try {
					hourStart = Integer.parseInt(startHourInNewBusRes.getText());
					if (hourStart < 0 && hourStart > 23)
						str = str + "\nStart hour does not appear to be a number between 0-23!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart hour does not appear to be a valid number!";
				}
				try {
					hourEnd = Integer.parseInt(endtHourInNewBusRes.getText());
					if (hourEnd < 0 && hourEnd > 23)
						str = str + "\nEnd hour does not appear to be a number between 0-23!";
				} catch (NumberFormatException e1) {
					str = str + "\nEnd hour does not appear to be a valid number!";
				}
				try {
					minuteStart = Integer.parseInt(startMinuteInNewBusRes.getText());
					if (minuteStart < 0 && minuteStart > 59)
						str = str + "\nStart minute does not appear to be a number between 0-59!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart minute does not appear to be a valid number!";
				}
				try {
					minuteEnd = Integer.parseInt(endMinuteInNewBusRes.getText());
					if (minuteEnd < 0 && minuteEnd > 59)
						str = str + "\nEnd minute does not appear to be a number between 0-59!";
				} catch (NumberFormatException e1) {
					str = str + "\nEnd minute does not appear to be a valid number!";
				}
				if (str.equals("")) {
					startDate = parseDate(
							yearStart + "-" + monthStart + "-" + dayStart + "-" + hourStart + "-" + minuteStart);
					endDate = parseDate(yearEnd + "-" + monthEnd + "-" + dayEnd + "-" + hourEnd + "-" + minuteEnd);
					listNewBusSelectBus(startDate, (int) ((endDate.getTime() - startDate.getTime()) / 3600000));
					listNewBusSelectChauffeur(startDate, (int) ((endDate.getTime() - startDate.getTime()) / 3600000));
				} else {
					JOptionPane.showMessageDialog(null, "Some of the fields were filled incorrectly:" + str);
				}
			}
		});

		lblSearchForAvailableInToursPanel.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This searches for suitable bus in busesArchive, adds them in
			 * tableSelectBus, searches for Chauffeurs in chauffeursArchive,
			 * adds them in tableSelectChauffeur in panelAddTour according to
			 * the information in textFieldDestination, textFieldStartMonth,
			 * textFieldStartDay, textFieldStartYear, textFieldStartHour,
			 * textFieldStartMinute, textFieldEndMonth, textFieldEndDay,
			 * textFieldEndYear, textFieldEndHour, textFieldEndMinute fields. If
			 * some of the field are filled incorrectly, the notification pops
			 * up and tells what fields are incorrect
			 */
			public void mouseReleased(MouseEvent e) {
				String str = new String("");
				int monthStart = 0;
				int monthEnd = 0;
				int dayStart = 0;
				int dayEnd = 0;
				int yearStart = 0;
				int yearEnd = 0;
				int hourStart = 0;
				int hourEnd = 0;
				int minuteStart = 0;
				int minuteEnd = 0;
				java.util.Date startDate = null;
				java.util.Date endDate = null;
				// int dayCount = -1;
				// int workHoursPerDay = 8; //for calculating price per
				// passenger (8 hours per day * price per hour = day price)
				Calendar timeNow = Calendar.getInstance();
				int currentYear = timeNow.get(Calendar.YEAR);
				try {
					monthStart = Integer.parseInt(textFieldStartMonth.getText());
					if (monthStart > 12 || monthStart < 1)
						str = str + "\nStart month does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart month does not seem to be a number between 1-12!";
				}
				try {
					dayStart = Integer.parseInt(textFieldStartDay.getText());
					if (monthStart == 1 || monthStart == 3 || monthStart == 5 || monthStart == 7 || monthStart == 8
							|| monthStart == 10 || monthStart == 12) {
						if (!(1 <= dayStart && dayStart <= 31)) {
							str = str + "\nStart day does not seem to be a number between 1-31!";
						}
					} else if (monthStart == 2) {
						if (!(1 <= dayStart && dayStart <= 28)) {
							str = str + "\nStart day does not seem to be a number between 1-28!";
						}
					} else if (monthStart == 4 || monthStart == 6 || monthStart == 9 || monthStart == 11) {
						if (!(1 <= dayStart && dayStart <= 30)) {
							str = str + "\nStart day does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nStart day does not seem to be a number between 1-31!";
				}
				try {
					yearStart = Integer.parseInt(textFieldStartYear.getText());
					if (yearStart < currentYear)
						str = str + "\nStart year does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart year does not appear to be a valid number!";
				}

				try {
					monthEnd = Integer.parseInt(textFieldEndMonth.getText());
					if (monthEnd > 12 || monthEnd < 1)
						str = str + "\nEnd month does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nEndt month does not seem to be a number between 1-12!";
				}
				try {
					dayEnd = Integer.parseInt(textFieldEndDay.getText());
					if (monthEnd == 1 || monthEnd == 3 || monthEnd == 5 || monthEnd == 7 || monthEnd == 8
							|| monthEnd == 10 || monthEnd == 12) {
						if (!(1 <= dayEnd && dayEnd <= 31)) {
							str = str + "\nEnd day does not seem to be a number between 1-31!";
						}
					} else if (monthEnd == 2) {
						if (!(1 <= dayEnd && dayEnd <= 28)) {
							str = str + "\nEnd day does not seem to be a number between 1-28!";
						}
					} else if (monthEnd == 4 || monthEnd == 6 || monthEnd == 9 || monthEnd == 11) {
						if (!(1 <= dayEnd && dayEnd <= 30)) {
							str = str + "\nEnd day does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nEnd day does not seem to be a number between 1-31!";
				}
				try {
					yearEnd = Integer.parseInt(textFieldEndYear.getText());
					if (yearEnd < currentYear)
						str = str + "\nEnd year does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nEnd year does not appear to be a valid number!";
				}
				try {
					hourStart = Integer.parseInt(textFieldStartHour.getText());
					if (hourStart < 0 && hourStart > 23)
						str = str + "\nStart hour does not appear to be a number between 0-23!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart hour does not appear to be a valid number!";
				}
				try {
					hourEnd = Integer.parseInt(textFieldEndHour.getText());
					if (hourEnd < 0 && hourEnd > 23)
						str = str + "\nEnd hour does not appear to be a number between 0-23!";
				} catch (NumberFormatException e1) {
					str = str + "\nEnd hour does not appear to be a valid number!";
				}
				try {
					minuteStart = Integer.parseInt(textFieldStartMinute.getText());
					if (minuteStart < 0 && minuteStart > 59)
						str = str + "\nStart minute does not appear to be a number between 0-59!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart minute does not appear to be a valid number!";
				}
				try {
					minuteEnd = Integer.parseInt(textFieldEndMinute.getText());
					if (minuteEnd < 0 && minuteEnd > 59)
						str = str + "\nEnd minute does not appear to be a number between 0-59!";
				} catch (NumberFormatException e1) {
					str = str + "\nEnd minute does not appear to be a valid number!";
				}
				if (str.equals("")) {
					startDate = parseDate(
							yearStart + "-" + monthStart + "-" + dayStart + "-" + hourStart + "-" + minuteStart);
					endDate = parseDate(yearEnd + "-" + monthEnd + "-" + dayEnd + "-" + hourEnd + "-" + minuteEnd);
					listSelectBus(startDate, (int) ((endDate.getTime() - startDate.getTime()) / 3600000));
					listSelectChauffeur(startDate, (int) ((endDate.getTime() - startDate.getTime()) / 3600000));
				} else {
					JOptionPane.showMessageDialog(null, "Some of the fields were filled incorrectly:" + str);
				}
			}
		});

		lblCancelButtonInNewTourReservation.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This cancels this reservation and clears all the fields
			 */
			public void mouseReleased(MouseEvent arg0) {
				if (okOrCancel("Are you sure you want to cancel this reservation?") == 0) {
					passengerPhoneInNewTourReservation.setText("");
					passengerNameInNewReservation.setText("");
					passengerAddressInNewTourReservation.setText("");
					passengerEmailInNewTourReservation.setText("");
					passengerMonthInNewTourReservation.setText("");
					passengerDayInNewTourReservation.setText("");
					passengerYearInNewTourReservation.setText("");
					customerNameNewTourReservationTextField.setText("");
					customerOrganisationtextField.setText("");
					customerAddressIncustomerEmailNewTourReservationTextField.setText("");
					customerEmailNewTourReservationtextField.setText("");
					customerMonthInNewTourReservationTextField.setText("");
					customerDayInNewTourReservationTextField.setText("");
					customerYearInNewTourReservationTextField.setText("");
					lblPhoneInNewTourReservationtextField.setText("");
					radioButtonIsCompanyNewTourReservation.setSelected(false);
					radioButtonIsPrivateInNewTourReservation.setSelected(false);
					radioButtonIsSchoolNewTourReservation.setSelected(false);
					chckbxNewBusIsPassenger.setSelected(false);
					deleteAllRows((DefaultTableModel) tablePassengersInNewTourReservation.getModel());
					lblSelectedCustomer.setText("");
					DefaultListModel<String> listModel = (DefaultListModel<String>) lblSelectedPassengers.getModel();
					listModel.removeAllElements();
					lblSelectedTour.setText("");
				}

			}
		});

		lblClearAlButtonInNewTourReservation.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This clears all the passengers from
			 * tablePassengersInNewTourReservation table in New Tour Reservation
			 * Select Passenger after the button has been pressed
			 */
			public void mouseReleased(MouseEvent arg0) {
				DefaultTableModel tablePassengersModelInNewTourReservation = (DefaultTableModel) tablePassengersInNewTourReservation
						.getModel();
				tablePassengersModelInNewTourReservation.setRowCount(0);
				DefaultListModel<String> listModel = (DefaultListModel<String>) lblSelectedPassengers.getModel();
				listModel.removeAllElements();
				boxIsAPassengerNewTourReservation.setSelected(false);
			}
		});

		lblRemoveButtonInNewTourReservation.addMouseListener(new MouseAdapter() {
			/**
			 * This removes the selected passenger from
			 * tablePassengersInNewTourReservation table in New Tour Reservation
			 * Select Passenger. After the button has been pressed, an
			 * okOrCancel notification pops up with the message: "Are you sure
			 * you want to remove this passenger from the list?". If the user
			 * clicks OK button, the selected passenger from the table
			 * tablePassengersInNewTourReservation is removed
			 */
			public void mouseReleased(MouseEvent event) {
				int index = tablePassengersInNewTourReservation.getSelectedRow();
				DefaultTableModel tablePassengersModelInNewTourReservation = (DefaultTableModel) tablePassengersInNewTourReservation
						.getModel();
				if (index != -1) {
					if (okOrCancel("Are you sure you want to remove this passenger from the list?") == 0) {
						tablePassengersModelInNewTourReservation.removeRow(index);
						DefaultListModel<String> listModel = (DefaultListModel<String>) lblSelectedPassengers
								.getModel();
						listModel.removeElementAt(index);
					}
				} else {
					JOptionPane.showMessageDialog(null, "You need first to select the passenger you wish to remove!");
				}
			}
		});

		searchCustomerTextField.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * This searches for Customers by name according to the symbols in
			 * searchCustomerTextField in NewTourReservation and adds them in
			 * customersTableInNewTourReservation table.
			 */

			public void deleteAllRows(final DefaultTableModel model) {
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				DefaultTableModel customersTableModelForNewReservation;
				deleteAllRows(
						customersTableModelForNewReservation = (DefaultTableModel) customersTableInNewTourReservation
								.getModel());
				String searchText;
				if (!(searchText = searchCustomerTextField.getText()).equals("")) {
					Object[] rowData = new Object[9];
					for (int i = 0; i < customersArchive.getListOfCustomers().size(); i++) {
						String customersName = customersArchive.getListOfCustomers().get(i).getName();
						String substringOfName = customersName.substring(0,
								searchText.length() <= customersName.length() ? searchText.length()
										: customersName.length());
						if (substringOfName.equals(searchText)) {
							rowData[0] = customersArchive.get(i).getName();
							rowData[1] = customersArchive.get(i).getOrganisationType();
							rowData[2] = customersArchive.get(i).getPhonenumber();
							rowData[3] = customersArchive.get(i).getName();
							rowData[4] = customersArchive.get(i).getAddress();
							rowData[5] = customersArchive.get(i).getEmail();
							rowData[6] = customersArchive.get(i).getBirthday().displayDate();
							rowData[7] = customersArchive.get(i).getMoneySpent();
							rowData[8] = customersArchive.get(i).getDiscount();
							customersTableModelForNewReservation.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(
							customersTableModelForNewReservation = (DefaultTableModel) customersTableInNewTourReservation
									.getModel());
					Object[] rowData = new Object[9];
					for (int i = 0; i < customersArchive.getListOfCustomers().size(); i++) {
						rowData[0] = customersArchive.get(i).getName();
						rowData[1] = customersArchive.get(i).getOrganisationType();
						rowData[2] = customersArchive.get(i).getPhonenumber();
						rowData[3] = customersArchive.get(i).getName();
						rowData[4] = customersArchive.get(i).getAddress();
						rowData[5] = customersArchive.get(i).getEmail();
						rowData[6] = customersArchive.get(i).getBirthday().displayDate();
						rowData[7] = customersArchive.get(i).getMoneySpent();
						rowData[8] = customersArchive.get(i).getDiscount();
						customersTableModelForNewReservation.addRow(rowData);
					}
				}
			}

			public void removeUpdate(DocumentEvent e) {
				DefaultTableModel customersTableModelForNewReservation;
				deleteAllRows(
						customersTableModelForNewReservation = (DefaultTableModel) customersTableInNewTourReservation
								.getModel());
				String searchText;
				if (!(searchText = searchCustomerTextField.getText()).equals("")) {
					Object[] rowData = new Object[9];
					for (int i = 0; i < customersArchive.getListOfCustomers().size(); i++) {
						String customersName = customersArchive.getListOfCustomers().get(i).getName();
						String substringOfName = customersName.substring(0,
								searchText.length() <= customersName.length() ? searchText.length()
										: customersName.length());
						if (substringOfName.equals(searchText)) {
							rowData[0] = customersArchive.get(i).getName();
							rowData[1] = customersArchive.get(i).getOrganisationType();
							rowData[2] = customersArchive.get(i).getPhonenumber();
							rowData[3] = customersArchive.get(i).getName();
							rowData[4] = customersArchive.get(i).getAddress();
							rowData[5] = customersArchive.get(i).getEmail();
							rowData[6] = customersArchive.get(i).getBirthday().displayDate();
							rowData[7] = customersArchive.get(i).getMoneySpent();
							rowData[8] = customersArchive.get(i).getDiscount();
							customersTableModelForNewReservation.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(
							customersTableModelForNewReservation = (DefaultTableModel) customersTableInNewTourReservation
									.getModel());
					Object[] rowData = new Object[9];
					for (int i = 0; i < customersArchive.getListOfCustomers().size(); i++) {
						rowData[0] = customersArchive.get(i).getName();
						rowData[1] = customersArchive.get(i).getOrganisationType();
						rowData[2] = customersArchive.get(i).getPhonenumber();
						rowData[3] = customersArchive.get(i).getName();
						rowData[4] = customersArchive.get(i).getAddress();
						rowData[5] = customersArchive.get(i).getEmail();
						rowData[6] = customersArchive.get(i).getBirthday().displayDate();
						rowData[7] = customersArchive.get(i).getMoneySpent();
						rowData[8] = customersArchive.get(i).getDiscount();
						customersTableModelForNewReservation.addRow(rowData);
					}
				}
			}

			public void insertUpdate(DocumentEvent e) {
				DefaultTableModel customersTableModelForNewReservation;
				deleteAllRows(
						customersTableModelForNewReservation = (DefaultTableModel) customersTableInNewTourReservation
								.getModel());
				String searchText;
				if (!(searchText = searchCustomerTextField.getText()).equals("")) {
					Object[] rowData = new Object[9];
					for (int i = 0; i < customersArchive.getListOfCustomers().size(); i++) {
						String customersName = customersArchive.getListOfCustomers().get(i).getName();
						String substringOfName = customersName.substring(0,
								searchText.length() <= customersName.length() ? searchText.length()
										: customersName.length());
						if (substringOfName.equals(searchText)) {
							rowData[0] = customersArchive.get(i).getName();
							rowData[1] = customersArchive.get(i).getOrganisationType();
							rowData[2] = customersArchive.get(i).getPhonenumber();
							rowData[3] = customersArchive.get(i).getName();
							rowData[4] = customersArchive.get(i).getAddress();
							rowData[5] = customersArchive.get(i).getEmail();
							rowData[6] = customersArchive.get(i).getBirthday().displayDate();
							rowData[7] = customersArchive.get(i).getMoneySpent();
							rowData[8] = customersArchive.get(i).getDiscount();
							customersTableModelForNewReservation.addRow(rowData);
						}
					}
				} else {
					deleteAllRows(
							customersTableModelForNewReservation = (DefaultTableModel) customersTableInNewTourReservation
									.getModel());
					Object[] rowData = new Object[9];
					for (int i = 0; i < customersArchive.getListOfCustomers().size(); i++) {
						rowData[0] = customersArchive.get(i).getName();
						rowData[1] = customersArchive.get(i).getOrganisationType();
						rowData[2] = customersArchive.get(i).getPhonenumber();
						rowData[3] = customersArchive.get(i).getName();
						rowData[4] = customersArchive.get(i).getAddress();
						rowData[5] = customersArchive.get(i).getEmail();
						rowData[6] = customersArchive.get(i).getBirthday().displayDate();
						rowData[7] = customersArchive.get(i).getMoneySpent();
						rowData[8] = customersArchive.get(i).getDiscount();
						customersTableModelForNewReservation.addRow(rowData);
					}
				}
			}
		});

		searchTourTextField.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * This searches for Tours by destination according to the symbols
			 * in searchTourTextField in NewTourReservation and adds them in
			 * toursTableInNewTourReservation table.
			 */
			public void deleteAllRows(final DefaultTableModel model) {
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
			}

			public void changedUpdate(DocumentEvent e) {
				DefaultTableModel toursTableModelForNewReservation;
				deleteAllRows(toursTableModelForNewReservation = (DefaultTableModel) tableToursInNewTourReservation
						.getModel());
				String searchText;
				if (!(searchText = searchTourTextField.getText()).equals("")) {
					Object[] rowData = new Object[9];
					for (int i = 0; i < toursArchive.size(); i++) {
						if (toursArchive.get(i).getSeatsAvailable() > 0) {
							String destination = toursArchive.get(i).getDestination();
							String substringOfDestination = destination.substring(0,
									searchText.length() <= destination.length() ? searchText.length()
											: destination.length());
							if (substringOfDestination.equals(searchText)) {
								rowData[0] = toursArchive.get(i).getDepartureDate();
								rowData[1] = toursArchive.get(i).getDestination();
								rowData[2] = toursArchive.get(i).getPickUpPlacesString();
								rowData[3] = toursArchive.get(i).getSeatsAvailable();
								rowData[4] = toursArchive.get(i).getTotalPrice();
								rowData[5] = toursArchive.get(i).getPricePerPassenger();
								rowData[6] = toursArchive.get(i).getBusAndType();
								rowData[7] = toursArchive.get(i).getChauffeur();
								rowData[8] = toursArchive.get(i).getServicesString();
								toursTableModelForNewReservation.addRow(rowData);
							}
						}
					}
				} else {
					deleteAllRows(toursTableModelForNewReservation = (DefaultTableModel) tableToursInNewTourReservation
							.getModel());
					Object[] rowData = new Object[9];
					for (int i = 0; i < toursArchive.size(); i++) {
						if (toursArchive.get(i).getSeatsAvailable() > 0) {
							rowData[0] = toursArchive.get(i).getDepartureDate();
							rowData[1] = toursArchive.get(i).getDestination();
							rowData[2] = toursArchive.get(i).getPickUpPlacesString();
							rowData[3] = toursArchive.get(i).getSeatsAvailable();
							rowData[4] = toursArchive.get(i).getTotalPrice();
							rowData[5] = toursArchive.get(i).getPricePerPassenger();
							rowData[6] = toursArchive.get(i).getBusAndType();
							rowData[7] = toursArchive.get(i).getChauffeur();
							rowData[8] = toursArchive.get(i).getServicesString();
							toursTableModelForNewReservation.addRow(rowData);
						}
					}
				}
			}

			public void removeUpdate(DocumentEvent e) {
				DefaultTableModel toursTableModelForNewReservation;
				deleteAllRows(toursTableModelForNewReservation = (DefaultTableModel) tableToursInNewTourReservation
						.getModel());
				String searchText;
				if (!(searchText = searchTourTextField.getText()).equals("")) {
					Object[] rowData = new Object[9];
					for (int i = 0; i < toursArchive.size(); i++) {
						if (toursArchive.get(i).getSeatsAvailable() > 0) {
							String destination = toursArchive.get(i).getDestination();
							String substringOfDestination = destination.substring(0,
									searchText.length() <= destination.length() ? searchText.length()
											: destination.length());
							if (substringOfDestination.equals(searchText)) {
								rowData[0] = toursArchive.get(i).getDepartureDate();
								rowData[1] = toursArchive.get(i).getDestination();
								rowData[2] = toursArchive.get(i).getPickUpPlacesString();
								rowData[3] = toursArchive.get(i).getSeatsAvailable();
								rowData[4] = toursArchive.get(i).getTotalPrice();
								rowData[5] = toursArchive.get(i).getPricePerPassenger();
								rowData[6] = toursArchive.get(i).getBusAndType();
								rowData[7] = toursArchive.get(i).getChauffeur();
								rowData[8] = toursArchive.get(i).getServicesString();
								toursTableModelForNewReservation.addRow(rowData);
							}
						}
					}
				} else {
					deleteAllRows(toursTableModelForNewReservation = (DefaultTableModel) tableToursInNewTourReservation
							.getModel());
					Object[] rowData = new Object[9];
					for (int i = 0; i < toursArchive.size(); i++) {
						if (toursArchive.get(i).getSeatsAvailable() > 0) {
							rowData[0] = toursArchive.get(i).getDepartureDate();
							rowData[1] = toursArchive.get(i).getDestination();
							rowData[2] = toursArchive.get(i).getPickUpPlacesString();
							rowData[3] = toursArchive.get(i).getSeatsAvailable();
							rowData[4] = toursArchive.get(i).getTotalPrice();
							rowData[5] = toursArchive.get(i).getPricePerPassenger();
							rowData[6] = toursArchive.get(i).getBusAndType();
							rowData[7] = toursArchive.get(i).getChauffeur();
							rowData[8] = toursArchive.get(i).getServicesString();
							toursTableModelForNewReservation.addRow(rowData);
						}
					}
				}
			}

			public void insertUpdate(DocumentEvent e) {
				DefaultTableModel toursTableModelForNewReservation;
				deleteAllRows(toursTableModelForNewReservation = (DefaultTableModel) tableToursInNewTourReservation
						.getModel());
				String searchText;
				if (!(searchText = searchTourTextField.getText()).equals("")) {
					Object[] rowData = new Object[9];
					for (int i = 0; i < toursArchive.size(); i++) {
						if (toursArchive.get(i).getSeatsAvailable() > 0) {
							String destination = toursArchive.get(i).getDestination();
							String substringOfDestination = destination.substring(0,
									searchText.length() <= destination.length() ? searchText.length()
											: destination.length());
							if (substringOfDestination.equals(searchText)) {
								rowData[0] = toursArchive.get(i).getDepartureDate();
								rowData[1] = toursArchive.get(i).getDestination();
								rowData[2] = toursArchive.get(i).getPickUpPlacesString();
								rowData[3] = toursArchive.get(i).getSeatsAvailable();
								rowData[4] = toursArchive.get(i).getTotalPrice();
								rowData[5] = toursArchive.get(i).getPricePerPassenger();
								rowData[6] = toursArchive.get(i).getBusAndType();
								rowData[7] = toursArchive.get(i).getChauffeur();
								rowData[8] = toursArchive.get(i).getServicesString();
								toursTableModelForNewReservation.addRow(rowData);
							}
						}
					}
				} else {
					deleteAllRows(toursTableModelForNewReservation = (DefaultTableModel) tableToursInNewTourReservation
							.getModel());
					Object[] rowData = new Object[9];
					for (int i = 0; i < toursArchive.size(); i++) {
						if (toursArchive.get(i).getSeatsAvailable() > 0) {
							rowData[0] = toursArchive.get(i).getDepartureDate();
							rowData[1] = toursArchive.get(i).getDestination();
							rowData[2] = toursArchive.get(i).getPickUpPlacesString();
							rowData[3] = toursArchive.get(i).getSeatsAvailable();
							rowData[4] = toursArchive.get(i).getTotalPrice();
							rowData[5] = toursArchive.get(i).getPricePerPassenger();
							rowData[6] = toursArchive.get(i).getBusAndType();
							rowData[7] = toursArchive.get(i).getChauffeur();
							rowData[8] = toursArchive.get(i).getServicesString();
							toursTableModelForNewReservation.addRow(rowData);
						}
					}
				}
			}
		});

		lblSelectCustomerButtonInNewTourRes.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This identifies the selected Customer from
			 * customersTableInNewTourReservation TextField and adds him to
			 * lblSelectedCustomer label
			 */
			public void mouseReleased(MouseEvent arg0) {
				int index = customersTableInNewTourReservation.getSelectedRow();
				if (index != -1)
					lblSelectedCustomer.setText(customersArchive.getListOfCustomers().get(index).getName() + " - "
							+ customersArchive.getListOfCustomers().get(index).getPhonenumber());
			}
		});

		lblSelectTourButtonInNewTourRes.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This identifies the selected Tour from
			 * toursTableInNewTourReservation TextField and adds him to
			 * lblSelectedTour label
			 */
			public void mouseReleased(MouseEvent arg0) {
				int index = tableToursInNewTourReservation.getSelectedRow();
				if (index != -1)
					lblSelectedTour.setText(toursArchive.getToursArchive().get(index).getDestination() + " "
							+ toursArchive.getToursArchive().get(index).getDepartureDate());
			}
		});

		lblCreateReservationButton.addMouseListener(new MouseAdapter() {

			@Override
			/**
			 * This creates a new Reservation in panelNewTourReservation, checks
			 * if the customer, passengers, and tour are selected
			 * lblSelectedTour lblSelectedCustomer lblSelectedPassengers fields.
			 * If some of these fields aren't selected, the notification pops up
			 * and says what wasn't selected
			 */
			public void mouseReleased(MouseEvent arg0) {
				String str = "";

				if (tableToursInNewTourReservation.getSelectedRow() == -1)
					str += "\nYou did not select a tour!";
				if (customersTableInNewTourReservation.getSelectedRow() == -1)
					str += "\nYou did not select a customer!";
				if (tablePassengersInNewTourReservation.getRowCount() == 0)
					str += "\nYou did not add any passengers to the list!";

				if (str.equals("")) {

					Customer selectedCustomer = customersArchive
							.get(customersTableInNewTourReservation.getSelectedRow());

					ArrayList<Passenger> listOfSelectedPassengers = new ArrayList<>();
					try {
						reservationNumber = reservationNumberGenerator.getReservationNumber();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					int passengersTableRowCount = tablePassengersInNewTourReservation.getRowCount();
					for (int i = 0; i < passengersTableRowCount; i++) {
						String passengersPhoneNumber = (String) tablePassengersInNewTourReservation.getModel()
								.getValueAt(i, 2);
						String passengersName = (String) tablePassengersInNewTourReservation.getModel().getValueAt(i,
								0);

						for (int j = 0; j < passengersArchive.size(); j++) {
							if (passengersArchive.getPassengersArchive().get(j).getPhonenumber()
									.equals(passengersPhoneNumber)
									&& passengersArchive.getPassengersArchive().get(j).getName()
											.equals(passengersName)) {
								listOfSelectedPassengers.add(passengersArchive.getPassengersArchive().get(j));
								break;
							}
						}
					}

					Tour selectedTour = null;
					int indexOfselectedTour = tableToursInNewTourReservation.getSelectedRow();
					String departureDate = String
							.valueOf(tableToursInNewTourReservation.getValueAt(indexOfselectedTour, 0));
					String busAndType = String
							.valueOf(tableToursInNewTourReservation.getValueAt(indexOfselectedTour, 6));
					for (int j = 0; j < toursArchive.size(); j++) {
						Tour tourToCompare = toursArchive.get(j);
						if (tourToCompare.getDepartureDate().equals(departureDate)
								&& tourToCompare.getBusAndType().equals(busAndType)) {
							selectedTour = tourToCompare;
							break;
						}
					}

					selectedCustomer.setMoneySpent(selectedCustomer.getMoneySpent()
							+ (listOfSelectedPassengers.size() * (selectedTour.getPricePerPassenger()
									- (selectedTour.getPricePerPassenger() * selectedCustomer.getDiscount()))));
					TourReservation newTourReservation = new TourReservation(reservationNumber, 0, selectedCustomer,
							selectedTour);
					newTourReservation.setPassengers(listOfSelectedPassengers);
					newTourReservation.getTour().setSeatsAvailable(
							newTourReservation.getTour().getSeatsAvailable() - listOfSelectedPassengers.size());

					double totalPriceForReservation = listOfSelectedPassengers.size()
							* (selectedTour.getPricePerPassenger()
									- (selectedTour.getPricePerPassenger() * selectedCustomer.getDiscount()));
					newTourReservation.setTotalPrice(totalPriceForReservation);
					newTourReservation.getTour()
							.setTotalPrice(newTourReservation.getTour().getTotalPrice() + totalPriceForReservation);

					reservationsArchive.addReservation(newTourReservation);
					try {
						reservationsArchive.saveReservationsArchive();
						customersArchive.saveCustomersArchive();
						toursArchive.saveToursArchive();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					updateListTourReservations((TourReservation) reservationsArchive.getReservationsArchive()
							.get(reservationsArchive.size() - 1));
					listTours();
					listCustomers();
					JOptionPane.showMessageDialog(null, "A new tour Reservation was successfully created");
					deleteAllRows((DefaultTableModel) tablePassengersInNewTourReservation.getModel());
					lblSelectedCustomer.setText("");
					lblSelectedTour.setText("");
					DefaultListModel<String> listModel = (DefaultListModel<String>) lblSelectedPassengers.getModel();
					listModel.removeAllElements();
				} else {
					JOptionPane.showMessageDialog(null, "It seems you form was filled incorrectly" + str);
				}
			}
		});

		mntmAboutAutobus.addActionListener(new ActionListener() {
			/**
			 * This shows notification about Autobus in mnHelp after the JMenu
			 * was clicked
			 */
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"autobus\u00AE\nBus Transportation Management System version 1.0\n\nDeveloped by:\n"
								+ "Mogens Bjerregaard, Nick Onov, Eugene Maloman, and Adam Kounis\n\n\u00A9 2016. All rights reserved.",
						"About autobus\u00AE", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});

		mntmExit.addActionListener(new ActionListener() {
			/**
			 * This exits the notification
			 */
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		mntmTourReservations.addActionListener(new ActionListener() {
			/**
			 * This hides all panels and shows panelTourReservations after the
			 * the JMenu was clicked
			 */
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelTourReservations.setVisible(true);
			}
		});

		mntmBusReservations.addActionListener(new ActionListener() {
			/**
			 * This hides all panels and shows panelBusReservation after the the
			 * JMenu was clicked
			 */
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelBusReservations.setVisible(true);
			}
		});

		mntmEditChauffeur.addActionListener(new ActionListener() {
			/**
			 * This hides all panels and shows panelChauffeurs after the the
			 * JMenu was clicked
			 */
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelChauffeurs.setVisible(true);
			}
		});

		lblAddChauffeurButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This adds new Chauffeur to chauffeursArchive according to the
			 * fields from Chauffeurs Archive: textFieldEmployeeNo,
			 * textFieldChauffeurName, textFieldChauffeurAddress,
			 * textFieldChauffeurEmail, textFieldChauffeurPhone,
			 * textFieldChauffeurBirthMonth, textFieldChauffeurBirthDay,
			 * textFieldChauffeurBirthYear, chckbxExternalEmployee,
			 * chckbxOnlyOneDayTrips fields. If some of the fields are
			 * incorrect, a notification pops up that says what fields should be
			 * changed
			 */
			public void mouseReleased(MouseEvent arg0) {
				String str = new String("");
				int month = 0;
				int day = 0;
				int year = 0;
				Calendar timeNow = Calendar.getInstance();
				int currentYear = timeNow.get(Calendar.YEAR);
				int phone = 0;

				if (textFieldEmployeeNo.getText().equals(""))
					str = str + "\nEmployee number seems to be empty!";
				if (textFieldChauffeurName.getText().equals(""))
					str = str + "\nName seems to be empty!";
				if (textFieldChauffeurAddress.getText().equals(""))
					str = str + "\nAddress seems to be empty!";
				if (!(textFieldChauffeurEmail.getText().contains("@")
						&& textFieldChauffeurEmail.getText().contains("."))) {
					str = str + "\nEmail does not seem to be in correct format!";
				}
				try {
					month = Integer.parseInt(textFieldChauffeurBirthMonth.getText());
					if (month > 12 || month < 1)
						str = str + "\nMonth does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nMonth does not seem to be a number between 1-12!";
				}
				try {
					day = Integer.parseInt(textFieldChauffeurBirthDay.getText());
					if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
							|| month == 12) {
						if (!(1 <= day && day <= 31)) {
							str = str + "\nDay does not seem to be a number between 1-31!";
						}
					} else if (month == 2) {
						if (!(1 <= day && day <= 28)) {
							str = str + "\nDay does not seem to be a number between 1-28!";
						}
					} else if (month == 4 || month == 6 || month == 9 || month == 11) {
						if (!(1 <= day && day <= 30)) {
							str = str + "\nDay does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nDay does not seem to be a number between 1-31!";
				}
				try {
					year = Integer.parseInt(textFieldChauffeurBirthYear.getText());
					if (year > currentYear - 17 || year < currentYear - 90)
						str = str + "\nYear does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nYear does not appear to be a valid number!";
				}
				try {
					phone = Integer.parseInt(textFieldChauffeurPhone.getText());
					if (phone > 99999999) {
						str = str + "\nPhone number appears to have too many digits!";
					}
					if (phone < 10000000) {
						str = str + "\nPhone number appears to have too few digits!";
					}
				} catch (Exception e) {
					str = str + "\nPhone number does not appear to be a number!";
				}

				if (str.equals("")) {

					chauffeursArchive.addChauffeur(new Chauffeur(textFieldChauffeurName.getText(),
							textFieldChauffeurEmail.getText(), textFieldChauffeurAddress.getText(), month, day, year,
							Integer.toString(phone), textFieldEmployeeNo.getText(), chckbxExternalEmployee.isSelected(),
							chckbxOnlyOneDayTrips.isSelected()));
					updateListChauffeurs(textFieldEmployeeNo.getText(), "no tours", textFieldChauffeurName.getText(),
							textFieldChauffeurAddress.getText(), textFieldChauffeurEmail.getText(),
							textFieldChauffeurPhone.getText(), month + "/" + day + "/" + year,
							chckbxOnlyOneDayTrips.isSelected());
					/*
					 * updateListSelectChauffeur(new
					 * Chauffeur(textFieldChauffeurName.getText(),
					 * textFieldChauffeurEmail.getText(),
					 * textFieldChauffeurAddress.getText(), month, day, year,
					 * Integer.toString(phone), textFieldEmployeeNo.getText(),
					 * chckbxExternalEmployee.isSelected(),
					 * chckbxOnlyOneDayTrips.isSelected()));
					 */
					textFieldChauffeurName.setText("");
					textFieldChauffeurEmail.setText("");
					textFieldChauffeurAddress.setText("");
					textFieldChauffeurBirthMonth.setText("");
					textFieldChauffeurBirthDay.setText("");
					textFieldChauffeurBirthYear.setText("");
					textFieldChauffeurPhone.setText("");
					textFieldEmployeeNo.setText("");
					chckbxExternalEmployee.setSelected(false);
					chckbxOnlyOneDayTrips.setSelected(false);
					try {
						chauffeursArchive.saveChauffeursArchive();
					} catch (Exception e) {

						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You have to fill out the fields correct:\n" + str);
				}

			}
		});

		lblDeleteChauffeurBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This removes selected Chauffeur from tableChauffeurs table and
			 * chauffeursArchive. After the button was pressed a notification
			 * pops up that asks the user if he really wants to remove this
			 * Chauffeur. If the user clicks button OK, the selected Chauffeur
			 * is deleted from tableChauffeurs table and chauffeursArchive.
			 */
			public void mouseReleased(MouseEvent arg0) {
				int index = tableChauffeurs.getSelectedRow();
				if (index != -1) {
					if (okOrCancel("Are you sure you want to delete this Chauffeur?") == 0) {
						chauffeursTable.removeRow(index);
						chauffeursArchive.get(index).getListOfStartEndDates().clear();
						chauffeursArchive.removeChauffeur(index);
						try {
							chauffeursArchive.saveChauffeursArchive();
						} catch (Exception e) {

							e.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "You need first to select the row you wish to delete!");
				}
			}
		});

		mntmEditBus.addActionListener(new ActionListener() {
			/**
			 * This hides all panels and shows panelBuses after the JMenu was
			 * clicked
			 */
			public void actionPerformed(ActionEvent arg0) {
				hideAllPanels();
				panelBuses.setVisible(true);
			}
		});

		mntmEditTours.addActionListener(new ActionListener() {
			/**
			 * This hides all panels and shows panelTours after the JMenu was
			 * clicked
			 */
			public void actionPerformed(ActionEvent arg0) {
				newBusSelectChauffeurTable = (DefaultTableModel) tableNewBusSelectChauffeur.getModel();
				deleteAllRows(newBusSelectChauffeurTable);
				newBusSelectBusTable = (DefaultTableModel) tableNewBusSelectBus.getModel();
				deleteAllRows(newBusSelectBusTable);
				hideAllPanels();
				panelTours.setVisible(true);
			}
		});

		/**
		 * This hides all panels and shows panelCustomers after the JMenu was
		 * clicked
		 */
		mntmEditCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelCustomers.setVisible(true);
			}
		});

		mntmPassengers.addActionListener(new ActionListener() {
			/**
			 * This hides all panels and shows panelPassengers after the JMenu
			 * was clicked
			 */
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelPassengers.setVisible(true);
			}
		});

		/**
		 * This hides all panels and shows panelTourReservation after the JMenu
		 * was clicked
		 */
		mntmNewTourReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelNewTourReservation.setVisible(true);
			}
		});

		mntmNewBusReservation.addActionListener(new ActionListener() {
			/**
			 * This hides all panels and shows panelNewBusReservation after the
			 * JMenu was clicked
			 */
			public void actionPerformed(ActionEvent e) {
				selectBusTable = (DefaultTableModel) tableSelectBus.getModel();
				deleteAllRows(selectBusTable);
				selectChauffeurTable = (DefaultTableModel) tableSelectChauffeur.getModel();
				deleteAllRows(selectChauffeurTable);
				hideAllPanels();
				panelNewBusReservation.setVisible(true);
			}
		});

		mntmPrices.addActionListener(new ActionListener() {
			/**
			 * This hides all panels and shows panelPrices after the JMenu was
			 * clicked
			 */
			public void actionPerformed(ActionEvent e) {
				hideAllPanels();
				panelPrices.setVisible(true);
			}
		});

		labelAddBusBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This adds new Bus to busesArchive and tableBuses table according
			 * to the panelAddBus, textFieldPriceHour, textFieldNumberSeats,
			 * rdbtnStandardBus, rdbtnPartyBus, rdbtnLuxuryBus fields after the
			 * button was pressed. If the information is filled incorrectly, the
			 * notification pops up and says what fields should are incorrect
			 */
			public void mouseReleased(MouseEvent e) {
				String str = new String("");
				double priceHour = 0;
				int maxSeats = 0;
				String modelType = new String("");
				if (textFieldVehicleID.getText().equals("")) {
					str = str + "\nVehicle ID appears to be empty!";
				}
				if (textFieldPriceHour.getText().equals("")) {
					str = str + "\nPrice per hour appears to be empty!";
				}
				try {
					priceHour = Double.parseDouble(textFieldPriceHour.getText());
					if (priceHour < 0) {
						str = str + "\nThe price per hour must be possitive!";
					}

				} catch (Exception e2) {
					str = str + "\nThe price per hour does not appear to be a number!";
				}
				if (textFieldNumberSeats.getText().equals("")) {
					str = str + "\nNumber of seats cannot be empty!";
				}
				try {
					maxSeats = Integer.parseInt(textFieldNumberSeats.getText());
					if (maxSeats < 5) {
						str = str + "\nNumber of seats entered may be too small!";
					}
					if (maxSeats > 80) {
						str = str + "\nNumber of seats enteret may be too high!";
					}
				} catch (Exception e2) {
					str = str + "\nNumber of seats must be a number!";
				}
				if (!(rdbtnStandardBus.isSelected() || rdbtnLuxuryBus.isSelected() || rdbtnPartyBus.isSelected())) {
					str = str + "\nBus modeltype must be selected!";
				}
				if (rdbtnStandardBus.isSelected()) {
					modelType = "STANDARD";
				}
				if (rdbtnLuxuryBus.isSelected()) {
					modelType = "LUXURY";
				}
				if (rdbtnPartyBus.isSelected()) {
					modelType = "PARTY";
				}

				if (str.equals("")) {
					busesArchive.addBus(new Bus(maxSeats, textFieldVehicleID.getText(), priceHour, modelType));
					updateListBuses(textFieldVehicleID.getText(), priceHour, maxSeats, maxSeats, modelType, true);
					// updateListSelectBus(new Bus(maxSeats,
					// textFieldVehicleID.getText(), priceHour, modelType));
					textFieldVehicleID.setText("");
					textFieldPriceHour.setText("");
					textFieldNumberSeats.setText("");
					rdbtnStandardBus.setSelected(false);
					rdbtnLuxuryBus.setSelected(false);
					rdbtnPartyBus.setSelected(false);

					try {
						busesArchive.saveBusesArchive();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You have to fill out the fields correct:\n" + str);
				}
			}
		});

		rdbtnStandardBus.addActionListener(new ActionListener() {
			/**
			 * This makes rdbtnLuxuryBus and rdbtnPartyBus unselected if the
			 * type of this Bus is standard
			 */
			public void actionPerformed(ActionEvent arg0) {
				rdbtnLuxuryBus.setSelected(false);
				rdbtnPartyBus.setSelected(false);
			}
		});

		rdbtnPartyBus.addActionListener(new ActionListener() {
			/**
			 * This makes rdbtnLuxuryBus and rdbtnStandartBus unselected if the
			 * type of this Bus is party
			 */
			public void actionPerformed(ActionEvent e) {
				rdbtnLuxuryBus.setSelected(false);
				rdbtnStandardBus.setSelected(false);
			}
		});

		rdbtnLuxuryBus.addActionListener(new ActionListener() {
			/**
			 * This makes rdbtnStandartBus and rdbtnPartyBus unselected if the
			 * type of this Bus is luxury
			 */
			public void actionPerformed(ActionEvent e) {
				rdbtnPartyBus.setSelected(false);
				rdbtnStandardBus.setSelected(false);
			}
		});

		labelDeleteBusBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This deletes selected Bus from tableBuses and busesArchive and
			 * updates busesArchive. After the button has been pressed, an
			 * okOrCancel notification pops up and asks if the user really wants
			 * to delete this Bus. If user clicks OK Button, selected Bus is
			 * deleted from tableBuses and busesArchive
			 */
			public void mouseReleased(MouseEvent e) {
				int index = tableBuses.getSelectedRow();
				if (index != -1) {
					if (okOrCancel("Are you sure you want to delete this bus?") == 0) {
						busesTable.removeRow(index);
						busesArchive.get(index).getListOfStartEndDates().clear();
						busesArchive.removeBus(index);
						try {
							busesArchive.saveBusesArchive();
						} catch (Exception e2) {

							e2.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "You need first to select the row you wish to delete!");
				}
			}
		});

		chckbxBreakfast.addActionListener(new ActionListener() {
			/**
			 * If breakfast is selected, chckbxAllInclusive isn't selected
			 */
			public void actionPerformed(ActionEvent arg0) {
				chckbxAllInclusive.setSelected(false);
			}
		});

		chckbxLunch.addActionListener(new ActionListener() {
			/**
			 * If lunch is selected, chckbxAllInclusive isn't selected
			 */
			public void actionPerformed(ActionEvent e) {
				chckbxAllInclusive.setSelected(false);
			}
		});

		chckbxAllInclusive.addActionListener(new ActionListener() {
			/**
			 * If allInclusive is selected, chckbxBreakfast and chckbxLunch
			 * aren't selected
			 */
			public void actionPerformed(ActionEvent e) {
				chckbxBreakfast.setSelected(false);
				chckbxLunch.setSelected(false);
			}
		});

		lblAddPickUpBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This adds pick up from textFieldAddPickup TextField to
			 * tablePickups table and updates listPickUps after the button was
			 * pressed
			 */
			public void mouseReleased(MouseEvent arg0) {
				if (!textFieldAddPickup.getText().equalsIgnoreCase("")) {
					updateListPickUps();
				}
			}
		});

		lblClearPickUpBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This clears selected pickUp from the tablePickups table. If the
			 * button is pressed without selected pick up from the tablePickups
			 * table, the notification pops with the message: "You need first to
			 * select the row you wish to delete!"
			 */
			public void mouseReleased(MouseEvent e) {

				int index = tablePickups.getSelectedRow();
				if (index != -1) {
					pickupsTable.removeRow(index);
				} else {
					JOptionPane.showMessageDialog(null, "You need first to select the row you wish to delete!");
				}
			}
		});

		lblAddTourBtn.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.
			 * MouseEvent)
			 */
			@Override
			/**
			 * This adds Tour in Tours Archive according to tableSelectBus,
			 * tableSelectChauffeur, tablePickups, chckbxBreakfast, chckbxLunch,
			 * chckbxAllInclusive, chckbxEntranceTickets fields. If some of the
			 * fields are completed incorrectly, the notification pops up that
			 * says what fields should be changed
			 */
			public void mouseReleased(MouseEvent arg0) {
				String str = new String("");
				int monthStart = 0;
				int monthEnd = 0;
				int dayStart = 0;
				int dayEnd = 0;
				int yearStart = 0;
				int yearEnd = 0;
				int hourStart = 0;
				int hourEnd = 0;
				int minuteStart = 0;
				int minuteEnd = 0;
				Date startDate = null;
				Date endDate = null;
				java.util.Date javastartDate = null;
				java.util.Date javaendDate = null;
				int dayCount = -1;
				int workHoursPerDay = 8; // for calculating price per passenger
											// (8 hours per day * price per hour
											// = day price)
				Calendar timeNow = Calendar.getInstance();
				int currentYear = timeNow.get(Calendar.YEAR);
				Services services = null;
				try {
					services = new Services();
				} catch (Exception e2) {

					e2.printStackTrace();
				}
				if (textFieldDestination.getText().equalsIgnoreCase("")) {
					str += "\nDestination cannot be empty!";
				}

				try {
					monthStart = Integer.parseInt(textFieldStartMonth.getText());
					if (monthStart > 12 || monthStart < 1)
						str = str + "\nStart month does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart month does not seem to be a number between 1-12!";
				}
				try {
					dayStart = Integer.parseInt(textFieldStartDay.getText());
					if (monthStart == 1 || monthStart == 3 || monthStart == 5 || monthStart == 7 || monthStart == 8
							|| monthStart == 10 || monthStart == 12) {
						if (!(1 <= dayStart && dayStart <= 31)) {
							str = str + "\nStart day does not seem to be a number between 1-31!";
						}
					} else if (monthStart == 2) {
						if (!(1 <= dayStart && dayStart <= 28)) {
							str = str + "\nStart day does not seem to be a number between 1-28!";
						}
					} else if (monthStart == 4 || monthStart == 6 || monthStart == 9 || monthStart == 11) {
						if (!(1 <= dayStart && dayStart <= 30)) {
							str = str + "\nStart day does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nStart day does not seem to be a number between 1-31!";
				}
				try {
					yearStart = Integer.parseInt(textFieldStartYear.getText());
					if (yearStart < currentYear)
						str = str + "\nStart year does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart year does not appear to be a valid number!";
				}

				try {
					monthEnd = Integer.parseInt(textFieldEndMonth.getText());
					if (monthEnd > 12 || monthEnd < 1)
						str = str + "\nEnd month does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nEndt month does not seem to be a number between 1-12!";
				}
				try {
					dayEnd = Integer.parseInt(textFieldEndDay.getText());
					if (monthEnd == 1 || monthEnd == 3 || monthEnd == 5 || monthEnd == 7 || monthEnd == 8
							|| monthEnd == 10 || monthEnd == 12) {
						if (!(1 <= dayEnd && dayEnd <= 31)) {
							str = str + "\nEnd day does not seem to be a number between 1-31!";
						}
					} else if (monthEnd == 2) {
						if (!(1 <= dayEnd && dayEnd <= 28)) {
							str = str + "\nEnd day does not seem to be a number between 1-28!";
						}
					} else if (monthEnd == 4 || monthEnd == 6 || monthEnd == 9 || monthEnd == 11) {
						if (!(1 <= dayEnd && dayEnd <= 30)) {
							str = str + "\nEnd day does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nEnd day does not seem to be a number between 1-31!";
				}
				try {
					yearEnd = Integer.parseInt(textFieldEndYear.getText());
					if (yearEnd < currentYear)
						str = str + "\nEnd year does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nEnd year does not appear to be a valid number!";
				}

				if (tableSelectBus.getSelectedRow() == -1) {
					str += "\nYou need to select a bus!";
				}
				if (tableSelectChauffeur.getSelectedRow() == -1) {
					str += "\nYou need to select a chauffeur!";
				}

				if (yearEnd < yearStart) {
					str += "\nEnd year cannont be before start year!";
				}
				if (yearStart == yearEnd && monthEnd < monthStart) {
					str += "\nEnd date must be after start date!";
				}
				if (yearStart == yearEnd && monthStart == monthEnd && dayStart > dayEnd) {
					str += "\nEnd date must be later than start date!";
				}

				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date startRentDate = null, endRentDate = null, currentDate = new java.util.Date();

				try {
					startRentDate = dateformat.parse(dayStart + "/" + monthStart + "/" + yearStart);
					endRentDate = dateformat.parse(dayEnd + "/" + monthEnd + "/" + yearEnd);
				} catch (ParseException e) {

					e.printStackTrace();
				}
				try {
					hourStart = Integer.parseInt(textFieldStartHour.getText());
					if (hourStart < 0 && hourStart > 23)
						str = str + "\nStart hour does not appear to be a number between 0-23!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart hour does not appear to be a valid number!";
				}
				try {
					hourEnd = Integer.parseInt(textFieldEndHour.getText());
					if (hourEnd < 0 && hourEnd > 23)
						str = str + "\nEnd hour does not appear to be a number between 0-23!";
				} catch (NumberFormatException e1) {
					str = str + "\nEnd hour does not appear to be a valid number!";
				}
				try {
					minuteStart = Integer.parseInt(textFieldStartMinute.getText());
					if (minuteStart < 0 && minuteStart > 59)
						str = str + "\nStart minute does not appear to be a number between 0-59!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart minute does not appear to be a valid number!";
				}
				try {
					minuteEnd = Integer.parseInt(textFieldEndMinute.getText());
					if (minuteEnd < 0 && minuteEnd > 59)
						str = str + "\nEnd minute does not appear to be a number between 0-59!";
				} catch (NumberFormatException e1) {
					str = str + "\nEnd minute does not appear to be a valid number!";
				}

				if (str.equals("")) {
					if (currentDate.equals(startRentDate) && startRentDate.before(endRentDate)
							|| currentDate.before(startRentDate) && startRentDate.before(endRentDate)) {
						dayCount = daysBetweenDates(startRentDate, endRentDate);

					}
					startDate = new Date(monthStart, dayStart, yearStart);
					endDate = new Date(monthEnd, dayEnd, yearEnd);
					try {
						toursArchive.addTour(new Tour(textFieldDestination.getText()));
					} catch (Exception e1) {

						e1.printStackTrace();
					}
					if (tablePickups.getRowCount() == 0) {
						toursArchive.get(toursArchive.size() - 1).setPickUpPlaces("");
					}
					for (int i = 0; i < tablePickups.getRowCount(); i++) {
						toursArchive.get(toursArchive.size() - 1)
								.setPickUpPlaces((String) tablePickups.getModel().getValueAt(i, 0));
					}
					String strBus = (String) tableSelectBus.getModel().getValueAt(tableSelectBus.getSelectedRow(), 0);
					Bus bus = busesArchive.getBusById(strBus);
					javastartDate = parseDate(
							yearStart + "-" + monthStart + "-" + dayStart + "-" + hourStart + "-" + minuteStart);
					javaendDate = parseDate(yearEnd + "-" + monthEnd + "-" + dayEnd + "-" + hourEnd + "-" + minuteEnd);
					bus.addNewReservationPeriod(new java.util.Date[] { javastartDate, javaendDate });
					toursArchive.get(toursArchive.size() - 1)
							.setNewDateInterval(new java.util.Date[] { javastartDate, javaendDate });
					try {
						busesArchive.saveBusesArchive();
					} catch (Exception e) {
						e.printStackTrace();
					}
					toursArchive.get(toursArchive.size() - 1).setBus(bus);
					double price = round(
							(bus.getPricePerHour() * workHoursPerDay * dayCount) / bus.getMaxNumberOfSeats(), 2); // price
																													// per
																													// passenger
																													// rounded
																													// to
																													// 2
																													// decimals
					if (chckbxAllInclusive.isSelected()) {
						price += dayCount * priceList.getPriceAllInclusive();
						services.setAllInclusive(true);
					}
					if (chckbxBreakfast.isSelected()) {
						price += dayCount * priceList.getPriceBreakfast();
						services.setBreakfastIncluded(true);
					}
					if (chckbxLunch.isSelected()) {
						price += dayCount * priceList.getPriceLunch();
						services.setLunchIncluded(true);
					}
					if (chckbxEntranceTickets.isSelected()) {
						price += priceList.getPriceEntranceTickets();
						services.setEntranceTickets(true);
					}
					toursArchive.get(toursArchive.size() - 1).setPricePerPassenger(price);
					toursArchive.get(toursArchive.size() - 1).setServices(services);
					toursArchive.get(toursArchive.size() - 1).setSeatsAvailable(
							toursArchive.get(toursArchive.size() - 1).getBus().getMaxNumberOfSeats());
					String strChauffeur = (String) tableSelectChauffeur.getModel()
							.getValueAt(tableSelectChauffeur.getSelectedRow(), 0);
					Chauffeur chauffeur = chauffeursArchive.getChauffeurById(strChauffeur);
					chauffeur.addNewReservationPeriod(new java.util.Date[] { javastartDate, javaendDate });
					try {
						chauffeursArchive.saveChauffeursArchive();
					} catch (Exception e) {
						e.printStackTrace();
					}
					toursArchive.get(toursArchive.size() - 1).setChauffeur(chauffeur);
					toursArchive.get(toursArchive.size() - 1).setDateInterval(new DateInterval(startDate, endDate));

					/*
					 * updateListTours(startDate.displayDate()+" -\n"+endDate.
					 * displayDate(), textFieldDestination.getText(),
					 * toursArchive.get(toursArchive.size()-1).
					 * getPickUpPlacesString(),
					 * String.valueOf(toursArchive.get(toursArchive.size()-1).
					 * getSeatsAvailable()),
					 * String.valueOf(toursArchive.get(toursArchive.size()-1).
					 * getTotalPrice()), String.valueOf(price),
					 * "#"+bus.getVehicleID()+" "+bus.getModelString()+" "+bus.
					 * getMaxNumberOfSeats()+" seats",
					 * "#"+chauffeur.getEmployeeNumber()+" "+chauffeur.getName()
					 * ,
					 * toursArchive.get(toursArchive.size()-1).getServicesString
					 * ());
					 */
					textFieldDestination.setText("");
					textFieldStartMonth.setText("");
					textFieldStartDay.setText("");
					textFieldStartYear.setText("");
					textFieldEndMonth.setText("");
					textFieldEndDay.setText("");
					textFieldEndYear.setText("");

					textFieldStartHour.setText("");
					textFieldStartMinute.setText("");
					textFieldEndHour.setText("");
					textFieldEndMinute.setText("");
					chckbxBreakfast.setSelected(false);
					chckbxLunch.setSelected(false);
					chckbxAllInclusive.setSelected(false);
					chckbxEntranceTickets.setSelected(false);
					textFieldAddPickup.setText("");
					pickupsTable = (DefaultTableModel) tablePickups.getModel();
					pickupsTable.setRowCount(0);
					tableSelectBus.clearSelection();
					tableSelectChauffeur.clearSelection();
					try {
						toursArchive.saveToursArchive();
					} catch (Exception e) {

						e.printStackTrace();
					}
					listBuses();
					listChauffeurs();
					listTours();
				} else {
					JOptionPane.showMessageDialog(null, "You have to fill out the fields correct:\n" + str);
				}

			}
		});

		lblDeleteTourBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This deletes selected Tour from tableTours table and
			 * toursArchive. After the button was pressed an okOrCancel
			 * notification pops up and asks the user if he really wants to
			 * delete this Tour. If the user clicks OK Button, this Tour is
			 * deleted from tableTours table and toursArchive
			 */
			public void mouseReleased(MouseEvent arg0) {
				int index = tableTours.getSelectedRow();
				if (index != -1) {
					if (okOrCancel("Are you sure you want to delete this tour?") == 0) {
						Bus bus = toursArchive.get(index).getBus();
						Chauffeur chauffeur = toursArchive.get(index).getChauffeursObject();
						for (int i = 0; i < reservationsArchive.size(); i++) {
							if (reservationsArchive.get(i) instanceof TourReservation) {
								if (((TourReservation) reservationsArchive.get(i)).getTour().getDepartureDate()
										.equals(toursArchive.get(index).getDepartureDate())
										&& ((TourReservation) reservationsArchive.get(i)).getTour().getBus()
												.getVehicleID()
												.equals(toursArchive.get(index).getBus().getVehicleID())) {
									reservationsArchive.get(i).getCustomer()
											.setMoneySpent(reservationsArchive.get(i).getCustomer().getMoneySpent()
													- toursArchive.get(index).getTotalPrice());
								}
							}
						}
						for (int i = 0; i < bus.getListOfStartEndDates().size(); i++) {
							if (toursArchive.get(index).getNewDateInterval()[0].toString()
									.equals(bus.getListOfStartEndDates().get(i)[0].toString())) {
								bus.getListOfStartEndDates().remove(i);
								bus.setDatePointer(
										bus.getDatePointer() <= i ? bus.getDatePointer() : bus.getDatePointer() - 1);
								break;

							}
						}
						for (int i = 0; i < chauffeur.getListOfStartEndDates().size(); i++) {
							if (toursArchive.get(index).getNewDateInterval()[0].toString()
									.equals(chauffeur.getListOfStartEndDates().get(i)[0].toString())) {
								chauffeur.getListOfStartEndDates().remove(i);
								chauffeur.setDatePointer(chauffeur.getDatePointer() <= i ? chauffeur.getDatePointer()
										: chauffeur.getDatePointer() - 1);
								break;
							}
						}
						toursTable.removeRow(index);
						toursArchive.removeTour(index);
						try {
							customersArchive.saveCustomersArchive();
							busesArchive.saveBusesArchive();
							chauffeursArchive.saveChauffeursArchive();
							toursArchive.saveToursArchive();
						} catch (Exception e2) {

							e2.printStackTrace();
						}
						listBuses();
						listChauffeurs();
						listCustomers();
						listTours();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You need first to select the row you wish to delete!");
				}
			}
		});

		lblDeleteTourReservation.addMouseListener(new MouseAdapter() {
			/**
			 * This deletes TourReservation from reservationsArchive and removes
			 * it from the tableTourReservations table and saves
			 * reservationArchive. After the button was pressed an okOrCancel
			 * notification pops up and asks if the user really wants to delete
			 * selected TourReservation. If users click OK Button, this
			 * TourReservation is deleted from tableTourReservations and
			 * toursArchive
			 */
			public void mouseReleased(MouseEvent arg0) {
				int index = tableTourReservations.getSelectedRow();
				if (index != -1) {
					if (okOrCancel("Are you sure you want to delete this Tour Reservation?") == 0) {
						TourReservation tourReservationToDelete = null;
						int indexOfTourReservationToDelete = -1;
						int reservationNumberOfTourResToDelete = (int) tableTourReservations
								.getValueAt(tableTourReservations.getSelectedRow(), 0);
						for (int i = 0; i < reservationsArchive.size(); i++) {
							if (reservationsArchive.get(i)
									.getReservationNumber() == reservationNumberOfTourResToDelete) {
								indexOfTourReservationToDelete = i;
								tourReservationToDelete = (TourReservation) reservationsArchive.get(i);
								break;
							}
						}
						tourReservationToDelete.getTour()
								.setTotalPrice(tourReservationToDelete.getTour().getTotalPrice()
										- tourReservationToDelete.getTotalPrice());
						tourReservationToDelete.getTour()
								.setSeatsAvailable(tourReservationToDelete.getTour().getSeatsAvailable()
										+ tourReservationToDelete.getPassengers().size());
						tourReservationToDelete.getCustomer()
								.setMoneySpent(tourReservationToDelete.getCustomer().getMoneySpent()
										- tourReservationToDelete.getTotalPrice());
						reservationsArchive.removeReservation(indexOfTourReservationToDelete);
						tourReservationsTable.removeRow(index);
						try {
							toursArchive.saveToursArchive();
							customersArchive.saveCustomersArchive();
							reservationsArchive.saveReservationsArchive();
						} catch (Exception e) {
							e.printStackTrace();
						}
						listTourReservations();
						listCustomers();
						listTours();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You need first to select the row you wish to delete!");
				}
			}
		});

		lblDeleteBus.addMouseListener(new MouseAdapter() {
			/**
			 * This deletes Bus Reservation from tableBusReservations table and
			 * reservationArchive. After the button was pressed an okOrCancel
			 * notification pops up and ask the user if he really wants to
			 * delete this Bus Reservation. If user clicks OK Button, this Bus
			 * Reservation is deleted from tableBusReservations table and
			 * reservationArchive.
			 */
			public void mouseReleased(MouseEvent arg0) {
				int index = tableBusReservations.getSelectedRow();
				if (index != -1) {
					if (okOrCancel("Are you sure you want to delete this Bus & Chauffeur Reservation?") == 0) {
						BusReservation reservationToDelete = null;
						int indexOfBusResToDelete = -1;
						int reservationNumberOfBusResToDelete = (int) tableBusReservations
								.getValueAt(tableBusReservations.getSelectedRow(), 0);
						for (int i = 0; i < reservationsArchive.size(); i++) {
							if (reservationsArchive.get(i)
									.getReservationNumber() == reservationNumberOfBusResToDelete) {
								reservationToDelete = (BusReservation) reservationsArchive.get(i);
								indexOfBusResToDelete = i;
								break;
							}
						}
						reservationToDelete.getCustomer()
								.setMoneySpent(reservationToDelete.getCustomer().getMoneySpent()
										- reservationToDelete.getTotalPrice());
						Bus bus = reservationToDelete.getBus();
						Chauffeur chauffeur = reservationToDelete.getChauffeur();
						for (int i = 0; i < bus.getListOfStartEndDates().size(); i++) {
							if (reservationToDelete.getNewDateInterval()[0].toString()
									.equals(bus.getListOfStartEndDates().get(i)[0].toString())) {
								bus.getListOfStartEndDates().remove(i);
								bus.setDatePointer(
										bus.getDatePointer() <= i ? bus.getDatePointer() : bus.getDatePointer() - 1);
								break;

							}
						}
						for (int i = 0; i < chauffeur.getListOfStartEndDates().size(); i++) {
							if (reservationToDelete.getNewDateInterval()[0].toString()
									.equals(chauffeur.getListOfStartEndDates().get(i)[0].toString())) {
								chauffeur.getListOfStartEndDates().remove(i);
								chauffeur.setDatePointer(chauffeur.getDatePointer() <= i ? chauffeur.getDatePointer()
										: chauffeur.getDatePointer() - 1);
								break;
							}
						}
						busReservationsTable.removeRow(index);
						reservationsArchive.removeReservation(indexOfBusResToDelete);

						try {
							customersArchive.saveCustomersArchive();
							chauffeursArchive.saveChauffeursArchive();
							busesArchive.saveBusesArchive();
							reservationsArchive.saveReservationsArchive();
						} catch (Exception e) {
							e.printStackTrace();
						}
						listBusReservations();
						listBuses();
						listChauffeurs();
						listCustomers();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You need first to select the row you wish to delete!");
				}
			}
		});

		lblUpdatePriceBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This updates prices for breakfast, lunch, allInclusive and
			 * entranceTickets from textFieldPriceBreakfast,
			 * textFieldPriceLunch, textFieldPriceAllinclusive,
			 * textFieldPriceEntranceTickets fields after the button was clicked
			 * and notification with the message: "Prices where updated
			 * succesfully!" appears
			 */
			public void mouseReleased(MouseEvent arg0) {

				priceList.setPriceBreakfast(Double.parseDouble(textFieldPriceBreakfast.getText()));
				priceList.setPriceLunch(Double.parseDouble(textFieldPriceLunch.getText()));
				priceList.setPriceAllInclusive(Double.parseDouble(textFieldPriceAllinclusive.getText()));
				priceList.setPriceEntranceTickets(Double.parseDouble(textFieldPriceEntranceTickets.getText()));
				try {
					priceList.savePriceList();
					JOptionPane.showMessageDialog(null, "Prices where updated succesfully!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				updatePrices();
			}
		});

		lblNewBusSearchCustomerBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This searches for Customer from customersArchive by phone number
			 * from textFieldNewBusCustomerPhone TextField. If the
			 * textFieldNewBusCustomerPhone is empty, a the notification pops up
			 * with the message: "You need to fill in the phone number first!".
			 * If the Customer wasn't found by the number, the notification pops
			 * up with the message: "You need to fill in the phone number
			 * first!". After the Customer was found,
			 * textFieldNewBusOrganisationName, rdbtnNewBusCompany,
			 * rdbtnNewBusSchool, rdbtnNewBusPrivate,
			 * textFieldNewBusCustomerName, textFieldNewBusCustomerAddress,
			 * textFieldNewBusCustomerEmail, textFieldNewBusCustomerBmonth,
			 * textFieldNewBusCustomerBday, textFieldNewBusCustomerByear fields
			 * are filled with the information of this Customer
			 */
			public void mouseReleased(MouseEvent arg0) {
				if (textFieldNewBusCustomerPhone.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "You need to fill in the phone number first!");
				} else {
					try {
						int phone = Integer.parseInt(textFieldNewBusCustomerPhone.getText());
						if (!(10000000 < phone && phone <= 99999999)) {
							JOptionPane.showMessageDialog(null, "Phonenumber does not have 8 digits!");
						} else {
							for (int i = 0; i < customersArchive.size(); i++) {
								if (customersArchive.get(i).getPhonenumber()
										.equalsIgnoreCase(textFieldNewBusCustomerPhone.getText())) {
									textFieldNewBusOrganisationName
											.setText(customersArchive.get(i).getOrganisationName());
									textFieldNewBusCustomerName.setText(customersArchive.get(i).getName());
									textFieldNewBusCustomerAddress.setText(customersArchive.get(i).getAddress());
									textFieldNewBusCustomerEmail.setText(customersArchive.get(i).getEmail());
									textFieldNewBusCustomerBmonth.setText(
											Integer.toString(customersArchive.get(i).getBirthday().getMonth()));
									textFieldNewBusCustomerBday
											.setText(Integer.toString(customersArchive.get(i).getBirthday().getDay()));
									textFieldNewBusCustomerByear
											.setText(Integer.toString(customersArchive.get(i).getBirthday().getYear()));
									if (customersArchive.get(i).getOrganisationType().equalsIgnoreCase("PRIVATE")) {
										rdbtnNewBusCompany.setSelected(false);
										rdbtnNewBusPrivate.setSelected(true);
										rdbtnNewBusSchool.setSelected(false);
									}
									if (customersArchive.get(i).getOrganisationType().equalsIgnoreCase("COMPANY")) {
										rdbtnNewBusCompany.setSelected(true);
										rdbtnNewBusPrivate.setSelected(false);
										rdbtnNewBusSchool.setSelected(false);
									}
									if (customersArchive.get(i).getOrganisationType().equalsIgnoreCase("SCHOOL")) {
										rdbtnNewBusCompany.setSelected(false);
										rdbtnNewBusPrivate.setSelected(false);
										rdbtnNewBusSchool.setSelected(true);
									}
									break;
								}
								if (i == customersArchive.size() - 1 || customersArchive.size() == 0) {
									JOptionPane.showMessageDialog(null,
											"No customer match found!\nPlease fill in new customer.");
								}

							}
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Entered phonenumber does not appear to be digits!");
					}
				}
			}
		});

		lblNewBusCustomerClear.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This clears textFieldNewBusOrganisationName, rdbtnNewBusCompany,
			 * rdbtnNewBusSchool, rdbtnNewBusPrivate,
			 * textFieldNewBusCustomerName, textFieldNewBusCustomerAddress,
			 * textFieldNewBusCustomerEmail, textFieldNewBusCustomerBmonth,
			 * textFieldNewBusCustomerBday, textFieldNewBusCustomerByear fields
			 * in NewBusCustomer after the Button was pressed
			 */
			public void mouseReleased(MouseEvent arg0) {
				textFieldNewBusOrganisationName.setText("");
				textFieldNewBusCustomerName.setText("");
				textFieldNewBusCustomerAddress.setText("");
				textFieldNewBusCustomerEmail.setText("");
				textFieldNewBusCustomerBmonth.setText("");
				textFieldNewBusCustomerBday.setText("");
				textFieldNewBusCustomerByear.setText("");
				textFieldNewBusCustomerPhone.setText("");
				rdbtnNewBusCompany.setSelected(false);
				rdbtnNewBusPrivate.setSelected(false);
				rdbtnNewBusSchool.setSelected(false);
				chckbxNewBusIsPassenger.setSelected(false);
			}
		});

		lblClearCustomerButtonNewTourReservation.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This clears lblPhoneInNewTourReservationtextField,
			 * customerOrganisationtextField,
			 * radioButtonIsCompanyNewTourReservation
			 * radioButtonIsSchoolNewTourReservation,
			 * radioButtonIsPrivateInNewTourReservation
			 * customerNameNewTourReservationTextField,
			 * customerAddressIncustomerEmailNewTourReservationTextField,
			 * customerEmailNewTourReservationtextField,
			 * customerMonthInNewTourReservationTextField,
			 * customerDayInNewTourReservationTextField,
			 * customerYearInNewTourReservationTextField fields in
			 * NewTourReservation after the Button was pressed
			 */
			public void mouseReleased(MouseEvent arg0) {
				customerNameNewTourReservationTextField.setText("");
				customerOrganisationtextField.setText("");
				customerAddressIncustomerEmailNewTourReservationTextField.setText("");
				customerEmailNewTourReservationtextField.setText("");
				customerMonthInNewTourReservationTextField.setText("");
				customerDayInNewTourReservationTextField.setText("");
				customerYearInNewTourReservationTextField.setText("");
				lblPhoneInNewTourReservationtextField.setText("");
				radioButtonIsCompanyNewTourReservation.setSelected(false);
				radioButtonIsPrivateInNewTourReservation.setSelected(false);
				radioButtonIsSchoolNewTourReservation.setSelected(false);
				chckbxNewBusIsPassenger.setSelected(false);
			}
		});

		rdbtnNewBusCompany.addActionListener(new ActionListener() {
			/**
			 * If company is selected for this Customer in New Tour Reservation,
			 * rdbtnNewBusPrivate and rdbtnNewBusSchool are unselected
			 */
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNewBusPrivate.setSelected(false);
				rdbtnNewBusSchool.setSelected(false);
			}
		});

		rdbtnNewBusSchool.addActionListener(new ActionListener() {
			/**
			 * If school is selected for this Customer in New Tour Reservation,
			 * rdbtnNewBusPrivate and rdbtnNewBusCompany are unselected
			 */
			public void actionPerformed(ActionEvent e) {
				rdbtnNewBusCompany.setSelected(false);
				rdbtnNewBusPrivate.setSelected(false);
			}
		});

		rdbtnNewBusPrivate.addActionListener(new ActionListener() {
			/**
			 * If private is selected for this Customer in New Tour Reservation,
			 * rdbtnNewBusCompany and rdbtnNewBusSchool are unselected
			 */
			public void actionPerformed(ActionEvent e) {
				rdbtnNewBusCompany.setSelected(false);
				rdbtnNewBusSchool.setSelected(false);
				textFieldNewBusCustomerName.setText(textFieldNewBusOrganisationName.getText());
			}
		});

		chckbxNewBusIsPassenger.addActionListener(new ActionListener() {
			/**
			 * This adds Customer in New Tour Reservation in
			 * selectPassengersScrollPanelInNewTourReservation table according
			 * to lblPhoneInNewTourReservationtextField,
			 * customerOrganisationtextField,
			 * radioButtonIsCompanyNewTourReservation
			 * radioButtonIsSchoolNewTourReservation,
			 * radioButtonIsPrivateInNewTourReservation
			 * customerNameNewTourReservationTextField,
			 * customerAddressIncustomerEmailNewTourReservationTextField,
			 * customerEmailNewTourReservationtextField,
			 * customerMonthInNewTourReservationTextField,
			 * customerDayInNewTourReservationTextField,
			 * customerYearInNewTourReservationTextField fields
			 */
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewBusIsPassenger.isSelected()) {
					String str = new String();
					int month = 0;
					int day = 0;
					int year = 0;
					Calendar timeNow = Calendar.getInstance();
					int currentYear = timeNow.get(Calendar.YEAR);
					try {
						int phone = Integer.parseInt(textFieldNewBusCustomerPhone.getText());
						if (!(10000000 < phone && phone <= 99999999)) {
							str += "\nPhone number does not have 8 digits!";
						}
					} catch (Exception e3) {
						str += "\nEntered phone number does not appear to be digits!";
					}
					if (textFieldNewBusOrganisationName.getText().equalsIgnoreCase("")) {
						str += "\nName/organisation cannot be empty!";
					}
					if (textFieldNewBusCustomerName.getText().equalsIgnoreCase("")) {
						str += "\nName/contact cannot be empty!";
					}
					if (textFieldNewBusCustomerAddress.getText().equalsIgnoreCase("")) {
						str += "\nAddress cannot be empty!";
					}
					if (textFieldNewBusCustomerEmail.getText().equalsIgnoreCase("")) {
						str += "\nEmail address cannot be empty!";
					}
					if (!(textFieldNewBusCustomerEmail.getText().contains("@")
							&& textFieldNewBusCustomerEmail.getText().contains("."))) {
						str += "\nEmail address does not appear to be in correct format!";
					}

					try {
						month = Integer.parseInt(textFieldNewBusCustomerBmonth.getText());
						if (month > 12 || month < 1)
							str = str + "\nMonth does not seem to be a number between 1-12!";
					} catch (NumberFormatException e1) {
						str = str + "\nMonth does not seem to be a number between 1-12!";
					}
					try {
						day = Integer.parseInt(textFieldNewBusCustomerBday.getText());
						if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
								|| month == 12) {
							if (!(1 <= day && day <= 31)) {
								str = str + "\nDay does not seem to be a number between 1-31!";
							}
						} else if (month == 2) {
							if (!(1 <= day && day <= 28)) {
								str = str + "\nDay does not seem to be a number between 1-28!";
							}
						} else if (month == 4 || month == 6 || month == 9 || month == 11) {
							if (!(1 <= day && day <= 30)) {
								str = str + "\nDay does not seem to be a number between 1-30!";
							}
						}
					} catch (NumberFormatException e1) {
						str = str + "\nDay does not seem to be a number between 1-31!";
					}
					try {
						year = Integer.parseInt(textFieldNewBusCustomerByear.getText());
						if (year > currentYear || year < currentYear - 120)
							str = str + "\nYear does not appear to be a valid number!";
					} catch (NumberFormatException e1) {
						str = str + "\nYear does not appear to be a valid number!";
					}

					if (str.equalsIgnoreCase("")) {
						Passenger newPassenger = null;
						for (int i = 0; i < passengersArchive.size(); i++) {
							if (passengersArchive.get(i).getPhonenumber().equals(textFieldNewBusCustomerPhone.getText())
									&& passengersArchive.get(i).getName()
											.equals(textFieldNewBusCustomerName.getText())) {
								newPassenger = passengersArchive.get(i);
								break;
							}
						}
						if (newPassenger == null) {
							passengersArchive.addPassenger(new Passenger(textFieldNewBusCustomerName.getText(),
									textFieldNewBusCustomerEmail.getText(), textFieldNewBusCustomerAddress.getText(),
									new Date(Integer.parseInt(textFieldNewBusCustomerBmonth.getText()),
											Integer.parseInt(textFieldNewBusCustomerBday.getText()),
											Integer.parseInt(textFieldNewBusCustomerByear.getText())),
									textFieldNewBusCustomerPhone.getText()));
							newPassenger = passengersArchive.get(Autobus.frame.passengersArchive.size() - 1);
						}
						updatePassengerListNewBus(newPassenger);

					} else {
						JOptionPane.showMessageDialog(null, "You have to fill out the fields correct:\n" + str);
						chckbxNewBusIsPassenger.setSelected(false);
					}
				} else {
					for (int i = 0; i < Autobus.frame.passengersArchive.size(); i++) {
						if (Autobus.frame.passengersArchive.get(i).getName()
								.equals(textFieldNewBusCustomerName.getText())
								&& Autobus.frame.passengersArchive.get(i).getName()
										.equals(textFieldNewBusCustomerPhone.getText())) {
							Autobus.frame.passengersArchive.removePassenger(i);
							break;
						}
					}
					DefaultTableModel tableModel = (DefaultTableModel) tableNewBusPassengers.getModel();
					for (int i = 0; i < tableNewBusPassengers.getRowCount(); i++) {
						if (tableNewBusPassengers.getValueAt(i, 0).equals(textFieldNewBusCustomerName.getText())
								&& tableNewBusPassengers.getValueAt(i, 2)
										.equals(textFieldNewBusCustomerPhone.getText())) {
							tableModel.removeRow(i);
							break;
						}
					}
				}
				try {
					Autobus.frame.passengersArchive.savePassengersArchive();
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});

		lblNewBusClearAllBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This clears all Passengers from tableNewBusPassengers table in
			 * New Bus & Chauffeur Reservation
			 */
			public void mouseReleased(MouseEvent arg0) {
				newBusPassengersTable.setRowCount(0);
				chckbxNewBusIsPassenger.setSelected(false);
			}
		});

		lblNewBusRemovePassengerBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This removes selected Passenger from tableNewBusPassengers table
			 * in New Bus & Chauffeur Reservation. If the button was clicked, an
			 * okOrCancel notification pops up and ask the user if he really
			 * wants to remove this passenger. If the user clicks OK Button, the
			 * selected passenger is removed from tableNewBusPassengers. If the
			 * Button was pressed and the passenger wasn't selected from
			 * tableNewBusPassengers, the notification pops up with message:
			 * "You need first to select the passenger you wish to remove!"
			 */
			public void mouseReleased(MouseEvent e) {
				newBusPassengerReservationTable = (DefaultTableModel) tableNewBusPassengers.getModel();
				int index = tableNewBusPassengers.getSelectedRow();
				if (index != -1) {
					if (okOrCancel("Are you sure you want to remove this passenger from the list?") == 0) {
						newBusPassengerReservationTable.removeRow(index);
					}
				} else {
					JOptionPane.showMessageDialog(null, "You need first to select the passenger you wish to remove!");
				}
			}
		});

		lblNewBusPassengerClearBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This clears Passengers textFieldNewBusPassengerPhone,
			 * textFieldNewBusPassengerName, textFieldNewBusPassengerAddress,
			 * textFieldNewBusPassengerEmail, textFieldNewBusPassengerBmonth,
			 * textFieldNewBusPassengerBday, textFieldNewBusPassengerByear
			 * fields after the button was clicked.
			 */
			public void mouseReleased(MouseEvent e) {
				textFieldNewBusPassengerPhone.setText("");
				textFieldNewBusPassengerName.setText("");
				textFieldNewBusPassengerAddress.setText("");
				textFieldNewBusPassengerEmail.setText("");
				textFieldNewBusPassengerBmonth.setText("");
				textFieldNewBusPassengerBday.setText("");
				textFieldNewBusPassengerByear.setText("");
			}
		});

		lblClearButtonPassengerInNewTourReservation.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This clears Passengers passengerPhoneInNewTourReservation,
			 * passengerNameInNewReservation,
			 * passengerAddressInNewTourReservation,
			 * passengerEmailInNewTourReservation,
			 * passengerMonthInNewTourReservation,
			 * passengerDayInNewTourReservation,
			 * passengerYearInNewTourReservation fields in NewTourReservation
			 */
			public void mouseReleased(MouseEvent e) {
				passengerPhoneInNewTourReservation.setText("");
				passengerNameInNewReservation.setText("");
				passengerAddressInNewTourReservation.setText("");
				passengerEmailInNewTourReservation.setText("");
				passengerMonthInNewTourReservation.setText("");
				passengerDayInNewTourReservation.setText("");
				passengerYearInNewTourReservation.setText("");
			}
		});

		lblSearchForPassengerInNewTourReservationButton.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This searches for passenger by phone number in passengersArchive
			 * in NewTourReservation. If the passenger was found,
			 * passengerNameInNewReservation,
			 * passengerAddressInNewTourReservation,
			 * passengerEmailInNewTourReservation,
			 * passengerMonthInNewTourReservation,
			 * passengerDayInNewTourReservation,
			 * passengerYearInNewTourReservation fields are filled with
			 * information from this Passenger. If the passenger wasn't found,
			 * the notification pops up with the message: "The passenger with
			 * entered phone number could not be found"
			 */
			public void mouseReleased(MouseEvent e) {
				String phoneNumber = passengerPhoneInNewTourReservation.getText();
				for (int i = 0; i < passengersArchive.size(); i++) {
					if (passengersArchive.getPassengersArchive().get(i).getPhonenumber().equals(phoneNumber)) {
						updateListPassengersInNewTourReservation(passengersArchive.getPassengersArchive().get(i));
						DefaultListModel<String> listModel = (DefaultListModel<String>) lblSelectedPassengers
								.getModel();
						listModel.addElement(passengersArchive.getPassengersArchive().get(i).getName() + " "
								+ passengersArchive.getPassengersArchive().get(i).getPhonenumber());
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "The passenger with entered phone number could not be found");
			}
		});

		// LISTENER FOR CREATING NEW PASSENGER IN "NEW TOUR RESERVATION"
		lblAddNewPassengerInNewTourReservation.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This adds Passenger in NewTourReservation to
			 * tablePassengersInNewTourReservation table according to
			 * passengerPhoneInNewTourReservation,
			 * passengerNameInNewReservation,
			 * passengerAddressInNewTourReservation,
			 * passengerEmailInNewTourReservation,
			 * passengerMonthInNewTourReservation,
			 * passengerDayInNewTourReservation,
			 * passengerYearInNewTourReservation fields. This passenger was
			 * added to passengersArchive and passengersArchive was saved. These
			 * field are checked and if some of the fields are incorrect, the
			 * notification pops up and says what fields are incorrect
			 */
			public void mouseReleased(MouseEvent e) {
				String str = "";
				int month = 0;
				int day = 0;
				int year = 0;
				Calendar timeNow = Calendar.getInstance();
				int currentYear = timeNow.get(Calendar.YEAR);
				try {
					int phone = Integer.parseInt(passengerPhoneInNewTourReservation.getText());
					if (!(10000000 < phone && phone <= 99999999)) {
						str += "\nPhone number does not have 8 digits!";
					}
				} catch (Exception e3) {
					str += "\nEntered phone number does not appear to be digits!";
				}
				if (passengerNameInNewReservation.getText().equalsIgnoreCase("")) {
					str += "\nName cannot be empty!";
				}
				if (passengerAddressInNewTourReservation.getText().equalsIgnoreCase("")) {
					str += "\nAddress cannot be empty!";
				}

				if (!(passengerEmailInNewTourReservation.getText().contains("@")
						&& passengerEmailInNewTourReservation.getText().contains("."))) {
					str += "\nEmail appears to be either empty or incorrect format!";
				}

				try {
					month = Integer.parseInt(passengerMonthInNewTourReservation.getText());
					if (month > 12 || month < 1)
						str = str + "\nMonth does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nMonth does not seem to be a number between 1-12!";
				}
				try {
					day = Integer.parseInt(passengerDayInNewTourReservation.getText());
					if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
							|| month == 12) {
						if (!(1 <= day && day <= 31)) {
							str = str + "\nDay does not seem to be a number between 1-31!";
						}
					} else if (month == 2) {
						if (!(1 <= day && day <= 28)) {
							str = str + "\nDay does not seem to be a number between 1-28!";
						}
					} else if (month == 4 || month == 6 || month == 9 || month == 11) {
						if (!(1 <= day && day <= 30)) {
							str = str + "\nDay does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nDay does not seem to be a number between 1-31!";
				}
				try {
					year = Integer.parseInt(passengerYearInNewTourReservation.getText());
					if (year > currentYear || year < currentYear - 120)
						str = str + "\nYear does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nYear does not appear to be a valid number!";
				}

				if (str.equalsIgnoreCase("")) {
					passengersArchive.addPassenger(new Passenger(passengerNameInNewReservation.getText(),
							passengerEmailInNewTourReservation.getText(),
							passengerAddressInNewTourReservation.getText(), new Date(month, day, year),
							passengerPhoneInNewTourReservation.getText()));
					updateListPassengersInNewTourReservation(passengersArchive.getPassengersArchive()
							.get(passengersArchive.getPassengersArchive().size() - 1));
					updateListPassengers(passengersArchive.getPassengersArchive()
							.get(passengersArchive.getPassengersArchive().size() - 1));
					DefaultListModel<String> listModel = (DefaultListModel<String>) lblSelectedPassengers.getModel();
					listModel.addElement(
							passengersArchive.getPassengersArchive().get(passengersArchive.size() - 1).getName() + " "
									+ passengersArchive.getPassengersArchive().get(passengersArchive.size() - 1)
											.getPhonenumber());

					try {
						passengersArchive.savePassengersArchive();
					} catch (Exception ex) {

						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You have to fill out the fields correct:\n" + str);
				}
			}
		});

		lblNewBusAddPassengerBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This adds new Passenger in tableNewBusPassengers table in New Bus
			 * & Chauffeur Reservation according to
			 * textFieldNewBusPassengerPhone, textFieldNewBusPassengerName,
			 * textFieldNewBusPassengerAddress, textFieldNewBusPassengerEmail,
			 * textFieldNewBusPassengerBmonth, textFieldNewBusPassengerBday,
			 * textFieldNewBusPassengerByear fields. The fields are checked and
			 * if some fields are incorrect, the notification pops up and shows
			 * which fields are incorrect
			 */
			public void mouseReleased(MouseEvent e) {
				String str = "";
				int month = 0;
				int day = 0;
				int year = 0;
				Calendar timeNow = Calendar.getInstance();
				int currentYear = timeNow.get(Calendar.YEAR);
				try {
					int phone = Integer.parseInt(textFieldNewBusPassengerPhone.getText());
					if (!(10000000 < phone && phone <= 99999999)) {
						str += "\nPhone number does not have 8 digits!";
					}
				} catch (Exception e3) {
					str += "\nEntered phone number does not appear to be digits!";
				}
				if (textFieldNewBusPassengerName.getText().equalsIgnoreCase("")) {
					str += "\nName cannot be empty!";
				}
				if (textFieldNewBusPassengerAddress.getText().equalsIgnoreCase("")) {
					str += "\nAddress cannot be empty!";
				}

				if (!(textFieldNewBusPassengerEmail.getText().contains("@")
						&& textFieldNewBusPassengerEmail.getText().contains("."))) {
					str += "\nEmail appears to be either empty or incorrect format!";
				}

				try {
					month = Integer.parseInt(textFieldNewBusPassengerBmonth.getText());
					if (month > 12 || month < 1)
						str = str + "\nMonth does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nMonth does not seem to be a number between 1-12!";
				}
				try {
					day = Integer.parseInt(textFieldNewBusPassengerBday.getText());
					if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
							|| month == 12) {
						if (!(1 <= day && day <= 31)) {
							str = str + "\nDay does not seem to be a number between 1-31!";
						}
					} else if (month == 2) {
						if (!(1 <= day && day <= 28)) {
							str = str + "\nDay does not seem to be a number between 1-28!";
						}
					} else if (month == 4 || month == 6 || month == 9 || month == 11) {
						if (!(1 <= day && day <= 30)) {
							str = str + "\nDay does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nDay does not seem to be a number between 1-31!";
				}
				try {
					year = Integer.parseInt(textFieldNewBusPassengerByear.getText());
					if (year > currentYear || year < currentYear - 120)
						str = str + "\nYear does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nYear does not appear to be a valid number!";
				}

				if (str.equalsIgnoreCase("")) {
					passengersArchive.addPassenger(new Passenger(textFieldNewBusPassengerName.getText(),
							textFieldNewBusPassengerEmail.getText(), textFieldNewBusPassengerAddress.getText(),
							new Date(month, day, year), textFieldNewBusPassengerPhone.getText()));
					updatePassengerListNewBus(passengersArchive.getPassengersArchive()
							.get(passengersArchive.getPassengersArchive().size() - 1));
					updateListPassengers(passengersArchive.getPassengersArchive()
							.get(passengersArchive.getPassengersArchive().size() - 1));
					try {
						passengersArchive.savePassengersArchive();
					} catch (Exception ex) {

						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You have to fill out the fields correct:\n" + str);
				}
			}
		});

		lblNewBusSearchPassengerBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This searches for Passenger in passengersArchive by phone number
			 * in textFieldNewBusPassengerPhone Text Field. If
			 * textFieldNewBusPassengerPhone Text Field is empty and the Button
			 * was pressed, the notification pops up with the information: "You
			 * need to fill in the phone number first!". If
			 * textFieldNewBusPassengerPhone Text Field has more or less than 8
			 * digits, the notifications pops ups with the message: "Phone
			 * number does not have 8 digits!". If textFieldNewBusPassengerPhone
			 * Text Field phonenumber wasn't found in passengersArchive, the
			 * notification pops up with the message: "No passenger match
			 * found!\nPlease fill in new passenger." If
			 * textFieldNewBusPassengerPhone Text Field doesn't have digits, the
			 * notification pops up with the information: "Entered phone number
			 * does not appear to be digits!". If textFieldNewBusPassengerPhone
			 * Text Field phonenumber is found in passengersArchive,
			 * textFieldNewBusPassengerPhone, textFieldNewBusPassengerName,
			 * textFieldNewBusPassengerAddress, textFieldNewBusPassengerEmail,
			 * textFieldNewBusPassengerBmonth, textFieldNewBusPassengerBday,
			 * textFieldNewBusPassengerByear fields are filled with the
			 * information from this Passenger
			 */
			public void mouseReleased(MouseEvent e) {
				if (textFieldNewBusPassengerPhone.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "You need to fill in the phone number first!");
				} else {
					try {
						int phone = Integer.parseInt(textFieldNewBusPassengerPhone.getText());
						if (!(10000000 < phone && phone <= 99999999)) {
							JOptionPane.showMessageDialog(null, "Phonenumber does not have 8 digits!");
						} else {
							for (int i = 0; i < passengersArchive.size(); i++) {
								if (passengersArchive.get(i).getPhonenumber()
										.equalsIgnoreCase(textFieldNewBusPassengerPhone.getText())) {
									updatePassengerListNewBus(passengersArchive.get(i));
									break;
								}
								if (i == passengersArchive.size() - 1 || passengersArchive.size() == 0) {
									JOptionPane.showMessageDialog(null,
											"No passenger match found!\nPlease fill in new passenger.");
								}
							}
						}
					} catch (Exception e4) {
						JOptionPane.showMessageDialog(null, "Entered phonenumber does not appear to be digits!");
					}
				}
			}
		});

		lblNewBusNextBtn.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This checks if textFieldNewBusCustomerPhone,
			 * textFieldNewBusOrganisationName, rdbtnNewBusCompany,
			 * rdbtnNewBusSchool, rdbtnNewBusPrivate,
			 * textFieldNewBusCustomerName, textFieldNewBusCustomerAddress,
			 * textFieldNewBusCustomerEmail, textFieldNewBusCustomerBmonth,
			 * textFieldNewBusCustomerBday, textFieldNewBusCustomerByear,
			 * chckbxNewBusIsPassenger, tableNewBusPassengers fields, checks if
			 * they are filled correctly, hides all panels and shows
			 * panelTouReservationNext. If some fields are filled incorrectly,
			 * the notification pops up and says what fields are incorrect
			 */
			public void mouseReleased(MouseEvent e) {
				String str = new String();
				int month = 0;
				int day = 0;
				int year = 0;
				Calendar timeNow = Calendar.getInstance();
				int currentYear = timeNow.get(Calendar.YEAR);
				try {
					int phone = Integer.parseInt(textFieldNewBusCustomerPhone.getText());
					if (!(10000000 < phone && phone <= 99999999)) {
						str += "\nCustomer phone number does not have 8 digits!";
					}
				} catch (Exception e3) {
					str += "\nEntered customer phone number does not appear to be digits!";
				}
				if (textFieldNewBusOrganisationName.getText().equalsIgnoreCase("")) {
					str += "\nCustomer name/organisation cannot be empty!";
				}
				if (textFieldNewBusCustomerName.getText().equalsIgnoreCase("")) {
					str += "\nCustomer name/contact cannot be empty!";
				}
				if (textFieldNewBusCustomerAddress.getText().equalsIgnoreCase("")) {
					str += "\nCustomer address cannot be empty!";
				}
				if (textFieldNewBusCustomerEmail.getText().equalsIgnoreCase("")) {
					str += "\nCustomer email address cannot be empty!";
				}
				if (!(textFieldNewBusCustomerEmail.getText().contains("@")
						&& textFieldNewBusCustomerEmail.getText().contains("."))) {
					str += "\nCustomer email address does not appear to be in correct format!";
				}

				try {
					month = Integer.parseInt(textFieldNewBusCustomerBmonth.getText());
					if (month > 12 || month < 1)
						str = str + "\nCustomer birth month does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nCustomer birth month does not seem to be a number between 1-12!";
				}
				try {
					day = Integer.parseInt(textFieldNewBusCustomerBday.getText());
					if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
							|| month == 12) {
						if (!(1 <= day && day <= 31)) {
							str = str + "\nCustomer birth day does not seem to be a number between 1-31!";
						}
					} else if (month == 2) {
						if (!(1 <= day && day <= 28)) {
							str = str + "\nCustomer birth day does not seem to be a number between 1-28!";
						}
					} else if (month == 4 || month == 6 || month == 9 || month == 11) {
						if (!(1 <= day && day <= 30)) {
							str = str + "\nCustomer birth day does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nCustomer birth day does not seem to be a number between 1-31!";
				}
				try {
					year = Integer.parseInt(textFieldNewBusCustomerByear.getText());
					if (year > currentYear - 15)
						str = str + "\nCustomer birth year: Must be at least 15!";
					if (year < currentYear - 120)
						str = str + "\nCustomer birth year: Cannot be over 120 years old!";
				} catch (NumberFormatException e1) {
					str = str + "\nCustomer birth year does not appear to be a valid number!";
				}

				if (tableNewBusPassengers.getRowCount() == 0) {
					str += "\nYou did not add any passengers to the list!";
				}

				if (str.equalsIgnoreCase("")) {
					hideAllPanels();
					panelNewBusReservationNext.setVisible(true);
					try {
						reservationNumber = reservationNumberGenerator.getReservationNumber();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					updateSummaryNewBus();
				} else {
					JOptionPane.showMessageDialog(null, "You have to fill out the fields correct:\n" + str);
				}
			}
		});

		lblCancel.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This clears reservationNumberGenerator,
			 * textFieldNewBusCustomerAddress, textFieldNewBusCustomerBday,
			 * textFieldNewBusCustomerBmonth, textFieldNewBusCustomerByear,
			 * textFieldNewBusCustomerEmail, textFieldNewBusCustomerName,
			 * textFieldNewBusCustomerPhone, textFieldNewBusPassengerAddress,
			 * textFieldNewBusPassengerBday, textFieldNewBusPassengerBmonth,
			 * textFieldNewBusPassengerByear, textFieldNewBusPassengerEmail,
			 * textFieldNewBusPassengerName, textFieldNewBusPassengerPhone,
			 * newBusPassengersTable, chckbxNewBusIsPassenger,
			 * rdbtnNewBusCompany, rdbtnNewBusPrivate, rdbtnNewBusSchool,
			 * textFieldNewBusOrganisationName, textFieldNewBusEndDay,
			 * textFieldNewBusEndMonth, textFieldNewBusEndYear,
			 * textFieldNewBusStartDay, textFieldNewBusStartMonth,
			 * textFieldNewBusStartYear fields,hides all panels and shows
			 * panelNewBusReservation
			 */
			public void mouseReleased(MouseEvent e) {
				try {
					reservationNumberGenerator.cancelReservationNumber();
					textFieldNewBusCustomerAddress.setText("");
					textFieldNewBusCustomerBday.setText("");
					textFieldNewBusCustomerBmonth.setText("");
					textFieldNewBusCustomerByear.setText("");
					textFieldNewBusCustomerEmail.setText("");
					textFieldNewBusCustomerName.setText("");
					textFieldNewBusCustomerPhone.setText("");
					textFieldNewBusPassengerAddress.setText("");
					textFieldNewBusPassengerBday.setText("");
					textFieldNewBusPassengerBmonth.setText("");
					textFieldNewBusPassengerByear.setText("");
					textFieldNewBusPassengerEmail.setText("");
					textFieldNewBusPassengerName.setText("");
					textFieldNewBusPassengerPhone.setText("");
					newBusPassengersTable.setRowCount(0);
					chckbxNewBusIsPassenger.setSelected(false);
					rdbtnNewBusCompany.setSelected(false);
					rdbtnNewBusPrivate.setSelected(false);
					rdbtnNewBusSchool.setSelected(false);
					textFieldNewBusOrganisationName.setText("");
					textFieldNewBusEndDay.setText("");
					textFieldNewBusEndMonth.setText("");
					textFieldNewBusEndYear.setText("");
					textFieldNewBusStartDay.setText("");
					textFieldNewBusStartMonth.setText("");
					textFieldNewBusStartYear.setText("");
					hideAllPanels();
					panelNewBusReservation.setVisible(true);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});

		chckbxBreakfastNewBus.addActionListener(new ActionListener() {
			/**
			 * If the breakfast is selected, chckbxAllInclusiveNewBus is
			 * unchecked and the textPaneSummaryNewBus in
			 * panelNewBusReservationNext
			 */
			public void actionPerformed(ActionEvent e) {
				chckbxAllInclusiveNewBus.setSelected(false);
				updateSummaryNewBus();
			}
		});

		chckbxLunchNewBus.addActionListener(new ActionListener() {
			/**
			 * If the lunch is selected, chckbxAllInclusiveNewBus is unchecked
			 * and the textPaneSummaryNewBus in panelNewBusReservationNext
			 */
			public void actionPerformed(ActionEvent e) {
				chckbxAllInclusiveNewBus.setSelected(false);
				updateSummaryNewBus();
			}
		});

		chckbxAllInclusiveNewBus.addActionListener(new ActionListener() {
			/**
			 * If the allInclusive is selected, chckbxLunchNewBus and
			 * chckbxBreakfastNewBus are unchecked and the textPaneSummaryNewBus
			 * in panelNewBusReservationNext
			 */
			public void actionPerformed(ActionEvent e) {
				chckbxBreakfastNewBus.setSelected(false);
				chckbxLunchNewBus.setSelected(false);
				updateSummaryNewBus();
			}
		});

		/**
		 * This updates the information in textPaneSummaryNewBus in
		 * panelNewBusReservationNext
		 */
		chckbxEntranceTicketsNewBus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSummaryNewBus();
			}
		});

		/**
		 * This updates the information in textPaneSummaryNewBus in
		 * panelNewBusReservationNext
		 */
		lblSelectBusNewBusResButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				updateSummaryNewBus();
			}
		});

		// LISTENER FOR ADDING NEW CUSTOMER IN NEW TOUR RESERVATION
		/**
		 * This adds new Customer in customersTableInNewTourReservation in
		 * nnewTourReservation and adds to customersArchive and update
		 * customersArchive according to lblPhoneInNewTourReservationtextField,
		 * customerOrganisationtextField,
		 * radioButtonIsCompanyNewTourReservation,
		 * radioButtonIsSchoolNewTourReservation,
		 * radioButtonIsPrivateInNewTourReservation,
		 * customerNameNewTourReservationTextField,
		 * customerAddressIncustomerEmailNewTourReservationTextField,
		 * customerEmailNewTourReservationtextField,
		 * customerMonthInNewTourReservationTextField,
		 * customerDayInNewTourReservationTextField,
		 * customerYearInNewTourReservationTextField fields. The fields are
		 * checked and if some of the fields are wrong, the notification pops up
		 * and says which fields arr wrong
		 */
		lblAddCusomerButtonNewTourReservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				String str = new String();
				int month = 0;
				int day = 0;
				int year = 0;
				Calendar timeNow = Calendar.getInstance();
				int currentYear = timeNow.get(Calendar.YEAR);
				try {
					int phone = Integer.parseInt(lblPhoneInNewTourReservationtextField.getText());
					if (!(10000000 < phone && phone <= 99999999)) {
						str += "\nPhone number does not have 8 digits!";
					}
				} catch (Exception e3) {
					str += "\nEntered phone number does not appear to be digits!";
				}
				if (customerOrganisationtextField.getText().equalsIgnoreCase("")) {
					str += "\nName/organisation cannot be empty!";
				}
				if (customerNameNewTourReservationTextField.getText().equalsIgnoreCase("")) {
					str += "\nName/contact cannot be empty!";
				}
				if (customerAddressIncustomerEmailNewTourReservationTextField.getText().equalsIgnoreCase("")) {
					str += "\nAddress cannot be empty!";
				}
				if (customerEmailNewTourReservationtextField.getText().equalsIgnoreCase("")) {
					str += "\nEmail address cannot be empty!";
				}
				if (!(customerEmailNewTourReservationtextField.getText().contains("@")
						&& customerEmailNewTourReservationtextField.getText().contains("."))) {
					str += "\nEmail address does not appear to be in correct format!";
				}

				try {
					month = Integer.parseInt(customerMonthInNewTourReservationTextField.getText());
					if (month > 12 || month < 1)
						str = str + "\nMonth does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nMonth does not seem to be a number between 1-12!";
				}
				try {
					day = Integer.parseInt(customerDayInNewTourReservationTextField.getText());
					if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
							|| month == 12) {
						if (!(1 <= day && day <= 31)) {
							str = str + "\nDay does not seem to be a number between 1-31!";
						}
					} else if (month == 2) {
						if (!(1 <= day && day <= 28)) {
							str = str + "\nDay does not seem to be a number between 1-28!";
						}
					} else if (month == 4 || month == 6 || month == 9 || month == 11) {
						if (!(1 <= day && day <= 30)) {
							str = str + "\nDay does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nDay does not seem to be a number between 1-31!";
				}
				try {
					year = Integer.parseInt(customerYearInNewTourReservationTextField.getText());
					if (year > currentYear || year < currentYear - 120)
						str = str + "\nYear does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nYear does not appear to be a valid number!";
				}

				if (str.equalsIgnoreCase("")) {
					Date birthday = null;
					String organisationType = "PRIVATE";
					if (radioButtonIsCompanyNewTourReservation.isSelected()) {
						organisationType = "COMPANY";
					}
					if (radioButtonIsSchoolNewTourReservation.isSelected()) {
						organisationType = "SCHOOL";
					}
					if (customerMonthInNewTourReservationTextField.getText().equalsIgnoreCase("")
							|| customerDayInNewTourReservationTextField.getText().equalsIgnoreCase("")
							|| customerYearInNewTourReservationTextField.getText().equalsIgnoreCase("")) {
						birthday = new Date(0, 0, 0);
					} else {
						int bMonth = 0;
						int bDay = 0;
						int bYear = 0;
						bMonth = Integer.parseInt(customerMonthInNewTourReservationTextField.getText());
						bDay = Integer.parseInt(customerDayInNewTourReservationTextField.getText());
						bYear = Integer.parseInt(customerYearInNewTourReservationTextField.getText());
						birthday = new Date(bMonth, bDay, bYear);
					}
					customersArchive.addCustomer(new Customer(customerNameNewTourReservationTextField.getText(),
							customerOrganisationtextField.getText(), customerEmailNewTourReservationtextField.getText(),
							customerAddressIncustomerEmailNewTourReservationTextField.getText(), birthday,
							lblPhoneInNewTourReservationtextField.getText(), organisationType));
					if (boxIsAPassengerNewTourReservation.isSelected()) {
						passengersArchive.addPassenger(new Passenger(customerNameNewTourReservationTextField.getText(),
								customerEmailNewTourReservationtextField.getText(),
								customerAddressIncustomerEmailNewTourReservationTextField.getText(), birthday,
								lblPhoneInNewTourReservationtextField.getText()));
						try {
							passengersArchive.savePassengersArchive();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					updateListCustomers(customersArchive.getListOfCustomers()
							.get(customersArchive.getListOfCustomers().size() - 1));
					updateListPassengers(passengersArchive.get(passengersArchive.size() - 1));
					try {
						customersArchive.saveCustomersArchive();
					} catch (Exception e) {

						e.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "You have to fill out the fields correct:\n" + str);
				}

			}
		});

		lblOkNewBusResevation.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * This methods adds new Bus & Chauffeur Reservation to the
			 * reservationArchive and updates reservationArchives according to
			 * chckbxBreakfastNewBus, chckbxLunchNewBus,
			 * chckbxAllInclusiveNewBus, chckbxEntranceTicketsNewBus,
			 * tableNewBusSelectBus, tableNewBusSelectChauffeur fields. The
			 * fields are checked. If some of the fields are wrong ,the
			 * notification pops up and says which fields are incorrect
			 */
			public void mouseReleased(MouseEvent arg0) {
				String str = new String();
				int monthStart = 0;
				int dayStart = 0;
				int yearStart = 0;
				int monthEnd = 0;
				int dayEnd = 0;
				int yearEnd = 0;

				int numberOfPassengers = tableNewBusPassengers.getRowCount();
				double pricePerDay = 0;
				double totalPrice = 0;
				Services services = null;
				java.util.Date javastartDate;
				java.util.Date javaendDate;

				int hourStart = 0;
				int hourEnd = 0;
				int minuteStart = 0;
				int minuteEnd = 0;

				Calendar timeNow = Calendar.getInstance();
				int currentYear = timeNow.get(Calendar.YEAR);
				try {
					monthStart = Integer.parseInt(textFieldNewBusStartMonth.getText());
					if (monthStart > 12 || monthStart < 1)
						str = str + "\nStart month does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart month does not seem to be a number between 1-12!";
				}
				try {
					dayStart = Integer.parseInt(textFieldNewBusStartDay.getText());
					if (monthStart == 1 || monthStart == 3 || monthStart == 5 || monthStart == 7 || monthStart == 8
							|| monthStart == 10 || monthStart == 12) {
						if (!(1 <= dayStart && dayStart <= 31)) {
							str = str + "\nStart day does not seem to be a number between 1-31!";
						}
					} else if (monthStart == 2) {
						if (!(1 <= dayStart && dayStart <= 28)) {
							str = str + "\nStart day does not seem to be a number between 1-28!";
						}
					} else if (monthStart == 4 || monthStart == 6 || monthStart == 9 || monthStart == 11) {
						if (!(1 <= dayStart && dayStart <= 30)) {
							str = str + "\nStart day does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nStart day does not seem to be a number between 1-31!";
				}
				try {
					yearStart = Integer.parseInt(textFieldNewBusStartYear.getText());
					if (yearStart < currentYear)
						str = str + "\nStart year does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart year does not appear to be a valid number!";
				}
				try {
					monthEnd = Integer.parseInt(textFieldNewBusEndMonth.getText());
					if (monthEnd > 12 || monthEnd < 1)
						str = str + "\nEnd month does not seem to be a number between 1-12!";
				} catch (NumberFormatException e1) {
					str = str + "\nEndt month does not seem to be a number between 1-12!";
				}
				try {
					dayEnd = Integer.parseInt(textFieldNewBusEndDay.getText());
					if (monthEnd == 1 || monthEnd == 3 || monthEnd == 5 || monthEnd == 7 || monthEnd == 8
							|| monthEnd == 10 || monthEnd == 12) {
						if (!(1 <= dayEnd && dayEnd <= 31)) {
							str = str + "\nEnd day does not seem to be a number between 1-31!";
						}
					} else if (monthEnd == 2) {
						if (!(1 <= dayEnd && dayEnd <= 28)) {
							str = str + "\nEnd day does not seem to be a number between 1-28!";
						}
					} else if (monthEnd == 4 || monthEnd == 6 || monthEnd == 9 || monthEnd == 11) {
						if (!(1 <= dayEnd && dayEnd <= 30)) {
							str = str + "\nEnd day does not seem to be a number between 1-30!";
						}
					}
				} catch (NumberFormatException e1) {
					str = str + "\nEnd day does not seem to be a number between 1-31!";
				}
				try {
					yearEnd = Integer.parseInt(textFieldNewBusEndYear.getText());
					if (yearEnd < currentYear)
						str = str + "\nEnd year does not appear to be a valid number!";
				} catch (NumberFormatException e1) {
					str = str + "\nEnd year does not appear to be a valid number!";
				}
				try {
					hourStart = Integer.parseInt(startHourInNewBusRes.getText());
					if (hourStart < 0 && hourStart > 23)
						str = str + "\nStart hour does not appear to be a number between 0-23!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart hour does not appear to be a valid number!";
				}
				try {
					hourEnd = Integer.parseInt(endtHourInNewBusRes.getText());
					if (hourEnd < 0 && hourEnd > 23)
						str = str + "\nEnd hour does not appear to be a number between 0-23!";
				} catch (NumberFormatException e1) {
					str = str + "\nEnd hour does not appear to be a valid number!";
				}
				try {
					minuteStart = Integer.parseInt(startMinuteInNewBusRes.getText());
					if (minuteStart < 0 && minuteStart > 59)
						str = str + "\nStart minute does not appear to be a number between 0-59!";
				} catch (NumberFormatException e1) {
					str = str + "\nStart minute does not appear to be a valid number!";
				}
				try {
					minuteEnd = Integer.parseInt(endMinuteInNewBusRes.getText());
					if (minuteEnd < 0 && minuteEnd > 59)
						str = str + "\nEnd minute does not appear to be a number between 0-59!";
				} catch (NumberFormatException e1) {
					str = str + "\nEnd minute does not appear to be a valid number!";
				}

				try {
					services = new Services();
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				int daysCount = 0;
				double discount = 0;
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date startDate = null, endDate = null, currentDate = new java.util.Date();
				DateInterval dateInterval = new DateInterval();
				String busSelected = new String("");
				Chauffeur chauffeur = null;
				Bus bus = null;
				if (chckbxAllInclusiveNewBus.isSelected()) {
					services.setAllInclusive(true);
					pricePerDay += numberOfPassengers * priceList.getPriceAllInclusive();
				}
				if (chckbxBreakfastNewBus.isSelected()) {
					services.setBreakfastIncluded(true);
					pricePerDay += numberOfPassengers * priceList.getPriceBreakfast();
				}
				if (chckbxLunchNewBus.isSelected()) {
					services.setLunchIncluded(true);
					pricePerDay += numberOfPassengers * priceList.getPriceLunch();
				}
				if (chckbxEntranceTicketsNewBus.isSelected()) {
					services.setEntranceTickets(true);
					totalPrice += numberOfPassengers * priceList.getPriceEntranceTickets();
				}
				if (!(textFieldNewBusStartDay.getText().equalsIgnoreCase("")
						|| textFieldNewBusStartMonth.getText().equalsIgnoreCase("")
						|| textFieldNewBusStartYear.getText().equalsIgnoreCase("")
						|| textFieldNewBusEndDay.getText().equalsIgnoreCase("")
						|| textFieldNewBusEndMonth.getText().equalsIgnoreCase("")
						|| textFieldNewBusEndYear.getText().equalsIgnoreCase(""))) {
					try {
						monthStart = Integer.parseInt(textFieldNewBusStartMonth.getText());
						dayStart = Integer.parseInt(textFieldNewBusStartDay.getText());
						yearStart = Integer.parseInt(textFieldNewBusStartYear.getText());
						monthEnd = Integer.parseInt(textFieldNewBusEndMonth.getText());
						dayEnd = Integer.parseInt(textFieldNewBusEndDay.getText());
						yearEnd = Integer.parseInt(textFieldNewBusEndYear.getText());
						dateInterval = new DateInterval(new Date(monthStart, dayStart, yearStart),
								new Date(monthEnd, dayEnd, yearEnd));
						startDate = dateformat.parse(dayStart + "/" + monthStart + "/" + yearStart);
						endDate = dateformat.parse(dayEnd + "/" + monthEnd + "/" + yearEnd);
						if (currentDate.equals(startDate) && startDate.before(endDate)
								|| currentDate.before(startDate) && startDate.before(endDate)) {
							daysCount = daysBetweenDates(startDate, endDate);
						} else {
							str += "\nDates must be future dates, and start date must be before end date!";
						}

					} catch (Exception e) {
						str += "\nPlease check if start and end dates are correct!";
					}
				}
				if (!(tableNewBusSelectBus.getSelectedRow() == -1)) {
					busSelected = (String) newBusSelectBusTable.getValueAt(tableNewBusSelectBus.getSelectedRow(), 0);
					pricePerDay += busesArchive.getBusById(busSelected).getPricePerHour() * 8;// price/hour
																								// *
																								// 8
																								// working
																								// hours
																								// per
																								// day
																								// =
																								// price/day
					bus = busesArchive.getBusById(busSelected);

				} else {
					str += "\nNo bus is selected!";
				}
				if (!(tableNewBusSelectChauffeur.getSelectedRow() == -1)) {
					String chauffeurSelected = (String) newBusSelectChauffeurTable
							.getValueAt(tableNewBusSelectChauffeur.getSelectedRow(), 0);
					chauffeur = chauffeursArchive.getChauffeurById(chauffeurSelected);
				} else {
					str += "\nNo chauffeur is selected!";
				}
				for (int i = 0; i < customersArchive.size(); i++) {
					if (textFieldNewBusCustomerPhone.getText()
							.equalsIgnoreCase(customersArchive.get(i).getPhonenumber())) {
						discount = customersArchive.get(i).getDiscount();
					}
				}
				totalPrice += pricePerDay * daysCount;
				totalPrice = totalPrice - (totalPrice * discount);
				totalPrice = round(totalPrice, 2);

				if (str.equalsIgnoreCase("")) {
					javastartDate = parseDate(
							yearStart + "-" + monthStart + "-" + dayStart + "-" + hourStart + "-" + minuteStart);
					javaendDate = parseDate(yearEnd + "-" + monthEnd + "-" + dayEnd + "-" + hourEnd + "-" + minuteEnd);
					int customerIndex = -1;
					bus.addNewReservationPeriod(new java.util.Date[] { javastartDate, javaendDate });
					try {
						busesArchive.saveBusesArchive();
					} catch (Exception e) {
						e.printStackTrace();
					}
					chauffeur.addNewReservationPeriod(new java.util.Date[] { javastartDate, javaendDate });
					try {
						chauffeursArchive.saveChauffeursArchive();
					} catch (Exception e) {
						e.printStackTrace();
					}
					for (int i = 0; i < customersArchive.size(); i++) {
						if (textFieldNewBusCustomerPhone.getText()
								.equalsIgnoreCase(customersArchive.get(i).getPhonenumber())) {
							customerIndex = i;
						}
					}
					if (customerIndex == -1) {
						Date birthday = null;
						String organisationType = "PRIVATE";
						if (rdbtnNewBusCompany.isSelected()) {
							organisationType = "COMPANY";
						}
						if (rdbtnNewBusSchool.isSelected()) {
							organisationType = "SCHOOL";
						}
						if (textFieldNewBusCustomerBmonth.getText().equalsIgnoreCase("")
								|| textFieldNewBusCustomerBday.getText().equalsIgnoreCase("")
								|| textFieldNewBusCustomerByear.getText().equalsIgnoreCase("")) {
							birthday = new Date(0, 0, 0);
						} else {
							int bMonth = 0;
							int bDay = 0;
							int bYear = 0;
							bMonth = Integer.parseInt(textFieldNewBusCustomerBmonth.getText());
							bDay = Integer.parseInt(textFieldNewBusCustomerBday.getText());
							bYear = Integer.parseInt(textFieldNewBusCustomerByear.getText());
							birthday = new Date(bMonth, bDay, bYear);
						}

						Customer customer = new Customer(textFieldNewBusCustomerName.getText(),
								textFieldNewBusOrganisationName.getText(), textFieldNewBusCustomerEmail.getText(),
								textFieldNewBusCustomerAddress.getText(), birthday,
								textFieldNewBusCustomerPhone.getText(), organisationType);
						customersArchive.addCustomer(customer);
						try {
							customersArchive.saveCustomersArchive();
						} catch (Exception e) {

							e.printStackTrace();
						}
						customerIndex = customersArchive.size() - 1;
					}
					customersArchive.get(customerIndex)
							.setMoneySpent(customersArchive.get(customerIndex).getMoneySpent() + totalPrice);
					reservationsArchive.addReservation(new BusReservation(reservationNumber, discount,
							customersArchive.get(customerIndex), chauffeur, bus, services, dateInterval, totalPrice));
					BusReservation lastBusReservation = (BusReservation) reservationsArchive
							.get(reservationsArchive.size() - 1);
					lastBusReservation.setNewDateInterval(new java.util.Date[] { javastartDate, javaendDate });
					lastBusReservation.setTotalPrice(totalPrice);
					ArrayList<Passenger> listOfSelectedPassengers = new ArrayList<>();
					int passengersTableRowCount = tableNewBusPassengers.getRowCount();
					for (int i = 0; i < passengersTableRowCount; i++) {
						String passengersPhoneNumber = (String) tableNewBusPassengers.getModel().getValueAt(i, 2);
						String passengersName = (String) tableNewBusPassengers.getModel().getValueAt(i, 0);

						for (int j = 0; j < passengersArchive.size(); j++) {
							if (passengersArchive.getPassengersArchive().get(j).getPhonenumber()
									.equals(passengersPhoneNumber)
									&& passengersArchive.getPassengersArchive().get(j).getName()
											.equals(passengersName)) {

								listOfSelectedPassengers.add(passengersArchive.getPassengersArchive().get(j));
								break;
							}
						}
					}
					lastBusReservation.setPassengers(listOfSelectedPassengers);
					try {
						reservationsArchive.saveReservationsArchive();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					try {
						Autobus.frame.deleteAllRows((DefaultTableModel) tableSelectBus.getModel());
						Autobus.frame.deleteAllRows((DefaultTableModel) tableSelectChauffeur.getModel());
						reservationsArchive.saveReservationsArchive();
						JOptionPane.showMessageDialog(null, "The reservation is now saved to the archive.");
						textFieldNewBusCustomerAddress.setText("");
						textFieldNewBusCustomerBday.setText("");
						textFieldNewBusCustomerBmonth.setText("");
						textFieldNewBusCustomerByear.setText("");
						textFieldNewBusCustomerEmail.setText("");
						textFieldNewBusCustomerName.setText("");
						textFieldNewBusCustomerPhone.setText("");
						textFieldNewBusPassengerAddress.setText("");
						textFieldNewBusPassengerBday.setText("");
						textFieldNewBusPassengerBmonth.setText("");
						textFieldNewBusPassengerByear.setText("");
						textFieldNewBusPassengerEmail.setText("");
						textFieldNewBusPassengerName.setText("");
						textFieldNewBusPassengerPhone.setText("");
						newBusPassengersTable.setRowCount(0);
						chckbxNewBusIsPassenger.setSelected(false);
						rdbtnNewBusCompany.setSelected(false);
						rdbtnNewBusPrivate.setSelected(false);
						rdbtnNewBusSchool.setSelected(false);
						textFieldNewBusOrganisationName.setText("");
						textFieldNewBusEndDay.setText("");
						textFieldNewBusEndMonth.setText("");
						textFieldNewBusEndYear.setText("");
						textFieldNewBusStartDay.setText("");
						textFieldNewBusStartMonth.setText("");
						textFieldNewBusStartYear.setText("");
						listBuses();
						listChauffeurs();
						listCustomers();
						listBusReservations();
						hideAllPanels();
						panelNewBusReservation.setVisible(true);
					} catch (Exception e) {

						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "You have to fill out the fields correct:\n" + str);
				}

			}
		});

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// These methods contains all code for adding from file to table and
	//////////////////////////////////////////////////////////////////////////////////////////////////////// updating
	//////////////////////////////////////////////////////////////////////////////////////////////////////// lists
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * This adds a new row to the newBusPassengersTable
	 * 
	 * @param newPassenger
	 *            - new passenger
	 */
	public void updatePassengerListNewBus(Passenger newPassenger) {
		newBusPassengersTable = (DefaultTableModel) tableNewBusPassengers.getModel();
		Object[] rowData = new Object[5];
		rowData[0] = newPassenger.getName();
		rowData[1] = newPassenger.getAddress();
		rowData[2] = newPassenger.getPhonenumber();
		rowData[3] = newPassenger.getEmail();
		rowData[4] = newPassenger.getBirthday();
		newBusPassengersTable.addRow(rowData);
	}

	/**
	 * This shows the information on textPaneSummaryNewBus in
	 * panelNewBusReservationsNext
	 */
	public void updateSummaryNewBus() {
		String str = new String();
		str += "Reservation#: " + reservationNumber;
		str += "\n\nCustomer: " + textFieldNewBusOrganisationName.getText() + "\n";
		if (!rdbtnNewBusPrivate.isSelected()) {
			str += "Contact name: " + textFieldNewBusCustomerName.getText() + "\n";
		}
		str += textFieldNewBusCustomerAddress.getText() + "\nPhone: " + textFieldNewBusCustomerPhone.getText() + "\n";
		str += "\nPassengers: " + tableNewBusPassengers.getRowCount();

		str += "\nRent date: ";
		if (!(textFieldNewBusStartDay.getText().equalsIgnoreCase("")
				&& textFieldNewBusStartMonth.getText().equalsIgnoreCase("")
				&& textFieldNewBusStartYear.getText().equalsIgnoreCase("")
				&& textFieldNewBusEndDay.getText().equalsIgnoreCase("")
				&& textFieldNewBusEndMonth.getText().equalsIgnoreCase("")
				&& textFieldNewBusEndYear.getText().equalsIgnoreCase(""))) {
			str += textFieldNewBusStartMonth.getText() + "/" + textFieldNewBusStartDay.getText() + "/"
					+ textFieldNewBusStartYear.getText() + " - " + textFieldNewBusEndMonth.getText() + "/"
					+ textFieldNewBusEndDay.getText() + "/" + textFieldNewBusEndYear.getText();
		}

		str += "\nServices: ";
		if (chckbxEntranceTicketsNewBus.isSelected()) {
			str += "Entrance tickets, ";
		}
		if (chckbxAllInclusiveNewBus.isSelected()) {
			str += "All inclusive";
		}
		if (chckbxBreakfastNewBus.isSelected()) {
			str += "Breakfast";
		}
		if (chckbxBreakfastNewBus.isSelected() && chckbxLunchNewBus.isSelected()) {
			str += ", Lunch";
		} else if (chckbxLunchNewBus.isSelected()) {
			str += "Lunch";
		}
		if (!(chckbxBreakfastNewBus.isSelected() || chckbxLunchNewBus.isSelected()
				|| chckbxAllInclusiveNewBus.isSelected() || chckbxEntranceTicketsNewBus.isSelected())) {
			str += "\nNo services selected";
		}
		if (tableNewBusSelectBus.getSelectedRow() != -1) {
			str += "\nBus selected:  #" + newBusSelectBusTable.getValueAt(tableNewBusSelectBus.getSelectedRow(), 0)
					+ "  Price/h: " + newBusSelectBusTable.getValueAt(tableNewBusSelectBus.getSelectedRow(), 1)
					+ "  Seats: " + newBusSelectBusTable.getValueAt(tableNewBusSelectBus.getSelectedRow(), 2)
					+ "  Type: " + newBusSelectBusTable.getValueAt(tableNewBusSelectBus.getSelectedRow(), 3);
		}
		if (tableNewBusSelectChauffeur.getSelectedRow() != -1) {
			str += "\nChauffeur selected: "
					+ newBusSelectChauffeurTable.getValueAt(tableNewBusSelectChauffeur.getSelectedRow(), 1);
		}
		if (!(textFieldNewBusStartDay.getText().equalsIgnoreCase("")
				|| textFieldNewBusStartMonth.getText().equalsIgnoreCase("")
				|| textFieldNewBusStartYear.getText().equalsIgnoreCase("")
				|| textFieldNewBusEndDay.getText().equalsIgnoreCase("")
				|| textFieldNewBusEndMonth.getText().equalsIgnoreCase("")
				|| textFieldNewBusEndYear.getText().equalsIgnoreCase("")
				|| tableNewBusSelectBus.getSelectedRow() == -1)) {
			String busSelected = (String) newBusSelectBusTable.getValueAt(tableNewBusSelectBus.getSelectedRow(), 0);
			double pricePerDay = 0;
			pricePerDay = busesArchive.getBusById(busSelected).getPricePerHour() * 8;// price/hour
																						// *
																						// 8
																						// working
																						// hours
																						// per
																						// day
																						// =
																						// price/day
			double totalPrice = 0;
			int numberOfPassengers = tableNewBusPassengers.getRowCount();
			int monthStart = 0;
			int dayStart = 0;
			int yearStart = 0;
			int monthEnd = 0;
			int dayEnd = 0;
			int yearEnd = 0;
			try {
				monthStart = Integer.parseInt(textFieldNewBusStartMonth.getText());
				dayStart = Integer.parseInt(textFieldNewBusStartDay.getText());
				yearStart = Integer.parseInt(textFieldNewBusStartYear.getText());
				monthEnd = Integer.parseInt(textFieldNewBusEndMonth.getText());
				dayEnd = Integer.parseInt(textFieldNewBusEndDay.getText());
				yearEnd = Integer.parseInt(textFieldNewBusEndYear.getText());
			} catch (Exception e) {
			}

			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date startDate = null, endDate = null, currentDate = new java.util.Date();

			try {
				startDate = dateformat.parse(dayStart + "/" + monthStart + "/" + yearStart);
				endDate = dateformat.parse(dayEnd + "/" + monthEnd + "/" + yearEnd);
			} catch (ParseException e) {

				e.printStackTrace();
			}

			if (currentDate.equals(startDate) && startDate.before(endDate)
					|| currentDate.before(startDate) && startDate.before(endDate)) {
				int daysCount = daysBetweenDates(startDate, endDate);
				if (chckbxAllInclusiveNewBus.isSelected()) {
					pricePerDay += numberOfPassengers * priceList.getPriceAllInclusive();
				}
				if (chckbxBreakfastNewBus.isSelected()) {
					pricePerDay += numberOfPassengers * priceList.getPriceBreakfast();
				}
				if (chckbxLunchNewBus.isSelected()) {
					pricePerDay += numberOfPassengers * priceList.getPriceLunch();
				}
				totalPrice = daysCount * pricePerDay;
				if (chckbxEntranceTicketsNewBus.isSelected()) {
					totalPrice += priceList.getPriceEntranceTickets();
				}
				str += "\n\nTotal price: " + round(totalPrice, 2) + "\n Total price per passenger: "
						+ round(totalPrice / numberOfPassengers, 2);
			} else {
				str += "\n - unable to calculate total price -\n";
			}

		}
		textPaneSummaryNewBus.setText(str);
	}

	/**
	 * This lists Chauffeurs from the chauffeursArchive in the chauffeursTable
	 * table
	 */
	public void listChauffeurs() {
		chauffeursTable = (DefaultTableModel) tableChauffeurs.getModel();
		deleteAllRows(chauffeursTable);
		Object[] rowData = new Object[8];
		for (int i = 0; i < chauffeursArchive.size(); i++) {
			rowData[0] = chauffeursArchive.get(i).getEmployeeNumber();
			rowData[1] = chauffeursArchive.get(i).getEarliestDepartureString();
			rowData[2] = chauffeursArchive.get(i).getName();
			rowData[3] = chauffeursArchive.get(i).getAddress();
			rowData[4] = chauffeursArchive.get(i).getEmail();
			rowData[5] = chauffeursArchive.get(i).getPhonenumber();
			rowData[6] = chauffeursArchive.get(i).getBirthDay();
			rowData[7] = chauffeursArchive.get(i).isOnlyOneDayTrips();
			chauffeursTable.addRow(rowData);
		}

	}

	/**
	 * This adds new Chauffeur to the chuauffeurTable with: employeeNumber,
	 * earliestDeparture, name, address, email, phonenumber, birthDay,
	 * onlyOneDayTrips table
	 * 
	 * @param employeeNumber
	 *            - employee number for this Chauffeur
	 * @param earlistDeparture
	 *            - earliest departure for this Chauffeur
	 * @param name
	 *            - name for this Chauffeur
	 * @param address
	 *            - address for this Chauffeur
	 * @param email
	 *            - email for this Chauffeur
	 * @param phonenumber
	 *            - phonenumber for this Chauffeur
	 * @param birthDay
	 *            - birthday for this Chauffeur
	 * @param onlyOneDayTrips
	 *            - if the Chauffeur is only available for one day trips
	 */
	public void updateListChauffeurs(String employeeNumber, String earlistDeparture, String name, String address,
			String email, String phonenumber, String birthDay, boolean onlyOneDayTrips) {
		Object[] rowData = new Object[8];
		rowData[0] = employeeNumber;
		rowData[1] = earlistDeparture;
		rowData[2] = name;
		rowData[3] = address;
		rowData[4] = email;
		rowData[5] = phonenumber;
		rowData[6] = birthDay;
		rowData[7] = onlyOneDayTrips;
		chauffeursTable.addRow(rowData);
	}

	/**
	 * This lists suitable Chauffeurs according to the startDate and
	 * durationInHours in newBusSelectChauffeurTable table
	 * 
	 * @param startDate
	 *            - start date
	 * @param durationInHours
	 *            - duration in hours
	 */
	public void listNewBusSelectChauffeur(java.util.Date startDate, int durationInHours) {
		newBusSelectChauffeurTable = (DefaultTableModel) tableNewBusSelectChauffeur.getModel();
		deleteAllRows(newBusSelectChauffeurTable);
		Object[] rowData = new Object[2];
		for (int i = 0; i < chauffeursArchive.size(); i++) {
			if (chauffeursArchive.get(i).isAvailable(startDate, durationInHours)) {
				rowData[0] = chauffeursArchive.get(i).getEmployeeNumber();
				rowData[1] = chauffeursArchive.get(i).getName();
				newBusSelectChauffeurTable.addRow(rowData);
			}
		}
	}

	/**
	 * This lists suitable Bus according to the startDate and durationInHours in
	 * newBusSelectBusTable table
	 * 
	 * @param startDate
	 *            - start date
	 * @param durationInHours
	 *            - duration in hours
	 */
	public void listNewBusSelectBus(java.util.Date startDate, int durationInHours) {
		newBusSelectBusTable = (DefaultTableModel) tableNewBusSelectBus.getModel();
		deleteAllRows(newBusSelectBusTable);
		Object[] rowData = new Object[4];
		for (int i = 0; i < busesArchive.size(); i++) {
			if (tableNewBusPassengers.getRowCount() <= busesArchive.get(i).getMaxNumberOfSeats()
					&& (busesArchive.get(i).isAvailable(startDate, durationInHours))) {
				rowData[0] = busesArchive.get(i).getVehicleID();
				rowData[1] = busesArchive.get(i).getPricePerHour();
				rowData[2] = busesArchive.get(i).getMaxNumberOfSeats();
				rowData[3] = busesArchive.get(i).getModelString();
				newBusSelectBusTable.addRow(rowData);
			}
		}
	}

	/**
	 * This lists all buses from busesArchive in busesTable table
	 */
	public void listBuses() {
		busesTable = (DefaultTableModel) tableBuses.getModel();
		deleteAllRows(busesTable);
		Object[] rowData = new Object[6];
		for (int i = 0; i < busesArchive.size(); i++) {
			rowData[0] = busesArchive.get(i).getVehicleID();
			rowData[1] = busesArchive.get(i).getPricePerHour();
			rowData[2] = busesArchive.get(i).getMaxNumberOfSeats();
			rowData[3] = busesArchive.get(i).getEarliestDepartureString();
			rowData[4] = busesArchive.get(i).getModelString();
			rowData[5] = busesArchive.get(i).isAvailableForTours();
			busesTable.addRow(rowData);
		}
	}

	/**
	 * This adds new Bus in the busesTable with: vehicleId, pricePerHour,
	 * maxSeats, availableSeats, model, availableForTours in busesTable table
	 * 
	 * @param vehicleId
	 *            - ID for this Bus
	 * @param pricePerHour
	 *            - price per hour for this Bus
	 * @param maxSeats
	 *            - max seats for this Bus
	 * @param availableSeats
	 *            - available seats for this Bus
	 * @param model
	 *            - model of this Bus
	 * @param availableForTours
	 *            - if this Bus is available for tours
	 */
	public void updateListBuses(String vehicleId, double pricePerHour, int maxSeats, int availableSeats, String model,
			boolean availableForTours) {
		Object[] rowData = new Object[6];
		rowData[0] = vehicleId;
		rowData[1] = pricePerHour;
		rowData[2] = maxSeats;
		rowData[3] = availableSeats;
		rowData[4] = model;
		rowData[5] = availableForTours;
		busesTable.addRow(rowData);
	}

	/**
	 * This lists Tours from toursArchive in toursTableInNewTourReservation
	 * table
	 */
	public void listTours() {
		toursTable = (DefaultTableModel) tableTours.getModel();
		deleteAllRows(toursTable);
		toursTableInNewTourReservation = (DefaultTableModel) tableToursInNewTourReservation.getModel();
		deleteAllRows(toursTableInNewTourReservation);
		Object[] rowData = new Object[9];
		for (int i = 0; i < toursArchive.size(); i++) {
			rowData[0] = toursArchive.get(i).getDepartureDate();
			rowData[1] = toursArchive.get(i).getDestination();
			rowData[2] = toursArchive.get(i).getPickUpPlacesString();
			rowData[3] = toursArchive.get(i).getSeatsAvailable();
			rowData[4] = toursArchive.get(i).getTotalPrice();
			rowData[5] = toursArchive.get(i).getPricePerPassenger();
			rowData[6] = toursArchive.get(i).getBusAndType();
			rowData[7] = toursArchive.get(i).getChauffeur();
			rowData[8] = toursArchive.get(i).getServicesString();
			toursTable.addRow(rowData);
			if (toursArchive.get(i).getSeatsAvailable() > 0)
				this.toursTableInNewTourReservation.addRow(rowData);
		}

	}

	/**
	 * This adds Tour to the tourTable with: dateInterval, destination, puckUps,
	 * seatsAvailable, price, pricePerPassenger, busAndType, chauffeur, services
	 * 
	 * @param dateInterval
	 *            - date interval for this Tour
	 * @param destination
	 *            - destination for this Tour
	 * @param pickUps
	 *            - pick ups for this Tour
	 * @param seatsAvailable
	 *            - seats available for this Tour
	 * @param price
	 *            - price for this Tour
	 * @param pricePerPassenger
	 *            - price per passenger for this Tour
	 * @param busAndType
	 *            - bus and type for this Tour
	 * @param chauffeur
	 *            - chauffeur for this Tour
	 * @param services
	 *            - services for this Tour
	 */

	/**
	 * This lists Customer from customersArchive in customersTable table
	 */
	public void listCustomers() {
		customersTable = (DefaultTableModel) tableCustomers.getModel();
		deleteAllRows(customersTable);
		Object[] rowData = new Object[9];
		for (int i = 0; i < customersArchive.size(); i++) {
			rowData[0] = customersArchive.get(i).getName();
			rowData[1] = customersArchive.get(i).getOrganisationType();
			rowData[2] = customersArchive.get(i).getPhonenumber();
			rowData[3] = customersArchive.get(i).getName();
			rowData[4] = customersArchive.get(i).getAddress();
			rowData[5] = customersArchive.get(i).getEmail();
			rowData[6] = customersArchive.get(i).getBirthday().displayDate();
			rowData[7] = customersArchive.get(i).getMoneySpent();
			rowData[8] = customersArchive.get(i).getDiscount() * 100 + "%";
			customersTable.addRow(rowData);
		}
		customersTable = (DefaultTableModel) customersTableInNewTourReservation.getModel();
		deleteAllRows(customersTable);
		for (int i = 0; i < customersArchive.size(); i++) {
			rowData[0] = customersArchive.get(i).getName();
			rowData[1] = customersArchive.get(i).getOrganisationType();
			rowData[2] = customersArchive.get(i).getPhonenumber();
			rowData[3] = customersArchive.get(i).getName();
			rowData[4] = customersArchive.get(i).getAddress();
			rowData[5] = customersArchive.get(i).getEmail();
			rowData[6] = customersArchive.get(i).getBirthday().displayDate();
			rowData[7] = customersArchive.get(i).getMoneySpent();
			rowData[8] = customersArchive.get(i).getDiscount();
			customersTable.addRow(rowData);
		}
	}

	/**
	 * This adds a new Customer in customersTable table
	 * 
	 * @param newCustomer
	 *            - new Customer that is added to the table
	 */
	public void updateListCustomers(Customer newCustomer) {
		customersTable = (DefaultTableModel) tableCustomers.getModel();
		Object[] rowData = new Object[9];
		rowData[0] = newCustomer.getName();
		rowData[1] = newCustomer.getOrganisationType();
		rowData[2] = newCustomer.getPhonenumber();
		rowData[3] = newCustomer.getName();
		rowData[4] = newCustomer.getAddress();
		rowData[5] = newCustomer.getEmail();
		rowData[6] = newCustomer.getBirthday().displayDate();
		rowData[7] = newCustomer.getMoneySpent();
		rowData[8] = newCustomer.getDiscount();
		customersTable.addRow(rowData);
		customersTable = (DefaultTableModel) customersTableInNewTourReservation.getModel();
		customersTable.addRow(rowData);
	}

	/**
	 * This lists passengers from passengersArchive in passengersTable table
	 */
	public void listPassengers() {
		passengersTable = (DefaultTableModel) tablePassengers.getModel();
		deleteAllRows(passengersTable);
		Object[] rowData = new Object[5];
		for (int i = 0; i < passengersArchive.size(); i++) {
			rowData[0] = passengersArchive.get(i).getName();
			rowData[1] = passengersArchive.get(i).getAddress();
			rowData[2] = passengersArchive.get(i).getPhonenumber();
			rowData[3] = passengersArchive.get(i).getEmail();
			rowData[4] = passengersArchive.get(i).getBirthday().displayDate();
			passengersTable.addRow(rowData);
		}
	}

	/**
	 * This adds a new Passenger in passengersTable table
	 * 
	 * @param newPassenger
	 *            - new Passenger that is added to the table
	 */
	public void updateListPassengers(Passenger newPassenger) {
		passengersTable = (DefaultTableModel) tablePassengers.getModel();
		Object[] rowData = new Object[5];
		rowData[0] = newPassenger.getName();
		rowData[1] = newPassenger.getAddress();
		rowData[2] = newPassenger.getPhonenumber();
		rowData[3] = newPassenger.getEmail();
		rowData[4] = newPassenger.getBirthday().displayDate();
		passengersTable.addRow(rowData);
	}

	/**
	 * This adds a new Passenger in the table in NewTourReservation in
	 * passengersTable table
	 * 
	 * @param newPassenger
	 *            - new passenger that is added in NewTourReservation
	 */
	public void updateListPassengersInNewTourReservation(Passenger newPassenger) {
		passengersTable = (DefaultTableModel) tablePassengersInNewTourReservation.getModel();
		Object[] rowData = new Object[5];
		rowData[0] = newPassenger.getName();
		rowData[1] = newPassenger.getAddress();
		rowData[2] = newPassenger.getPhonenumber();
		rowData[3] = newPassenger.getEmail();
		rowData[4] = newPassenger.getBirthday().displayDate();
		passengersTable.addRow(rowData);
	}

	/**
	 * This adds new pick up on the table in pickupsTable table
	 */
	public void updateListPickUps() {
		pickupsTable = (DefaultTableModel) tablePickups.getModel();
		Object[] rowData = new Object[1];
		rowData[0] = textFieldAddPickup.getText();
		textFieldAddPickup.setText("");
		pickupsTable.addRow(rowData);
	}

	/**
	 * This lists suitable Buses according to startDate and durationInHours in
	 * selectBusTable table
	 * 
	 * @param startDate
	 *            - start date
	 * @param durationInHours
	 *            - duration in hours
	 */
	public void listSelectBus(java.util.Date startDate, int durationInHours) {
		selectBusTable = (DefaultTableModel) tableSelectBus.getModel();
		deleteAllRows(selectBusTable);
		Object[] rowData = new Object[3];
		for (int i = 0; i < busesArchive.size(); i++) {
			if (busesArchive.get(i).isAvailable(startDate, durationInHours)) {
				rowData[0] = busesArchive.get(i).getVehicleID();
				rowData[1] = busesArchive.get(i).getModel();
				rowData[2] = Integer.toString(busesArchive.get(i).getMaxNumberOfSeats());
				selectBusTable.addRow(rowData);
			}
		}
	}

	/**
	 * This lists suitable Chauffeurs according to startDate and durationInHours
	 * in selectChauffeurTable table
	 * 
	 * @param startDate
	 *            - start date
	 * @param durationInHours
	 *            - duration in hours
	 */
	public void listSelectChauffeur(java.util.Date startDate, int durationInHours) {
		selectChauffeurTable = (DefaultTableModel) tableSelectChauffeur.getModel();
		deleteAllRows(selectChauffeurTable);
		Object[] rowData = new Object[2];
		for (int i = 0; i < chauffeursArchive.size(); i++) {
			if (!chauffeursArchive.get(i).isOnlyOneDayTrips()
					&& chauffeursArchive.get(i).isAvailable(startDate, durationInHours)) {
				rowData[0] = chauffeursArchive.get(i).getEmployeeNumber();
				rowData[1] = chauffeursArchive.get(i).getName();
				selectChauffeurTable.addRow(rowData);
			}
		}

	}

	/**
	 * This updates prices for breakfast, lunch, all inclusive and tickets in
	 * textFieldPriceBreakfast, textFieldPriceLunch, textFieldPriceAllinclusive,
	 * textFieldPriceEntranceTickets fields
	 */
	public void updatePrices() {
		textFieldPriceBreakfast.setText(Double.toString(priceList.getPriceBreakfast()));
		textFieldPriceLunch.setText(Double.toString(priceList.getPriceLunch()));
		textFieldPriceAllinclusive.setText(Double.toString(priceList.getPriceAllInclusive()));
		textFieldPriceEntranceTickets.setText(Double.toString(priceList.getPriceEntranceTickets()));
	}

	/**
	 * This lists other busReservations to busReservationsTabel in
	 * busReservationsTable table
	 */
	public void listBusReservations() {
		busReservationsTable = (DefaultTableModel) tableBusReservations.getModel();
		deleteAllRows(busReservationsTable);
		Object[] rowData = new Object[8];
		for (int i = 0; i < reservationsArchive.size(); i++) {
			if (reservationsArchive.get(i) instanceof BusReservation) {
				BusReservation otherBusReservation = (BusReservation) reservationsArchive.get(i);
				rowData[0] = otherBusReservation.getReservationNumber();
				rowData[1] = otherBusReservation.getDepartureDate();
				rowData[2] = otherBusReservation.getCustomer().getName();
				rowData[3] = otherBusReservation.getPassengersString();
				rowData[4] = otherBusReservation.getChauffeur().getName();
				rowData[5] = "#" + otherBusReservation.getBus().getVehicleID() + " "
						+ otherBusReservation.getBus().getModel();
				rowData[6] = otherBusReservation.getServices().getServicesString();
				rowData[7] = otherBusReservation.getTotalPrice();
				busReservationsTable.addRow(rowData);
			}
		}
	}

	/**
	 * This lists other tourReservations to busReservationsTabel in
	 * tourReservationsTable table
	 */
	public void listTourReservations() {
		tourReservationsTable = (DefaultTableModel) tableTourReservations.getModel();
		deleteAllRows(tourReservationsTable);
		Object[] rowData = new Object[5];
		for (int i = 0; i < reservationsArchive.size(); i++) {
			if (reservationsArchive.get(i) instanceof TourReservation) {
				TourReservation otherTourReservation = (TourReservation) reservationsArchive.get(i);
				rowData[0] = otherTourReservation.getReservationNumber();
				rowData[1] = otherTourReservation.getTour().getDestination() + " "
						+ otherTourReservation.getTour().getDateIntervalString();
				rowData[2] = otherTourReservation.getCustomer().getName();
				rowData[3] = otherTourReservation.getPassengersString();
				rowData[4] = otherTourReservation.getTotalPrice();
				tourReservationsTable.addRow(rowData);
			}
		}
	}

	/**
	 * This lists tourReservation in tourReservationTable table
	 */
	public void updateListTourReservations(TourReservation newTourReservation) {
		tourReservationsTable = (DefaultTableModel) tableTourReservations.getModel();
		Object[] rowData = new Object[5];
		rowData[0] = newTourReservation.getReservationNumber();
		rowData[1] = newTourReservation.getTour().getDestination() + " "
				+ newTourReservation.getTour().getDateIntervalString();
		rowData[2] = newTourReservation.getCustomer().getName();
		rowData[3] = newTourReservation.getPassengersString();
		rowData[4] = newTourReservation.getTotalPrice();
		tourReservationsTable.addRow(rowData);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// This method contains all code for creating and initializing components
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("serial")
	private void initComponents() {
		icon = new ImageIcon(Autobus.class.getResource("/ressources/icon_bus.png"));

		getContentPane().setBackground(new Color(0, 128, 128));

		setBackground(new Color(32, 178, 170));
		setTitle("autobus\u00AE - Bus Transportation Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Autobus.class.getResource("/ressources/icon_bus.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1387, 1156);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(3, 3, 3, 3));
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setBackground(new Color(32, 178, 170));
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setForeground(new Color(255, 255, 255));
		menuBar.add(mnFile);

		mntmNewTourReservation = new JMenuItem("New Tour reservation");
		mnFile.add(mntmNewTourReservation);

		mntmNewBusReservation = new JMenuItem("New Bus reservation");
		mnFile.add(mntmNewBusReservation);

		mntmExit = new JMenuItem("Exit");

		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setForeground(new Color(255, 255, 255));
		menuBar.add(mnEdit);

		mntmEditBus = new JMenuItem("Buses");

		mnEdit.add(mntmEditBus);

		mntmEditChauffeur = new JMenuItem("Chauffeurs");

		mnEdit.add(mntmEditChauffeur);

		mntmEditCustomers = new JMenuItem("Customers");
		mnEdit.add(mntmEditCustomers);

		mntmPassengers = new JMenuItem("Passengers");
		mnEdit.add(mntmPassengers);

		mntmEditTours = new JMenuItem("Tours");
		mnEdit.add(mntmEditTours);

		mntmPrices = new JMenuItem("Prices");
		mnEdit.add(mntmPrices);

		JMenu mnReservations = new JMenu("Reservations");
		mnReservations.setForeground(new Color(255, 255, 255));
		menuBar.add(mnReservations);

		mntmTourReservations = new JMenuItem("Tour reservations");

		mnReservations.add(mntmTourReservations);

		mntmBusReservations = new JMenuItem("Bus reservations");

		mnReservations.add(mntmBusReservations);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setForeground(new Color(255, 255, 255));
		menuBar.add(mnHelp);

		mntmAboutAutobus = new JMenuItem("About autobus\u00AE");

		mnHelp.add(mntmAboutAutobus);

		JLabel lblTopBanner = new JLabel("");
		lblTopBanner.setIcon(new ImageIcon(Autobus.class.getResource("/ressources/bus_banner.jpg")));

		desktopPane = new JDesktopPane();

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE).addGap(0))
						.addComponent(lblTopBanner, GroupLayout.PREFERRED_SIZE, 1000, Short.MAX_VALUE)).addGap(0)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addComponent(lblTopBanner)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(desktopPane, GroupLayout.DEFAULT_SIZE,
								494, Short.MAX_VALUE)));
		desktopPane.setLayout(new CardLayout(0, 0));

		panelTourReservations = new JPanel();
		panelTourReservations.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelTourReservations, "name_32464075200119");

		JPanel panelTopTourReservations = new JPanel();
		panelTopTourReservations.setBackground(new Color(0, 128, 128));

		scrollPaneTourReservations = new JScrollPane();
		scrollPaneTourReservations.setForeground(new Color(255, 255, 255));
		scrollPaneTourReservations.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		scrollPaneTourReservations.setBackground(new Color(95, 158, 160));

		lblDeleteTourReservation = new JLabel("Delete Tour Reservation");
		lblDeleteTourReservation.setForeground(Color.WHITE);
		lblDeleteTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblDeleteTourReservation.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));

		lblUpdateTourReservation = new JLabel("Update Tour Reservation");
		lblUpdateTourReservation.setForeground(Color.WHITE);
		lblUpdateTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblUpdateTourReservation.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));

		JLabel lblSearchByDestination_2 = new JLabel("Search by Customer's Name:");
		lblSearchByDestination_2.setForeground(Color.WHITE);
		lblSearchByDestination_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		searchTourResTextField = new JTextField();
		searchTourResTextField.setBorder(new LineBorder(new Color(255, 255, 255)));
		searchTourResTextField.setBackground(new Color(95, 158, 160));
		searchTourResTextField.setColumns(10);
		GroupLayout gl_panelTourReservations = new GroupLayout(panelTourReservations);
		gl_panelTourReservations.setHorizontalGroup(gl_panelTourReservations.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTourReservations.createSequentialGroup().addContainerGap()
						.addComponent(lblUpdateTourReservation).addGap(18).addComponent(lblDeleteTourReservation)
						.addContainerGap(995, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panelTourReservations.createSequentialGroup()
						.addGroup(gl_panelTourReservations.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelTourReservations.createSequentialGroup().addGap(12)
										.addComponent(scrollPaneTourReservations, GroupLayout.DEFAULT_SIZE, 1326,
												Short.MAX_VALUE)
										.addGap(31))
								.addComponent(panelTopTourReservations, GroupLayout.DEFAULT_SIZE, 1369,
										Short.MAX_VALUE))
						.addGap(0))
				.addGroup(gl_panelTourReservations.createSequentialGroup().addContainerGap()
						.addComponent(lblSearchByDestination_2)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(searchTourResTextField,
								GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(970, Short.MAX_VALUE)));
		gl_panelTourReservations.setVerticalGroup(gl_panelTourReservations.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTourReservations.createSequentialGroup()
						.addComponent(panelTopTourReservations, GroupLayout.PREFERRED_SIZE, 58,
								GroupLayout.PREFERRED_SIZE)
						.addGap(9)
						.addGroup(gl_panelTourReservations.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSearchByDestination_2, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(searchTourResTextField, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPaneTourReservations, GroupLayout.PREFERRED_SIZE, 322,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelTourReservations.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUpdateTourReservation, GroupLayout.PREFERRED_SIZE, 27,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDeleteTourReservation, GroupLayout.PREFERRED_SIZE, 27,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(413, Short.MAX_VALUE)));

		tableTourReservations = new JTable();
		tableTourReservations.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Reservation#", "Tour", "Customer", "Passengers", "Total Price" }) {
			/**
			* 
			*/
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTourReservations.setSelectionBackground(new Color(102, 205, 170));
		tableTourReservations.setBackground(new Color(95, 158, 160));
		tableTourReservations.setForeground(new Color(255, 255, 255));
		tableTourReservations.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		scrollPaneTourReservations.setViewportView(tableTourReservations);

		JLabel lblNewLabel = new JLabel("Tour reservations");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopTourReservations = new GroupLayout(panelTopTourReservations);
		gl_panelTopTourReservations
				.setHorizontalGroup(gl_panelTopTourReservations.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTopTourReservations.createSequentialGroup().addContainerGap()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(749, Short.MAX_VALUE)));
		gl_panelTopTourReservations.setVerticalGroup(gl_panelTopTourReservations.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTopTourReservations.createSequentialGroup()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelTopTourReservations.setLayout(gl_panelTopTourReservations);
		panelTourReservations.setLayout(gl_panelTourReservations);

		panelBusReservations = new JPanel();
		panelBusReservations.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelBusReservations, "name_33299908692167");

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));

		JLabel labelBusReservations = new JLabel("Bus and Chauffeur reservations");
		labelBusReservations.setForeground(Color.WHITE);
		labelBusReservations.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(labelBusReservations, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(610, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(labelBusReservations, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		scrollPaneBusReservations = new JScrollPane();
		scrollPaneBusReservations.setBackground(new Color(95, 158, 160));
		scrollPaneBusReservations.setForeground(new Color(255, 255, 255));

		lblDeleteBus = new JLabel("Delete Bus & Chauffeur Reservation");
		lblDeleteBus.setForeground(Color.WHITE);
		lblDeleteBus.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblDeleteBus.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));

		lblUpdateBusReservation = new JLabel("Update Bus & Chauffeur Reservation");
		lblUpdateBusReservation.setForeground(Color.WHITE);
		lblUpdateBusReservation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblUpdateBusReservation.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));

		JLabel lblSearchByCustomers = new JLabel("Search by Customer's Name:");
		lblSearchByCustomers.setForeground(Color.WHITE);
		lblSearchByCustomers.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		searchBusResTextField = new JTextField();
		searchBusResTextField.setBackground(new Color(95, 158, 160));
		searchBusResTextField.setBorder(new LineBorder(new Color(255, 255, 255)));
		searchBusResTextField.setColumns(10);
		GroupLayout gl_panelBusReservations = new GroupLayout(panelBusReservations);
		gl_panelBusReservations
				.setHorizontalGroup(gl_panelBusReservations.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBusReservations.createSequentialGroup()
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 1369, Short.MAX_VALUE).addGap(0))
						.addGroup(gl_panelBusReservations.createSequentialGroup().addContainerGap()
								.addComponent(lblUpdateBusReservation).addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblDeleteBus).addContainerGap(835, Short.MAX_VALUE))
						.addGroup(gl_panelBusReservations.createSequentialGroup().addContainerGap()
								.addComponent(scrollPaneBusReservations, GroupLayout.DEFAULT_SIZE, 1330,
										Short.MAX_VALUE)
								.addGap(27))
						.addGroup(gl_panelBusReservations.createSequentialGroup().addContainerGap()
								.addComponent(lblSearchByCustomers)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(searchBusResTextField,
										GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(970, Short.MAX_VALUE)));
		gl_panelBusReservations.setVerticalGroup(gl_panelBusReservations.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBusReservations.createSequentialGroup()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelBusReservations.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSearchByCustomers, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(searchBusResTextField, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPaneBusReservations, GroupLayout.PREFERRED_SIZE, 302,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelBusReservations.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUpdateBusReservation, GroupLayout.PREFERRED_SIZE, 27,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDeleteBus, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(435, Short.MAX_VALUE)));

		tableBusReservations = new JTable();
		tableBusReservations.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Reservation#", "Date",
				"Customer", "Passengers", "Chauffeur", "Bus", "Services", "Total Price" }) {
			/**
			* 
			*/
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Integer.class, Object.class, Object.class, Object.class, Object.class,
					Object.class, Object.class, Object.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableBusReservations.setSelectionBackground(new Color(102, 205, 170));
		tableBusReservations.setForeground(new Color(255, 255, 255));
		tableBusReservations.setBackground(new Color(95, 158, 160));
		scrollPaneBusReservations.setViewportView(tableBusReservations);
		panelBusReservations.setLayout(gl_panelBusReservations);

		panelChauffeurs = new JPanel();
		panelChauffeurs.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelChauffeurs, "name_33922176440952");

		JPanel panelTopChauffeurs = new JPanel();
		panelTopChauffeurs.setBackground(new Color(0, 128, 128));

		JLabel labelChauffeurs = new JLabel("Chauffeurs archive");
		labelChauffeurs.setForeground(Color.WHITE);
		labelChauffeurs.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopChauffeurs = new GroupLayout(panelTopChauffeurs);
		gl_panelTopChauffeurs.setHorizontalGroup(gl_panelTopChauffeurs.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelTopChauffeurs.createSequentialGroup().addContainerGap()
						.addComponent(labelChauffeurs, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(748, Short.MAX_VALUE)));
		gl_panelTopChauffeurs.setVerticalGroup(gl_panelTopChauffeurs.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
				.addGroup(gl_panelTopChauffeurs.createSequentialGroup()
						.addComponent(labelChauffeurs, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelTopChauffeurs.setLayout(gl_panelTopChauffeurs);

		JPanel panelAddChauffeur = new JPanel();
		panelAddChauffeur.setBackground(new Color(95, 158, 160));
		panelAddChauffeur.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Add chauffeur",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));

		JScrollPane scrollPaneChauffeursArchive = new JScrollPane();
		scrollPaneChauffeursArchive.setOpaque(false);
		scrollPaneChauffeursArchive.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		scrollPaneChauffeursArchive.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Chauffeurs archive",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
				new EmptyBorder(5, 5, 5, 5)));
		scrollPaneChauffeursArchive.setBackground(new Color(95, 158, 160));

		lblDeleteChauffeurBtn = new JLabel("Delete Chauffeur");

		lblDeleteChauffeurBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(2, 2, 2, 2)));
		lblDeleteChauffeurBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblDeleteChauffeurBtn.setForeground(new Color(255, 255, 255));

		lblShowFullDescriptionChauffeurButton = new JLabel("Show Full Description");
		lblShowFullDescriptionChauffeurButton.setForeground(Color.WHITE);
		lblShowFullDescriptionChauffeurButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblShowFullDescriptionChauffeurButton.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(2, 2, 2, 2)));

		JLabel lblSearchByName = new JLabel("Search by Name:");
		lblSearchByName.setForeground(Color.WHITE);
		lblSearchByName.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		searchChauffeurTextField = new JTextField();
		searchChauffeurTextField.setBackground(new Color(95, 158, 160));
		searchChauffeurTextField.setBorder(new LineBorder(new Color(255, 255, 255)));
		searchChauffeurTextField.setColumns(10);
		GroupLayout gl_panelChauffeurs = new GroupLayout(panelChauffeurs);
		gl_panelChauffeurs.setHorizontalGroup(gl_panelChauffeurs.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChauffeurs.createSequentialGroup()
						.addComponent(panelTopChauffeurs, GroupLayout.DEFAULT_SIZE, 1369, Short.MAX_VALUE).addGap(0))
				.addGroup(gl_panelChauffeurs.createSequentialGroup().addGap(12)
						.addComponent(panelAddChauffeur, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panelChauffeurs.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelChauffeurs.createSequentialGroup()
										.addComponent(lblShowFullDescriptionChauffeurButton, GroupLayout.PREFERRED_SIZE,
												149, GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblDeleteChauffeurBtn))
								.addComponent(scrollPaneChauffeursArchive, GroupLayout.DEFAULT_SIZE, 981,
										Short.MAX_VALUE)
								.addGroup(gl_panelChauffeurs.createSequentialGroup().addComponent(lblSearchByName)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(searchChauffeurTextField, GroupLayout.PREFERRED_SIZE, 179,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		gl_panelChauffeurs.setVerticalGroup(gl_panelChauffeurs.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChauffeurs.createSequentialGroup()
						.addComponent(panelTopChauffeurs, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panelChauffeurs.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelAddChauffeur, GroupLayout.PREFERRED_SIZE, 368,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelChauffeurs.createSequentialGroup()
										.addGroup(gl_panelChauffeurs.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblSearchByName, GroupLayout.PREFERRED_SIZE, 25,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(searchChauffeurTextField, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(scrollPaneChauffeursArchive, GroupLayout.PREFERRED_SIZE, 328,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelChauffeurs.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblShowFullDescriptionChauffeurButton, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDeleteChauffeurBtn))
						.addContainerGap(392, Short.MAX_VALUE)));

		tableChauffeurs = new JTable();
		tableChauffeurs.setRowHeight(20);
		tableChauffeurs.setShowVerticalLines(false);
		scrollPaneChauffeursArchive.setViewportView(tableChauffeurs);
		tableChauffeurs.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tableChauffeurs.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "#", "Earliest Departure",
				"Name", "Address", "Email", "Phone", "Birthday", "1 d only" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class,
					Object.class, Object.class, Boolean.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableChauffeurs.getColumnModel().getColumn(0).setPreferredWidth(31);
		tableChauffeurs.getColumnModel().getColumn(1).setPreferredWidth(128);
		tableChauffeurs.getColumnModel().getColumn(2).setPreferredWidth(107);
		tableChauffeurs.getColumnModel().getColumn(3).setPreferredWidth(115);
		tableChauffeurs.getColumnModel().getColumn(4).setPreferredWidth(91);
		tableChauffeurs.setSelectionForeground(new Color(255, 255, 255));
		tableChauffeurs.setSelectionBackground(new Color(102, 205, 170));
		tableChauffeurs.setForeground(new Color(255, 255, 255));
		tableChauffeurs.setBackground(new Color(95, 158, 160));

		textFieldChauffeurName = new JTextField();
		textFieldChauffeurName.setForeground(new Color(255, 255, 255));
		textFieldChauffeurName.setBackground(new Color(95, 158, 160));
		textFieldChauffeurName.setBorder(new LineBorder(Color.WHITE));
		textFieldChauffeurName.setColumns(10);

		JLabel lblChauffeurName = new JLabel("Name:");
		lblChauffeurName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblChauffeurName.setForeground(new Color(255, 255, 255));

		JLabel lblChauffeurAddress = new JLabel("Address:");
		lblChauffeurAddress.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblChauffeurAddress.setForeground(new Color(255, 255, 255));

		textFieldChauffeurAddress = new JTextField();
		textFieldChauffeurAddress.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldChauffeurAddress.setBackground(new Color(95, 158, 160));
		textFieldChauffeurAddress.setForeground(new Color(255, 255, 255));
		textFieldChauffeurAddress.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setForeground(new Color(255, 255, 255));
		lblBirthday.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel lblEmployee = new JLabel("Employee#");
		lblEmployee.setForeground(new Color(255, 255, 255));
		lblEmployee.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldChauffeurEmail = new JTextField();
		textFieldChauffeurEmail.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldChauffeurEmail.setBackground(new Color(95, 158, 160));
		textFieldChauffeurEmail.setForeground(new Color(255, 255, 255));
		textFieldChauffeurEmail.setSelectedTextColor(new Color(255, 255, 255));
		textFieldChauffeurEmail.setSelectionColor(new Color(95, 158, 160));
		textFieldChauffeurEmail.setColumns(10);

		textFieldChauffeurPhone = new JTextField();
		textFieldChauffeurPhone.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldChauffeurPhone.setBackground(new Color(95, 158, 160));
		textFieldChauffeurPhone.setForeground(new Color(255, 255, 255));
		textFieldChauffeurPhone.setSelectedTextColor(new Color(255, 255, 255));
		textFieldChauffeurPhone.setSelectionColor(new Color(95, 158, 160));
		textFieldChauffeurPhone.setColumns(10);

		textFieldChauffeurBirthMonth = new JTextField();
		textFieldChauffeurBirthMonth.setBorder(new TitledBorder(new LineBorder(null), "MM", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldChauffeurBirthMonth.setBackground(new Color(95, 158, 160));
		textFieldChauffeurBirthMonth.setForeground(new Color(255, 255, 255));
		textFieldChauffeurBirthMonth.setSelectedTextColor(new Color(255, 255, 255));
		textFieldChauffeurBirthMonth.setSelectionColor(new Color(95, 158, 160));
		textFieldChauffeurBirthMonth.setColumns(10);

		textFieldEmployeeNo = new JTextField();
		textFieldEmployeeNo.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldEmployeeNo.setBackground(new Color(95, 158, 160));
		textFieldEmployeeNo.setForeground(new Color(255, 255, 255));
		textFieldEmployeeNo.setSelectedTextColor(new Color(255, 255, 255));
		textFieldEmployeeNo.setSelectionColor(new Color(95, 158, 160));
		textFieldEmployeeNo.setColumns(10);

		chckbxExternalEmployee = new JCheckBox("External employee");
		chckbxExternalEmployee.setForeground(new Color(255, 255, 255));
		chckbxExternalEmployee.setBackground(new Color(95, 158, 160));
		chckbxExternalEmployee.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		chckbxOnlyOneDayTrips = new JCheckBox("Only 1 day trips");
		chckbxOnlyOneDayTrips.setForeground(new Color(255, 255, 255));
		chckbxOnlyOneDayTrips.setBackground(new Color(95, 158, 160));
		chckbxOnlyOneDayTrips.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		lblAddChauffeurButton = new JLabel("Add Chauffeur");

		lblAddChauffeurButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblAddChauffeurButton.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(2, 2, 2, 2)));
		lblAddChauffeurButton.setForeground(new Color(255, 255, 255));

		textFieldChauffeurBirthDay = new JTextField();
		textFieldChauffeurBirthDay.setBorder(new TitledBorder(new LineBorder(null), "DD", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldChauffeurBirthDay.setBackground(new Color(95, 158, 160));
		textFieldChauffeurBirthDay.setForeground(new Color(255, 255, 255));
		textFieldChauffeurBirthDay.setColumns(10);

		textFieldChauffeurBirthYear = new JTextField();
		textFieldChauffeurBirthYear.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldChauffeurBirthYear.setBackground(new Color(95, 158, 160));
		textFieldChauffeurBirthYear.setForeground(new Color(255, 255, 255));
		textFieldChauffeurBirthYear.setColumns(10);
		GroupLayout gl_panelAddChauffeur = new GroupLayout(panelAddChauffeur);
		gl_panelAddChauffeur.setHorizontalGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panelAddChauffeur.createSequentialGroup().addContainerGap().addComponent(lblEmployee)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(textFieldEmployeeNo,
										GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
								.addGap(7))
				.addGroup(gl_panelAddChauffeur.createSequentialGroup().addGap(13).addGroup(gl_panelAddChauffeur
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAddChauffeur.createSequentialGroup()
								.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxOnlyOneDayTrips).addComponent(chckbxExternalEmployee))
								.addContainerGap())
						.addGroup(gl_panelAddChauffeur.createSequentialGroup()
								.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBirthday).addComponent(lblChauffeurName)
										.addComponent(lblChauffeurAddress).addComponent(lblEmail)
										.addComponent(lblPhone))
								.addGap(29)
								.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldChauffeurAddress, Alignment.TRAILING,
												GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
										.addComponent(textFieldChauffeurName, Alignment.TRAILING,
												GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
										.addComponent(textFieldChauffeurEmail, GroupLayout.DEFAULT_SIZE, 209,
												Short.MAX_VALUE)
										.addComponent(textFieldChauffeurPhone, Alignment.TRAILING,
												GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
										.addGroup(gl_panelAddChauffeur.createSequentialGroup()
												.addComponent(textFieldChauffeurBirthMonth, GroupLayout.PREFERRED_SIZE,
														49, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldChauffeurBirthDay, GroupLayout.PREFERRED_SIZE,
														48, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldChauffeurBirthYear, GroupLayout.DEFAULT_SIZE,
														100, Short.MAX_VALUE)))
								.addGap(7))))
				.addGroup(Alignment.TRAILING, gl_panelAddChauffeur.createSequentialGroup()
						.addContainerGap(188, Short.MAX_VALUE).addComponent(lblAddChauffeurButton).addContainerGap()));
		gl_panelAddChauffeur.setVerticalGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelAddChauffeur.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.BASELINE).addComponent(lblEmployee)
								.addComponent(textFieldEmployeeNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
						.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldChauffeurName, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblChauffeurName))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblChauffeurAddress).addComponent(textFieldChauffeurAddress,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.BASELINE).addComponent(lblEmail)
								.addComponent(textFieldChauffeurEmail, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(12)
						.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.BASELINE).addComponent(lblPhone)
								.addComponent(textFieldChauffeurPhone, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelAddChauffeur.createParallelGroup(Alignment.BASELINE).addComponent(lblBirthday)
								.addComponent(textFieldChauffeurBirthMonth, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldChauffeurBirthYear, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldChauffeurBirthDay, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(chckbxExternalEmployee).addGap(4)
						.addComponent(chckbxOnlyOneDayTrips).addGap(45).addComponent(lblAddChauffeurButton)
						.addContainerGap()));
		panelAddChauffeur.setLayout(gl_panelAddChauffeur);
		panelChauffeurs.setLayout(gl_panelChauffeurs);

		panelBuses = new JPanel();
		panelBuses.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelBuses, "name_5618907185400");

		JPanel panelTopBuses = new JPanel();
		panelTopBuses.setBackground(new Color(0, 128, 128));

		JLabel lblBusesArchive = new JLabel("Buses archive");
		lblBusesArchive.setForeground(Color.WHITE);
		lblBusesArchive.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopBuses = new GroupLayout(panelTopBuses);
		gl_panelTopBuses.setHorizontalGroup(gl_panelTopBuses.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelTopBuses.createSequentialGroup().addContainerGap()
						.addComponent(lblBusesArchive, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(748, Short.MAX_VALUE)));
		gl_panelTopBuses.setVerticalGroup(gl_panelTopBuses.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
				.addGroup(gl_panelTopBuses.createSequentialGroup()
						.addComponent(lblBusesArchive, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelTopBuses.setLayout(gl_panelTopBuses);

		JPanel panelAddBus = new JPanel();
		panelAddBus.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Add bus",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelAddBus.setBackground(new Color(95, 158, 160));

		JLabel lblVehicleId = new JLabel("Vehicle ID# :");
		lblVehicleId.setForeground(Color.WHITE);
		lblVehicleId.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldVehicleID = new JTextField();
		textFieldVehicleID.setSelectionColor(new Color(95, 158, 160));
		textFieldVehicleID.setSelectedTextColor(Color.WHITE);
		textFieldVehicleID.setForeground(Color.WHITE);
		textFieldVehicleID.setColumns(10);
		textFieldVehicleID.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldVehicleID.setBackground(new Color(95, 158, 160));

		JLabel lblPricePerHour = new JLabel("Price per hour:");
		lblPricePerHour.setForeground(Color.WHITE);
		lblPricePerHour.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel lblNumberOfSeats = new JLabel("Number of seats:");
		lblNumberOfSeats.setForeground(Color.WHITE);
		lblNumberOfSeats.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel lblBusModeltype = new JLabel("Bus modeltype:");
		lblBusModeltype.setForeground(Color.WHITE);
		lblBusModeltype.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldNumberSeats = new JTextField();
		textFieldNumberSeats.setForeground(Color.WHITE);
		textFieldNumberSeats.setColumns(10);
		textFieldNumberSeats.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldNumberSeats.setBackground(new Color(95, 158, 160));

		textFieldPriceHour = new JTextField();
		textFieldPriceHour.setForeground(Color.WHITE);
		textFieldPriceHour.setColumns(10);
		textFieldPriceHour.setBorder(new LineBorder(Color.WHITE));
		textFieldPriceHour.setBackground(new Color(95, 158, 160));

		labelAddBusBtn = new JLabel("Add Bus");
		labelAddBusBtn.setForeground(Color.WHITE);
		labelAddBusBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		labelAddBusBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(2, 2, 2, 2)));

		rdbtnStandardBus = new JRadioButton("Standard bus");
		rdbtnStandardBus.setForeground(new Color(255, 255, 255));
		rdbtnStandardBus.setBackground(new Color(95, 158, 160));
		rdbtnStandardBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		rdbtnPartyBus = new JRadioButton("Party bus");
		rdbtnPartyBus.setForeground(new Color(255, 255, 255));
		rdbtnPartyBus.setBackground(new Color(95, 158, 160));
		rdbtnPartyBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		rdbtnLuxuryBus = new JRadioButton("Luxury bus");
		rdbtnLuxuryBus.setForeground(new Color(255, 255, 255));
		rdbtnLuxuryBus.setBackground(new Color(95, 158, 160));
		rdbtnLuxuryBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		GroupLayout gl_panelAddBus = new GroupLayout(panelAddBus);
		gl_panelAddBus.setHorizontalGroup(gl_panelAddBus.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelAddBus.createSequentialGroup().addContainerGap().addGroup(gl_panelAddBus
						.createParallelGroup(Alignment.LEADING).addGroup(
								gl_panelAddBus
										.createSequentialGroup().addGroup(gl_panelAddBus
												.createParallelGroup(Alignment.TRAILING)
												.addGroup(Alignment.LEADING, gl_panelAddBus.createSequentialGroup()
														.addGroup(gl_panelAddBus.createParallelGroup(Alignment.LEADING)
																.addComponent(lblPricePerHour)
																.addComponent(lblNumberOfSeats)
																.addComponent(lblBusModeltype))
														.addGap(29)
														.addGroup(gl_panelAddBus
																.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panelAddBus.createSequentialGroup()
																		.addComponent(rdbtnLuxuryBus).addPreferredGap(
																				ComponentPlacement.RELATED, 73,
																				GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_panelAddBus
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_panelAddBus.createSequentialGroup()
																				.addComponent(rdbtnPartyBus)
																				.addPreferredGap(
																						ComponentPlacement.RELATED, 82,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_panelAddBus
																				.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_panelAddBus
																						.createSequentialGroup()
																						.addComponent(rdbtnStandardBus)
																						.addPreferredGap(
																								ComponentPlacement.RELATED,
																								60,
																								GroupLayout.PREFERRED_SIZE))
																				.addComponent(textFieldPriceHour,
																						GroupLayout.DEFAULT_SIZE, 161,
																						Short.MAX_VALUE)
																				.addComponent(textFieldNumberSeats,
																						GroupLayout.DEFAULT_SIZE, 161,
																						Short.MAX_VALUE)))))
												.addGroup(Alignment.LEADING,
														gl_panelAddBus.createSequentialGroup()
																.addComponent(lblVehicleId).addGap(53)
																.addComponent(textFieldVehicleID,
																		GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.RELATED)))
										.addGap(7))
						.addGroup(Alignment.TRAILING, gl_panelAddBus.createSequentialGroup()
								.addComponent(labelAddBusBtn).addContainerGap()))));
		gl_panelAddBus.setVerticalGroup(gl_panelAddBus.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelAddBus.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelAddBus.createParallelGroup(Alignment.BASELINE).addComponent(lblVehicleId)
								.addComponent(textFieldVehicleID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelAddBus.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldPriceHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPricePerHour))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelAddBus.createParallelGroup(Alignment.BASELINE).addComponent(lblNumberOfSeats)
								.addComponent(textFieldNumberSeats, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelAddBus.createParallelGroup(Alignment.LEADING).addComponent(lblBusModeltype)
								.addComponent(rdbtnStandardBus))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnPartyBus)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnLuxuryBus)
						.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE).addComponent(labelAddBusBtn)
						.addContainerGap()));
		panelAddBus.setLayout(gl_panelAddBus);

		labelDeleteBusBtn = new JLabel("Delete Bus");
		labelDeleteBusBtn.setForeground(Color.WHITE);
		labelDeleteBusBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		labelDeleteBusBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(2, 2, 2, 2)));

		JScrollPane scrollPaneBusesArchive = new JScrollPane();
		scrollPaneBusesArchive.setOpaque(false);
		scrollPaneBusesArchive.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		scrollPaneBusesArchive.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Buses archive",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
				new EmptyBorder(5, 5, 5, 5)));
		scrollPaneBusesArchive.setBackground(new Color(95, 158, 160));

		lblShowFullDescription = new JLabel("Show Full Description");
		lblShowFullDescription.setForeground(Color.WHITE);
		lblShowFullDescription.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblShowFullDescription.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(2, 2, 2, 2)));

		JLabel lblSearchByVehicles = new JLabel("Search by Vehicle's ID:");
		lblSearchByVehicles.setForeground(Color.WHITE);
		lblSearchByVehicles.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		searchBusTextField = new JTextField();
		searchBusTextField.setBorder(new LineBorder(new Color(255, 255, 255)));
		searchBusTextField.setBackground(new Color(95, 158, 160));
		searchBusTextField.setColumns(10);
		GroupLayout gl_panelBuses = new GroupLayout(panelBuses);
		gl_panelBuses.setHorizontalGroup(gl_panelBuses.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBuses.createSequentialGroup()
						.addComponent(panelTopBuses, GroupLayout.DEFAULT_SIZE, 1369, Short.MAX_VALUE).addGap(0))
				.addGroup(gl_panelBuses.createSequentialGroup().addContainerGap()
						.addComponent(panelAddBus, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panelBuses.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelBuses.createSequentialGroup().addComponent(lblShowFullDescription)
										.addGap(50).addComponent(labelDeleteBusBtn))
								.addComponent(scrollPaneBusesArchive, GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
								.addGroup(gl_panelBuses.createSequentialGroup()
										.addComponent(lblSearchByVehicles, GroupLayout.PREFERRED_SIZE, 169,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(searchBusTextField,
												GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		gl_panelBuses.setVerticalGroup(gl_panelBuses.createParallelGroup(Alignment.LEADING).addGroup(gl_panelBuses
				.createSequentialGroup()
				.addComponent(panelTopBuses, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panelBuses.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBuses
								.createSequentialGroup().addGap(18).addGroup(gl_panelBuses
										.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSearchByVehicles, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(searchBusTextField, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPaneBusesArchive, GroupLayout.PREFERRED_SIZE, 290,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panelBuses.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblShowFullDescription, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(labelDeleteBusBtn))
								.addGap(10))
						.addGroup(gl_panelBuses.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelAddBus, GroupLayout.PREFERRED_SIZE, 378,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(428, Short.MAX_VALUE)));

		tableBuses = new JTable();
		tableBuses.setShowVerticalLines(false);
		tableBuses.setRowHeight(20);
		tableBuses.setSelectionForeground(new Color(255, 255, 255));
		tableBuses.setSelectionBackground(new Color(102, 205, 170));
		tableBuses.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Vehicle ID", "Price/hour",
				"Max # seats", "Earliest Departure", "Model type", "Available for Tours" }) {
			/**
			* 
			*/
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class,
					Boolean.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableBuses.setForeground(new Color(255, 255, 255));
		tableBuses.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tableBuses.setBackground(new Color(95, 158, 160));
		scrollPaneBusesArchive.setViewportView(tableBuses);
		panelBuses.setLayout(gl_panelBuses);

		panelTours = new JPanel();
		panelTours.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelTours, "name_6540542874877");

		JPanel panelTopTours = new JPanel();
		panelTopTours.setBackground(new Color(0, 128, 128));

		JLabel labelTours = new JLabel("Tours archive");
		labelTours.setForeground(Color.WHITE);
		labelTours.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopTours = new GroupLayout(panelTopTours);
		gl_panelTopTours.setHorizontalGroup(
				gl_panelTopTours.createParallelGroup(Alignment.LEADING).addGap(0, 1000, Short.MAX_VALUE)
						.addGroup(gl_panelTopTours.createSequentialGroup().addContainerGap()
								.addComponent(labelTours, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(748, Short.MAX_VALUE)));
		gl_panelTopTours
				.setVerticalGroup(gl_panelTopTours.createParallelGroup(Alignment.LEADING).addGap(0, 58, Short.MAX_VALUE)
						.addGroup(gl_panelTopTours.createSequentialGroup()
								.addComponent(labelTours, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelTopTours.setLayout(gl_panelTopTours);

		panelAddTour = new JPanel();
		panelAddTour.setForeground(new Color(255, 255, 255));
		panelAddTour.setBackground(new Color(95, 158, 160));
		panelAddTour
				.setBorder(new CompoundBorder(
						new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Add Tour",
								TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
						new EmptyBorder(3, 3, 3, 3)));

		JScrollPane scrollPaneToursArchive = new JScrollPane();
		scrollPaneToursArchive.setBackground(new Color(95, 158, 160));
		scrollPaneToursArchive.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Tours archive",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
				new EmptyBorder(3, 3, 3, 3)));

		lblDeleteTourBtn = new JLabel("Delete Tour");
		lblDeleteTourBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));
		lblDeleteTourBtn.setForeground(new Color(255, 255, 255));
		lblDeleteTourBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		lblUpdateTourButton = new JLabel("Update Tour");
		lblUpdateTourButton.setForeground(Color.WHITE);
		lblUpdateTourButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblUpdateTourButton.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));

		JLabel lblSearchByDestination_1 = new JLabel("Search by Destination:");
		lblSearchByDestination_1.setForeground(Color.WHITE);
		lblSearchByDestination_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		searchTourTExtField = new JTextField();
		searchTourTExtField.setBorder(new LineBorder(new Color(255, 255, 255)));
		searchTourTExtField.setBackground(new Color(95, 158, 160));
		searchTourTExtField.setColumns(10);
		GroupLayout gl_panelTours = new GroupLayout(panelTours);
		gl_panelTours
				.setHorizontalGroup(gl_panelTours.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTours.createSequentialGroup()
								.addComponent(panelTopTours, GroupLayout.DEFAULT_SIZE, 1520, Short.MAX_VALUE).addGap(0))
						.addGroup(gl_panelTours.createSequentialGroup().addContainerGap()
								.addComponent(panelAddTour, GroupLayout.PREFERRED_SIZE, 623,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelTours.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelTours.createSequentialGroup()
												.addComponent(lblUpdateTourButton, GroupLayout.PREFERRED_SIZE, 95,
														GroupLayout.PREFERRED_SIZE)
												.addGap(26).addComponent(lblDeleteTourBtn).addContainerGap())
										.addGroup(gl_panelTours.createSequentialGroup()
												.addComponent(scrollPaneToursArchive, GroupLayout.DEFAULT_SIZE, 630,
														Short.MAX_VALUE)
												.addGap(130))
										.addGroup(gl_panelTours.createSequentialGroup()
												.addComponent(lblSearchByDestination_1, GroupLayout.PREFERRED_SIZE, 169,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(searchTourTExtField, GroupLayout.PREFERRED_SIZE, 179,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap(525, Short.MAX_VALUE)))));
		gl_panelTours.setVerticalGroup(
				gl_panelTours.createParallelGroup(Alignment.LEADING).addGroup(gl_panelTours.createSequentialGroup()
						.addComponent(panelTopTours, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelTours
								.createParallelGroup(Alignment.LEADING).addGroup(gl_panelTours
										.createSequentialGroup().addGap(36)
										.addGroup(gl_panelTours.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblSearchByDestination_1, GroupLayout.PREFERRED_SIZE, 25,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(searchTourTExtField, GroupLayout.PREFERRED_SIZE, 23,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(scrollPaneToursArchive, GroupLayout.PREFERRED_SIZE, 301,
												GroupLayout.PREFERRED_SIZE)
										.addGap(13)
										.addGroup(gl_panelTours.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblUpdateTourButton, GroupLayout.PREFERRED_SIZE, 27,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDeleteTourBtn)))
								.addGroup(gl_panelTours.createSequentialGroup().addGap(26).addComponent(panelAddTour,
										GroupLayout.PREFERRED_SIZE, 491, GroupLayout.PREFERRED_SIZE)))
						.addGap(299)));

		tableTours = new JTable();
		tableTours.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Date", "Destination", "Pick up", "Seats Available", "Current Total Price",
						"Price Per Passenger", "Bus# / type", "Chauffeur", "Services" }) {
			/**
			* 
			*/
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTours.setBackground(new Color(95, 158, 160));
		tableTours.setSelectionBackground(new Color(102, 205, 170));
		tableTours.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tableTours.setForeground(new Color(255, 255, 255));
		scrollPaneToursArchive.setViewportView(tableTours);

		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setForeground(new Color(255, 255, 255));
		lblDestination.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldDestination = new JTextField();
		textFieldDestination.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldDestination.setSelectionColor(new Color(102, 205, 170));
		textFieldDestination.setSelectedTextColor(new Color(255, 255, 255));
		textFieldDestination.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldDestination.setBackground(new Color(95, 158, 160));
		textFieldDestination.setForeground(new Color(255, 255, 255));
		textFieldDestination.setColumns(10);

		lblAddPickUpBtn = new JLabel("Add");
		lblAddPickUpBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));
		lblAddPickUpBtn.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblAddPickUpBtn.setForeground(new Color(255, 255, 255));
		lblAddPickUpBtn.setBackground(new Color(95, 158, 160));

		textFieldAddPickup = new JTextField();
		textFieldAddPickup.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldAddPickup.setSelectionColor(new Color(102, 205, 170));
		textFieldAddPickup.setSelectedTextColor(new Color(255, 255, 255));
		textFieldAddPickup.setBorder(new LineBorder(new Color(255, 255, 255)));
		textFieldAddPickup.setForeground(new Color(255, 255, 255));
		textFieldAddPickup.setBackground(new Color(95, 158, 160));
		textFieldAddPickup.setColumns(10);

		lblStartDate = new JLabel("Start date:");
		lblStartDate.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblStartDate.setForeground(new Color(255, 255, 255));

		textFieldStartMonth = new JTextField();
		textFieldStartMonth.setSelectionColor(new Color(102, 205, 170));
		textFieldStartMonth.setSelectedTextColor(new Color(255, 255, 255));
		textFieldStartMonth.setBackground(new Color(95, 158, 160));
		textFieldStartMonth.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MM",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldStartMonth.setForeground(new Color(255, 255, 255));
		textFieldStartMonth.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldStartMonth.setColumns(10);

		textFieldStartDay = new JTextField();
		textFieldStartDay.setBackground(new Color(95, 158, 160));
		textFieldStartDay.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "DD",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldStartDay.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldStartDay.setForeground(new Color(255, 255, 255));
		textFieldStartDay.setColumns(10);

		textFieldStartYear = new JTextField();
		textFieldStartYear.setForeground(new Color(255, 255, 255));
		textFieldStartYear.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldStartYear.setBackground(new Color(95, 158, 160));
		textFieldStartYear.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldStartYear.setColumns(10);

		lblEndDate = new JLabel("End date:");
		lblEndDate.setForeground(new Color(255, 255, 255));
		lblEndDate.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldEndMonth = new JTextField();
		textFieldEndMonth.setForeground(new Color(255, 255, 255));
		textFieldEndMonth.setBackground(new Color(95, 158, 160));
		textFieldEndMonth.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MM",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldEndMonth.setColumns(10);

		textFieldEndDay = new JTextField();
		textFieldEndDay.setForeground(new Color(255, 255, 255));
		textFieldEndDay.setBackground(new Color(95, 158, 160));
		textFieldEndDay.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "DD", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldEndDay.setColumns(10);

		textFieldEndYear = new JTextField();
		textFieldEndYear.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldEndYear.setBackground(new Color(95, 158, 160));
		textFieldEndYear.setForeground(new Color(255, 255, 255));
		textFieldEndYear.setColumns(10);

		lblClearPickUpBtn = new JLabel("Clear");
		lblClearPickUpBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));
		lblClearPickUpBtn.setForeground(new Color(255, 255, 255));
		lblClearPickUpBtn.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		chckbxBreakfast = new JCheckBox("Breakfast");
		chckbxBreakfast.setForeground(new Color(255, 255, 255));
		chckbxBreakfast.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chckbxBreakfast.setBackground(new Color(95, 158, 160));

		chckbxLunch = new JCheckBox("Lunch");
		chckbxLunch.setBackground(new Color(95, 158, 160));
		chckbxLunch.setForeground(new Color(255, 255, 255));
		chckbxLunch.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		chckbxAllInclusive = new JCheckBox("All inclusive");
		chckbxAllInclusive.setForeground(new Color(255, 255, 255));
		chckbxAllInclusive.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chckbxAllInclusive.setBackground(new Color(95, 158, 160));

		chckbxEntranceTickets = new JCheckBox("Entrance tickets");
		chckbxEntranceTickets.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chckbxEntranceTickets.setBackground(new Color(95, 158, 160));
		chckbxEntranceTickets.setForeground(new Color(255, 255, 255));

		lblAddTourBtn = new JLabel("Add Tour");
		lblAddTourBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));
		lblAddTourBtn.setForeground(new Color(255, 255, 255));
		lblAddTourBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		scrollPanePickUps = new JScrollPane();
		scrollPanePickUps.setForeground(new Color(255, 255, 255));
		scrollPanePickUps.setBackground(new Color(95, 158, 160));
		scrollPanePickUps.setBorder(null);

		scrollPaneSelectBus = new JScrollPane();
		scrollPaneSelectBus.setBackground(new Color(95, 158, 160));
		scrollPaneSelectBus
				.setBorder(new CompoundBorder(
						new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Select bus",
								TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
						new EmptyBorder(3, 3, 3, 3)));

		scrollPaneSelectChauffeur = new JScrollPane();
		scrollPaneSelectChauffeur.setBackground(new Color(95, 158, 160));
		scrollPaneSelectChauffeur.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Select chauffeur",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
				new EmptyBorder(3, 3, 3, 3)));

		lblSearchForAvailableInToursPanel = new JLabel("Search");
		lblSearchForAvailableInToursPanel.setForeground(Color.WHITE);
		lblSearchForAvailableInToursPanel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblSearchForAvailableInToursPanel.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));

		textFieldStartHour = new JTextField();
		textFieldStartHour.setSelectionColor(new Color(102, 205, 170));
		textFieldStartHour.setSelectedTextColor(Color.WHITE);
		textFieldStartHour.setForeground(Color.WHITE);
		textFieldStartHour.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldStartHour.setColumns(10);
		textFieldStartHour.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "HH",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldStartHour.setBackground(new Color(95, 158, 160));

		textFieldStartMinute = new JTextField();
		textFieldStartMinute.setSelectionColor(new Color(102, 205, 170));
		textFieldStartMinute.setSelectedTextColor(Color.WHITE);
		textFieldStartMinute.setForeground(Color.WHITE);
		textFieldStartMinute.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldStartMinute.setColumns(10);
		textFieldStartMinute.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MIN",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldStartMinute.setBackground(new Color(95, 158, 160));

		textFieldEndHour = new JTextField();
		textFieldEndHour.setSelectionColor(new Color(102, 205, 170));
		textFieldEndHour.setSelectedTextColor(Color.WHITE);
		textFieldEndHour.setForeground(Color.WHITE);
		textFieldEndHour.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldEndHour.setColumns(10);
		textFieldEndHour.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "HH", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldEndHour.setBackground(new Color(95, 158, 160));

		textFieldEndMinute = new JTextField();
		textFieldEndMinute.setSelectionColor(new Color(102, 205, 170));
		textFieldEndMinute.setSelectedTextColor(Color.WHITE);
		textFieldEndMinute.setForeground(Color.WHITE);
		textFieldEndMinute.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldEndMinute.setColumns(10);
		textFieldEndMinute.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MIN",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		textFieldEndMinute.setBackground(new Color(95, 158, 160));

		JSeparator separator = new JSeparator();

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.WHITE);
		GroupLayout gl_panelAddTour = new GroupLayout(panelAddTour);
		gl_panelAddTour.setHorizontalGroup(gl_panelAddTour.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_panelAddTour.createSequentialGroup().addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAddTour.createSequentialGroup().addGap(212).addComponent(
								lblSearchForAvailableInToursPanel, GroupLayout.PREFERRED_SIZE, 57,
								GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelAddTour.createSequentialGroup().addContainerGap().addGroup(
								gl_panelAddTour.createParallelGroup(Alignment.LEADING, false).addGroup(gl_panelAddTour
										.createSequentialGroup().addComponent(scrollPaneSelectBus,
												GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE).addComponent(
												scrollPaneSelectChauffeur, GroupLayout.PREFERRED_SIZE, 275,
												GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_panelAddTour
														.createSequentialGroup().addGroup(gl_panelAddTour
																.createParallelGroup(Alignment.LEADING)
																.addGroup(
																		gl_panelAddTour
																				.createSequentialGroup()
																				.addComponent(chckbxBreakfast)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(chckbxLunch)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(chckbxAllInclusive)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(
																						chckbxEntranceTickets)
																				.addGap(133)
																				.addComponent(lblAddTourBtn))
																.addGroup(gl_panelAddTour.createSequentialGroup()
																		.addGap(12)
																		.addGroup(gl_panelAddTour
																				.createParallelGroup(Alignment.TRAILING)
																				.addGroup(gl_panelAddTour
																						.createSequentialGroup()
																						.addGroup(gl_panelAddTour
																								.createParallelGroup(
																										Alignment.LEADING)
																								.addComponent(
																										lblEndDate)
																								.addComponent(
																										lblStartDate))
																						.addGap(13)
																						.addGroup(gl_panelAddTour
																								.createParallelGroup(
																										Alignment.LEADING,
																										false)
																								.addComponent(
																										textFieldEndMonth,
																										0, 0,
																										Short.MAX_VALUE)
																								.addComponent(
																										textFieldStartMonth,
																										GroupLayout.PREFERRED_SIZE,
																										44,
																										GroupLayout.PREFERRED_SIZE))
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addGroup(gl_panelAddTour
																								.createParallelGroup(
																										Alignment.LEADING,
																										false)
																								.addComponent(
																										textFieldEndDay,
																										0, 0,
																										Short.MAX_VALUE)
																								.addComponent(
																										textFieldStartDay,
																										GroupLayout.PREFERRED_SIZE,
																										45,
																										GroupLayout.PREFERRED_SIZE))
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addGroup(gl_panelAddTour
																								.createParallelGroup(
																										Alignment.LEADING,
																										false)
																								.addComponent(
																										textFieldStartYear,
																										0, 0,
																										Short.MAX_VALUE)
																								.addComponent(
																										textFieldEndYear,
																										GroupLayout.PREFERRED_SIZE,
																										96,
																										GroupLayout.PREFERRED_SIZE)))
																				.addGroup(gl_panelAddTour
																						.createSequentialGroup()
																						.addComponent(lblDestination)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(
																								textFieldDestination,
																								193, 193, 193)
																						.addGap(6)))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(gl_panelAddTour
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(textFieldStartHour,
																						GroupLayout.PREFERRED_SIZE, 44,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(textFieldEndHour,
																						GroupLayout.PREFERRED_SIZE, 44,
																						GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addGroup(gl_panelAddTour
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(textFieldStartMinute,
																						GroupLayout.PREFERRED_SIZE, 44,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(textFieldEndMinute,
																						GroupLayout.PREFERRED_SIZE, 44,
																						GroupLayout.PREFERRED_SIZE))
																		.addGap(23)
																		.addComponent(separator_1,
																				GroupLayout.PREFERRED_SIZE, 5,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(gl_panelAddTour
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addComponent(scrollPanePickUps,
																						GroupLayout.DEFAULT_SIZE, 145,
																						Short.MAX_VALUE)
																				.addGroup(gl_panelAddTour
																						.createSequentialGroup()
																						.addComponent(lblAddPickUpBtn)
																						.addGap(18)
																						.addComponent(lblClearPickUpBtn,
																								GroupLayout.PREFERRED_SIZE,
																								40,
																								GroupLayout.PREFERRED_SIZE))
																				.addComponent(textFieldAddPickup))))
														.addPreferredGap(ComponentPlacement.RELATED, 0,
																Short.MAX_VALUE))
										.addComponent(separator, GroupLayout.PREFERRED_SIZE, 575,
												GroupLayout.PREFERRED_SIZE))))
						.addContainerGap()));
		gl_panelAddTour
				.setVerticalGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING).addGroup(gl_panelAddTour
						.createSequentialGroup().addGroup(gl_panelAddTour
								.createParallelGroup(Alignment.LEADING).addGroup(gl_panelAddTour
										.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelAddTour
												.createSequentialGroup().addGroup(gl_panelAddTour
														.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblDestination).addComponent(textFieldDestination,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panelAddTour.createParallelGroup(Alignment.BASELINE)
														.addComponent(textFieldStartMonth, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldStartDay, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldStartYear, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblStartDate)
														.addComponent(textFieldStartHour, GroupLayout.PREFERRED_SIZE,
																39, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldStartMinute, GroupLayout.PREFERRED_SIZE,
																39, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panelAddTour.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblEndDate).addGroup(
																gl_panelAddTour.createParallelGroup(Alignment.BASELINE)
																		.addComponent(textFieldEndMonth,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(textFieldEndDay,
																				GroupLayout.PREFERRED_SIZE, 39,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(textFieldEndYear,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(textFieldEndHour,
																				GroupLayout.PREFERRED_SIZE, 39,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(textFieldEndMinute,
																				GroupLayout.PREFERRED_SIZE, 39,
																				GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblSearchForAvailableInToursPanel,
														GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelAddTour.createSequentialGroup()
												.addComponent(scrollPanePickUps, GroupLayout.PREFERRED_SIZE, 123,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldAddPickup, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panelAddTour.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblAddPickUpBtn).addComponent(lblClearPickUpBtn,
																GroupLayout.PREFERRED_SIZE, 24,
																GroupLayout.PREFERRED_SIZE))))
								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelAddTour.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPaneSelectBus, GroupLayout.PREFERRED_SIZE, 191,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPaneSelectChauffeur, GroupLayout.PREFERRED_SIZE, 191,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelAddTour.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelAddTour.createParallelGroup(Alignment.BASELINE)
										.addComponent(chckbxBreakfast).addComponent(chckbxLunch)
										.addComponent(chckbxAllInclusive).addComponent(chckbxEntranceTickets))
								.addComponent(lblAddTourBtn, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		tableSelectChauffeur = new JTable();
		tableSelectChauffeur.setSelectionForeground(new Color(255, 255, 255));
		tableSelectChauffeur.setSelectionBackground(new Color(102, 205, 170));
		tableSelectChauffeur.setForeground(new Color(255, 255, 255));
		tableSelectChauffeur.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tableSelectChauffeur.setBackground(new Color(95, 158, 160));
		tableSelectChauffeur.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID#", "Name" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class };

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPaneSelectChauffeur.setViewportView(tableSelectChauffeur);

		tableSelectBus = new JTable();
		tableSelectBus.setBackground(new Color(95, 158, 160));
		tableSelectBus.setSelectionForeground(new Color(255, 255, 255));
		tableSelectBus.setSelectionBackground(new Color(102, 205, 170));
		tableSelectBus.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID#", "Type", "Seats" }) {

			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class };

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableSelectBus.setForeground(new Color(255, 255, 255));
		tableSelectBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		scrollPaneSelectBus.setViewportView(tableSelectBus);

		tablePickups = new JTable();
		tablePickups.setForeground(new Color(255, 255, 255));
		tablePickups.setOpaque(false);
		tablePickups.setSelectionForeground(new Color(255, 255, 255));
		tablePickups.setSelectionBackground(new Color(102, 205, 170));
		scrollPanePickUps.setViewportView(tablePickups);
		tablePickups.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Pick up stops" }) {

			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class };

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablePickups.setBackground(new Color(95, 158, 160));
		tablePickups.setBorder(null);
		panelAddTour.setLayout(gl_panelAddTour);
		panelTours.setLayout(gl_panelTours);

		panelCustomers = new JPanel();
		panelCustomers.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelCustomers, "name_6580052400446");

		JPanel panelTopCustomers = new JPanel();
		panelTopCustomers.setBackground(new Color(0, 128, 128));

		JLabel labelCustomers = new JLabel("Customers archive");
		labelCustomers.setForeground(Color.WHITE);
		labelCustomers.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopCustomers = new GroupLayout(panelTopCustomers);
		gl_panelTopCustomers.setHorizontalGroup(gl_panelTopCustomers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelTopCustomers.createSequentialGroup().addContainerGap()
						.addComponent(labelCustomers, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(748, Short.MAX_VALUE)));
		gl_panelTopCustomers.setVerticalGroup(gl_panelTopCustomers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
				.addGroup(gl_panelTopCustomers.createSequentialGroup()
						.addComponent(labelCustomers, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelTopCustomers.setLayout(gl_panelTopCustomers);

		JScrollPane scrollPaneCustomers = new JScrollPane();
		scrollPaneCustomers.setBackground(new Color(95, 158, 160));
		scrollPaneCustomers.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Customers archive",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
				new EmptyBorder(3, 3, 3, 3)));

		JPanel addNewCustomerPanel = new JPanel();
		addNewCustomerPanel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true),
				"Update Existing Customer", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		addNewCustomerPanel.setBackground(new Color(95, 158, 160));

		JLabel label_1 = new JLabel("Phone");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerPhone = new JTextField();
		customerPhone.setForeground(Color.WHITE);
		customerPhone.setColumns(10);
		customerPhone.setBackground(new Color(95, 158, 160));

		lblClearButtonCustomer = new JLabel("Cancel");
		lblClearButtonCustomer.setForeground(Color.WHITE);
		lblClearButtonCustomer.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblClearButtonCustomer.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		lblSaveChangesCustomerButton = new JLabel("Save");
		lblSaveChangesCustomerButton.setForeground(Color.WHITE);
		lblSaveChangesCustomerButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblSaveChangesCustomerButton.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));

		radioButtonCompany = new JRadioButton("Company");
		radioButtonCompany.setForeground(Color.WHITE);
		radioButtonCompany.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		radioButtonCompany.setBackground(new Color(95, 158, 160));

		radioButtonSchool = new JRadioButton("School");
		radioButtonSchool.setForeground(Color.WHITE);
		radioButtonSchool.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		radioButtonSchool.setBackground(new Color(95, 158, 160));

		radioButtonPrivate = new JRadioButton("Private");
		radioButtonPrivate.setForeground(Color.WHITE);
		radioButtonPrivate.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		radioButtonPrivate.setBackground(new Color(95, 158, 160));

		JLabel label_9 = new JLabel("Name/contact");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerName = new JTextField();
		customerName.setSelectionColor(new Color(102, 205, 170));
		customerName.setForeground(Color.WHITE);
		customerName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerName.setColumns(10);
		customerName.setBackground(new Color(95, 158, 160));

		JLabel customer = new JLabel("Name/organisation");
		customer.setForeground(Color.WHITE);
		customer.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerOrganisation = new JTextField();
		customerOrganisation.setSelectionColor(new Color(102, 205, 170));
		customerOrganisation.setForeground(Color.WHITE);
		customerOrganisation.setColumns(10);
		customerOrganisation.setBackground(new Color(95, 158, 160));

		JLabel label_11 = new JLabel("Email");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerEmail = new JTextField();
		customerEmail.setForeground(Color.WHITE);
		customerEmail.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerEmail.setColumns(10);
		customerEmail.setBackground(new Color(95, 158, 160));

		JLabel label_13 = new JLabel("Address");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerAddress = new JTextField();
		customerAddress.setSelectionColor(new Color(102, 205, 170));
		customerAddress.setForeground(Color.WHITE);
		customerAddress.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerAddress.setColumns(10);
		customerAddress.setBackground(new Color(95, 158, 160));

		JLabel label_16 = new JLabel("Birthday");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerMonth = new JTextField();
		customerMonth.setForeground(Color.WHITE);
		customerMonth.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerMonth.setColumns(10);
		customerMonth.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MM",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		customerMonth.setBackground(new Color(95, 158, 160));

		customerDay = new JTextField();
		customerDay.setForeground(Color.WHITE);
		customerDay.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerDay.setColumns(10);
		customerDay.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "DD",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		customerDay.setBackground(new Color(95, 158, 160));

		customerYear = new JTextField();
		customerYear.setForeground(Color.WHITE);
		customerYear.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerYear.setColumns(10);
		customerYear.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		customerYear.setBackground(new Color(95, 158, 160));

		lblDiscount = new JLabel("Discount");
		lblDiscount.setForeground(Color.WHITE);
		lblDiscount.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerDiscountUpdCustomerTextField = new JTextField();
		customerDiscountUpdCustomerTextField.setSelectionColor(new Color(102, 205, 170));
		customerDiscountUpdCustomerTextField.setForeground(Color.WHITE);
		customerDiscountUpdCustomerTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerDiscountUpdCustomerTextField.setColumns(10);
		customerDiscountUpdCustomerTextField.setBackground(new Color(95, 158, 160));

		dicount = new JLabel("Money spent");
		dicount.setForeground(Color.WHITE);
		dicount.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerMoneySpentTextField = new JTextField();
		customerMoneySpentTextField.setSelectionColor(new Color(102, 205, 170));
		customerMoneySpentTextField.setForeground(Color.WHITE);
		customerMoneySpentTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerMoneySpentTextField.setColumns(10);
		customerMoneySpentTextField.setBackground(new Color(95, 158, 160));
		GroupLayout gl_addNewCustomerPanel = new GroupLayout(addNewCustomerPanel);
		gl_addNewCustomerPanel.setHorizontalGroup(gl_addNewCustomerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addNewCustomerPanel.createSequentialGroup().addContainerGap().addGroup(
						gl_addNewCustomerPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_addNewCustomerPanel
								.createSequentialGroup()
								.addGroup(gl_addNewCustomerPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_addNewCustomerPanel.createSequentialGroup().addComponent(label_1)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(
														customerPhone, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
										.addGroup(gl_addNewCustomerPanel.createSequentialGroup()
												.addComponent(radioButtonCompany).addGap(18)
												.addComponent(radioButtonSchool).addGap(18)
												.addComponent(radioButtonPrivate))
										.addGroup(gl_addNewCustomerPanel.createSequentialGroup().addComponent(label_9)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(
														customerName, 172, 172, 172))
										.addGroup(gl_addNewCustomerPanel.createSequentialGroup().addComponent(customer)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(
														customerOrganisation, GroupLayout.PREFERRED_SIZE, 154,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_addNewCustomerPanel.createSequentialGroup().addComponent(label_11)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(customerEmail,
														238, 238, 238))
										.addGroup(gl_addNewCustomerPanel.createSequentialGroup().addComponent(label_13)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(
														customerAddress, GroupLayout.DEFAULT_SIZE, 215,
														Short.MAX_VALUE)))
								.addGap(14))
								.addGroup(gl_addNewCustomerPanel.createSequentialGroup()
										.addComponent(lblDiscount, GroupLayout.PREFERRED_SIZE, 62,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(customerDiscountUpdCustomerTextField, GroupLayout.PREFERRED_SIZE,
												209, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_addNewCustomerPanel.createSequentialGroup()
										.addComponent(lblClearButtonCustomer)
										.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
										.addComponent(lblSaveChangesCustomerButton, GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(
										gl_addNewCustomerPanel.createSequentialGroup().addComponent(label_16).addGap(18)
												.addComponent(customerMonth, GroupLayout.PREFERRED_SIZE, 47,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(customerDay, GroupLayout.PREFERRED_SIZE, 47,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(customerYear, GroupLayout.PREFERRED_SIZE, 92,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_addNewCustomerPanel.createSequentialGroup()
										.addComponent(dicount, GroupLayout.PREFERRED_SIZE, 77,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(customerMoneySpentTextField, GroupLayout.PREFERRED_SIZE, 187,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))));
		gl_addNewCustomerPanel.setVerticalGroup(gl_addNewCustomerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addNewCustomerPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_addNewCustomerPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
								.addComponent(customerPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_addNewCustomerPanel.createParallelGroup(Alignment.BASELINE).addComponent(customer)
								.addComponent(customerOrganisation, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_addNewCustomerPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(radioButtonCompany).addComponent(radioButtonSchool).addComponent(
										radioButtonPrivate))
						.addGap(18)
						.addGroup(gl_addNewCustomerPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_9)
								.addComponent(customerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_addNewCustomerPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_13)
								.addComponent(customerAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_addNewCustomerPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_11)
								.addComponent(customerEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(
								gl_addNewCustomerPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblDiscount)
										.addComponent(customerDiscountUpdCustomerTextField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_addNewCustomerPanel.createParallelGroup(Alignment.BASELINE).addComponent(dicount)
								.addComponent(customerMoneySpentTextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(52)
						.addGroup(gl_addNewCustomerPanel.createParallelGroup(Alignment.BASELINE).addComponent(label_16)
								.addComponent(customerMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(customerDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(customerYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_addNewCustomerPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblClearButtonCustomer).addComponent(lblSaveChangesCustomerButton))
						.addGap(24)));
		addNewCustomerPanel.setLayout(gl_addNewCustomerPanel);

		lblUpdateCustomerButton = new JLabel("Update");
		lblUpdateCustomerButton.setForeground(Color.WHITE);
		lblUpdateCustomerButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblUpdateCustomerButton.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		lblDeleteCustomerPanel = new JLabel("Delete");
		lblDeleteCustomerPanel.setForeground(Color.WHITE);
		lblDeleteCustomerPanel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblDeleteCustomerPanel.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		JLabel lblSearchByName_1 = new JLabel("Search by Name:");
		lblSearchByName_1.setForeground(Color.WHITE);
		lblSearchByName_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		searchCustomerInCustomerPanelTextField = new JTextField();
		searchCustomerInCustomerPanelTextField.setBackground(new Color(95, 158, 160));
		searchCustomerInCustomerPanelTextField.setBorder(new LineBorder(new Color(255, 255, 255)));
		searchCustomerInCustomerPanelTextField.setColumns(10);
		GroupLayout gl_panelCustomers = new GroupLayout(panelCustomers);
		gl_panelCustomers.setHorizontalGroup(gl_panelCustomers.createParallelGroup(
				Alignment.TRAILING)
				.addGroup(gl_panelCustomers.createSequentialGroup().addGroup(gl_panelCustomers
						.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelCustomers.createSequentialGroup()
								.addGap(8).addComponent(addNewCustomerPanel, GroupLayout.PREFERRED_SIZE, 310,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										ComponentPlacement.UNRELATED)
								.addGroup(gl_panelCustomers.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelCustomers.createSequentialGroup().addGroup(gl_panelCustomers
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelCustomers.createSequentialGroup()
														.addComponent(lblUpdateCustomerButton,
																GroupLayout.PREFERRED_SIZE, 65,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 887,
																Short.MAX_VALUE)
														.addComponent(lblDeleteCustomerPanel,
																GroupLayout.PREFERRED_SIZE, 57,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(scrollPaneCustomers, GroupLayout.DEFAULT_SIZE, 1009,
														Short.MAX_VALUE))
												.addGap(30))
										.addGroup(gl_panelCustomers.createSequentialGroup()
												.addComponent(lblSearchByName_1)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(searchCustomerInCustomerPanelTextField,
														GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))))
						.addComponent(panelTopCustomers, GroupLayout.DEFAULT_SIZE, 1369, Short.MAX_VALUE)).addGap(0)));
		gl_panelCustomers
				.setVerticalGroup(gl_panelCustomers.createParallelGroup(Alignment.LEADING).addGroup(gl_panelCustomers
						.createSequentialGroup().addComponent(panelTopCustomers, GroupLayout.PREFERRED_SIZE, 58,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelCustomers.createParallelGroup(Alignment.LEADING).addGroup(gl_panelCustomers
								.createSequentialGroup().addGap(28)
								.addGroup(gl_panelCustomers.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSearchByName_1, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(searchCustomerInCustomerPanelTextField,
												GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPaneCustomers, GroupLayout.PREFERRED_SIZE, 343,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelCustomers.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblUpdateCustomerButton, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDeleteCustomerPanel, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelCustomers.createSequentialGroup().addGap(18).addComponent(
										addNewCustomerPanel, GroupLayout.PREFERRED_SIZE, 475,
										GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(323, Short.MAX_VALUE)));

		tableCustomers = new JTable();
		tableCustomers.setShowVerticalLines(false);
		tableCustomers.setBackground(new Color(95, 158, 160));
		tableCustomers.setForeground(new Color(255, 255, 255));
		tableCustomers.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tableCustomers.setSelectionBackground(new Color(102, 205, 170));
		tableCustomers.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Organisation name", "Type",
				"Phone", "Name", "Address", "E-mail", "Birthday", "Money Spent", "Discount" }) {
			/**
			* 
			*/
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPaneCustomers.setViewportView(tableCustomers);
		panelCustomers.setLayout(gl_panelCustomers);

		panelPassengers = new JPanel();
		panelPassengers.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelPassengers, "name_7387082934835");

		JPanel panelTopPassengers = new JPanel();
		panelTopPassengers.setBackground(new Color(0, 128, 128));

		JLabel labelPassengers = new JLabel("Passengers archive");
		labelPassengers.setForeground(Color.WHITE);
		labelPassengers.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopPassengers = new GroupLayout(panelTopPassengers);
		gl_panelTopPassengers.setHorizontalGroup(gl_panelTopPassengers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panelTopPassengers.createSequentialGroup().addContainerGap()
						.addComponent(labelPassengers, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(748, Short.MAX_VALUE)));
		gl_panelTopPassengers.setVerticalGroup(gl_panelTopPassengers.createParallelGroup(Alignment.LEADING)
				.addGap(0, 58, Short.MAX_VALUE)
				.addGroup(gl_panelTopPassengers.createSequentialGroup()
						.addComponent(labelPassengers, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelTopPassengers.setLayout(gl_panelTopPassengers);

		scrollPanePassengers = new JScrollPane();
		scrollPanePassengers.setBackground(new Color(95, 158, 160));
		scrollPanePassengers.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Passengers archive",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
				new EmptyBorder(3, 3, 3, 3)));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Update Existing Passenger",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBackground(new Color(95, 158, 160));

		lblClearPassengerButton = new JLabel("Cancel");
		lblClearPassengerButton.setForeground(Color.WHITE);
		lblClearPassengerButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblClearPassengerButton.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		lblAddNewPassengerButton = new JLabel("Save Changes");
		lblAddNewPassengerButton.setForeground(Color.WHITE);
		lblAddNewPassengerButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblAddNewPassengerButton.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		JLabel label_10 = new JLabel("Address");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel label_17 = new JLabel("Email");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		passengerEmail = new JTextField();
		passengerEmail.setSelectionColor(new Color(102, 205, 170));
		passengerEmail.setForeground(Color.WHITE);
		passengerEmail.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerEmail.setColumns(10);
		passengerEmail.setBackground(new Color(95, 158, 160));

		passengerAddress = new JTextField();
		passengerAddress.setSelectionColor(new Color(102, 205, 170));
		passengerAddress.setForeground(Color.WHITE);
		passengerAddress.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerAddress.setColumns(10);
		passengerAddress.setBackground(new Color(95, 158, 160));

		JLabel label_18 = new JLabel("Phone");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel label_20 = new JLabel("Name");
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		passengerPhone = new JTextField();
		passengerPhone.setSelectionColor(new Color(102, 205, 170));
		passengerPhone.setForeground(Color.WHITE);
		passengerPhone.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerPhone.setColumns(10);
		passengerPhone.setBackground(new Color(95, 158, 160));

		passengerName = new JTextField();
		passengerName.setSelectionColor(new Color(102, 205, 170));
		passengerName.setForeground(Color.WHITE);
		passengerName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerName.setColumns(10);
		passengerName.setBackground(new Color(95, 158, 160));

		JLabel label_22 = new JLabel("Birthday");
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		passengerMonth = new JTextField();
		passengerMonth.setForeground(Color.WHITE);
		passengerMonth.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerMonth.setColumns(10);
		passengerMonth.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MM",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		passengerMonth.setBackground(new Color(95, 158, 160));

		passengerDay = new JTextField();
		passengerDay.setForeground(Color.WHITE);
		passengerDay.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerDay.setColumns(10);
		passengerDay.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "DD",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		passengerDay.setBackground(new Color(95, 158, 160));

		passengerYear = new JTextField();
		passengerYear.setForeground(Color.WHITE);
		passengerYear.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerYear.setColumns(10);
		passengerYear.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		passengerYear.setBackground(new Color(95, 158, 160));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(
						gl_panel_1
								.createSequentialGroup().addGroup(gl_panel_1
										.createParallelGroup(Alignment.LEADING, false).addGroup(gl_panel_1
												.createSequentialGroup().addContainerGap().addGroup(gl_panel_1
														.createParallelGroup(Alignment.LEADING,
																false)
														.addGroup(gl_panel_1.createSequentialGroup()
																.addGroup(gl_panel_1
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(label_10).addComponent(label_17))
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addGroup(gl_panel_1
																		.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(passengerEmail,
																				GroupLayout.PREFERRED_SIZE, 172,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(passengerAddress,
																				GroupLayout.PREFERRED_SIZE, 172,
																				GroupLayout.PREFERRED_SIZE)))
														.addGroup(gl_panel_1.createSequentialGroup()
																.addGroup(gl_panel_1
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(label_18).addComponent(label_20))
																.addGap(18)
																.addGroup(gl_panel_1
																		.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(passengerPhone).addComponent(
																				passengerName, GroupLayout.DEFAULT_SIZE,
																				176, Short.MAX_VALUE)))))
										.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_1.createSequentialGroup().addGap(13)
														.addComponent(label_22)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(passengerMonth, GroupLayout.PREFERRED_SIZE, 46,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
														.addComponent(lblClearPassengerButton)))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(lblAddNewPassengerButton,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(gl_panel_1.createSequentialGroup()
																.addComponent(passengerDay, GroupLayout.PREFERRED_SIZE,
																		44, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(passengerYear, GroupLayout.PREFERRED_SIZE,
																		52, GroupLayout.PREFERRED_SIZE)))))
								.addGap(13)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(22)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_18).addComponent(
						passengerPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_20).addComponent(
						passengerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_10).addComponent(
						passengerAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_17).addComponent(
						passengerEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(16)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_22)
						.addComponent(passengerMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(passengerDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(passengerYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblAddNewPassengerButton)
						.addComponent(lblClearPassengerButton))
				.addContainerGap()));
		panel_1.setLayout(gl_panel_1);

		lblUpdatePassengerButton = new JLabel("Update");
		lblUpdatePassengerButton.setForeground(Color.WHITE);
		lblUpdatePassengerButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblUpdatePassengerButton.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		lblDeletePassengerButton = new JLabel("Delete");
		lblDeletePassengerButton.setForeground(Color.WHITE);
		lblDeletePassengerButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblDeletePassengerButton.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		JLabel label_2 = new JLabel("Search by Name:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		searchPassengerTextField = new JTextField();
		searchPassengerTextField.setBackground(new Color(95, 158, 160));
		searchPassengerTextField.setBorder(new LineBorder(new Color(255, 255, 255)));
		searchPassengerTextField.setColumns(10);
		GroupLayout gl_panelPassengers = new GroupLayout(panelPassengers);
		gl_panelPassengers
				.setHorizontalGroup(
						gl_panelPassengers.createParallelGroup(Alignment.LEADING).addGroup(gl_panelPassengers
								.createSequentialGroup().addGroup(
										gl_panelPassengers.createParallelGroup(Alignment.TRAILING)
												.addComponent(panelTopPassengers, GroupLayout.DEFAULT_SIZE, 1371,
														Short.MAX_VALUE)
												.addGroup(gl_panelPassengers.createSequentialGroup().addContainerGap()
														.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 271,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_panelPassengers
																.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panelPassengers.createSequentialGroup()
																		.addGroup(gl_panelPassengers
																				.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_panelPassengers
																						.createSequentialGroup()
																						.addComponent(
																								lblUpdatePassengerButton)
																						.addPreferredGap(
																								ComponentPlacement.RELATED,
																								931, Short.MAX_VALUE)
																						.addComponent(
																								lblDeletePassengerButton))
																				.addComponent(scrollPanePassengers,
																						GroupLayout.DEFAULT_SIZE, 1053,
																						Short.MAX_VALUE))
																		.addGap(31))
																.addGroup(gl_panelPassengers.createSequentialGroup()
																		.addComponent(label_2,
																				GroupLayout.PREFERRED_SIZE, 126,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(searchPassengerTextField,
																				GroupLayout.PREFERRED_SIZE, 179,
																				GroupLayout.PREFERRED_SIZE)))))
								.addGap(0)));
		gl_panelPassengers.setVerticalGroup(gl_panelPassengers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPassengers.createSequentialGroup()
						.addComponent(panelTopPassengers, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelPassengers.createParallelGroup(Alignment.LEADING).addGroup(gl_panelPassengers
								.createSequentialGroup().addGap(26)
								.addGroup(gl_panelPassengers.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(searchPassengerTextField, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPanePassengers, GroupLayout.PREFERRED_SIZE, 255,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelPassengers.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblUpdatePassengerButton, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDeletePassengerButton, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelPassengers.createSequentialGroup().addGap(18).addComponent(panel_1,
										GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(479, Short.MAX_VALUE)));

		tablePassengers = new JTable() {
			/**
			* 
			*/
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return true;
			}
		};
		tablePassengers.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Name", "Address", "Phone", "E-mail", "Birthday" }) {
			/**
			* 
			*/
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablePassengers.setShowVerticalLines(false);
		tablePassengers.setSelectionBackground(new Color(102, 205, 170));
		tablePassengers.setForeground(new Color(255, 255, 255));
		tablePassengers.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tablePassengers.setBackground(new Color(95, 158, 160));
		scrollPanePassengers.setViewportView(tablePassengers);
		panelPassengers.setLayout(gl_panelPassengers);

		panelNewTourReservation = new JPanel();
		panelNewTourReservation.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelNewTourReservation.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelNewTourReservation, "name_7800006522332");

		JPanel panelTopNewTourReservation = new JPanel();
		panelTopNewTourReservation.setBackground(new Color(0, 128, 128));

		JLabel labelNewTourReservation = new JLabel("New Tour reservation");
		labelNewTourReservation.setForeground(Color.WHITE);
		labelNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopNewTourReservation = new GroupLayout(panelTopNewTourReservation);
		gl_panelTopNewTourReservation
				.setHorizontalGroup(gl_panelTopNewTourReservation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTopNewTourReservation
								.createSequentialGroup().addContainerGap().addComponent(labelNewTourReservation,
										GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(1117, Short.MAX_VALUE)));
		gl_panelTopNewTourReservation
				.setVerticalGroup(gl_panelTopNewTourReservation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTopNewTourReservation.createSequentialGroup()
								.addComponent(labelNewTourReservation, GroupLayout.PREFERRED_SIZE, 51,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelTopNewTourReservation.setLayout(gl_panelTopNewTourReservation);

		JTabbedPane newTourReservationTabbedPanel = new JTabbedPane(JTabbedPane.TOP);

		lblCreateReservationButton = new JLabel("Create reservation");
		lblCreateReservationButton.setForeground(Color.WHITE);
		lblCreateReservationButton.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblCreateReservationButton.setBorder(new LineBorder(new Color(255, 255, 255), 2));

		JPanel addNewCustomerInNewTourReservation = new JPanel();
		addNewCustomerInNewTourReservation.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true),
				"Add New Customer", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		addNewCustomerInNewTourReservation.setBackground(new Color(95, 158, 160));

		JLabel label = new JLabel("Phone");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		lblPhoneInNewTourReservationtextField = new JTextField();
		lblPhoneInNewTourReservationtextField.setForeground(Color.WHITE);
		lblPhoneInNewTourReservationtextField.setColumns(10);
		lblPhoneInNewTourReservationtextField.setBackground(new Color(95, 158, 160));

		lblAddCusomerButtonNewTourReservation = new JLabel("Add");
		lblAddCusomerButtonNewTourReservation.setForeground(Color.WHITE);
		lblAddCusomerButtonNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		lblAddCusomerButtonNewTourReservation.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));

		lblClearCustomerButtonNewTourReservation = new JLabel("Clear");
		lblClearCustomerButtonNewTourReservation.setForeground(Color.WHITE);
		lblClearCustomerButtonNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblClearCustomerButtonNewTourReservation.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		boxIsAPassengerNewTourReservation = new JCheckBox("is a passenger");
		boxIsAPassengerNewTourReservation.setForeground(Color.WHITE);
		boxIsAPassengerNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		boxIsAPassengerNewTourReservation.setBackground(new Color(95, 158, 160));

		radioButtonIsCompanyNewTourReservation = new JRadioButton("Company");
		radioButtonIsCompanyNewTourReservation.setForeground(Color.WHITE);
		radioButtonIsCompanyNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		radioButtonIsCompanyNewTourReservation.setBackground(new Color(95, 158, 160));

		radioButtonIsSchoolNewTourReservation = new JRadioButton("School");
		radioButtonIsSchoolNewTourReservation.setForeground(Color.WHITE);
		radioButtonIsSchoolNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		radioButtonIsSchoolNewTourReservation.setBackground(new Color(95, 158, 160));

		radioButtonIsPrivateInNewTourReservation = new JRadioButton("Private");
		radioButtonIsPrivateInNewTourReservation.setForeground(Color.WHITE);
		radioButtonIsPrivateInNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		radioButtonIsPrivateInNewTourReservation.setBackground(new Color(95, 158, 160));

		JLabel lblCustomerNameNewTourReservation = new JLabel("Name/contact");
		lblCustomerNameNewTourReservation.setForeground(Color.WHITE);
		lblCustomerNameNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerNameNewTourReservationTextField = new JTextField();
		customerNameNewTourReservationTextField.setSelectionColor(new Color(102, 205, 170));
		customerNameNewTourReservationTextField.setForeground(Color.WHITE);
		customerNameNewTourReservationTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerNameNewTourReservationTextField.setColumns(10);
		customerNameNewTourReservationTextField.setBackground(new Color(95, 158, 160));

		JLabel label_4 = new JLabel("Name/organisation");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerOrganisationtextField = new JTextField();
		customerOrganisationtextField.setSelectionColor(new Color(102, 205, 170));
		customerOrganisationtextField.setForeground(Color.WHITE);
		customerOrganisationtextField.setColumns(10);
		customerOrganisationtextField.setBackground(new Color(95, 158, 160));

		JLabel lblcustomerEmailNewTourReservation = new JLabel("Email");
		lblcustomerEmailNewTourReservation.setForeground(Color.WHITE);
		lblcustomerEmailNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerEmailNewTourReservationtextField = new JTextField();
		customerEmailNewTourReservationtextField.setForeground(Color.WHITE);
		customerEmailNewTourReservationtextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerEmailNewTourReservationtextField.setColumns(10);
		customerEmailNewTourReservationtextField.setBackground(new Color(95, 158, 160));

		JLabel label_6 = new JLabel("Address");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerAddressIncustomerEmailNewTourReservationTextField = new JTextField();
		customerAddressIncustomerEmailNewTourReservationTextField.setSelectionColor(new Color(102, 205, 170));
		customerAddressIncustomerEmailNewTourReservationTextField.setForeground(Color.WHITE);
		customerAddressIncustomerEmailNewTourReservationTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerAddressIncustomerEmailNewTourReservationTextField.setColumns(10);
		customerAddressIncustomerEmailNewTourReservationTextField.setBackground(new Color(95, 158, 160));

		JLabel label_7 = new JLabel("Birthday");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		customerMonthInNewTourReservationTextField = new JTextField();
		customerMonthInNewTourReservationTextField.setForeground(Color.WHITE);
		customerMonthInNewTourReservationTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerMonthInNewTourReservationTextField.setColumns(10);
		customerMonthInNewTourReservationTextField.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MM", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		customerMonthInNewTourReservationTextField.setBackground(new Color(95, 158, 160));

		customerDayInNewTourReservationTextField = new JTextField();
		customerDayInNewTourReservationTextField.setForeground(Color.WHITE);
		customerDayInNewTourReservationTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerDayInNewTourReservationTextField.setColumns(10);
		customerDayInNewTourReservationTextField.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "DD", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		customerDayInNewTourReservationTextField.setBackground(new Color(95, 158, 160));

		customerYearInNewTourReservationTextField = new JTextField();
		customerYearInNewTourReservationTextField.setForeground(Color.WHITE);
		customerYearInNewTourReservationTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		customerYearInNewTourReservationTextField.setColumns(10);
		customerYearInNewTourReservationTextField
				.setBorder(
						new CompoundBorder(
								new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY", TitledBorder.CENTER,
										TitledBorder.TOP, null, new Color(255, 255, 255)),
								new EmptyBorder(2, 2, 2, 2)));
		customerYearInNewTourReservationTextField.setBackground(new Color(95, 158, 160));
		GroupLayout gl_addNewCustomerInNewTourReservation = new GroupLayout(addNewCustomerInNewTourReservation);
		gl_addNewCustomerInNewTourReservation
				.setHorizontalGroup(gl_addNewCustomerInNewTourReservation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addNewCustomerInNewTourReservation.createSequentialGroup().addContainerGap()
								.addGroup(gl_addNewCustomerInNewTourReservation.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_addNewCustomerInNewTourReservation.createSequentialGroup()
												.addComponent(label).addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblPhoneInNewTourReservationtextField,
														GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
										.addGroup(gl_addNewCustomerInNewTourReservation.createSequentialGroup()
												.addComponent(lblClearCustomerButtonNewTourReservation).addGap(30)
												.addComponent(boxIsAPassengerNewTourReservation)
												.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
												.addComponent(lblAddCusomerButtonNewTourReservation))
										.addGroup(gl_addNewCustomerInNewTourReservation.createSequentialGroup()
												.addComponent(radioButtonIsCompanyNewTourReservation).addGap(18)
												.addComponent(radioButtonIsSchoolNewTourReservation).addGap(18)
												.addComponent(radioButtonIsPrivateInNewTourReservation))
										.addGroup(gl_addNewCustomerInNewTourReservation.createSequentialGroup()
												.addComponent(lblCustomerNameNewTourReservation)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(customerNameNewTourReservationTextField, 172, 172, 172))
										.addGroup(gl_addNewCustomerInNewTourReservation.createSequentialGroup()
												.addComponent(label_4).addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(customerOrganisationtextField, GroupLayout.PREFERRED_SIZE,
														154, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_addNewCustomerInNewTourReservation.createSequentialGroup()
												.addComponent(lblcustomerEmailNewTourReservation)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(customerEmailNewTourReservationtextField, 238, 238, 238))
										.addGroup(gl_addNewCustomerInNewTourReservation.createSequentialGroup()
												.addComponent(label_6).addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(customerAddressIncustomerEmailNewTourReservationTextField,
														GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
										.addGroup(gl_addNewCustomerInNewTourReservation.createSequentialGroup()
												.addComponent(label_7).addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(customerMonthInNewTourReservationTextField,
														GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(customerDayInNewTourReservationTextField,
														GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(customerYearInNewTourReservationTextField, 0,
														0, Short.MAX_VALUE)))
								.addGap(31)));
		gl_addNewCustomerInNewTourReservation
				.setVerticalGroup(gl_addNewCustomerInNewTourReservation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addNewCustomerInNewTourReservation.createSequentialGroup().addContainerGap()
								.addGroup(gl_addNewCustomerInNewTourReservation.createParallelGroup(Alignment.BASELINE)
										.addComponent(label).addComponent(lblPhoneInNewTourReservationtextField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_addNewCustomerInNewTourReservation.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_4).addComponent(customerOrganisationtextField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_addNewCustomerInNewTourReservation.createParallelGroup(Alignment.BASELINE)
										.addComponent(radioButtonIsCompanyNewTourReservation)
										.addComponent(radioButtonIsSchoolNewTourReservation)
										.addComponent(radioButtonIsPrivateInNewTourReservation))
								.addGap(18)
								.addGroup(gl_addNewCustomerInNewTourReservation.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCustomerNameNewTourReservation).addComponent(
												customerNameNewTourReservationTextField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_addNewCustomerInNewTourReservation.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_6)
										.addComponent(customerAddressIncustomerEmailNewTourReservationTextField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_addNewCustomerInNewTourReservation.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblcustomerEmailNewTourReservation)
										.addComponent(customerEmailNewTourReservationtextField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_addNewCustomerInNewTourReservation.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_7)
										.addComponent(
												customerMonthInNewTourReservationTextField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(customerDayInNewTourReservationTextField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(customerYearInNewTourReservationTextField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_addNewCustomerInNewTourReservation.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_addNewCustomerInNewTourReservation
												.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblClearCustomerButtonNewTourReservation)
												.addComponent(boxIsAPassengerNewTourReservation))
										.addComponent(lblAddCusomerButtonNewTourReservation, GroupLayout.PREFERRED_SIZE,
												40, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(14, Short.MAX_VALUE)));
		addNewCustomerInNewTourReservation.setLayout(gl_addNewCustomerInNewTourReservation);

		summaryPanel = new JPanel();
		summaryPanel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Summary", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)), null));
		summaryPanel.setBackground(new Color(95, 158, 160));

		lblCancelButtonInNewTourReservation = new JLabel("Cancel");
		lblCancelButtonInNewTourReservation.setForeground(Color.WHITE);
		lblCancelButtonInNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCancelButtonInNewTourReservation.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		GroupLayout gl_panelNewTourReservation = new GroupLayout(panelNewTourReservation);
		gl_panelNewTourReservation.setHorizontalGroup(
				gl_panelNewTourReservation.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelNewTourReservation
						.createSequentialGroup().addComponent(panelTopNewTourReservation, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(0))
						.addGroup(gl_panelNewTourReservation.createSequentialGroup().addContainerGap()
								.addGroup(gl_panelNewTourReservation.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCancelButtonInNewTourReservation, GroupLayout.PREFERRED_SIZE,
												63, GroupLayout.PREFERRED_SIZE)
										.addComponent(addNewCustomerInNewTourReservation, GroupLayout.PREFERRED_SIZE,
												327, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelNewTourReservation.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelNewTourReservation.createSequentialGroup().addGap(18)
												.addComponent(newTourReservationTabbedPanel, GroupLayout.PREFERRED_SIZE,
														642, Short.MAX_VALUE)
												.addGap(18).addComponent(summaryPanel, GroupLayout.DEFAULT_SIZE, 288,
														Short.MAX_VALUE))
										.addGroup(Alignment.TRAILING, gl_panelNewTourReservation.createSequentialGroup()
												.addGap(842).addComponent(lblCreateReservationButton)))
								.addGap(64)));
		gl_panelNewTourReservation.setVerticalGroup(gl_panelNewTourReservation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNewTourReservation.createSequentialGroup()
						.addComponent(panelTopNewTourReservation, GroupLayout.PREFERRED_SIZE, 58,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelNewTourReservation.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panelNewTourReservation.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panelNewTourReservation.createParallelGroup(Alignment.LEADING)
												.addComponent(newTourReservationTabbedPanel,
														GroupLayout.PREFERRED_SIZE, 439, GroupLayout.PREFERRED_SIZE)
												.addComponent(addNewCustomerInNewTourReservation, Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelNewTourReservation.createSequentialGroup().addGap(30).addComponent(
										summaryPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)))
						.addGap(30)
						.addGroup(gl_panelNewTourReservation.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblCreateReservationButton, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCancelButtonInNewTourReservation, GroupLayout.DEFAULT_SIZE, 31,
										Short.MAX_VALUE))
						.addGap(104)));

		lblSelectedTour = new JLabel("");
		lblSelectedTour.setVerticalAlignment(SwingConstants.TOP);
		lblSelectedTour.setForeground(Color.WHITE);
		lblSelectedTour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectedTour.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Selected Tour",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));

		lblSelectedCustomer = new JLabel("");
		lblSelectedCustomer.setVerticalAlignment(SwingConstants.TOP);
		lblSelectedCustomer.setForeground(Color.WHITE);
		lblSelectedCustomer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectedCustomer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Selected Customer",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_summaryPanel = new GroupLayout(summaryPanel);
		gl_summaryPanel.setHorizontalGroup(gl_summaryPanel.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_summaryPanel.createSequentialGroup().addContainerGap().addGroup(gl_summaryPanel
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
						.addComponent(lblSelectedTour, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252,
								Short.MAX_VALUE)
						.addComponent(lblSelectedCustomer, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252,
								Short.MAX_VALUE))
						.addContainerGap()));
		gl_summaryPanel.setVerticalGroup(gl_summaryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_summaryPanel.createSequentialGroup().addGap(5)
						.addComponent(lblSelectedTour, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblSelectedCustomer, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addContainerGap()));

		lblSelectedPassengers = new JList<String>();
		lblSelectedPassengers.setModel(new DefaultListModel<String>());
		lblSelectedPassengers.setForeground(Color.WHITE);
		lblSelectedPassengers.setBorder(new TitledBorder(null, "Selected Passengers", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(255, 255, 255)));
		lblSelectedPassengers.setBackground(new Color(95, 158, 160));
		scrollPane.setViewportView(lblSelectedPassengers);
		summaryPanel.setLayout(gl_summaryPanel);

		JPanel selectCustomerPanel = new JPanel();
		selectCustomerPanel.setBackground(new Color(95, 158, 160));
		newTourReservationTabbedPanel.addTab("Select Customer", null, selectCustomerPanel, null);
		newTourReservationTabbedPanel.setForegroundAt(0, new Color(0, 153, 102));

		searchCustomerTextField = new JTextField();
		searchCustomerTextField.setBackground(new Color(95, 158, 160));
		searchCustomerTextField.setBorder(new LineBorder(new Color(255, 255, 255)));
		searchCustomerTextField.setToolTipText("enter customer's name here");
		/* searchCustomerTextField.setColumns(10); */

		lblSearchCustomerByName = new JLabel("Search by name:");
		lblSearchCustomerByName.setForeground(Color.WHITE);
		lblSearchCustomerByName.setFont(new Font("Century Gothic", Font.PLAIN, 13));

		JScrollPane selectCustomersInNewTourReservationScrollPane = new JScrollPane();
		selectCustomersInNewTourReservationScrollPane.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Customers archive",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
				new EmptyBorder(3, 3, 3, 3)));
		selectCustomersInNewTourReservationScrollPane.setBackground(new Color(95, 158, 160));

		lblSelectCustomerButtonInNewTourRes = new JLabel("Select");
		lblSelectCustomerButtonInNewTourRes.setForeground(Color.WHITE);
		lblSelectCustomerButtonInNewTourRes.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblSelectCustomerButtonInNewTourRes.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		GroupLayout gl_selectCustomerPanel = new GroupLayout(selectCustomerPanel);
		gl_selectCustomerPanel.setHorizontalGroup(gl_selectCustomerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectCustomerPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_selectCustomerPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(selectCustomersInNewTourReservationScrollPane, Alignment.TRAILING,
										GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
								.addGroup(gl_selectCustomerPanel.createSequentialGroup()
										.addComponent(lblSearchCustomerByName, GroupLayout.PREFERRED_SIZE, 113,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(searchCustomerTextField, GroupLayout.PREFERRED_SIZE, 166,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lblSelectCustomerButtonInNewTourRes))
						.addContainerGap()));
		gl_selectCustomerPanel.setVerticalGroup(gl_selectCustomerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectCustomerPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_selectCustomerPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSearchCustomerByName, GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(searchCustomerTextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(27)
						.addComponent(selectCustomersInNewTourReservationScrollPane, GroupLayout.PREFERRED_SIZE, 236,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblSelectCustomerButtonInNewTourRes,
								GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(66, Short.MAX_VALUE)));

		customersTableInNewTourReservation = new JTable();
		customersTableInNewTourReservation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		customersTableInNewTourReservation.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Organisation", "Type", "Phone", "Name", "Address", "Email", "Birthday", "Money spent", "Discount" }) {
			/**
			  * 
			  */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		selectCustomersInNewTourReservationScrollPane.setViewportView(customersTableInNewTourReservation);
		selectCustomerPanel.setLayout(gl_selectCustomerPanel);

		JPanel selectPassengersPanel = new JPanel();
		selectPassengersPanel.setBackground(new Color(95, 158, 160));
		newTourReservationTabbedPanel.addTab("Select Passengers", null, selectPassengersPanel, null);
		newTourReservationTabbedPanel.setForegroundAt(1, new Color(0, 153, 102));

		JScrollPane selectPassengersScrollPanelInNewTourReservation = new JScrollPane();
		selectPassengersScrollPanelInNewTourReservation.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "List of Selected Passengers",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
				new EmptyBorder(3, 3, 3, 3)));
		selectPassengersScrollPanelInNewTourReservation.setBackground(new Color(95, 158, 160));

		addNewPassengerInNewTourReservationPanel = new JPanel();
		addNewPassengerInNewTourReservationPanel
				.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true),
						"Add passenger", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), null));
		addNewPassengerInNewTourReservationPanel.setBackground(new Color(95, 158, 160));

		lblClearButtonPassengerInNewTourReservation = new JLabel("Clear");
		lblClearButtonPassengerInNewTourReservation.setForeground(Color.WHITE);
		lblClearButtonPassengerInNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblClearButtonPassengerInNewTourReservation.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		lblAddNewPassengerInNewTourReservation = new JLabel("Add");
		lblAddNewPassengerInNewTourReservation.setForeground(Color.WHITE);
		lblAddNewPassengerInNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblAddNewPassengerInNewTourReservation.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		label_3 = new JLabel("Address");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		label_5 = new JLabel("Email");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		passengerEmailInNewTourReservation = new JTextField();
		passengerEmailInNewTourReservation.setSelectionColor(new Color(102, 205, 170));
		passengerEmailInNewTourReservation.setForeground(Color.WHITE);
		passengerEmailInNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerEmailInNewTourReservation.setColumns(10);
		passengerEmailInNewTourReservation.setBackground(new Color(95, 158, 160));

		passengerAddressInNewTourReservation = new JTextField();
		passengerAddressInNewTourReservation.setSelectionColor(new Color(102, 205, 170));
		passengerAddressInNewTourReservation.setForeground(Color.WHITE);
		passengerAddressInNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerAddressInNewTourReservation.setColumns(10);
		passengerAddressInNewTourReservation.setBackground(new Color(95, 158, 160));

		label_12 = new JLabel("Phone");
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		label_14 = new JLabel("Name");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		passengerPhoneInNewTourReservation = new JTextField();
		passengerPhoneInNewTourReservation.setSelectionColor(new Color(102, 205, 170));
		passengerPhoneInNewTourReservation.setForeground(Color.WHITE);
		passengerPhoneInNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerPhoneInNewTourReservation.setColumns(10);
		passengerPhoneInNewTourReservation.setBackground(new Color(95, 158, 160));

		passengerNameInNewReservation = new JTextField();
		passengerNameInNewReservation.setSelectionColor(new Color(102, 205, 170));
		passengerNameInNewReservation.setForeground(Color.WHITE);
		passengerNameInNewReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerNameInNewReservation.setColumns(10);
		passengerNameInNewReservation.setBackground(new Color(95, 158, 160));

		label_15 = new JLabel("Birthday");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		passengerMonthInNewTourReservation = new JTextField();
		passengerMonthInNewTourReservation.setForeground(Color.WHITE);
		passengerMonthInNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerMonthInNewTourReservation.setColumns(10);
		passengerMonthInNewTourReservation.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MM", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		passengerMonthInNewTourReservation.setBackground(new Color(95, 158, 160));

		passengerDayInNewTourReservation = new JTextField();
		passengerDayInNewTourReservation.setForeground(Color.WHITE);
		passengerDayInNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerDayInNewTourReservation.setColumns(10);
		passengerDayInNewTourReservation.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "DD", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		passengerDayInNewTourReservation.setBackground(new Color(95, 158, 160));

		passengerYearInNewTourReservation = new JTextField();
		passengerYearInNewTourReservation.setForeground(Color.WHITE);
		passengerYearInNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		passengerYearInNewTourReservation.setColumns(10);
		passengerYearInNewTourReservation
				.setBorder(
						new CompoundBorder(
								new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY", TitledBorder.CENTER,
										TitledBorder.TOP, null, new Color(255, 255, 255)),
								new EmptyBorder(2, 2, 2, 2)));
		passengerYearInNewTourReservation.setBackground(new Color(95, 158, 160));

		lblSearchForPassengerInNewTourReservationButton = new JLabel("Search");
		lblSearchForPassengerInNewTourReservationButton.setForeground(Color.WHITE);
		lblSearchForPassengerInNewTourReservationButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblSearchForPassengerInNewTourReservationButton.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		GroupLayout gl_addNewPassengerInNewTourReservationPanel = new GroupLayout(
				addNewPassengerInNewTourReservationPanel);
		gl_addNewPassengerInNewTourReservationPanel.setHorizontalGroup(gl_addNewPassengerInNewTourReservationPanel
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_addNewPassengerInNewTourReservationPanel.createSequentialGroup()
						.addGroup(gl_addNewPassengerInNewTourReservationPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_addNewPassengerInNewTourReservationPanel.createSequentialGroup()
										.addContainerGap().addComponent(lblClearButtonPassengerInNewTourReservation)
										.addGap(140).addComponent(lblAddNewPassengerInNewTourReservation))
								.addGroup(gl_addNewPassengerInNewTourReservationPanel.createSequentialGroup()
										.addContainerGap().addGroup(gl_addNewPassengerInNewTourReservationPanel
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_addNewPassengerInNewTourReservationPanel
														.createSequentialGroup()
														.addGroup(gl_addNewPassengerInNewTourReservationPanel
																.createParallelGroup(Alignment.LEADING)
																.addComponent(label_3).addComponent(label_5))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_addNewPassengerInNewTourReservationPanel
																.createParallelGroup(Alignment.LEADING).addComponent(
																		passengerEmailInNewTourReservation,
																		GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
																.addComponent(passengerAddressInNewTourReservation,
																		GroupLayout.DEFAULT_SIZE, 172,
																		Short.MAX_VALUE)))
												.addGroup(gl_addNewPassengerInNewTourReservationPanel
														.createSequentialGroup()
														.addGroup(gl_addNewPassengerInNewTourReservationPanel
																.createParallelGroup(Alignment.LEADING)
																.addComponent(label_12).addComponent(label_14))
														.addGap(18)
														.addGroup(gl_addNewPassengerInNewTourReservationPanel
																.createParallelGroup(Alignment.LEADING, false)
																.addGroup(gl_addNewPassengerInNewTourReservationPanel
																		.createSequentialGroup()
																		.addComponent(
																				passengerPhoneInNewTourReservation,
																				GroupLayout.PREFERRED_SIZE, 102,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(
																				lblSearchForPassengerInNewTourReservationButton,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addPreferredGap(ComponentPlacement.RELATED))
																.addComponent(passengerNameInNewReservation,
																		GroupLayout.PREFERRED_SIZE, 176,
																		GroupLayout.PREFERRED_SIZE)))))
								.addGroup(gl_addNewPassengerInNewTourReservationPanel.createSequentialGroup().addGap(13)
										.addComponent(label_15).addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(passengerMonthInNewTourReservation, GroupLayout.PREFERRED_SIZE,
												46, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(passengerDayInNewTourReservation, GroupLayout.PREFERRED_SIZE, 44,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(passengerYearInNewTourReservation, GroupLayout.PREFERRED_SIZE, 52,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(13)));
		gl_addNewPassengerInNewTourReservationPanel.setVerticalGroup(gl_addNewPassengerInNewTourReservationPanel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addNewPassengerInNewTourReservationPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_addNewPassengerInNewTourReservationPanel
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_addNewPassengerInNewTourReservationPanel
										.createParallelGroup(Alignment.BASELINE).addComponent(label_12).addComponent(
												passengerPhoneInNewTourReservation, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblSearchForPassengerInNewTourReservationButton,
										GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_addNewPassengerInNewTourReservationPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_14).addComponent(passengerNameInNewReservation,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_addNewPassengerInNewTourReservationPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3).addComponent(passengerAddressInNewTourReservation,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_addNewPassengerInNewTourReservationPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5).addComponent(passengerEmailInNewTourReservation,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(16)
						.addGroup(gl_addNewPassengerInNewTourReservationPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_15)
								.addComponent(passengerMonthInNewTourReservation, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passengerDayInNewTourReservation, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passengerYearInNewTourReservation, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
						.addGroup(gl_addNewPassengerInNewTourReservationPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAddNewPassengerInNewTourReservation)
								.addComponent(lblClearButtonPassengerInNewTourReservation))
						.addContainerGap()));
		addNewPassengerInNewTourReservationPanel.setLayout(gl_addNewPassengerInNewTourReservationPanel);

		lblRemoveButtonInNewTourReservation = new JLabel("Remove");
		lblRemoveButtonInNewTourReservation.setForeground(Color.WHITE);
		lblRemoveButtonInNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblRemoveButtonInNewTourReservation.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		lblClearAlButtonInNewTourReservation = new JLabel("Clear all");
		lblClearAlButtonInNewTourReservation.setForeground(Color.WHITE);
		lblClearAlButtonInNewTourReservation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblClearAlButtonInNewTourReservation.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		GroupLayout gl_selectPassengersPanel = new GroupLayout(selectPassengersPanel);
		gl_selectPassengersPanel.setHorizontalGroup(gl_selectPassengersPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectPassengersPanel.createSequentialGroup().addContainerGap()
						.addComponent(addNewPassengerInNewTourReservationPanel, GroupLayout.PREFERRED_SIZE, 265,
								GroupLayout.PREFERRED_SIZE)
						.addGap(35)
						.addGroup(gl_selectPassengersPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(selectPassengersScrollPanelInNewTourReservation, GroupLayout.DEFAULT_SIZE,
										313, Short.MAX_VALUE)
								.addGroup(gl_selectPassengersPanel.createSequentialGroup()
										.addComponent(lblRemoveButtonInNewTourReservation, GroupLayout.PREFERRED_SIZE,
												69, GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblClearAlButtonInNewTourReservation,
												GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		gl_selectPassengersPanel.setVerticalGroup(gl_selectPassengersPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectPassengersPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_selectPassengersPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_selectPassengersPanel.createSequentialGroup()
										.addComponent(selectPassengersScrollPanelInNewTourReservation,
												GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
										.addGroup(gl_selectPassengersPanel.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblRemoveButtonInNewTourReservation,
														GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblClearAlButtonInNewTourReservation,
														GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
								.addComponent(addNewPassengerInNewTourReservationPanel, GroupLayout.PREFERRED_SIZE, 385,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		tablePassengersInNewTourReservation = new JTable();
		tablePassengersInNewTourReservation.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tablePassengersInNewTourReservation.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Name", "Address", "Phone", "Email", "Birthday" }) {
			/**
			  * 
			  */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		selectPassengersScrollPanelInNewTourReservation.setViewportView(tablePassengersInNewTourReservation);
		selectPassengersPanel.setLayout(gl_selectPassengersPanel);

		JPanel selectTourPanel = new JPanel();
		selectTourPanel.setBackground(new Color(95, 158, 160));
		newTourReservationTabbedPanel.addTab("Select Tour", null, selectTourPanel, null);
		newTourReservationTabbedPanel.setForegroundAt(2, new Color(0, 153, 102));
		newTourReservationTabbedPanel.setBackgroundAt(2, Color.WHITE);

		JLabel lblSearchByDestination = new JLabel("Search by destination:");
		lblSearchByDestination.setForeground(new Color(255, 255, 255));
		lblSearchByDestination.setFont(new Font("Century Gothic", Font.PLAIN, 13));

		searchTourTextField = new JTextField();
		searchTourTextField.setBackground(new Color(95, 158, 160));
		searchTourTextField.setBorder(new LineBorder(new Color(255, 255, 255)));
		searchTourTextField.setToolTipText("enter Tour's destination here");
		searchTourTextField.setColumns(10);

		selectTourInNewTourReservationScrollPanel = new JScrollPane();
		selectTourInNewTourReservationScrollPanel.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Tours archive",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
				new EmptyBorder(3, 3, 3, 3)));
		selectTourInNewTourReservationScrollPanel.setBackground(new Color(95, 158, 160));

		lblSelectTourButtonInNewTourRes = new JLabel("Select");
		lblSelectTourButtonInNewTourRes.setForeground(Color.WHITE);
		lblSelectTourButtonInNewTourRes.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblSelectTourButtonInNewTourRes.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		GroupLayout gl_selectTourPanel = new GroupLayout(selectTourPanel);
		gl_selectTourPanel.setHorizontalGroup(gl_selectTourPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectTourPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_selectTourPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(selectTourInNewTourReservationScrollPanel, GroupLayout.DEFAULT_SIZE, 613,
										Short.MAX_VALUE)
								.addGroup(gl_selectTourPanel.createSequentialGroup()
										.addComponent(lblSearchByDestination, GroupLayout.PREFERRED_SIZE, 145,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(searchTourTextField,
												GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblSelectTourButtonInNewTourRes, GroupLayout.PREFERRED_SIZE, 54,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_selectTourPanel.setVerticalGroup(gl_selectTourPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectTourPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_selectTourPanel
								.createParallelGroup(Alignment.BASELINE).addComponent(lblSearchByDestination)
								.addComponent(searchTourTextField, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(selectTourInNewTourReservationScrollPanel, GroupLayout.PREFERRED_SIZE, 241,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblSelectTourButtonInNewTourRes,
								GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(67, Short.MAX_VALUE)));

		tableToursInNewTourReservation = new JTable();
		tableToursInNewTourReservation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableToursInNewTourReservation
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Date", "Destination", "Pick up",
						"Seats Available", "Current Total Price", "Price Per Passenger", "Bus", "Chauffeur" }) {
					/**
					* 
					*/
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false,
							false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		selectTourInNewTourReservationScrollPanel.setViewportView(tableToursInNewTourReservation);
		selectTourPanel.setLayout(gl_selectTourPanel);
		panelNewTourReservation.setLayout(gl_panelNewTourReservation);

		panelNewBusReservation = new JPanel();
		panelNewBusReservation.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelNewBusReservation, "name_7867663339455");

		JPanel panelTopNewBusReservation = new JPanel();
		panelTopNewBusReservation.setBackground(new Color(0, 128, 128));

		JLabel labelNewBusReservation = new JLabel("New Bus & Chauffeur reservation");
		labelNewBusReservation.setForeground(Color.WHITE);
		labelNewBusReservation.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopNewBusReservation = new GroupLayout(panelTopNewBusReservation);
		gl_panelTopNewBusReservation
				.setHorizontalGroup(gl_panelTopNewBusReservation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTopNewBusReservation
								.createSequentialGroup().addContainerGap().addComponent(labelNewBusReservation,
										GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(530, Short.MAX_VALUE)));
		gl_panelTopNewBusReservation
				.setVerticalGroup(gl_panelTopNewBusReservation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTopNewBusReservation.createSequentialGroup()
								.addComponent(labelNewBusReservation, GroupLayout.PREFERRED_SIZE, 51,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelTopNewBusReservation.setLayout(gl_panelTopNewBusReservation);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Customer",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBackground(new Color(95, 158, 160));

		panelNewBusAddPassenger = new JPanel();
		panelNewBusAddPassenger
				.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true),
						"Add passenger", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), null));
		panelNewBusAddPassenger.setBackground(new Color(95, 158, 160));

		scrollPaneNewBusPassengers = new JScrollPane();
		scrollPaneNewBusPassengers.setBackground(new Color(95, 158, 160));
		scrollPaneNewBusPassengers.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Passenger list",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
				new EmptyBorder(3, 3, 3, 3)));

		lblNewBusRemovePassengerBtn = new JLabel("Remove");
		lblNewBusRemovePassengerBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		lblNewBusRemovePassengerBtn.setForeground(new Color(255, 255, 255));
		lblNewBusRemovePassengerBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		lblNewBusNextBtn = new JLabel("NEXT >>");
		lblNewBusNextBtn.setForeground(new Color(255, 255, 255));
		lblNewBusNextBtn.setFont(new Font("Century Gothic", Font.PLAIN, 18));

		lblNewBusClearAllBtn = new JLabel("Clear all");
		lblNewBusClearAllBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		lblNewBusClearAllBtn.setForeground(new Color(255, 255, 255));
		lblNewBusClearAllBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		GroupLayout gl_panelNewBusReservation = new GroupLayout(panelNewBusReservation);
		gl_panelNewBusReservation
				.setHorizontalGroup(
						gl_panelNewBusReservation.createParallelGroup(Alignment.TRAILING)
								.addGroup(
										gl_panelNewBusReservation
												.createSequentialGroup().addGroup(gl_panelNewBusReservation
														.createParallelGroup(Alignment.LEADING).addGroup(
																gl_panelNewBusReservation.createSequentialGroup()
																		.addGap(12)
																		.addComponent(panel, GroupLayout.PREFERRED_SIZE,
																				327, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(
																				panelNewBusAddPassenger,
																				GroupLayout.PREFERRED_SIZE,
																				265, GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addGroup(gl_panelNewBusReservation
																				.createParallelGroup(Alignment.TRAILING)
																				.addGroup(gl_panelNewBusReservation
																						.createSequentialGroup()
																						.addComponent(
																								lblNewBusRemovePassengerBtn)
																						.addPreferredGap(
																								ComponentPlacement.UNRELATED)
																						.addComponent(
																								lblNewBusClearAllBtn)
																						.addPreferredGap(
																								ComponentPlacement.RELATED,
																								126, Short.MAX_VALUE)
																						.addComponent(lblNewBusNextBtn)
																						.addGap(35))
																				.addGroup(Alignment.LEADING,
																						gl_panelNewBusReservation
																								.createSequentialGroup()
																								.addComponent(
																										scrollPaneNewBusPassengers,
																										GroupLayout.DEFAULT_SIZE,
																										339,
																										Short.MAX_VALUE)
																								.addGap(27))))
														.addComponent(panelTopNewBusReservation,
																GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
												.addGap(0)));
		gl_panelNewBusReservation.setVerticalGroup(gl_panelNewBusReservation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNewBusReservation.createSequentialGroup()
						.addComponent(panelTopNewBusReservation, GroupLayout.PREFERRED_SIZE, 58,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelNewBusReservation.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelNewBusReservation
										.createSequentialGroup()
										.addComponent(scrollPaneNewBusPassengers, GroupLayout.PREFERRED_SIZE, 331,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(gl_panelNewBusReservation.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelNewBusReservation
														.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblNewBusNextBtn)
														.addComponent(lblNewBusRemovePassengerBtn))
												.addComponent(lblNewBusClearAllBtn)))
								.addComponent(panelNewBusAddPassenger, GroupLayout.PREFERRED_SIZE, 385,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(37, Short.MAX_VALUE)));

		tableNewBusPassengers = new JTable();
		tableNewBusPassengers.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Name", "Address", "Phone", "Email", "Birthday" }) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class };

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableNewBusPassengers.setSelectionBackground(new Color(102, 205, 170));
		tableNewBusPassengers.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tableNewBusPassengers.setForeground(new Color(255, 255, 255));
		tableNewBusPassengers.setBackground(new Color(95, 158, 160));
		scrollPaneNewBusPassengers.setViewportView(tableNewBusPassengers);

		lblNewBusPassengerPhone = new JLabel("Phone");
		lblNewBusPassengerPhone.setForeground(new Color(255, 255, 255));
		lblNewBusPassengerPhone.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		lblNewBusPassengerName = new JLabel("Name");
		lblNewBusPassengerName.setForeground(new Color(255, 255, 255));
		lblNewBusPassengerName.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		lblNewBusPassengerAddress = new JLabel("Address");
		lblNewBusPassengerAddress.setForeground(new Color(255, 255, 255));
		lblNewBusPassengerAddress.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		lblNewBusPassengerEmail = new JLabel("Email");
		lblNewBusPassengerEmail.setForeground(new Color(255, 255, 255));
		lblNewBusPassengerEmail.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		lblNewBusPassengerBirthday = new JLabel("Birthday");
		lblNewBusPassengerBirthday.setForeground(new Color(255, 255, 255));
		lblNewBusPassengerBirthday.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldNewBusPassengerPhone = new JTextField();
		textFieldNewBusPassengerPhone.setSelectionColor(new Color(102, 205, 170));
		textFieldNewBusPassengerPhone.setBackground(new Color(95, 158, 160));
		textFieldNewBusPassengerPhone.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusPassengerPhone.setForeground(new Color(255, 255, 255));
		textFieldNewBusPassengerPhone.setColumns(10);

		textFieldNewBusPassengerName = new JTextField();
		textFieldNewBusPassengerName.setSelectionColor(new Color(102, 205, 170));
		textFieldNewBusPassengerName.setBackground(new Color(95, 158, 160));
		textFieldNewBusPassengerName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusPassengerName.setForeground(new Color(255, 255, 255));
		textFieldNewBusPassengerName.setColumns(10);

		textFieldNewBusPassengerAddress = new JTextField();
		textFieldNewBusPassengerAddress.setSelectionColor(new Color(102, 205, 170));
		textFieldNewBusPassengerAddress.setBackground(new Color(95, 158, 160));
		textFieldNewBusPassengerAddress.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusPassengerAddress.setForeground(new Color(255, 255, 255));
		textFieldNewBusPassengerAddress.setColumns(10);

		textFieldNewBusPassengerEmail = new JTextField();
		textFieldNewBusPassengerEmail.setSelectionColor(new Color(102, 205, 170));
		textFieldNewBusPassengerEmail.setBackground(new Color(95, 158, 160));
		textFieldNewBusPassengerEmail.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusPassengerEmail.setForeground(new Color(255, 255, 255));
		textFieldNewBusPassengerEmail.setColumns(10);

		lblNewBusSearchPassengerBtn = new JLabel("Search");
		lblNewBusSearchPassengerBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));
		lblNewBusSearchPassengerBtn.setForeground(new Color(255, 255, 255));
		lblNewBusSearchPassengerBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		textFieldNewBusPassengerBmonth = new JTextField();
		textFieldNewBusPassengerBmonth.setForeground(new Color(255, 255, 255));
		textFieldNewBusPassengerBmonth.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusPassengerBmonth.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MM", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		textFieldNewBusPassengerBmonth.setBackground(new Color(95, 158, 160));
		textFieldNewBusPassengerBmonth.setColumns(10);

		textFieldNewBusPassengerBday = new JTextField();
		textFieldNewBusPassengerBday.setForeground(new Color(255, 255, 255));
		textFieldNewBusPassengerBday.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusPassengerBday.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "DD", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		textFieldNewBusPassengerBday.setBackground(new Color(95, 158, 160));
		textFieldNewBusPassengerBday.setColumns(10);

		textFieldNewBusPassengerByear = new JTextField();
		textFieldNewBusPassengerByear.setForeground(new Color(255, 255, 255));
		textFieldNewBusPassengerByear.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusPassengerByear
				.setBorder(
						new CompoundBorder(
								new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY", TitledBorder.CENTER,
										TitledBorder.TOP, null, new Color(255, 255, 255)),
								new EmptyBorder(2, 2, 2, 2)));
		textFieldNewBusPassengerByear.setBackground(new Color(95, 158, 160));
		textFieldNewBusPassengerByear.setColumns(10);

		lblNewBusPassengerClearBtn = new JLabel("Clear");
		lblNewBusPassengerClearBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		lblNewBusPassengerClearBtn.setForeground(new Color(255, 255, 255));
		lblNewBusPassengerClearBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));

		lblNewBusAddPassengerBtn = new JLabel("Add");
		lblNewBusAddPassengerBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		lblNewBusAddPassengerBtn.setForeground(new Color(255, 255, 255));
		lblNewBusAddPassengerBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		GroupLayout gl_panelNewBusAddPassenger = new GroupLayout(panelNewBusAddPassenger);
		gl_panelNewBusAddPassenger.setHorizontalGroup(
				gl_panelNewBusAddPassenger.createParallelGroup(Alignment.LEADING).addGroup(gl_panelNewBusAddPassenger
						.createSequentialGroup().addGroup(gl_panelNewBusAddPassenger
								.createParallelGroup(Alignment.LEADING).addGroup(gl_panelNewBusAddPassenger
										.createSequentialGroup().addContainerGap().addGroup(gl_panelNewBusAddPassenger
												.createParallelGroup(Alignment.TRAILING).addGroup(
														gl_panelNewBusAddPassenger
																.createSequentialGroup()
																.addGroup(
																		gl_panelNewBusAddPassenger
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblNewBusPassengerAddress)
																				.addComponent(lblNewBusPassengerEmail))
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addGroup(gl_panelNewBusAddPassenger
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(textFieldNewBusPassengerEmail,
																				GroupLayout.DEFAULT_SIZE,
																				167, Short.MAX_VALUE)
																		.addComponent(textFieldNewBusPassengerAddress,
																				GroupLayout.DEFAULT_SIZE, 165,
																				Short.MAX_VALUE)))
												.addGroup(Alignment.LEADING,
														gl_panelNewBusAddPassenger.createSequentialGroup()
																.addGroup(gl_panelNewBusAddPassenger
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblNewBusPassengerPhone)
																		.addComponent(lblNewBusPassengerName))
																.addGap(27)
																.addGroup(gl_panelNewBusAddPassenger
																		.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(textFieldNewBusPassengerName,
																				GroupLayout.PREFERRED_SIZE, 166,
																				GroupLayout.PREFERRED_SIZE)
																		.addGroup(gl_panelNewBusAddPassenger
																				.createSequentialGroup()
																				.addComponent(
																						textFieldNewBusPassengerPhone,
																						GroupLayout.PREFERRED_SIZE, 75,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						lblNewBusSearchPassengerBtn))))))
								.addGroup(gl_panelNewBusAddPassenger.createSequentialGroup().addGap(13)
										.addComponent(lblNewBusPassengerBirthday)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textFieldNewBusPassengerBmonth, GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textFieldNewBusPassengerBday, GroupLayout.PREFERRED_SIZE, 44,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textFieldNewBusPassengerByear, GroupLayout.PREFERRED_SIZE, 52,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING,
										gl_panelNewBusAddPassenger.createSequentialGroup().addGap(14)
												.addComponent(lblNewBusPassengerClearBtn)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(lblNewBusAddPassengerBtn)))
						.addContainerGap()));
		gl_panelNewBusAddPassenger.setVerticalGroup(gl_panelNewBusAddPassenger.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNewBusAddPassenger.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelNewBusAddPassenger.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewBusPassengerPhone)
								.addComponent(textFieldNewBusPassengerPhone, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewBusSearchPassengerBtn))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelNewBusAddPassenger.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewBusPassengerName).addComponent(textFieldNewBusPassengerName,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelNewBusAddPassenger.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewBusPassengerAddress).addComponent(textFieldNewBusPassengerAddress,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelNewBusAddPassenger.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewBusPassengerEmail).addComponent(textFieldNewBusPassengerEmail,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(16)
						.addGroup(gl_panelNewBusAddPassenger
								.createParallelGroup(Alignment.BASELINE).addComponent(lblNewBusPassengerBirthday)
								.addComponent(textFieldNewBusPassengerBmonth, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNewBusPassengerBday, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNewBusPassengerByear, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
						.addGroup(gl_panelNewBusAddPassenger.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewBusPassengerClearBtn).addComponent(lblNewBusAddPassengerBtn))
						.addContainerGap()));
		panelNewBusAddPassenger.setLayout(gl_panelNewBusAddPassenger);

		lblNewBusOrganisationName = new JLabel("Name/organisation");
		lblNewBusOrganisationName.setForeground(new Color(255, 255, 255));
		lblNewBusOrganisationName.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		rdbtnNewBusCompany = new JRadioButton("Company");
		rdbtnNewBusCompany.setBackground(new Color(95, 158, 160));
		rdbtnNewBusCompany.setForeground(new Color(255, 255, 255));
		rdbtnNewBusCompany.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		rdbtnNewBusSchool = new JRadioButton("School");
		rdbtnNewBusSchool.setBackground(new Color(95, 158, 160));
		rdbtnNewBusSchool.setForeground(new Color(255, 255, 255));
		rdbtnNewBusSchool.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		rdbtnNewBusPrivate = new JRadioButton("Private");
		rdbtnNewBusPrivate.setBackground(new Color(95, 158, 160));
		rdbtnNewBusPrivate.setForeground(new Color(255, 255, 255));
		rdbtnNewBusPrivate.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldNewBusOrganisationName = new JTextField();
		textFieldNewBusOrganisationName.setSelectionColor(new Color(102, 205, 170));
		textFieldNewBusOrganisationName.setForeground(new Color(255, 255, 255));
		textFieldNewBusOrganisationName.setBackground(new Color(95, 158, 160));
		textFieldNewBusOrganisationName.setColumns(10);

		JLabel lblNewBusName = new JLabel("Name/contact");
		lblNewBusName.setForeground(new Color(255, 255, 255));
		lblNewBusName.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldNewBusCustomerName = new JTextField();
		textFieldNewBusCustomerName.setSelectionColor(new Color(102, 205, 170));
		textFieldNewBusCustomerName.setForeground(new Color(255, 255, 255));
		textFieldNewBusCustomerName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusCustomerName.setBackground(new Color(95, 158, 160));
		textFieldNewBusCustomerName.setColumns(10);

		chckbxNewBusIsPassenger = new JCheckBox("is a passenger");
		chckbxNewBusIsPassenger.setForeground(new Color(255, 255, 255));
		chckbxNewBusIsPassenger.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chckbxNewBusIsPassenger.setBackground(new Color(95, 158, 160));

		JLabel lblNewBusCustomerAddress = new JLabel("Address");
		lblNewBusCustomerAddress.setForeground(new Color(255, 255, 255));
		lblNewBusCustomerAddress.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldNewBusCustomerAddress = new JTextField();
		textFieldNewBusCustomerAddress.setSelectionColor(new Color(102, 205, 170));
		textFieldNewBusCustomerAddress.setForeground(new Color(255, 255, 255));
		textFieldNewBusCustomerAddress.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusCustomerAddress.setBackground(new Color(95, 158, 160));
		textFieldNewBusCustomerAddress.setColumns(10);

		JLabel lblNewBusCustomerPhone = new JLabel("Phone");
		lblNewBusCustomerPhone.setForeground(new Color(255, 255, 255));
		lblNewBusCustomerPhone.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldNewBusCustomerPhone = new JTextField();
		textFieldNewBusCustomerPhone.setBackground(new Color(95, 158, 160));
		textFieldNewBusCustomerPhone.setForeground(new Color(255, 255, 255));
		textFieldNewBusCustomerPhone.setColumns(10);

		JLabel lblNewBusCustomerEmail = new JLabel("Email");
		lblNewBusCustomerEmail.setForeground(new Color(255, 255, 255));
		lblNewBusCustomerEmail.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldNewBusCustomerEmail = new JTextField();
		textFieldNewBusCustomerEmail.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusCustomerEmail.setForeground(new Color(255, 255, 255));
		textFieldNewBusCustomerEmail.setBackground(new Color(95, 158, 160));
		textFieldNewBusCustomerEmail.setColumns(10);

		JLabel lblNewBusCustomerBirthday = new JLabel("Birthday");
		lblNewBusCustomerBirthday.setForeground(new Color(255, 255, 255));
		lblNewBusCustomerBirthday.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldNewBusCustomerBmonth = new JTextField();
		textFieldNewBusCustomerBmonth.setForeground(new Color(255, 255, 255));
		textFieldNewBusCustomerBmonth.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusCustomerBmonth.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MM", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		textFieldNewBusCustomerBmonth.setBackground(new Color(95, 158, 160));
		textFieldNewBusCustomerBmonth.setColumns(10);

		textFieldNewBusCustomerBday = new JTextField();
		textFieldNewBusCustomerBday.setForeground(new Color(255, 255, 255));
		textFieldNewBusCustomerBday.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusCustomerBday.setBackground(new Color(95, 158, 160));
		textFieldNewBusCustomerBday.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "DD", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(2, 2, 2, 2)));
		textFieldNewBusCustomerBday.setColumns(10);

		textFieldNewBusCustomerByear = new JTextField();
		textFieldNewBusCustomerByear.setForeground(new Color(255, 255, 255));
		textFieldNewBusCustomerByear.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusCustomerByear
				.setBorder(
						new CompoundBorder(
								new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY", TitledBorder.CENTER,
										TitledBorder.TOP, null, new Color(255, 255, 255)),
								new EmptyBorder(2, 2, 2, 2)));
		textFieldNewBusCustomerByear.setBackground(new Color(95, 158, 160));
		textFieldNewBusCustomerByear.setColumns(10);

		lblNewBusSearchCustomerBtn = new JLabel("Search");
		lblNewBusSearchCustomerBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));
		lblNewBusSearchCustomerBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewBusSearchCustomerBtn.setForeground(new Color(255, 255, 255));

		lblNewBusCustomerClear = new JLabel("Clear");
		lblNewBusCustomerClear.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		lblNewBusCustomerClear.setForeground(new Color(255, 255, 255));
		lblNewBusCustomerClear.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewBusCustomerPhone)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textFieldNewBusCustomerPhone, GroupLayout.PREFERRED_SIZE, 79,
										GroupLayout.PREFERRED_SIZE)
								.addGap(32).addComponent(lblNewBusSearchCustomerBtn))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewBusCustomerClear)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(chckbxNewBusIsPassenger))
								.addGroup(gl_panel.createSequentialGroup().addComponent(rdbtnNewBusCompany).addGap(18)
										.addComponent(rdbtnNewBusSchool).addGap(18).addComponent(rdbtnNewBusPrivate))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewBusName)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textFieldNewBusCustomerName))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewBusOrganisationName)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldNewBusOrganisationName, GroupLayout.PREFERRED_SIZE, 154,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewBusCustomerEmail)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldNewBusCustomerEmail, 238, 238, 238))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewBusCustomerAddress)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textFieldNewBusCustomerAddress, GroupLayout.DEFAULT_SIZE, 216,
												Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewBusCustomerBirthday)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textFieldNewBusCustomerBmonth, GroupLayout.PREFERRED_SIZE, 47,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textFieldNewBusCustomerBday, GroupLayout.PREFERRED_SIZE, 47,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(textFieldNewBusCustomerByear, 0, 0, Short.MAX_VALUE)))
				.addGap(24)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewBusCustomerPhone)
						.addComponent(textFieldNewBusCustomerPhone, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewBusSearchCustomerBtn))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewBusOrganisationName)
						.addComponent(textFieldNewBusOrganisationName, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnNewBusCompany)
						.addComponent(rdbtnNewBusSchool).addComponent(rdbtnNewBusPrivate))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewBusName).addComponent(
						textFieldNewBusCustomerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewBusCustomerAddress)
						.addComponent(textFieldNewBusCustomerAddress, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewBusCustomerEmail)
						.addComponent(textFieldNewBusCustomerEmail, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewBusCustomerBirthday)
						.addComponent(textFieldNewBusCustomerBmonth, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNewBusCustomerBday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNewBusCustomerByear, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewBusCustomerClear)
						.addComponent(chckbxNewBusIsPassenger))
				.addContainerGap()));
		panel.setLayout(gl_panel);
		panelNewBusReservation.setLayout(gl_panelNewBusReservation);

		panelPrices = new JPanel();
		panelPrices.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelPrices, "name_24367594985615");

		panelTopPrices = new JPanel();
		panelTopPrices.setBackground(new Color(0, 128, 128));

		labelPrices = new JLabel("Prices");
		labelPrices.setForeground(Color.WHITE);
		labelPrices.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panelTopPrices = new GroupLayout(panelTopPrices);
		gl_panelTopPrices.setHorizontalGroup(
				gl_panelTopPrices.createParallelGroup(Alignment.LEADING).addGap(0, 1000, Short.MAX_VALUE)
						.addGroup(gl_panelTopPrices.createSequentialGroup().addContainerGap()
								.addComponent(labelPrices, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(748, Short.MAX_VALUE)));
		gl_panelTopPrices.setVerticalGroup(
				gl_panelTopPrices.createParallelGroup(Alignment.LEADING).addGap(0, 58, Short.MAX_VALUE)
						.addGroup(gl_panelTopPrices.createSequentialGroup()
								.addComponent(labelPrices, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelTopPrices.setLayout(gl_panelTopPrices);

		JPanel panelPricesServices = new JPanel();
		panelPricesServices.setBackground(new Color(95, 158, 160));
		panelPricesServices
				.setBorder(new CompoundBorder(
						new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Services",
								TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
						new EmptyBorder(3, 3, 3, 3)));
		GroupLayout gl_panelPrices = new GroupLayout(panelPrices);
		gl_panelPrices
				.setHorizontalGroup(gl_panelPrices.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_panelPrices.createSequentialGroup()
								.addGroup(gl_panelPrices
										.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
												gl_panelPrices.createSequentialGroup().addGap(12)
														.addComponent(panelPricesServices, GroupLayout.PREFERRED_SIZE,
																246, GroupLayout.PREFERRED_SIZE)
														.addGap(742))
										.addComponent(panelTopPrices, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(0)));
		gl_panelPrices.setVerticalGroup(gl_panelPrices.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrices.createSequentialGroup()
						.addComponent(panelTopPrices, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(panelPricesServices, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(157, Short.MAX_VALUE)));

		JLabel lblPriceBreakfast = new JLabel("Breakfast");
		lblPriceBreakfast.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblPriceBreakfast.setForeground(new Color(255, 255, 255));

		textFieldPriceBreakfast = new JTextField();
		textFieldPriceBreakfast.setBackground(new Color(95, 158, 160));
		textFieldPriceBreakfast.setSelectionColor(new Color(102, 205, 170));
		textFieldPriceBreakfast.setSelectedTextColor(new Color(51, 51, 51));
		textFieldPriceBreakfast.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldPriceBreakfast.setForeground(new Color(255, 255, 255));
		textFieldPriceBreakfast.setDisabledTextColor(new Color(102, 205, 170));
		textFieldPriceBreakfast.setCaretColor(new Color(255, 255, 255));
		textFieldPriceBreakfast.setColumns(10);

		JLabel lblPriceLunch = new JLabel("Lunch");
		lblPriceLunch.setForeground(new Color(255, 255, 255));
		lblPriceLunch.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldPriceLunch = new JTextField();
		textFieldPriceLunch.setSelectionColor(new Color(102, 205, 170));
		textFieldPriceLunch.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldPriceLunch.setForeground(new Color(255, 255, 255));
		textFieldPriceLunch.setBackground(new Color(95, 158, 160));
		textFieldPriceLunch.setColumns(10);

		JLabel lblPriceAllInclusive = new JLabel("All inclusive");
		lblPriceAllInclusive.setForeground(new Color(255, 255, 255));
		lblPriceAllInclusive.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldPriceAllinclusive = new JTextField();
		textFieldPriceAllinclusive.setSelectionColor(new Color(102, 205, 170));
		textFieldPriceAllinclusive.setForeground(new Color(255, 255, 255));
		textFieldPriceAllinclusive.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldPriceAllinclusive.setBackground(new Color(95, 158, 160));
		textFieldPriceAllinclusive.setColumns(10);

		JLabel lblPriceEntranceTickets = new JLabel("Entrance tickets");
		lblPriceEntranceTickets.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblPriceEntranceTickets.setForeground(new Color(255, 255, 255));

		textFieldPriceEntranceTickets = new JTextField();
		textFieldPriceEntranceTickets.setSelectionColor(new Color(102, 205, 170));
		textFieldPriceEntranceTickets.setForeground(new Color(255, 255, 255));
		textFieldPriceEntranceTickets.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldPriceEntranceTickets.setBackground(new Color(95, 158, 160));
		textFieldPriceEntranceTickets.setColumns(10);

		lblUpdatePriceBtn = new JLabel("Update ");
		lblUpdatePriceBtn.setForeground(new Color(255, 255, 255));
		lblUpdatePriceBtn.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		lblUpdatePriceBtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		GroupLayout gl_panelPricesServices = new GroupLayout(panelPricesServices);
		gl_panelPricesServices.setHorizontalGroup(gl_panelPricesServices.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPricesServices.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelPricesServices.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelPricesServices.createSequentialGroup().addComponent(lblPriceBreakfast)
										.addGap(65).addComponent(textFieldPriceBreakfast, GroupLayout.PREFERRED_SIZE,
												69, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelPricesServices.createSequentialGroup().addComponent(lblPriceLunch)
										.addGap(85).addComponent(textFieldPriceLunch, GroupLayout.PREFERRED_SIZE, 69,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelPricesServices.createSequentialGroup()
										.addComponent(lblPriceAllInclusive).addGap(50).addComponent(
												textFieldPriceAllinclusive, GroupLayout.PREFERRED_SIZE, 69,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelPricesServices.createSequentialGroup()
										.addComponent(lblPriceEntranceTickets).addGap(24)
										.addComponent(textFieldPriceEntranceTickets, GroupLayout.PREFERRED_SIZE, 69,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelPricesServices.createSequentialGroup().addGap(120)
										.addComponent(lblUpdatePriceBtn)))
						.addContainerGap(88, Short.MAX_VALUE)));
		gl_panelPricesServices.setVerticalGroup(gl_panelPricesServices.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPricesServices.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelPricesServices.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPriceBreakfast)
								.addComponent(textFieldPriceBreakfast, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelPricesServices.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPriceLunch).addComponent(textFieldPriceLunch,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelPricesServices.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPriceAllInclusive).addComponent(textFieldPriceAllinclusive,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelPricesServices.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPriceEntranceTickets).addComponent(textFieldPriceEntranceTickets,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(31).addComponent(lblUpdatePriceBtn).addContainerGap(38, Short.MAX_VALUE)));
		panelPricesServices.setLayout(gl_panelPricesServices);
		panelPrices.setLayout(gl_panelPrices);

		panelNewBusReservationNext = new JPanel();
		panelNewBusReservationNext.setBackground(new Color(95, 158, 160));
		desktopPane.add(panelNewBusReservationNext, "name_78121885344105");

		lblCancel = new JLabel("Cancel");
		lblCancel.setForeground(Color.WHITE);
		lblCancel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblCancel.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		lblOkNewBusResevation = new JLabel("Create");
		lblOkNewBusResevation.setForeground(Color.WHITE);
		lblOkNewBusResevation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblOkNewBusResevation.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));

		scrollPaneNewBusSelectChauffeur = new JScrollPane();
		scrollPaneNewBusSelectChauffeur.setForeground(new Color(255, 255, 255));
		scrollPaneNewBusSelectChauffeur.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Select chauffeur",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
				new EmptyBorder(3, 3, 3, 3)));
		scrollPaneNewBusSelectChauffeur.setBackground(new Color(95, 158, 160));

		panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 128, 128));

		label_19 = new JLabel("New Bus & Chauffeur reservation");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGap(0, 1000, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup().addContainerGap()
						.addComponent(label_19, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(530, Short.MAX_VALUE)));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGap(0, 58, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup()
						.addComponent(label_19, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_5.setLayout(gl_panel_5);

		panelSelectBus = new JPanel();
		panelSelectBus.setBorder(new CompoundBorder(
				new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Date interval",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
				new EmptyBorder(3, 3, 3, 3)));
		panelSelectBus.setBackground(new Color(95, 158, 160));

		scrollPaneNewBusSelectBus = new JScrollPane();
		scrollPaneNewBusSelectBus
				.setBorder(new CompoundBorder(
						new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Select bus",
								TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
						new EmptyBorder(3, 3, 3, 3)));
		scrollPaneNewBusSelectBus.setBackground(new Color(95, 158, 160));

		textPaneSummaryNewBus = new JTextPane();
		textPaneSummaryNewBus.setForeground(new Color(255, 255, 255));
		textPaneSummaryNewBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textPaneSummaryNewBus
				.setBorder(
						new CompoundBorder(
								new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Summary",
										TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
								new EmptyBorder(5, 5, 5, 5)));
		textPaneSummaryNewBus.setBackground(new Color(95, 158, 160));

		panelServicesNewBus = new JPanel();
		panelServicesNewBus
				.setBorder(new CompoundBorder(
						new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Services",
								TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),
						new EmptyBorder(2, 2, 2, 2)));
		panelServicesNewBus.setBackground(new Color(95, 158, 160));

		lblSelectBusNewBusResButton = new JLabel("Select");
		lblSelectBusNewBusResButton.setForeground(Color.WHITE);
		lblSelectBusNewBusResButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblSelectBusNewBusResButton.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		GroupLayout gl_panelNewBusReservationNext = new GroupLayout(panelNewBusReservationNext);
		gl_panelNewBusReservationNext
				.setHorizontalGroup(gl_panelNewBusReservationNext.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 1369, Short.MAX_VALUE)
						.addGroup(gl_panelNewBusReservationNext.createSequentialGroup().addContainerGap().addGroup(
								gl_panelNewBusReservationNext.createParallelGroup(Alignment.LEADING, false).addGroup(
										Alignment.TRAILING, gl_panelNewBusReservationNext.createSequentialGroup()
												.addComponent(lblCancel).addPreferredGap(ComponentPlacement.RELATED,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblOkNewBusResevation))
										.addGroup(gl_panelNewBusReservationNext.createSequentialGroup()
												.addGroup(gl_panelNewBusReservationNext
														.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_panelNewBusReservationNext.createSequentialGroup()
																.addGroup(gl_panelNewBusReservationNext
																		.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(panelServicesNewBus,
																				GroupLayout.PREFERRED_SIZE, 298,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(panelSelectBus,
																				GroupLayout.PREFERRED_SIZE, 298,
																				GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(scrollPaneNewBusSelectBus,
																		GroupLayout.PREFERRED_SIZE, 224,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(scrollPaneNewBusSelectChauffeur,
																		GroupLayout.PREFERRED_SIZE, 222,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18))
														.addGroup(gl_panelNewBusReservationNext.createSequentialGroup()
																.addComponent(lblSelectBusNewBusResButton,
																		GroupLayout.PREFERRED_SIZE, 54,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(220)))
												.addComponent(textPaneSummaryNewBus, GroupLayout.PREFERRED_SIZE, 511,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(54)));
		gl_panelNewBusReservationNext.setVerticalGroup(gl_panelNewBusReservationNext
				.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNewBusReservationNext.createSequentialGroup()
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panelNewBusReservationNext
								.createParallelGroup(Alignment.LEADING)
								.addComponent(
										textPaneSummaryNewBus, GroupLayout.PREFERRED_SIZE, 426,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelNewBusReservationNext.createSequentialGroup()
										.addGroup(gl_panelNewBusReservationNext.createParallelGroup(Alignment.LEADING)
												.addComponent(scrollPaneNewBusSelectChauffeur,
														GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
												.addGroup(
														gl_panelNewBusReservationNext
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(scrollPaneNewBusSelectBus, 0, 0,
																		Short.MAX_VALUE)
																.addGroup(gl_panelNewBusReservationNext
																		.createSequentialGroup()
																		.addComponent(panelSelectBus,
																				GroupLayout.PREFERRED_SIZE, 233,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18).addComponent(panelServicesNewBus,
																				GroupLayout.PREFERRED_SIZE, 137,
																				GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblSelectBusNewBusResButton, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelNewBusReservationNext.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelNewBusReservationNext.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblOkNewBusResevation))
								.addGroup(gl_panelNewBusReservationNext.createSequentialGroup().addGap(5)
										.addComponent(lblCancel)))
						.addGap(355)));

		chckbxBreakfastNewBus = new JCheckBox("Breakfast");
		chckbxBreakfastNewBus.setForeground(new Color(255, 255, 255));
		chckbxBreakfastNewBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chckbxBreakfastNewBus.setBackground(new Color(95, 158, 160));

		chckbxLunchNewBus = new JCheckBox("Lunch");
		chckbxLunchNewBus.setForeground(new Color(255, 255, 255));
		chckbxLunchNewBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chckbxLunchNewBus.setBackground(new Color(95, 158, 160));

		chckbxAllInclusiveNewBus = new JCheckBox("All inclusive");
		chckbxAllInclusiveNewBus.setForeground(new Color(255, 255, 255));
		chckbxAllInclusiveNewBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chckbxAllInclusiveNewBus.setBackground(new Color(95, 158, 160));

		chckbxEntranceTicketsNewBus = new JCheckBox("Entrance tickets");
		chckbxEntranceTicketsNewBus.setForeground(new Color(255, 255, 255));
		chckbxEntranceTicketsNewBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chckbxEntranceTicketsNewBus.setBackground(new Color(95, 158, 160));
		GroupLayout gl_panelServicesNewBus = new GroupLayout(panelServicesNewBus);
		gl_panelServicesNewBus.setHorizontalGroup(gl_panelServicesNewBus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelServicesNewBus.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelServicesNewBus.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxBreakfastNewBus).addComponent(chckbxLunchNewBus)
								.addComponent(chckbxAllInclusiveNewBus).addComponent(chckbxEntranceTicketsNewBus))
						.addContainerGap(50, Short.MAX_VALUE)));
		gl_panelServicesNewBus.setVerticalGroup(gl_panelServicesNewBus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelServicesNewBus.createSequentialGroup().addComponent(chckbxBreakfastNewBus)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckbxLunchNewBus)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckbxAllInclusiveNewBus)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chckbxEntranceTicketsNewBus)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelServicesNewBus.setLayout(gl_panelServicesNewBus);

		tableNewBusSelectBus = new JTable();
		tableNewBusSelectBus.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Price/hour", "Seats", "Type" }) {

					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

					@SuppressWarnings({ "rawtypes", "unchecked" })
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		tableNewBusSelectBus.setSelectionBackground(new Color(102, 205, 170));
		tableNewBusSelectBus.setForeground(new Color(255, 255, 255));
		tableNewBusSelectBus.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tableNewBusSelectBus.setBackground(new Color(95, 158, 160));
		scrollPaneNewBusSelectBus.setViewportView(tableNewBusSelectBus);

		JLabel lblNewBusStartDate = new JLabel("Enter start date:");
		lblNewBusStartDate.setForeground(new Color(255, 255, 255));
		lblNewBusStartDate.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		JLabel lblNewBusEndDate = new JLabel("Enter end date:");
		lblNewBusEndDate.setForeground(new Color(255, 255, 255));
		lblNewBusEndDate.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		textFieldNewBusStartMonth = new JTextField();
		textFieldNewBusStartMonth.setForeground(new Color(255, 255, 255));
		textFieldNewBusStartMonth.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusStartMonth.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "M", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(1, 1, 1, 1)));
		textFieldNewBusStartMonth.setBackground(new Color(95, 158, 160));
		textFieldNewBusStartMonth.setColumns(10);

		textFieldNewBusStartDay = new JTextField();
		textFieldNewBusStartDay.setForeground(new Color(255, 255, 255));
		textFieldNewBusStartDay.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusStartDay.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "D", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(1, 1, 1, 1)));
		textFieldNewBusStartDay.setBackground(new Color(95, 158, 160));
		textFieldNewBusStartDay.setColumns(10);

		textFieldNewBusEndYear = new JTextField();
		textFieldNewBusEndYear.setForeground(new Color(255, 255, 255));
		textFieldNewBusEndYear.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusEndYear.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Y", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(1, 1, 1, 1)));
		textFieldNewBusEndYear.setBackground(new Color(95, 158, 160));
		textFieldNewBusEndYear.setColumns(10);

		textFieldNewBusEndDay = new JTextField();
		textFieldNewBusEndDay.setForeground(new Color(255, 255, 255));
		textFieldNewBusEndDay.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusEndDay.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "D", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(1, 1, 1, 1)));
		textFieldNewBusEndDay.setBackground(new Color(95, 158, 160));
		textFieldNewBusEndDay.setColumns(10);

		textFieldNewBusEndMonth = new JTextField();
		textFieldNewBusEndMonth.setForeground(new Color(255, 255, 255));
		textFieldNewBusEndMonth.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusEndMonth.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "M", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(1, 1, 1, 1)));
		textFieldNewBusEndMonth.setBackground(new Color(95, 158, 160));
		textFieldNewBusEndMonth.setColumns(10);

		textFieldNewBusStartYear = new JTextField();
		textFieldNewBusStartYear.setForeground(new Color(255, 255, 255));
		textFieldNewBusStartYear.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldNewBusStartYear.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Y", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(1, 1, 1, 1)));
		textFieldNewBusStartYear.setBackground(new Color(95, 158, 160));
		textFieldNewBusStartYear.setColumns(10);

		startHourInNewBusRes = new JTextField();
		startHourInNewBusRes.setForeground(Color.WHITE);
		startHourInNewBusRes.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		startHourInNewBusRes.setColumns(10);
		startHourInNewBusRes.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "H", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(1, 1, 1, 1)));
		startHourInNewBusRes.setBackground(new Color(95, 158, 160));

		startMinuteInNewBusRes = new JTextField();
		startMinuteInNewBusRes.setForeground(Color.WHITE);
		startMinuteInNewBusRes.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		startMinuteInNewBusRes.setColumns(10);
		startMinuteInNewBusRes.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Mn", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(1, 1, 1, 1)));
		startMinuteInNewBusRes.setBackground(new Color(95, 158, 160));

		endtHourInNewBusRes = new JTextField();
		endtHourInNewBusRes.setForeground(Color.WHITE);
		endtHourInNewBusRes.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		endtHourInNewBusRes.setColumns(10);
		endtHourInNewBusRes.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "H",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(1, 1, 1, 1)));
		endtHourInNewBusRes.setBackground(new Color(95, 158, 160));

		endMinuteInNewBusRes = new JTextField();
		endMinuteInNewBusRes.setForeground(Color.WHITE);
		endMinuteInNewBusRes.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		endMinuteInNewBusRes.setColumns(10);
		endMinuteInNewBusRes.setBorder(
				new CompoundBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "Mn", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(255, 255, 255)), new EmptyBorder(1, 1, 1, 1)));
		endMinuteInNewBusRes.setBackground(new Color(95, 158, 160));

		lblSearchForAvailableInNewBusRes = new JLabel("Search");
		lblSearchForAvailableInNewBusRes.setForeground(Color.WHITE);
		lblSearchForAvailableInNewBusRes.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblSearchForAvailableInNewBusRes.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(5, 5, 5, 5)));
		GroupLayout gl_panelSelectBus = new GroupLayout(panelSelectBus);
		gl_panelSelectBus.setHorizontalGroup(gl_panelSelectBus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSelectBus.createSequentialGroup()
						.addContainerGap().addGroup(gl_panelSelectBus.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewBusStartDate)
								.addGroup(gl_panelSelectBus
										.createSequentialGroup().addGroup(gl_panelSelectBus
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelSelectBus
														.createParallelGroup(Alignment.TRAILING, false)
														.addGroup(Alignment.LEADING,
																gl_panelSelectBus.createSequentialGroup()
																		.addComponent(textFieldNewBusEndMonth,
																				GroupLayout.PREFERRED_SIZE, 35,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(textFieldNewBusEndDay,
																				GroupLayout.PREFERRED_SIZE,
																				35, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(textFieldNewBusEndYear, 0, 0,
																				Short.MAX_VALUE))
														.addGroup(Alignment.LEADING,
																gl_panelSelectBus.createSequentialGroup()
																		.addComponent(textFieldNewBusStartMonth,
																				GroupLayout.PREFERRED_SIZE, 35,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(textFieldNewBusStartDay,
																				GroupLayout.PREFERRED_SIZE, 35,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(textFieldNewBusStartYear,
																				GroupLayout.PREFERRED_SIZE, 69,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(lblSearchForAvailableInNewBusRes,
																GroupLayout.PREFERRED_SIZE, 63,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(lblNewBusEndDate))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panelSelectBus.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelSelectBus.createSequentialGroup()
														.addComponent(startHourInNewBusRes, GroupLayout.PREFERRED_SIZE,
																35, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(
																startMinuteInNewBusRes, GroupLayout.PREFERRED_SIZE, 35,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panelSelectBus.createSequentialGroup()
														.addComponent(endtHourInNewBusRes, GroupLayout.PREFERRED_SIZE,
																35, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(endMinuteInNewBusRes, GroupLayout.PREFERRED_SIZE,
																35, GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panelSelectBus.setVerticalGroup(gl_panelSelectBus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSelectBus.createSequentialGroup().addGroup(gl_panelSelectBus
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSelectBus.createSequentialGroup().addContainerGap()
								.addComponent(lblNewBusStartDate).addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelSelectBus.createParallelGroup(Alignment.BASELINE)
										.addComponent(textFieldNewBusStartMonth, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldNewBusStartDay, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldNewBusStartYear, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(startHourInNewBusRes, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panelSelectBus.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelSelectBus
												.createSequentialGroup().addComponent(lblNewBusEndDate)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panelSelectBus.createParallelGroup(Alignment.BASELINE)
														.addComponent(textFieldNewBusEndMonth,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldNewBusEndDay, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldNewBusEndYear,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)))
										.addComponent(endtHourInNewBusRes, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelSelectBus.createSequentialGroup().addGap(36)
								.addComponent(startMinuteInNewBusRes, GroupLayout.PREFERRED_SIZE, 41,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
								.addComponent(endMinuteInNewBusRes, GroupLayout.PREFERRED_SIZE, 41,
										GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblSearchForAvailableInNewBusRes, GroupLayout.PREFERRED_SIZE, 31,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelSelectBus.setLayout(gl_panelSelectBus);

		tableNewBusSelectChauffeur = new JTable();
		tableNewBusSelectChauffeur.setBackground(new Color(95, 158, 160));
		tableNewBusSelectChauffeur.setSelectionBackground(new Color(102, 205, 170));
		tableNewBusSelectChauffeur.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		tableNewBusSelectChauffeur.setForeground(new Color(255, 255, 255));
		tableNewBusSelectChauffeur.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name" }) {

			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class };

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPaneNewBusSelectChauffeur.setViewportView(tableNewBusSelectChauffeur);
		panelNewBusReservationNext.setLayout(gl_panelNewBusReservationNext);
		getContentPane().setLayout(groupLayout);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	// These methods contains all code for utilities
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * This method hides all panels
	 */
	public void hideAllPanels() {
		panelTourReservations.setVisible(false);
		panelBusReservations.setVisible(false);
		panelChauffeurs.setVisible(false);
		panelBuses.setVisible(false);
		panelTours.setVisible(false);
		panelCustomers.setVisible(false);
		panelPassengers.setVisible(false);
		panelNewTourReservation.setVisible(false);
		panelNewBusReservation.setVisible(false);
		panelNewBusReservationNext.setVisible(false);
		panelPrices.setVisible(false);
		this.updateBusReservations.setVisible(false);
		this.updateTourReservationPanel.setVisible(false);
		this.updateTourPanel.setVisible(false);
		this.updateBusReservationsNext.setVisible(false);
		this.updateBusPanel.setVisible(false);
		this.updateChauffeurPanel.setVisible(false);
	}

	/**
	 * Formats the specific string, converting it to java.util.Date object
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static java.util.Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-d-H-m").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Rounds the double- type number to the specific digit, specified by the
	 * "places" parameter.
	 * 
	 * @param value
	 * @param places
	 * @return
	 */
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * Pops up orOrCancel message that asks user if he really wants to do
	 * something(usually with important methods like: remove, add etc.). There
	 * are two Buttons in alertMessage: OK and Cancel. If user presses OK
	 * Button, then the made the confirmation and the action is made after the
	 * Button is pressed. If the user presses Cancel Button, then the action is
	 * declined
	 * 
	 * @param alertMessage
	 *            - alert message that pops up
	 * @return result
	 */
	public static int okOrCancel(String alertMessage) {
		int result = JOptionPane.showConfirmDialog((Component) null, alertMessage, "Caution",
				JOptionPane.OK_CANCEL_OPTION);
		return result;
	}

	/**
	 * Returns difference between days according to startDate and endDate
	 * 
	 * @param startDate
	 *            - start date
	 * @param endDate
	 *            - end date
	 * @return days
	 */
	public static int daysBetweenDates(java.util.Date startDate, java.util.Date endDate) {
		long days = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
		return (int) days;
	}

	/**
	 * This deletes all rows in the selected table(used for search)
	 * 
	 * @param model
	 */
	public void deleteAllRows(final DefaultTableModel model) {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}

	/**
	 * This initializes externalComponents
	 */
	public void initExternalComponents() {
		this.updateBusReservationsNext = new UpdateBusReservationsNext();
		desktopPane.add(updateBusReservationsNext);

		this.updateBusReservations = new UpdateBusReservations();
		desktopPane.add(this.updateBusReservations);

		this.updateTourReservationPanel = new UpdateTourReservationPanel();
		desktopPane.add(updateTourReservationPanel);

		this.updateTourPanel = new UpdateTourPanel();
		desktopPane.add(updateTourPanel);

		this.updateChauffeurPanel = new UpdateChauffeur();
		desktopPane.add(this.updateChauffeurPanel);

		this.updateBusPanel = new UpdateBus();
		desktopPane.add(this.updateBusPanel);

	}
}
