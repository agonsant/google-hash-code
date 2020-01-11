"use strict";
const Server = require('./server');
const File = require('./file');
const CompilationStep = require('./compilation-step');

module.exports = class Compiler {

    constructor() {
        this.servers = [];
        this.compileFiles = new Map();
        this.compilationSteps = [];
        this.nextServer = -1;
    }

    createEmptyServers(number) {
        if (number > 0) {
            for (let i = 0; i < number; i++) {
                this.servers.push(new Server());
            }
        }
    }

    addCompiledFile(id, compileTime, replicateTime, dependencies) {
        let file = new File(id, compileTime, replicateTime);
        file.addDependencies(dependencies);
        this.compileFiles.set(id, file);
    }

    addTargetFileInformation(id, deadline, goalpoints) {
        const file = this.compileFiles.get(id);
        if (file && deadline && goalpoints) {
            file.addDeadline(deadline);
            file.addGoalPoints(goalpoints);
        }
    }

    printCompilationSteps() {
        let str = this.compilationSteps.length + '\n';
        this.compilationSteps.forEach(step => str += step.toString() + '\n');
        return str;
    }


    compile() {
        // orderBy number of deps
        const sortedFiles = [...this.compileFiles].sort((a, b) => a[1].compare(b[1]));
        console.log(sortedFiles);
        // iterate over orderer file list recursively assigning servers in round robin
        //sortedFiles.forEach(file => this.sendToServer(file[0]));
    }

    sendToServer(fileId, parentId) {
        const fileInstance = this.compileFiles.get(fileId);
        if (parentId) {
            const parentInstance = this.compileFiles.get(parentId);
            const depIndex = parentInstance.getDependencies().indexOf(fileId);
            parentInstance.getDependencies().splice(depIndex, 1);
        }
        if (fileInstance.getDependencies().length === 0) {
            if (!fileInstance.isAssigned()) {
                this.compilationSteps.push(new CompilationStep(fileId, this.retrieveNextServerRoundRobin()));
                fileInstance.assign();
            }
        } else {
            const deps = [...fileInstance.getDependencies()];
            deps.forEach(dep => this.sendToServer(dep, fileId));
            this.compilationSteps.push(new CompilationStep(fileId, this.retrieveNextServerRoundRobin()));
            fileInstance.assign();
        }
    }

    retrieveNextServerRoundRobin() {
        return ++this.nextServer % this.servers.length;
    }

    toString() {
        let compilerStr = `Compiler:\n Compiled Files:\n${this.compileFiles.size <= 0 ? '  Empty Map\n' : ''}`;
        this.compileFiles.forEach((value, key) => compilerStr += `  File ${key.toString()}: ${value.toString()}\n`);
        compilerStr += ` Servers: ${this.servers.length}`;
        return compilerStr;
    }
}