import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private Container cp;
    private JButton jbtn1 = new JButton("範例");
    private JButton jbtn2 = new JButton("加密");
    private JButton jbtn3 = new JButton("清除");
    private JButton jbtn4 = new JButton("Exit");
    private JLabel jlab = new JLabel("key");
    private JTextField jtf = new JTextField("3");
    private JPanel jp = new JPanel(new GridLayout(6,1));
    private JTextArea jtaL = new JTextArea();
    private JTextArea jtaR = new JTextArea();
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private int n=0;

    public MainFrame(){
        initComp();
    }

    public void initComp(){
        this.setBounds(300,300,500,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jp,BorderLayout.CENTER);
        cp.add(jspL,BorderLayout.WEST);
        cp.add(jspR,BorderLayout.EAST);

        jtaL.setPreferredSize(new Dimension(200,400));
        jtaR.setPreferredSize(new Dimension(200,400));

        jp.add(jbtn1);
        jp.add(jbtn2);
 //       jlab.setHorizontalAlignment(JLabel.CENTER);
        jp.add(jlab);
        jp.add(jtf);
        jp.add(jbtn3);
        jp.add(jbtn4);

        jbtn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("Asia University, though young, put great efforts in developments of academic, " +
                        "teaching and other affairs in the last decade, and has yielded many great achievements. " +
                        "Some important ones are listed in the following.");
                jtaL.setLineWrap(true);
            }
        });
        jbtn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[] = jtaL.getText().toCharArray();
                int len = data.length;
                for(int i=0;i<len;i++){
                    data[i]+=Integer.parseInt(jtf.getText());
                }
                jtaR.setText(new String(data));
                jtaR.setLineWrap(true);
            }
        });
        jbtn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("");
                jtaR.setText("");
            }
        });
        jbtn4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
