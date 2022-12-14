package libraryManagementNew;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class searchBooks extends javax.swing.JFrame {

	/**
	 * Creates new form searchBooks
	 */
	public searchBooks() {
		initComponents();
		bookSearchBtnActionPerformedDisplay();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		inputTxt = new javax.swing.JTextField();
		bookSearchBtn = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		bookSearchTable = new javax.swing.JTable();
		Checkout = new javax.swing.JButton();
		searchHome = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		inputTxt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				inputTxtActionPerformed(evt);
			}
		});

		bookSearchBtn.setText("Search");
		bookSearchBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bookSearchBtnActionPerformed(evt);
			}
		});

		jLabel1.setText("Enter ISBN/title/author name in the text box");

		jLabel2.setText("Book Search");

		bookSearchTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null } },
				new String[] { "Title", "Name", "Authors", "Availability" }));
		bookSearchTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				bookSearchTableMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(bookSearchTable);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(20, Short.MAX_VALUE).addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		Checkout.setText("Checkout");
		Checkout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CheckoutActionPerformed(evt);
			}
		});

		searchHome.setText("Home");
		searchHome.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchHomeActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(
								jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(27, 27, 27)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel1)
												.addGroup(layout.createSequentialGroup()
														.addComponent(inputTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
																151, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(76, 76, 76).addComponent(bookSearchBtn))))
								.addGroup(layout.createSequentialGroup().addGap(165, 165, 165).addComponent(jLabel2)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addGap(104, 104, 104).addComponent(Checkout)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(searchHome).addGap(129, 129, 129)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(13, 13, 13).addComponent(jLabel2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(inputTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(bookSearchBtn))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(Checkout).addComponent(searchHome))
						.addContainerGap(33, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	
	//when search button is clicked to search for books
	private void bookSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {
		bookSearchBtnActionPerformedDisplay();
	}
	private void bookSearchBtnActionPerformedDisplay() {
		bookSearchTable.setVisible(true);
		String input_Txt = inputTxt.getText();
		try {
			Connection connect = DBConnection.connect();
			Statement st = connect.createStatement();
			String query;
			if(input_Txt == null) {
				query = "select b.ISBN, b.TITLE , a.AUTHRO , b.IS_AVAILABLE  from Book b join Book_authors ba on b.ISBN = ba.ISBN join Authors a on a.author_id = ba.author_id";
			}
			else {
			 query = "select b.ISBN, b.TITLE , a.AUTHRO , b.IS_AVAILABLE  from Book b join Book_authors ba on b.ISBN = ba.ISBN join Authors a on a.author_id = ba.author_id where b.ISBN like '%"
					+ input_Txt + "%' or b.Title like '%" + input_Txt + "%' or a.authro like '%" + input_Txt + "%'";
			}
			ResultSet rs = st.executeQuery(query);
			bookSearchTable.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void inputTxtActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public String selectedIsbn;
	public boolean selectedBookAvailable;

	// when checkout button is clicked
	private void CheckoutActionPerformed(java.awt.event.ActionEvent evt) {
		if (selectedIsbn == null) {
			JOptionPane.showMessageDialog(null, "No Book Selected");
		} else if (selectedBookAvailable == false) {
			JOptionPane.showMessageDialog(null, "Sorry! Book is unavailable");

		} else {
			String result = (String) JOptionPane.showInputDialog(null, "Card number:", "Check Out Book",
					JOptionPane.PLAIN_MESSAGE, null, null, null);
			if (result == null) {
				JOptionPane.showMessageDialog(null, "No card number entered");
			} else {
				try {
					Connection connect = DBConnection.connect();
					Statement st = connect.createStatement();
					String query = "select count(*) from borrower where card_no=\"" + result + "\";";
					ResultSet rs = st.executeQuery(query);
					int borrowerCount = 0;
					int booksBorrowedCount = 0;
					while (rs.next()) {
						borrowerCount = rs.getInt("count(*)");
					}
					rs.close();
					if (borrowerCount == 0) {
						JOptionPane.showMessageDialog(null,
								"The borrower does not exist. Please add the borrower first.");
					} else if (borrowerCount == 1) {
						String borrowedBooksSet = "select count(*) from book_loans group by card_no having card_no='"
								+ result + "';";
						ResultSet set = st.executeQuery(borrowedBooksSet);
						while (set.next()) {
							booksBorrowedCount = set.getInt("count(*)");
						}
						set.close();
						if (booksBorrowedCount >= 3) {
							JOptionPane.showMessageDialog(null, "Borrower has reached max limit of 3 books.");

						} else {
							String input_Txt = inputTxt.getText();
							String q1 = "update book set IS_AVAILABLE=0 WHERE ISBN=\"" + selectedIsbn + "\";";
							int result1 = st.executeUpdate(q1);
							String q2 = "insert into BOOK_LOANS(CARD_NO,ISBN,DATE_OUT,DUE_DATE) VALUES ('" + result
									+ "','" + selectedIsbn + "',CURDATE(),DATE_ADD(CURDATE(), INTERVAL 14 DAY));";
							int result2 = st.executeUpdate(q2);
							if (result1 == 1 && result2 == 1) {
								JOptionPane.showMessageDialog(null, "Book Checked Out Successfully");
								 query = "select b.ISBN, b.TITLE , a.AUTHRO , b.IS_AVAILABLE  from Book b join Book_authors ba on b.ISBN = ba.ISBN join Authors a on a.author_id = ba.author_id where b.ISBN like '%"
										+ input_Txt + "%' or b.Title like '%" + input_Txt + "%' or a.authro like '%" + input_Txt + "%'";
								 rs = st.executeQuery(query);
								bookSearchTable.setModel(DbUtils.resultSetToTableModel(rs));
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect card number.");
					}
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error! Please try again");
				}
			}
		}
	}
	
	//to navigate to home page
	private void searchHomeActionPerformed(java.awt.event.ActionEvent evt) {
		LibraryManagement home = LibraryManagement.home();
	}
	
	//when a record in the book search table is clicked, to fetch the selected row 
	private void bookSearchTableMouseClicked(java.awt.event.MouseEvent evt) {
		int selectedRow = bookSearchTable.getSelectedRow();
		DefaultTableModel defTableModel = (DefaultTableModel) bookSearchTable.getModel();
		selectedIsbn = defTableModel.getValueAt(selectedRow, 0).toString();
		selectedBookAvailable = (Boolean) defTableModel.getValueAt(selectedRow, 3);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(searchBooks.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(searchBooks.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(searchBooks.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(searchBooks.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new searchBooks().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton Checkout;
	private javax.swing.JButton bookSearchBtn;
	private javax.swing.JTable bookSearchTable;
	private javax.swing.JTextField inputTxt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton searchHome;
	// End of variables declaration
}
