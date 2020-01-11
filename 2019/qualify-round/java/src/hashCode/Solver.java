package hashCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solver {

	private PhotoList horizontalPhotosList;
	private PhotoList verticalPhotosList;
	private SlideShow slideShow;
	private List<Slide> finalSlideShow;

	private final String[] files = { "a_example", "b_lovely_landscapes", "c_memorable_moments", "d_pet_pictures",
			"e_shiny_selfies" };
	private final int file = 4;

	public Solver() {
		this.horizontalPhotosList = new PhotoList();
		this.verticalPhotosList = new PhotoList();
		this.slideShow = new SlideShow();
		this.finalSlideShow = new LinkedList<Slide>();
	}

	public void loadData() {
		BufferedReader br = null;
		FileReader fr = null;
		String fileName = "./input/" + this.files[file] + ".txt";
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String sCurrentLine;
			int counter = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] split = sCurrentLine.split(" ");
				if (split.length > 1) {
					Set<String> tags = new HashSet<String>(Arrays.asList(Arrays.copyOfRange(split, 2, split.length)));
					Photo photo = new Photo(split[0], tags, counter);
					counter++;
					if (split[0].equalsIgnoreCase("H")) {
						this.slideShow.addSlide(new Slide(photo));
					} else {
						this.verticalPhotosList.addPhoto(photo);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Solver [horizontalPhotosList=" + horizontalPhotosList + ", verticalPhotosList=" + verticalPhotosList
				+ ", slideShow=" + slideShow + ", finalSlideShow=" + finalSlideShow + "]";
	}

	public void writeData() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		String fileName = "./output/output_" + this.files[file] + ".txt";
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(Integer.toString(this.finalSlideShow.size()));
			bw.newLine();
			Iterator<Slide> it = this.finalSlideShow.iterator();
			while (it.hasNext()) {
				Slide slide = it.next();
				String line = Integer.toString(slide.getPhotos().get(0).getId());
				if (slide.getPhotos().size() > 1) {
					line += " " + slide.getPhotos().get(1).getId();
				}
				bw.write(line);
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void solve() {
		int i = 0, j = this.verticalPhotosList.getLength();
		while (i < j) {
			Photo one = this.verticalPhotosList.getNextMaxPhoto();
			Photo two = this.verticalPhotosList.getNextMinPhoto();
			if (one != two) {
				this.slideShow.addSlide(new Slide(one, two));
			} else {
				this.slideShow.addSlide(new Slide(one));
			}
			i++;
			j--;
		}
		this.finalSlideShow = this.slideShow.generateFinalSlideShow();
	}

}
