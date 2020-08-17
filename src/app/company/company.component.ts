import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';

import { HistoricalData } from '../models';
import { Observable} from 'rxjs';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
  company : any;
  stock : any;
  historicalData: Observable<HistoricalData[]> = this.service.historicalData;
  single: any[];
  multi: any[];

  view: any[] = [800, 360];

  // options
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'Time';
  showYAxisLabel = true;
  yAxisLabel = 'Population';

  colorScheme = {
    domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
  };

    constructor(private service:ServiceService) {
      this.single = this.service.getStaticData();
   }
   public onSelect(event): void {

  }

  public onRefresh(): void {
    
  }

  ngOnInit(): void {
  }
  
  choose() : any{
    this.service.getStock(this.company,'2020-08-13').subscribe((result: any) => { console.log(result),this.stock = result });
    
  }

}
