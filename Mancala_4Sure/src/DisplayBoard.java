package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class DisplayBoard {

	private JFrame frame;

	private void show() {
		this.frame.pack();
		this.frame.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayBoard window = new DisplayBoard();
					window.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisplayBoard() {

		try {
			initialize();
		} catch (IOException e) {
			System.err.println("Failed to initialize becaus eof IOException");
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		// frame.setBounds(100, 100, 450, 300);
		// frame.se`
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		// gridBagLayout.columnWidths = new int[] { 0, 8 };
		// gridBagLayout.rowHeights = new int[] { 0, 1 };
		// gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		// gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_leftouter = new GridBagConstraints();
		gbc_leftouter.fill = GridBagConstraints.VERTICAL;
		gbc_leftouter.gridx = 0;
		gbc_leftouter.gridy = 0;
		gbc_leftouter.gridheight = 2;
		gbc_leftouter.weighty = 2;
		GridBagConstraints gbc_rightouter = new GridBagConstraints();
		gbc_rightouter.fill = GridBagConstraints.VERTICAL;
		gbc_rightouter.gridx = 7;
		gbc_rightouter.gridy = 0;
		gbc_rightouter.gridheight = 2;
		gbc_rightouter.weighty = 2;
		GridBagConstraints gbc_innertop = new GridBagConstraints(), gbc_innerbottom = new GridBagConstraints();
		Pit[] gpc_top = new Pit[6], gpc_bottom = new Pit[6];
		Pit lh = new Pit(), rh = lh;

		for (int i = 0; i < 8; i++) {
			JPanel panel = new JPanel();
			panel.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
			if (i == 0) {
				// Set constraints to gbc_leftouter
				// panel.add(new JButton("Left holder"));
				lh = new Pit("Left holder");
				lh.setPreferredSize(new Dimension(250, 400));
				frame.getContentPane().add(lh, gbc_leftouter);
			} else if (i == 7) {
				// Set constraints to gbc_leftouter
				// panel.add(new JButton("Right holder"));
				rh = new Pit("Right holder");
				rh.setPreferredSize(new Dimension(250, 400));
				frame.getContentPane().add(rh, gbc_rightouter);
			} else {
				// Set constraints to gbc_inner
				// panel.add(new JButton("Inner Pit"));
				// GridBagConstraints gbc_innertop = new GridBagConstraints();
				gbc_innertop.gridx = i;
				gbc_innertop.gridy = 0;
				gbc_innertop.insets = new Insets(0, 5, 0, 5);
				gbc_innertop.gridheight = 1;
				gbc_innertop.weighty = 1;
				// top pits
				gpc_top[i - 1] = new Pit();
				// Pit jButtonTop = new Pit();
				gpc_top[i - 1].setMarbles(4);
				frame.getContentPane().add(gpc_top[i - 1], gbc_innertop);
				gpc_bottom[i - 1] = new Pit();
				gpc_bottom[i - 1].setMarbles(4);
				// GridBagConstraints gbc_innerbottom = new GridBagConstraints();
				gbc_innerbottom.gridx = i;
				gbc_innerbottom.gridy = 1;
				gbc_innerbottom.insets = new Insets(0, 5, 0, 5);
				gbc_innerbottom.gridheight = 1;
				gbc_innerbottom.weighty = 1;
				// bottom pits
				// JButton jButtonBottom = new Pit();
				frame.getContentPane().add(gpc_bottom[i - 1], gbc_innerbottom);
			}
		}
		/**
		 * @see SetColor in progress
		 */
		lh.setEnabled(false);
		lh.setMarbles(2);
//		lh.setBorderPainted(true);
		lh.setColor(new Color(255, 0, 0));

		rh.setEnabled(false);
		rh.setMarbles(2);

		gbc_innerbottom.fill = GridBagConstraints.HORIZONTAL;
		gbc_innerbottom.gridx = 0;
		gbc_innerbottom.gridy = 2;
		gbc_innertop.insets = new Insets(0, 2, 0, 2);
		gbc_innerbottom.gridheight = 1;
		gbc_innerbottom.weighty = 1;
		JButton reset = new JButton("undo");
//		reset.addActionListener((ActionListener) new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// trigger undo logic in BoardData
//
//			}
//		});
		// reset.addActionListener(new actionListener());
		frame.getContentPane().add(reset, gbc_innerbottom);

		// GridBagConstraints gbc_panel = new GridBagConstraints();
		// gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		// gbc_panel.gridx = 0;
		// gbc_panel.gridy = 0;
		// frame.getContentPane().add(panel, gbc_panel);
	}
	// lh.setMarbles(2);

}