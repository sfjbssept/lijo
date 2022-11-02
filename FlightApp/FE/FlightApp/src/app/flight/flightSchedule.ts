import { Time } from "@angular/common";

export class FlightSchedule {
     sourceLocation!: string;
     destination!: string;
     departureTime!:Date
     arrivalTime!:Date
     flightDuration!: number;
     gateNumber!: string;
     economyClassCost: string;
     businessClassCost: string
     flightId: string
     constructor(){
          this.arrivalTime = undefined;
          this.businessClassCost = undefined;
          this.departureTime = undefined;
          this.sourceLocation = undefined;
          this.destination =undefined;
          this.gateNumber = undefined;
          this.economyClassCost =  undefined;
          this.flightDuration = 0;
          this.flightId = undefined;
     }
}