/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitasku;

/**
 *
 * @author vitco
 */
import javax.swing.*; //importing swing package
import java.awt.*; //importing awt package
public class Second extends JFrame
{
	public Second()
	{
		setTitle("MyWindow"); //setting title of frame as  MyWindow
		JLabel lb = new JLabel("Welcome to My Second Window");//Creating a label named Welcome to My Second Window
		add(lb);                        //adding label to frame.
		setLayout(new FlowLayout());    //setting layout using FlowLayout object.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setting close operation.
		setSize(400, 400);              //setting size
		setVisible(true);               //setting frame visibility
	}

	public static void main(String[] args)
	{
		new Second();
	}
}