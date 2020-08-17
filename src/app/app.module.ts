import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {LoginComponent} from './login/login.component'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './header/header.component';
import { Routes, RouterModule } from '@angular/router';
import {FormsModule} from '@angular/forms';
import { NsebseComponent } from './nsebse/nsebse.component';
import { CompanyComponent } from './company/company.component';

import { NgxChartsModule } from '@swimlane/ngx-charts';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
const appRoot:Routes=[{path:'', component: HomeComponent},
{path:'login',component:LoginComponent},
{path:'home',component:HomeComponent},
{path:'nsebse',component:NsebseComponent},
{path:'company',component:CompanyComponent}]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    LoginComponent,
    NsebseComponent,
    CompanyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    HttpClientModule,
    RouterModule.forRoot(appRoot),
    NgxChartsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
