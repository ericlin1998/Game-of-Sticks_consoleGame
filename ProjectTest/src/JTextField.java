import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JTextField {
	JTextField input;
	JTextArea output;
	
	public JTextField(){
		createGui();
	}
	
	public void createGui(){
		input = new JTextField(20);
		input.addActionListener(this);
		output = new JTextArea(5,20);
		output.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(jtAreaOutput, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagLayout gridBag = new GridBagLayout();
		Container contentPane = getContentPane();
		contentPane.setLayout(gridBag);
		GridBagConstraints gridCons1 = new GridBagConstraints();
		gridCons1.gridwidth = GridBagConstraints.REMAINDER;
		gridCons1.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(jtfInput, gridCons1);
		GridBagConstraints gridCons2 = new GridBagConstraints();
		gridCons2.weightx = 1.0;
		gridCons2.weighty = 1.0;
		contentPane.add(scrollPane, gridCons2);
	}
	}
}
