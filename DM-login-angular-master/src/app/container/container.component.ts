import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContainerService } from '../services/container.service';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.css']
})
export class ContainerComponent implements OnInit {
  bookedslots: any = [];
    constructor(private router: Router, private containerService: ContainerService) { }
  
    ngOnInit() {

      this.containerService.containerMethod().subscribe(data => {
        console.log('data fetch from response', data);
        this.bookedslots = data;
     });
    }

}
