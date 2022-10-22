import { Time } from "@angular/common";

export class FlightSchedule {
     sourceLocation!: string;
     destination!: string;
     departureTime!:Date
     arrivalTime!:Date
     flightDuration!: number;
     gateNumber!: string;

}