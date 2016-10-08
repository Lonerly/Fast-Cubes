import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Help() {
		setTitle("Help");
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JTextPane txtpnPurposeOfThis = new JTextPane();
		txtpnPurposeOfThis.setBackground(Color.DARK_GRAY);
		txtpnPurposeOfThis.setForeground(Color.WHITE);
		txtpnPurposeOfThis.setText(
				"Purpose of this game is to create magic square using the variables on the left side of the program and droping them on prefered place. You must also remember that you can't use same numbers everywhere.");
		GridBagConstraints gbc_txtpnPurposeOfThis = new GridBagConstraints();
		gbc_txtpnPurposeOfThis.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnPurposeOfThis.fill = GridBagConstraints.BOTH;
		gbc_txtpnPurposeOfThis.gridx = 0;
		gbc_txtpnPurposeOfThis.gridy = 0;
		contentPane.add(txtpnPurposeOfThis, gbc_txtpnPurposeOfThis);

		JButton btnOkayGotIt = new JButton("Okay, got it!");
		btnOkayGotIt.addActionListener(e -> this.dispose());
		btnOkayGotIt.setBackground(Color.GRAY);
		btnOkayGotIt.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnOkayGotIt = new GridBagConstraints();
		gbc_btnOkayGotIt.fill = GridBagConstraints.BOTH;
		gbc_btnOkayGotIt.gridx = 0;
		gbc_btnOkayGotIt.gridy = 1;
		contentPane.add(btnOkayGotIt, gbc_btnOkayGotIt);
	}

}
