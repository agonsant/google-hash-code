"use strict";

module.exports = class Photo {

    constructor(orientation, tags, id) {
        this.orientation = orientation;
        this.tags = this.getTagsMap(tags);
        this.id = id;
        this.totalTags = this.tags.length;
    }

    getTagsMap(tags) {
        const tagMap = new Map();
        for (let i = 0; i < tags.length; i++) {
            tagMap.set(tags[i], tags[i]);
        }
        return tagMap;
    }

    
}