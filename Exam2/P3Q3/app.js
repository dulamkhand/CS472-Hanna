var Car = function(){
    let make = 'default';
    let model = 'default';
    let color = 'default';
    return{
        setMake: function(pmake){
            return this.make = pmake;
        },
        setModel: function(pmodel){
            return this.model = pmodel;
        },
        setColor: function(pcolor){
            return this.color = pcolor;
        },
        drive : function(speed){
            console.log("The " + this.color + " " + this.make +" " + this.model + " is driving at " + speed + " mph.")
        },
        stop : function(){
            console.log("The " + this.color + " " + this.make + this.model + " is stopping.");
        }
    }
}
var redHondaAccord = Car();
redHondaAccord.setMake('Honda');
redHondaAccord.setColor('red');
redHondaAccord.setModel('Accord');
redHondaAccord.drive(200);