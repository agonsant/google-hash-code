"use strict";
const Compiler = require('./entities/compiler');
const Loader = require('./loader');




module.exports = class Solver {
    

    constructor() {
        this.compiler= new Compiler();
        this.loader = new Loader();
    }

    loadData(){
        this.loader.loadData(this.compiler);
    }

    writeData(){
        this.loader.writeData(this.compiler);
    }

    solve() {
        this.compiler.compile();
    }


}