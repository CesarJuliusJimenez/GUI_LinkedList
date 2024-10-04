import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

class BSCS2_Celajes_Jimenez_Soriano_Finals_LinkedList {

static Scanner userInput = new Scanner(System.in);
	
	static Node head; //the head of the list
	static boolean ifDataNotFound = false;
	
	static class Node
	{
		int data;
		Node next;
		
		//Constructor of the Node class
		public Node(int data) 
		{
			this.data = data;
			this.next = null;
		}
	}
	
	//INSERTION AT THE BEGINNING USER DEFINED METHOD
	static void insertAtBeginning(int newData) 
	{
		Node newNode = new Node(newData);
		
		//if head is null then the newNode next will be null
		if(head == null)
			newNode.next = null;
		
		//else makes next of the new node as the head
		//example 1 2 3, ung susunod na node ay yung current head which is 1 then, if iinput si 4 sya na po ang magiging head so magiging 4 1 2 3
		newNode.next = head;
		
		//the head will be the new node
		head = newNode;
	}
	
	//INSERTION AT THE END USER DEFINED METHOD
	static void insertAtEnd(int newData) 
	{	
		Node newNode = new Node(newData);
		
		//set temp to null for initialization
		Node temp = null;
		
		//data of new node will be the newData and its next is null
		newNode.data = newData;
		newNode.next = null;
		
		//if head is null then the head will be the newNode
		//linked list is still empty then ung head po ay magiging node bale macrecreate ng newNode po sa empty linked list
		if(head == null)
			head = newNode;
		
		//temp will be the head and it will traverse till the last node which is currently null
		else 
		{
			temp = head;
			//it will check if the linked list still has value in it until it becomes null then it will insert the inserAtEnd value at the end part
			while(temp.next != null) 
				temp = temp.next;
			
			//then the node is inserted at the last part
			temp.next = newNode;
		}
	}
	
	//DELETION OF NODE USER DEFINED METHOD
	static void delNode(int dataDel) 
	{
		//if linked list is empty then immediately return
		if (head == null) 
		{
			System.out.println("\nLinked list is empty.");
			return;
		}
		
		//set node variables to null for initialization
		Node prevNode = null, node = null;
		
		//if head node itself has the data to be deleted
		if(head.data == dataDel) 
		{
			head = head.next; //changes the head
			return; //already stops 
		}
		
		node = head;
		
		//traverses the linked list until it finds the data in that nodes that is going to be deleted
		while(node != null && node.data != dataDel) 
		{
			prevNode = node; //prevNode gets the node 
			node = node.next; //node will then transfer to the next node
		}
		
		//if node is null meaning data was not found
		if (node == null) 
		{
			ifDataNotFound = true;
			System.out.println("\nDATA not found.");
			return;
		}
		
		//unlinks the node from the linked list
		//wherein deletion is performed
		prevNode.next = node.next;
	}
	
	//DISPLAY OF CURRENT LINKEDLIST USER DEFINED METHOD
	public static String display() 
	{
		//if linked list becames empty
		if(head == null) 
		{
			System.out.println("Linked list is empty.");
			return "Linked list is empty.";
		}
		
		//only for GUI to print DATA not found
		if(ifDataNotFound) 
		{
			ifDataNotFound = false;
			return "DATA not found.";
		}
		
		Node current = head;
		String list = "";
		
		//prints the linkedlist data
		while (current != null) 
		{
			System.out.print("[ " + current.data + " ] --> ");
			list += "[ " + current.data + " ] --> "; //list = list = current.data	
            
			current = current.next;
		}
		
		System.out.println("[ " + current + " ]");
		
		return list + "[ " + current + " ]";
	}

}

@SuppressWarnings("serial")
public class BSCS2_Celajes_Jimenez_Soriano_Final extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;

	//Launching GUI
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					BSCS2_Celajes_Jimenez_Soriano_Final frame = new BSCS2_Celajes_Jimenez_Soriano_Final();
					frame.setVisible(true);
				} 
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}


    //Create the frame.
	public BSCS2_Celajes_Jimenez_Soriano_Final() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(72, 209, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setTitle("Linked List GUI by Celajes, Jimenez, Soriano. | [1BSCS2]");
		
		//TEXT AREA
		JTextArea DisplayLL = new JTextArea();
		DisplayLL.setFont(new Font("Monospaced", Font.PLAIN, 20));
		DisplayLL.setBackground(new Color(255, 250, 205));
		DisplayLL.setBounds(10, 90, 766, 242);
		contentPane.add(DisplayLL);
		
		//SCROLL PANE
		JScrollPane scrollPane = new JScrollPane(DisplayLL);
		scrollPane.setBounds(10, 90, 766, 242);
		contentPane.add(scrollPane);
		
		//PANEL
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 130, 238));
		panel.setBounds(10, 11, 766, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//INSERT AT BEGINNING BUTTON
		JButton insertAtBegButton = new JButton("Insert At Beginning");
		insertAtBegButton.setForeground(new Color(128, 0, 128));
		insertAtBegButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		insertAtBegButton.setBackground(new Color(211, 211, 211));
		insertAtBegButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				BSCS2_Celajes_Jimenez_Soriano_Finals_LinkedList.insertAtBeginning(Integer.parseInt(textField.getText()));
			}
		});
		insertAtBegButton.setBounds(10, 11, 130, 45);
		insertAtBegButton.setFocusable(false);
		panel.add(insertAtBegButton);
		
		//INSERT AT BEGINNING BUTTON
		JButton insertAtEndButton = new JButton("Insert At End");
		insertAtEndButton.setForeground(new Color(128, 0, 128));
		insertAtEndButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		insertAtEndButton.setBackground(new Color(211, 211, 211));
		insertAtEndButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				BSCS2_Celajes_Jimenez_Soriano_Finals_LinkedList.insertAtEnd(Integer.parseInt(textField.getText()));
			}
		});
		insertAtEndButton.setBounds(164, 11, 125, 45);
		insertAtEndButton.setFocusable(false);
		panel.add(insertAtEndButton);
		
		//DELETE BUTTON
		JButton deleteButton = new JButton("Delete");
		deleteButton.setForeground(new Color(255, 0, 0));
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		deleteButton.setBackground(new Color(211, 211, 211));
		deleteButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				BSCS2_Celajes_Jimenez_Soriano_Finals_LinkedList.delNode(Integer.parseInt(textField.getText()));
			}
		});
		deleteButton.setBounds(311, 11, 125, 45);
		deleteButton.setFocusable(false);
		panel.add(deleteButton);
		
		//DISPLAY BUTTON
		JButton displayButton = new JButton("Display");
		displayButton.setForeground(new Color(0, 100, 0));
		displayButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		displayButton.setBackground(new Color(211, 211, 211));
		displayButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DisplayLL.setText(BSCS2_Celajes_Jimenez_Soriano_Finals_LinkedList.display());
			}
		});
		displayButton.setBounds(457, 11, 125, 45);
		displayButton.setFocusable(false);
		panel.add(displayButton);
		
		//TEXT FIELD
		JLabel enterText = new JLabel("Enter Data:");
		enterText.setBounds(591, 11, 79, 45);
		panel.add(enterText);
		enterText.setFont(new Font("Arial", Font.ITALIC, 14));
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(new Color(255, 228, 196));
		textField.setBounds(670, 23, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

	}

}
