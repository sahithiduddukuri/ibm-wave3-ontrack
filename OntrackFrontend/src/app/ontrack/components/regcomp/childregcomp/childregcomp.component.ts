import { Component, OnInit } from '@angular/core';
import { OntrackserviceService } from 'src/app/ontrack/ontrackservice.service';

@Component({
  selector: 'app-childregcomp',
  templateUrl: './childregcomp.component.html',
  styleUrls: ['./childregcomp.component.scss']
})
export class ChildregcompComponent implements OnInit {

  constructor(private service: OntrackserviceService) { }

  ngOnInit() {
  }

}
