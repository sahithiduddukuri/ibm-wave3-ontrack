import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RegserviceService } from 'src/app/ontrack/regservice.service';
import { OnTrackService } from 'src/app/ontrack/ontrack.service';
import { Regclass } from 'src/app/ontrack/regclass';
import { namespaceMathML } from '@angular/core/src/render3';

@Component({
  selector: 'app-childreg',
  templateUrl: './childreg.component.html',
  styleUrls: ['./childreg.component.scss']
})
export class ChildregComponent implements OnInit {

  // errorStatus: string;
  // statusCode: number;
  regclass: Regclass = new Regclass();
  constructor(private regservice: RegserviceService) { }

  ngOnInit() {
    }
  submit(event) {
    console.log('registered succesfully');
  }

}
