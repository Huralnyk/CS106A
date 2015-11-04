/*
 * File: FlipImage.java
 * --------------------
 * This program horizontally flips the image and presents
 * original and flipped images on the graphic canvas.
 */

import acm.program.*;
import acm.graphics.*;

public class FlipImage extends GraphicsProgram {
	
	public void run() {
		GImage image = new GImage("Milkmaid.jpg");
		GImage flippedImage = flipHorizontal(image);
		
		add(image, 10, 50);
		add(flippedImage, 380, 50);
	}
	
	// Flips an image horizontally and returns the flipped image
	private GImage flipHorizontal(GImage image) {
		int[][] pixels = image.getPixelArray();
		int height = pixels.length;
		int width = pixels[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width / 2; j++) {
				swap(pixels[i], j, width - j - 1);
			}
		}
		return new GImage(pixels);
	}
	
	// Swaps two elements in array specified by pos1, pos2 positions.
	private void swap(int[] array, int pos1, int pos2) {
		int tmp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = tmp;
	}
}
