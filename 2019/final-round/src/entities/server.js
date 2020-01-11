"use strict";

module.exports = class Server {

    constructor() {
        this.availableCompiledFiles=[];
    }

    addAvailableCompiledFile(compiledFile){
        this.availableCompiledFiles.push(compiledFile);
    }
}