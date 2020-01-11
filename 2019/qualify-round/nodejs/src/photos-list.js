"use strict";

module.exports = class PhotosList {

    constructor(photosList) {
        this.photosList = photosList || [];
        this.count = 0;
    }

    addPhoto(photo) {
        const index = this.locationOf(photo, this.photosList);
        if (index === 0) {
            this.photosList.unshift(photo);
        } else if (index === this.photosList.length) {
            this.photosList.push(photo);
        } else {
            this.photosList.splice(index, 0, photo);
        }
    }

    locationOf(element, array, start, end) {
        start = start || 0;
        end = end || array.length - 1;
        if (end <= 0) return 0;
        if (element.totalTags >= array[start].totalTags) return start;
        if (element.totalTags <= array[end].totalTags) return end + 1;
        let mid = Math.floor((start + end) / 2);
        if (element.totalTags === array[mid].totalTags) return mid;
        if (element.totalTags > array[mid].totalTags) {
            if (end - start === 1) return start;
            return this.locationOf(element, array, start, mid);
        } else {
            if (end - start === 1) return end;
            return this.locationOf(element, array, mid, end);
        }
    }

}