import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpBackend } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { PropertyService } from '../property.service';

@Component({
   selector: 'app-add-properties',
   templateUrl: './add-properties.component.html',
   styleUrls: ['./add-properties.component.css']
})


export class AddPropertiesComponent implements OnInit {

   title = 'materialApp';   
   firstFormGroup: FormGroup;
   categoryFormGroup: FormGroup;
   secondFormGroup: FormGroup;
   thirdFormGroup: FormGroup;
   panelOpenState: boolean = false;
    allSpaces = [];
    categoryName:any;
   @ViewChild('var', {static: false}) var
 
   
   constructor(private _formBuilder: FormBuilder,private propertyService:PropertyService,private route: ActivatedRoute, private router:Router) {}
 
   arrayOfSpace:any=[];
   private username:any;
   private contact:any;
   private emailId;
  
 
   ngOnInit() {
      this.firstFormGroup = this._formBuilder.group({
         IdCtrl: ['', Validators.required],
        NameCtrl: ['', Validators.required],
        LengthCtrl: ['', Validators.required],
        BreadthCtrl: ['', Validators.required],
        spaceImageUrlCtrl: ['', Validators.required]
 
     
 
      });
 
 
      this.categoryFormGroup = this._formBuilder.group({
      CategoryidCtrl: ['', Validators.required],
       HourCtrl: ['', Validators.required],
       DailyCtrl: ['', Validators.required],
       MonthlyCtrl: ['', Validators.required],
       CapacityCtrl: ['', Validators.required]
    });
      this.secondFormGroup = this._formBuilder.group({
         NumberCtrl: ['', Validators.required],
         AreaCtrl: ['', Validators.required],
         CityCtrl: ['', Validators.required],
         StateCtrl: ['', Validators.required],
         CountryCtrl: ['', Validators.required],
         PincodeCtrl: ['', Validators.required]
       
      });
      this.thirdFormGroup = this._formBuilder.group({
       AmenitiesCtrl: ['', Validators.required]
      });
 
      const name = this.route.snapshot.paramMap.get('name');
      const contactnumber = this.route.snapshot.paramMap.get('contactNumber');
      const email = this.route.snapshot.paramMap.get('email');
 
      console.log(name);
      console.log(contactnumber);
      console.log(email);
      this.username=name;
      this.contact=contactnumber;
      this.emailId=email;
 
 
   }
   addToSpaces(type) {
     let space = {
           categoryId:this.categoryFormGroup.controls.CategoryidCtrl.value,
           categoryName: type,
           capacity:this.categoryFormGroup.controls. CapacityCtrl.value,
           hourlyPrice: this.categoryFormGroup.controls.HourCtrl.value,
           dailyPrice: this.categoryFormGroup.controls. DailyCtrl.value,
           monthlyPrice:this.categoryFormGroup.controls.MonthlyCtrl.value
        
     }
     this.allSpaces.push(space);
 
     console.log(this.allSpaces);
     console.log(space);
     
  }
 
   fireEvent():void{
 
        
     let spaceInfo ={
       name:this.username,
       contactNumber:this.contact,
       emailId:this.emailId,
       spaceId:this.firstFormGroup.controls.IdCtrl.value,
       spaceName:this.firstFormGroup.controls.NameCtrl.value,
       category:this.allSpaces,
       buildingNumber:this.secondFormGroup.controls.NumberCtrl.value,
       area:this.secondFormGroup.controls.AreaCtrl.value,
       city:this.secondFormGroup.controls.CityCtrl.value,
       state:this.secondFormGroup.controls.StateCtrl.value,
       country:this.secondFormGroup.controls.CountryCtrl.value,
       pincode:this.secondFormGroup.controls.PincodeCtrl.value,
       amenities:this.thirdFormGroup.controls.AmenitiesCtrl.value,
     }
     console.log(spaceInfo);
     console.log("hjgasdjskjfsjkk@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
 
     this.propertyService.addSpace(spaceInfo).subscribe(console.log);
     
  }

  BackToHome():any{
     console.log(this.username)
     this.router.navigateByUrl("/owner-login/"+this.username)
  }
   }
   