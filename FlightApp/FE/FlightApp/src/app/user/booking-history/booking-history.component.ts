import { Component, OnInit } from '@angular/core';
import { BookingService } from 'src/app/ticket-booking/booking.service';

@Component({
  selector: 'app-booking-history',
  templateUrl: './booking-history.component.html',
  styleUrls: ['./booking-history.component.css']
})
export class BookingHistoryComponent implements OnInit {
  bookingData: any;

  constructor(private bookingService: BookingService) { }

  ngOnInit(): void {
    this.bookingService.getTicketDetailsByUserId().subscribe({
      next:(data: any) => {
       this.bookingData = data.data;
      },
      error: (data: any) =>{

      }
    });
  }

}
