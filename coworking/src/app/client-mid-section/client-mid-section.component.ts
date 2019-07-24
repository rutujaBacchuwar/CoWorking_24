import { Component, OnInit } from '@angular/core';
import {ClientProfileService} from '../client-profile.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-mid-section',
  templateUrl: './client-mid-section.component.html',
  styleUrls: ['./client-mid-section.component.css']
})
export class ClientMidSectionComponent implements OnInit {
  ArrayOfClientData: any=[];
  arrayOfPriceRecommandation: any=[];
  arrayOfLocationRecommandation:any=[];
  address:string
 
  constructor(private clientprofileService:ClientProfileService,private router:Router) { }
  username:any;
  ngOnInit() {
  
    this.getRecommendationByGivingAddress();
    this.getRecommendationBasedOnPrice();
    this.getRecommendationBasedOnLocation();
  }

  getRecommendationByGivingAddress():any{
    this.address=sessionStorage.getItem('address');
    console.log(this.address);
    this.clientprofileService.getClientData(this.address).subscribe(data=>{
      console.log(data)
      this.ArrayOfClientData=data;
    });
  }

  getRecommendationBasedOnPrice():any{
    // this.address=sessionStorage.getItem('address');
    this.username=sessionStorage.getItem('username');
    console.log(this.username)
    this.clientprofileService.getClientDataBasedOnPrice(this.username).subscribe(data=>{
      console.log("Price based Recommandation")
      this.arrayOfPriceRecommandation=data;
      console.log(data);
    });
  }

  getRecommendationBasedOnLocation():any{
    this.username=sessionStorage.getItem('username');
    console.log(this.username)
    this.clientprofileService.getClientDataBasedOnLocation(this.username).subscribe(data=>
      {
        console.log("Location Based Recommandation")
        this.arrayOfLocationRecommandation=data;
        console.log(data);
      });
  }

  click(spaceName){
    sessionStorage.setItem("spaceName",spaceName);
     console.log(spaceName);
    this.router.navigateByUrl("details/"+spaceName);
 }
 clickMe(spaceName){
  sessionStorage.setItem("spaceName",spaceName);
   console.log(spaceName);
  this.router.navigateByUrl("details/"+spaceName);
}

clickEvent(spaceName){
  sessionStorage.setItem("spaceName",spaceName);
  console.log(spaceName);
  this.router.navigateByUrl("details/"+spaceName)
}



}
