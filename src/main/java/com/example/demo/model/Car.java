package com.example.demo.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Table(name = "CarTable") //Create table automatically
@Entity //to use relation with other tables
public class Car {
	
	@Id //value will be unique
	@GeneratedValue(strategy = GenerationType.AUTO ) //database will generate unique id
	@Column(name = "Id") //id column will be in table 
	private int id;
	
	@NotEmpty
	@NotNull
	@Size(min = 3 , max = 20) //rakstiskai vertibais ir Size
	@Column(name = "Engine")
	private String engine;//"" by default
	
	
	@NotNull
	@Min(0) //skaitliskai vertibai ir min un max
	@Max(400)
	@Column(name = "Speed")
	private double speed; // 0.0 by default
	
	
	@NotNull
	@Min(1700) //skaitliskai vertibai ir min un max
	@Max(2019)
	@Column(name = "Year")
	private int year; //0 by default
	
	@NotEmpty
	@NotNull
	@Size(min = 3 , max = 10) //rakstiskai vertibais ir Size
	@Pattern(regexp= "[a-zA-z]+", message = "only letters allowed")
	@Column(name = "Color")
	private String color; //"" by default
	
	
	//private static int idCounter = 0;
	
	public Car()
	{
		
	}
	
	public Car(String e, double s, int y, String c)
	{
		engine = e;
		speed = s;
		year = y;
		color = c;
		//setEngine(e);
		//setSpeed(s);
		//setYear(y);
		//setColor(c);
		//setId();
	}
	
	public int getId()
	{
		return id;
	}
	
	/*public void setId()
	{
		this.id = idCounter;
		idCounter++;
	}*/

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		/*if (speed >= 0 && speed <= 250)
			this.speed = speed;
		else
			this.speed = 50;*/
		this.speed = speed;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		/*if (year > 1700 && year < 2019)
			this.year = year;
		else {
			Date date = new Date();
			this.year = date.getYear()+1900;//119
		}*/
		this.year = year;

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		/*if (color != null) {
			boolean isOnlyLetters = false;
			for (int i = 0; i < color.length(); i++) {
				if (Character.isLetter(color.charAt(i)))
				{
					isOnlyLetters = true;
				}
				else {
					isOnlyLetters = false;
					break;
				}
			}
			if (isOnlyLetters)
			{
				this.color = color;
			}
			else
			{
				this.color = "Red";
			}
		} else
		{
			this.color = "None";
		}*/
		this.color = color;

	}

	@Override
	public String toString() {
		return ""+engine +" " + speed + " km/h " + year + " " + color;
		}

}