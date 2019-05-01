package moore.machine;
import javax.swing.*;
import com.Pojos.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
public class Frame2 {
    
    static JFrame frame;
    JLabel title;
    JButton Load;
    JLabel labels[]=new JLabel[20];
    JTextField boxes[]=new JTextField[20];
    JPanel panel1,panel2;
    
    void GUI(Machine machine){
        frame=new JFrame();
        title=new JLabel();
        Load=new JButton("Load Machine");
        title.setFont(new java.awt.Font("Tahoma", 3, 24));
        title.setText("       Enter Transition Table");
        Load.setFont(new java.awt.Font("Tahoma", 1, 18));
        Load.setText("Load Machine");
        panel1=new JPanel();
        panel2=new JPanel();
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(machine.no_of_states+1,machine.no_of_symbols+2));
        frame.add(panel1);
        panel1.add(title,BorderLayout.NORTH);
        panel1.add(Load,BorderLayout.SOUTH);
        panel1.add(panel2,BorderLayout.CENTER);
        int i,j=0,k,l=0,limit=machine.no_of_states*(machine.no_of_symbols+1);
        labels[j++]=new JLabel("States/Symbols");
        for(i=0;i<machine.no_of_symbols;i++,j++){
            labels[j]=new JLabel("              "+machine.Symbols[i]);
        }
        labels[j++]=new JLabel("        Output");
        for(i=0;i<machine.no_of_states;i++,j++){
            labels[j]=new JLabel("             Q"+i);
        }
        j=0;
        panel2.add(labels[j++]);
        for(i=0;i<machine.no_of_symbols;i++,j++){
            panel2.add(labels[j]);
        }
        panel2.add(labels[j++]);
        for(i=0;i<machine.no_of_states;i++,j++){
            panel2.add(labels[j]);
            for(k=0;k<=machine.no_of_symbols;k++,l++){
                boxes[l]=new JTextField();
                panel2.add(boxes[l]);
            }
        }
        Load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                State states[]=new State[machine.no_of_states];
                int k=0,i,j;
                for(i=0;i<machine.no_of_states;i++){
                    states[i]=new State();
                    for(j=0;j<machine.no_of_symbols;j++){
                        states[i].onSym[j]=boxes[k++].getText().substring(1);
                    }
                    states[i].output=boxes[k++].getText();
                }
                Frame3 f3=new Frame3();
                f3.main(states,machine);
                frame.dispose();
            }
	});

        
    }
    
    public static void main(Machine machine){
        Frame2 obj=new Frame2();
        obj.GUI(machine);
        frame.pack();
        frame.setLocation(350,150);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }
}
