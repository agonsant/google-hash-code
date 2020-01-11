"use strict";

module.exports = class File {

    constructor(id, compileTime, replicateTime) {
        this.id = id;
        this.compileTime = compileTime;
        this.replicateTime = replicateTime
        this.dependencies = [];
        this.deadline = 0;
        this.goalPoints = 0;
        this.assigned = false;
    }

    addDependencies(dependencies) {
        this.dependencies = this.dependencies.concat(dependencies);
    }

    addDeadline(deadline) {
        this.deadline += deadline;
    }

    addGoalPoints(goalPoints) {
        this.goalPoints += goalPoints;
    }

    assign() {
        this.assigned = true;
    }

    isAssigned() {
        return this.assigned;
    }

    getDependencies() {
        return this.dependencies;
    }

    getDeadline() {
        return this.deadline;
    }

    getGoalPoints() {
        return this.goalPoints;
    }

    compare(file) {
        
        return this.deadline < file.getDeadline() ? 1 :
            (this.deadline > file.getDeadline() ? -1 :
                (this.goalPoints > file.getGoalPoints() ? 1 : this.goalPoints < file.getGoalPoints() ? -1 : 0));
    }

    toString() {
        return `{ compileTime: ${this.compileTime}, replicateTime: ${this.replicateTime}` +
            `, dependencies: ${this.dependencies.length > 0 ? this.dependencies.toString() : '[]'}` +
            `, deadline: ${this.deadline}, goalPoints: ${this.goalPoints} }`;
    }
}