import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AngularMaterialModule } from '../AngularMaterialModule';
export interface DialogData {
  animal: string;
  name: string;
}
@Component({
  standalone: true,
  selector: 'app-modal-popup',
  imports:[AngularMaterialModule],
  templateUrl: './modal-popup.component.html',
  styleUrls: ['./modal-popup.component.css']
})
export class ModalPopupComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<ModalPopupComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
  ) {}

  ngOnInit(): void {
  }
  onNoClick(): void {
    this.dialogRef.close();
  }

}
