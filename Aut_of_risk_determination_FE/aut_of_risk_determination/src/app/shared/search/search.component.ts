import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  @Input() displayed: any;
  @Output() filter = new EventEmitter<any[]>();
  
  search: any;

  ngOnInit() {
    setTimeout(()=>{                       
      this.openSearch();
    }, 1000);
  

    this.search = document.getElementById('mysearch');
  }

  public openSearch() {
    document.getElementById('search')?.classList.toggle('active');
  }

  public clear() {
    this.search.value = '';
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value.toLowerCase();
    
    const filtered = this.displayed.filter((item: any) => {
      return item.dangerName.description.toLowerCase().includes(filterValue) ||
             item.dangerName.dangerNumber.toString().includes(filterValue);
    });

    // update the filtered array in the parent component
    this.filter.emit(filtered);

  }

}
