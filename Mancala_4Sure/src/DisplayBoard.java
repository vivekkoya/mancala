import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

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
//		frame.setBounds(100, 100, 450, 300);
//		frame.se`
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[] { 0, 8 };
//		gridBagLayout.rowHeights = new int[] { 0, 1 };
//		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
//		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
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
//				"file:///home/surikoya/Documents/Fall%202022/classfiles/Eclipse-Workspace/Mancala/src/marble.jpeg");

		for (int i = 0; i < 8; i++) {
//			JPanel panel = new JPanel();
//			panel.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
			if (i == 0) {
				// Set constraints to gbc_leftouter
//				panel.add(new JButton("Left holder"));
				frame.getContentPane().add(new JButton("Left holder"), gbc_leftouter);
			} else if (i == 7) {
				// Set constraints to gbc_leftouter
//				panel.add(new JButton("Right holder"));
				frame.getContentPane().add(new JButton("Right holder"), gbc_rightouter);
			} else {
				// Set constraints to gbc_inner
				// panel.add(new JButton("Inner Pit"));
				GridBagConstraints gbc_innertop = new GridBagConstraints();
				gbc_innertop.gridx = i;
				gbc_innertop.gridy = 0;
				gbc_innertop.insets = new Insets(0, 5, 0, 5);
				gbc_innertop.gridheight = 1;
				gbc_innertop.weighty = 1;
				JButton jButtonTop = new Pit();
				frame.getContentPane().add(jButtonTop, gbc_innertop);
				GridBagConstraints gbc_innerbottom = new GridBagConstraints();
				gbc_innerbottom.gridx = i;
				gbc_innerbottom.gridy = 1;
				gbc_innerbottom.insets = new Insets(0, 5, 0, 5);
				gbc_innerbottom.gridheight = 1;
				gbc_innerbottom.weighty = 1;
				JButton jButtonBottom = new Pit();
				frame.getContentPane().add(jButtonBottom, gbc_innerbottom);
			}
		}

//		GridBagConstraints gbc_panel = new GridBagConstraints();
//		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
//		gbc_panel.gridx = 0;
//		gbc_panel.gridy = 0;

//		frame.getContentPane().add(panel, gbc_panel);

	}

}
