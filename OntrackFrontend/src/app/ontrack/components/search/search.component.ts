import { Component, OnInit, EventEmitter, Output } from '@angular/core';
// import { OntrackserviceService } from '../../ontrackservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  @Output() searchEvent = new EventEmitter<any>();

  constructor(private router: Router) { }
  ngOnInit() {

}
search(searchKey) {
  if (location.pathname === '/' || location.pathname.search('/home') === 0) {
    this.router.navigate(['home', {search : searchKey}]);
  } else if (location.pathname.search('/home') === 0) {
    this.router.navigate(['home', {search : searchKey}]);
  }
}
  }
