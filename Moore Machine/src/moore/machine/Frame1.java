package moore.machine;
import javax.swing.*;
import com.Pojos.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class Frame1 {
    Machine machine=new Machine();
    static JFrame frame;
    JLabel title,state,symbol,symbols;
    JButton transition;
    JTextField nsta,nsym,syms;
    JPanel panel1,panel2,panel3,panel4,panel5;
    
    void GUI(){
        frame=new JFrame();
        title=new JLabel();
        state=new JLabel();
        symbol=new JLabel();
        symbols=new JLabel();
        title.setFont(new java.awt.Font("Calibri", 3, 24));
        title.setText("                     MOORE MACHINE");
        state.setFont(new java.awt.Font("Tahoma", 1, 18));
        state.setText("No. Of States :                     ");
        symbol.setFont(new java.awt.Font("Tahoma", 1, 18));
        symbol.setText("No. Of Symbols :                  ");
        symbols.setFont(new java.awt.Font("Tahoma", 1, 18));
        symbols.setText("Symbols (Seperate by ',') : ");
        transition=new JButton();
        transition.setFont(new java.awt.Font("Calibri", 2, 14));
        transition.setText("Enter Transition Table");
        nsta=new JTextField(10);
        nsym=new JTextField(10);
        syms=new JTextField(10);
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        panel5=new JPanel();
        frame.add(panel1);
        panel1.setLayout(new BorderLayout());
        panel1.add(title,BorderLayout.NORTH);
        panel1.add(transition,BorderLayout.SOUTH);
        panel1.add(panel2,BorderLayout.CENTER);
        panel2.setLayout(new GridLayout(3,1));
        panel3.setLayout(new FlowLayout());
        panel4.setLayout(new FlowLayout());
        panel5.setLayout(new FlowLayout());
        
        panel3.add(state);
        panel3.add(nsta);
        panel4.add(symbol);
        panel4.add(nsym);
        panel5.add(symbols);
        panel5.add(syms);
        panel2.add(panel3);
        panel2.add(panel4);
        panel2.add(panel5);
        
        transition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                machine.no_of_states=Integer.parseInt(nsta.getText());
                machine.no_of_symbols=Integer.parseInt(nsym.getText());
                machine.Symbols=syms.getText().split(",");
                
                Frame2 f2=new Frame2();
                f2.main(machine);
                frame.dispose();
            }
	});
    }
    
     public static void main(){
        Frame1 obj=new Frame1();
        obj.GUI();
        frame.setSize(400,300);
        frame.setLocation(350,150);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }     
}


