import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar-logout',
  templateUrl: './navbar-logout.component.html',
  styleUrls: ['./navbar-logout.component.css']
})
export class NavbarLogoutComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }
logout(){
  sessionStorage.removeItem('username');
  this.router.navigateByUrl("/");
}
}
