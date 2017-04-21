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
import java.util.ArrayList;

public class MainWindow extends Window{
   private static final long serialVersionUID = 1L;
   
   private JTextField searchByDestinationTextField;
   private JTable tableTours;
   private DefaultTableModel toursTable;
   
   private ArrayList<Tour> tours;


   @Override
   public void showLogin() {

   }

   @Override
   public void showMain() {

   }

   @Override
   public void loadData() {
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
      // SEARCH BY DESTINATION
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
                  if (substringOfDestination.equals(searchText)) {
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
                  if (substringOfDestination.equals(searchText)) {
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
                  if (substringOfDestination.equals(searchText)) {
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
   }
   
   // LIST ALL TOURS IN THE TABLE
   public void listTours() {
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
   
   // THIS DELETES ALL ROWS IN THE SELECTED TABLE(USED FOR SEARCH)
   public void deleteAllRows(final DefaultTableModel model) {
      for (int i = model.getRowCount() - 1; i >= 0; i--) {
         model.removeRow(i);
      }
   }
   
   // GUI COMPONENTS
   public void initComponents() {
      
      JPanel panel = new JPanel();
      panel.setBackground(new Color(95, 158, 160));
      
      JPanel mainWindowTopPanel = new JPanel();
      mainWindowTopPanel.setBackground(new Color(0, 128, 128));
      
      JLabel lblToursArchive = new JLabel("Tours Archive");
      lblToursArchive.setForeground(Color.WHITE);
      lblToursArchive.setFont(new Font("Century Gothic", Font.PLAIN, 20));
      GroupLayout gl_mainWindowTopPanel = new GroupLayout(mainWindowTopPanel);
      gl_mainWindowTopPanel.setHorizontalGroup(
         gl_mainWindowTopPanel.createParallelGroup(Alignment.LEADING)
            .addGap(0, 1518, Short.MAX_VALUE)
            .addGroup(gl_mainWindowTopPanel.createSequentialGroup()
               .addContainerGap()
               .addComponent(lblToursArchive, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
               .addContainerGap(1268, Short.MAX_VALUE))
      );
      gl_mainWindowTopPanel.setVerticalGroup(
         gl_mainWindowTopPanel.createParallelGroup(Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
            .addGroup(gl_mainWindowTopPanel.createSequentialGroup()
               .addComponent(lblToursArchive, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
               .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      mainWindowTopPanel.setLayout(gl_mainWindowTopPanel);
      
      JScrollPane scrollPaneToursArchive = new JScrollPane();
      scrollPaneToursArchive.setBorder(new CompoundBorder(

                  new TitledBorder(new LineBorder(new Color(255, 255, 255), 1, true), "Tours archive",

                        TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)),

                  new EmptyBorder(3, 3, 3, 3)));
      scrollPaneToursArchive.setBackground(new Color(95, 158, 160));
      
      JLabel label = new JLabel("Search by Destination:");
      label.setForeground(Color.WHITE);
      label.setFont(new Font("Century Gothic", Font.PLAIN, 14));
      
      searchByDestinationTextField = new JTextField();
      searchByDestinationTextField.setColumns(10);
      searchByDestinationTextField.setBorder(new LineBorder(new Color(255, 255, 255)));
      searchByDestinationTextField.setBackground(new Color(95, 158, 160));
      GroupLayout gl_panel = new GroupLayout(panel);
      gl_panel.setHorizontalGroup(
         gl_panel.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panel.createSequentialGroup()
               .addComponent(mainWindowTopPanel, GroupLayout.DEFAULT_SIZE, 1518, Short.MAX_VALUE)
               .addGap(0))
            .addGroup(gl_panel.createSequentialGroup()
               .addContainerGap()
               .addComponent(scrollPaneToursArchive, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
               .addContainerGap(906, Short.MAX_VALUE))
            .addGroup(gl_panel.createSequentialGroup()
               .addContainerGap()
               .addComponent(label, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(ComponentPlacement.RELATED)
               .addComponent(searchByDestinationTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
               .addContainerGap(1165, Short.MAX_VALUE))
      );
      gl_panel.setVerticalGroup(
         gl_panel.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panel.createSequentialGroup()
               .addComponent(mainWindowTopPanel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
               .addGap(18)
               .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                  .addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                  .addComponent(searchByDestinationTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(ComponentPlacement.RELATED)
               .addComponent(scrollPaneToursArchive, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
               .addContainerGap(281, Short.MAX_VALUE))
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
            .addGroup(groupLayout.createSequentialGroup()
               .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(panel, GroupLayout.PREFERRED_SIZE, 1518, GroupLayout.PREFERRED_SIZE)
               .addContainerGap())
      );
      groupLayout.setVerticalGroup(
         groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
               .addComponent(panel, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
               .addContainerGap(64, Short.MAX_VALUE))
      );
      setLayout(groupLayout);
   
   }



}
