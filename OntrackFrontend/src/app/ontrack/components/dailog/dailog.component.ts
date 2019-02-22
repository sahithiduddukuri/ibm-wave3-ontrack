import { OnTrackService } from './../../ontrack.service';
import { Ontrack } from './../../ontrack';
import { Component, OnInit, Inject, Input } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
@Component({
  selector: 'app-dailog',
  templateUrl: './dailog.component.html',
  styleUrls: ['./dailog.component.scss']
})
export class DailogComponent implements OnInit {
  products: any = [];
  constructor(
    public dialogRef: MatDialogRef<DailogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private onTrack: OnTrackService
    ) {}
    ngOnInit() {
      this.onTrack.openDailog().subscribe(data => {
        // console.log(data);
        this.products = data;
      });
    }
  closeDailog() {
    this.dialogRef.close('Ok');
  }
}

