'use strict';
const Solver = require('./src/solver');

function start() {
  let solver = new Solver();
  solver.loadData().then(() =>{
    console.log('DATOS CARGADOS')
    solver.solve();
    console.log('SOLUCION')
    solver.writeData();
    console.log('DATOS ESCRITOS')
  });
}

start()