"use strict";

module.exports = class SlideShow {

  constructor(slideList) {
    this.slideList = slideList || [];
  }

  addSlide(slide) {
    this.slideList.push(slide);
  }

  getBestSlideCombination(elementIndex, array) {
    let index = -1, maximun = -Infinity;
    const element = array[elementIndex];
    for (let i = 0; i < array.length; i++) {
      if (!array[i].taken) {
        const tagsOne = this.getExludedTags(element, array[i]);
        const sameTags = element.mergedTags.size - tagsOne;
        const tagsTwo = array[i].mergedTags.size - sameTags;
        const minimun = Math.min(tagsOne, Math.min(tagsTwo, sameTags));
        if (minimun > maximun) {
          maximun = minimun;
          index = i;
        }
        console.log(elementIndex,maximun);
      }
    }
    return index;
  }

  getExludedTags(slideOne, slideTwo) {
    let counter = 0;
    for (let [key, value] of slideOne.mergedTags) {
      counter += !slideTwo.mergedTags.has(key) ? 1 : 0;
    }
    return counter;
  }

  generateFinalSlideShow() {
    const finalSlideShow = [];
    const i = this.getNextSlide();
    this.slideList[i].taken = true;
    finalSlideShow.push(this.slideList[i]);
    while (i >= 0) {
      const index = this.getBestSlideCombination(i, this.slideList);
      if (index >= 0) {
        this.slideList[index].taken = true;
        finalSlideShow.push(this.slideList[index]);
      }
      i=index;
    }

    return finalSlideShow;
  }

  getNextSlide() {
    let i = 0, found = false;
    while (!found && i < this.slideList.length) {
      found = !this.slideList[i].taken;
      i++;
    }
    return found ? i - 1 : -1;
  }

}
