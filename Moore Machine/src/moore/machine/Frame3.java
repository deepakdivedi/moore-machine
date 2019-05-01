package moore.machine;
import javax.swing.*;
import com.Pojos.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class Frame3 {
    
    static JFrame frame;
    JButton evaluate,newinput,newmachine;
    JLabel ip,op,output;
    JTextField input;
    JPanel panel1,panel2,panel3,panel4;
    
    void GUI(State[] states,Machine machine){
        frame=new JFrame();
        ip=new JLabel();
        op=new JLabel();
        output=new JLabel();
        input=new JTextField(15);
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        evaluate=new JButton();
        newinput=new JButton();
        newmachine=new JButton();
        
        ip.setFont(new java.awt.Font("Tahoma", 3, 24));
        ip.setText("       Input String : ");
        op.setFont(new java.awt.Font("Tahoma", 3, 24));
        op.setText("       Output : ");
        output.setFont(new java.awt.Font("Tahoma", 3, 24));
        output.setText("");
        evaluate.setFont(new java.awt.Font("Calibri", 2, 14));
        evaluate.setText("Evaluate String");
        newinput.setFont(new java.awt.Font("Calibri", 2, 14));
        newinput.setText("New Input String");
        newmachine.setFont(new java.awt.Font("Calibri", 2, 14));
        newmachine.setText("New Machine");
        
        panel1.setLayout(new GridLayout(3, 1));
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new FlowLayout());
        panel4.setLayout(new FlowLayout());
        
        frame.add(panel1);
        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);
        panel2.add(ip);
        panel2.add(input);
        panel3.add(op);
        panel3.add(output);
        panel4.add(evaluate);
        panel4.add(newinput);
        panel4.add(newmachine);
        
        evaluate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                char inputs[]=input.getText().toCharArray();
                int i,current=0,sym;
                for(i=0;i<inputs.length;i++){
                    sym=checksym(inputs[i],machine);
                    if(sym==-1){
                     output.setText("INVALID STRING!");
                     break;
                    }
                    else{
                        current=Integer.parseInt(states[current].onSym[sym]);
                        output.setText(output.getText()+""+states[current].output);
                    }
                }
            }
	});
        
        newinput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                input.setText("");
                output.setText("");
            }
	});
        
        newmachine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Frame1 f1=new Frame1();
                f1.main();
                frame.dispose();
            }
	});
    }
    
    int checksym(char ip,Machine machine){
        int i;
        for(i=0;i<machine.no_of_symbols;i++){
            if(machine.Symbols[i].equals(ip+"")){
                return i;
            }
        }
        return -1;
    }
 
    public void main(State[] states,Machine machine){
        Frame3 obj=new Frame3();
        obj.GUI(states,machine);
        frame.pack();
        frame.setLocation(350,150);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }
}
