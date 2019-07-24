import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class SpaceService {

  username:any;
  userid:any;
  arrayOfData:any=[]
  myVar1:Date;
  myVar2:Date;

  
  constructor(private httpClient:HttpClient, private userService:UserService) { }


  getSpaceDetails(spaceName):any{
    console.log("In getspaceDetails")
    console.log(spaceName)
    return this.httpClient.get(`http://13.235.110.75:8090/api/v1/space/spaces/${spaceName}`)
  }


  saveBookingDetails(bookInfo): Observable<any> {
    console.log(bookInfo,"In Booking service");
    console.log(bookInfo.myCategory,"Displaying Categoryyyyyyyyy");
    // console.log(bookInfo.myCategory[0],"pppppppppppppppppppp");

    this.username=sessionStorage.getItem('username');
    this.userid=sessionStorage.getItem('uid')
    this.myVar1=JSON.parse(sessionStorage.getItem('startDate'));
    this.myVar2=JSON.parse(sessionStorage.getItem('endDate'));
    
    if(this.username==null){
      
    }

    this.userService.getDataByName(this.username).subscribe(data=>{

      this.arrayOfData=data;
      console.log(this.arrayOfData);
      

    })


    let bookingDetails = {
      startDate: this.myVar1,
      endDate: this.myVar2,
      myUser: {
       uid:this.userid,
       name:this.username,
        myCategory: {
          categoryId: bookInfo.myCategory.categoryId,
          categoryName : bookInfo.myCategory.categoryName,
          myLocation: {
              locationName: bookInfo.locationName,
          },
          mySpace: {
            spaceId: bookInfo.spaceId,
            spaceName: bookInfo.spaceName,
            totalprice: bookInfo.price,
          }

       
        }
     }
    }

    console.log(bookingDetails)


     return this.httpClient.post('http://13.235.110.75:8091/api/v1/book',bookingDetails);

    }

}
