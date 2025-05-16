import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
* @author Frank LaMantia
* Used only 220 materials
*/

public class Animations {
	
	
	public static ArrayList<BufferedImage> smallNums() {
		ArrayList<BufferedImage> smallNums = new ArrayList<>();
		
		try {
			smallNums.add(ImageIO.read(new File("src/Images/SmallNumbers/small_0.png")));
			smallNums.add(ImageIO.read(new File("src/Images/SmallNumbers/small_1.png")));
			smallNums.add(ImageIO.read(new File("src/Images/SmallNumbers/small_2.png")));
			smallNums.add(ImageIO.read(new File("src/Images/SmallNumbers/small_3.png")));
			smallNums.add(ImageIO.read(new File("src/Images/SmallNumbers/small_4.png")));
			smallNums.add(ImageIO.read(new File("src/Images/SmallNumbers/small_5.png")));
			smallNums.add(ImageIO.read(new File("src/Images/SmallNumbers/small_6.png")));
			smallNums.add(ImageIO.read(new File("src/Images/SmallNumbers/small_7.png")));
			smallNums.add(ImageIO.read(new File("src/Images/SmallNumbers/small_8.png")));
			smallNums.add(ImageIO.read(new File("src/Images/SmallNumbers/small_9.png")));
			
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("small Numbers Failed to Load");
		}
		
		return smallNums;
		
	}
	
	public static ArrayList<BufferedImage> bigNums() {
		ArrayList<BufferedImage> bigNums = new ArrayList<>();
		
		try {
			bigNums.add(ImageIO.read(new File("src/Images/BigNumbers/Big_1.png")));
			bigNums.add(ImageIO.read(new File("src/Images/BigNumbers/Big_2.png")));
			bigNums.add(ImageIO.read(new File("src/Images/BigNumbers/Big_3.png")));
			bigNums.add(ImageIO.read(new File("src/Images/BigNumbers/Big_4.png")));
			bigNums.add(ImageIO.read(new File("src/Images/BigNumbers/Big_5.png")));
			bigNums.add(ImageIO.read(new File("src/Images/BigNumbers/Big_6.png")));
			bigNums.add(ImageIO.read(new File("src/Images/BigNumbers/Big_7.png")));
			bigNums.add(ImageIO.read(new File("src/Images/BigNumbers/Big_8.png")));
			bigNums.add(ImageIO.read(new File("src/Images/BigNumbers/Big_9.png")));
			bigNums.add(ImageIO.read(new File("src/Images/BigNumbers/Big_0.png")));
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Big Numbers Failed to Load");
		}
		
		return bigNums;
		
	}
	

	public static ArrayList<BufferedImage> clubs() {
		ArrayList<BufferedImage> clubs = new ArrayList<>();
		
		try {
			clubs.add(ImageIO.read(new File("src/Images/Clubs/Driver.png")));
			clubs.add(ImageIO.read(new File("src/Images/Clubs/Iron.png")));
			clubs.add(ImageIO.read(new File("src/Images/Clubs/Wedge.png")));
			clubs.add(ImageIO.read(new File("src/Images/Clubs/Putter.png")));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Clubs Failed to Load");
		}
		
		return clubs;
		
	}
	
	public static ArrayList<BufferedImage> windDirections() {
		ArrayList<BufferedImage> wind = new ArrayList<>();
		
		try {
			wind.add(ImageIO.read(new File("src/Images/Wind/N-Wind.png")));
			wind.add(ImageIO.read(new File("src/Images/Wind/NE-Wind.png")));
			wind.add(ImageIO.read(new File("src/Images/Wind/E-Wind.png")));
			wind.add(ImageIO.read(new File("src/Images/Wind/SE-Wind.png")));
			wind.add(ImageIO.read(new File("src/Images/Wind/S-Wind.png")));
			wind.add(ImageIO.read(new File("src/Images/Wind/SW-Wind.png")));
			wind.add(ImageIO.read(new File("src/Images/Wind/W-Wind.png")));
			wind.add(ImageIO.read(new File("src/Images/Wind/NW-Wind.png")));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Wind Failed to Load");
		}
		
		return wind;
		
	}

	public static ArrayList<BufferedImage> ballArc() {
		ArrayList<BufferedImage> ball = new ArrayList<>();
		
		try {
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Sprites_0000.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Sprites_0001.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Sprites_0002.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Sprites_0003.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Sprites_0004.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Sprites_0005.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Sprites_0006.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Sprites_0007.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Sprites_0008.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Sprites_0009.png")));
			ball.add(ImageIO.read(new File("src/Images/Ball/Ball-Sprites_0010.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Golfball Animation Failed to Load");
		}
		
		return ball;
		
	}
}
