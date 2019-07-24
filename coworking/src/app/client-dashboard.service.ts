import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ClientDashboardService {

  constructor(private httpClient:HttpClient) { }


  getSpaceDetailsByUserName(username):any{
    return this.httpClient.get(`http://13.235.110.75:8091/api/v1/books/${username}`);
  }
}
