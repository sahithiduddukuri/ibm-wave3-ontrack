import { Route } from '@angular/compiler/src/core';

import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { Subject } from 'rxjs';
import { SearchService } from '../../services/search.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Ontrack } from '../../classes/ontrack';
import { DailogComponent } from '../dailog/dailog.component';
import { MatDialog } from '@angular/material';



@Component({
selector: 'app-search',
templateUrl: './search.component.html',
styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
@Input() Ontrack: any;
private ontracks: Ontrack[];
q: any;
cart: any ;
brand: any;
@Output()
cartAddEvent = new EventEmitter<any>();
 dialogResult: any;

constructor(public dialog: MatDialog, private route: Router, private searchService: SearchService, private ac: ActivatedRoute) { }
//  AddToCart1(q): void {
//   console.log(q, 'click event call');
//   this.cartAddEvent.emit(q);
//   this.searchService.cart = q;
//  this.route.navigateByUrl('/AddToCart1');

// }
// buy2() {
//   this.route.navigate([ '/', 'buy2']);
// }

// openDialog1(q): void {
//   console.log(q, 'this is the data ');
//  const dialogRef = this.dialog.open(DailogComponent,  {
//    data: { q }
//   });
//   dialogRef.afterClosed().subscribe(result => {
//     console.log('The dialog was closed');
//     this.dialogResult = result;
//   });

// }
ngOnInit() {
         // this.Ontrack.Home().subscribe(data => {
         //   console.log(data);
         //   this.ontracks = data;
         // });
        //  this.searchService.searchByProductStartsWith(value).subscribe((res: any) => {
        //    this.ontracks = res.body;
        //    console.log(res);
        //    console.log( this.ontracks);
        // });
        this.brand = this.ac.snapshot.params['brand'];
  this.searchService.searchByProductStartsWith(this.brand).subscribe((res: any) => {
     this.ontracks = res.body;
     console.log(res);
     console.log( this.ontracks);
  });
 }
}
