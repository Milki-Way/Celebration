package Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import data.DataEngine;
import tileengine.Tile;

public class TEst {

	public static void main(String[] args) {
			System.out.println("start");
			Tile tuile = DataEngine.getInstance().LoadTile("0/0/0");
			System.out.println(tuile.getZoom());
			System.out.println("end");
	}

}
