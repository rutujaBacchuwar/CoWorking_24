import { Component, OnInit } from '@angular/core';
import { ClientDashboardService } from '../client-dashboard.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-client-profile',
  templateUrl: './client-profile.component.html',
  styleUrls: ['./client-profile.component.css']
})
export class ClientProfileComponent implements OnInit {
  ArrayOfClientData:any=[];
  address:string;
  constructor(private clientService:ClientDashboardService,private userService:UserService) { }

  ngOnInit() {
    // this.address=sessionStorage.getItem('address');

  }


}
