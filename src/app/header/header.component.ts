import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  check : boolean;
  userName : any;
  constructor(private router: Router, private service : ServiceService) { }

  ngOnInit(): void {
  }
  loginck():boolean{
    this.check = this.service.getUserLogged();
    return this.check;
  }
  
    logout() : void{
      this.router.navigate(['home']);
      this.service.setUserLoggedOut();
    }
  
    getName() : any{
      return this.service.getUserName();
    }
    
}
