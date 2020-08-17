import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  todaynse : any;
  prevnse : any;
  constructor(private service : ServiceService) { 
    this.service.getNse('2020-08-13').subscribe((result: any) => { console.log(result),this.todaynse = result });
    this.service.getNse('2020-08-12').subscribe((result: any) => { console.log(result),this.prevnse = result });
  
    }

  ngOnInit(): void {
  }

  
}
