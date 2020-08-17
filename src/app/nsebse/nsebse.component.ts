import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-nsebse',
  templateUrl: './nsebse.component.html',
  styleUrls: ['./nsebse.component.css']
})
export class NsebseComponent implements OnInit {
  opt : any;
  todaynse : any;
  prevnse : any;
  todaybse : any;
  prevbse:any;
  constructor(private service : ServiceService) { 
    this.service.getNse('2020-08-13').subscribe((result: any) => { console.log(result),this.todaynse = result });
    this.service.getNse('2020-08-12').subscribe((result: any) => { console.log(result),this.prevnse = result });
    this.service.getBse('2020-08-13').subscribe((result: any) => { console.log(result),this.todaybse = result });
    this.service.getBse('2020-08-12').subscribe((result: any) => { console.log(result),this.prevbse = result });
 
  }

  ngOnInit(): void {
  }

  choose() : boolean{
    if(this.opt === 'bse'){
      return true;
    }
    else{
      return false;
    }
  }



}
