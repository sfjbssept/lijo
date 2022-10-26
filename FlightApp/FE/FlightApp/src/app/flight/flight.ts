import { Time } from "@angular/common";

export class Flight {
     id: number;
     airlineId: number;
     flightCode: string;
     flightRowCount: number;
     businessClassSeatCount:number;
     economyClassSeatCount:number;
     scheduledDays: string;
     aircraftModel: string;
     status: string;
     internationalService: string;
     domesticService: string;
     constructor(){
        this.id =undefined;
        this.airlineId = undefined;
        this.flightCode =undefined;
        this.aircraftModel = undefined;
        this.flightRowCount = undefined;
        this.businessClassSeatCount =undefined;
        this.economyClassSeatCount =undefined;
        this.scheduledDays =undefined;
        this.status =undefined;
        this.internationalService =undefined;
        this.domesticService =undefined;
     }

}