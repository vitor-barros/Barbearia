package viewer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import model.ModelException;

public class JanelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfTelefone;
	private JTextField tfCpf;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCliente frame = new JanelaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaCliente() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

// Nome area

		tfNome = new JTextField();
		tfNome.setForeground(Color.GRAY);
		tfNome.setText("Digite o seu nome aqui");

		tfNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfNome.getText().equals("Digite o seu nome aqui")) {
					tfNome.setText("");
					tfNome.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfNome.getText().isEmpty()) {
					tfNome.setForeground(Color.GRAY);
					tfNome.setText("Digite o seu nome aqui");
				}
			}
		});

		tfNome.setBounds(93, 69, 130, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		tfNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!isVisible())
					return;
				tfNome.setBackground(Color.WHITE);
				String nome = tfNome.getText();
				if (nome.equals("Digite o seu nome aqui"))
					return;
				try {
					Cliente.validarNome(nome);
				} catch (ModelException e1) {
					JOptionPane.showMessageDialog(lblNewLabel, "Erro: " + e1);
					tfNome.requestFocus();
				}
			}
		});

// telefone area
		tfTelefone = new JTextField();
		tfTelefone.setForeground(Color.GRAY);
		tfTelefone.setText("Digite o telefone aqui");

		tfTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfTelefone.getText().equals("Digite o telefone aqui")) {
					tfTelefone.setText("");
					tfTelefone.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfTelefone.getText().isEmpty()) {
					tfTelefone.setForeground(Color.GRAY);
					tfTelefone.setText("Digite o telefone aqui");
				}
			}
		});

		tfTelefone.setBounds(102, 90, 130, 26);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);

		tfTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!isVisible())
					return;
				tfTelefone.setBackground(Color.WHITE);
				String telefone = tfTelefone.getText();
				if (telefone.equals("Digite o telefone aqui"))
					return;
				try {
					Cliente.validarTelefone(telefone);
				} catch (ModelException e1) {
					JOptionPane.showMessageDialog(lblNewLabel, "Erro: " + e1);
					tfTelefone.requestFocus();
				}
			}
		});


// cpf area
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setBounds(18, 52, 61, 16);
		contentPane.add(lblNewLabel_3);

		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(102, 47, 130, 26);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);


		JButton btnCancelarcli = new JButton("Cancelar");
		btnCancelarcli.setBounds(18, 158, 117, 29);
		contentPane.add(btnCancelarcli);

		JButton btnSalvarcli = new JButton("Salvar");
		btnSalvarcli.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {}
			@SuppressWarnings("unused")
			String nome = tfNome.getText();
			@SuppressWarnings("unused")
			String cpf = tfCpf.getText();
			@SuppressWarnings("unused")
			String telefone = tfTelefone.getText();

		});
		btnSalvarcli.setBounds(145, 158, 117, 29);
		contentPane.add(btnSalvarcli);

		lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setBounds(18, 95, 61, 16);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(18, 14, 61, 16);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(102, 9, 130, 26);
		contentPane.add(textField);

	}

}
