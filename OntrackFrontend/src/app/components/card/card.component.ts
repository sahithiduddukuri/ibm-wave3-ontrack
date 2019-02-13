import { DailougeComponent } from './../dailouge/dailouge.component';
import { Component } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent {
  dialogResult: any;
  constructor(public dialog: MatDialog) { }

  openDialog(): void {
   const dialogRef = this.dialog.open(DailougeComponent, {
    width: '600px',
    height: '250px'
    });
    // dialogRef.afterClosed().subscribe(result => {
    //   console.log('The dialog was closed');
    //   this.dialogResult = result;
    // });
}
}
