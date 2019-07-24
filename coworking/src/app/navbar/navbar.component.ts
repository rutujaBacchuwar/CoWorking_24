import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  helper=new JwtHelperService();
  name: any;
  password: any;
  userDetail:any=[];
  constructor(private userService:UserService, private route: ActivatedRoute, private router:Router,private modal:NgbModal) { }
  arrayOfUser:any[];
  ngOnInit() {
    // sessionStorage.removeItem('username');
    console.log(sessionStorage.getItem('username'));
  }

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
        if (type == "Client") {
          console.log("ClientLogin");
          this.router.navigateByUrl('/client-login');
        }
       if(type == "owner") {
          this.router.navigateByUrl('/owner-login/'+name);


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
