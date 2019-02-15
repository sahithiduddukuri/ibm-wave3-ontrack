import { SearchService } from './../search/search.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-cardcontainer',
  templateUrl: './cardcontainer.component.html',
  styleUrls: ['./cardcontainer.component.scss']
})
export class CardcontainerComponent implements OnInit {
  text: String;
  constructor(private searchService: SearchService) { }

  ngOnInit() {
    // this.searchService.searchfilter(this.text);
  }

}
