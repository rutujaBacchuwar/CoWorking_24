

import { Component, OnInit } from '@angular/core';
import { EditService } from '../edit.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  name:any;
  address1:any;
  contactNumber:any;
  id:any;
  emailId:any;
  arrayOfData:any=[];
  constructor(private editService:EditService,private router:Router) {
      console.log(sessionStorage.getItem('username'));
      console.log(sessionStorage.getItem('address'));
      console.log(sessionStorage.getItem('contactNumber'));
      console.log(sessionStorage.getItem('emailId'));
      console.log(sessionStorage.getItem('uid'));
      this.name=sessionStorage.getItem('username');
       this.address1=sessionStorage.getItem('address');
       this.contactNumber=sessionStorage.getItem('contactNumber');
       this.id=sessionStorage.getItem('uid');
       this.emailId=sessionStorage.getItem('emailId');

   }

  ngOnInit() {
      
      
    }
    
    updateProfile(user,pass,email,contact,uid,address):any{
      let userDetails={     
        uid:uid,
        name:user,
        contactNumber:contact,
        emailId:email,
        password:pass,
        address:address
      }
      console.log(userDetails)
      this.editService.updateClientProfile(userDetails).subscribe(data=>{
        this.arrayOfData=data;
        this.name=this.arrayOfData.name
        console.log("***********************")
        console.log(name)
        this.router.navigateByUrl("/client-login"+name)
      });


    }
  }


