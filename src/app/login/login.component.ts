import { Component, OnInit } from '@angular/core';

import { ServiceService } from '../service.service'
import { Router } from '@angular/router';
declare var jQuery : any;
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: any;
  loggedUser : any;
  newUser : any;
  constructor(private service: ServiceService,private router:Router) { 
    this.user = { email: '', password: '' };
    this.newUser = { userName : '',email : '', password : ''};
  }

  ngOnInit(): void {
  }

  showEditPopup() : void{
    jQuery('#empModal').modal('show');
  }

 

  async loginSubmit(loginForm: any) {

    await this.service.loginCusto(this.user.email, this.user.password).then((res: any) => {
      if (res != null) {
        console.log(res);
         this.loggedUser = res;
        alert('loggedin');
        this.service.setUserLoggedIn(this.loggedUser.userName);
        this.router.navigate(['home']);
      }

      else {
        alert('INVALID CREDENTIALS');
        }
    });

  }

  regSubmit(): void {
    this.service.registerCust(this.newUser).subscribe((result: any) => { console.log(result) });
    alert('registered successfully');
    }
}
