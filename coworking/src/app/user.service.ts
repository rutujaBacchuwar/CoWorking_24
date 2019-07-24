

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable(
  {
  providedIn: 'root'
}
)
export class UserService {


  userDetail:any;
  

   constructor(private http:HttpClient) { }

 authenticateUser(userdata:any):any{
   console.log(userdata);
   this.http.post("http://13.235.110.75:8002/api/user",userdata).subscribe(
     (user:any)=>
   {
     console.log("qwertyuiop")
    console.log(user);
    }
   );
   console.log(userdata);
}

registerUser(userDetails):Observable<any>{
  // console()
  console.log("in register user service"+userDetails);
  console.log(userDetails);
return this.http.post("http://13.235.110.75:8090/api/v1/user",userDetails);
}

getToken(obj): any {
  console.log(obj)
  console.log(obj.name,obj.password);
  return this.http.post(`http://13.235.110.75:8002/api/user`,obj);
}

getDataByName(username):any{
  console.log(username)
  console.log("In get Data by name service ");
  return this.http.get(`http://13.235.110.75:8090/api/v1/user/${username}`);
}
}
