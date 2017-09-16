class Car {
    constructor(make = 'default', model = 'default', color = 'default') {
        this.make = make;
        this.model = model;
        this.color = color;
    }
    drive(speed) {
        console.log('The ', this.color, ' ', this.make, ' ', this.model, ' is driving at ', speed, ' mph.');
    }
    stop() {
        console.log('The ', this.color, ' ', this.make, ' ', this.model, ' is stopping.');
    }
}

class BredHondaAccord extends Car {
    constructor() {
        super('Honda', 'Accord', 'Red');
    }
}

var honda = new BredHondaAccord();
console.log(honda.drive(200));