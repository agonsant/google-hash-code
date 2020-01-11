package hashCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SlideShow {

	private List<Slide> slideList;

	public List<Slide> getSlideList() {
		return slideList;
	}

	public SlideShow() {
		this.slideList = new LinkedList<Slide>();
	}

	public void addSlide(Slide slide) {
		this.slideList.add(slide);
	}

	public LinkedList<Slide> generateFinalSlideShow() {
		LinkedList<Slide> finalSlideShow = new LinkedList<Slide>();
		int count = 0;
		Slide slide = this.getNextSlide();
		slide.setTaken(true);
		finalSlideShow.add(slide);
		while (slide!=null) {
			System.out.println(count);
			count++;
			Slide slideCombination = this.getBestSlideCombination(slide);
			if (slideCombination != null) {
				slideCombination.setTaken(true);
				finalSlideShow.add(slideCombination);
			} 
			slide = slideCombination;
		}

		return finalSlideShow;
	}

	@Override
	public String toString() {
		return "SlideShow [slideList=" + slideList + "]";
	}

	private Slide getBestSlideCombination(Slide slide) {
		Slide foundSlide = null;
		int max = Integer.MIN_VALUE;
		Iterator<Slide> it = this.slideList.iterator();
		while (it.hasNext()) {
			Slide current = it.next();
			if (!current.isTaken()) {
				int tagsOne = this.getExludedTags(slide, current);
				int sameTags = slide.getMergedTags().size() - tagsOne;
				int tagsTwo = current.getMergedTags().size() - sameTags;
				int min = Integer.min(tagsOne, Integer.min(sameTags, tagsTwo));
				if (min > max) {
					max = min;
					foundSlide = current;
				}
			}
		}

		return foundSlide;

	}

	private int getExludedTags(Slide slideOne, Slide slideTwo) {
		Set<String> diff = new HashSet<String>(slideOne.getMergedTags());
		diff.removeAll(slideTwo.getMergedTags());
		return diff.size();
	}

	private Slide getNextSlide() {
		boolean found = false;
		Slide slide = null;
		Iterator<Slide> it = this.slideList.iterator();
		while (!found && it.hasNext()) {
			slide = it.next();
			found = !slide.isTaken();
		}
		return found ? slide : null;
	}

}
