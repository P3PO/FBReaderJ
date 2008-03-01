package org.zlibrary.ui.android.dialogs;

import java.util.HashMap;

import org.zlibrary.core.dialogs.ZLSelectionDialog;
import org.zlibrary.core.dialogs.ZLTreeHandler;
import org.zlibrary.core.dialogs.ZLTreeNode;

class ZLAndroidSelectionDialog extends ZLSelectionDialog {
	/*
	private static final String OPTION_GROUP_NAME = "OpenFileDialog";
	private static final HashMap ourIcons = new HashMap(); // <string, ImageIcon>
	private static final String ourIconDirectory = "icons/filetree/";

	private final JDialog myDialog;
	private final JTextField myStateLine = new JTextField();
	private final JList myList = new JList();
	private OKAction myOKAction;
	
	private boolean myReturnValue = false;
	*/
	
	protected ZLAndroidSelectionDialog(String caption, ZLTreeHandler myHandler) {
		super(myHandler);
		/*
		myDialog = new JDialog(frame);
		myDialog.setTitle(caption);
		update();
		*/
	}

	protected void exitDialog() {
		//myDialog.hide();
	}

	public boolean run() {
		/*
		myDialog.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				myWidthOption.setValue(myDialog.getWidth());
				myHeightOption.setValue(myDialog.getHeight());
			}
		});
		myDialog.setLayout(new BorderLayout());
		myStateLine.setEditable(!handler().isOpenHandler());
		myStateLine.setEnabled(!handler().isOpenHandler());
		myDialog.add(myStateLine, BorderLayout.NORTH);
	
		myList.setCellRenderer(new CellRenderer());
		JScrollPane scrollPane = new JScrollPane(myList);
		scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());		
		myDialog.add(scrollPane, BorderLayout.CENTER);
		
		myList.addListSelectionListener(new SelectionListener());
		myList.addKeyListener(new MyKeyAdapter());
		myList.addMouseListener(new MyMouseListener());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton button1 = ZLAndroidDialogManager.createButton(ZLAndroidDialogManager.OK_BUTTON);
		myOKAction = new OKAction(button1.getText());
		button1.setAction(myOKAction);
		JButton button2 = ZLAndroidDialogManager.createButton(ZLAndroidDialogManager.CANCEL_BUTTON);
		button2.setAction(new CancelAction (button2.getText()));
		if (button1.getPreferredSize().width < button2.getPreferredSize().width) {
			button1.setPreferredSize(button2.getPreferredSize());
		} else {
			button2.setPreferredSize(button1.getPreferredSize());
		}
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		myDialog.add(buttonPanel, BorderLayout.SOUTH);
		
		myDialog.pack();
		myList.requestFocusInWindow();	
		myDialog.setSize(myWidthOption.getValue(), myHeightOption.getValue());
		myDialog.setLocationRelativeTo(myDialog.getParent());
		myDialog.setModal(true);
		myDialog.setVisible(true);
		
		return myReturnValue;
		*/
		return false;
	}

	protected void selectItem(int index) {
		//myList.setSelectedIndex(index);
		//myList.ensureIndexIsVisible(index);
	}

	protected void updateList() {
		//myList.setListData(handler().subnodes().toArray());
	}

	protected void updateStateLine() {
		//myStateLine.setText(handler().stateDisplayName());
	}
	
	/*
	private static ImageIcon getIcon(ZLTreeNode node) {
		final String pixmapName = node.pixmapName();
		ImageIcon icon = (ImageIcon) ourIcons.get(pixmapName);
		if (icon == null) {
			icon = ZLAndroidIconUtil.getIcon(ourIconDirectory + pixmapName + ".png");
			ourIcons.put(pixmapName, icon);
		}
		return icon;
	}
	
	private void changeFolder(int index) {
		ZLTreeNode node = (ZLTreeNode) handler().subnodes().get(index);
		myReturnValue = !node.isFolder();
        runNode(node);
	}
	
	private class MyMouseListener extends MouseInputAdapter {
		public void mouseClicked(MouseEvent e) {
			if (!((System.getProperty("os.name").startsWith("Windows")) && (e.getClickCount() == 1))) {
				changeFolder(myList.locationToIndex(e.getPoint()));
			}		
		}	
	}
	
	private class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			final int code = e.getKeyCode();	
			switch (code) {
			case KeyEvent.VK_ENTER:
				changeFolder(myList.getSelectedIndex());
				break;
			case KeyEvent.VK_ESCAPE:
				exitDialog();
				break;
			}
		}
	}
	
	private class CancelAction extends AbstractAction {
		public CancelAction(String text) {
			putValue(NAME, text);
		}
		
		public void actionPerformed(ActionEvent e) {
			exitDialog();
		}		
	}
	
	private class OKAction extends AbstractAction {
		public OKAction(String text) {
			putValue(NAME, text);
			setEnabled(false);
		}
		
		public void actionPerformed(ActionEvent e) {
			myReturnValue = true;
			runNode((ZLTreeNode) handler().subnodes().get(myList.getSelectedIndex())); 
		}
	}
	
	private class SelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			int index = myList.getSelectedIndex();
			myOKAction.setEnabled(index != -1 && !((ZLTreeNode) handler().subnodes().get(index)).isFolder());
		}		
	}
	
	private static class CellRenderer extends JLabel implements ListCellRenderer {
		
		public Component getListCellRendererComponent(
			JList list,
			Object value,            // value to display
			int index,               // cell index
			boolean isSelected,      // is the cell selected
			boolean cellHasFocus)    // the list and the cell have the focus
		{
			String s = ((ZLTreeNode) value).displayName();
			setText(s);
			setIcon(ZLAndroidSelectionDialog.getIcon((ZLTreeNode) value));
			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			setOpaque(true);			
			return this;
		}
	}
	*/	
}