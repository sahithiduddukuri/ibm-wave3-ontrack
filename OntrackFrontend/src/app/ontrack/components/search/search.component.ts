
import { Component, OnInit, Input} from '@angular/core';
import { Subject } from 'rxjs';
import { SearchService } from '../../services/search.service';
import { Router } from '@angular/router';
import { Ontrack } from '../../classes/ontrack';



@Component({
 selector: 'app-search',
 templateUrl: './search.component.html',
 styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
 @Input() Ontrack: any;
 private ontracks: Ontrack[];


 constructor(private router: Router, private searchService: SearchService) { }
 ngOnInit() {
          this.Ontrack.Home().subscribe(data => {
            console.log(data);
            this.ontracks = data;
          });
  }
  search(value) {
   this.searchService.searchByProductStartsWith(value).subscribe((res: any) => {
      this.ontracks = res.body;
      console.log(res);
      console.log( this.ontracks);
   });
  }
}
