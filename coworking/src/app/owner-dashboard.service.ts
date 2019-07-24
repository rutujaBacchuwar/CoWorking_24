import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OwnerDashboardService {


  constructor(private httpClient:HttpClient) { }

  

  getSpaceByName(value):Observable<any>{
    console.log(value);
    //this.rm=id;
    return this.httpClient.get<any>(`http://13.235.110.75:8090/api/v1/${value}`);
   }

   searchByName(value):Observable<any>{
     console.log(value);
     return this.httpClient.get<any>(`http://13.235.110.75:8090/api/v1/user/${value}`)
   }

   deleteSpace(value):Observable<any>{
     console.log(value);
     return this.httpClient.delete<any>(`http://13.235.110.75:8090/api/v1/space/${value}`)
   }
}

