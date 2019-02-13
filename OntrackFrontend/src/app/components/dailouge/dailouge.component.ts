import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
@Component({
  selector: 'app-dailouge',
  templateUrl: './dailouge.component.html',
  styleUrls: ['./dailouge.component.scss']
})
export class DailougeComponent implements OnInit {
  constructor(
    public dialogRef: MatDialogRef<DailougeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
    ) {}
    ngOnInit() {
    }
  closeDailog() {
    this.dialogRef.close('Ok');
  }
}

