package hashCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PhotoList {

	private PriorityQueue<Photo> maxPhotosList;
	private PriorityQueue<Photo> minPhotosList;

	public PhotoList() {
		this.maxPhotosList = new PriorityQueue<Photo>(50000, new Comparator<Photo>() {
			@Override
			public int compare(Photo a, Photo b) {
				int tags = b.getTotalTags() - a.getTotalTags();
				return tags != 0 ? tags : b.getId()-a.getId();
			}
		});
		this.minPhotosList = new PriorityQueue<Photo>(50000, new Comparator<Photo>() {
			@Override
			public int compare(Photo a, Photo b) {
				int tags = a.getTotalTags() - b.getTotalTags();
				return tags != 0 ? tags : a.getId()-b.getId();
			}
		});
	}

	public void addPhoto(Photo photo) {
		this.minPhotosList.add(photo);
		this.maxPhotosList.add(photo);
	}
	
	public int getPhotoListLength() {
		return this.minPhotosList.size();
	}
	
	public Photo getNextMaxPhoto() {
		return this.maxPhotosList.poll();
	}
	
	public Photo getNextMinPhoto() {
		return this.minPhotosList.poll();
	}
	
	public int getLength() {
		return this.maxPhotosList.size();
	}

	@Override
	public String toString() {
		return "PhotoList [maxPhotosList=" + maxPhotosList + ", minPhotosList=" + minPhotosList + "]";
	}

}
