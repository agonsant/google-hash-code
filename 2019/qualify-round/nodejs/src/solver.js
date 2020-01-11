"use strict";
const PhotosList = require('./photos-list');
const Photo = require('./photo');
const Slide = require('./slide');
const SlideShow = require('./slide-show');

const fs = require('fs');
const createInterface = require('readline').createInterface;

const files = [
    'a_example',
    'b_lovely_landscapes',
    'c_memorable_moments',
    'd_pet_pictures',
    'e_shiny_selfies'
];
const file = files[process.argv.length > 2 ? parseInt(process.argv[2]) : 4];

module.exports = class Solver {
    

    constructor() {
        this.horizontalPhotosList = new PhotosList();
        this.verticalPhotosList = new PhotosList();
        this.slideShow = new SlideShow();
        this.finalSlideShow = [];
    }

    loadData() {
        return new Promise((resolve, reject) => {            
            const lineReader = createInterface({
                input: fs.createReadStream(`input/${file}.txt`)
            });
            let counter = 0;
            lineReader.on('line', (line) => {
                const split = line.split(' ');
                if (split.length > 1) {
                    const photo = new Photo(split[0], split.splice(2), counter);
                    counter++;
                    if (split[0] === 'H') {
                        this.slideShow.addSlide(new Slide([photo]));
                    } else {
                        this.verticalPhotosList.addPhoto(photo);
                    }
                }
            });
            lineReader.on('close', () => {
                resolve();
            });
        });
    }

    writeData() {
        const stream = fs.createWriteStream(`output/output_${file}.txt`);
        stream.once('open', () => {
            
            stream.write(`${this.finalSlideShow ? this.finalSlideShow.length : 0}\n`);
            const slideShow = this.finalSlideShow.map(slide => slide.photosId.join(' '));
            stream.write(slideShow.join('\n'));
            stream.end();
        });
    }

    solve() {
        let i = 0, j = this.verticalPhotosList.photosList.length - 1;
        while (i < j) {
            this.slideShow.addSlide(new Slide([this.verticalPhotosList.photosList[i], this.verticalPhotosList.photosList[j]]));
            i++;
            j--;
        }
        this.finalSlideShow = this.slideShow.generateFinalSlideShow();
    }


}