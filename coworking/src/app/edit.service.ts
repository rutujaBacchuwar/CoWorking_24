import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EditService {

  constructor(private httpClient:HttpClient) { }

  updateClientProfile(user):any{
    console.log(user)
    return this.httpClient.patch("http://13.235.110.75:8090/api/v1/user",user)
  }
}
