import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { ContainerService } from '../services/container.service';
import { SelectedSlot } from './cont';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.css']
})
export class ContainerComponent implements OnInit {
  @Input() SelectedSlot: any;
  bookedslots: SelectedSlot;
  data: any;
  private selectedSlot: SelectedSlot[];
    constructor(private router: Router, private containerService: ContainerService) { }
  
    ngOnInit() {
     this.bookedslots = new SelectedSlot();
this.bookedslots.orderDate=new Date().toDateString();
this.bookedslots.orderId=123243;
this.bookedslots.productCount=2;
this.bookedslots.slotDate=new Date().toDateString();
this.bookedslots.slotType='A';

console.log('this is the post value',this.bookedslots);

this.containerService.containerMethod(this.bookedslots).subscribe(resp => {
   console.log('value from response++++',resp);
   this.data = resp;
   console.log('this is the value of after resp+++', this.data.slotAvailabilities);

})
// this.loginService.login(this.user.value)
// .subscribe(res => {
//   console.log('Res: ', res);
//   if (res.message === 'User successfully logged in') {
//     this.router.navigate([`/home`]);
//     this.loginService.setCookie('token', res.token, 1);
//     // this.loginService.setCookie('message', res.message, 1);
//     // let token = this.loginService.getCookie('token');
//   } else {
//     window.alert('Credentials you entered are incorrect');
//   }
// });
}

    //   this.containerService.containerMethod(this.bookedslots).subscribe( resp => {
    //     console.log('data fetch from response+++++++++', resp);
    //     // this.bookedslots = data;
    //     console.log(this.bookedslots);
    //  });
    // }

}
