"use strict";

module.exports = class CompilationStep {

    constructor(fileId, serverIndex){
        this.fileId = fileId;
        this.serverIndex = serverIndex;
    }

    toString(){
        return `${this.fileId} ${this.serverIndex}`;
    }
}