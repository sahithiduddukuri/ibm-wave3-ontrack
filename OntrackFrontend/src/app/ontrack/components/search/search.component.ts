<<<<<<< HEAD
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
=======
import { HttpClient } from '@angular/common/http';
import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Router } from '@angular/router';

import { Ontrack } from '../../ontrack';
import { SearchService } from './search.service';
import { Subject } from 'rxjs';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss'],
  providers: [SearchService]
})
export class SearchComponent implements OnInit {
  results: Object;
  searchTerm$ = new Subject<string>();

  constructor(private searchService: SearchService) {
    this.searchService.search(this.searchTerm$)
      .subscribe(results => {
        this.results = results.results;
      });
  }
  ngOnInit() {

}

>>>>>>> 6feda0e1ab8986eae2136541a3c66d4fe2b966cd
  }
