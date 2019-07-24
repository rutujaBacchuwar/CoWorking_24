import { Component, OnInit } from '@angular/core';
import { ClientDashboardService } from '../client-dashboard.service';
import { HttpBackend, HttpClient } from '@angular/common/http';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-client-dashboard',
  templateUrl: './client-dashboard.component.html',
  styleUrls: ['./client-dashboard.component.css']
})
export class ClientDashboardComponent implements OnInit {

  ArrayOfClientSpace : any = [];
  ArrayOfdetails: any =[];
  userName:string
  contactNumber:any;
  emailId:any;
  address:any;
  i:any;
  
  constructor(private clientDashboardService:ClientDashboardService ,private http:HttpClient,private router:Router) {
    this.userName=sessionStorage.getItem('username')
    console.log(this.userName)
    this.contactNumber=sessionStorage.getItem('contactNumber');
    console.log(this.contactNumber)
    this.emailId=sessionStorage.getItem('emailId');
    console.log(this.emailId)
    ,this.address=sessionStorage.getItem('address');



   }
 
  ngOnInit() {
    this.getSpaceDetailsByUserName();
  }

  getSpaceDetailsByUserName():any{
    console.log(this.userName);

    this.clientDashboardService.getSpaceDetailsByUserName(this.userName).subscribe(data=>
      {
        console.log(data);
        this.ArrayOfClientSpace=data;
       
      });


  }

  editUser():any{
    console.log("In edit user")
    this.router.navigateByUrl("/edit");
  }

 



}
