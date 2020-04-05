// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.moves;

import java.util.Arrays;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Cell;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.model.Operation;

/**
 * Responsible for rotating the image data in a given cell in a clockwise
 * direction.
 *
 * @author betty
 *
 */
public class Rotation implements Operation {
	private final Location location;
	private final int steps;

	/**
	 * Construction a rotation for the cell at a given location, rotating a given
	 * number of steps.
	 *
	 * @param loc
	 * @param steps
	 */
	public Rotation(Location loc, int steps) {
		this.location = loc;
		this.steps = steps;
	}

	/**
	 * Apply rotation to the selected cell.
	 *
	 * @param cell  The cell on which the rotation is applied.
	 *
	 * @param steps Number of steps to rotate in clockwise direction.
	 */
	@Override
	public void apply(Board board) {
		if (board != null || steps > 0) {
			Cell cell = board.getCellAt(location);
			if (cell != null) {
				int width = cell.getWidth();

				for (int i = 0; i < steps; i++) {
					int[] temp = new int[width * width];
					for (int row = 0; row < width; row++) {
						for (int col = 0; col < width; col++) {
							int rgb = cell.getRGB(col, row);
							temp[(col * width) + (width - row - 1)] = rgb;
						}
					}

					for (int j = 0; j < width * width; j++) {
						cell.setRGB(j % width, j / width, temp[j]);
					}

				}
			}
		}
	}
}
