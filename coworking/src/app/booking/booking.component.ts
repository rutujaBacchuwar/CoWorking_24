import { Component, OnInit } from '@angular/core';
import { SpaceService } from '../space.service';
import { HttpClient } from '@angular/common/http';
import { CardService } from '../card.service';
import { MatDialog } from '@angular/material';
import { BookModalComponent } from '../book-modal/book-modal.component';



@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  arrayOfData: any = [];
  arrayOfCategories: any = [];
  selectedThing: any = [];
  selectedSpaces: any = [];
  arrayOfDetails: any = [];
  total: any;
  addCost: any = [];
  dialogRef: any;
  arrayOfCategory: any = [];
  location: any;
  space: any;
  capacity: any;
  categoryName: any;
  hourlyPrice: any;
  dailyPrice: any;
  monthlyPrice: any;
  name: any;
  myVar1: Date;
  myVar2: Date;
  constructor(private spaceService: SpaceService, private httpClient: HttpClient, private cardService: CardService, public dialog: MatDialog) {
    this.myVar1 = new Date();
    this.myVar2 = new Date();
  }

  ngOnInit() {



    console.log("In Booking comp ts")

    console.log("In NgOninit")

    this.getModal();

    // this.openDialog();

  }



  addSpace(a, rate, count, name) {
    console.log(a, rate, count, name)
    let obj = {
      rate: rate,
      count: count,
      name: name,
      // id: id,


    }
    this.selectedSpaces.push(obj)
    sessionStorage.setItem('selectedSpaces', JSON.stringify(this.selectedSpaces));
  }
  book() {


    console.log(this.selectedSpaces)

  }

  public num1: number;
  public num2: number;
  public result: number;


  // calc() {


  //   this.result = this.num1 * this.num2;
   


  //   this.addCost.push(this.result);

  //   console.log(this.addCost);
  // }

  sum() {
    this.total = this.addCost.reduce((acc = 0, curVal) => {
      return acc = acc + curVal;
    })

    console.log(this.total, "This is the Total")
    console.log(this.total);

    // this.addCost.push(total);
  }




  getModal(): any {
    this.name = sessionStorage.getItem("spaceName")
    console.log("getting space name")
    console.log(this.name)
    this.spaceService.getSpaceDetails(this.name).subscribe(data => {
      console.log(data);
      this.arrayOfData = data;
      this.arrayOfCategories = this.arrayOfData.category
      console.log(this.arrayOfCategories);

    })
  }


  pushthisthing(thisthing) {
    console.log(thisthing, "sdfhskjdfhskjhfdkshfdkjsh")
    this.selectedThing = thisthing;
  }

  openDialog(): void {
    this.dialogRef = this.dialog.open(BookModalComponent, {
      width: '800px',
    });


  }

  bookSpace(value): any {
    console.log(this.selectedSpaces);
    console.log(this.total);

    let bookingSpace = {
      spaceId: this.arrayOfData.spaceId,
      spaceName: this.arrayOfData.spaceName,
      locationName: this.arrayOfData.location.locationName,
      price: this.total,
      myCategory: this.selectedThing,
    }
    this.spaceService.saveBookingDetails(bookingSpace).subscribe();

    // sessionStorage.setItem('total', value);

  }

  myStartDate() {
    console.log(this.myVar1);
    sessionStorage.setItem('startDate', JSON.stringify(this.myVar1));
  }

  myEndDate() {
    console.log(this.myVar2);
    sessionStorage.setItem('endDate', JSON.stringify(this.myVar2));

  }
  totalRate() {
    this.selectedSpaces = this.selectedSpaces.map(e => {
      console.log(typeof e.rate, typeof e.count)
      e.total = parseInt(e.count) * parseInt(e.rate)
      console.log(e)
      this.addCost.push(e.total);
      console.log(this.addCost)
      return e;
      
    })
  }
}


