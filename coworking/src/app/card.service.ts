import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CardService {
  constructor(private httpclient: HttpClient) { }

  getByCategory(category): any {
    console.log("in category" + category);
    return this.httpclient.get(`http://13.235.110.75:8005/api/v1/category/${category}`);
  }


  getSpaceDetails(spaceName): any {
    return this.httpclient.get(`http://13.235.110.75:8090/api/v1/space/spaces/${spaceName}`)
  }

}
