package hashCode;

import java.util.Set;

public class Photo {
	
	private String orientation;
	private Set<String> tags;
	private int id;
	private int totalTags;
	
	public Photo(String orientation, Set<String> tags, int id) {
		this.orientation = orientation;
		this.tags = tags;
		this.id = id;
		this.totalTags = tags.size();
	}

	public String getOrientation() {
		return orientation;
	}
	
	public Set<String> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "Photo [orientation=" + orientation + ", tags=" + tags + ", id=" + id + ", totalTags=" + totalTags + "]";
	}

	public int getId() {
		return id;
	}

	public int getTotalTags() {
		return totalTags;
	}

	
}
