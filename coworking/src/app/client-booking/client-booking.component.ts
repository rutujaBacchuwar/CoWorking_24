import { Component, OnInit } from '@angular/core';
import { SpaceService } from '../space.service';
import { HttpClient } from '@angular/common/http';
import { CardService } from '../card.service';
import { MatDialog } from '@angular/material';
import { BookModalComponent } from '../book-modal/book-modal.component';
import { Router, ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { JwtHelperService } from '@auth0/angular-jwt';
import { UserService } from '../user.service';

@Component({
  selector: 'app-client-booking',
  templateUrl: './client-booking.component.html',
  styleUrls: ['./client-booking.component.css']
})
export class ClientBookingComponent implements OnInit {

  

  arrayOfData: any=[];
  arrayOfCategories: any=[];
  selectedThing : any = [];
  selectedSpaces: any = [];
  arrayOfDetails: any=[];
  total:any;
  addCost :any = [];
  dialogRef:any;
  arrayOfCategory:any = [];
  location:any;
  space:any;
  capacity:any;
  categoryName:any;
  hourlyPrice:any;
  dailyPrice:any;
  monthlyPrice:any;
  Name:any;
  myVar1:Date;
  myVar2:Date;
    constructor(private spaceService: SpaceService,private httpClient: HttpClient,private cardService:CardService, 
      public dialog:MatDialog,private modal:NgbModal,private userService:UserService, private route: ActivatedRoute, private router:Router) {
      this.myVar1=new Date();
      this.myVar2=new Date();
     }
  
    ngOnInit() {
  
      
     
      console.log("In Booking comp ts")
  
      console.log("In NgOninit")
    
      this.getModal();
  
      // this.openDialog();
      
    }
  
  
  
  addSpace(a, rate, count, name) {
    console.log(a,rate,count,name)
    let obj = {
      rate:  rate,
      count: count,
    Name: name,
      // id: id,
      
  
    }
    this.selectedSpaces.push(obj)
    sessionStorage.setItem('selectedSpaces', JSON.stringify(this.selectedSpaces));
  }
  book() {
    // this.router.navigateByUrl('/')
  
  }

  // openModal(content){
  //   this.modal.open(content);
  //   console.log(content);
  // }
  
  public num1:number;
   public num2:number;
   public result:number;
  
   
    calc(){
    
  
    this.result=this.num1*this.num2;
    // console.log(this.result)
   
    
    this.addCost.push(this.result);
  
    console.log(this.addCost);
    }
  
    sum(){
    this.total = this.addCost.reduce((acc = 0, curVal) => {
      return acc = acc + curVal;
    })
  
    console.log(this.total, "This is the Total")
    console.log(this.total);
  
    // this.addCost.push(total);
    }
  
  
  
  
    getModal():any{
      this.Name=sessionStorage.getItem("spaceName")
      console.log("getting space name")
      console.log(this.Name)
      this.spaceService.getSpaceDetails(this.Name).subscribe(data=>
        {
          console.log(data);
          this.arrayOfData=data;
          this.arrayOfCategories=this.arrayOfData.category
          console.log(this.arrayOfCategories);
          
        })
    }
  
  
    pushthisthing(thisthing){
      console.log(thisthing, "sdfhskjdfhskjhfdkshfdkjsh")
      this.selectedThing = thisthing;
    }
  
    openDialog(): void {
      this.dialogRef = this.dialog.open(BookModalComponent, {
        width: '800px',
      });
    
     
  }
  
  bookSpace(value): any{
    console.log(this.selectedSpaces);
  
    let bookingSpace = {
      spaceId:this.arrayOfData.spaceId,
      spaceName:this.arrayOfData.spaceName,
      locationName:this.arrayOfData.location.locationName,
      price:this.total,
      myCategory:this.selectedThing,
    }
      this.spaceService.saveBookingDetails(bookingSpace).subscribe();
  
    // sessionStorage.setItem('total', value);
  
    }
  
    myStartDate(){
      console.log(this.myVar1);
      sessionStorage.setItem('startDate',JSON.stringify( this.myVar1));
    }
  ​
    myEndDate(){
      console.log(this.myVar2);
      sessionStorage.setItem('endDate',JSON.stringify( this.myVar2));
  ​
    }












    helper=new JwtHelperService();
    name: any;
    password: any;
    userDetail:any=[];
  
    arrayOfUser:any[];
    spaceName:any;
    authenticateUser(name,password)
    {
      console.log(name ,password);
      let userdata=
      {
        name:name,
        password:password
      }
  
      // this.userService.getToken(userdata)
      this.userService.getToken(userdata).subscribe(data=>{
          console.log(data);
           sessionStorage.setItem('token',data.token);
            sessionStorage.setItem('details', JSON.stringify(this.helper.decodeToken(data.token)))
            console.log(this.helper.decodeToken(data.token));
          let type = this.helper.decodeToken(data.token).sub;
          console.log(data.token);
          console.log(type, "this is the role");
          this.spaceName=sessionStorage.getItem("spaceName");

          if (type == "Client") {
            console.log("ClientLogin");
            this.router.navigateByUrl('/details/'+this.spaceName);
          }
         if(type == "owner") {
            this.router.navigateByUrl('/details/'+this.spaceName);
  
  
          }
          // this.userService.authenticateUser(userdata);
          sessionStorage.setItem('username',userdata.name)
          let username=sessionStorage.getItem('username');
          this.getData();
          console.log("printing session storage of username" +username)
      });
    }
  
    getData():any{
     
     
      let userName=sessionStorage.getItem('username')
      console.log(userName);
      this.userService.getDataByName(userName).subscribe(data=>{
        this.userDetail=data;
        console.log(this.userDetail)
  
        this.address=this.userDetail.address;
        sessionStorage.setItem("address",this.address);
  
        this.contact=this.userDetail.contactNumber;
        sessionStorage.setItem("contactNumber",this.contact);
        console.log(sessionStorage.getItem('contactNumber'));
  
        this.email=this.userDetail.emailId;
        sessionStorage.setItem("emailId",this.email);
  
        this.uid=this.userDetail.uid;
        sessionStorage.setItem("uid",this.uid);
  
  
      
      });
      }
    user:any;
    email:any;
    pass:any;
    contact:any;
    uid:any;
    address:any;
  
    registerUser(user,email,pass,contact,uid,address)
    {
      let userDetails={     
        uid:uid,
        name:user,
        contactNumber:contact,
        emailId:email,
        password:pass,
        address:address
      }
      console.log(user);
      console.log(userDetails);
      this.userService.registerUser(userDetails).subscribe();
      console.log("we have to pass data",this.userService.userDetail)
      sessionStorage.setItem('username',userDetails.name)
     sessionStorage.setItem('address',userDetails.address)
     sessionStorage.setItem('emailId',userDetails.emailId)
     sessionStorage.setItem('contactNumber',userDetails.contactNumber)
     sessionStorage.setItem('uid',userDetails.uid)
      
    }
  
   
    openModal(content){
      this.modal.open(content);
      console.log(content);
    }
  
    openRegistrationModal(contents){
      this.modal.open(contents);
      console.log(contents);
      console.log("in registration modal");
    }
  }
  

  

