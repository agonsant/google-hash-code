package hashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Slide {

	private List<Photo> photos;
	private boolean taken;
	private Set<String> mergedTags;
	
	public Slide(Photo one) {
		this.photos = new ArrayList<Photo>(2);
		this.photos.add(one);
		this.taken = false;
		this.mergedTags = new HashSet<String>(one.getTags());
	}

	public Slide(Photo one, Photo two) {
		this.photos = new ArrayList<Photo>(2);
		this.photos.add(one);
		this.photos.add(two);
		this.taken = false;
		this.mergedTags = new HashSet<String>(one.getTags());
		this.mergedTags.addAll(two.getTags());
	}

	@Override
	public String toString() {
		return "Slide [photos=" + photos + ", taken=" + taken + ", mergedTags=" + mergedTags + "]";
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public boolean isTaken() {
		return taken;
	}

	public Set<String> getMergedTags() {
		return mergedTags;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

}
