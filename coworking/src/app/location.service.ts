import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LocationService {


  location:any;


  constructor(private httpClient:HttpClient) { }

  getSpaceByLocation(location):any{
    console.log("In location Service");
    return this.httpClient.get(`http://13.235.110.75:8006/v1/api/IsIn/recommendationLocCity/${location}`)
  }

  getCategoryByLocation(location):any{
    return this.httpClient.get(`http://13.235.110.75:8005/api/v1/location/${location}`)
  }

  getSpaceBySpaceName():any{
    return this.httpClient.get("http://13.235.110.75:8006/v1/api/space/SafeWork11");
  }

}