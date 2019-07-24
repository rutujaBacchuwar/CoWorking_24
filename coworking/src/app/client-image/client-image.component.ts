import { Component, OnInit } from '@angular/core';
import {ClientProfileService} from '../client-profile.service'
import { UserService } from '../user.service';
@Component({
  selector: 'app-client-image',
  templateUrl: './client-image.component.html',
  styleUrls: ['./client-image.component.css']
})
export class ClientImageComponent implements OnInit {
  ArrayOfDetails: any;
  userName;
  userDetail:any=[];
  address:string
  constructor(private clientprofileService:ClientProfileService,private userService:UserService) 
  {
     console.log("In client login")
     this.userName=sessionStorage.getItem('username')
     console.log(this.userName)
   }

  
  ngOnInit() {
  }

}
