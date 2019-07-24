import { Component, OnInit } from '@angular/core';
import { CardService } from '../card.service';
import { LocationService } from '../location.service';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-spaces',
  templateUrl: './spaces.component.html',
  styleUrls: ['./spaces.component.css']
})
export class SpacesComponent implements OnInit {

  constructor(private san: DomSanitizer,private cardService: CardService,private locationService:LocationService,private router:Router) { }
  arrayOfSpace: any = [];
  arrayOfSpace1: any = [];
  arrayOfCategory: any = [];
  array:any;
  imgurl: any;
  username:any;
  loc:String;
  ngOnInit() {
    console.log(this.locationService.location);
    this.loc=this.locationService.location;
    this.locationService.getSpaceByLocation(this.loc).subscribe(data=>{
      this.arrayOfSpace=data;
      console.log(this.arrayOfSpace);
    });

    

    this.imgurl = "https://www.google.com/imgres?imgurl=https://rushfaster.com.au/blog/wp-content/uploads/2017/03/coworking-spaces-in-melbourne.jpg&imgrefurl=https://rushfaster.com.au/blog/coworking-spaces-melbourne/&docid=ZQQytwE1a0s8zM&tbnid=3xaxsgM7LjpCpM:&vet=10ahUKEwjW6MXfjInjAhWMtI8KHXVEBgMQMwhMKAAwAA..i&w=1080&h=720&bih=687&biw=758&q=images+of+coworking+spaces&ved=0ahUKEwjW6MXfjInjAhWMtI8KHXVEBgMQMwhMKAAwAA&iact=mrc&uact=8"

    this.imgurl = this.san.bypassSecurityTrustResourceUrl(this.imgurl)
  }
  click(spaceName){
    
    sessionStorage.setItem("spaceName",spaceName);
    console.log(this.arrayOfSpace);
    console.log("***************")
     console.log(spaceName);
     this.username=sessionStorage.getItem('username');
     console.log(this.username);
     if(this.username!=null)
      {
     this.router.navigateByUrl("details/"+spaceName);
      }
      else
      this.router.navigateByUrl("detail/"+spaceName);
  }
 }
 


