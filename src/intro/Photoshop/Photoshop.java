package intro.Photoshop;
// Photoshop program that can run several manipulations on 
// an image
// filler code by Mr. David

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class Photoshop extends Component {

	// the name of the output file. will be determined by which methods are called
    private String outputName;
    
    // the 2d array of colors representing the image
    private Color[][] pixels;
    
    // the width and height of the image 
    private int w,h;
    

    // this method increases each color's rgb value by a given amount.
    // don't forget that rgb values are limited to the range [0,255]
    public void brighten(int amount) { // brighten the images by "amount" of rgb value
        outputName = "brightened_" + outputName; // alter the output file's name
		for (int i = 0; i < pixels.length; i++) { // go through the pixels
			for (int j = 0; j < pixels[i].length; j++) {
				int r = Math.max(Math.min(pixels[i][j].getRed() + amount, 255), 0); // add 255 to r, g, and b to increase brightness
				int g = Math.max(Math.min(pixels[i][j].getGreen() + amount, 255), 0);
				int b = Math.max(Math.min(pixels[i][j].getBlue() + amount, 255), 0);
				pixels[i][j] = new Color(r, g, b); // replace the current pixel with the new pixel
			}
		}
    }
    
    // flip an image either horizontally or vertically.
    public void flip(boolean horizontally) { // flip the image vertically or horizontally based on user's choice represented by the boolean
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName; // change the output file's name based on user's flip choice
		Color[][] copy = new Color[pixels.length][pixels[0].length]; // copy the array for backup
        for (int i = 0; i < pixels.length; i++) {
			System.arraycopy(pixels[i], 0, copy[i], 0, pixels[i].length); // copy
		}
		if (!horizontally) {
			for (int i = 0; i < pixels.length; i++) { // go through rows
				System.arraycopy(copy[pixels.length - i - 1], 0, pixels[i], 0, pixels[i].length); //replace each row's pixels
			}
		}
		else {
			for (int i = 0; i < pixels.length; i++) { // go through rows
				for (int j = 0; j < pixels[i].length; j++) { // go through columns
					pixels[i][j] = copy[i][pixels[i].length - j - 1]; // replace each pixel
				}
			}
		}
    }
    
    // negates an image
    // to do this: subtract each pixel's rgb value from 255 
    // and use this as the new value
    public void negate() { // negate the image
        outputName = "negated_" + outputName; // update file's name
		for (int i = 0; i < pixels.length; i++) { // go through each row
			for (int j = 0; j < pixels[i].length; j++) { // go through each column
				int r = 255 - pixels[i][j].getRed(); // negate each pixel's r, g, and b value
				int g = 255 - pixels[i][j].getGreen();
				int b = 255 - pixels[i][j].getBlue();
				pixels[i][j] = new Color(r, g, b); // replace current pixel with new pixel
			}
		}
    }
    
    // this makes the image 'simpler' by redrawing it using only a few colors
    // to do this: for each pixel, find the color in the list that is closest to
    // the pixel's rgb value. 
    // use this predefined color as the rgb value for the changed image.
    public void simplify() { // simplify image with limited amount of colors
		// the list of colors to compare to. Feel free to change/add colors
		Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
                Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN}; // a predefined list of colors
        outputName = "simplified_" + outputName; // change the output file's name
        for (int i = 0; i < pixels.length; i++) { // go through each row
			for (int j = 0; j < pixels[i].length; j++) { // go through each column
				double best_color_value = 100000; // define the best value variable and give it a large value to begin with
				int best_color_id = 0; // record the best value's id
				for (int k = 0; k < colorList.length; k++) { // go through the colors' list
					double distance_value = distance(pixels[i][j], colorList[k]); // get the current color's distance value
					if (distance_value < best_color_value) { // if the current color's distance value is better than the best one before
						best_color_id = k; // record the new color's id
						best_color_value = distance_value; // replace the old value with the new best value
					}
				}
				pixels[i][j] = colorList[best_color_id]; // replace the current pixel with the most similar color from the list
			}
		}
        // your code here
         
    }
    
    // optional helper method (recommended) that finds the 'distance' 
    // between two colors.
    // use the 3d distance formula to calculate
    public double distance(Color c1, Color c2) { // get the r, g, b value's difference of two colors
		int r = c1.getRed(), g = c1.getGreen(), b = c1.getBlue(), new_r = c2.getRed(), new_g = c2.getGreen(), new_b = c2.getBlue(); // get the values
		return Math.sqrt(Math.pow(r - new_r, 2) + Math.pow(g - new_g, 2) + Math.pow(b - new_b, 2)); // return the distance value
    }
    
    // this blurs the image
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values 
    // with the current pixel's own rgb value. 
    // divide this sum by 9, and set it as the rgb value for the blurred image
    public void blur() { // blur the image
		outputName = "blurred_" + outputName; // change the file's name
		int[][] search = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {0, 0}}; // a search array that will be useful later for directions
		Color[][] copy = new Color[pixels.length][pixels[0].length]; // copy the array for backup
		for (int i = 0; i < pixels.length; i++) { // go through the rows
			System.arraycopy(pixels[i], 0, copy[i], 0, pixels[i].length); // copy each row
		}
		for (int i = 0; i < pixels.length; i++) { // go through each row
			for (int j = 0; j < pixels[i].length; j++) { // go through each column
				int sum_r = 0, sum_g = 0, sum_b = 0, count = 0; // record the sum values and the total accessible neighbor pixels
				for (int[] ints : search) { // go through all the neighboring directions
					int new_x = i + ints[0], new_y = j + ints[1]; // new pixels
					if (new_x < 0 || new_y < 0 || new_x >= pixels.length || new_y >= pixels[i].length) continue; // see if it is out of bounds
					sum_r += copy[new_x][new_y].getRed(); // add the r, g, b, and count values if the pixel is valid
					sum_g += copy[new_x][new_y].getGreen();
					sum_b += copy[new_x][new_y].getBlue();
					count++;
				}
				pixels[i][j] = new Color(sum_r / count, sum_g / count, sum_b / count); // get the new pixel's value and replace the original pixel with it
			}
		}
	}
    
    // this highlights the edges in the image, turning everything else black. 
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values. 
    // now, multiply the current pixel's rgb value by 8, then subtract the sum.
    // this value is the rgb value for the 'edged' image
    public void edge() {
        outputName = "edged_" + outputName; // change the file's name
		int[][] search = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}}; // an array that predefines neighboring pixels' directions
		Color[][] copy = new Color[pixels.length][pixels[0].length]; // copy the array for backup
		for (int i = 0; i < pixels.length; i++) { // go through each row
			System.arraycopy(pixels[i], 0, copy[i], 0, pixels[i].length); // copy each row
		}
		for (int i = 0; i < pixels.length; i++) { // go through each row
			for (int j = 0; j < pixels[i].length; j++) { // go through each column
				int sum_r = 0, sum_g = 0, sum_b = 0, count = 0; // record the sum of r, g, b, and the number of accessible neighboring pixels
				for (int[] ints : search) { // go through each direction
					int new_x = i + ints[0], new_y = j + ints[1]; // get coordinates of new searching pixels
					if (new_x < 0 || new_y < 0 || new_x >= pixels.length || new_y >= pixels[i].length) continue; // see if the new coordinate is out of bounds
					sum_r += copy[new_x][new_y].getRed(); // add to r, g, b, and count sum values if the new coordinate is valid
					sum_g += copy[new_x][new_y].getGreen();
					sum_b += copy[new_x][new_y].getBlue();
					count++;
				}
				int new_red = copy[i][j].getRed() * count - sum_r, new_green = copy[i][j].getGreen() * count - sum_g, new_blue = copy[i][j].getBlue() * count - sum_b; // get the new pixel's r, g, and b values
				pixels[i][j] = new Color(Math.max(0, Math.min(new_red, 255)), Math.max(0, Math.min(new_green, 255)), Math.max(0, Math.min(new_blue, 255))); // replace the old pixel with the new pixel and check if the values are valid
			}
		}
    }

	public void filter(int filter_number) {
		outputName = "filtered_" + outputName;
		if (filter_number == 0) { // Grayscale Filter
			for (int i = 0; i < pixels.length; i++) { // go through row
				for (int j = 0; j < pixels[i].length; j++) { // go through each column
					int gray = (pixels[i][j].getRed() + pixels[i][j].getGreen() + pixels[i][j].getBlue()) / 3; // filter each pixel
					pixels[i][j] = new Color(gray, gray, gray); // replace the old pixel with the new one
				}
			}
		}
		if (filter_number == 1) { // Deep Red Filter
			for (int i = 0; i < pixels.length; i++) { // go through each row
				for (int j = 0; j < pixels[i].length; j++) { // go through each column
					pixels[i][j] = new Color(pixels[i][j].getRed(), (int)(0.37 * pixels[i][j].getGreen()), (int)(0.37 * pixels[i][j].getBlue())); // filter each pixel
				}
			}
		}
		if (filter_number == 2) { // Deep Blue Filter
			for (int i = 0; i < pixels.length; i++) { // go through each row
				for (int j = 0; j < pixels[i].length; j++) { // go through each column
					pixels[i][j] = new Color((int)(0.13 * pixels[i][j].getRed()), (int)(0.27 * pixels[i][j].getGreen()), pixels[i][j].getBlue()); // filter each pixel
				}
			}
		}
	}
    
    
    // *************** DON'T MESS WITH THE BELOW CODE **************** //
    
    // feel free to check it out, but don't change it unless you've consulted 
    // with Mr. David and understand what the code's doing
    
    

    public void run() {
    	JFileChooser fc = new JFileChooser();
//		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
//		fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File my_file = fc.getSelectedFile();
		if (my_file == null)
			System.exit(-1);
		
		// reads the image file and creates our 2d array
        BufferedImage image;
		try {
			image = ImageIO.read(my_file);
		
	        BufferedImage new_image = new BufferedImage(image.getWidth(),
	                        image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        create_pixel_array(image);
			outputName = my_file.getName();
			
			// runs the manipulations determined by the user
			System.out.println("Enter the manipulations you would like to run on the image.\nYour "
					+ "choices are: brighten, flip, negate, blur, edge, filter, or simplify.\nEnter each "
					+ "manipulation you'd like to run, then type in 'done'.");
			Scanner in = new Scanner(System.in);
			String action = in.next().toLowerCase();
			while (!action.equals("done")) {
	    			try {
		    			if (action.equals("brighten")) {
		    				System.out.println("enter an amount to increase the brightness by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
						else if (action.equals("filter")) {
							System.out.println("enter filter: Grayscale(enter 0), Deep Red(enter 1), Deep Blue(enter 2)");
							int filter_action = in.nextInt();
							Method m = getClass().getDeclaredMethod(action, int.class);
							m.invoke(this, filter_action);
						}
		    			else if (action.equals("flip")) {
		    				System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("h"));
		    			}
		    			else {
		        			Method m = getClass().getDeclaredMethod(action);
		        			m.invoke(this, new Object[0]);
		    			}
		    			System.out.println("done. enter another action, or type 'done'");
	    			}
	    			catch (NoSuchMethodException e) {
	    				System.out.println("not a valid action, try again");
	    			} catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);} 
	    			catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
	    			catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}
	    			
	    			action = in.next().toLowerCase();
	    		} 
	        in.close();
	        
	        // turns our 2d array of colors into a new png file
	        create_new_image(new_image);
	        File output_file = new File("Images/" + outputName);
	        ImageIO.write(new_image, "png", output_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
		
    
    public void create_pixel_array(BufferedImage image) {
        w = image.getWidth();
        h = image.getHeight();
        pixels = new Color[h][];
        for (int i = 0; i < h; i++) {
            pixels[i] = new Color[w];
            for (int j = 0; j < w; j++) {
                pixels[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_new_image(BufferedImage new_image) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            		new_image.setRGB(j, i, pixels[i][j].getRGB());
            }
        }
    }

    public static void main(String[] args) {
		new Photoshop();
	}

    public Photoshop() {
		run();
    }
}