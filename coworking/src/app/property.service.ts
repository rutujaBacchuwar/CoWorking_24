import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PropertyService {

  constructor(private httpClient:HttpClient) { }
  addSpace(spaceInfo):Observable<any>{
    //this.counter++;
  console.log(spaceInfo, "**********");
  let obj = {
    spaceId:spaceInfo.spaceId,
    spaceName:  spaceInfo.spaceName,
    category:spaceInfo.category, 
    address:{
      buildingNumber:spaceInfo.buildingNumber,
      area:spaceInfo.area,
      city:spaceInfo.city,
      state:spaceInfo.state,
      country:spaceInfo.country,
      pincode:spaceInfo.pincode,
    },
    user:{
      name:spaceInfo.name,
      contactNumber:spaceInfo.contactNumber,
      emailId:spaceInfo.emailId,
    },
    amenities:{
        amenities:spaceInfo.amenities,
    },
    location:{
      locationName:spaceInfo.area,
    }

  }
  console.log(obj);
  return this.httpClient.post<any>('http://13.235.110.75:8090/api/v1/space',obj);
}
}
