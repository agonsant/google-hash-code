"use strict";

module.exports = class Slide {
    constructor(photos) {
        this.photos = photos;
        this.photosId = this.generatePhotosId(photos);
        this.mergedTags = this.mergeTags(photos);
        this.taken = false;
    }

    mergeTags(photos) {
        let mergedTags = photos[0].tags;
        if (photos.length > 1) {
            mergedTags = new Map(mergedTags, photos[1].tags);
        }
        return mergedTags;
    }

    generatePhotosId(photos) {
        const photosId = [];
        for (let i = 0; i < photos.length; i++) {
            photosId.push(photos[i].id);
        }
        return photosId;
    }

}