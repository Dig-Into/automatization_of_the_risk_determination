import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  search: any;

  ngOnInit() {
    setTimeout(()=>{                       
      this.openSearch();
    }, 1000);
  

    this.search = document.getElementById('mysearch');;
  }

  public openSearch() {
    document.getElementById('search')?.classList.toggle('active');
  }

  public clear() {
    this.search.value = '';
  }

}
