

import { Component, OnInit } from '@angular/core';
import { CardService } from '../card.service';
import { ActivatedRoute, Router } from '@angular/router';
import { LocationService } from '../location.service';
@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})


export class CardComponent implements OnInit {

  constructor(private cardService: CardService, private locationService: LocationService, private route: ActivatedRoute, private router: Router) { }


  arrayOfCategory: any = [];
  arrayOfObject
  locationName:any;
 
  hourlyPrice:any;
  dailyPrice:any;
  monthlyPrice:any;
  capacity:any;
  categoryName:any;

  location1: string;
  spaceName:any;
  username:any;
  ngOnInit() {
    
    // getting location name
    this.location1 = sessionStorage.getItem('location');
    console.log("printing location")

    const category = this.route.snapshot.paramMap.get('category');
    console.log(category);

    // this.location=this.locationService.location;
    this.cardService.getByCategory(category).subscribe(data => {
    this.arrayOfCategory = data;
    console.log(this.arrayOfCategory)
    
    });
  }
  click(spaceName){
     sessionStorage.setItem("spaceName",spaceName);
      console.log(spaceName);
      this.username=sessionStorage.getItem('username');
      console.log(this.username)
      if(this.username!=null)
      {
     this.router.navigateByUrl("details/"+spaceName);
      }
      else
      this.router.navigateByUrl("detail/"+spaceName);
  }
}