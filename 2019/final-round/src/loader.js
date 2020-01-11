"use strict";
const fs = require('fs');

const files = [
    'a_example',
    'b_narrow',
    'c_urgent',
    'd_typical',
    'e_intriguing',
    'f_big'
];
const file = files[process.argv.length > 2 ? parseInt(process.argv[2]) : 0];

module.exports = class Loader {

    constructor() {
    }

    loadData(compiler) {
        const lines = fs.readFileSync(`../problem-statement/${file}.in`, 'utf-8').split(/\r?\n/);
        const firstLine = lines[0].split(' ');
        console.log(`Data input: ${firstLine}`);
        const compiledFiles = parseInt(firstLine[0]), targetFiles = parseInt(firstLine[1]);
        compiler.createEmptyServers(parseInt(firstLine[2]));

        for (let i = 1; i <= compiledFiles; i++) {
            const compiledFileLine = lines[i * 2 - 1].split(' ');
            const dependencies = lines[i * 2].split(' ');
            const dependencyCount = dependencies.shift();
            compiler.addCompiledFile(compiledFileLine[0], parseInt(compiledFileLine[1]),
                parseInt(compiledFileLine[2]), dependencies);
        }

        for (let i = compiledFiles*2 + 1; i <= (compiledFiles*2 + targetFiles); i++) {
            const targetFileLine = lines[i].split(' ');
            compiler.addTargetFileInformation(targetFileLine[0], parseInt(targetFileLine[1]), parseInt(targetFileLine[2]));
        }
    }

    writeData(compiler) {
        const stream = fs.createWriteStream(`output/output_${file}.out`);
        stream.once('open', () => {
            stream.write(compiler.printCompilationSteps());
            stream.end();
        });
    }

}