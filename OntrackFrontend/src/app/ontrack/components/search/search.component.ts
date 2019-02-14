import { HttpClient } from '@angular/common/http';
import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Router } from '@angular/router';

import { Ontrack } from '../../ontrack';
import { SearchService } from './search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  value: string;
  @Input()
  ontrack: Ontrack;

  constructor(private searchService: SearchService, private http: HttpClient) {
    console.log('name' , this.value);
   }
  onKey(event: any) {
    this.value = event.target.value;
    console.log(this.value);
    this.searchService.searchfilter(this.value);
  }
  ngOnInit() {

}

  }
