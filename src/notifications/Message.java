package notifications;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Message extends JDialog {
	private static final long serialVersionUID = 1L;
    public static final int NORMAL_MESSAGE = 0;
	public static final int CONFIRMATION_MESSAGE = 1;
	public static final int WARNING_MESSAGE = -2;
	public static final int ERROR_MESSAGE = -1;

	private JLabel jLabelMain;
	private JLabel jLabelIcon;
	private JLabel[] jLabelText;	
	private JButton jButtonOK;
	
	private String[] message;
	private int messageType;

	public Message(String message, int messageType) {
		this.message = getMessage(message);
		this.messageType = messageType;
		initialComponent();
	}


	private void initialComponent() {
		
		jLabelMain = new JLabel();
		jLabelIcon = new JLabel();
		jLabelText = new JLabel[3];	
		jButtonOK = new JButton();
		
        jLabelMain.setBounds(0, 0, 400, 200);
        jLabelMain.setLayout(null);
        
        
        jLabelIcon.setBounds(10, 33, 70, 70);
        if(messageType == CONFIRMATION_MESSAGE){
        	jLabelIcon.setIcon(new ImageIcon(getClass().getResource("/imgs/MessageConfirmation.png")));
        }
        else if(messageType == WARNING_MESSAGE){
        	jLabelIcon.setIcon(new ImageIcon(getClass().getResource("/imgs/MessageWarning.png")));
        }
        else if(messageType == ERROR_MESSAGE){
        	jLabelIcon.setIcon(new ImageIcon(getClass().getResource("/imgs/MessageError.png")));
        }
        else {
        	jLabelIcon.setIcon(new ImageIcon(getClass().getResource("/imgs/MessageNormal.png")));
        }
        
        for(int i=0; i<3; i++){
        	jLabelText[i] = new JLabel();
	        jLabelText[i].setBounds(100, 40+i*25, 280, 25);
	        jLabelText[i].setFont(new Font("Lucida", 0, 16));
	        jLabelText[i].setText(message[i]);
		}
        
        jButtonOK.setText("OK");
        jButtonOK.setBounds(310, 130, 60, 30);
        jButtonOK.setBackground(new Color(212, 227, 250));
        jButtonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });
        jButtonOK.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
	    	put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), "ENTER_pressed");
	    jButtonOK.getActionMap().put("ENTER_pressed", new AbstractAction() {
	        private static final long serialVersionUID = 1L;
            public void actionPerformed(ActionEvent evt) {
	        	jButtonOKActionPerformed(evt);
	        }
	    });
		
		jLabelMain.add(jLabelIcon);
		jLabelMain.add(jLabelText[0]);
		jLabelMain.add(jLabelText[1]);
		jLabelMain.add(jLabelText[2]);
		jLabelMain.add(jButtonOK);
	
		setIconImage(new ImageIcon(getClass().getResource("")).getImage());
		setBounds(240, 200, 400, 200);
		setTitle("Message");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setModal(true);
		add(jLabelMain);
		setVisible(true);
	}

	
	private void jButtonOKActionPerformed(ActionEvent evt){
		dispose();
	}

	private String[] getMessage(String message){
		String[] messages = new String[3];
		
		if(message.contains("\n")){
			messages[0] = message.substring(0, message.indexOf("\n"));
			message = message.substring(message.indexOf("\n")+1);
			if(message.contains("\n")){
				messages[1] = message.substring(0, message.indexOf("\n"));
				messages[2] = message.substring(message.indexOf("\n")+1);
				
			}else{
				messages[1] = message;
			}
		}else{
			messages[0] = message;
		}
		return messages;
	}																			
}
