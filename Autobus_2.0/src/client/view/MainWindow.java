package client.view;

import autoBus.Tour;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainWindow extends Window{
   public MainWindow() {
   }
   private static final long serialVersionUID = 1L;
   
   private JTextField searchByDestinationTextField;
   private JTable tableTours;
   private DefaultTableModel toursTable;
   private DefaultTableModel selectTourTable;
   private JButton btnLogout;
   private JTextField startDayTextField;
   private JTextField startMonthTextField;
   private JTextField startYearTextField;
   private JTextField startHourTextField;
   private JTextField startMinuteTextField;
   private JTextField EndDayTextField;
   private JTextField endMonthTextField;
   private JTextField endYearTextField;
   private JTextField endHourTextField;
   private JTextField endMinuteTextField;
   
   private java.util.List<Tour> tours;
   private JLabel searchButton;



   @Override
   public void showLogin() {
      view.setCurrentWindow(LOGIN);
   }

   @Override
   public void showMain() {

   }

   @Override
   public void loadData() {
      tours = controller.getTours();

      toursTable = (DefaultTableModel) tableTours.getModel();
      deleteAllRows(toursTable);
      Object[] rowData = new Object[9];
      for (int i = 0; i < tours.size(); i++) {
         rowData[0] = tours.get(i).getDepartureDate();
         rowData[1] = tours.get(i).getDestination();
         rowData[2] = tours.get(i).getPickUpPlacesString();
         rowData[3] = tours.get(i).getSeatsAvailable();
         rowData[4] = tours.get(i).getTotalPrice();
         rowData[5] = tours.get(i).getPricePerPassenger();
         rowData[6] = tours.get(i).getBusAndType();
         rowData[7] = tours.get(i).getChauffeur();
         rowData[8] = tours.get(i).getServicesString();
         toursTable.addRow(rowData);
      }

   }

   public void createEvents() {
      //
      //LOGOUT BUTTON
      //
      btnLogout.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseReleased(java.awt.event.MouseEvent e) {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to log out from the system?")==0){
               try {
                  controller.logout();
               } catch (RemoteException ex) {
                  JOptionPane.showMessageDialog(MainWindow.this,"Could not contact the server.");
               }
            }
         }
      });

      //
      // SEARCH BY DESTINATION
      //
      searchByDestinationTextField.getDocument().addDocumentListener(new DocumentListener() {
         public void deleteAllRows(final DefaultTableModel model) {
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
               model.removeRow(i);
            }
         }

         public void changedUpdate(DocumentEvent e) {
            DefaultTableModel toursTableModel;
            deleteAllRows(toursTableModel = (DefaultTableModel) tableTours.getModel());
            String searchText;
            if (!(searchText = searchByDestinationTextField.getText()).equals("")) {
               Object[] rowData = new Object[9];
               for (int i = 0; i < tours.size(); i++) {
                  String destination = tours.get(i).getDestination();
                  String substringOfDestination = destination.substring(0,
                        searchText.length() <= destination.length() ? searchText.length()
                              : destination.length());
                  if (substringOfDestination.toLowerCase().equals(searchText.toLowerCase())) {
                     rowData[0] = tours.get(i).getDepartureDate();
                     rowData[1] = tours.get(i).getDestination();
                     rowData[2] = tours.get(i).getPickUpPlacesString();
                     rowData[3] = tours.get(i).getSeatsAvailable();
                     rowData[4] = tours.get(i).getTotalPrice();
                     rowData[5] = tours.get(i).getPricePerPassenger();
                     rowData[6] = tours.get(i).getBusAndType();
                     rowData[7] = tours.get(i).getChauffeur();
                     rowData[8] = tours.get(i).getServicesString();
                     toursTableModel.addRow(rowData);
                  }
               }
            } else {
               deleteAllRows(toursTableModel = (DefaultTableModel) tableTours.getModel());
               Object[] rowData = new Object[9];
               for (int i = 0; i < tours.size(); i++) {
                  rowData[0] = tours.get(i).getDepartureDate();
                  rowData[1] = tours.get(i).getDestination();
                  rowData[2] = tours.get(i).getPickUpPlacesString();
                  rowData[3] = tours.get(i).getSeatsAvailable();
                  rowData[4] = tours.get(i).getTotalPrice();
                  rowData[5] = tours.get(i).getPricePerPassenger();
                  rowData[6] = tours.get(i).getBusAndType();
                  rowData[7] = tours.get(i).getChauffeur();
                  rowData[8] = tours.get(i).getServicesString();
                  toursTableModel.addRow(rowData);
               }
            }
         }

         public void removeUpdate(DocumentEvent e) {
            DefaultTableModel toursTableModel;
            deleteAllRows(toursTableModel = (DefaultTableModel) tableTours.getModel());
            String searchText;
            if (!(searchText = searchByDestinationTextField.getText()).equals("")) {
               Object[] rowData = new Object[9];
               for (int i = 0; i < tours.size(); i++) {
                  String destination = tours.get(i).getDestination();
                  String substringOfDestination = destination.substring(0,
                        searchText.length() <= destination.length() ? searchText.length()
                              : destination.length());
                  if (substringOfDestination.toLowerCase().equals(searchText.toLowerCase())) {
                     rowData[0] = tours.get(i).getDepartureDate();
                     rowData[1] = tours.get(i).getDestination();
                     rowData[2] = tours.get(i).getPickUpPlacesString();
                     rowData[3] = tours.get(i).getSeatsAvailable();
                     rowData[4] = tours.get(i).getTotalPrice();
                     rowData[5] = tours.get(i).getPricePerPassenger();
                     rowData[6] = tours.get(i).getBusAndType();
                     rowData[7] = tours.get(i).getChauffeur();
                     rowData[8] = tours.get(i).getServicesString();
                     toursTableModel.addRow(rowData);
                  }
               }
            } else {
               deleteAllRows(toursTableModel = (DefaultTableModel) tableTours.getModel());
               Object[] rowData = new Object[9];
               for (int i = 0; i < tours.size(); i++) {
                  rowData[0] = tours.get(i).getDepartureDate();
                  rowData[1] = tours.get(i).getDestination();
                  rowData[2] = tours.get(i).getPickUpPlacesString();
                  rowData[3] = tours.get(i).getSeatsAvailable();
                  rowData[4] = tours.get(i).getTotalPrice();
                  rowData[5] = tours.get(i).getPricePerPassenger();
                  rowData[6] = tours.get(i).getBusAndType();
                  rowData[7] = tours.get(i).getChauffeur();
                  rowData[8] = tours.get(i).getServicesString();
                  toursTableModel.addRow(rowData);
               }
            }
         }

         public void insertUpdate(DocumentEvent e) {
            DefaultTableModel toursTableModel;
            deleteAllRows(toursTableModel = (DefaultTableModel) tableTours.getModel());
            String searchText;
            if (!(searchText = searchByDestinationTextField.getText()).equals("")) {
               Object[] rowData = new Object[9];
               for (int i = 0; i < tours.size(); i++) {
                  String destination = tours.get(i).getDestination();
                  String substringOfDestination = destination.substring(0,
                        searchText.length() <= destination.length() ? searchText.length()
                              : destination.length());
                  if (substringOfDestination.toLowerCase().equals(searchText.toLowerCase())) {
                     rowData[0] = tours.get(i).getDepartureDate();
                     rowData[1] = tours.get(i).getDestination();
                     rowData[2] = tours.get(i).getPickUpPlacesString();
                     rowData[3] = tours.get(i).getSeatsAvailable();
                     rowData[4] = tours.get(i).getTotalPrice();
                     rowData[5] = tours.get(i).getPricePerPassenger();
                     rowData[6] = tours.get(i).getBusAndType();
                     rowData[7] = tours.get(i).getChauffeur();
                     rowData[8] = tours.get(i).getServicesString();
                     toursTableModel.addRow(rowData);
                  }
               }
            } else {
               deleteAllRows(toursTableModel = (DefaultTableModel) tableTours.getModel());
               Object[] rowData = new Object[9];
               for (int i = 0; i < tours.size(); i++) {
                  rowData[0] = tours.get(i).getDepartureDate();
                  rowData[1] = tours.get(i).getDestination();
                  rowData[2] = tours.get(i).getPickUpPlacesString();
                  rowData[3] = tours.get(i).getSeatsAvailable();
                  rowData[4] = tours.get(i).getTotalPrice();
                  rowData[5] = tours.get(i).getPricePerPassenger();
                  rowData[6] = tours.get(i).getBusAndType();
                  rowData[7] = tours.get(i).getChauffeur();
                  rowData[8] = tours.get(i).getServicesString();
                  toursTableModel.addRow(rowData);
               }
            }
         }
         
         
      });
      
      // SEARCH BY DATE INTERVAL
      searchButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseReleased(java.awt.event.MouseEvent e) {
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
            Calendar timeNow = Calendar.getInstance();
            int currentYear = timeNow.get(Calendar.YEAR);
            try {
               monthStart = Integer.parseInt(startMonthTextField.getText());
               if (monthStart > 12 || monthStart < 1)
                  str = str + "\nStart month does not seem to be a number between 1-12!";
            } catch (NumberFormatException e1) {
               str = str + "\nStart month does not seem to be a number between 1-12!";
            }
            try {
               dayStart = Integer.parseInt(startDayTextField.getText());
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
               yearStart = Integer.parseInt(startYearTextField.getText());
               if (yearStart < currentYear)
                  str = str + "\nStart year does not appear to be a valid number!";
            } catch (NumberFormatException e1) {
               str = str + "\nStart year does not appear to be a valid number!";
            }

            try {
               monthEnd = Integer.parseInt(endMonthTextField.getText());
               if (monthEnd > 12 || monthEnd < 1)
                  str = str + "\nEnd month does not seem to be a number between 1-12!";
            } catch (NumberFormatException e1) {
               str = str + "\nEndt month does not seem to be a number between 1-12!";
            }
            try {
               dayEnd = Integer.parseInt(EndDayTextField.getText());
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
               yearEnd = Integer.parseInt(endYearTextField.getText());
               if (yearEnd < currentYear)
                  str = str + "\nEnd year does not appear to be a valid number!";
            } catch (NumberFormatException e1) {
               str = str + "\nEnd year does not appear to be a valid number!";
            }
            try {
               hourStart = Integer.parseInt(startHourTextField.getText());
               if (hourStart < 0 && hourStart > 23)
                  str = str + "\nStart hour does not appear to be a number between 0-23!";
            } catch (NumberFormatException e1) {
               str = str + "\nStart hour does not appear to be a valid number!";
            }
            try {
               hourEnd = Integer.parseInt(endHourTextField.getText());
               if (hourEnd < 0 && hourEnd > 23)
                  str = str + "\nEnd hour does not appear to be a number between 0-23!";
            } catch (NumberFormatException e1) {
               str = str + "\nEnd hour does not appear to be a valid number!";
            }
            try {
               minuteStart = Integer.parseInt(startMinuteTextField.getText());
               if (minuteStart < 0 && minuteStart > 59)
                  str = str + "\nStart minute does not appear to be a number between 0-59!";
            } catch (NumberFormatException e1) {
               str = str + "\nStart minute does not appear to be a valid number!";
            }
            try {
               minuteEnd = Integer.parseInt(endMinuteTextField.getText());
               if (minuteEnd < 0 && minuteEnd > 59)
                  str = str + "\nEnd minute does not appear to be a number between 0-59!";
            } catch (NumberFormatException e1) {
               str = str + "\nEnd minute does not appear to be a valid number!";
            }
            if (str.equals("")) {
               startDate = parseDate(
                     yearStart + "-" + monthStart + "-" + dayStart + "-" + hourStart + "-" + minuteStart);
               endDate = parseDate(yearEnd + "-" + monthEnd + "-" + dayEnd + "-" + hourEnd + "-" + minuteEnd);
               listTours(startDate, endDate);
            } else {
               JOptionPane.showMessageDialog(null, "Some of the fields were filled incorrectly:" + str);
            }
         }
      });
   }

   
   // THIS DELETES ALL ROWS IN THE SELECTED TABLE(USED FOR SEARCH)
   public void deleteAllRows(final DefaultTableModel model) {
      for (int i = model.getRowCount() - 1; i >= 0; i--) {
         model.removeRow(i);
      }
   }
   
   // FORMATS THE SPECIFIC STRING, CONVERTING IT TO DATE OBJECT
   public static java.util.Date parseDate(String date) {
      try {
         return new SimpleDateFormat("yyyy-MM-d-H-m").parse(date);
      } catch (ParseException e) {
         return null;
      }
   }
   
   // THIS METHOD LISTS TOURS FOR DATE INTERVAL SEARCH
   
   public void listTours(java.util.Date startDate, java.util.Date endDate) {
      selectTourTable = (DefaultTableModel) tableTours.getModel();
      deleteAllRows(selectTourTable);
      Object[] rowData = new Object[9];
         for (int i = 0; i < tours.size(); i++) {
            if(overlap(startDate, endDate, tours.get(i).getNewDateInterval()[0], tours.get(i).getNewDateInterval()[1])) {
            rowData[0] = tours.get(i).getDepartureDate();
            rowData[1] = tours.get(i).getDestination();
            rowData[2] = tours.get(i).getPickUpPlacesString();
            rowData[3] = tours.get(i).getSeatsAvailable();
            rowData[4] = tours.get(i).getTotalPrice();
            rowData[5] = tours.get(i).getPricePerPassenger();
            rowData[6] = tours.get(i).getBusAndType();
            rowData[7] = tours.get(i).getChauffeur();
            rowData[8] = tours.get(i).getServicesString();
            selectTourTable.addRow(rowData);
            }
         }
   }

   // THIS CHECKS IF THE TIME PERIOD OVERLAPS ANOTHER ONE
   public boolean overlap(Date start1, Date end1, Date start2, Date end2){
      return start1.getTime() <= end2.getTime() && start2.getTime() <= end1.getTime() && end2.getTime() <= end1.getTime();
   }

   // GUI COMPONENTS
   public void initComponents() {

      setAlignmentX(Component.LEFT_ALIGNMENT);
      setAlignmentY(Component.TOP_ALIGNMENT);

      JPanel panel = new JPanel();
      panel.setBackground(new Color(95, 158, 160));

      JPanel mainWindowTopPanel = new JPanel();
      mainWindowTopPanel.setBackground(new Color(0, 128, 128));

      JLabel lblToursArchive = new JLabel("Tours Archive");
      lblToursArchive.setForeground(Color.WHITE);
      lblToursArchive.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      
      btnLogout = new JButton("Log out");
      GroupLayout gl_mainWindowTopPanel = new GroupLayout(mainWindowTopPanel);
      gl_mainWindowTopPanel.setHorizontalGroup(
         gl_mainWindowTopPanel.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_mainWindowTopPanel.createSequentialGroup()
               .addContainerGap()
               .addComponent(lblToursArchive, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(ComponentPlacement.RELATED, 423, Short.MAX_VALUE)
               .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
               .addGap(234))
      );
      gl_mainWindowTopPanel.setVerticalGroup(
         gl_mainWindowTopPanel.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_mainWindowTopPanel.createSequentialGroup()
               .addGroup(gl_mainWindowTopPanel.createParallelGroup(Alignment.BASELINE)
                  .addComponent(lblToursArchive, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                  .addComponent(btnLogout))
               .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      mainWindowTopPanel.setLayout(gl_mainWindowTopPanel);
      
      JLabel label = new JLabel("Search by Destination:");
      label.setForeground(Color.WHITE);
      label.setFont(new Font("Century Gothic", Font.PLAIN, 14));
      
      searchByDestinationTextField = new JTextField();
      searchByDestinationTextField.setColumns(10);
      searchByDestinationTextField.setBorder(new LineBorder(new Color(255, 255, 255)));
      searchByDestinationTextField.setBackground(new Color(95, 158, 160));
      
      JLabel lblSearchByDate = new JLabel("Search by Date Interval:");
      lblSearchByDate.setForeground(Color.WHITE);
      lblSearchByDate.setFont(new Font("Century Gothic", Font.PLAIN, 14));
      
      JLabel label_1 = new JLabel("Start date:");
      label_1.setForeground(Color.WHITE);
      label_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      
      startDayTextField = new JTextField();
      startDayTextField.setForeground(Color.WHITE);
      startDayTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      startDayTextField.setColumns(10);
      startDayTextField.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "DD",


                        TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
      startDayTextField.setBackground(new Color(95, 158, 160));
      
      startMonthTextField = new JTextField();
      startMonthTextField.setSelectionColor(new Color(102, 205, 170));
      startMonthTextField.setSelectedTextColor(Color.WHITE);
      startMonthTextField.setForeground(Color.WHITE);
      startMonthTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      startMonthTextField.setColumns(10);
      startMonthTextField.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MM",


                        TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
      startMonthTextField.setBackground(new Color(95, 158, 160));
      
      startYearTextField = new JTextField();
      startYearTextField.setForeground(Color.WHITE);
      startYearTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      startYearTextField.setColumns(10);
      startYearTextField.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY",


                        TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
      startYearTextField.setBackground(new Color(95, 158, 160));
      
      startHourTextField = new JTextField();
      startHourTextField.setSelectionColor(new Color(102, 205, 170));
      startHourTextField.setSelectedTextColor(Color.WHITE);
      startHourTextField.setForeground(Color.WHITE);
      startHourTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      startHourTextField.setColumns(10);
      startHourTextField.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "HH",


                        TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
      startHourTextField.setBackground(new Color(95, 158, 160));
      
      startMinuteTextField = new JTextField();
      startMinuteTextField.setSelectionColor(new Color(102, 205, 170));
      startMinuteTextField.setSelectedTextColor(Color.WHITE);
      startMinuteTextField.setForeground(Color.WHITE);
      startMinuteTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      startMinuteTextField.setColumns(10);
      startMinuteTextField.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MIN",


                        TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
      startMinuteTextField.setBackground(new Color(95, 158, 160));
      
      JLabel lblEndDate = new JLabel("End date:");
      lblEndDate.setForeground(Color.WHITE);
      lblEndDate.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      
      EndDayTextField = new JTextField();
      EndDayTextField.setForeground(Color.WHITE);
      EndDayTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      EndDayTextField.setColumns(10);
      EndDayTextField.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "DD",



                              TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
      EndDayTextField.setBackground(new Color(95, 158, 160));
      
      endMonthTextField = new JTextField();
      endMonthTextField.setSelectionColor(new Color(102, 205, 170));
      endMonthTextField.setSelectedTextColor(Color.WHITE);
      endMonthTextField.setForeground(Color.WHITE);
      endMonthTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      endMonthTextField.setColumns(10);
      endMonthTextField.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MM",



                              TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
      endMonthTextField.setBackground(new Color(95, 158, 160));
      
      endYearTextField = new JTextField();
      endYearTextField.setForeground(Color.WHITE);
      endYearTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      endYearTextField.setColumns(10);
      endYearTextField.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "YYYY",



                              TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
      endYearTextField.setBackground(new Color(95, 158, 160));
      
      endHourTextField = new JTextField();
      endHourTextField.setSelectionColor(new Color(102, 205, 170));
      endHourTextField.setSelectedTextColor(Color.WHITE);
      endHourTextField.setForeground(Color.WHITE);
      endHourTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      endHourTextField.setColumns(10);
      endHourTextField.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "HH",



                              TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
      endHourTextField.setBackground(new Color(95, 158, 160));
      
      endMinuteTextField = new JTextField();
      endMinuteTextField.setSelectionColor(new Color(102, 205, 170));
      endMinuteTextField.setSelectedTextColor(Color.WHITE);
      endMinuteTextField.setForeground(Color.WHITE);
      endMinuteTextField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      endMinuteTextField.setColumns(10);
      endMinuteTextField.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "MIN",



                              TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
      endMinuteTextField.setBackground(new Color(95, 158, 160));
      
      searchButton = new JLabel("Search");
      searchButton.setForeground(Color.WHITE);
      searchButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
      searchButton.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255), 1, true), new EmptyBorder(3, 3, 3, 3)));
      
      JScrollPane scrollPaneToursArchive = new JScrollPane();
      scrollPaneToursArchive.setBorder(new CompoundBorder(

      

                    new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Tours archive",

      

                            TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),

      

                    new EmptyBorder(3, 3, 3, 3)));
      scrollPaneToursArchive.setBackground(new Color(95, 158, 160));
      GroupLayout gl_panel = new GroupLayout(panel);
      gl_panel.setHorizontalGroup(
         gl_panel.createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_panel.createSequentialGroup()
               .addComponent(mainWindowTopPanel, GroupLayout.DEFAULT_SIZE, 1134, Short.MAX_VALUE)
               .addGap(0))
            .addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
               .addContainerGap()
               .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_panel.createSequentialGroup()
                     .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                           .addComponent(label, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(ComponentPlacement.RELATED)
                           .addComponent(searchByDestinationTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblSearchByDate, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_panel.createSequentialGroup()
                           .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(ComponentPlacement.UNRELATED)
                           .addComponent(startDayTextField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(ComponentPlacement.RELATED)
                           .addComponent(startMonthTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(ComponentPlacement.RELATED)
                           .addComponent(startYearTextField, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(ComponentPlacement.RELATED)
                           .addComponent(startHourTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(ComponentPlacement.RELATED)
                           .addComponent(startMinuteTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                           .addComponent(lblEndDate, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(ComponentPlacement.UNRELATED)
                           .addComponent(EndDayTextField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(ComponentPlacement.RELATED)
                           .addComponent(endMonthTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(ComponentPlacement.RELATED)
                           .addComponent(endYearTextField, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(ComponentPlacement.RELATED)
                           .addComponent(endHourTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(ComponentPlacement.RELATED)
                           .addComponent(endMinuteTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
                     .addGap(30)
                     .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                  .addComponent(scrollPaneToursArchive, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE))
               .addContainerGap(522, Short.MAX_VALUE))
      );
      gl_panel.setVerticalGroup(
         gl_panel.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panel.createSequentialGroup()
               .addComponent(mainWindowTopPanel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
               .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_panel.createSequentialGroup()
                     .addPreferredGap(ComponentPlacement.UNRELATED)
                     .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchByDestinationTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                     .addPreferredGap(ComponentPlacement.UNRELATED)
                     .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_panel.createSequentialGroup()
                           .addComponent(lblSearchByDate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(ComponentPlacement.RELATED)
                           .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                              .addComponent(startYearTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                              .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                 .addComponent(startDayTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                 .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                              .addComponent(startMonthTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(startHourTextField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(startMinuteTextField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                     .addPreferredGap(ComponentPlacement.RELATED)
                     .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                        .addComponent(lblEndDate, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addComponent(EndDayTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(endMonthTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(endYearTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addComponent(endHourTextField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addComponent(endMinuteTextField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                  .addGroup(gl_panel.createSequentialGroup()
                     .addGap(105)
                     .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
               .addPreferredGap(ComponentPlacement.UNRELATED)
               .addComponent(scrollPaneToursArchive, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
               .addGap(341))
      );
      
      tableTours = new JTable();
      tableTours.setModel(new DefaultTableModel(
         new Object[][] {
         },
         new String[] {
            "Date", "Destination", "Pick up", "Seats Available", "Current Total Price", "Price Per Passenger", "Bus# / type", "Chauffeur", "Services"
         }
      ));
      tableTours.setSelectionBackground(new Color(102, 205, 170));
      tableTours.setForeground(Color.WHITE);
      tableTours.setFont(new Font("Century Gothic", Font.PLAIN, 12));
      tableTours.setBackground(new Color(95, 158, 160));
      scrollPaneToursArchive.setViewportView(tableTours);
      panel.setLayout(gl_panel);
      GroupLayout groupLayout = new GroupLayout(this);
      groupLayout.setHorizontalGroup(
         groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
               .addComponent(panel, GroupLayout.DEFAULT_SIZE, 2301, Short.MAX_VALUE)
               .addContainerGap())
      );
      groupLayout.setVerticalGroup(
         groupLayout.createParallelGroup(Alignment.TRAILING)
            .addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
      );
      setLayout(groupLayout);
      
   
   }



}
