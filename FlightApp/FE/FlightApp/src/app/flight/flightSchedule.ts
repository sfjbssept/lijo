import { Time } from "@angular/common";

export class FlightSchedule {
     sourceLocation!: string;
     destination!: string;
     departureTime!:Date;
     arrivalTime!:Date;
     flightDuration!: string;
     gateNumber!: string;
     economyClassCost: number;
     businessClassCost: number;
     flightId: string;
     id: number;
     constructor(){
          this.arrivalTime = undefined;
          this.businessClassCost = undefined;
          this.departureTime = undefined;
          this.sourceLocation = undefined;
          this.destination =undefined;
          this.gateNumber = undefined;
          this.economyClassCost =  undefined;
          this.flightDuration = undefined;
          this.flightId = undefined;
     }
}