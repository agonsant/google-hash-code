'use strict';
const Solver = require('./src/solver');

function start() {
  let solver = new Solver();
  solver.loadData()
  console.log('DATOS CARGADOS');
  solver.solve();
  console.log('SOLUCION');
  solver.writeData();
  console.log('DATOS ESCRITOS');
}

start()