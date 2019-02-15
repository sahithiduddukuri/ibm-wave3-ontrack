import { Component, OnInit } from '@angular/core';
import { RegserviceService } from '../../regservice.service';

@Component({
  selector: 'app-registrationcomp',
  templateUrl: './registrationcomp.component.html',
  styleUrls: ['./registrationcomp.component.scss']
})
export class RegistrationcompComponent implements OnInit {

  constructor(private service: RegserviceService) { }

  ngOnInit() {
  }

}
