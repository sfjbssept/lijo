import { CommonModule } from '@angular/common';
import { isNgTemplate, ThisReceiver } from '@angular/compiler';
import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import html2canvas from 'html2canvas';
import { ModalPopupComponent } from '../modal-popup/modal-popup.component';
import { SharedModule } from '../shared/shared.module';
import { BookingService } from '../ticket-booking/booking.service';
import { Passenger } from '../user/passenger';

@Component({
  standalone: true,
  selector: 'app-pnr-search',
  templateUrl: './pnr-search.component.html',
  imports: [SharedModule, CommonModule, FormsModule],
  styleUrls: ['./pnr-search.component.css']
})
export class PnrSearchComponent implements OnInit {
  @ViewChild('screen') screen: ElementRef;
  @ViewChild('downloadLink') downloadLink: ElementRef;
  @Input() pnrInput: string;
  pnr: string;
  pnrData: any;
  passengerList: Passenger[];
  errorMessage = "";
  successMessage = "";
  pnrUrl: string;
  showModel: boolean = false;
  capturedImage: any;
  constructor(private bookingService: BookingService,
    private acivatedRoute: ActivatedRoute,
    public dialog: MatDialog) { }

  ngOnInit(): void {
    this.pnrUrl = this.acivatedRoute.snapshot.paramMap.get('pnr');
    if (this.pnrUrl) {
      this.pnr = this.pnrUrl;
      this.getTicketDetailsByPnr(this.pnr);
    } else if (this.pnrInput) {
      this.pnr = this.pnrInput;
      this.getTicketDetailsByPnr(this.pnrInput);
    }
  }

  getTicketDetailsByPnr(value: string) {
    this.resetMessage();
    this.bookingService.getTicketDetailsByPnrNumber(value).subscribe({
      next: (data: any) => {
        console.log(data);
        this.pnrData = data.data;
        this.passengerList = this.pnrData.passengerDtoList;
      },
      error: (e) => {
        this.errorMessage = e.error.message;
        console.log(e);
      }
    })
  }
  resetMessage() {
    this.successMessage = this.errorMessage = '';
  }
  getPassengerAge(id: number) {
    return this.passengerList.filter(item => item.id === id)[0].age;
  }
  getPassengerName(id: number) {
    return this.passengerList.filter(item => item.id === id)[0].name;
  }
  getPassengerGender(id: number) {
    return this.passengerList.filter(item => item.id === id)[0].gender;
  }

  downloadImage(pnr: any) {
    html2canvas(this.screen.nativeElement).then(canvas => {
      this.downloadLink.nativeElement.href = canvas.toDataURL('image/png');
      this.downloadLink.nativeElement.download = 'ticket' + pnr + '.png';
      this.downloadLink.nativeElement.click();
    });
  }
  cancelTicket(id: number, bookingDate: Date) {
    this.openDialog(id);
  }
  openDialog(id:number): void {
    const dialogRef = this.dialog.open(ModalPopupComponent, {
      // width: '250px',
      data: { heading: "title", message: 'message' },
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result === 'cancel') {
        this.bookingService.cancelTicket(id).subscribe({
          next: (data) => {
          console.log("cancelled");
          },
          error: e=>{
            console.log(e);
          }
        });
      }
    });
  }
}
