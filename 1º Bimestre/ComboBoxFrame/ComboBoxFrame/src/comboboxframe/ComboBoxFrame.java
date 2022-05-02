package comboboxframe;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame {

    private JComboBox imagesJComboBox; // caixa de combinação para armazenar nomes de ícones
    private JLabel label; // rótulo para exibir ícone selecionado
    private static final String[] names= {"banana.gif", "Luffy.gif", "ombrelo.gif", "gif-Amungs.gif"};
    private Icon[] icons = {
        new ImageIcon(getClass().getResource(names[0])),
        new ImageIcon(getClass().getResource(names[1])),
        new ImageIcon(getClass().getResource(names[2])),
        new ImageIcon(getClass().getResource(names[3]))
    };

    // construtor ComboBoxFrame adiciona JComboBox ao JFrame
    public ComboBoxFrame() {
        super("Testing JComboBox");
        setLayout(new FlowLayout()); // confi gura o layout de frame

        imagesJComboBox = new JComboBox(names); // confi gura JComboBox
        imagesJComboBox.setMaximumRowCount(3); // exibe três linhas

        imagesJComboBox.addItemListener(
                new ItemListener() // classe interna anônima
        {
            // trata evento JComboBox
            public void itemStateChanged(ItemEvent event) {
                // determina se o item selecionado
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
                }
            } // fi m do método itemStateChanged
        } // fi m da classe interna anônima
        ); // fi m da chamada para addItemListener

        add(imagesJComboBox); // adiciona combobox ao JFrame
        label = new JLabel(icons[0]); // exibe primeiro ícone
        add(label); // adiciona rótulo ao JFrame
    } // fi m do construtor ComboBoxFrame
} // 
